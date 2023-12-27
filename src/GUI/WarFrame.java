package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import SysAndMain.CharacterSys;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class WarFrame extends JFrame {

	private JPanel contentPane;
	MainFrame main = null;
	
	ArrayList<String> out = null;
	int i = 0;

	/**
	 * Create the frame.
	 */
	public WarFrame(JFrame jr) {
		

		main = (MainFrame)jr;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 684, 429);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 41, 412, 312);
		contentPane.add(scrollPane);
		
		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		scrollPane.setViewportView(textPane);
		textPane.setText("Press enter to start and continue the battle");
		
		JButton closeButton = new JButton("Close");
		closeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.setVisible(true);
				setVisible(false);
			}
		});
		closeButton.setBounds(516, 263, 89, 23);
		contentPane.add(closeButton);
		
		JButton displayButton = new JButton("Display");
		displayButton.setBounds(516, 149, 89, 23);
		contentPane.add(displayButton);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Health", "Name"}));
		comboBox.setBounds(558, 67, 76, 22);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel = new JLabel("Display by:");
		lblNewLabel.setBounds(469, 71, 79, 14);
		contentPane.add(lblNewLabel);
		
		lblNewLabel.setVisible(false);
		comboBox.setVisible(false);
		displayButton.setVisible(false);
		
		//actions
		displayButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox.getSelectedItem().toString().equals("Health"))
					textPane.setText(CharacterSys.displayByHealth());
				else
					textPane.setText(CharacterSys.displayByName());
				
				
			}
		});
		
		textPane.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER){
					if(i == 0) {
						out = main.getOutput();
						textPane.setText(out.get(i) + "\n");
						i++;
					}
					else if(i < out.size()) {
						textPane.setText(textPane.getText() + out.get(i) + "\n");
						i++;
						if(i == out.size()) {
							lblNewLabel.setVisible(true);
							comboBox.setVisible(true);
							displayButton.setVisible(true);
						}
					}
				}
			}
		});
	}
}
