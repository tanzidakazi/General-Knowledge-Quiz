import java.sql.*;
import java.util.ArrayList;
import java.util.Objects;

public class Database {
    static boolean studentlogin(String studentname, String passcode)
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz", "root", "");
            Statement stmt = con.createStatement();
            String  query="SELECT StudentName FROM `table 3` WHERE studentname='"+studentname+"'";
            ResultSet rs = stmt.executeQuery(query);
            if(!rs.next()) return false;
            else rs=stmt.executeQuery("SELECT Passcode FROM `table 3` WHERE passcode='"+passcode+"'");
            rs.next();
            return Objects.equals(rs.getString(1), passcode);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    static boolean teacherlogin(String teachername, String passcode)
    {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz", "root", "");
            Statement stmt = con.createStatement();
            String  query3="SELECT TeacherName FROM `table 4` WHERE teachername='"+teachername+"'";
            ResultSet rs = stmt.executeQuery(query3);
            if(!rs.next()) return false;
            else rs=stmt.executeQuery("SELECT Passcode FROM `table 4` WHERE passcode='"+passcode+"'");
            rs.next();
            return Objects.equals(rs.getString(1), passcode);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    static ArrayList<String[]> getQuestions()
    {
        try {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz", "root", "");
        Statement stmt = con.createStatement();
        String  query1="SELECT * FROM `table 1`";
        ResultSet rs = stmt.executeQuery(query1);

            ArrayList<String[]> A=new ArrayList<>();

        while(rs.next())
            A.add(new String[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)});
        return A;
        } catch (Exception e) {
        e.printStackTrace();
        }
        return null;
    }

    static ArrayList<String[]> getRightAnswers()
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz", "root", "");
            Statement stmt = con.createStatement();
            String  query2="SELECT * FROM `table 2`";
            ResultSet rs = stmt.executeQuery(query2);

            ArrayList<String[]> B=new ArrayList<>();

            while(rs.next())
                B.add(new String[]{rs.getString(1),rs.getString(2)});
            return B;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
