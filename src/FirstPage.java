import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
public class FirstPage extends JFrame{
    JLabel quizprogram1abel;
    JLabel selectlabel;
    JRadioButton studentradiobutton;
    JRadioButton teacherradiobutton;
    JButton nextbutton;
    ButtonGroup bg;

    FirstPage(){

        quizprogram1abel= new JLabel();
        quizprogram1abel.setText("QUIZ PROGRAM");
        quizprogram1abel.setBounds(150,50,400,100);
        quizprogram1abel.setForeground(Color.RED);
        quizprogram1abel.setFont(new Font("Arial", Font.BOLD, 26));
        this.add(quizprogram1abel);

        selectlabel= new JLabel();
        selectlabel.setText("Select");
        selectlabel.setBounds(110,150,200,60);
        selectlabel.setForeground(Color.BLUE);
        selectlabel.setFont(new Font("Arial", Font.BOLD, 22));
        this.add(selectlabel);

        studentradiobutton = new JRadioButton();
        studentradiobutton.setText("Student");
        studentradiobutton.setBounds(100,220,200,60);
        studentradiobutton.setFont(new Font("Arial", Font.BOLD, 18));
        this.add(studentradiobutton);

        teacherradiobutton = new JRadioButton();
        teacherradiobutton.setText("Teacher");
        teacherradiobutton.setBounds(100,290,200,60);
        teacherradiobutton.setFont(new Font("Arial", Font.BOLD, 18));
        this.add(teacherradiobutton);

        nextbutton= new JButton();
        nextbutton.setText("Next");
        nextbutton.setBounds(100,400, 200,60);
        nextbutton.setFont(new Font("Arial", Font.BOLD, 18));
        nextbutton.setForeground(Color.BLUE);
        nextbutton.setBackground(Color.PINK);
        this.add(nextbutton);

        nextbutton.addActionListener(e->{
            if(studentradiobutton.isSelected()){
                new Student();
                this.setVisible(false);
            }
            else if(teacherradiobutton.isSelected()){
                new Teacher();
                this.setVisible(false);
            }
            else {
                JOptionPane.showMessageDialog(this, "Select First");
            }
        });

        bg=new ButtonGroup();
        bg.add(studentradiobutton);
        bg.add(teacherradiobutton);

        this.setSize(600,600);
        this.setLayout(null);
        this.setVisible(true);

    }
    public static void main(String[] args){
        new FirstPage();
    }
}
