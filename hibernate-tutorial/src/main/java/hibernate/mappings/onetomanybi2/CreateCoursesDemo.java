package hibernate.mappings.onetomanybi2;


import hibernate.mappings.onetomanybi2.entity.Course;
import hibernate.mappings.onetomanybi2.entity.Instructor;
import hibernate.mappings.onetomanybi2.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCoursesDemo {

    public static void main(String[] args) {
        //        Create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate_one_to_many_bi.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();
//        Create a session
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        try {

            int id = 1;
            Instructor tempInstructor = session.get(Instructor.class, id);
            Course tempCourse1 = new Course("Air Guitar - The Ultimate Guide");
            Course tempCourse2 = new Course("The Pinball Masterclass");
            tempInstructor.addCourse(tempCourse1);
            tempInstructor.addCourse(tempCourse2);
            session.save(tempCourse1);
            session.save(tempCourse2);
            session.getTransaction().commit();
//            We don't save the instructor!
        }
        finally {
            session.close();
            factory.close();
        }

    }
}
