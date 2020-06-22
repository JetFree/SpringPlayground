package hibernate.mappings.onetooneuni;

import hibernate.mappings.onetooneuni.entity.Instructor;
import hibernate.mappings.onetooneuni.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OneToOneUniDemo {

    public static void main(String[] args) {
        //        Create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate_one_to_one_uni.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();
//        Create a session
        Session session = factory.getCurrentSession();
        try {
            Instructor tempInstructor = new Instructor("Jet", "Free", "jetfree@hackit.by");
            InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.hackIT.by/youtube", "Coding");
            tempInstructor.setInstructorDetail(tempInstructorDetail);

            session.beginTransaction();
//            Note: this will also save the details object
//            because of CascadeType.ALL
            session.save(tempInstructor);
            System.out.println("Saving instructor: " + tempInstructor);
            session.getTransaction().commit();
        }
        finally {
            factory.close();
        }

    }
}
