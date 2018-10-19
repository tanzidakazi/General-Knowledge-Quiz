import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Scanner;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

class SearchResult extends JFrame{
    JTable personTable;
    
    SearchResult(){
        
        Object[] columns = {"NAME", "PHONE", "EMAIL"};
        Object[][] data = new Object[50][30];
		personTable = new JTable(data, columns);
        JScrollPane pnl = new JScrollPane(personTable);
		
		try {
            Statement stmt = DB.getConnection().createStatement();
            String  query1="SELECT name FROM person WHERE name ='"+name+"'";
            ResultSet rs = stmt.executeQuery(query1);
            rs.next();
            String ret[]=new String[3];
            ret[0]=rs.getString(1);
            rs.next();
            ret[1]=rs.getString(1);
            rs.next();
            ret[2]=rs.getString(1);
            return ret;

        }catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
		
                        
        
        
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        this.setSize(300, 300);
        this.setVisible(true);
    }
    
    public static void main(String[] args){
	    new Show();
    }
}