package dturcan;

import dturcan.Hibernate.Persons;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Date;
import java.util.Iterator;

/**
 * Created by dturcan on 9/28/2016.
 */
public class ManagePersons {

    private static SessionFactory factory;

    public static void main(String[] args) throws Exception {

        factory = new Configuration().configure().buildSessionFactory();

        ManagePersons managePersons = new ManagePersons();

        managePersons.listPersons();
    }


    public void listPersons() throws Exception{

        Session session = factory.openSession();

        Transaction transaction = null;

        transaction = session.beginTransaction();

        List persons = session.createQuery("from Persons").list();

        for (Iterator i = persons.iterator(); i.hasNext();){

            Persons person = (Persons) i.next();
            System.err.print("First Name: ");
            System.out.println(person.getFirstname());
            System.err.print("Last Name: ");
            System.out.println(person.getLastname());
            System.err.print("Address: ");
            System.out.println(person.getAddress());
            System.err.print("City: ");
            System.out.println(person.getCity());
        }

    }

}
