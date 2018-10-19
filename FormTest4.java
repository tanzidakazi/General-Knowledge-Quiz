import javax.swing.*;
import java.awt.*;
import java.util.Vector;


class FormTest4 extends JFrame{
    static String spotname;
    JLabel namelabel11,namelabel12;
    Vector<String>vec=new Vector<>();
    Vector<JRadioButton>r=new Vector<>();
   //JRadioButton[] rbt = new JRadioButton[20]();
    //JRadioButton[] r=new JRadioButton[]();
    JButton btn6,btn7;
    public FormTest4(Point p){


        this.setLocation(p);

        ImageIcon img= new ImageIcon("C:\\Users\\arifu\\Desktop\\art-gallery-icon-20.png");
        this.setIconImage(img.getImage());

        getContentPane().setBackground(Color.ORANGE);

        namelabel12 = new JLabel(FormTest3.district);
        //spotname=r1.getText();
        namelabel12.setFont(new Font("Courier New", Font.BOLD, 24));
        namelabel12.setForeground(Color.RED);
        namelabel12.setBounds(300, 20, 300, 50);
        this.add(namelabel12);

        namelabel11 = new JLabel("Which Place do you want to visit??");
        namelabel11.setFont(new Font("Courier New", Font.BOLD, 30));
        namelabel11.setForeground(Color.BLUE);
        namelabel11.setBounds(20, 50, 700, 50);
        this.add(namelabel11);
       Vector<String> V=DBMethod.place();
        //System.out.println(V.size());
        ButtonGroup bg1 = new ButtonGroup();
        int a=20,b=90,c=300,d=20;
        for(int i=0;i<V.size();i++) {
            JRadioButton rb=new JRadioButton();
            rb.setBounds(a,b+20,c,d);
            b+=40;
            //r.add(rb);
            /*r[i] = new JRadioButton();
            r[i].add();*/
            rb.setText(V.get(i));
            System.out.println(rb.getText());
            bg1.add(rb);
            r.add(rb);
            this.add(rb);

        }


       /* r1.setBounds(20, 110, 300, 20);
        this.add(r1);
        bg1.add(r1);

        r2 = new JRadioButton();
        r2.setBounds(20, 160, 300, 20);

        this.add(r2);
        bg1.add(r2);

        r3 = new JRadioButton();
        r3.setBounds(20, 210, 300, 20);

        this.add(r3);
        bg1.add(r3);*/


        btn6 = new JButton("Back");
        btn6.setBounds(20, 510, 100, 30);
        this.add(btn6);
        btn6.setFont(new Font("Courier New", Font.BOLD, 14));
        btn6.setForeground(Color.RED);
        btn6.addActionListener(e->
        {
            new FormTest3(this.getLocation());
            this.setVisible(false);

        });

        btn7 = new JButton("Next");
        btn7.setBounds(600, 510, 100, 30);
        this.add(btn7);
        btn7.setFont(new Font("Courier New", Font.BOLD, 14));
        btn7.setForeground(Color.RED);
        btn7.addActionListener(e->
        {   System.out.println(r.size());
            boolean f=true;
            for(int i=0;i<r.size();i++) {
                System.out.println(r.get(i).getText() + " " + r.get(i).isSelected());
                if (r.get(i).isSelected()) {
                    f = false;
                    spotname = r.get(i).getText();
                    new FormTest5(this.getLocation());

                    this.setVisible(false);
                }
            }
            if(f) JOptionPane.showMessageDialog(this, "All fields are not filled");
            /*else if(r2.isSelected())
            {   spotname=r2.getText();
                new FormTest5(this.getLocation());

                this.setVisible(false);
            }
            else if(r3.isSelected())
            {   spotname=r3.getText();
                new FormTest5(this.getLocation());

                this.setVisible(false);
                //javac -cp .;./connector.jar test2.java
                //java -cp .;./connector.jar test2
            }*/
              /*  else {
                    JOptionPane.showMessageDialog(this, "All fields are not filled");
                }*/
        });

        this.setSize(800,600);
        this.setLayout(null);
        this.setVisible(true);
    }
}