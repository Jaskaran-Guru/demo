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

            Student student = new Student("John ", "john@example.com");  // change value
            Student student1 =  new Student("Harshit" , "harshit@example.com"); // insert multiple values  using  different objects

            // save them
            session.save(student);

            session.save(student1);

            // access the values

            Student s = session.get(Student.class, 6);
            System.out.println(student1.getName() + " "  +  student1.getEmail());

            student1.setName("Harshit Saddi" );

            session.remove(student);






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
