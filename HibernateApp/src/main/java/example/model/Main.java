package example.model;

import example.model.Student;
import example.model.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import  org.hibernate.cfg.Configuration;
import org.hibernate.query.Query; // Hibernate 5.2+



public class Main {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();

            Student student = new Student("John ", "john@example.com");  // change value
            Student student1 = new Student("Harshit", "harshit@example.com"); // insert multiple values  using  different objects

            Student student2 = new Student("C", "CC@example.com");


            String hql = "FROM Student WHERE name = :name";
            Query<Student> q = session.createQuery(hql, Student.class);
            q.setParameter("name", "Harshit Saddi");

            Student student3 = q.uniqueResultOptional().orElse(null);
            System.out.println(student);




            if (student != null) {
                session.save(student);
            } else {
                System.out.println("No student found with that name");
            }






            // save them
//

            session.save(student1);

            session.save(student2);

            // access the values

            Student s = session.get(Student.class, 6);
            System.out.println(student1.getName() + " "  +  student1.getEmail());

            student1.setName("Harshit Saddi" );








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
