package hibernate.demo.crud;

import hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateStudentDemo {

    public static void main(String[] args) {
//        Create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate_student.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
//        Create a session
        Session session = factory.getCurrentSession();

        try {
            Student student = new Student("Paul", "Free", "test@mail.ru");
//            Start transaction
            session.beginTransaction();
//            Save the object
            session.save(student);
//            commit transaction
            session.getTransaction().commit();
            System.out.println("Done!");
        } finally {
            factory.close();
        }
    }
}
