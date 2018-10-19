/**
 * Created by tanzida on 9/2/2016.
 */
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Quiz extends JFrame implements ActionListener{
        JRadioButton option1;
        JRadioButton option2;
        JRadioButton option3;
        JPanel panel;

        ButtonGroup bg;
        JLabel label;
        JButton nextbt;
        int q=0;
        int c=0;
        String[] ClickedAns;
        ArrayList<String[]> Questions=Database.getQuestions();
        ArrayList<String[]> Answers=Database.getRightAnswers();

        Quiz() {
            ArrayList<String[]> Questions = Database.getQuestions();

            setTitle("MCQ GENERAL KNOWLEDGE QUIZ");
            setSize(650, 600);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setResizable(false);

            Container con = getContentPane();
            bg = new ButtonGroup();
            option1 = new JRadioButton();
            option1.setFont(new Font("Arial", Font.BOLD, 18));
            option2 = new JRadioButton();
            option2.setFont(new Font("Arial", Font.BOLD, 18));
            option3 = new JRadioButton();
            option3.setFont(new Font("Arial", Font.BOLD, 18));
            bg.add(option1);
            bg.add(option2);
            bg.add(option3);
            label = new JLabel();
            label.setForeground(Color.RED);
            label.setFont(new Font("Italic", Font.BOLD, 18));

            panel = new JPanel();
            panel.setBackground(Color.YELLOW);
            panel.setSize(650, 600);
            panel.setLayout(new GridLayout(5, 1));
            panel.add(label);
            panel.add(option1);
            panel.add(option2);
            panel.add(option3);

            nextbt = new JButton("NEXT");
            nextbt.setFont(new Font("Arial", Font.BOLD, 18));
            nextbt.setForeground(Color.BLUE);
            nextbt.setBackground(Color.PINK);
            nextbt.addActionListener(this);
            panel.add(nextbt);
            con.add(panel);
            setVisible(true);
            setqa(q);
            ClickedAns = new String[6];}

    public String clicked() {
        if (option1.isSelected()) return option1.getText();
        if (option2.isSelected()) return option2.getText();
        if (option3.isSelected()) return option3.getText();
        return null;
    }

    public void setqa(int q) {
        //System.out.println(Questions.get(q)[1]);
        label.setText("  " + Questions.get(q)[0]);
        option1.setText(Questions.get(q)[1]);
        option2.setText(Questions.get(q)[2]);
        option3.setText(Questions.get(q)[3]);
    }

    public void actionPerformed(ActionEvent e) {
        if (nextbt.getText().equals("NEXT")) {
            if (q < 5) {
                ClickedAns[q] = clicked();
                q++;
                setqa(q);
            } else {
                ClickedAns[q] = clicked();
                nextbt.setText("CHECK ANSWERS");
            }
        }
        else if(nextbt.getText().equals("CHECK ANSWERS"))
         new MyFrame2();

    }
    public int calculate(){
        for(int q=0; q<6; q++)
            if(Answers.get(q)[1].equals(ClickedAns[q]))
                c++;
        return c;
    }

    public class MyFrame2 extends JFrame{
        JButton exitbt;
        MyFrame2(){
            exitbt= new JButton();
            exitbt.setText("Go to first page");
            exitbt.setBounds(10,600, 200,50);
            exitbt.setFont(new Font("Arial", Font.BOLD, 15));
            exitbt.setForeground(Color.BLUE);
            exitbt.setBackground(Color.PINK);
            this.add(exitbt);
            exitbt.addActionListener(e->{
                new FirstPage();
                this.setVisible(false);
            });

            setTitle("ANSWERS AND RESULT");
            setSize(700,700);
            setResizable(false);
            addWindowListener(new WindowAdapter(){
                public void windowClosing(WindowEvent e){
                    dispose();
                }

            });
            Display d=new Display();
            add(d);
            setVisible(true);
        }
        class Display extends Canvas{
            public void paint(Graphics g){
                int x=6;
                int y=30;
                for(int i=0;i<6;i++){
                    g.setFont(new Font("Italic",Font.BOLD,12));
                    g.setColor(Color.RED);
                    g.drawString(i+1+". "+ Answers.get(i)[0], x,y);
                    y=y+25;
                    g.setFont(new Font("Arial",Font.BOLD,12));
                    g.setColor(Color.BLUE);
                    g.drawString("      Clicked answer: "+ClickedAns[i], x,y);
                    y=y+25;
                    g.setColor(Color.MAGENTA);
                    g.drawString("      Right answer: "+Answers.get(i)[1], x,y);
                    y=y+25;
                }
                int n=calculate();
                g.setColor(Color.BLUE);
                g.setFont(new Font("Arial",Font.BOLD,15));
                g.drawString("Number of right answers: "+n,200,510);
                g.drawString("Accuracy percentage : "+(n*100)/6+ "%",200,540);
            }
        }

    }
    public static void main(String[] args){
        new Quiz();
    }
}

