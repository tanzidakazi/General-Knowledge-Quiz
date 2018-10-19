import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.Objects;

public class Add extends JFrame{
    JLabel addlabel;
    JLabel option1lb;
    JLabel option2lb;
    JLabel option3lb;
    JLabel rightans;
    JTextField addqtf;
    JTextField option1tf;
    JTextField option2tf;
    JTextField option3tf;
    JTextField rightanstf;
    JButton done1bt;
    JButton back1bt;
    static String question, option1, option2, option3, rightanswer;

    Add(){
        addlabel= new JLabel();
        addlabel.setText("Add Question");
        addlabel.setBounds(20,00,400,50);
        addlabel.setFont(new Font("Arial", Font.BOLD, 14));
        this.add(addlabel);

        addqtf= new JTextField();
        addqtf.setBounds(20,50, 500,40);
        addqtf.setFont(new Font("Arial", Font.BOLD, 14));
        this.add(addqtf);

        option1lb= new JLabel();
        option1lb.setText("Option1");
        option1lb.setBounds(20,100,400,40);
        option1lb.setFont(new Font("Arial", Font.BOLD, 14));
        this.add(option1lb);

        option1tf= new JTextField();
        option1tf.setBounds(20,150, 400,40);
        option1tf.setFont(new Font("Arial", Font.BOLD, 14));
        this.add(option1tf);

        option2lb= new JLabel();
        option2lb.setText("Option2");
        option2lb.setBounds(20,200,400,40);
        option2lb.setFont(new Font("Arial", Font.BOLD, 14));
        this.add(option2lb);

        option2tf= new JTextField();
        option2tf.setBounds(20,250, 400,40);
        option2tf.setFont(new Font("Arial", Font.BOLD, 14));
        this.add(option2tf);

        option3lb= new JLabel();
        option3lb.setText("Option3");
        option3lb.setBounds(20,300,400,40);
        option3lb.setFont(new Font("Arial", Font.BOLD, 14));
        this.add(option3lb);

        option3tf= new JTextField();
        option3tf.setBounds(20,350, 400,40);
        option3tf.setFont(new Font("Arial", Font.BOLD, 14));
        this.add(option3tf);

        rightans= new JLabel();
        rightans.setText("Right Answer");
        rightans.setBounds(20,400,400,40);
        rightans.setFont(new Font("Arial", Font.BOLD, 14));
        this.add(rightans);

        rightanstf= new JTextField();
        rightanstf.setBounds(20,450, 400,40);
        rightanstf.setFont(new Font("Arial", Font.BOLD, 14));
        this.add(rightanstf);

        done1bt= new JButton();
        done1bt.setText("Add");
        done1bt.setBounds(300,550, 200,30);
        done1bt.setFont(new Font("Arial", Font.BOLD, 18));
        done1bt.setForeground(Color.BLUE);
        done1bt.setBackground(Color.PINK);
        this.add(done1bt);

        back1bt= new JButton();
        back1bt.setText("Back");
        back1bt.setBounds(20,550, 200,30);
        back1bt.setFont(new Font("Arial", Font.BOLD, 18));
        back1bt.setForeground(Color.BLUE);
        back1bt.setBackground(Color.PINK);
        this.add(back1bt);

        done1bt.addActionListener(e->{
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz", "root", "");
                Statement stmt = con.createStatement();
                 question = addqtf.getText();
                 option1 = option1tf.getText();
                 option2 = option2tf.getText();
                 option3 = option3tf.getText();
                 rightanswer = rightanstf.getText();
                if (addqtf.getText().isEmpty() || option1tf.getText().isEmpty() || option2tf.getText().isEmpty() || option3tf.getText().isEmpty()){
                    JOptionPane.showMessageDialog(this, "Missing Info");
                }
                else {
                    String query = "INSERT INTO `table 1` VALUES ('"+question+"', '"+option1+"','"+option2+"', '"+option3+"')";
                    String query1 = "INSERT INTO `table 2`  VALUES ('"+question+"', '"+rightanswer+"')";
                    if(stmt.executeUpdate(query)==1 && stmt.executeUpdate(query1)==1){
                        JOptionPane.showMessageDialog(this, "Question Added");
                    }
                    else{
                        JOptionPane.showMessageDialog(this, "Question not added");
                    }
                }
            }
            catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error");
                ex.printStackTrace();
            }
        });


        back1bt.addActionListener(e->{
            new Modify();
            this.setVisible(false);
        });


        this.setSize(700,700);
        this.setLayout(null);
        this.setVisible(true);

    }
    public static void main(String[] args){
        new Add();
    }
}

