import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

class MyFrame1 extends JFrame implements ActionListener{
 JRadioButton option1;
 JRadioButton option2;
 JRadioButton option3;
 JPanel panel;
 ButtonGroup bg;
 JLabel label;
 JButton nextbutton;
 int q=0;
 int c=0;
 String[][] QuestionAndOption;
 String[][] QuestionAndRightAnswer;
 String[] ClickedAns;
 
 MyFrame1(){
 setTitle("MCQ GENERAL KNOWLEDGE QUIZ");
 setSize(600, 330);
 setDefaultCloseOperation(EXIT_ON_CLOSE);
 data();
 
 Container con=getContentPane();
 bg=new ButtonGroup();
 option1=new JRadioButton();
 option2=new JRadioButton();
 option3=new JRadioButton();
 bg.add(option1);
 bg.add(option2);
 bg.add(option3);

 label= new JLabel();
 label.setForeground(Color.RED);
 label.setFont(new Font("Italic", Font.BOLD, 16));
 
 panel=new JPanel();
 panel.setBackground(Color.YELLOW);
 panel.setSize(600,300);
 panel.setLayout(new GridLayout(5,1));
 panel.add(label);
 panel.add(option1);
 panel.add(option2);
 panel.add(option3);
 
 nextbutton =new JButton("NEXT");
 nextbutton.setForeground(Color.BLUE);
 nextbutton.setBackground(Color.PINK);
 nextbutton.addActionListener(this);
 panel.add(nextbutton);
 con.add(panel);
 setVisible(true);
 setqa(q);
 ClickedAns=new String[6];
}

public void data(){
                    QuestionAndOption=new String[6][4];
                    QuestionAndOption[0][0]="1. What is the capital city of Germany?";
                    QuestionAndOption[0][1]="London";
                    QuestionAndOption[0][2]="Dhaka";
                    QuestionAndOption[0][3]="Berlin";
                
                    QuestionAndOption[1][0]="2. Who was the world's first programmer?";
                    QuestionAndOption[1][1]="Ada Lovelace";
                    QuestionAndOption[1][2]="Mark Zuckerberg";
                    QuestionAndOption[1][3]="Steve Jobs";
                       
                    QuestionAndOption[2][0]="3. What is the first programming language?";
                    QuestionAndOption[2][1]="Java";
                    QuestionAndOption[2][2]="FORTRAN";
                    QuestionAndOption[2][3]="C";
                 
                    QuestionAndOption[3][0]="4. Definition of object in Java?";
                    QuestionAndOption[3][1]="instance of a class";
                    QuestionAndOption[3][2]="constructor of a class";
                    QuestionAndOption[3][3]="state of a class";
                    
                    QuestionAndOption[4][0]="5. Who invented Java Programming Language?";
                    QuestionAndOption[4][1]="Dennis Ritchie";
                    QuestionAndOption[4][2]="James Gosling";
                    QuestionAndOption[4][3]="Larry Wall";
                     
                    QuestionAndOption[5][0]="6. Where is Olympics 2016 being held?";
                    QuestionAndOption[5][1]="Rio";
                    QuestionAndOption[5][2]="Tokyo";
                    QuestionAndOption[5][3]="Paris";
   
                    QuestionAndRightAnswer=new String[6][2];
                    QuestionAndRightAnswer[0][0]="What is the capital city of Germany?";
                    QuestionAndRightAnswer[0][1]="Berlin";

                    QuestionAndRightAnswer[1][0]="Who was the world's first programmer?";
                    QuestionAndRightAnswer[1][1]="Ada Lovelace";
                         
                    QuestionAndRightAnswer[2][0]="What is the first programming language?";
                    QuestionAndRightAnswer[2][1]="FORTRAN";

                    QuestionAndRightAnswer[3][0]="Definition of object in Java?";
                    QuestionAndRightAnswer[3][1]="instance of a class";

                    QuestionAndRightAnswer[4][0]="Who invented Java Programming Language?";
                    QuestionAndRightAnswer[4][1]="James Gosling";
                  
                    QuestionAndRightAnswer[5][0]="Where is Olympics 2016 being held?";
                    QuestionAndRightAnswer[5][1]="Rio"; 
					
                    }
					
public void setqa(int q){
                        label.setText("  "+QuestionAndOption(q)[0]);
                        option1.setText(QuestionAndOption(q)[1]);
                        option2.setText(QuestionAndOption(q)[2]);
                        option3.setText(QuestionAndOption.get(q)[3]);
            }
					 
public void actionPerformed(ActionEvent e){
    if(nextbutton.getText().equals("NEXT")){
                       if(q<5){
							 ClickedAns[q]=clicked();
                             q++;
                             setqa(q);
                                           }
                       else{
							 ClickedAns[q]=clicked();
                             nextbutton.setText("CHECK ANSWERS");
                            }
                      }
                       else if(nextbutton.getText().equals("CHECK ANSWERS"))
                                    new MyFrame2();
          }

public String clicked(){
	if(option1.isSelected()) return option1.getText();
	if(option2.isSelected()) return option2.getText();
	if(option3.isSelected()) return option3.getText();
	return null;
                    }
				
public int calculate(){ 
                        for(int q=0; q<6; q++)
									if(QuestionAndRightAnswer[q][1].equals(ClickedAns[q]))
										c++;
                        return c;
            }
public class MyFrame2 extends JFrame{
                        MyFrame2(){
                               setTitle("ANSWERS AND RESULT");
                               setSize(700,600);
                               addWindowListener(new WindowAdapter(){
                      
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
                                                            g.drawString(i+1+". "+QuestionAndRightAnswer[i][0], x,y);
                                                            y=y+25;
                                                            g.setFont(new Font("Arial",Font.BOLD,12)); 
															g.setColor(Color.BLUE);	
                                                            g.drawString("      Clicked answer: "+ClickedAns[i], x,y);
                                                            y=y+25;  
                                                            g.setColor(Color.ORANGE);															
                                                            g.drawString("      Right answer: "+QuestionAndRightAnswer[i][1], x,y);
                                                            y=y+25;															
                                                }
                                                int n=calculate();
                                                g.setColor(Color.GREEN);
                                                g.setFont(new Font("Arial",Font.BOLD,15));
                                                g.drawString("Number of right answers: "+n,200,510);   
											    g.drawString("Accuracy percentage : "+(n*100)/6+ "%",200,540); 
                                    }
                        }
                                   
            }
}
public class GkQuiz{
public static void main(String[] args){
                         new MyFrame1();
            }
}