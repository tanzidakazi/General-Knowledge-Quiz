/**
 * Created by tanzida on 9/1/2016.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

class Connectwitdb{
    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz", "root", "");
            return con;

        } catch (Exception ex) {
            return null;
        }
    }
}

//DBSample.getConnection();