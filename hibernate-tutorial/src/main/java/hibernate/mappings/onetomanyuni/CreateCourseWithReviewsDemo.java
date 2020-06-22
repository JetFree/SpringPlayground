package hibernate.mappings.onetomanyuni;



import hibernate.mappings.onetomanyuni.entity.Course;
import hibernate.mappings.onetomanyuni.entity.Instructor;
import hibernate.mappings.onetomanyuni.entity.InstructorDetail;
import hibernate.mappings.onetomanyuni.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseWithReviewsDemo {

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
            Course tempCourse = new Course("Java Spring Course");
            Review firstReview = new Review("Great course! I liked it very much");
            Review secondReview = new Review("I didn't understand anything. Looks like it is not for beginners.");
            tempCourse.addReview(firstReview);
            tempCourse.addReview(secondReview);
            session.save(tempCourse);
            session.getTransaction().commit();
        }
        finally {
            session.close();
            factory.close();
        }

    }
}
