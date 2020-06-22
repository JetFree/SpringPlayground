package hibernate.mappings.onetomanyuni;



import hibernate.mappings.onetomanyuni.entity.Course;
import hibernate.mappings.onetomanyuni.entity.Instructor;
import hibernate.mappings.onetomanyuni.entity.InstructorDetail;
import hibernate.mappings.onetomanyuni.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetCourseAndReviewsDemo {

    public static void main(String[] args) {
        //        Create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate_one_to_many_uni.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .buildSessionFactory();
//        Create a session
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        try {
            int id = 10;
            Course tempCourse = session.get(Course.class, id);
            if (tempCourse != null) {
                System.out.println(tempCourse);
                System.out.println(tempCourse.getReviews());
            }
            session.getTransaction().commit();
        }
        finally {
            session.close();
            factory.close();
        }

    }
}
