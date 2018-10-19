import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public class Delete extends JFrame{
    JLabel deletelabel;
    JTextField deletetf;
    JButton done2bt;
    JButton back2bt;
    static String delete;

    Delete(){
        deletelabel= new JLabel();
        deletelabel.setText("Enter Question to delete");
        deletelabel.setBounds(20,20,400,100);
        deletelabel.setFont(new Font("Arial", Font.BOLD, 16));
        this.add(deletelabel);

        deletetf= new JTextField();
        deletetf.setBounds(20,90, 500,50);
        deletetf.setFont(new Font("Arial", Font.BOLD, 14));
        this.add(deletetf);

        done2bt= new JButton();
        done2bt.setText("");
        done2bt.setText("delete");
        done2bt.setBounds(300,400, 200,50);
        done2bt.setFont(new Font("Arial", Font.BOLD, 18));
        done2bt.setForeground(Color.BLUE);
        done2bt.setBackground(Color.PINK);
        this.add(done2bt);

        back2bt= new JButton();
        back2bt.setText("Back");
        back2bt.setBounds(30,400, 200,50);
        back2bt.setFont(new Font("Arial", Font.BOLD, 18));
        back2bt.setForeground(Color.BLUE);
        back2bt.setBackground(Color.PINK);
        this.add(back2bt);

        done2bt.addActionListener(e->{
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz", "root", "");
                Statement stmt = con.createStatement();

                String Question = deletetf.getText();
                if (deletetf.getText().isEmpty()){
                    JOptionPane.showMessageDialog(this, "Missing Info");
                }
                else {
                    String query = "DELETE from `table 1` WHERE  Question = '"+Question+"'";
                    String query1 = "DELETE from `table 2` WHERE  Question = '"+Question+"'";
                    if(stmt.executeUpdate(query)==1 && stmt.executeUpdate(query1)==1){
                        JOptionPane.showMessageDialog(this, "Deleted");
                    }
                    else{
                        JOptionPane.showMessageDialog(this, "Question not found");
                    }
                }
            }
            catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error");
                ex.printStackTrace();
            }
        });

        back2bt.addActionListener(e->{
            new Modify();
            this.setVisible(false);
        });

        this.setSize(600,600);
        this.setLayout(null);
        this.setVisible(true);
    }
    public static void main(String[] args){
        new Delete();
    }
}


