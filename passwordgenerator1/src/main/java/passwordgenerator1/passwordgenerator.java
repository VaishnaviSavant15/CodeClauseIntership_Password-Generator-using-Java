package passwordgenerator1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.SecureRandom;
import java.util.Scanner;


public class passwordgenerator extends JFrame{
	private JTextField passwordField;
	private JButton generateButton;
	private JComboBox<Integer>lengthComboBox;
	
	private static final String LOWERCASE_CHARACTERS="abcdefghijklmnopqrstuvwxyz";
	private static final String UPPERCASE_CHARACTERS="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private static final String Numbers="0123456789";
	private static final String SPECIAL_CHARACTERS="+_-*&^%$#@";
	
	
	public  passwordgenerator() {
	setTitle("password generator");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setLayout(new FlowLayout());
	passwordField = new JTextField(20);
	passwordField.setEditable(false);
	generateButton = new JButton("Generate");
	generateButton.setPreferredSize(new Dimension(150,150));
	JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
	buttonPanel.setPreferredSize(new Dimension(300,30));
	add(buttonPanel,BorderLayout.CENTER);
	
	lengthComboBox = new JComboBox<>();
	lengthComboBox.addItem(6);
	lengthComboBox .addItem(10);
	lengthComboBox .addItem(12);
	
	generateButton.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			int passwordlength = (int) lengthComboBox.getSelectedItem();
			String password = passwordgenerator(passwordlength);
			passwordField.setText(password);
			
			
		}
		
	});
	add(lengthComboBox);
	add(generateButton);
	add(passwordField);
	
	pack();
	setSize(400,300);
	setLocationRelativeTo(null);
	setVisible(true);
	
}
	private String passwordgenerator(int length) {
		StringBuilder password = new StringBuilder();
		SecureRandom random = new SecureRandom();
		StringBuilder characters = new StringBuilder();
		characters.append(LOWERCASE_CHARACTERS);
		characters.append(UPPERCASE_CHARACTERS);
		characters.append(Numbers);
		characters.append(SPECIAL_CHARACTERS);
		
		for(int i = 0;i <length;i++) {
			int randomIndex = random.nextInt(characters.length());
			password.append(characters.charAt(randomIndex));
		}
		return password.toString();
	}
         public static void main(String[] args) {
        	 SwingUtilities.invokeLater(new Runnable() {

				@Override
				public void run() {
					// TODO Auto-generated method stub
					new passwordgenerator ();
				}
		});
		
	}
}
