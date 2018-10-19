import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.Objects;
import java.util.Vector;

/**
 * Created by ariful on 8/29/2016.
 */
public class DBMethod {

    Connection con=DB.getConnection();
    static void signup(String firstname,String lastname,String username,String password){
   try{

       Statement stmt = DB.getConnection().createStatement();
        String query = "INSERT INTO `account` (firstname,lastname,username,password) VALUES ('" + firstname + "','" + lastname + "','" + username + "','" + password + "')";
        //System.out.println(query);
         stmt.executeUpdate(query);

    }
   catch (SQLException e) {
       e.printStackTrace();
   }
    }
    static boolean login(String username, String password)
    {

        try {
            Statement stmt = DB.getConnection().createStatement();
            String  query1="SELECT username FROM `account` WHERE username='"+username+"'";
            ResultSet rs = stmt.executeQuery(query1);
            if(!rs.next()) return false;
            else rs=stmt.executeQuery("SELECT password FROM `account` WHERE username='"+username+"'");
            rs.next();
            //System.out.println(rs.getString(1));
            return Objects.equals(rs.getString(1), password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    static boolean security(String adpassword)
    {

        try {
            Statement stmt = DB.getConnection().createStatement();
            String  query3="SELECT password FROM `security` WHERE password='"+adpassword+"'";
            ResultSet rs = stmt.executeQuery(query3);

            if(!rs.next()) return false;
            else rs=stmt.executeQuery("SELECT password FROM `security` WHERE password='"+adpassword+"'");
            rs.next();
            System.out.println(rs.getString(1));
            return  Objects.equals(rs.getString(1), adpassword);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    static boolean adlogin(String adusername, String adpassword)
    {

        try {
            Statement stmt = DB.getConnection().createStatement();
            String  query1="SELECT username FROM `adaccount` WHERE username='"+adusername+"'";
            ResultSet rs = stmt.executeQuery(query1);
            if(!rs.next()) return false;
            else rs=stmt.executeQuery("SELECT password FROM `adaccount` WHERE username='"+adusername+"'");
            rs.next();
            //System.out.println(rs.getString(1));
            return Objects.equals(rs.getString(1), adpassword);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    static Vector<String> place()
    {

        try {
            Statement stmt = DB.getConnection().createStatement();
            String  query1="SELECT `spot name` FROM `table 1` WHERE district='"+FormTest3.district+"'";
            ResultSet rs = stmt.executeQuery(query1);
            //rs.next();
            /*String ret[]=new String[3];
            ret[0]=rs.getString(1);
            rs.next();
            ret[1]=rs.getString(1);
            rs.next();
            ret[2]=rs.getString(1);
            //return ret;*/

            Vector<String>vector=new Vector<>();
            while(rs.next()) {
                vector.add(rs.getString(1));

            }
            return vector;


        }catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    static String[] hotel(){

        try {
            Statement stmt = DB.getConnection().createStatement();
        String  query1="SELECT `Suggested Hotel` FROM `table 1` WHERE district='"+FormTest3.district+"'";
            ResultSet rs = stmt.executeQuery(query1);
            rs.next();
            String ret[]=new String[2];
            ret[0]=rs.getString(1);
            rs.next();
            String  query2="SELECT `Hotel fare` FROM `table 1` WHERE `Suggested Hotel`='"+ret[0]+"'";
            ResultSet rs2 = stmt.executeQuery(query2);
            rs2.next();
            ret[1]=rs2.getString(1);
            //System.out.println(ret[1]);
            rs2.next();
            return ret;
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return null;

    }

    static String busFare(){
        try {
            Statement stmt = DB.getConnection().createStatement();
            String query1 = "SELECT `Bus fare` FROM `table 1` WHERE `spot name`='" + FormTest4.spotname + "'";
            ResultSet rs = stmt.executeQuery(query1);
            rs.next();
            System.out.println(rs.getString(1));
            return rs.getString(1);
        }catch (Exception e){}
        return null;
    }

    static String distance(){
        try {
            Statement stmt = DB.getConnection().createStatement();
            String query1 = "SELECT `distance from dhaka` FROM `table 1` WHERE `spot name`='" + FormTest4.spotname + "'";
            ResultSet rs = stmt.executeQuery(query1);
            rs.next();
            System.out.println(rs.getString(1));
            return rs.getString(1);
        }catch (Exception e){}
        return null;
    }
}
