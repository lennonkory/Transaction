package com.kcomp.Transaction.service;

import java.util.List;
import com.kcomp.Transaction.model.Person;
 
 
public interface PersonService {
 
    Person findById(int id);
     
    void savePerson(Person person);
     
    void updatePerson(Person person);
     
    void deletePersonBySsn(String ssn);
 
    List<Person> findAllPersons(); 
     
    Person findPersonBySsn(String ssn);
 
    boolean isPersonSsnUnique(Integer id, String ssn);
     
}