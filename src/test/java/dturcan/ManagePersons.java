package dturcan;

import dturcan.Hibernate.Persons;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Iterator;

public class ManagePersons {

    private static SessionFactory factory;



    public static void main(String[] args) throws Exception {

        factory = new Configuration().configure().buildSessionFactory();

        Persons person = new Persons("Turcan","Dumitru", "Chisinau", "Adresa");

        ManagePersons managePersons = new ManagePersons();

        System.out.println("Adding a person");

        //managePersons.addPerson(person);

        managePersons.listPersons();

        System.out.println("Deleting a person");

        managePersons.deletePerson(24);

        managePersons.listPersons();

        factory.close();

    }


    public void listPersons() throws Exception{

        Session session = factory.openSession();

        Transaction transaction = null;

        transaction = session.beginTransaction();

        List persons = session.createQuery("from Persons").list();

        for (Iterator i = persons.iterator(); i.hasNext();){

            Persons person = (Persons) i.next();

            System.out.println("Person ID("+person.getPersonid()+")");

            System.out.println("First Name: "+ person.getFirstname());

            System.out.println("Last Name: "+person.getLastname());

            System.out.println("Address: "+person.getAddress());

            System.out.println("City: "+ person.getCity());

            System.out.println("---------------------------------------------");
        }

        session.close();

    }

    public void addPerson(Persons person) throws Exception{

        Integer id = null;

        Session session = factory.openSession();

        Transaction transaction = null;

        transaction = session.beginTransaction();

        id = (Integer) session.save(person);

        System.out.println("Added user with ID ("+id+")");

        transaction.commit();

        session.close();
    }

    public void deletePerson(Integer person){

        Session session = factory.openSession();

        Transaction transaction=null;

        transaction = session.beginTransaction();

        Persons persons = (Persons) session.get(Persons.class, person);

        session.delete(persons);

        transaction.commit();

    }

}
