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
import java.util.Vector;



class MyFrame extends JFrame implements ActionListener{
	JLabel nameLabel,nameLabel1,nameLabel2,nameLabel3,nameLabel4,nameLabel5,nameLabel6,nameLabel16;
	JLabel nameLabel7,nameLabel8,nameLabel9,nameLabel10,nameLabel11,nameLabel12,nameLabel13,nameLabel14,nameLabel15;
	JButton button,button1,button2,button3,button4,button5,button6,button7,button8,button9,button10,button11,button23;
	JButton button12,button13,button14,button15,button16,button17,button18,button19,button20,button21,button22,button24;
	JTextField text,text1,text2,text3,text4,text5,text6,text7,text8,text9,text10,text11,text12;
	JPanel panel,panel1,panel2,panel3,panel4,panel5,panel6,panel7,panel8,panel9,panel10,panel11;
	JTable personTable;
	
	
	Object[] columns = {"NAME", "PHONE", "EMAIL"};
	Object[][] data = new Object[100][100];
	
	public MyFrame(){
		this.setResizable(false);
	
		panel = new JPanel();
		panel.setBackground(Color.red);
		panel.setSize(400,400);
		panel.setBounds(0,0,400,400);
		panel.setLayout(null);
		this.add(panel);
		
		
		nameLabel = new JLabel();
		nameLabel.setText("Welcome To Contact Apps");
		nameLabel.setBounds(100,120,800,40);
		panel.add(nameLabel);

		button = new JButton();
		button.setText("Next");
		button.setBounds(140,160,60,40);
		button.addActionListener(this);
		panel.add(button);
		
		
		panel1 = new JPanel();
		panel1.setBackground(Color.green);
		panel1.setSize(400,400);
		panel1.setBounds(0,0,400,400);
		panel1.setLayout(null);
		
		
		
		nameLabel1 = new JLabel();
		nameLabel1.setText("Select An Option: ");
		nameLabel1.setBounds(150,30,800,40);
		panel1.add(nameLabel1);		
			

		button1 = new JButton();
		button1.setText("New");
		button1.setBounds(0,100,80,80);
		button1.addActionListener(this);
		panel1.add(button1);
		
		button2 = new JButton();
		button2.setText("Exist");
		button2.setBounds(100,100,80,80);
		button2.addActionListener(this);
		panel1.add(button2);
		
		button18 = new JButton();
		button18.setText("Delete");
		button18.setBounds(200,100,80,80);
		button18.addActionListener(this);
		panel1.add(button18);
		
		button19 = new JButton();
		button19.setText("Search");
		button19.setBounds(300,100,80,80);
		button19.addActionListener(this);
		panel1.add(button19);
		
		button12 = new JButton();
		button12.setText("Back");
		button12.setBounds(140,200,100,40);
		button12.addActionListener(this);
		panel1.add(button12);
				
		panel2 = new JPanel();
		panel2.setBackground(Color.yellow);
		panel2.setSize(400,400);
		panel2.setBounds(0,0,400,400);
		panel2.setLayout(null);
		
		nameLabel2 = new JLabel();
		nameLabel2.setText("User Name");
		nameLabel2.setBounds(80,50,500,70);
		panel2.add(nameLabel2);	
		
		text = new JTextField();
		text.setBounds(80,100,150,30);
        panel2.add(text);
		
		nameLabel3 = new JLabel();
		nameLabel3.setText("Phone Number");
		nameLabel3.setBounds(80,120,500,70);
		panel2.add(nameLabel3);	
		
		text1 = new JTextField();
		text1.setBounds(80,170,150,30);
        panel2.add(text1);
		
		nameLabel4 = new JLabel();
		nameLabel4.setText("Email Address");
		nameLabel4.setBounds(80,180,500,70);
		panel2.add(nameLabel4);			
				
		text2 = new JTextField();
		text2.setBounds(80,230,150,30);
        panel2.add(text2);
		
		button3 = new JButton();
		button3.setText("Save");
		button3.setBounds(170,270,100,40);
		button3.addActionListener(this);
		panel2.add(button3);
		
		button13 = new JButton();
		button13.setText("Back");
		button13.setBounds(70,270,100,40);
		button13.addActionListener(this);
		panel2.add(button13);
		

		
		panel3 = new JPanel();
		panel3.setBackground(Color.yellow);
		panel3.setSize(400,400);
		panel3.setBounds(0,0,400,400);
		panel3.setLayout(null);
		
		button4 = new JButton();
		button4.setText("Email Update");
		button4.setBounds(80,80,200,40);
		button4.addActionListener(this);
		panel3.add(button4);
		
		button5 = new JButton();
		button5.setText("Phone Update");
		button5.setBounds(80,150,200,40);
		button5.addActionListener(this);
		panel3.add(button5);
		
		button6 = new JButton();
		button6.setText("Emaiil & Phone Both Update");
		button6.setBounds(80,220,200,40);
		button6.addActionListener(this);
		panel3.add(button6);
		
		button14 = new JButton();
		button14.setText("Back");
		button14.setBounds(130,280,100,40);
		button14.addActionListener(this);
		panel3.add(button14);
		
		panel4 = new JPanel();
		panel4.setBackground(Color.orange);
		panel4.setSize(400,400);
		panel4.setBounds(0,0,400,400);
		panel4.setLayout(null);
		
		nameLabel5 = new JLabel();
		nameLabel5.setText("User Name");
		nameLabel5.setBounds(80,50,500,70);
		panel4.add(nameLabel5);	
		
		text3 = new JTextField();
		text3.setBounds(80,100,150,30);
        panel4.add(text3);
		
		nameLabel6 = new JLabel();
		nameLabel6.setText("Email Address");
		nameLabel6.setBounds(80,130,500,70);
		panel4.add(nameLabel6);	
		
		text4 = new JTextField();
		text4.setBounds(80,180,150,30);
        panel4.add(text4);
		
		button7 = new JButton();
		button7.setText("Update");
		button7.setBounds(170,220,100,40);
		button7.addActionListener(this);
		panel4.add(button7);
		
		button15 = new JButton();
		button15.setText("Back");
		button15.setBounds(70,220,100,40);
		button15.addActionListener(this);
		panel4.add(button15);
		
		
		panel5 = new JPanel();
		panel5.setBackground(Color.orange);
		panel5.setSize(400,400);
		panel5.setBounds(0,0,400,400);
		panel5.setLayout(null);
		
		nameLabel7 = new JLabel();
		nameLabel7.setText("User Name");
		nameLabel7.setBounds(80,50,500,70);
		panel5.add(nameLabel7);	
		
		text5 = new JTextField();
		text5.setBounds(80,100,150,30);
        panel5.add(text5);
		
		nameLabel8 = new JLabel();
		nameLabel8.setText("Phone Number");
		nameLabel8.setBounds(80,130,500,70);
		panel5.add(nameLabel8);	
		
		text6 = new JTextField();
		text6.setBounds(80,180,150,30);
        panel5.add(text6);
		
		button8 = new JButton();
		button8.setText("Update");
		button8.setBounds(170,220,100,40);
		button8.addActionListener(this);
		panel5.add(button8);
		
		button16 = new JButton();
		button16.setText("Back");
		button16.setBounds(70,220,100,40);
		button16.addActionListener(this);
		panel5.add(button16);
		
		
		
		panel6 = new JPanel();
		panel6.setBackground(Color.orange);
		panel6.setSize(400,400);
		panel6.setBounds(0,0,400,400);
		panel6.setLayout(null);
		
		nameLabel9 = new JLabel();
		nameLabel9.setText("User Name");
		nameLabel9.setBounds(80,20,500,70);
		panel6.add(nameLabel9);	
		
		text7 = new JTextField();
		text7.setBounds(80,70,150,30);
        panel6.add(text7);
		
		nameLabel10 = new JLabel();
		nameLabel10.setText("Email Address");
		nameLabel10.setBounds(80,120,500,70);
		panel6.add(nameLabel10);	
		
		text8 = new JTextField();
		text8.setBounds(80,170,150,30);
        panel6.add(text8);
		
		nameLabel11 = new JLabel();
		nameLabel11.setText("Phone Number");
		nameLabel11.setBounds(80,220,500,70);
		panel6.add(nameLabel11);	
		
		text9 = new JTextField();
		text9.setBounds(80,270,150,30);
        panel6.add(text9);
		
		button9 = new JButton();
		button9.setText("Update");
		button9.setBounds(170,320,100,40);
		button9.addActionListener(this);
		panel6.add(button9);
		
		button17 = new JButton();
		button17.setText("Back");
		button17.setBounds(70,320,100,40);
		button17.addActionListener(this);
		panel6.add(button17);
		
		panel7 = new JPanel();
		panel7.setBackground(Color.blue);
		panel7.setSize(400,400);
		panel7.setBounds(0,0,400,400);
		panel7.setLayout(null);
		
		nameLabel15 = new JLabel();
		nameLabel15.setText("Show The Selected Data");
		nameLabel15.setBounds(100,100,500,70);
		panel7.add(nameLabel15);
		
		button10 = new JButton();
		button10.setText("Show");
		button10.setBounds(120,150,100,40);
		button10.addActionListener(this);
		panel7.add(button10);
		
		
			
		panel9 = new JPanel();
		panel9.setBackground(Color.red);
		panel9.setSize(400,400);
		panel9.setBounds(0,0,400,400);
		panel9.setLayout(null);
		
		nameLabel12 = new JLabel();
		nameLabel12.setText("User You Want To Delete");
		nameLabel12.setBounds(80,50,500,70);
		panel9.add(nameLabel12);	
		
		text11 = new JTextField();
		text11.setBounds(80,100,150,30);
        panel9.add(text11);
		
		button20 = new JButton();
		button20.setText("Delete");
		button20.setBounds(70,180,100,40);
		button20.addActionListener(this);
		panel9.add(button20);
		
		button21 = new JButton();
		button21.setText("Back");
		button21.setBounds(170,180,100,40);
		button21.addActionListener(this);
		panel9.add(button21);
		
		
		
		panel10 = new JPanel();
		panel10.setBackground(Color.red);
		panel10.setSize(400,400);
		panel10.setBounds(0,0,400,400);
		panel10.setLayout(null);
		
		nameLabel13 = new JLabel();
		nameLabel13.setText("User Name You Want To Search");
		nameLabel13.setBounds(80,50,500,70);
		panel10.add(nameLabel13);	
		
		text12 = new JTextField();
		text12.setBounds(80,100,150,30);
        panel10.add(text12);
		
		button22 = new JButton();
		button22.setText("Search");
		button22.setBounds(70,180,100,40);
		button22.addActionListener(this);
		panel10.add(button22);
		
		button23 = new JButton();
		button23.setText("Back");
		button23.setBounds(170,180,100,40);
		button23.addActionListener(this);
		panel10.add(button23);
			
		this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        this.setSize(400, 400);
        this.setVisible(true);
		
		
	}

class SearchResult extends JFrame{   
    JTable personTable;
    
