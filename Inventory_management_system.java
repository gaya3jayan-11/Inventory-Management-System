package MultipleCustomers;

import javax.swing.*;
import java.awt.event.*;
import java.util.*;

class Product
{
	String id, name;
	int quantity;
}
class Furniture extends Product
{
	Furniture(String id, String name, int quantity)
	{
		this.id=id;
		this.name=name;
		this.quantity=quantity;
	}
}
class Appliances extends Product
{
	Appliances(String id, String name, int quantity)
	{
		this.id=id;
		this.name=name;
		this.quantity=quantity;
	}
}

class Customer
{
	String id, name;
	Furniture furn_objs[]=new Furniture[100];
	Appliances elec_objs[]=new Appliances[100];
	int furn_index=-1,elec_index=-1;
	float rent=0;
	Customer(String id, String name)
	{
		this.id=id;
		this.name=name;
	}
	void manage_product(Customer c)
	{
		JFrame f3= new JFrame("Admin"); 
		JLabel l3=new JLabel(); 
		f3.setVisible(true); 
		f3.setSize(1000,1000);
		f3.setLayout(null);
		l3.setText("Customer Menu"); 
		l3.setBounds(50,25,10000,30); 
		f3.add(l3); 
		JButton b1,b2,b3,b4,b5,b6;
		b1=new JButton("Add Furniture"); 
		b2=new JButton("Remove Furniture");
		b3=new JButton("Add Appliances"); 
		b4=new JButton("Remove Appliances");
		b5=new JButton("Display Products and Rent");
		b6=new JButton("Return Back"); 
		b1.setBounds(130,100,100,40);  
		b1.setSize(200, 30);
		b2.setBounds(130,150,100,40); 
		b2.setSize(200, 30);
		b3.setBounds(130,200,100,40);  
		b3.setSize(200, 30);
		b4.setBounds(130,250,100,40);  
		b4.setSize(200, 30);
		b5.setBounds(130,300,100,40);  
		b5.setSize(200, 30);
		b6.setBounds(130,350,100,40);  
		b6.setSize(200, 30);
		b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) 
            { 
            	if(c.furn_index==99)
            		JOptionPane.showMessageDialog(f3, "Product Limit Reached","Alert",JOptionPane.WARNING_MESSAGE);
            	else
            	{
            		JTextField idField = new JTextField(), nameField = new JTextField(), quantityField= new JTextField();
            		JLabel idLabel = new JLabel("ID:"),nameLabel = new JLabel("Name:"),quantityLabel = new JLabel("Quantity:");
            		JPanel p = new JPanel(); 
            		p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS)); 
            		p.add(idLabel);p.add(idField);
            		p.add(nameLabel);p.add(nameField);
            		p.add(quantityLabel);p.add(quantityField);
            		int option = JOptionPane.showConfirmDialog(f3, p, "Enter Details", JOptionPane.OK_CANCEL_OPTION);
            		if (option == JOptionPane.OK_OPTION) 
            		{
            			int flag=0;
            			String new_id=idField.getText();
            			if(c.furn_index>-1)
            			{
            				for(int j=0;j<=c.furn_index;j++)
            				{
            					if(c.furn_objs[j].id.equals(new_id))
            					{
            						JOptionPane.showMessageDialog(f3, "Given ID Already exists","Alert",JOptionPane.WARNING_MESSAGE);
            						flag=1;
            						break;
            					}
            				}
            			}
            			if(flag==0)
            			{
            				try 
            				{
            					String new_name=nameField.getText();
            					int new_quantity = Integer.parseInt(quantityField.getText());
            					c.furn_index++;
            					c.furn_objs[furn_index]=new Furniture(new_id,new_name,new_quantity);
            					c.rent+=new_quantity*1000;
            					JOptionPane.showMessageDialog(f3, "Product Successfully Added");
            				} 
            				catch (NumberFormatException err) 
            				{
            					JOptionPane.showMessageDialog(f3, "Please enter valid data type for quantity","Alert",JOptionPane.WARNING_MESSAGE);
            				}
            			}
					}
                }
            }
        });
		b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) 
            { 
            	if(c.furn_index==-1)
            		JOptionPane.showMessageDialog(f3, "There are no products to be removed","Alert",JOptionPane.WARNING_MESSAGE);
            	else
            	{
            		JTextField idField = new JTextField();
                	JLabel idLabel = new JLabel("ID:");
                	JPanel p = new JPanel(); 
                	p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
                	p.add(idLabel);p.add(idField);
                	int option = JOptionPane.showConfirmDialog(f3, p, "Enter Furniture ID to be removed", JOptionPane.OK_CANCEL_OPTION);
                    if (option == JOptionPane.OK_OPTION) 
                    {
    					int rem_index=-1;
    					String rem_id=idField.getText();
    					for(int i=0;i<=c.furn_index;i++)
    					{
    						if(rem_id.equals(c.furn_objs[i].id))
    						{
    							rem_index=i;
    							c.rent-=c.furn_objs[rem_index].quantity*1000;
    							for(int j=rem_index;j<c.furn_index;j++)
    								c.furn_objs[j]=c.furn_objs[j+1];
    							c.furn_objs[furn_index]=null;
    							c.furn_index--;
    							JOptionPane.showMessageDialog(f3, "Product Successfully Removed");
    							break;
    						}
    					}
    					if(rem_index==-1)
    						JOptionPane.showMessageDialog(f3, "Given ID does not exist","Alert",JOptionPane.WARNING_MESSAGE);
                    }
            	}
            }
		});
		b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) 
            { 
            	if(c.elec_index==99)
            		JOptionPane.showMessageDialog(f3, "Product Limit Reached","Alert",JOptionPane.WARNING_MESSAGE);
            	else
            	{
            		JTextField idField = new JTextField(), nameField = new JTextField(), quantityField= new JTextField();
            		JLabel idLabel = new JLabel("ID:"),nameLabel = new JLabel("Name:"),quantityLabel = new JLabel("Quantity:");
            		JPanel p = new JPanel(); 
            		p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS)); 
            		p.add(idLabel);p.add(idField);
            		p.add(nameLabel);p.add(nameField);
            		p.add(quantityLabel);p.add(quantityField);
            		int option = JOptionPane.showConfirmDialog(f3, p, "Enter Details", JOptionPane.OK_CANCEL_OPTION);
            		if (option == JOptionPane.OK_OPTION) 
            		{
            			int flag=0;
            			String new_id=idField.getText();
            			if(c.elec_index>-1)
            			{
            				for(int j=0;j<=c.elec_index;j++)
            				{
            					if(c.elec_objs[j].id.equals(new_id))
            					{
            						JOptionPane.showMessageDialog(f3, "Given ID Already exists","Alert",JOptionPane.WARNING_MESSAGE);
            						flag=1;
            						break;
            					}
            				}
            			}
            			if(flag==0)
            			{
            				try 
            				{
            					String new_name=nameField.getText();
            					int new_quantity = Integer.parseInt(quantityField.getText());
            					c.elec_index++;
            					c.elec_objs[elec_index]=new Appliances(new_id,new_name,new_quantity);
            					c.rent+=new_quantity*1000;
            					JOptionPane.showMessageDialog(f3, "Product Successfully Added");
            				} 
            				catch (NumberFormatException err) 
            				{
            					JOptionPane.showMessageDialog(f3, "Please enter valid data type for quantity","Alert",JOptionPane.WARNING_MESSAGE);
            				}
            			}
					}
                }
            }
        });
		b4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) 
            { 
            	if(c.elec_index==-1)
            		JOptionPane.showMessageDialog(f3, "There are no products to be removed","Alert",JOptionPane.WARNING_MESSAGE);
            	else
            	{
            		JTextField idField = new JTextField();
                	JLabel idLabel = new JLabel("ID:");
                	JPanel p = new JPanel(); 
                	p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
                	p.add(idLabel);p.add(idField);
                	int option = JOptionPane.showConfirmDialog(f3, p, "Enter Appliance ID to be removed", JOptionPane.OK_CANCEL_OPTION);
                    if (option == JOptionPane.OK_OPTION) 
                    {
    					int rem_index=-1;
    					String rem_id=idField.getText();
    					for(int i=0;i<=c.elec_index;i++)
    					{
    						if(rem_id.equals(c.elec_objs[i].id))
    						{
    							rem_index=i;
    							c.rent-=c.elec_objs[rem_index].quantity*1000;
    							for(int j=rem_index;j<c.elec_index;j++)
    								c.elec_objs[j]=c.elec_objs[j+1];
    							c.elec_objs[elec_index]=null;
    							c.elec_index--;
    							JOptionPane.showMessageDialog(f3, "Product Successfully Removed");
    							break;
    						}
    					}
    					if(rem_index==-1)
    						JOptionPane.showMessageDialog(f3, "Given ID does not exist","Alert",JOptionPane.WARNING_MESSAGE);
                    }
            	}
            }
		});
		b5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{ 
				if(furn_index==-1 && elec_index==-1)
            		JOptionPane.showMessageDialog(f3, "There are no products","Alert",JOptionPane.WARNING_MESSAGE);
            	else
            	{
            		JFrame f3 = new JFrame("My Products");  
            		JPanel p = new JPanel();
                    p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
                    JLabel l1;
                    JLabel l2 = new JLabel("Total Rent = "+c.rent);
                    String column_heading[]={"ID","NAME","QUANTITY"};
                    if(furn_index==-1)
                    {
                    	l1=new JLabel("There are no furnitures");
                    	p.add(l1);
                    }
                    else
                    {
                    	l1=new JLabel("Furnitures:");
                    	String table_data_furn[][]=new String[furn_index+1][3]; 
                		for(int i=0;i<=furn_index;i++)
                		{
                			table_data_furn[i][0]=furn_objs[i].id;
                			table_data_furn[i][1]=furn_objs[i].name;
                			table_data_furn[i][2]=String.valueOf(furn_objs[i].quantity);
                		}
                		JTable t=new JTable(table_data_furn,column_heading);
                		JScrollPane sp=new JScrollPane(t);
                		p.add(l1);p.add(sp);
                    }
                    if(elec_index==-1)
                    {
                    	l1=new JLabel("There are no appliances");
                    	p.add(l1);
                    }
                    else
                    {
                    	l1=new JLabel("Electronical Appliances:");
                    	String table_data_elec[][]=new String[elec_index+1][3]; 
                		for(int i=0;i<=elec_index;i++)
                		{
                			table_data_elec[i][0]=elec_objs[i].id;
                			table_data_elec[i][1]=elec_objs[i].name;
                			table_data_elec[i][2]=String.valueOf(elec_objs[i].quantity);
                		}
                		JTable t=new JTable(table_data_elec,column_heading);         
                		JScrollPane sp=new JScrollPane(t); 
                		
                		p.add(l1);p.add(sp); 
                    }
            		
            		p.add(l2);
            		f3.add(p);
            		f3.setSize(300,400);    
            		f3.setVisible(true); 
            	}
			}
		});
		b6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	f3.dispose(); 
            }
        });
		f3.add(b1);f3.add(b2);f3.add(b3);f3.add(b4);f3.add(b5);f3.add(b6);
	}	
}

