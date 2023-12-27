package GUI;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import SysAndMain.CharacterSys;

import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JTextArea;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	JButton deleteButton;
	AddFrame add = new AddFrame(this);
	WarFrame war = new WarFrame(this);
	SearchFrame search = new SearchFrame(this);
	DeleteFrame delete = new DeleteFrame(this);
	private final ButtonGroup buttonGroup = new ButtonGroup();
	ImageIcon happygandalf = new ImageIcon("gandalfmutlu.jpg");
	ImageIcon sadgandalf = new ImageIcon("gandalfuzgun.jpg");

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 607, 371);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JRadioButton addRBtn = new JRadioButton("Add Manual");
		buttonGroup.add(addRBtn);
		addRBtn.setBounds(25, 100, 111, 23);
		contentPane.add(addRBtn);
		
		JRadioButton randomRBtn = new JRadioButton("Random");
		buttonGroup.add(randomRBtn);
		randomRBtn.setBounds(138, 100, 90, 23);
		contentPane.add(randomRBtn);
		
		JButton addButton = new JButton("Add");
		addButton.setBounds(75, 130, 89, 23);
		contentPane.add(addButton);
		
		JLabel lblNewLabel = new JLabel("Add own hero or create randomly?");
		lblNewLabel.setBounds(21, 70, 218, 23);
		contentPane.add(lblNewLabel);
		
		JLabel lblSearchCharacterFrom = new JLabel("Search character from Lord Of The Objects set");
		lblSearchCharacterFrom.setBounds(10, 175, 331, 23);
		contentPane.add(lblSearchCharacterFrom);
		
		JButton searchButton = new JButton("Search");
		searchButton.setBounds(75, 209, 89, 23);
		contentPane.add(searchButton);
		
		JLabel lblYouCanDelete = new JLabel("You can delete one of your enemies(Choose wisely)");
		lblYouCanDelete.setBounds(10, 264, 331, 23);
		contentPane.add(lblYouCanDelete);
		
		deleteButton = new JButton("Delete");
		deleteButton.setBounds(75, 298, 89, 23);
		contentPane.add(deleteButton);
		
		JButton startWarButton = new JButton("Start War");
		startWarButton.setBounds(385, 251, 121, 48);
		contentPane.add(startWarButton);
		
		JLabel image = new JLabel("");
		image.setIcon(resizeIcon(happygandalf,150,150));
		image.setBounds(370, 46, 150, 138);
		contentPane.add(image);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 11, 287, 48);
		contentPane.add(scrollPane);
		
		JTextArea output = new JTextArea();
		output.setText("Welcome to the Lord of the Objects World!");
		scrollPane.setViewportView(output);
		
		//actions
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(addRBtn.isSelected() || randomRBtn.isSelected()) {
				add.setVisible(true);
				setVisible(false);
				}
				else {
					output.setText("Please make your choice about Hero.");
					image.setIcon(resizeIcon(sadgandalf,150,150));
				}
			}
		});
		
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete.getComboBox().setModel(new DefaultComboBoxModel(CharacterSys.getEnemyNames()));
				delete.setVisible(true);
				setVisible(false);
			}
		});
		
		startWarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(addRBtn.isSelected() || randomRBtn.isSelected()) {
				CharacterSys.createBattleField();
				war.setVisible(true);
				setVisible(false);
				}
				else {
					image.setIcon(resizeIcon(sadgandalf,150,150));
					output.setText("Please make your hero decision.");
				}
			}
		});
		
		addRBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addButton.setVisible(true);
			}
		});
		
		randomRBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addButton.setVisible(false);
			}
		});
	
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				search.getComboBox().setModel(new DefaultComboBoxModel(CharacterSys.getCharacterNames()));
				search.setVisible(true);
				setVisible(false);
			}
		});
	}
	
	private static Icon resizeIcon(ImageIcon icon, int resizedWidth, int resizedHeight) {
	    Image img = icon.getImage();  
	    Image resizedImage = img.getScaledInstance(resizedWidth, resizedHeight,  java.awt.Image.SCALE_SMOOTH);  
	    return new ImageIcon(resizedImage);
	}

	public JButton getDeleteButton() {
		return deleteButton;
	}
	
	public ArrayList<String> getOutput() {
		ArrayList<String> out = CharacterSys.startWar();
		return(out);
	}
	
}
