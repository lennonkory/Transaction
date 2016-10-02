package com.kcomp.Transaction.service;

import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kcomp.Transaction.dao.PersonDAO;
import com.kcomp.Transaction.model.Person;
 
 
@Service("personService")
@Transactional
public class PersonServiceImpl implements PersonService {
 
    @Autowired
    private PersonDAO dao;
     
    public Person findById(int id) {
        return dao.findById(id);
    }
 
    public void savePerson(Person Person) {
        dao.savePerson(Person);
    }
 
    /*
     * Since the method is running with Transaction, No need to call hibernate update explicitly.
     * Just fetch the entity from db and update it with proper values within transaction.
     * It will be updated in db once transaction ends. 
     */
    public void updatePerson(Person person) {
        Person entity = dao.findById(person.getId());
        if(entity!=null){
            entity.setName(person.getName());
            entity.setJoiningDate(person.getJoiningDate());
            entity.setSalary(person.getSalary());
            entity.setSsn(person.getSsn());
        }
    }
 
    public void deletePersonBySsn(String ssn) {
        dao.deletePersonBySsn(ssn);
    }
     
    public List<Person> findAllPersons() {
        return dao.findAllPersons();
    }
 
    public Person findPersonBySsn(String ssn) {
        return dao.findPersonBySsn(ssn);
    }
 
    public boolean isPersonSsnUnique(Integer id, String ssn) {
        Person Person = findPersonBySsn(ssn);
        return ( Person == null || ((id != null) && (Person.getId() == id)));
    }
     
}