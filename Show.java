import java.sql.*;
import java.util.Scanner;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

class Show extends JFrame{   
    JTable personTable;
    
    Show(){
        Object[] columns = {"NAME", "PHONE", "EMAIL"};
        Object[][] data = new Object[50][30];
		personTable = new JTable(data, columns);
        JScrollPane pnl = new JScrollPane(personTable);
        		
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/persondb", "root", "");
            Statement stmt = con.createStatement();
                                    
            String query = "SELECT name, phone, email FROM person";           
            ResultSet rs = stmt.executeQuery(query);             
            
            for(int i=0;rs.next();++i){
                data[i][0] = rs.getString("name");
                data[i][1] = rs.getString("phone");
                data[i][2] = rs.getString("email");
            }
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Some Error Occured");
        }
		
		this.getContentPane().add(pnl);
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        this.setSize(300, 300);
        this.setVisible(true);        
    }
}
