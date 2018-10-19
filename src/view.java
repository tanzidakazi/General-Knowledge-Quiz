import java.sql.*;
import java.util.Scanner;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

class view extends JFrame{
    JTable viewtable ;

    view(){
        Object[] columns = {"Question", "Option1", "Option2","Option3"};
        Object[][] data = new Object[50][30];
        viewtable = new JTable(data, columns);
        JScrollPane p = new JScrollPane(viewtable);

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz", "root", "");
            Statement stmt = con.createStatement();

            String query = "SELECT * FROM `table 1`";
            ResultSet rs = stmt.executeQuery(query);

            for(int i=0;rs.next();++i){
                data[i][0] = rs.getString("Question");
                data[i][1] = rs.getString("Option1");
                data[i][2] = rs.getString("Option2");
                data[i][3] = rs.getString("Option3");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error");
        }

        this.getContentPane().add(p);
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        this.setSize(600, 600);
        this.setVisible(true);
    }
}
