package hibernate.mappings.manytomany;

import hibernate.demo.entity.Student;
import hibernate.mappings.manytomany.entity.Course;
import hibernate.mappings.manytomany.entity.Instructor;
import hibernate.mappings.manytomany.entity.InstructorDetail;
import hibernate.mappings.onetomanyuni.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ManyToManyDemo {

    public static void main(String[] args) {
        //        Create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate_many_to_many.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .buildSessionFactory();
//        Create a session
        Session session = factory.getCurrentSession();
        try {
            session.beginTransaction();
            Instructor tempInstructor = new Instructor("Jet", "Free", "jetfree@hackit.by");
            InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.hackIT.by/youtube", "Coding");
            session.save(tempInstructor);

            tempInstructor.setInstructorDetail(tempInstructorDetail);
            Course tempCourse = new Course("Arduino for beginners");
            tempCourse.setInstructor(tempInstructor);

            session.save(tempCourse);

            Student firstStudent = new Student("Mary", "Jain", "Mary.Jain@gmail.com");
            Student secondStudent = new Student("Peter", "Parker", "Peter.Parker@gmail.com");
            tempCourse.addStudent(firstStudent);
            tempCourse.addStudent(secondStudent);

            session.save(firstStudent);
            session.save(secondStudent);

            session.getTransaction().commit();
        }
        finally {
            factory.close();
        }

    }
}
