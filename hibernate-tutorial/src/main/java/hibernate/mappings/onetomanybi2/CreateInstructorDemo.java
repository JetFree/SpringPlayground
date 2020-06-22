package hibernate.mappings.onetomanybi2;


import hibernate.mappings.onetomanybi2.entity.Course;
import hibernate.mappings.onetomanybi2.entity.Instructor;
import hibernate.mappings.onetomanybi2.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateInstructorDemo {

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
            Instructor tempInstructor = new Instructor("Susan", "Public", "susan.public@luv2code.com");
            InstructorDetail tempInstructorDetail = new InstructorDetail("http://youtube.com/gaming", "Video Games");
            tempInstructor.setInstructorDetail(tempInstructorDetail);
            session.save(tempInstructor);
            session.getTransaction().commit();
        }
        finally {
            session.close();
            factory.close();
        }

    }
}