class Inventory
{
	static Customer cust_objs[]=new Customer[100];
	static int cust_index=-1;
	static Scanner sc = new Scanner(System.in);
	public static void main(String args[])
	{
		JFrame f1= new JFrame("Inventory Management System"); //creating frame 
		JLabel l1=new JLabel("Welcome to the Inventory Management System"); //creating label
		f1.setVisible(true); //making frame visible
		f1.setSize(1000,1000);//width and height
		f1.setLayout(null); //arranging components
		l1.setBounds(50,25,10000,30); //x,y,width,height
		f1.add(l1); //adding label
		JButton b1,b2,b3;
		b1=new JButton("Admin"); 
		b2=new JButton("Customer"); 
		b3=new JButton("Exit"); 
		b1.setBounds(130,100,100,40);//x, y, width, height  
		b1.setSize(90, 30);
		b2.setBounds(130,150,100,40); 
		b2.setSize(90, 30);
		b3.setBounds(130,200,100,40);  
		b3.setSize(90, 30);
		f1.add(b1);f1.add(b2);f1.add(b3);
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{ 
				JPasswordField passwordField = new JPasswordField(); // to conceal password typed
		        int option = JOptionPane.showConfirmDialog(f1, passwordField, "Enter Password", JOptionPane.OK_CANCEL_OPTION);
		        if (option == JOptionPane.OK_OPTION) 
		        {
		            String pswd = new String(passwordField.getPassword()); // converting to string because getPassword() returns array of chars
		            if (pswd.equals("JAVA IS COOL")) 
		                admin();
		            else
		                JOptionPane.showMessageDialog(f1, "Incorrect password!");
		        } 
		    }
		});
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				JTextField idField = new JTextField(), nameField = new JTextField();
                JLabel idLabel = new JLabel("ID:"),nameLabel = new JLabel("Name:");
                JPanel p = new JPanel(); 
                p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
                p.add(idLabel);p.add(idField);
                p.add(nameLabel);p.add(nameField);
                int option = JOptionPane.showConfirmDialog(f1, p, "Enter Membership ID and Name", JOptionPane.OK_CANCEL_OPTION); //  ok cancel
                if (option == JOptionPane.OK_OPTION) 
                {
    				int mem_index=-1;
    				String mem_id=idField.getText(), mem_name=nameField.getText();
    				for(int i=0;i<=cust_index;i++)
    				{
    					if(mem_id.equals(cust_objs[i].id) && mem_name.equals(cust_objs[i].name))
    					{
    						mem_index=i;
    						cust_objs[mem_index].manage_product(cust_objs[mem_index]);
    						break;
    					}
    				}
    				if(mem_index==-1)
    					JOptionPane.showMessageDialog(f1, "Incorrect ID or Name","Alert",JOptionPane.WARNING_MESSAGE);
                }
			}
		});
		b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) 
            {  //displaying confirmation block
                int option = JOptionPane.showConfirmDialog(f1, "Are you sure you want to exit?");
                if (option == JOptionPane.YES_OPTION) // yes no cancel
                    f1.dispose(); // for closing frame
            }
        });
	}
	static void admin()
	{
		JFrame f2= new JFrame("Admin"); 
		JLabel l2=new JLabel(); 
		f2.setVisible(true); 
		f2.setSize(1000,1000);
		f2.setLayout(null);
		l2.setText("Admin Menu"); 
		l2.setBounds(50,25,10000,30); 
		f2.add(l2); 
		JButton b1,b2,b3;
		b1=new JButton("Add Customer Membership"); 
		b2=new JButton("Remove Customer Membership");  
		b3=new JButton("Return Back"); 
		b1.setBounds(130,100,100,40);  
		b1.setSize(250, 30);
		b2.setBounds(130,150,100,40); 
		b2.setSize(250, 30);
		b3.setBounds(130,200,100,40);  
		b3.setSize(250, 30);
		b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) 
            { 
            	JTextField idField = new JTextField(), nameField = new JTextField();
                JLabel idLabel = new JLabel("ID:"),nameLabel = new JLabel("Name:");
                JPanel p = new JPanel(); //creating panel
                p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS)); //BoxLayout arranges components in single row/col, Y_AXIS arranges in column
                p.add(idLabel);p.add(idField);
                p.add(nameLabel);p.add(nameField);
                int option = JOptionPane.showConfirmDialog(f2, p, "Enter Details", JOptionPane.OK_CANCEL_OPTION);
                if (option == JOptionPane.OK_OPTION) 
                {
                	int flag=0;
                    String new_id=idField.getText();
					if(cust_index>-1)
					{
						for(int j=0;j<=cust_index;j++)
						{
							if(cust_objs[j].id.equals(new_id))
							{
								JOptionPane.showMessageDialog(f2, "Given ID Already exists","Alert",JOptionPane.WARNING_MESSAGE);
								flag=1;
								break;
							}
						}
					}
					if(flag==0)
					{
						cust_index++;
						cust_objs[cust_index]=new Customer(new_id,nameField.getText());
						JOptionPane.showMessageDialog(f2, "Membership created");
					}
                }
            }
        });
		b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) 
            { 
            	if(cust_index==-1)
            		JOptionPane.showMessageDialog(f2, "There are no customers to be removed","Alert",JOptionPane.WARNING_MESSAGE);
            	else
            	{
            		JTextField idField = new JTextField();
                	JLabel idLabel = new JLabel("ID:");
                	JPanel p = new JPanel(); 
                	p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
                	p.add(idLabel);p.add(idField);
                	int option = JOptionPane.showConfirmDialog(f2, p, "Enter ID to be removed", JOptionPane.OK_CANCEL_OPTION);
                    if (option == JOptionPane.OK_OPTION) 
                    {
    					int rem_index=-1;
    					String rem_id=idField.getText();
    					for(int i=0;i<=cust_index;i++)
    					{
    						if(rem_id.equals(cust_objs[i].id))
    						{
    							rem_index=i;
    							for(int j=rem_index;j<cust_index;j++)
    								cust_objs[j]=cust_objs[j+1];
    							cust_objs[cust_index]=null;
    							cust_index--;
    							JOptionPane.showMessageDialog(f2, "Membership removed");
    							break;
    						}
    					}
    					if(rem_index==-1)
    						JOptionPane.showMessageDialog(f2, "Given ID does not exist","Alert",JOptionPane.WARNING_MESSAGE);
                    }
            	}
            	
            }
		});
		b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	f2.dispose(); 
            }
        });
		f2.add(b1);f2.add(b2);f2.add(b3);
	}
}