    SearchResult(){
        Object[] columns = {"NAME", "PHONE", "EMAIL"};
        Object[][] data = new Object[50][30];
		personTable = new JTable(data, columns);
        JScrollPane pnl = new JScrollPane(personTable);
        		
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/persondb", "root", "");
            Statement stmt = con.createStatement();
            String name = text12.getText();                        
            String query = "SELECT name, phone, email FROM person where name = '"+name+"'";           
            ResultSet rs = stmt.executeQuery(query);             
            
            for(int i=0;rs.next();++i){
                data[i][0] = rs.getString("name");
                data[i][1] = rs.getString("phone");
                data[i][2] = rs.getString("email");
            }
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Name not found!");
			dispose();
			this.setContentPane(panel3);
			this.setVisible(true);
			
			
        }
		
		this.getContentPane().add(pnl);
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        this.setSize(300, 300);
        this.setVisible(true);        
    }
}
		
	public void actionPerformed(ActionEvent e){    
 				if (e.getSource()==button){
				this.setContentPane(panel1);
				this.setVisible(true);
				} 
				
				else if (e.getSource()==button1){
				this.setContentPane(panel2);
				this.setVisible(true);
				}
				
				else if (e.getSource()==button2){
				this.setContentPane(panel3);
				this.setVisible(true);
				}
				
				
				else if (e.getSource()==button3){


					try {
						Class.forName("com.mysql.jdbc.Driver");
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/persondb", "root", "");
						Statement stmt = con.createStatement();
            
						String name = text.getText();
						String phone = text1.getText();
						String email = text2.getText();
					if (text.getText().equals("") || text.getText().equals("")||text1.getText().equals("")){
							JOptionPane.showMessageDialog(this, "Field Is Empty!");
						}
						else {
						String query = "INSERT INTO person (name,phone,email) VALUES ('"+name+"', '"+phone+"','"+email+"')";            
						//System.out.println(query);
						if(stmt.executeUpdate(query)==1){
							JOptionPane.showMessageDialog(this, "Record Added");
							this.setContentPane(panel7);
							this.setVisible(true);
						}            
					else{
						JOptionPane.showMessageDialog(this, "Record Could not be Added");
					}			
					} 
				}
					catch (Exception ex) {
						JOptionPane.showMessageDialog(this, "Some Error Occured");
					}
				}
				
				else if (e.getSource()==button4){
					this.setContentPane(panel4);
					this.setVisible(true);
				}
				else if (e.getSource()==button5){
					this.setContentPane(panel5);
					this.setVisible(true);
				}
				else if (e.getSource()==button6){
					this.setContentPane(panel6);
					this.setVisible(true);
				}
				
				else if (e.getSource()==button7){
					try {
						Class.forName("com.mysql.jdbc.Driver");
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/persondb", "root", "");
						Statement stmt = con.createStatement();
            
						String name = text3.getText();
						String email = text4.getText();
						
					if (text3.getText().equals("") || text4.getText().equals("")){
							JOptionPane.showMessageDialog(this, "Field Is Empty!");
					}
						else {
            
						String query = "UPDATE person SET email = '"+email+"' WHERE name = '"+name+"'";            
						//System.out.println(query);
						if(stmt.executeUpdate(query)==1){
							JOptionPane.showMessageDialog(this, "Updated");
							this.setContentPane(panel7);
							this.setVisible(true);
						}            
						else{
						JOptionPane.showMessageDialog(this, "Can't Find User!");
						}			
					} 
					}
					catch (Exception ex) {
						JOptionPane.showMessageDialog(this, "Some Error Occured");
					}						
				}
				
				else if (e.getSource()==button8){
					try {
						Class.forName("com.mysql.jdbc.Driver");
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/persondb", "root", "");
						Statement stmt = con.createStatement();
            
						String name = text5.getText();
						String phone = text6.getText();
					if (text5.getText().equals("") || text6.getText().equals("")){
							JOptionPane.showMessageDialog(this, "Field Is Empty!");
						}
						else {
            
						String query = "UPDATE person SET phone = '"+phone+"' WHERE name = '"+name+"'";            
						//System.out.println(query);
						if(stmt.executeUpdate(query)==1){
							JOptionPane.showMessageDialog(this, "Updated");
							this.setContentPane(panel7);
							this.setVisible(true);
						}    						
						else{
						JOptionPane.showMessageDialog(this, "Can't Find User!");
						}			
					} 
					}
					catch (Exception ex) {
						JOptionPane.showMessageDialog(this, "Some Error Occured");
					}
				}
				
				else if (e.getSource()==button9){
					try {
						Class.forName("com.mysql.jdbc.Driver");
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/persondb", "root", "");
						Statement stmt = con.createStatement();
            
						String name = text7.getText();
						String email = text8.getText();
						String phone = text9.getText();
						if (text8.getText().equals("") || text9.getText().equals("")){
							JOptionPane.showMessageDialog(this, "Field Is Empty!");
						}
						else {
							String query = "UPDATE person SET email = '"+email+"', phone = '"+phone+"' WHERE name = '"+name+"'";            
						//System.out.println(query);
							if(stmt.executeUpdate(query)==1){
								JOptionPane.showMessageDialog(this, "Updated");
								this.setContentPane(panel7);
								this.setVisible(true);
							}    
					else{
						JOptionPane.showMessageDialog(this, "Can't Find User!");
					}	
						}
					} 
					catch (Exception ex) {
						JOptionPane.showMessageDialog(this, "Some Error Occured");
					}
				}
				
				
			else if (e.getSource()==button10){
					new Show();
					this.setVisible(false);					
		}
			else if (e.getSource()==button12){
					this.setContentPane(panel);
					this.setVisible(true);					
		}
			else if (e.getSource()==button13){
					this.setContentPane(panel1);
					this.setVisible(true);					
		}
			else if (e.getSource()==button14){
					this.setContentPane(panel1);
					this.setVisible(true);					
		}
			else if (e.getSource()==button15){
					this.setContentPane(panel3);
					this.setVisible(true);					
		}
			else if (e.getSource()==button16){
					this.setContentPane(panel3);
					this.setVisible(true);					
		}
			else if (e.getSource()==button21){
					this.setContentPane(panel1);
					this.setVisible(true);					
		}
	
			else if (e.getSource()==button18){
					this.setContentPane(panel9);
					this.setVisible(true);					
		}

			else if (e.getSource()==button19){
					this.setContentPane(panel10);
					this.setVisible(true);					
		}
		
			else if (e.getSource()==button20){
					try {
						Class.forName("com.mysql.jdbc.Driver");
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/persondb", "root", "");
						Statement stmt = con.createStatement();
            
						String name = text11.getText();
					if (text11.getText().equals("")){
							JOptionPane.showMessageDialog(this, "Field Is Empty!");
						}
						else {
            
						String query = "DELETE from person WHERE name = '"+name+"'";            
						//System.out.println(query);
						if(stmt.executeUpdate(query)==1){
							JOptionPane.showMessageDialog(this, "Deleted!");
							this.setContentPane(panel7);
							this.setVisible(true);
						}    						
						else{
						JOptionPane.showMessageDialog(this, "Can't Find User!");
						}			
					} 
					}
					catch (Exception ex) {
						JOptionPane.showMessageDialog(this, "Some Error Occured");
						ex.printStackTrace();
					}
				}
			
				else if (e.getSource()==button22){
					new SearchResult();
					this.setVisible(false);
				}
		
	}
		public static void main(String[] args){
				new MyFrame();
			}
}
		
