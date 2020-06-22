package hibernate.demo.crud;

import hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyDemo {


    public static void main(String[] args) {
        //        Create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate_student.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
//        Create a session
        Session session = factory.getCurrentSession();

        try {
            Student student = new Student("Paul", "Free", "test1@mail.ru");
            Student student1 = new Student("Max", "Loly", "test2@mail.ru");
            Student student2 = new Student("Alena", "Apobolm", "test3@mail.ru");
            Student student3 = new Student("Eugene", "Roy", "test4@mail.ru");
//            Start transaction
            session.beginTransaction();
//            Save the object
            session.save(student);
            session.save(student1);
            session.save(student2);
            session.save(student3);
//            commit transaction
            session.getTransaction().commit();
            System.out.println("Done!");
        } finally {
            factory.close();
        }
    }
}
