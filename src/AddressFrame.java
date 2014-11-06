import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JList;
import javax.swing.DefaultListModel;



public class AddressFrame extends JFrame implements ActionListener {
	
	static AddressBook abook = new AddressBook("Address Book");
	static AddressFrame a;
	static JLabel text;
	static JMenuBar menuBar;
	static JMenu buddyBar, bookBar, fileBar;
	static JMenuItem addBuddy,saveList, newList, removeBuddy, editBuddy;
	static JList<BuddyInfo> list;
	static DefaultListModel<BuddyInfo> model;
	
	
	public AddressFrame(String s){
		this.setLayout(new BorderLayout());
		this.setSize(400,200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final ArrayList<AddressBook> alist= new ArrayList<AddressBook>();
		alist.add(abook);
		//System.out.println(buddy.getInfo());
		
		//Create the menu bar.
		menuBar = new JMenuBar();

		//Build the first menu.
		fileBar = new JMenu("File Options");
		fileBar.getAccessibleContext().setAccessibleDescription("Accessing AddressBook Saving");
		menuBar.add(fileBar);
		
		bookBar = new JMenu("Address Book Options");
		bookBar.getAccessibleContext().setAccessibleDescription("AddressBook Operations");
		menuBar.add(bookBar);
		
		buddyBar = new JMenu("Buddy Options");
		buddyBar.getAccessibleContext().setAccessibleDescription("Buddy Operations");
		menuBar.add(buddyBar);

		addBuddy = new JMenuItem("Add Buddy");
		addBuddy.getAccessibleContext().setAccessibleDescription("Adds a Buddy to the list");
		bookBar.add(addBuddy);

		saveList = new JMenuItem("Save Address Book");
		saveList.getAccessibleContext().setAccessibleDescription("Saves the address book");
		fileBar.add(saveList);

		newList = new JMenuItem("New Address Book");
		newList.getAccessibleContext().setAccessibleDescription("Makes a new address book");
		fileBar.add(newList);
		
		removeBuddy = new JMenuItem("Remove A Buddy");
		newList.getAccessibleContext().setAccessibleDescription("Removes a selected buddy");
		buddyBar.add(removeBuddy);
		
		editBuddy = new JMenuItem("Edit A Buddy");
		newList.getAccessibleContext().setAccessibleDescription("Edits a selected buddy");
		buddyBar.add(editBuddy);
		
		
		a= new AddressFrame(abook.getName());
		model = new DefaultListModel<BuddyInfo>();
		list= new JList<BuddyInfo>(model);
		text = new JLabel("Address List.");
		a.setJMenuBar(menuBar);

		newList.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			alist.add(abook);
			String s1 = (String) JOptionPane.showInputDialog("Please Enter Name Of the Address Book: ");
			abook.setName(s1);
			AddressBook a = new AddressBook(s1);
			text.setText("New Address Book Created");
		}
		});
		addBuddy.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String s1 = (String) JOptionPane.showInputDialog("Please Enter a Name: ");
				String s2 = (String) JOptionPane.showInputDialog("Please Enter an Address: ");
				String s3 = (String) JOptionPane.showInputDialog("Please Enter a Phone Number: ");
				
				BuddyInfo buddy = new BuddyInfo(s1,s2,s3);
				abook.addBuddy(buddy);
				model.addElement(buddy);
				text.setText("Buddy Added");
			}
		});
		saveList.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				/*if(abook.size() == 0)
				abook=alist.get(alist.size()-1);
				PrintWriter out = null;
				try {
					out = new PrintWriter(abook.getName()+".txt");
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				out.println(alist.get(abook.size()-1).toString());
				out.close();
				text.setText("Address Book Saved");*/
				
				abook.export(alist);
				
			}
		});
		
		removeBuddy.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(list.getSelectedValue() == null){
					text.setText("You must select a buddy first");
				}
				else{
					abook.addBuddy(list.getSelectedValue());
					model.removeElement(list.getSelectedValue());
					text.setText("Buddy Removed");
				}
			}
		});
		
		editBuddy.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(list.getSelectedValue() == null){
					text.setText("You must select a buddy first, dummie");
				}
				else{
					String s1 = (String) JOptionPane.showInputDialog("Please Enter a Name: ");
					String s2 = (String) JOptionPane.showInputDialog("Please Enter an Address: ");
					String s3 = (String) JOptionPane.showInputDialog("Please Enter a Phone Number: ");
					
					abook.editBuddy(list.getSelectedValue(), s1, s2, s3);
					text.setText("Edit a buddy");
				}
			}
		});
		
		a.add(list,BorderLayout.SOUTH);
		a.add(text,BorderLayout.NORTH);
		a.setVisible(true);
		}
		
		
}
	
	
	







