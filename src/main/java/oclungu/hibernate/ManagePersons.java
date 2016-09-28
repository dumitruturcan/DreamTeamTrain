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

    public static void main(String[] args) {

        try {

            factory = new Configuration().configure().buildSessionFactory();

        } catch (Throwable throwable) {

            System.err.println("Failed to create sessionFactory object." + throwable);
            throw new ExceptionInInitializerError(throwable);

        }

        ManagePersons managePersons = new ManagePersons();

      /* Add few employee records in database */
        //Integer empID1 = managePersons.addPerson("Zara", "Ali", 1000);

      /* List down all the employees */
        managePersons.getPersonsList();

      /* Update employee's records */
        //managePersons.updateEmployee(empID1, 5000);

      /* Delete an employee from the database */
        //managePersons.deletePerson(empID2);

      /* List down new list of the employees */
        // managePersons.getPersonsList();

    }

    public Integer addPerson(String lastName, String firstName, String address, String city) {

        Session session = factory.openSession();
        Transaction transaction = null;
        Integer personId = null;

        try {

            transaction = session.beginTransaction();
            Person person = new Person(lastName, firstName, address, city);
            personId = (Integer) session.save(person);
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
            List persons = session.createQuery("FROM Persons").list();

            for (Iterator iterator = persons.iterator(); iterator.hasNext(); ) {

                Employee employee = (Employee) iterator.next();
                System.out.println("Last Name: " + employee.getLastName() + "\tFirst Name: " + employee.getFirstName() +
                        "\tAddress: " + employee.getAddress() + "\tCity: " + employee.getCity());

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
            Employee employee = (Employee) session.get(Employee.class, personId);
            employee.setCity(city);
            session.update(employee);
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
            Employee employee = (Employee) session.get(Employee.class, personId);
            session.delete(employee);
            transaction.commit();

        } catch (HibernateException e) {

            if (transaction != null) transaction.rollback();
            e.printStackTrace();

        } finally {

            session.close();

        }

    }

}
