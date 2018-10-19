import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
public class Question extends JFrame{
    JRadioButton qoption1;
    JRadioButton qoption2;
    JRadioButton qoption3;
    ButtonGroup bg;
    JLabel qlb;
    JButton finishedbt;
    Question(){
        setTitle("MCQ GENERAL KNOWLEDGE QUIZ");
        setSize(600, 600);

        qlb= new JLabel();
        qlb.setBounds(30, 40, 300, 50);
        qlb.setForeground(Color.RED);
        qlb.setFont(new Font("Italic", Font.BOLD, 14));
        this.add(qlb);

        qoption1=new JRadioButton();
        qoption1.setBounds(30, 80, 300, 40);
        this.add(qoption1);

        qoption2=new JRadioButton();
        qoption2.setBounds(30, 120, 300, 40);
        this.add(qoption2);

        qoption3=new JRadioButton();
        qoption3.setBounds(30, 160, 300, 40);
        this.add(qoption3);

        bg=new ButtonGroup();
        bg.add(qoption1);
        bg.add(qoption2);
        bg.add(qoption3);

        finishedbt =new JButton("Finished");
        finishedbt.setFont(new Font("Arial", Font.BOLD, 10));
        finishedbt.setBounds(100,200, 80,30);
        finishedbt.setForeground(Color.BLUE);
        finishedbt.setBackground(Color.PINK);
        this.add(finishedbt);

        finishedbt.addActionListener(e->{
                new Result();
                this.setVisible(false);
        });
        this.setSize(600,600);
        this.setLayout(null);
        this.setVisible(true);

    }
    public static void main(String[] args){
        new Question();
    }
}
