package com.kcomp.Transaction.Transaction;

import java.math.BigDecimal;
import java.util.List;

import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.kcomp.Transaction.config.HibernateConfig;
import com.kcomp.Transaction.model.Person;
import com.kcomp.Transaction.service.PersonService;;

/**
 * Hello world!
 *
 */
public class App 
{
	
    public static void main( String[] args )
    {
    	ApplicationContext context = 
                new AnnotationConfigApplicationContext(HibernateConfig.class);
    	
    	
    	
    	PersonService personService = context.getBean(PersonService.class);
    	
    	List<Person> persons = personService.findAllPersons();
    	
    	for(Person p : persons){
    		System.out.println(p.toString());
    	}
    	
    	Person person = personService.findById(3);
    	
    	System.out.println(person.toString());
    	
    }
}
