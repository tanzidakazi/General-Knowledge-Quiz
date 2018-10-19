import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class Modify extends JFrame {
    JLabel modifylb;
    JButton addbt;
    JButton deletebt;
    JButton viewbt;
    JButton exitbt;

    Modify(){
        modifylb= new JLabel();
        modifylb.setText("Modify");
        modifylb.setBounds(100, 50, 300, 50);
        modifylb.setForeground(Color.BLUE);
        modifylb.setFont(new Font("Arial", Font.BOLD, 22));
        this.add(modifylb);

        addbt= new JButton();
        addbt.setText("Add Question");
        addbt.setBounds(100,150, 300,50);
        addbt.setFont(new Font("Arial", Font.BOLD, 18));
        addbt.setForeground(Color.BLUE);
        addbt.setBackground(Color.PINK);
        this.add(addbt);

        deletebt= new JButton();
        deletebt.setText("Delete Question");
        deletebt.setBounds(100,250, 300,50);
        deletebt.setFont(new Font("Arial", Font.BOLD, 18));
        deletebt.setForeground(Color.BLUE);
        deletebt.setBackground(Color.PINK);
        this.add(deletebt);

        viewbt= new JButton();
        viewbt.setText("View Question");
        viewbt.setBounds(100,350, 300,50);
        viewbt.setFont(new Font("Arial", Font.BOLD, 18));
        viewbt.setForeground(Color.BLUE);
        viewbt.setBackground(Color.PINK);
        this.add(viewbt);

        exitbt= new JButton();
        exitbt.setText("Go to first page");
        exitbt.setBounds(50,470, 200,50);
        exitbt.setFont(new Font("Arial", Font.BOLD, 15));
        exitbt.setForeground(Color.BLUE);
        exitbt.setBackground(Color.PINK);
        this.add(exitbt);
        exitbt.addActionListener(e->{
            new FirstPage();
            this.setVisible(false);
        });


        addbt.addActionListener(e->{
                new Add();
                this.setVisible(false);
        });
        deletebt.addActionListener(e->{
            new Delete();
            this.setVisible(false);
        });
        viewbt.addActionListener(e->{
            new view();
            //this.setVisible(false);
        });
        this.setSize(600,600);
        this.setLayout(null);
        this.setVisible(true);
    }
    public static void main(String[] args){
        new Modify();
    }
}


