package hello;

import java.sql.*;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }

    @RequestMapping("/testmysql")
    public Enseignant testerMySql() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecole", "root", "Le24ClemiE!");
        Statement stmt = conn.createStatement();
        try (ResultSet rs = stmt.executeQuery("select idenseignant, prenom, nom from enseignants where nom = 'Masson'")) {
            rs.first();
            //position result to first
            return(new Enseignant(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3)));
        }
        /*catch (SQLException sqle) {
            
        }*/
    }
}