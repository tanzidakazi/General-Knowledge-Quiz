/**
 * Created by tanzida on 9/2/2016.
 */
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class Teacher extends JFrame {
        JLabel teachernamelb;
        JLabel passcodelb;
        JTextField tnametf;
        JTextField passcodetf;
        JButton donebt;
        static String teachername, passcode;

        Teacher() {
            teachernamelb= new JLabel();
            teachernamelb.setText("Teacher Name");
            teachernamelb.setBounds(100, 70, 300, 50);
            teachernamelb.setForeground(Color.BLUE);
            teachernamelb.setFont(new Font("Arial", Font.BOLD, 22));
            this.add(teachernamelb);

            tnametf= new JTextField();
            tnametf.setBounds(100,120, 300,50);
            tnametf.setFont(new Font("Arial", Font.BOLD, 18));
            this.add(tnametf);

            passcodelb= new JLabel();
            passcodelb.setText("Passcode");
            passcodelb.setBounds(100, 190, 300, 50);
            passcodelb.setForeground(Color.BLUE);
            passcodelb.setFont(new Font("Arial", Font.BOLD, 22));
            this.add(passcodelb);

            passcodetf= new JTextField();
            passcodetf.setBounds(100,240, 300,50);
            passcodetf.setFont(new Font("Arial", Font.BOLD, 18));
            this.add(passcodetf);

            donebt= new JButton();
            donebt.setText("Done");
            donebt.setBounds(100,350, 100,50);
            donebt.setFont(new Font("Arial", Font.BOLD, 18));
            donebt.setForeground(Color.BLUE);
            donebt.setBackground(Color.PINK);
            this.add(donebt);

            donebt.addActionListener(e-> {
                if (Database.teacherlogin(tnametf.getText(),passcodetf.getText())==true) {
                    teachername=tnametf.getText();
                    passcode=passcodetf.getText();
                    new Modify();
                    this.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(this, "Wrong username or passcode");
                }

            });

            this.setSize(600,600);
            this.setLayout(null);
            this.setVisible(true);
        }
        public static void main(String[] args){
            new Teacher();
        }
    }

