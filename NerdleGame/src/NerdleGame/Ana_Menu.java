package YusufTahaKara;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;

public class Ana_Menu extends JFrame {

	private JPanel contentPane;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ana_Menu frame = new Ana_Menu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public Ana_Menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setTitle("Ana Menü");
		
		setBounds(100, 100, 583, 381);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("İSTATİSTİKLER");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(47, 38, 122, 27);
		contentPane.add(lblNewLabel);
		
		JLabel lblYaridaBirakilan = new JLabel("Kaç oyun yarıda bırakılmış :");
		lblYaridaBirakilan.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblYaridaBirakilan.setBounds(47, 61, 243, 36);
		contentPane.add(lblYaridaBirakilan);
		
		JLabel lblBasarisiz = new JLabel("Kaç oyun başarısızlıkla sonuçlanmış :");
		lblBasarisiz.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBasarisiz.setBounds(47, 88, 272, 36);
		contentPane.add(lblBasarisiz);
		
		JLabel lblBasarili = new JLabel("Kaç oyun başarıyla tamamlanmış :");
		lblBasarili.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBasarili.setBounds(47, 117, 272, 36);
		contentPane.add(lblBasarili);
		
		JLabel lblBasariliOrtSatir = new JLabel("Başarıyla tamamlananlar ortalama kaç satırda tamamlanmış :");
		lblBasariliOrtSatir.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBasariliOrtSatir.setBounds(47, 145, 420, 36);
		contentPane.add(lblBasariliOrtSatir);
		
		JLabel lblBasariliOrtSure = new JLabel("Başarıyla tamamlananlar ortalama ne kadar sürede tamamlanmış :");
		lblBasariliOrtSure.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBasariliOrtSure.setBounds(47, 175, 466, 36);
		contentPane.add(lblBasariliOrtSure);
		
		JButton btnNewButton = new JButton("Oyna");

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmYeniOyun frm = new FrmYeniOyun();
		       
				frm.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(105, 221, 142, 58);
		contentPane.add(btnNewButton);
		
		JButton btnTest = new JButton("Test");
		btnTest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmTest frm = new FrmTest();
				frm.setVisible(true);
				dispose();
			}
		});
		btnTest.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnTest.setBounds(295, 221, 142, 58);
		contentPane.add(btnTest);
		
		JLabel lblNewLabel_2 = new JLabel("19011021 - Yusuf Taha Kara");
		lblNewLabel_2.setForeground(Color.GRAY);
		lblNewLabel_2.setBounds(362, 331, 197, 13);
		contentPane.add(lblNewLabel_2);
		
		JButton btnIstatistikleriGetir = new JButton("İstatistikleri Getir");
		btnIstatistikleriGetir.addActionListener(new ActionListener() {
			@SuppressWarnings("unchecked")
			public void actionPerformed(ActionEvent e) {
				
					try {
						FileInputStream fileIn = new FileInputStream("istatistikler.txt");
						ObjectInputStream in = new ObjectInputStream(fileIn);

						Istatistik ist = (Istatistik) in.readObject(); 
						lblBasarili.setText("Kaç oyun başarıyla tamamlanmış : "+ Integer.toString(ist.getBasariliOyunAdet()));
						lblYaridaBirakilan.setText("Kaç oyun yarıda bırakılmış : "+ Integer.toString(ist.getYaridaBirakilan()));
						lblBasarisiz.setText("Kaç oyun başarısızlıkla sonuçlanmış : "+ Integer.toString(ist.getBasarisizOyunAdet()));
						lblBasariliOrtSatir.setText("Başarıyla tamamlananlar ortalama kaç satırda tamamlanmış : "+ Double.toString(ist.getBasarililarOrtKacSatirdaTamamlanmis()));
						lblBasariliOrtSure.setText("Başarıyla tamamlananlar ortalama ne kadar sürede tamamlanmış : "+ Double.toString(ist.getBasarililarOrtSure()));

						in.close();
						fileIn.close();
						
					} catch (IOException i) {
						i.printStackTrace();
						return ;
					} catch (ClassNotFoundException c) {
						System.out.println("Istatistik sınıfı bulunamadi...");
						c.printStackTrace();
						return ;
					}
			}
			
		});
		
		btnIstatistikleriGetir.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnIstatistikleriGetir.setBounds(47, 10, 217, 27);
		contentPane.add(btnIstatistikleriGetir);
		
		JButton btnNewButton_1 = new JButton("X");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBackground(Color.RED);
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnNewButton_1.setBounds(513, 10, 46, 36);
		contentPane.add(btnNewButton_1);
	}
}
