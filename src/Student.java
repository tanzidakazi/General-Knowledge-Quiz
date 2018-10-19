import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class Student extends JFrame {
    static String studentname, passcode;
    JLabel studentnamelb;
    JTextField stnametf;
    JLabel passcodelb;
    JTextField passcodetf;

    JButton startquizbt;
    JButton exitbt;

    Student() {
        studentnamelb= new JLabel();
        studentnamelb.setText("Student Name");
        studentnamelb.setBounds(100, 100, 300, 50);
        studentnamelb.setForeground(Color.BLUE);
        studentnamelb.setFont(new Font("Arial", Font.BOLD, 22));
        this.add(studentnamelb);

        stnametf= new JTextField(50);
        stnametf.setBounds(100,160, 300,50);
        stnametf.setFont(new Font("Arial", Font.BOLD, 18));
        this.add(stnametf);

        passcodelb= new JLabel();
        passcodelb.setText("Roll");
        passcodelb.setBounds(100, 210, 300, 50);
        passcodelb.setForeground(Color.BLUE);
        passcodelb.setFont(new Font("Arial", Font.BOLD, 22));
        this.add(passcodelb);

        passcodetf= new JTextField();
        passcodetf.setBounds(100,270, 300,50);
        passcodetf.setFont(new Font("Arial", Font.BOLD, 18));
        this.add(passcodetf);

        startquizbt= new JButton();
        startquizbt.setText("Start Quiz");
        startquizbt.setBounds(100,350, 200,50);
        startquizbt.setFont(new Font("Arial", Font.BOLD, 18));
        startquizbt.setForeground(Color.BLUE);
        startquizbt.setBackground(Color.PINK);
        this.add(startquizbt);

        startquizbt.addActionListener(e-> {
                if (Database.studentlogin(stnametf.getText(),passcodetf.getText())==true) {
                    studentname=stnametf.getText();
                    passcode=passcodetf.getText();
                    new Quiz();
                    this.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(this, "Wrong username or passcode");
                }

            });

        exitbt= new JButton();
        exitbt.setText("Back");
        exitbt.setBounds(100,450, 200,50);
        exitbt.setFont(new Font("Arial", Font.BOLD, 18));
        exitbt.setForeground(Color.BLUE);
        exitbt.setBackground(Color.PINK);
        this.add(exitbt);
        exitbt.addActionListener(e->{
            new FirstPage();
            this.setVisible(false);
        });

        this.setSize(600,600);
        this.setLayout(null);
        this.setVisible(true);
    }
    public static void main(String[] args){
        new Student();
    }
}
