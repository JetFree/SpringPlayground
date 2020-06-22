package hibernate.demo.crud;

import hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteStudentDemo {

    public static void main(String[] args) {
        //        Create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate_student.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
//        Create a session
        Session session = factory.getCurrentSession();

        try {
//            Start transaction
            session.beginTransaction();
            int studentId = 7;
            System.out.println("\n Getting student with id: " + studentId);
            Student myStudent = session.get(Student.class, studentId);
            System.out.println("\n Deleting student with id: " + studentId);
            session.delete(myStudent);
            session.getTransaction().commit();

//            alternate approach
            session.createQuery("delete from Student where id = 8").executeUpdate();
            session.getTransaction().commit();
            System.out.println("Done!");
        } finally {
            factory.close();
        }
    }
}
