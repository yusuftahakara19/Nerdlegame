package YusufTahaKara;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Color;





public class FrmTest extends JFrame {

	private JPanel contentPane;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmTest frame = new FrmTest();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public FrmTest() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 536, 377);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(30, 129, 459, 29);
		contentPane.add(lblNewLabel);

		
		
		FrmYeniOyun frm = new FrmYeniOyun();
		JButton btnNewButton = new JButton("Denklem Üret");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			lblNewLabel.setText(frm.generateEquation()); 
		
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(116, 227, 297, 51);
		contentPane.add(btnNewButton);
		
		JButton btnAnaMenu = new JButton("Ana Menü");
		btnAnaMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ana_Menu frm = new Ana_Menu();
				frm.setVisible(true);
				dispose();
			}
		});
		btnAnaMenu.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnAnaMenu.setBounds(411, 10, 101, 50);
		contentPane.add(btnAnaMenu);
		
		JLabel lblNewLabel_1 = new JLabel("19011021 - Yusuf Taha Kara");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 8));
		lblNewLabel_1.setForeground(Color.GRAY);
		lblNewLabel_1.setBounds(315, 317, 197, 13);
		contentPane.add(lblNewLabel_1);
		

	}
}
