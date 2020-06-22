import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;


@WebServlet("/TestDbServlet")
public class TestDbServlet extends HttpServlet {

    private String user = "springstudent";
    private String password = "springstudent";
    private String jdbcUrl = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false&serverTimezone=UTC";
    private String driver = "com.mysql.cj.jdbc.Driver";



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            PrintWriter out = resp.getWriter();
            out.println("Connecting to db: " + jdbcUrl);
            Class.forName(driver);
            Connection connection = DriverManager.getConnection(jdbcUrl, user, password);
            out.println("Connection successful!");
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServletException(e);
        }
    }
}