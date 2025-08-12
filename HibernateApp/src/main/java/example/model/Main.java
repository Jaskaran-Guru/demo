package example.model;

import example.model.Student;
import example.model.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();

            Student student = new Student("John ", "john@example.com");
            Student student1 =  new Student("Harshit" , "harshit@example.com");
            session.save(student);
            session.save(student1);

            tx.commit();
            System.out.println("Student saved successfully!");

        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
