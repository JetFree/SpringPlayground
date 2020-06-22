package hibernate.demo.crud;

import hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateStudentDemo {

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
            System.out.println("\n Updating student ...");
            myStudent.setFirstName("Scooby");
            session.getTransaction().commit();

//            NEW CODE
            session = factory.getCurrentSession();
            session.beginTransaction();
//            Update email for all students
            System.out.println("Update email for all students");
            session.createQuery("update Student set email='foo@gmail.com'").executeUpdate();

            session.getTransaction().commit();
        } finally {
            factory.close();
        }
    }
}
