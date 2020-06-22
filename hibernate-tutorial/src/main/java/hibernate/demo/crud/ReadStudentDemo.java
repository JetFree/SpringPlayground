package hibernate.demo.crud;

import hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadStudentDemo {

    public static void main(String[] args) {

        //        Create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate_student.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
//        Create a session
        Session session = factory.getCurrentSession();

        try {
            Student student = new Student("Guf", "Dog", "test@mail.ru");
//            Start transaction
            session.beginTransaction();
//            Save the object
            session.save(student);
            System.out.println(student);
//            commit transaction
            session.getTransaction().commit();

//            NEW CODE
//            Finding the primary key
            System.out.println("Save student. Generated id: " + student.getId());
            session = factory.getCurrentSession();
            session.beginTransaction();

            Student retrievedStudent = session.get(Student.class, student.getId());
            System.out.println(retrievedStudent);
            session.getTransaction().commit();
            System.out.println("Done!");
        } finally {
            factory.close();
        }
    }
}
