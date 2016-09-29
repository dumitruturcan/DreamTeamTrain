package oclungu.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Iterator;
import java.util.List;

public class ManagePersons {

    private static SessionFactory factory;

    public static void main(String[] args) throws Exception {

        factory = new Configuration().configure().buildSessionFactory();

        ManagePersons managePersons = new ManagePersons();

      /* Add few employee records in database */
        //Integer person1 = managePersons.addPerson("LastNameTest1", "FirstNameTest1", "AddressTest1", "CityTest1");
        //Integer person2 = managePersons.addPerson("LastNameTest2", "FirstNameTest2", "AddressTest2", "CityTest2");

      /* List down all the employees */
        //managePersons.getPersonsList();

      /* Update employee's records */
        //managePersons.updateEmployee(empID1, 5000);

      /* Delete an employee from the database */
        //managePersons.deletePerson(22);

      /* List down new list of the employees */
        managePersons.getPersonsList();

        factory.close();

    }

    public Integer addPerson(String lastName, String firstName, String address, String city) {

        Session session = factory.openSession();
        Transaction transaction = null;
        Integer personId = null;

        try {

            transaction = session.beginTransaction();
            Persons persons = new Persons(lastName, firstName, address, city);
            personId = (Integer) session.save(persons);
            transaction.commit();

        } catch (HibernateException e) {

            if (transaction != null) transaction.rollback();
            e.printStackTrace();

        } finally {

            session.close();

        }

        return personId;

    }

    /* Method to  READ all the employees */
    public void getPersonsList() {

        Session session = factory.openSession();
        Transaction transaction = null;

        try {

            transaction = session.beginTransaction();
            List persons = session.createQuery("from Persons").list();

            for (Iterator iterator = persons.iterator(); iterator.hasNext(); ) {

                Persons person = (Persons) iterator.next();
                System.out.println("Last Name: " + person.getLastName() +
                        "\tFirst Name: " + person.getFirstName() +
                        "\tAddress: " + person.getAddress() +
                        "\tCity: " + person.getCity());

            }

            transaction.commit();

        } catch (HibernateException e) {

            if (transaction != null) transaction.rollback();
            e.printStackTrace();

        } finally {

            session.close();

        }

    }

    /* Method to UPDATE salary for an employee */
    public void updatePersonCity(Integer personId, String city) {

        Session session = factory.openSession();
        Transaction transaction = null;

        try {

            transaction = session.beginTransaction();
            Persons persons = (Persons) session.get(Persons.class, personId);
            persons.setCity(city);
            session.update(persons);
            transaction.commit();

        } catch (HibernateException e) {

            if (transaction != null) transaction.rollback();
            e.printStackTrace();

        } finally {

            session.close();

        }

    }

    /* Method to DELETE an employee from the records */
    public void deletePerson(Integer personId) {

        Session session = factory.openSession();
        Transaction transaction = null;

        try {

            transaction = session.beginTransaction();
            Persons persons = (Persons) session.get(Persons.class, personId);
            session.delete(persons);
            transaction.commit();

        } catch (HibernateException e) {

            if (transaction != null) transaction.rollback();
            e.printStackTrace();

        } finally {

            session.close();

        }

    }

}
