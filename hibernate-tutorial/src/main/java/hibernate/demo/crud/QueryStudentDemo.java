package hibernate.demo.crud;

import hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryStudentDemo {

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

            System.out.println("Selecting all students \n");
            List<Student> theStudents = session.createQuery("from Student").getResultList();
            displayStudents(theStudents);

            System.out.println("\nSelecting students where last name = Roy \n");
            theStudents = session.createQuery("from Student s where s.lastName = 'Roy'").getResultList();
            displayStudents(theStudents);

            System.out.println("\nSelecting students where last name = Roy or first name = Max\n");
            theStudents = session.createQuery("from Student s where s.lastName = 'Roy' or s.firstName = 'Max'").getResultList();
            displayStudents(theStudents);

            System.out.println("\nSelecting students where email ends with by\n");
            theStudents = session.createQuery("from Student s where s.email LIKE '%by'").getResultList();
            displayStudents(theStudents);
            System.out.println("Done!");
        } finally {
            factory.close();
        }
    }

    public static void displayStudents(List<Student> theStudents) {
        for (Student student : theStudents) {
            System.out.println(student);
        }
    }
}
