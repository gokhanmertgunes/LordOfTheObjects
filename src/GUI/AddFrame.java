package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import HasARelationship.Weapon;
import SysAndMain.CharacterSys;

import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddFrame extends JFrame {

	private JPanel contentPane;
	MainFrame main = null;
	private JTextField nameTxt;
	private JTextField ageTxt;
	private JTextField healthTxt;
	private JTextField kingdomTxt;
	private JTextField damageTxt;
	private JTextField herotypeTxt;
	

	/**
	 * Create the frame.
	 */
	public AddFrame(JFrame jr) {
		main = (MainFrame)jr;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(26, 39, 481, 349);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(82, 41, 73, 14);
		contentPane.add(lblNewLabel);
		
		nameTxt = new JTextField();
		nameTxt.setBounds(221, 41, 155, 20);
		contentPane.add(nameTxt);
		nameTxt.setColumns(10);
		
		JLabel lblAge = new JLabel("Age:");
		lblAge.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAge.setBounds(82, 69, 73, 14);
		contentPane.add(lblAge);
		
		ageTxt = new JTextField();
		ageTxt.setColumns(10);
		ageTxt.setBounds(221, 69, 155, 20);
		contentPane.add(ageTxt);
		
		JLabel lblNewLabel_1_1 = new JLabel("Health:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1_1.setBounds(82, 129, 73, 14);
		contentPane.add(lblNewLabel_1_1);
		
		healthTxt = new JTextField();
		healthTxt.setColumns(10);
		healthTxt.setBounds(221, 129, 155, 20);
		contentPane.add(healthTxt);
		
		kingdomTxt = new JTextField();
		kingdomTxt.setColumns(10);
		kingdomTxt.setBounds(221, 101, 155, 20);
		contentPane.add(kingdomTxt);
		
		JLabel lblKingdom = new JLabel("Kingdom:");
		lblKingdom.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblKingdom.setBounds(82, 101, 73, 14);
		contentPane.add(lblKingdom);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Damage:");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1_1_1.setBounds(82, 160, 73, 14);
		contentPane.add(lblNewLabel_1_1_1);
		
		damageTxt = new JTextField();
		damageTxt.setColumns(10);
		damageTxt.setBounds(221, 160, 155, 20);
		contentPane.add(damageTxt);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Hero Type:");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1_1_1_1.setBounds(82, 193, 86, 14);
		contentPane.add(lblNewLabel_1_1_1_1);
		
		herotypeTxt = new JTextField();
		herotypeTxt.setColumns(10);
		herotypeTxt.setBounds(221, 193, 155, 20);
		contentPane.add(herotypeTxt);
		
		JLabel outputLabel = new JLabel("");
		outputLabel.setBounds(82, 237, 294, 14);
		contentPane.add(outputLabel);
		
		JButton addButton = new JButton("Add");
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name, kingdom, heroType;
				int age, health,damage;
				
				if(nameTxt.getText().isEmpty() || ageTxt.getText().isEmpty() || kingdomTxt.getText().isEmpty() || herotypeTxt.getText().isEmpty() || healthTxt.getText().isEmpty() || damageTxt.getText().isEmpty())
					outputLabel.setText("Please fill all fields!");
				else {
					name = nameTxt.getText();
					age = Integer.parseInt(ageTxt.getText());
					kingdom = kingdomTxt.getText();
					heroType = herotypeTxt.getText();
					health = Integer.parseInt(healthTxt.getText());
					damage = Integer.parseInt(damageTxt.getText());
					
				
					
					if(CharacterSys.addHero(name, age, kingdom, health, damage, heroType)) 
						outputLabel.setText("Hero is added!");
					
					else
						outputLabel.setText("Hero could not be added, please try again!");
					}
				}
		});
		addButton.setBounds(82, 276, 120, 23);
		contentPane.add(addButton);
		
		JButton closeButton = new JButton("Close");
		closeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.setVisible(true);
				dispose();
			}
		});
		closeButton.setBounds(256, 276, 120, 23);
		contentPane.add(closeButton);
	}
}
