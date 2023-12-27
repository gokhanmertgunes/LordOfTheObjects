package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import SysAndMain.CharacterSys;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SearchFrame extends JFrame {

	private JPanel contentPane;
	MainFrame main = null;
	JComboBox comboBox = null;
	
	/**
	 * Create the frame.
	 */
	public SearchFrame(JFrame jr) {
		main = (MainFrame)jr;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 310);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		comboBox = new JComboBox();
		comboBox.setBounds(72, 21, 137, 22);
		contentPane.add(comboBox);
		
		
		JLabel nameLabel = new JLabel("Names:");
		nameLabel.setBounds(10, 25, 70, 14);
		contentPane.add(nameLabel);
		
		JButton searchButton = new JButton("Search");
		searchButton.setBounds(231, 21, 89, 23);
		contentPane.add(searchButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 70, 404, 176);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JButton closeButton = new JButton("Close");
		closeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.setVisible(true);
				dispose();
			}
		});
		closeButton.setBounds(335, 21, 89, 23);
		contentPane.add(closeButton);
		
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText(CharacterSys.search(comboBox.getSelectedItem().toString()).toString());
			}
		});
	}

	public JComboBox getComboBox() {
		return comboBox;
	}
	
	
}
