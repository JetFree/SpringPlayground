package hibernate.demo.crud;

import hibernate.demo.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class HomeWorkHibernateDemo {

    private static Session currentSession;
    private static SessionFactory sessionFactory;

    public static void main(String[] args) {
        sessionFactory = new Configuration()
                .configure("hibernate_employee.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        List<Employee> employeeList = Arrays.asList(
                new Employee("John", "Kazino", "JoyCasino"),
                new Employee("Kaput", "Denis", "NelMarket"),
                new Employee("Ivanov", "Kostia", "IFix"),
                new Employee("Korzh", "Eugene", "PartyGroup")
        );
//        for (Employee employee : employeeList) {
//            saveEmployee(employee);
//        }

        currentSession = sessionFactory.getCurrentSession();
        currentSession.beginTransaction();
        Employee employee = getEmployeeById(3);
        employee.setCompany("iTechArt");
        currentSession.getTransaction().commit();

        List<Employee> retrievedEmployeeList = getStudentsByCompanyName("JoyCasino");
        for (Employee employee1 : retrievedEmployeeList) {
            System.out.println(employee1);
        }

        deleteEmployee(3);
        sessionFactory.close();
    }

    public static void saveEmployee(Employee employee) {
        currentSession = sessionFactory.getCurrentSession();
        if (!currentSession.getTransaction().isActive()) {
            currentSession.beginTransaction();
        }
        currentSession.save(employee);
        currentSession.getTransaction().commit();
    }

    public static Employee getEmployeeById(int id) {
        return currentSession.get(Employee.class, id);
    }

    public static List<Employee> getStudentsByCompanyName(String companyName) {
        currentSession = sessionFactory.getCurrentSession();
        if (!currentSession.getTransaction().isActive()) {
            currentSession.beginTransaction();
        }
        List<Employee> employeeList = currentSession.createQuery("from Employee s where s.company = " +
                        "'" + companyName + "'", Employee.class).getResultList();
        return employeeList;
    }

    public static void deleteEmployee(int i) {
        currentSession = sessionFactory.getCurrentSession();
        if (!currentSession.getTransaction().isActive()) {
            currentSession.beginTransaction();
        }
        currentSession.createQuery("delete from Employee where id = " + i + "").executeUpdate();
        currentSession.getTransaction().commit();
    }

}
