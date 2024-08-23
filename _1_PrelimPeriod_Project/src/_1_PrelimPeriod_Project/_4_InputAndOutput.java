package _1_PrelimPeriod_Project;

import javax.swing.JOptionPane;

public class _4_InputAndOutput {
	static String name;
	static String course;
	static String section;
	static Long mobileNumber;
	static Short age;

	public static void main(String[] args) {
		name = JOptionPane.showInputDialog("Enter Name: ");
		JOptionPane.showMessageDialog(null, "Hello " + name);
		
		course = JOptionPane.showInputDialog("Enter Course: ");
		JOptionPane.showMessageDialog(null, "Your Course is " + course);
		
		section = JOptionPane.showInputDialog("Enter Section: ");
		JOptionPane.showMessageDialog(null, "Your section is " + section);
		
		mobileNumber = Long.parseLong(JOptionPane.showInputDialog("Enter Mobile Number: "));
		JOptionPane.showMessageDialog(null, "Your mobile number is " + mobileNumber);
		
		age = Short.parseShort(JOptionPane.showInputDialog("Enter Age: "));
		JOptionPane.showMessageDialog(null, "Your age is " +  age);

	}

}
