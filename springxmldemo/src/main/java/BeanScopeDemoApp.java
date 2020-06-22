import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanscope-applicationContext.xml");

        Coach theCoach = context.getBean("myCoach", Coach.class);
        Coach theSecondCoach = context.getBean("myCoach", Coach.class);

        boolean result = (theCoach == theSecondCoach);
        System.out.println("Pointing to the same object " + result);
        System.out.println("Memory location for the theCoach: " + theCoach);
        System.out.println("Memory location for the theSecondCoach: " + theSecondCoach);

        context.close();

    }
}
