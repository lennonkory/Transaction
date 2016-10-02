package com.kcomp.Transaction.dao;

import java.util.List;
import com.kcomp.Transaction.model.Person;

public interface PersonDAO {
 
    Person findById(int id);
 
    void savePerson(Person person);
     
    void deletePersonBySsn(String ssn);
     
    List<Person> findAllPersons();
 
    Person findPersonBySsn(String ssn);
 
}