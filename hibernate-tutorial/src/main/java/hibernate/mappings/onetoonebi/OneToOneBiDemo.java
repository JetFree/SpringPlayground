package hibernate.mappings.onetoonebi;


import hibernate.mappings.onetoonebi.entity.Instructor;
import hibernate.mappings.onetoonebi.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OneToOneBiDemo {

    public static void main(String[] args) {
        //        Create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate_one_to_one_uni.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();
//        Create a session
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        try {
            int id = 1;
            InstructorDetail instructorDetail = session.get(InstructorDetail.class, id);
            if (instructorDetail != null) {
                System.out.println("Instructor details: " + instructorDetail);
                System.out.println("Instructor: " + instructorDetail.getInstructor());
            }

            session.getTransaction().commit();
        }
        finally {
            session.close();
            factory.close();
        }

    }
}
