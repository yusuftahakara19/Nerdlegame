package YusufTahaKara;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.Font;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.beans.VetoableChangeListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JLabel;

public class FrmYeniOyun extends JFrame {

	private JPanel contentPane;
	private JTextField txtBox1_1;
	private JTextField txtBox1_2;
	private JTextField txtBox1_3;
	private JTextField txtBox1_6;
	private JTextField txtBox1_5;
	private JTextField txtBox1_4;
	private JTextField txtBox1_8;
	private JTextField txtBox1_7;
	private JTextField secilen ;
	private JTextField onceki ;
	private JTextField txtBox2_1;
	private JTextField txtBox2_2;
	private JTextField txtBox2_3;
	private JTextField txtBox2_4;
	private JTextField txtBox2_5;
	private JTextField txtBox2_6;
	private JTextField txtBox2_7;
	private JTextField txtBox2_8;
	private JTextField txtBox3_1;
	private JTextField txtBox3_2;
	private JTextField txtBox3_3;
	private JTextField txtBox3_4;
	private JTextField txtBox3_5;
	private JTextField txtBox3_6;
	private JTextField txtBox3_7;
	private JTextField txtBox3_8;
	private JTextField txtBox4_1;
	private JTextField txtBox4_2;
	private JTextField txtBox4_3;
	private JTextField txtBox4_4;
	private JTextField txtBox4_5;
	private JTextField txtBox4_6;
	private JTextField txtBox4_7;
	private JTextField txtBox4_8;
	private JTextField txtBox5_1;
	private JTextField txtBox5_2;
	private JTextField txtBox5_3;
	private JTextField txtBox5_4;
	private JTextField txtBox5_5;
	private JTextField txtBox5_6;
	private JTextField txtBox5_7;
	private JTextField txtBox5_8;
	private JTextField txtBox6_1;
	private JTextField txtBox6_2;
	private JTextField txtBox6_3;
	private JTextField txtBox6_4;
	private JTextField txtBox6_5;
	private JTextField txtBox6_6;
	private JTextField txtBox6_7;
	private JTextField txtBox6_8;
	private JTextField txtBox1_9;
	private JTextField txtBox2_9;
	private JTextField txtBox3_9;
	private JTextField txtBox4_9;
	private JTextField txtBox5_9;
	private JTextField txtBox6_9;
	private JTextField txtBoxDenklem1;
	private JTextField txtBoxDenklem2;
	private JTextField txtBoxDenklem3;
	private JTextField txtBoxDenklem4;
	private JTextField txtBoxDenklem5;
	private JTextField txtBoxDenklem6;
	private JTextField txtBoxDenklem7;
	private JTextField txtBoxDenklem8;
	private JTextField txtBoxDenklem9;
	private JLabel lblHata;
	private JLabel lblBasarili;
	private JLabel lblNewLabel;
	private JLabel lblSure;
	private static int saniye;
	private JButton btnDevamEt;
	private static int sayac;
	private static Timer myTimer;


	
	public Istatistik istatistikGetir() {
		try {
			
			FileInputStream fileIn = new FileInputStream("istatistikler.txt");
			ObjectInputStream in = new ObjectInputStream(fileIn);

			 Istatistik ist = (Istatistik) in.readObject();
			 return ist;
		} catch (IOException i) {
			i.printStackTrace();
			return null;
		} catch (ClassNotFoundException c) {
			System.out.println("Istatistik sınıfı bulunamadı");
			c.printStackTrace();
			return null;
		}
	}
	
	
	public void sayacCalistir(int baslangic) {
		
		
		 sayac =baslangic;
	        TimerTask gorev = new TimerTask() {
				@Override
				public void run() {
					sayac++;
					lblSure.setText(sayac+"");
				}
	        	
	        };
	        
	        myTimer.schedule(gorev, 0,1000);
	}
	
	public boolean istatistikGuncelle(int yaridaBirakilan,int basarisizOyunAdet,int basariliOyunAdet, double basarililarOrtKacSatirdaTamamlanmis,double basarililarOrtSure) {
		try {
			try {
				File myObj = new File("istatistikler.txt");
				myObj.delete();

				File myObj2 = new File("istatistikler.txt");
				if (myObj2.createNewFile()) {
	
				} else {
	
				}
			} catch (IOException a) {
				System.out.println("An error occurred.");
				a.printStackTrace();
			}

			Istatistik e = new Istatistik(yaridaBirakilan,basarisizOyunAdet,basariliOyunAdet,basarililarOrtKacSatirdaTamamlanmis,basarililarOrtSure);
			FileOutputStream fileOut = new FileOutputStream("istatistikler.txt");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(e);
			out.close();
			fileOut.close();
            return true;
		} catch (IOException i) {
			i.printStackTrace();
			return false;
		}
	}
	
	  public boolean sonraBitirClassDosyaOku(){
		  try {
				FileInputStream fileIn = new FileInputStream("sonraBitir.txt");
				ObjectInputStream in = new ObjectInputStream(fileIn);

				 SonraBitirClass ist = (SonraBitirClass) in.readObject(); 
					in.close();
					fileIn.close();
					
					return true;
			} catch (IOException i) {
				i.printStackTrace();
				return false;
			} catch (ClassNotFoundException c) {
				System.out.println("Employee class not found");
				c.printStackTrace();
				return false;
			}
	
	  }
	
	public String generateEquation() {
		try {
			String denklem = "";
			int[] numbers = { 0,1,2,3,4,5,6,7,8,9};
			String [] operatorler = {"+","-","*","/"};
			int[] uzunluk = {2,3};
			 Random rand = new Random();	  
		        int rand1= rand.nextInt(2);
		        int denklem_uzunlugu = uzunluk[rand1];
		        
	        for (int i = 0; i < denklem_uzunlugu; i++) {
	        	 rand1= rand.nextInt(10);
	        	denklem += numbers[rand1]; 
	        	denklem +=" ";
	        	 rand1= rand.nextInt(4);
	        	denklem += operatorler[rand1];
	        	denklem +=" ";
	        }
	       
	        rand1= rand.nextInt(10);
	    	denklem += numbers[rand1];
	    	String denklemDizi[] = denklem.split(" "); 
	    	
	    	
	    	// İşlem önceliğinden dolayı öncelikle * ve / işlemleri yapılmakta
		      for (int i = 0; i < denklemDizi.length; i++) {
		           if( denklemDizi[i].equals("+")==true || denklemDizi[i].equals("-")==true || denklemDizi[i].equals("/")==true || denklemDizi[i].equals("*")==true ) {
		        	   
		           }else if(denklemDizi[i].equals("NULL")==false) {
		        	   if(i!=denklemDizi.length-1) {
		        		   if(denklemDizi[i+1].equals("/")==true || denklemDizi[i+1].equals("*")==true ) {
		        			   int a =Integer.parseInt(denklemDizi[i]) ;
		        			   int b = Integer.parseInt(denklemDizi[i+2]);
		        			   String operator2 = denklemDizi[i+1];
		        			   if(operator2.equals("/")==true) {
		        				   // dizide kullanılmayacak yerleri "NULL" değeri ile değiştirdik
		        				   denklemDizi[i] = "NULL";
		        				   denklemDizi[i+1] = "NULL";
		        				   denklemDizi[i+2] = Integer.toString(a/b);
		        				   i=0;
		        			   }
		        				   
		        			   else {
		        				   denklemDizi[i] = "NULL";
		        				   denklemDizi[i+1] = "NULL";
		        				   denklemDizi[i+2] = Integer.toString(a*b);
		        				   i=0;
		        			   }
		        		   }
		        	   }
		        	
		           }
		        }

		     
		       int numberOfNULL = 0;	        
		        for (int i = 0; i < denklemDizi.length; i++) {
		        	if(denklemDizi[i].equals("NULL")== true)
		        		numberOfNULL++;
		        		
		        }
	        int k= 0;
	        		


		      // "NULL"' ları dizimizden çıkartıyoruz
		      List<String> copy = new ArrayList<String>();
		      
		        for (String i : denklemDizi) {
		            if (i.equals("NULL")==false) 
		            	copy.add(i);

		        }
		        
		        String[] denklemDiziYeni = new String[copy.size()];
		        
		        for (int i = 0; i < copy.size(); i++) {
		        	denklemDiziYeni[i] = copy.get(i);
		        }

		      // * ve / işlemlerinden sonra + ve - işlemleri yapılacak
		      for (int i = 0; i < denklemDiziYeni.length; i++) {
		    	  
		    	  if(denklemDiziYeni[i].equals("NULL") == false) {
		    		  if(i!=denklemDiziYeni.length-1) {
		    			  if(denklemDiziYeni[i+1].equals("+")==true || denklemDiziYeni[i+1].equals("-")==true) {
		        			   int a =Integer.parseInt(denklemDiziYeni[i]) ;
		        			   int b = Integer.parseInt(denklemDiziYeni[i+2]);
		        			   String operator2 = denklemDiziYeni[i+1];
		        			   if(operator2.equals("+")==true) {
		        				   denklemDiziYeni[i] = "NULL";
		        				   denklemDiziYeni[i+1] = "NULL";
		        				   denklemDiziYeni[i+2] = Integer.toString(a+b);
		        				   i=0;
		        			   }
		        				   
		        			   else {
		        				   denklemDiziYeni[i] = "NULL";
		        				   denklemDiziYeni[i+1] = "NULL";
		        				   denklemDiziYeni[i+2] = Integer.toString(a-b);
		        				   i=0;
		        			   }
		    			  }
		    		  }
		    	  }
		      }
		      
		      denklem += " =";
		    // sonucun basamak sayısının 1 den fazla olması durumunda her kutucuğa bir rakam gelmesi için 
		   String sonuc =denklemDiziYeni[denklemDiziYeni.length-1];
		   String[] sonucDizi = sonuc.split("");
		   for(int i=0;i<sonucDizi.length;i++) {
			   denklem +=" "+sonucDizi[i];
		   }
		   
	String denklemDiziSon[] = denklem.split(" ");

  int uzunlukDenklem = denklemDiziSon.length;

  if(uzunlukDenklem <=9) {
	  txtBoxDenklem1.setText("");
	  txtBoxDenklem2.setText("");
	  txtBoxDenklem3.setText("");
	  txtBoxDenklem4.setText("");
	  txtBoxDenklem5.setText("");
	  txtBoxDenklem6.setText("");
	  txtBoxDenklem7.setText("");
	  txtBoxDenklem8.setText("");
	  txtBoxDenklem9.setText("");
	  
	  txtBoxDenklem1.setText(denklemDiziSon[0]);
	  txtBoxDenklem2.setText(denklemDiziSon[1]);
	  txtBoxDenklem3.setText(denklemDiziSon[2]);
	  txtBoxDenklem4.setText(denklemDiziSon[3]);
	  txtBoxDenklem5.setText(denklemDiziSon[4]);
	  txtBoxDenklem6.setText(denklemDiziSon[5]);
	  txtBoxDenklem7.setText(denklemDiziSon[6]);
	  if(uzunlukDenklem == 7) {
		  txtBox1_8.setVisible(false);
		  txtBox1_9.setVisible(false);
		  txtBox2_8.setVisible(false);
		  txtBox2_9.setVisible(false);
		  txtBox3_8.setVisible(false);
		  txtBox3_9.setVisible(false);
		  txtBox4_8.setVisible(false);
		  txtBox4_9.setVisible(false);
		  txtBox5_8.setVisible(false);
		  txtBox5_9.setVisible(false);
		  txtBox6_8.setVisible(false);
		  txtBox6_9.setVisible(false);
	  }

	  else if(uzunlukDenklem == 8) {
		  txtBoxDenklem8.setText(denklemDiziSon[7]);
		  txtBox1_8.setVisible(true);
		  txtBox2_8.setVisible(true);
		  txtBox3_8.setVisible(true);
		  txtBox4_8.setVisible(true);
		  txtBox5_8.setVisible(true);
		  txtBox6_8.setVisible(true);
		  
		  txtBox1_9.setVisible(false);
		  txtBox2_9.setVisible(false);
		  txtBox3_9.setVisible(false);
		  txtBox4_9.setVisible(false);
		  txtBox5_9.setVisible(false);
		  txtBox6_9.setVisible(false);
	  }
	  else if(uzunlukDenklem==9) {
		  txtBox1_8.setVisible(true);
		  txtBox2_8.setVisible(true);
		  txtBox3_8.setVisible(true);
		  txtBox4_8.setVisible(true);
		  txtBox5_8.setVisible(true);
		  txtBox6_8.setVisible(true);
		  
		  txtBox1_9.setVisible(true);
		  txtBox2_9.setVisible(true);
		  txtBox3_9.setVisible(true);
		  txtBox4_9.setVisible(true);
		  txtBox5_9.setVisible(true);
		  txtBox6_9.setVisible(true);
		  txtBoxDenklem8.setText(denklemDiziSon[7]);
		  txtBoxDenklem9.setText(denklemDiziSon[8]);
	  }
	   return denklem;
  }
  
  else
	  return generateEquation();
		     
		      
		}catch(Exception e) {
			return generateEquation();
			
		}

	} 
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmYeniOyun frame = new FrmYeniOyun();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	
	public FrmYeniOyun() {
         myTimer = new Timer();
		setFont(new Font("Dialog", Font.PLAIN, 15));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 874, 735);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnBasla = new JButton("YENİ OYUN");

		btnBasla.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnBasla.setBounds(268, 8, 167, 50);
		contentPane.add(btnBasla);
		
		JButton btn2 = new JButton("2");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				secilen.setText("2");
			}
		});
		btn2.setEnabled(false);
		btn2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn2.setBounds(184, 499, 63, 50);
		contentPane.add(btn2);
		
		JButton btn3 = new JButton("3");
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(secilen.isEnabled()==true)
				if(secilen.isEnabled()==true)
				secilen.setText("3");
			}
		});
		btn3.setEnabled(false);
		btn3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn3.setBounds(257, 499, 63, 50);
		contentPane.add(btn3);
		
		JButton btn4 = new JButton("4");
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(secilen.isEnabled()==true)
				secilen.setText("4");
			}
		});
		btn4.setEnabled(false);
		btn4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn4.setBounds(330, 499, 63, 50);
		contentPane.add(btn4);
		
		JButton btn5 = new JButton("5");
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(secilen.isEnabled()==true)
				secilen.setText("5");
			}
		});
		btn5.setEnabled(false);
		btn5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn5.setBounds(403, 499, 63, 50);
		contentPane.add(btn5);
		
		JButton btn6 = new JButton("6");
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(secilen.isEnabled()==true)
				secilen.setText("6");
			}
		});
		btn6.setEnabled(false);
		btn6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn6.setBounds(477, 499, 63, 50);
		contentPane.add(btn6);
		
		JButton btn7 = new JButton("7");
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(secilen.isEnabled()==true)
				secilen.setText("7");
			}
		});
		btn7.setEnabled(false);
		btn7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn7.setBounds(551, 499, 63, 50);
		contentPane.add(btn7);
		
		JButton btn8 = new JButton("8");
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(secilen.isEnabled()==true)
				secilen.setText("8");
			}
		});
		btn8.setEnabled(false);
		btn8.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn8.setBounds(624, 499, 63, 50);
		contentPane.add(btn8);
		
		JButton btnSonraBitir = new JButton("Sonra Bitir");
		btnSonraBitir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myTimer.cancel();
				int sure = Integer.parseInt(lblSure.getText());
				String denklem = txtBoxDenklem1.getText()+" "+txtBoxDenklem2.getText()+" "+txtBoxDenklem3.getText()+" "+txtBoxDenklem4.getText()+" "+txtBoxDenklem5.getText()+" "+txtBoxDenklem6.getText()+ " "+txtBoxDenklem7.getText()+" "+txtBoxDenklem8.getText()+" "+txtBoxDenklem9.getText();
				String birinciSatir =  txtBox1_1.getText()+" "+txtBox1_2.getText()+" "+txtBox1_3.getText()+" "+txtBox1_4.getText()+" "+txtBox1_5.getText()+" "+txtBox1_6.getText()+ " "+txtBox1_7.getText()+" "+txtBox1_8.getText()+" "+txtBox1_9.getText();
				String ikinciSatir =  txtBox2_1.getText()+" "+txtBox2_2.getText()+" "+txtBox2_3.getText()+" "+txtBox2_4.getText()+" "+txtBox2_5.getText()+" "+txtBox2_6.getText()+ " "+txtBox2_7.getText()+" "+txtBox2_8.getText()+" "+txtBox2_9.getText();
				String ucuncuSatir =  txtBox3_1.getText()+" "+txtBox3_2.getText()+" "+txtBox3_3.getText()+" "+txtBox3_4.getText()+" "+txtBox3_5.getText()+" "+txtBox3_6.getText()+ " "+txtBox3_7.getText()+" "+txtBox3_8.getText()+" "+txtBox3_9.getText();
				String dorduncuSatir =  txtBox4_1.getText()+" "+txtBox4_2.getText()+" "+txtBox4_3.getText()+" "+txtBox4_4.getText()+" "+txtBox4_5.getText()+" "+txtBox4_6.getText()+ " "+txtBox4_7.getText()+" "+txtBox4_8.getText()+" "+txtBox4_9.getText();
				String besinciSatir =  txtBox5_1.getText()+" "+txtBox5_2.getText()+" "+txtBox5_3.getText()+" "+txtBox5_4.getText()+" "+txtBox5_5.getText()+" "+txtBox5_6.getText()+ " "+txtBox5_7.getText()+" "+txtBox5_8.getText()+" "+txtBox5_9.getText();
				String altinciSatir =  txtBox6_1.getText()+" "+txtBox6_2.getText()+" "+txtBox6_3.getText()+" "+txtBox6_4.getText()+" "+txtBox6_5.getText()+" "+txtBox6_6.getText()+ " "+txtBox6_7.getText()+" "+txtBox6_8.getText()+" "+txtBox6_9.getText();


				try {
					try {
						File myObj = new File("sonraBitir.txt");
						myObj.delete();

						File myObj2 = new File("sonraBitir.txt");
						if (myObj2.createNewFile()) {
			
						} else {
			
						}
					} catch (IOException a) {
						System.out.println("An error occurred.");
						a.printStackTrace();
					}
				
                    // SonraBitirClass 'tan bir nesne üretip gerekli bilgiler atandıktan sonra dosyaya bilgiler kaydediliyor.
					SonraBitirClass sonraBitir = new SonraBitirClass(sure,denklem,birinciSatir,ikinciSatir,ucuncuSatir,dorduncuSatir,besinciSatir,altinciSatir);
					FileOutputStream fileOut = new FileOutputStream("sonraBitir.txt");
					ObjectOutputStream out = new ObjectOutputStream(fileOut);
					out.writeObject(sonraBitir);
					out.close();
					fileOut.close();
					
				} catch (IOException i) {
					i.printStackTrace();
				}
				
				// istatistik bilgilerinde yarıda bırakılan oyun sayısı güncelleniyor
				Istatistik ist = istatistikGetir();
                int yaridaBirakilan = ist.getYaridaBirakilan();
                yaridaBirakilan++;
	    
	        	istatistikGuncelle(yaridaBirakilan,ist.getBasarisizOyunAdet(),ist.getBasariliOyunAdet(),ist.getBasarililarOrtKacSatirdaTamamlanmis(),ist.getBasarililarOrtSure());
				
				
				Ana_Menu frm = new Ana_Menu();
				frm.setVisible(true);
				dispose();
			}
		});
		btnSonraBitir.setEnabled(false);
		btnSonraBitir.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSonraBitir.setBounds(551, 620, 181, 50);
		contentPane.add(btnSonraBitir);
		
		JButton btnSil = new JButton("Sil");
		btnSil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(secilen.isEnabled()==true)
					onceki.setText("");
			}
		});
		btnSil.setEnabled(false);
		btnSil.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSil.setBounds(299, 620, 209, 50);
		contentPane.add(btnSil);
		
		JButton btnTahminEt = new JButton("Tahmin Et");
		btnTahminEt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblHata.setVisible(false);
				int sure;
				int basariliOlunanSatir;
				int basariliKutuSayisi = 0;
				int denkleminUzunlugu = 7;
				String denklem2 = "";
				int hangiSatirdayiz = 0;
				if(txtBox1_1.isEnabled()==true)
					hangiSatirdayiz =1;
				else if(txtBox2_1.isEnabled() == true)
					hangiSatirdayiz =2;
				else if(txtBox3_1.isEnabled() == true)
					hangiSatirdayiz =3;
				else if(txtBox4_1.isEnabled() == true)
					hangiSatirdayiz =4;
				else if(txtBox5_1.isEnabled() == true)
					hangiSatirdayiz =5;
				else if(txtBox6_1.isEnabled() == true)
					hangiSatirdayiz =6;

		   

		        
				String[] denklemDizi = new String[9];
				denklemDizi[0] = txtBoxDenklem1.getText();
				denklemDizi[1] =  txtBoxDenklem2.getText();
				denklemDizi[2] =  txtBoxDenklem3.getText();
				denklemDizi[3] =  txtBoxDenklem4.getText();
				denklemDizi[4] =  txtBoxDenklem5.getText();
				denklemDizi[5] =  txtBoxDenklem6.getText();
				denklemDizi[6] =  txtBoxDenklem7.getText();
				denklemDizi[7] =  txtBoxDenklem8.getText();
				denklemDizi[8] =  txtBoxDenklem9.getText();
				String denklem = denklemDizi.toString();
				
		        if(hangiSatirdayiz==1) {
		        	
		        	denklem2+=txtBox1_1.getText();
		        	denklem2+=" "+txtBox1_2.getText();
		        	denklem2+=" "+txtBox1_3.getText();
		        	denklem2+=" "+txtBox1_4.getText();
		        	denklem2+=" "+txtBox1_5.getText();
		        	denklem2+=" "+txtBox1_6.getText();
		        	denklem2+=" "+txtBox1_7.getText();	
		        	if(txtBox1_8.isVisible()==true)
		            	denklem2+=" "+txtBox1_8.getText();
		        	if(txtBox1_9.isVisible()==true)
		            	denklem2+=" "+txtBox1_9.getText();

		        	}
		        else if(hangiSatirdayiz==2) {
		        	denklem2+=txtBox2_1.getText();
		        	denklem2+=" "+txtBox2_2.getText();
		        	denklem2+=" "+txtBox2_3.getText();
		        	denklem2+=" "+txtBox2_4.getText();
		        	denklem2+=" "+txtBox2_5.getText();
		        	denklem2+=" "+txtBox2_6.getText();
		        	denklem2+=" "+txtBox2_7.getText();	
		        	if(txtBox2_8.isVisible()==true)
		            	denklem2+=" "+txtBox2_8.getText();
		        	if(txtBox2_9.isVisible()==true)
		            	denklem2+=" "+txtBox2_9.getText();
		        	
		        }
		        else if(hangiSatirdayiz==3) {
		        	denklem2+=txtBox3_1.getText();
		        	denklem2+=" "+txtBox3_2.getText();
		        	denklem2+=" "+txtBox3_3.getText();
		        	denklem2+=" "+txtBox3_4.getText();
		        	denklem2+=" "+txtBox3_5.getText();
		        	denklem2+=" "+txtBox3_6.getText();
		        	denklem2+=" "+txtBox3_7.getText();	
		        	if(txtBox3_8.isVisible()==true)
		            	denklem2+=" "+txtBox3_8.getText();
		        	if(txtBox3_9.isVisible()==true)
		            	denklem2+=" "+txtBox3_9.getText();
		        	
		        }
		        else if(hangiSatirdayiz==4) {
		        	denklem2+=txtBox4_1.getText();
		        	denklem2+=" "+txtBox4_2.getText();
		        	denklem2+=" "+txtBox4_3.getText();
		        	denklem2+=" "+txtBox4_4.getText();
		        	denklem2+=" "+txtBox4_5.getText();
		        	denklem2+=" "+txtBox4_6.getText();
		        	denklem2+=" "+txtBox4_7.getText();	
		        	if(txtBox4_8.isVisible()==true)
		            	denklem2+=" "+txtBox4_8.getText();
		        	if(txtBox4_9.isVisible()==true)
		            	denklem2+=" "+txtBox4_9.getText();
		        }
		        else if(hangiSatirdayiz==5) {
		        	denklem2+=txtBox5_1.getText();
		        	denklem2+=" "+txtBox5_2.getText();
		        	denklem2+=" "+txtBox5_3.getText();
		        	denklem2+=" "+txtBox5_4.getText();
		        	denklem2+=" "+txtBox5_5.getText();
		        	denklem2+=" "+txtBox5_6.getText();
		        	denklem2+=" "+txtBox5_7.getText();	
		        	if(txtBox5_8.isVisible()==true)
		            	denklem2+=" "+txtBox5_8.getText();
		        	if(txtBox5_9.isVisible()==true)
		            	denklem2+=" "+txtBox5_9.getText();
		        }
		        else if(hangiSatirdayiz==6) {
		        	denklem2+=txtBox6_1.getText();
		        	denklem2+=" "+txtBox6_2.getText();
		        	denklem2+=" "+txtBox6_3.getText();
		        	denklem2+=" "+txtBox6_4.getText();
		        	denklem2+=" "+txtBox6_5.getText();
		        	denklem2+=" "+txtBox6_6.getText();
		        	denklem2+=" "+txtBox6_7.getText();	
		        	if(txtBox6_8.isVisible()==true)
		            	denklem2+=" "+txtBox6_8.getText();
		        	if(txtBox6_9.isVisible()==true)
		            	denklem2+=" "+txtBox6_9.getText();
		        }

	        	
	        	// eşittir'in sağı soluna eşit mi kontrolü
	        	int esittirNerede = -1;
	        	String yazilanSonuc="";
	        	String denklemSonuc[] = denklem2.split(" ");
	        	for(int i=0;i<denklemSonuc.length;i++) {
	        		if(denklemSonuc[i].equals("=")==true)
	        			esittirNerede = i;
	        	}
                
	        	if(esittirNerede==-1) {
	        		  lblHata.setVisible(true);
	        	}else {
	        		for(int i= esittirNerede+1;i<denklemSonuc.length;i++) {
	        			yazilanSonuc += denklemSonuc[i];
	        		}

			     String[] denklemDiziCopy = new String[esittirNerede];
			     
			     for(int i=0;i<esittirNerede;i++) {
			      denklemDiziCopy [i] =denklemSonuc[i]; 
			     }
			     


			     
			     int baslangic = 0;
			     int indexOfOperator = -1;
			     String sayi = "";
			     for(int i=0;i<denklemDiziCopy.length;i++) {
				     if(denklemDiziCopy[baslangic].equals("0")||denklemDiziCopy[baslangic].equals("1")||denklemDiziCopy[baslangic].equals("2")||denklemDiziCopy[baslangic].equals("3")||denklemDiziCopy[baslangic].equals("4")||denklemDiziCopy[baslangic].equals("5")||denklemDiziCopy[baslangic].equals("6")||denklemDiziCopy[baslangic].equals("7")||denklemDiziCopy[baslangic].equals("8")||denklemDiziCopy[baslangic].equals("9")) {
				    	 sayi += denklemDiziCopy[baslangic];
				    	 baslangic++;
				     }else {
				    	 for(int j = indexOfOperator+1; j<baslangic-1;j++) {
				    		 denklemDiziCopy[j]="NULL";
				    	 }
				    	 
				    	 denklemDiziCopy[baslangic-1] = sayi;
				    	 sayi = "";
				    	 indexOfOperator = i;
				    	 baslangic = i+1;
				     }
				     
				     if(i==denklemDiziCopy.length-1) {
				    	 for(int k = indexOfOperator+1 ; k<baslangic;k++) {
				    		 denklemDiziCopy[k]="NULL";
				    	 }
				    	 denklemDiziCopy[baslangic-1] = sayi;
				     }
				    	 
			     }
			
			     List<String> copy = new ArrayList<String>();
			      
			        for (String i : denklemDiziCopy) {
			            if (i.equals("NULL")==false) 
			            	copy.add(i);

			        }
			        
			        String[] denklemDiziYeni = new String[copy.size()];
			        
			        for (int i = 0; i < copy.size(); i++) {
			        	denklemDiziYeni[i] = copy.get(i);
			        }
			     
			     

				     int n = 0;
			      for (int i = 0; i < denklemDiziYeni.length; i++) {
			           if( denklemDiziYeni[i].equals("+")==true || denklemDiziYeni[i].equals("-")==true || denklemDiziYeni[i].equals("/")==true || denklemDiziYeni[i].equals("*")==true ) {
			        	   
			           }else if(denklemDiziYeni[i].equals("NULL")==false) {
			        	   if(i!=denklemDiziYeni.length-1) {
			        		   if(denklemDiziYeni[i+1].equals("/")==true || denklemDiziYeni[i+1].equals("*")==true ) {
			        			   int a =Integer.parseInt(denklemDiziYeni[i]) ;
			        			   while(denklemDiziYeni[i+2+n].equals("NULL")==true) {
			        				   n++;
			        			   }
			        			   int b = Integer.parseInt(denklemDiziYeni[i+2+n]);
			        			 
			        			   String operator2 = denklemDiziYeni[i+1];
			        			   if(operator2.equals("/")==true) {
			        				   for(int k=i;k<i+2+n;k++)
			        					   denklemDiziYeni[k] = "NULL";
			        				  
			        				   denklemDiziYeni[i+2+n] = Integer.toString(a/b);
			        				   i=0;
			        			   }
			        				   
			        			   else {
			        				   for(int k=i;k<i+2+n;k++)
			        					   denklemDiziYeni[k] = "NULL";
			        				  
			        				   denklemDiziYeni[i+2+n] = Integer.toString(a*b);
			        				   i=0;
			        		
			        			   }
			        			   n =0;
			        		   }
			        	   }
			        	
			           }
			        }
			      
				     
				     for (int i = 0; i < denklemDiziYeni.length; i++) {
				    	  
				    	  if(denklemDiziYeni[i].equals("NULL") == false) {
				    		  if(i!=denklemDiziYeni.length-1) {
				    			  if(denklemDiziYeni[i+1].equals("+")==true || denklemDiziYeni[i+1].equals("-")==true) {
				        			   int a =Integer.parseInt(denklemDiziYeni[i]) ;
				        			   while(denklemDiziYeni[i+2+n].equals("NULL")==true) {
				        				   n++;
				        			   }
				        			   int b = Integer.parseInt(denklemDiziYeni[i+2+n]);
				        			   
				        			   String operator2 = denklemDiziYeni[i+1];
				        			   if(operator2.equals("+")==true) {
				        				   for(int k=i;k<i+2+n;k++)
				        					   denklemDiziYeni[k] = "NULL";
				        				  
				        				   denklemDiziYeni[i+2+n] = Integer.toString(a+b);
				        				   i=0;
				        			   }
				        				   
				        			   else {
				        				   for(int k=i;k<i+2+n;k++)
				        					   denklemDiziYeni[k] = "NULL";
				        				  
				        				   denklemDiziYeni[i+2+n] = Integer.toString(a-b);
	
				        				   i=0;
				        			   }
				        			   n=0;
				    			  }
				    		  }
				    	  }
				      } 

				     String sonuc =denklemDiziYeni[denklemDiziYeni.length-1];
				     if(sonuc.equals(yazilanSonuc)==false) {
				    	 lblHata.setVisible(true); 	 
				     }else {
				    	 
				    	 if(hangiSatirdayiz==1) {
					    	 
					    	  txtBox1_1.setBackground(Color.red);
					        	 txtBox1_2.setBackground(Color.red);
					        	 txtBox1_3.setBackground(Color.red);
					        	 txtBox1_4.setBackground(Color.red);
					        	 txtBox1_5.setBackground(Color.red);
					        	 txtBox1_6.setBackground(Color.red);
					        	 txtBox1_7.setBackground(Color.red);
					        	 txtBox1_8.setBackground(Color.red);
					        	 txtBox1_9.setBackground(Color.red);
					        	 
					        	 txtBox1_1.setForeground(Color.white);
					        	 txtBox1_2.setForeground(Color.white);
					        	 txtBox1_3.setForeground(Color.white);
					        	 txtBox1_4.setForeground(Color.white);
					        	 txtBox1_5.setForeground(Color.white);
					        	 txtBox1_6.setForeground(Color.white);
					        	 txtBox1_7.setForeground(Color.white);
					        	 txtBox1_8.setForeground(Color.white);
					        	 txtBox1_9.setForeground(Color.white);
					        	 
					        	 for(int i=0; i<denklemDizi.length;i++) {
						        	 if(denklemDizi[i].equals(txtBox1_1.getText()))
						        		 txtBox1_1.setBackground(Color.yellow);
						        	 if(denklemDizi[i].equals(txtBox1_2.getText()))
						        		 txtBox1_2.setBackground(Color.yellow);
						        	 if(denklemDizi[i].equals(txtBox1_3.getText()))
						        		 txtBox1_3.setBackground(Color.yellow);
						        	 if(denklemDizi[i].equals(txtBox1_4.getText()))
						        		 txtBox1_4.setBackground(Color.yellow);
						        	 if(denklemDizi[i].equals(txtBox1_5.getText()))
						        		 txtBox1_5.setBackground(Color.yellow);
						        	 
						        	 if(denklemDizi[i].equals(txtBox1_6.getText()))
						        		 txtBox1_6.setBackground(Color.yellow);
						        	 if(denklemDizi[i].equals(txtBox1_7.getText()))
						        		 txtBox1_7.setBackground(Color.yellow);
						        	 
						        	 if(txtBox1_8.isVisible()==true) {
							        	 if(denklemDizi[i].equals(txtBox1_8.getText()))
							        		 txtBox1_8.setBackground(Color.yellow);
						        	 }
						        	 if(txtBox1_9.isVisible()==true) {
							        	 if(denklemDizi[i].equals(txtBox1_9.getText()))
							        		 txtBox1_9.setBackground(Color.yellow);
						        	 }
					        	 }


						         
					         if(txtBox1_1.getText().equals(txtBoxDenklem1.getText())) {
					        	 basariliKutuSayisi++;
					        	 txtBox1_1.setBackground(Color.green);
					         }
					        	
					         if(txtBox1_2.getText().equals(txtBoxDenklem2.getText())) {
					        	 basariliKutuSayisi++;
					        	 txtBox1_2.setBackground(Color.green);
					         }
					        	
					         if(txtBox1_3.getText().equals(txtBoxDenklem3.getText())){
					        	 basariliKutuSayisi++;
					        	 txtBox1_3.setBackground(Color.green);
					         }
					        
					         if(txtBox1_4.getText().equals(txtBoxDenklem4.getText())){
					        	 basariliKutuSayisi++;
					        	 txtBox1_4.setBackground(Color.green);
					         }
					        	
					         if(txtBox1_5.getText().equals(txtBoxDenklem5.getText())){
					        	 basariliKutuSayisi++;
					        	 txtBox1_5.setBackground(Color.green);
					         }
					        	 
					         if(txtBox1_6.getText().equals(txtBoxDenklem6.getText())){
					        	 basariliKutuSayisi++;
					        	 txtBox1_6.setBackground(Color.green);
					         }
					        	
					         if(txtBox1_7.getText().equals(txtBoxDenklem7.getText())){
					        	 basariliKutuSayisi++;
					        	 txtBox1_7.setBackground(Color.green);
					         }
					        	 
					         if(txtBox1_8.isVisible()==true) {
					        	 denkleminUzunlugu++;
						         if(txtBox1_8.getText().equals(txtBoxDenklem8.getText())){
						        	 basariliKutuSayisi++;
						        	 txtBox1_8.setBackground(Color.green);
						         }
						        	 
					         }
					         if(txtBox1_9.isVisible()==true) {
					        	 denkleminUzunlugu++;
					             if(txtBox1_9.getText().equals(txtBoxDenklem9.getText())){
					            	 basariliKutuSayisi++;
					            	 txtBox1_9.setBackground(Color.green);
						         }
						        
					         }
					         
					         txtBox1_1.setEnabled(false);
					         txtBox1_2.setEnabled(false);
					         txtBox1_3.setEnabled(false);
					         txtBox1_4.setEnabled(false);
					         txtBox1_5.setEnabled(false);
					         txtBox1_6.setEnabled(false);
					         txtBox1_7.setEnabled(false);
					         txtBox1_8.setEnabled(false);
					         txtBox1_9.setEnabled(false);
					         if(basariliKutuSayisi == denkleminUzunlugu) {
					        	 
					        	lblSure.setVisible(false);
					        	sure = Integer.parseInt(lblSure.getText());
					        	basariliOlunanSatir = 1;
					        	 lblBasarili.setForeground(Color.green);
					        	 lblBasarili.setText("Tebrikler, "+sure+" sn içerisinde tamamladınız...");
					        	lblBasarili.setVisible(true);
					        	btnBasla.setVisible(false);
					        	Istatistik ist = istatistikGetir();

					        	int basariliOyunAdet = ist.getBasariliOyunAdet();
					        	basariliOyunAdet++;
					        	double basariliKacSatirda = ist.getBasarililarOrtKacSatirdaTamamlanmis();
					        	double basariliOrtSure = ist.getBasarililarOrtSure();
					        	
					        	double ortalamaSatir = ((basariliKacSatirda*(basariliOyunAdet-1))+basariliOlunanSatir)/(basariliOyunAdet);
					        	double ortalamaSure = ((basariliOrtSure*(basariliOyunAdet-1)) + sure) / (basariliOyunAdet);
					    
					        	istatistikGuncelle(ist.getYaridaBirakilan(),ist.getBasarisizOyunAdet(),basariliOyunAdet,ortalamaSatir,ortalamaSure);
					       

					         }else {
					        	 secilen = txtBox2_1;
					        	  txtBox2_1.setEnabled(true);
									txtBox2_2.setEnabled(true);
									txtBox2_3.setEnabled(true);
									txtBox2_4.setEnabled(true);
									txtBox2_5.setEnabled(true);
									txtBox2_6.setEnabled(true);
									txtBox2_7.setEnabled(true);
									txtBox2_8.setEnabled(true);
									txtBox2_9.setEnabled(true);
					         }
				    	 }
				    	 else if(hangiSatirdayiz==2) {
					    	 
					    	  txtBox2_1.setBackground(Color.red);
					    	  txtBox2_2.setBackground(Color.red);
					        	 txtBox2_3.setBackground(Color.red);
					        	 txtBox2_4.setBackground(Color.red);
					        	 txtBox2_5.setBackground(Color.red);
					        	 txtBox2_6.setBackground(Color.red);
					        	 txtBox2_7.setBackground(Color.red);
					        	 txtBox2_8.setBackground(Color.red);
					        	 txtBox2_9.setBackground(Color.red);
					        	 
					        	 txtBox2_1.setForeground(Color.white);
					        	 txtBox2_2.setForeground(Color.white);
					        	 txtBox2_3.setForeground(Color.white);
					        	 txtBox2_4.setForeground(Color.white);
					        	 txtBox2_5.setForeground(Color.white);
					        	 txtBox2_6.setForeground(Color.white);
					        	 txtBox2_7.setForeground(Color.white);
					        	 txtBox2_8.setForeground(Color.white);
					        	 txtBox2_9.setForeground(Color.white);
					        	 
					        	 for(int i=0; i<denklemDizi.length;i++) {
						        	 if(denklemDizi[i].equals(txtBox2_1.getText()))
						        		 txtBox2_1.setBackground(Color.yellow);
						        	 if(denklemDizi[i].equals(txtBox2_2.getText()))
						        		 txtBox2_2.setBackground(Color.yellow);
						        	 if(denklemDizi[i].equals(txtBox2_3.getText()))
						        		 txtBox2_3.setBackground(Color.yellow);
						        	 if(denklemDizi[i].equals(txtBox2_4.getText()))
						        		 txtBox2_4.setBackground(Color.yellow);
						        	 if(denklemDizi[i].equals(txtBox2_5.getText()))
						        		 txtBox2_5.setBackground(Color.yellow);
						        	 
						        	 if(denklemDizi[i].equals(txtBox2_6.getText()))
						        		 txtBox2_6.setBackground(Color.yellow);
						        	 if(denklemDizi[i].equals(txtBox2_7.getText()))
						        		 txtBox2_7.setBackground(Color.yellow);
						        	 
						        	 if(txtBox2_8.isVisible()==true) {
							        	 if(denklemDizi[i].equals(txtBox2_8.getText()))
							        		 txtBox2_8.setBackground(Color.yellow);
						        	 }
						        	 if(txtBox2_9.isVisible()==true) {
							        	 if(denklemDizi[i].equals(txtBox2_9.getText()))
							        		 txtBox2_9.setBackground(Color.yellow);
						        	 }
					        	 }


						         
					         if(txtBox2_1.getText().equals(txtBoxDenklem1.getText())) {
					        	 basariliKutuSayisi++;
					        	 txtBox2_1.setBackground(Color.green);
					         }
					        	
					         if(txtBox2_2.getText().equals(txtBoxDenklem2.getText())) {
					        	 basariliKutuSayisi++;
					        	 txtBox2_2.setBackground(Color.green);
					         }
					        	
					         if(txtBox2_3.getText().equals(txtBoxDenklem3.getText())){
					        	 basariliKutuSayisi++;
					        	 txtBox2_3.setBackground(Color.green);
					         }
					        
					         if(txtBox2_4.getText().equals(txtBoxDenklem4.getText())){
					        	 basariliKutuSayisi++;
					        	 txtBox2_4.setBackground(Color.green);
					         }
					        	
					         if(txtBox2_5.getText().equals(txtBoxDenklem5.getText())){
					        	 basariliKutuSayisi++;
					        	 txtBox2_5.setBackground(Color.green);
					         }
					        	 
					         if(txtBox2_6.getText().equals(txtBoxDenklem6.getText())){
					        	 basariliKutuSayisi++;
					        	 txtBox2_6.setBackground(Color.green);
					         }
					        	
					         if(txtBox2_7.getText().equals(txtBoxDenklem7.getText())){
					        	 basariliKutuSayisi++;
					        	 txtBox2_7.setBackground(Color.green);
					         }
					        	 
					         if(txtBox2_8.isVisible()==true) {
					        	 denkleminUzunlugu++;
						         if(txtBox2_8.getText().equals(txtBoxDenklem8.getText())){
						        	 basariliKutuSayisi++;
						        	 txtBox2_8.setBackground(Color.green);
						         }
						        	 
					         }
					         if(txtBox2_9.isVisible()==true) {
					        	 denkleminUzunlugu++;
					             if(txtBox2_9.getText().equals(txtBoxDenklem9.getText())){
					            	 basariliKutuSayisi++;
					            	 txtBox2_9.setBackground(Color.green);
						         }
						        
					         }
					         
					         txtBox2_1.setEnabled(false);
					         txtBox2_2.setEnabled(false);
					         txtBox2_3.setEnabled(false);
					         txtBox2_4.setEnabled(false);
					         txtBox2_5.setEnabled(false);
					         txtBox2_6.setEnabled(false);
					         txtBox2_7.setEnabled(false);
					         txtBox2_8.setEnabled(false);
					         txtBox2_9.setEnabled(false);
					         if(basariliKutuSayisi == denkleminUzunlugu) {
					        	 
					        	lblSure.setVisible(false);
					        	sure = Integer.parseInt(lblSure.getText());
					        	basariliOlunanSatir = 2;
					        	 lblBasarili.setForeground(Color.green);
					        	 lblBasarili.setText("Tebrikler, "+sure+" sn içerisinde tamamladınız...");		
					        	 lblBasarili.setVisible(true);
					        	btnBasla.setVisible(false);
					        	Istatistik ist = istatistikGetir();

					        	int basariliOyunAdet = ist.getBasariliOyunAdet();
					        	basariliOyunAdet++;
					        	double basariliKacSatirda = ist.getBasarililarOrtKacSatirdaTamamlanmis();
					        	double basariliOrtSure = ist.getBasarililarOrtSure();
					        	
					        	double ortalamaSatir = ((basariliKacSatirda*(basariliOyunAdet-1))+basariliOlunanSatir)/(basariliOyunAdet);
					        	double ortalamaSure = ((basariliOrtSure*(basariliOyunAdet-1)) + sure) / (basariliOyunAdet);
					    
					        	istatistikGuncelle(ist.getYaridaBirakilan(),ist.getBasarisizOyunAdet(),basariliOyunAdet,ortalamaSatir,ortalamaSure);
					       

					         }else {
					        	 secilen = txtBox3_1;
					        	  txtBox3_1.setEnabled(true);
									txtBox3_2.setEnabled(true);
									txtBox3_3.setEnabled(true);
									txtBox3_4.setEnabled(true);
									txtBox3_5.setEnabled(true);
									txtBox3_6.setEnabled(true);
									txtBox3_7.setEnabled(true);
									txtBox3_8.setEnabled(true);
									txtBox3_9.setEnabled(true);
					         }
				    	 }
				    	 else if(hangiSatirdayiz==3) {
					    	 
					    	  txtBox3_1.setBackground(Color.red);
					    	  txtBox3_2.setBackground(Color.red);
					        	 txtBox3_3.setBackground(Color.red);
					        	 txtBox3_4.setBackground(Color.red);
					        	 txtBox3_5.setBackground(Color.red);
					        	 txtBox3_6.setBackground(Color.red);
					        	 txtBox3_7.setBackground(Color.red);
					        	 txtBox3_8.setBackground(Color.red);
					        	 txtBox3_9.setBackground(Color.red);
					        	 
					        	 txtBox3_1.setForeground(Color.white);
					        	 txtBox3_2.setForeground(Color.white);
					        	 txtBox3_3.setForeground(Color.white);
					        	 txtBox3_4.setForeground(Color.white);
					        	 txtBox3_5.setForeground(Color.white);
					        	 txtBox3_6.setForeground(Color.white);
					        	 txtBox3_7.setForeground(Color.white);
					        	 txtBox3_8.setForeground(Color.white);
					        	 txtBox3_9.setForeground(Color.white);
					        	 
					        	 for(int i=0; i<denklemDizi.length;i++) {
						        	 if(denklemDizi[i].equals(txtBox3_1.getText()))
						        		 txtBox3_1.setBackground(Color.yellow);
						        	 if(denklemDizi[i].equals(txtBox3_2.getText()))
						        		 txtBox3_2.setBackground(Color.yellow);
						        	 if(denklemDizi[i].equals(txtBox3_3.getText()))
						        		 txtBox3_3.setBackground(Color.yellow);
						        	 if(denklemDizi[i].equals(txtBox3_4.getText()))
						        		 txtBox3_4.setBackground(Color.yellow);
						        	 if(denklemDizi[i].equals(txtBox3_5.getText()))
						        		 txtBox3_5.setBackground(Color.yellow);
						        	 
						        	 if(denklemDizi[i].equals(txtBox3_6.getText()))
						        		 txtBox3_6.setBackground(Color.yellow);
						        	 if(denklemDizi[i].equals(txtBox3_7.getText()))
						        		 txtBox3_7.setBackground(Color.yellow);
						        	 
						        	 if(txtBox3_8.isVisible()==true) {
							        	 if(denklemDizi[i].equals(txtBox3_8.getText()))
							        		 txtBox3_8.setBackground(Color.yellow);
						        	 }
						        	 if(txtBox3_9.isVisible()==true) {
							        	 if(denklemDizi[i].equals(txtBox3_9.getText()))
							        		 txtBox3_9.setBackground(Color.yellow);
						        	 }
					        	 }


						         
					         if(txtBox3_1.getText().equals(txtBoxDenklem1.getText())) {
					        	 basariliKutuSayisi++;
					        	 txtBox3_1.setBackground(Color.green);
					         }
					        	
					         if(txtBox3_2.getText().equals(txtBoxDenklem2.getText())) {
					        	 basariliKutuSayisi++;
					        	 txtBox3_2.setBackground(Color.green);
					         }
					        	
					         if(txtBox3_3.getText().equals(txtBoxDenklem3.getText())){
					        	 basariliKutuSayisi++;
					        	 txtBox3_3.setBackground(Color.green);
					         }
					        
					         if(txtBox3_4.getText().equals(txtBoxDenklem4.getText())){
					        	 basariliKutuSayisi++;
					        	 txtBox3_4.setBackground(Color.green);
					         }
					        	
					         if(txtBox3_5.getText().equals(txtBoxDenklem5.getText())){
					        	 basariliKutuSayisi++;
					        	 txtBox3_5.setBackground(Color.green);
					         }
					        	 
					         if(txtBox3_6.getText().equals(txtBoxDenklem6.getText())){
					        	 basariliKutuSayisi++;
					        	 txtBox3_6.setBackground(Color.green);
					         }
					        	
					         if(txtBox3_7.getText().equals(txtBoxDenklem7.getText())){
					        	 basariliKutuSayisi++;
					        	 txtBox3_7.setBackground(Color.green);
					         }
					        	 
					         if(txtBox3_8.isVisible()==true) {
					        	 denkleminUzunlugu++;
						         if(txtBox3_8.getText().equals(txtBoxDenklem8.getText())){
						        	 basariliKutuSayisi++;
						        	 txtBox3_8.setBackground(Color.green);
						         }
						        	 
					         }
					         if(txtBox3_9.isVisible()==true) {
					        	 denkleminUzunlugu++;
					             if(txtBox3_9.getText().equals(txtBoxDenklem9.getText())){
					            	 basariliKutuSayisi++;
					            	 txtBox3_9.setBackground(Color.green);
						         }
						        
					         }
					         
					         txtBox3_1.setEnabled(false);
					         txtBox3_2.setEnabled(false);
					         txtBox3_3.setEnabled(false);
					         txtBox3_4.setEnabled(false);
					         txtBox3_5.setEnabled(false);
					         txtBox3_6.setEnabled(false);
					         txtBox3_7.setEnabled(false);
					         txtBox3_8.setEnabled(false);
					         txtBox3_9.setEnabled(false);
					         if(basariliKutuSayisi == denkleminUzunlugu) {
					        	 
					        	lblSure.setVisible(false);
					        	sure = Integer.parseInt(lblSure.getText());
					        	basariliOlunanSatir = 3;
					        	 lblBasarili.setForeground(Color.green);
					        	 lblBasarili.setText("Tebrikler, "+sure+" sn içerisinde tamamladınız...");		
					        	 lblBasarili.setVisible(true);
					        	btnBasla.setVisible(false);
					        	Istatistik ist = istatistikGetir();

					        	int basariliOyunAdet = ist.getBasariliOyunAdet();
					        	basariliOyunAdet++;
					        	double basariliKacSatirda = ist.getBasarililarOrtKacSatirdaTamamlanmis();
					        	double basariliOrtSure = ist.getBasarililarOrtSure();
					        	
					        	double ortalamaSatir = ((basariliKacSatirda*(basariliOyunAdet-1))+basariliOlunanSatir)/(basariliOyunAdet);
					        	double ortalamaSure = ((basariliOrtSure*(basariliOyunAdet-1)) + sure) / (basariliOyunAdet);
					    
					        	istatistikGuncelle(ist.getYaridaBirakilan(),ist.getBasarisizOyunAdet(),basariliOyunAdet,ortalamaSatir,ortalamaSure);
					       

					         }else {
					        	 secilen = txtBox4_1;
					        	  txtBox4_1.setEnabled(true);
									txtBox4_2.setEnabled(true);
									txtBox4_3.setEnabled(true);
									txtBox4_4.setEnabled(true);
									txtBox4_5.setEnabled(true);
									txtBox4_6.setEnabled(true);
									txtBox4_7.setEnabled(true);
									txtBox4_8.setEnabled(true);
									txtBox4_9.setEnabled(true);
					         }
				    	 }	 else if(hangiSatirdayiz==4) {
				    	 
				    	  txtBox4_1.setBackground(Color.red);
				    	  txtBox4_2.setBackground(Color.red);
				        	 txtBox4_3.setBackground(Color.red);
				        	 txtBox4_4.setBackground(Color.red);
				        	 txtBox4_5.setBackground(Color.red);
				        	 txtBox4_6.setBackground(Color.red);
				        	 txtBox4_7.setBackground(Color.red);
				        	 txtBox4_8.setBackground(Color.red);
				        	 txtBox4_9.setBackground(Color.red);
				        	 
				        	 txtBox4_1.setForeground(Color.white);
				        	 txtBox4_2.setForeground(Color.white);
				        	 txtBox4_3.setForeground(Color.white);
				        	 txtBox4_4.setForeground(Color.white);
				        	 txtBox4_5.setForeground(Color.white);
				        	 txtBox4_6.setForeground(Color.white);
				        	 txtBox4_7.setForeground(Color.white);
				        	 txtBox4_8.setForeground(Color.white);
				        	 txtBox4_9.setForeground(Color.white);
				        	 
				        	 for(int i=0; i<denklemDizi.length;i++) {
					        	 if(denklemDizi[i].equals(txtBox4_1.getText()))
					        		 txtBox4_1.setBackground(Color.yellow);
					        	 if(denklemDizi[i].equals(txtBox4_2.getText()))
					        		 txtBox4_2.setBackground(Color.yellow);
					        	 if(denklemDizi[i].equals(txtBox4_3.getText()))
					        		 txtBox4_3.setBackground(Color.yellow);
					        	 if(denklemDizi[i].equals(txtBox4_4.getText()))
					        		 txtBox4_4.setBackground(Color.yellow);
					        	 if(denklemDizi[i].equals(txtBox4_5.getText()))
					        		 txtBox4_5.setBackground(Color.yellow);
					        	 
					        	 if(denklemDizi[i].equals(txtBox4_6.getText()))
					        		 txtBox4_6.setBackground(Color.yellow);
					        	 if(denklemDizi[i].equals(txtBox4_7.getText()))
					        		 txtBox4_7.setBackground(Color.yellow);
					        	 
					        	 if(txtBox4_8.isVisible()==true) {
						        	 if(denklemDizi[i].equals(txtBox4_8.getText()))
						        		 txtBox4_8.setBackground(Color.yellow);
					        	 }
					        	 if(txtBox4_9.isVisible()==true) {
						        	 if(denklemDizi[i].equals(txtBox4_9.getText()))
						        		 txtBox4_9.setBackground(Color.yellow);
					        	 }
				        	 }


					         
				         if(txtBox4_1.getText().equals(txtBoxDenklem1.getText())) {
				        	 basariliKutuSayisi++;
				        	 txtBox4_1.setBackground(Color.green);
				         }
				        	
				         if(txtBox4_2.getText().equals(txtBoxDenklem2.getText())) {
				        	 basariliKutuSayisi++;
				        	 txtBox4_2.setBackground(Color.green);
				         }
				        	
				         if(txtBox4_3.getText().equals(txtBoxDenklem3.getText())){
				        	 basariliKutuSayisi++;
				        	 txtBox4_3.setBackground(Color.green);
				         }
				        
				         if(txtBox4_4.getText().equals(txtBoxDenklem4.getText())){
				        	 basariliKutuSayisi++;
				        	 txtBox4_4.setBackground(Color.green);
				         }
				        	
				         if(txtBox4_5.getText().equals(txtBoxDenklem5.getText())){
				        	 basariliKutuSayisi++;
				        	 txtBox4_5.setBackground(Color.green);
				         }
				        	 
				         if(txtBox4_6.getText().equals(txtBoxDenklem6.getText())){
				        	 basariliKutuSayisi++;
				        	 txtBox4_6.setBackground(Color.green);
				         }
				        	
				         if(txtBox4_7.getText().equals(txtBoxDenklem7.getText())){
				        	 basariliKutuSayisi++;
				        	 txtBox4_7.setBackground(Color.green);
				         }
				        	 
				         if(txtBox4_8.isVisible()==true) {
				        	 denkleminUzunlugu++;
					         if(txtBox4_8.getText().equals(txtBoxDenklem8.getText())){
					        	 basariliKutuSayisi++;
					        	 txtBox4_8.setBackground(Color.green);
					         }
					        	 
				         }
				         if(txtBox4_9.isVisible()==true) {
				        	 denkleminUzunlugu++;
				             if(txtBox4_9.getText().equals(txtBoxDenklem9.getText())){
				            	 basariliKutuSayisi++;
				            	 txtBox4_9.setBackground(Color.green);
					         }
					        
				         }
				         
				         txtBox4_1.setEnabled(false);
				         txtBox4_2.setEnabled(false);
				         txtBox4_3.setEnabled(false);
				         txtBox4_4.setEnabled(false);
				         txtBox4_5.setEnabled(false);
				         txtBox4_6.setEnabled(false);
				         txtBox4_7.setEnabled(false);
				         txtBox4_8.setEnabled(false);
				         txtBox4_9.setEnabled(false);
				         if(basariliKutuSayisi == denkleminUzunlugu) {
				        	 
				        	lblSure.setVisible(false);
				        	sure = Integer.parseInt(lblSure.getText());
				        	basariliOlunanSatir = 4;
				        	 lblBasarili.setForeground(Color.green);
				        	 lblBasarili.setText("Tebrikler, "+sure+" sn içerisinde tamamladınız...");	
				        	 lblBasarili.setVisible(true);
				        	btnBasla.setVisible(false);
				        	Istatistik ist = istatistikGetir();

				        	int basariliOyunAdet = ist.getBasariliOyunAdet();
				        	basariliOyunAdet++;
				        	double basariliKacSatirda = ist.getBasarililarOrtKacSatirdaTamamlanmis();
				        	double basariliOrtSure = ist.getBasarililarOrtSure();
				        	
				        	double ortalamaSatir = ((basariliKacSatirda*(basariliOyunAdet-1))+basariliOlunanSatir)/(basariliOyunAdet);
				        	double ortalamaSure = ((basariliOrtSure*(basariliOyunAdet-1)) + sure) / (basariliOyunAdet);
				    
				        	istatistikGuncelle(ist.getYaridaBirakilan(),ist.getBasarisizOyunAdet(),basariliOyunAdet,ortalamaSatir,ortalamaSure);
				       

				         }else {
				        	 secilen = txtBox5_1;
				        	  txtBox5_1.setEnabled(true);
								txtBox5_2.setEnabled(true);
								txtBox5_3.setEnabled(true);
								txtBox5_4.setEnabled(true);
								txtBox5_5.setEnabled(true);
								txtBox5_6.setEnabled(true);
								txtBox5_7.setEnabled(true);
								txtBox5_8.setEnabled(true);
								txtBox5_9.setEnabled(true);
				         }
			    	 }
				    	 else if(hangiSatirdayiz==5) {
					    	 
					    	  txtBox5_1.setBackground(Color.red);
					    	  txtBox5_2.setBackground(Color.red);
					        	 txtBox5_3.setBackground(Color.red);
					        	 txtBox5_4.setBackground(Color.red);
					        	 txtBox5_5.setBackground(Color.red);
					        	 txtBox5_6.setBackground(Color.red);
					        	 txtBox5_7.setBackground(Color.red);
					        	 txtBox5_8.setBackground(Color.red);
					        	 txtBox5_9.setBackground(Color.red);
					        	 
					        	 txtBox5_1.setForeground(Color.white);
					        	 txtBox5_2.setForeground(Color.white);
					        	 txtBox5_3.setForeground(Color.white);
					        	 txtBox5_4.setForeground(Color.white);
					        	 txtBox5_5.setForeground(Color.white);
					        	 txtBox5_6.setForeground(Color.white);
					        	 txtBox5_7.setForeground(Color.white);
					        	 txtBox5_8.setForeground(Color.white);
					        	 txtBox5_9.setForeground(Color.white);
					        	 
					        	 for(int i=0; i<denklemDizi.length;i++) {
						        	 if(denklemDizi[i].equals(txtBox5_1.getText()))
						        		 txtBox5_1.setBackground(Color.yellow);
						        	 if(denklemDizi[i].equals(txtBox5_2.getText()))
						        		 txtBox5_2.setBackground(Color.yellow);
						        	 if(denklemDizi[i].equals(txtBox5_3.getText()))
						        		 txtBox5_3.setBackground(Color.yellow);
						        	 if(denklemDizi[i].equals(txtBox5_4.getText()))
						        		 txtBox5_4.setBackground(Color.yellow);
						        	 if(denklemDizi[i].equals(txtBox5_5.getText()))
						        		 txtBox5_5.setBackground(Color.yellow);
						        	 
						        	 if(denklemDizi[i].equals(txtBox5_6.getText()))
						        		 txtBox5_6.setBackground(Color.yellow);
						        	 if(denklemDizi[i].equals(txtBox5_7.getText()))
						        		 txtBox5_7.setBackground(Color.yellow);
						        	 
						        	 if(txtBox5_8.isVisible()==true) {
							        	 if(denklemDizi[i].equals(txtBox5_8.getText()))
							        		 txtBox5_8.setBackground(Color.yellow);
						        	 }
						        	 if(txtBox5_9.isVisible()==true) {
							        	 if(denklemDizi[i].equals(txtBox5_9.getText()))
							        		 txtBox5_9.setBackground(Color.yellow);
						        	 }
					        	 }


						         
					         if(txtBox5_1.getText().equals(txtBoxDenklem1.getText())) {
					        	 basariliKutuSayisi++;
					        	 txtBox5_1.setBackground(Color.green);
					         }
					        	
					         if(txtBox5_2.getText().equals(txtBoxDenklem2.getText())) {
					        	 basariliKutuSayisi++;
					        	 txtBox5_2.setBackground(Color.green);
					         }
					        	
					         if(txtBox5_3.getText().equals(txtBoxDenklem3.getText())){
					        	 basariliKutuSayisi++;
					        	 txtBox5_3.setBackground(Color.green);
					         }
					        
					         if(txtBox5_4.getText().equals(txtBoxDenklem4.getText())){
					        	 basariliKutuSayisi++;
					        	 txtBox5_4.setBackground(Color.green);
					         }
					        	
					         if(txtBox5_5.getText().equals(txtBoxDenklem5.getText())){
					        	 basariliKutuSayisi++;
					        	 txtBox5_5.setBackground(Color.green);
					         }
					        	 
					         if(txtBox5_6.getText().equals(txtBoxDenklem6.getText())){
					        	 basariliKutuSayisi++;
					        	 txtBox5_6.setBackground(Color.green);
					         }
					        	
					         if(txtBox5_7.getText().equals(txtBoxDenklem7.getText())){
					        	 basariliKutuSayisi++;
					        	 txtBox5_7.setBackground(Color.green);
					         }
					        	 
					         if(txtBox5_8.isVisible()==true) {
					        	 denkleminUzunlugu++;
						         if(txtBox5_8.getText().equals(txtBoxDenklem8.getText())){
						        	 basariliKutuSayisi++;
						        	 txtBox5_8.setBackground(Color.green);
						         }
						        	 
					         }
					         if(txtBox5_9.isVisible()==true) {
					        	 denkleminUzunlugu++;
					             if(txtBox5_9.getText().equals(txtBoxDenklem9.getText())){
					            	 basariliKutuSayisi++;
					            	 txtBox5_9.setBackground(Color.green);
						         }
						        
					         }
					         
					         txtBox5_1.setEnabled(false);
					         txtBox5_2.setEnabled(false);
					         txtBox5_3.setEnabled(false);
					         txtBox5_4.setEnabled(false);
					         txtBox5_5.setEnabled(false);
					         txtBox5_6.setEnabled(false);
					         txtBox5_7.setEnabled(false);
					         txtBox5_8.setEnabled(false);
					         txtBox5_9.setEnabled(false);
					         if(basariliKutuSayisi == denkleminUzunlugu) {
					        	 
					        	lblSure.setVisible(false);
					        	sure = Integer.parseInt(lblSure.getText());
					        	basariliOlunanSatir = 5;
					        	 lblBasarili.setForeground(Color.green);
					        	 lblBasarili.setText("Tebrikler, "+sure+" sn içerisinde tamamladınız...");		
					        	 lblBasarili.setVisible(true);
					        	btnBasla.setVisible(false);
					        	Istatistik ist = istatistikGetir();

					        	int basariliOyunAdet = ist.getBasariliOyunAdet();
					        	basariliOyunAdet++;
					        	double basariliKacSatirda = ist.getBasarililarOrtKacSatirdaTamamlanmis();
					        	double basariliOrtSure = ist.getBasarililarOrtSure();
					        	
					        	double ortalamaSatir = ((basariliKacSatirda*(basariliOyunAdet-1))+basariliOlunanSatir)/(basariliOyunAdet);
					        	double ortalamaSure = ((basariliOrtSure*(basariliOyunAdet-1)) + sure) / (basariliOyunAdet);
					    
					        	istatistikGuncelle(ist.getYaridaBirakilan(),ist.getBasarisizOyunAdet(),basariliOyunAdet,ortalamaSatir,ortalamaSure);
					       

					         }else {
					        	 secilen = txtBox6_1;
					        	  txtBox6_1.setEnabled(true);
									txtBox6_2.setEnabled(true);
									txtBox6_3.setEnabled(true);
									txtBox6_4.setEnabled(true);
									txtBox6_5.setEnabled(true);
									txtBox6_6.setEnabled(true);
									txtBox6_7.setEnabled(true);
									txtBox6_8.setEnabled(true);
									txtBox6_9.setEnabled(true);
					         }
				    	 }
				    	 else if(hangiSatirdayiz==6) {
					    	 
					    	  txtBox6_1.setBackground(Color.red);
					    	  txtBox6_2.setBackground(Color.red);
					        	 txtBox6_3.setBackground(Color.red);
					        	 txtBox6_4.setBackground(Color.red);
					        	 txtBox6_5.setBackground(Color.red);
					        	 txtBox6_6.setBackground(Color.red);
					        	 txtBox6_7.setBackground(Color.red);
					        	 txtBox6_8.setBackground(Color.red);
					        	 txtBox6_9.setBackground(Color.red);
					        	 
					        	 txtBox6_1.setForeground(Color.white);
					        	 txtBox6_2.setForeground(Color.white);
					        	 txtBox6_3.setForeground(Color.white);
					        	 txtBox6_4.setForeground(Color.white);
					        	 txtBox6_5.setForeground(Color.white);
					        	 txtBox6_6.setForeground(Color.white);
					        	 txtBox6_7.setForeground(Color.white);
					        	 txtBox6_8.setForeground(Color.white);
					        	 txtBox6_9.setForeground(Color.white);
					        	 
					        	 for(int i=0; i<denklemDizi.length;i++) {
						        	 if(denklemDizi[i].equals(txtBox6_1.getText()))
						        		 txtBox6_1.setBackground(Color.yellow);
						        	 if(denklemDizi[i].equals(txtBox6_2.getText()))
						        		 txtBox6_2.setBackground(Color.yellow);
						        	 if(denklemDizi[i].equals(txtBox6_3.getText()))
						        		 txtBox6_3.setBackground(Color.yellow);
						        	 if(denklemDizi[i].equals(txtBox6_4.getText()))
						        		 txtBox6_4.setBackground(Color.yellow);
						        	 if(denklemDizi[i].equals(txtBox6_5.getText()))
						        		 txtBox6_5.setBackground(Color.yellow);
						        	 
						        	 if(denklemDizi[i].equals(txtBox6_6.getText()))
						        		 txtBox6_6.setBackground(Color.yellow);
						        	 if(denklemDizi[i].equals(txtBox6_7.getText()))
						        		 txtBox6_7.setBackground(Color.yellow);
						        	 
						        	 if(txtBox6_8.isVisible()==true) {
							        	 if(denklemDizi[i].equals(txtBox6_8.getText()))
							        		 txtBox6_8.setBackground(Color.yellow);
						        	 }
						        	 if(txtBox6_9.isVisible()==true) {
							        	 if(denklemDizi[i].equals(txtBox6_9.getText()))
							        		 txtBox6_9.setBackground(Color.yellow);
						        	 }
					        	 }


						         
					         if(txtBox6_1.getText().equals(txtBoxDenklem1.getText())) {
					        	 basariliKutuSayisi++;
					        	 txtBox6_1.setBackground(Color.green);
					         }
					        	
					         if(txtBox6_2.getText().equals(txtBoxDenklem2.getText())) {
					        	 basariliKutuSayisi++;
					        	 txtBox6_2.setBackground(Color.green);
					         }
					        	
					         if(txtBox6_3.getText().equals(txtBoxDenklem3.getText())){
					        	 basariliKutuSayisi++;
					        	 txtBox6_3.setBackground(Color.green);
					         }
					        
					         if(txtBox6_4.getText().equals(txtBoxDenklem4.getText())){
					        	 basariliKutuSayisi++;
					        	 txtBox6_4.setBackground(Color.green);
					         }
					        	
					         if(txtBox6_5.getText().equals(txtBoxDenklem5.getText())){
					        	 basariliKutuSayisi++;
					        	 txtBox6_5.setBackground(Color.green);
					         }
					        	 
					         if(txtBox6_6.getText().equals(txtBoxDenklem6.getText())){
					        	 basariliKutuSayisi++;
					        	 txtBox6_6.setBackground(Color.green);
					         }
					        	
					         if(txtBox6_7.getText().equals(txtBoxDenklem7.getText())){
					        	 basariliKutuSayisi++;
					        	 txtBox6_7.setBackground(Color.green);
					         }
					        	 
					         if(txtBox6_8.isVisible()==true) {
					        	 denkleminUzunlugu++;
						         if(txtBox6_8.getText().equals(txtBoxDenklem8.getText())){
						        	 basariliKutuSayisi++;
						        	 txtBox6_8.setBackground(Color.green);
						         }
						        	 
					         }
					         if(txtBox6_9.isVisible()==true) {
					        	 denkleminUzunlugu++;
					             if(txtBox6_9.getText().equals(txtBoxDenklem9.getText())){
					            	 basariliKutuSayisi++;
					            	 txtBox6_9.setBackground(Color.green);
						         }
						        
					         }
					         
					         txtBox6_1.setEnabled(false);
					         txtBox6_2.setEnabled(false);
					         txtBox6_3.setEnabled(false);
					         txtBox6_4.setEnabled(false);
					         txtBox6_5.setEnabled(false);
					         txtBox6_6.setEnabled(false);
					         txtBox6_7.setEnabled(false);
					         txtBox6_8.setEnabled(false);
					         txtBox6_9.setEnabled(false);
					         if(basariliKutuSayisi == denkleminUzunlugu) {
					        	 
					        	lblSure.setVisible(false);
					        	sure = Integer.parseInt(lblSure.getText());
					        	basariliOlunanSatir = 6;
					        	 lblBasarili.setForeground(Color.green);
					        	lblBasarili.setText("Tebrikler, "+sure+" sn içerisinde tamamladınız...");
					        	lblBasarili.setVisible(true);
					        	btnBasla.setVisible(false);
					        	Istatistik ist = istatistikGetir();

					        	int basariliOyunAdet = ist.getBasariliOyunAdet();
					        	basariliOyunAdet++;
					        	double basariliKacSatirda = ist.getBasarililarOrtKacSatirdaTamamlanmis();
					        	double basariliOrtSure = ist.getBasarililarOrtSure();
					        	
					        	double ortalamaSatir = ((basariliKacSatirda*(basariliOyunAdet-1))+basariliOlunanSatir)/(basariliOyunAdet);
					        	double ortalamaSure = ((basariliOrtSure*(basariliOyunAdet-1)) + sure) / (basariliOyunAdet);
					    
					        	istatistikGuncelle(ist.getYaridaBirakilan(),ist.getBasarisizOyunAdet(),basariliOyunAdet,ortalamaSatir,ortalamaSure);
					       

					         }else {
					        	   lblSure.setVisible(false);
						            lblBasarili.setForeground(Color.red);
						        	lblBasarili.setText("Kaybettiniz, denklem : "+txtBoxDenklem1.getText()+txtBoxDenklem2.getText()+txtBoxDenklem3.getText()+txtBoxDenklem4.getText()+txtBoxDenklem5.getText()+txtBoxDenklem6.getText()+txtBoxDenklem7.getText()+txtBoxDenklem8.getText()+txtBoxDenklem9.getText());
						        	lblBasarili.setVisible(true);
						        	btnBasla.setVisible(false);
						        	Istatistik ist = istatistikGetir();
						        	int basarisizOyunAdet = ist.getBasarisizOyunAdet();
						        	basarisizOyunAdet++;

						        	istatistikGuncelle(ist.getYaridaBirakilan(),basarisizOyunAdet,ist.getBasariliOyunAdet(),ist.getBasarililarOrtKacSatirdaTamamlanmis(),ist.getBasarililarOrtSure());       

					         }
				    	 }
				    	 


				     }

		         
		         
		         
		        }
		        
		        
		        
			}
		});
		btnTahminEt.setEnabled(false);
		btnTahminEt.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnTahminEt.setBounds(42, 620, 205, 50);
		contentPane.add(btnTahminEt);
		
		JButton btnEsittir = new JButton(" = ");
		btnEsittir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(secilen.isEnabled()==true)
				secilen.setText("=");
			}
		});
		btnEsittir.setEnabled(false);
		btnEsittir.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnEsittir.setBounds(518, 559, 63, 50);
		contentPane.add(btnEsittir);
		
		JButton btnCarp = new JButton("*");
		btnCarp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(secilen.isEnabled()==true)
				secilen.setText("*");
			}
		});
		btnCarp.setEnabled(false);
		btnCarp.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCarp.setBounds(445, 559, 63, 50);
		contentPane.add(btnCarp);
		
		JButton btnBol = new JButton("/");
		btnBol.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(secilen.isEnabled()==true)
				secilen.setText("/");
			}
		});
		btnBol.setEnabled(false);
		btnBol.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnBol.setBounds(372, 559, 63, 50);
		contentPane.add(btnBol);
		
		JButton btnCikar = new JButton("-");
		btnCikar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(secilen.isEnabled()==true)
				secilen.setText("-");
			}
		});
		btnCikar.setEnabled(false);
		btnCikar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCikar.setBounds(299, 559, 63, 50);
		contentPane.add(btnCikar);
		
		JButton btn1 = new JButton("1");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn1.setEnabled(false);
		btn1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(secilen.isEnabled()==true)
				secilen.setText("1");
			}
		});
		btn1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn1.setBounds(114, 499, 63, 50);
		contentPane.add(btn1);
		
		JButton btnTopla = new JButton("+");
		btnTopla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(secilen.isEnabled()==true)
				secilen.setText("+");
			}
		});
		btnTopla.setEnabled(false);
		btnTopla.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnTopla.setBounds(229, 559, 63, 50);
		contentPane.add(btnTopla);
		
		JButton btn9 = new JButton("9");
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(secilen.isEnabled()==true)
				secilen.setText("9");
			}
		});
		btn9.setEnabled(false);
		btn9.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn9.setBounds(697, 499, 63, 50);
		contentPane.add(btn9);
		
		JButton btn0 = new JButton("0");
		btn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn0.setEnabled(false);
	
		btn0.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(secilen.isEnabled()==true)
			secilen.setText("0");

			}
		});
		btn0.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn0.setBounds(42, 499, 63, 50);
		contentPane.add(btn0);
		
		txtBox1_1 = new JTextField();
		txtBox1_1.setEnabled(false);
		txtBox1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtBox1_1.setHorizontalAlignment(SwingConstants.CENTER);
		txtBox1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				secilen = txtBox1_1;
				
				if(secilen.isEnabled()==true)
				txtBox1_1.setBackground(Color.white);
				lblHata.setVisible(false);
			}
		});
		

		txtBox1_1.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
			// SATIRLARDA EKLEME YAPILIRKEN SIRAYLA EKLEME OLMASI İÇİN
				secilen = txtBox1_2;
				onceki = txtBox1_1;
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				// SİL BUTONUNUN DOĞRU ÇALIŞMASI İÇİN
				onceki = txtBox1_1;
				secilen = txtBox1_1;
				
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				onceki = txtBox1_1;
				secilen = txtBox1_1;
				
			}
		  });
		
		txtBox1_1.setBounds(42, 82, 63, 50);
		contentPane.add(txtBox1_1);
		txtBox1_1.setColumns(10);
		
		txtBox1_2 = new JTextField();
		txtBox1_2.setEnabled(false);
		txtBox1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtBox1_2.setHorizontalAlignment(SwingConstants.CENTER);
		txtBox1_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				secilen = txtBox1_2;
				
				if(secilen.isEnabled()==true)
				txtBox1_2.setBackground(Color.white);
				lblHata.setVisible(false);
			}
		});
		txtBox1_2.getDocument().addDocumentListener(new DocumentListener() {


			@Override
			public void insertUpdate(DocumentEvent e) {
			
				secilen = txtBox1_3;
				onceki = txtBox1_2;
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				onceki = txtBox1_1;
				secilen = txtBox1_2;
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
	
			}
		  });
		txtBox1_2.setColumns(10);
		txtBox1_2.setBounds(135, 82, 63, 50);
		contentPane.add(txtBox1_2);
		
		txtBox1_3 = new JTextField();
		txtBox1_3.setEnabled(false);
		txtBox1_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtBox1_3.setHorizontalAlignment(SwingConstants.CENTER);
		txtBox1_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				secilen = txtBox1_3;
				if(secilen.isEnabled()==true)
				txtBox1_3.setBackground(Color.white);
				lblHata.setVisible(false);
				
			}
		});
		txtBox1_3.getDocument().addDocumentListener(new DocumentListener() {


			@Override
			public void insertUpdate(DocumentEvent e) {
			
				secilen = txtBox1_4;
				onceki = txtBox1_3;
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				onceki = txtBox1_2;
				secilen = txtBox1_3;
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				
				
			}
		  });
		txtBox1_3.setColumns(10);
		txtBox1_3.setBounds(228, 82, 63, 50);
		contentPane.add(txtBox1_3);
		
		txtBox1_6 = new JTextField();
		txtBox1_6.setEnabled(false);
		txtBox1_6.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtBox1_6.setHorizontalAlignment(SwingConstants.CENTER);
		txtBox1_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				secilen = txtBox1_6;
				if(secilen.isEnabled()==true)
				txtBox1_6.setBackground(Color.white);
				lblHata.setVisible(false);
			}
		});
		txtBox1_6.getDocument().addDocumentListener(new DocumentListener() {


			@Override
			public void insertUpdate(DocumentEvent e) {
			
				secilen = txtBox1_7;
				onceki = txtBox1_6;
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				onceki = txtBox1_5;
				secilen = txtBox1_6;
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				
				
			}
		  });
		txtBox1_6.setColumns(10);
		txtBox1_6.setBounds(507, 82, 63, 50);
		contentPane.add(txtBox1_6);
		
		txtBox1_5 = new JTextField();
		txtBox1_5.setEnabled(false);
		txtBox1_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtBox1_5.setHorizontalAlignment(SwingConstants.CENTER);
		txtBox1_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				secilen = txtBox1_5;
				if(secilen.isEnabled()==true)
				txtBox1_5.setBackground(Color.white);
				lblHata.setVisible(false);
			}
		});
		txtBox1_5.getDocument().addDocumentListener(new DocumentListener() {


			@Override
			public void insertUpdate(DocumentEvent e) {
			
				secilen = txtBox1_6;
				onceki = txtBox1_5;
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				onceki = txtBox1_4;
				secilen = txtBox1_5;
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				
				
			}
		  });
		txtBox1_5.setColumns(10);
		txtBox1_5.setBounds(414, 82, 63, 50);
		contentPane.add(txtBox1_5);
		
		txtBox1_4 = new JTextField();
		txtBox1_4.setEnabled(false);
		txtBox1_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtBox1_4.setHorizontalAlignment(SwingConstants.CENTER);
		txtBox1_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				secilen = txtBox1_4;
			
				if(secilen.isEnabled()==true)
				txtBox1_4.setBackground(Color.white);
				lblHata.setVisible(false);
			}
		});
		txtBox1_4.getDocument().addDocumentListener(new DocumentListener() {


			@Override
			public void insertUpdate(DocumentEvent e) {
			
				secilen = txtBox1_5;
				onceki = txtBox1_4;
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				onceki = txtBox1_3;
				secilen = txtBox1_4;
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				
				
			}
		  });
		txtBox1_4.setColumns(10);
		txtBox1_4.setBounds(321, 82, 63, 50);
		contentPane.add(txtBox1_4);
		
		txtBox1_8 = new JTextField();
		txtBox1_8.setEnabled(false);
		txtBox1_8.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtBox1_8.setHorizontalAlignment(SwingConstants.CENTER);
		txtBox1_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				secilen = txtBox1_8;
				if(secilen.isEnabled()==true)
					txtBox1_8.setBackground(Color.white);
				lblHata.setVisible(false);
			}
		});
		txtBox1_8.getDocument().addDocumentListener(new DocumentListener() {


			@Override
			public void insertUpdate(DocumentEvent e) {
			
				secilen = txtBox1_9;
				onceki = txtBox1_8;
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				onceki = txtBox1_7;
				secilen = txtBox1_8;
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				
				
			}
		  });
		txtBox1_8.setColumns(10);
		txtBox1_8.setBounds(693, 82, 63, 50);
		contentPane.add(txtBox1_8);
		
		txtBox1_7 = new JTextField();
		txtBox1_7.setEnabled(false);
		txtBox1_7.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtBox1_7.setHorizontalAlignment(SwingConstants.CENTER);
		txtBox1_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				secilen = txtBox1_7;
				if(secilen.isEnabled()==true)
					txtBox1_7.setBackground(Color.white);
				lblHata.setVisible(false);
			}
		});
		txtBox1_7.getDocument().addDocumentListener(new DocumentListener() {


			@Override
			public void insertUpdate(DocumentEvent e) {
			
				secilen = txtBox1_8;
				onceki = txtBox1_7;
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				onceki = txtBox1_6;
				secilen = txtBox1_7;
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				
				
			}
		  });
		txtBox1_7.setColumns(10);
		txtBox1_7.setBounds(600, 82, 63, 50);
		contentPane.add(txtBox1_7);
		
		txtBox2_1 = new JTextField();
		txtBox2_1.setEnabled(false);
		txtBox2_1.setHorizontalAlignment(SwingConstants.CENTER);
		txtBox2_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtBox2_1.setColumns(10);
		txtBox2_1.setBounds(42, 142, 63, 50);
		txtBox2_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblHata.setVisible(false);
				secilen = txtBox2_1;
			}
		});
		

		txtBox2_1.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
			
				secilen = txtBox2_2;
				
				onceki = txtBox2_1;
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				onceki = txtBox2_1;
				secilen = txtBox2_1;
				
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				//secilen = txtBox1_2;
				
			}
		  });
		contentPane.add(txtBox2_1);
		
		txtBox2_2 = new JTextField();
		txtBox2_2.setEnabled(false);
		txtBox2_2.setHorizontalAlignment(SwingConstants.CENTER);
		txtBox2_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtBox2_2.setColumns(10);
		txtBox2_2.setBounds(135, 142, 63, 50);
		txtBox2_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblHata.setVisible(false);
				secilen = txtBox2_2;
			}
		});
		

		txtBox2_2.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
			
				secilen = txtBox2_3;
				onceki = txtBox2_2;
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				onceki = txtBox2_1;
				secilen = txtBox2_2;
				
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				//secilen = txtBox1_2;
				
			}
		  });
		contentPane.add(txtBox2_2);
		
		txtBox2_3 = new JTextField();
		txtBox2_3.setEnabled(false);
		txtBox2_3.setHorizontalAlignment(SwingConstants.CENTER);
		txtBox2_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtBox2_3.setColumns(10);
		txtBox2_3.setBounds(228, 142, 63, 50);
		txtBox2_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblHata.setVisible(false);
				secilen = txtBox2_3;
			}
		});
		

		txtBox2_3.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
			
				secilen = txtBox2_4;
				onceki = txtBox2_3;
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				onceki = txtBox2_2;
				secilen = txtBox2_3;
				
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				//secilen = txtBox1_2;
				
			}
		  });
		contentPane.add(txtBox2_3);
		
		txtBox2_4 = new JTextField();
		txtBox2_4.setEnabled(false);
		txtBox2_4.setHorizontalAlignment(SwingConstants.CENTER);
		txtBox2_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtBox2_4.setColumns(10);
		txtBox2_4.setBounds(321, 142, 63, 50);
		txtBox2_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblHata.setVisible(false);
				secilen = txtBox2_4;
			}
		});
		

		txtBox2_4.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
			
				secilen = txtBox2_5;
				onceki = txtBox2_4;
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				onceki = txtBox2_3;
				secilen = txtBox2_4;
				
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				//secilen = txtBox1_2;
				
			}
		  });
		contentPane.add(txtBox2_4);
		
		txtBox2_5 = new JTextField();
		txtBox2_5.setEnabled(false);
		txtBox2_5.setHorizontalAlignment(SwingConstants.CENTER);
		txtBox2_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtBox2_5.setColumns(10);
		txtBox2_5.setBounds(414, 142, 63, 50);
		txtBox2_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblHata.setVisible(false);
				secilen = txtBox2_5;
			}
		});
		

		txtBox2_5.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
			
				secilen = txtBox2_6;
				onceki = txtBox2_5;
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				onceki = txtBox2_4;
				secilen = txtBox2_5;
				
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				//secilen = txtBox1_2;
				
			}
		  });
		contentPane.add(txtBox2_5);
		
		txtBox2_6 = new JTextField();
		txtBox2_6.setEnabled(false);
		txtBox2_6.setHorizontalAlignment(SwingConstants.CENTER);
		txtBox2_6.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtBox2_6.setColumns(10);
		txtBox2_6.setBounds(507, 142, 63, 50);
		txtBox2_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblHata.setVisible(false);
				secilen = txtBox2_6;
			}
		});
		

		txtBox2_6.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
			
				secilen = txtBox2_7;
				onceki = txtBox2_6;
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				onceki = txtBox2_5;
				secilen = txtBox2_6;
				
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				//secilen = txtBox1_2;
				
			}
		  });
		contentPane.add(txtBox2_6);
		
		txtBox2_7 = new JTextField();
		txtBox2_7.setEnabled(false);
		txtBox2_7.setHorizontalAlignment(SwingConstants.CENTER);
		txtBox2_7.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtBox2_7.setColumns(10);
		txtBox2_7.setBounds(600, 142, 63, 50);
		txtBox2_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblHata.setVisible(false);
				secilen = txtBox2_7;
			}
		});
		

		txtBox2_7.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
			
				secilen = txtBox2_8;
				onceki = txtBox2_7;
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				onceki = txtBox2_6;
				secilen = txtBox2_7;
				
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				
				
			}
		  });
		contentPane.add(txtBox2_7);
		
		txtBox2_8 = new JTextField();
		txtBox2_8.setEnabled(false);
		txtBox2_8.setHorizontalAlignment(SwingConstants.CENTER);
		txtBox2_8.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtBox2_8.setColumns(10);
		txtBox2_8.setBounds(693, 142, 63, 50);
		txtBox2_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblHata.setVisible(false);
				secilen = txtBox2_8;
			}
		});
		

		txtBox2_8.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
			
				secilen = txtBox2_9;
				onceki = txtBox2_8;
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				onceki = txtBox2_7;
				secilen = txtBox2_8;
				
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
			
				
			}
		  });
		contentPane.add(txtBox2_8);
		
		txtBox3_1 = new JTextField();
		txtBox3_1.setEnabled(false);
		txtBox3_1.setHorizontalAlignment(SwingConstants.CENTER);
		txtBox3_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtBox3_1.setColumns(10);
		txtBox3_1.setBounds(42, 202, 63, 50);
		txtBox3_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblHata.setVisible(false);
				secilen = txtBox3_1;
			}
		});
		

		txtBox3_1.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
			
				secilen = txtBox3_2;
				onceki = txtBox3_1;
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				secilen = txtBox3_1;
				onceki = txtBox3_1;
				
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				//secilen = txtBox1_2;
				
			}
		  });
		contentPane.add(txtBox3_1);
		
		txtBox3_2 = new JTextField();
		txtBox3_2.setEnabled(false);
		txtBox3_2.setHorizontalAlignment(SwingConstants.CENTER);
		txtBox3_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtBox3_2.setColumns(10);
		txtBox3_2.setBounds(135, 202, 63, 50);
		txtBox3_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblHata.setVisible(false);
				secilen = txtBox3_2;
			}
		});
		

		txtBox3_2.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
			
				secilen = txtBox3_3;
				onceki = txtBox3_2;
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				onceki = txtBox3_1;
				secilen = txtBox3_2;
				
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				
				
			}
		  });
		contentPane.add(txtBox3_2);
		
		txtBox3_3 = new JTextField();
		txtBox3_3.setEnabled(false);
		txtBox3_3.setHorizontalAlignment(SwingConstants.CENTER);
		txtBox3_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtBox3_3.setColumns(10);
		txtBox3_3.setBounds(228, 202, 63, 50);
		txtBox3_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				secilen = txtBox3_3;
				lblHata.setVisible(false);
			}
		});
		

		txtBox3_3.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
			
				secilen = txtBox3_4;
				onceki = txtBox3_3;
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				onceki = txtBox3_2;
				secilen = txtBox3_3;
				
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				
				
			}
		  });
		contentPane.add(txtBox3_3);
		
		txtBox3_4 = new JTextField();
		txtBox3_4.setEnabled(false);
		txtBox3_4.setHorizontalAlignment(SwingConstants.CENTER);
		txtBox3_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtBox3_4.setColumns(10);
		txtBox3_4.setBounds(321, 202, 63, 50);
		txtBox3_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				secilen = txtBox3_4;
				lblHata.setVisible(false);
			}
		});
		

		txtBox3_4.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
			
				secilen = txtBox3_5;
				onceki = txtBox3_4;
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				onceki = txtBox3_3;
				secilen = txtBox3_4;
				
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				
				
			}
		  });
		contentPane.add(txtBox3_4);
		
		txtBox3_5 = new JTextField();
		txtBox3_5.setEnabled(false);
		txtBox3_5.setHorizontalAlignment(SwingConstants.CENTER);
		txtBox3_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtBox3_5.setColumns(10);
		txtBox3_5.setBounds(414, 202, 63, 50);
		txtBox3_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				secilen = txtBox3_5;
				lblHata.setVisible(false);
			}
		});
		

		txtBox3_5.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
			
				secilen = txtBox3_6;
				onceki = txtBox3_5;

			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				onceki = txtBox3_4;
				secilen = txtBox3_5;
				
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				//secilen = txtBox1_2;
				
			}
		  });
		contentPane.add(txtBox3_5);
		
		txtBox3_6 = new JTextField();
		txtBox3_6.setEnabled(false);
		txtBox3_6.setHorizontalAlignment(SwingConstants.CENTER);
		txtBox3_6.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtBox3_6.setColumns(10);
		txtBox3_6.setBounds(507, 202, 63, 50);
		txtBox3_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				secilen = txtBox3_6;
				lblHata.setVisible(false);
			}
		});
		

		txtBox3_6.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
			
				secilen = txtBox3_7;
				onceki = txtBox3_6;

			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				onceki = txtBox3_5;
				secilen = txtBox3_6;
				
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				//secilen = txtBox1_2;
				
			}
		  });
		contentPane.add(txtBox3_6);
		
		txtBox3_7 = new JTextField();
		txtBox3_7.setEnabled(false);
		txtBox3_7.setHorizontalAlignment(SwingConstants.CENTER);
		txtBox3_7.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtBox3_7.setColumns(10);
		txtBox3_7.setBounds(600, 202, 63, 50);
		txtBox3_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				secilen = txtBox3_7;
				lblHata.setVisible(false);
			}
		});
		

		txtBox3_7.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
			
				secilen = txtBox3_8;
				onceki = txtBox3_7;
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				onceki = txtBox3_6;
				secilen = txtBox3_7;
				
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				//secilen = txtBox1_2;
				
			}
		  });
		contentPane.add(txtBox3_7);
		
		txtBox3_8 = new JTextField();
		txtBox3_8.setEnabled(false);
		txtBox3_8.setHorizontalAlignment(SwingConstants.CENTER);
		txtBox3_8.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtBox3_8.setColumns(10);
		txtBox3_8.setBounds(693, 202, 63, 50);
		txtBox3_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				secilen = txtBox3_8;
				lblHata.setVisible(false);
			}
		});
		

		txtBox3_8.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
			
				secilen = txtBox3_9;
				onceki = txtBox3_8;
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				onceki = txtBox3_7;
				secilen = txtBox3_8;
				
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				//secilen = txtBox1_2;
				
			}
		  });
		contentPane.add(txtBox3_8);
		
		txtBox4_1 = new JTextField();
		txtBox4_1.setEnabled(false);
		txtBox4_1.setHorizontalAlignment(SwingConstants.CENTER);
		txtBox4_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtBox4_1.setColumns(10);
		txtBox4_1.setBounds(42, 262, 63, 50);
		txtBox4_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				secilen = txtBox4_1;
				lblHata.setVisible(false);
			}
		});
		

		txtBox4_1.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
			
				secilen = txtBox4_2;
				onceki = txtBox4_1;
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				onceki = txtBox4_1;
				secilen = txtBox4_1;
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				//secilen = txtBox1_2;
				
			}
		  });
		contentPane.add(txtBox4_1);
		
		txtBox4_2 = new JTextField();
		txtBox4_2.setEnabled(false);
		txtBox4_2.setHorizontalAlignment(SwingConstants.CENTER);
		txtBox4_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtBox4_2.setColumns(10);
		txtBox4_2.setBounds(135, 262, 63, 50);
		txtBox4_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				secilen = txtBox4_2;
				lblHata.setVisible(false);
			}
		});
		

		txtBox4_2.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
			
				secilen = txtBox4_3;
				onceki = txtBox4_2;
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				onceki = txtBox4_1;
				secilen = txtBox4_2;
				
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				//secilen = txtBox1_2;
				
			}
		  });
		contentPane.add(txtBox4_2);
		
		txtBox4_3 = new JTextField();
		txtBox4_3.setEnabled(false);
		txtBox4_3.setHorizontalAlignment(SwingConstants.CENTER);
		txtBox4_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtBox4_3.setColumns(10);
		txtBox4_3.setBounds(228, 262, 63, 50);
		txtBox4_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				secilen = txtBox4_3;
				lblHata.setVisible(false);
			}
		});
		

		txtBox4_3.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
			
				secilen = txtBox4_4;
				onceki = txtBox4_3;
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				onceki = txtBox4_2;
				secilen = txtBox4_3;
				
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				//secilen = txtBox1_2;
				
			}
		  });
		contentPane.add(txtBox4_3);
		
		txtBox4_4 = new JTextField();
		txtBox4_4.setEnabled(false);
		txtBox4_4.setHorizontalAlignment(SwingConstants.CENTER);
		txtBox4_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtBox4_4.setColumns(10);
		txtBox4_4.setBounds(321, 262, 63, 50);
		txtBox4_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				secilen = txtBox4_4;
				lblHata.setVisible(false);
			}
		});
		

		txtBox4_4.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
			
				secilen = txtBox4_5;
				onceki = txtBox4_4;
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				onceki = txtBox4_3;
				secilen = txtBox4_4;
				
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				//secilen = txtBox1_2;
				
			}
		  });
		contentPane.add(txtBox4_4);
		
		txtBox4_5 = new JTextField();
		txtBox4_5.setEnabled(false);
		txtBox4_5.setHorizontalAlignment(SwingConstants.CENTER);
		txtBox4_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtBox4_5.setColumns(10);
		txtBox4_5.setBounds(414, 262, 63, 50);
		txtBox4_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				secilen = txtBox4_5;
				lblHata.setVisible(false);
			}
		});
		

		txtBox4_5.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
			
				secilen = txtBox4_6;
				onceki = txtBox4_5;
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				onceki = txtBox4_4;
				secilen = txtBox4_5;
				
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				//secilen = txtBox1_2;
				
			}
		  });
		contentPane.add(txtBox4_5);
		
		txtBox4_6 = new JTextField();
		txtBox4_6.setEnabled(false);
		txtBox4_6.setHorizontalAlignment(SwingConstants.CENTER);
		txtBox4_6.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtBox4_6.setColumns(10);
		txtBox4_6.setBounds(507, 262, 63, 50);
		txtBox4_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				secilen = txtBox4_6;
				lblHata.setVisible(false);
			}
		});
		

		txtBox4_6.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
			
				secilen = txtBox4_7;
				onceki = txtBox4_6;
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				onceki = txtBox4_5;
				secilen = txtBox4_6;
				
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				//secilen = txtBox1_2;
				
			}
		  });
		contentPane.add(txtBox4_6);
		
		txtBox4_7 = new JTextField();
		txtBox4_7.setEnabled(false);
		txtBox4_7.setHorizontalAlignment(SwingConstants.CENTER);
		txtBox4_7.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtBox4_7.setColumns(10);
		txtBox4_7.setBounds(600, 262, 63, 50);
		txtBox4_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				secilen = txtBox4_7;
				lblHata.setVisible(false);
			}
		});
		

		txtBox4_7.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
			
				secilen = txtBox4_8;
				onceki = txtBox4_7;				
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				onceki = txtBox4_6;
				secilen = txtBox4_7;
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				//secilen = txtBox1_2;
				
			}
		  });
		contentPane.add(txtBox4_7);
		
		txtBox4_8 = new JTextField();
		txtBox4_8.setEnabled(false);
		txtBox4_8.setHorizontalAlignment(SwingConstants.CENTER);
		txtBox4_8.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtBox4_8.setColumns(10);
		txtBox4_8.setBounds(693, 262, 63, 50);
		txtBox4_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				secilen = txtBox4_8;
				lblHata.setVisible(false);
			}
		});
		

		txtBox4_8.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
			
				secilen = txtBox4_9;
				onceki = txtBox4_8;
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				onceki = txtBox4_7;
				secilen = txtBox4_8;
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				//secilen = txtBox1_2;
				
			}
		  });
		contentPane.add(txtBox4_8);
		
		txtBox5_1 = new JTextField();
		txtBox5_1.setEnabled(false);
		txtBox5_1.setHorizontalAlignment(SwingConstants.CENTER);
		txtBox5_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtBox5_1.setColumns(10);
		txtBox5_1.setBounds(42, 322, 63, 50);
		txtBox5_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				secilen = txtBox5_1;
				lblHata.setVisible(false);
			}
		});
		

		txtBox5_1.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
			
				secilen = txtBox5_2;
				onceki = txtBox5_1;
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				onceki = txtBox5_1;
				secilen = txtBox5_1;
				
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				//secilen = txtBox1_2;
				
			}
		  });
		contentPane.add(txtBox5_1);
		
		txtBox5_2 = new JTextField();
		txtBox5_2.setEnabled(false);
		txtBox5_2.setHorizontalAlignment(SwingConstants.CENTER);
		txtBox5_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtBox5_2.setColumns(10);
		txtBox5_2.setBounds(135, 322, 63, 50);
		txtBox5_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				secilen = txtBox5_2;
				lblHata.setVisible(false);
			}
		});
		

		txtBox5_2.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
			
				secilen = txtBox5_3;
				onceki = txtBox5_2;
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				onceki = txtBox5_1;
				secilen = txtBox5_2;
				
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				//secilen = txtBox1_2;
				
			}
		  });
		contentPane.add(txtBox5_2);
		
		txtBox5_3 = new JTextField();
		txtBox5_3.setEnabled(false);
		txtBox5_3.setHorizontalAlignment(SwingConstants.CENTER);
		txtBox5_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtBox5_3.setColumns(10);
		txtBox5_3.setBounds(228, 322, 63, 50);
		txtBox5_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				secilen = txtBox5_3;
				lblHata.setVisible(false);
			}
		});
		

		txtBox5_3.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
			
				secilen = txtBox5_4;
				onceki = txtBox5_3;
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				onceki = txtBox5_2;
				secilen = txtBox5_3;
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				//secilen = txtBox1_2;
				
			}
		  });
		contentPane.add(txtBox5_3);
		
		txtBox5_4 = new JTextField();
		txtBox5_4.setEnabled(false);
		txtBox5_4.setHorizontalAlignment(SwingConstants.CENTER);
		txtBox5_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtBox5_4.setColumns(10);
		txtBox5_4.setBounds(321, 322, 63, 50);
		txtBox5_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				secilen = txtBox5_4;
				lblHata.setVisible(false);
			}
		});
		

		txtBox5_4.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
			
				secilen = txtBox5_5;
				onceki = txtBox5_4;
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				onceki = txtBox5_3;
				secilen = txtBox5_4;
				
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				//secilen = txtBox1_2;
				
			}
		  });
		contentPane.add(txtBox5_4);
		
		txtBox5_5 = new JTextField();
		txtBox5_5.setEnabled(false);
		txtBox5_5.setHorizontalAlignment(SwingConstants.CENTER);
		txtBox5_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtBox5_5.setColumns(10);
		txtBox5_5.setBounds(414, 322, 63, 50);
		txtBox5_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				secilen = txtBox5_5;
				lblHata.setVisible(false);
			}
		});
		

		txtBox5_5.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
			
				secilen = txtBox5_6;
				onceki = txtBox5_5;
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				onceki = txtBox5_4;
				secilen = txtBox5_5;
				
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				//secilen = txtBox1_2;
				
			}
		  });
		contentPane.add(txtBox5_5);
		
		txtBox5_6 = new JTextField();
		txtBox5_6.setEnabled(false);
		txtBox5_6.setHorizontalAlignment(SwingConstants.CENTER);
		txtBox5_6.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtBox5_6.setColumns(10);
		txtBox5_6.setBounds(507, 322, 63, 50);
		txtBox5_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				secilen = txtBox5_6;
				lblHata.setVisible(false);
			}
		});
		

		txtBox5_6.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
			
				secilen = txtBox5_7;
				onceki = txtBox5_6;
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				onceki = txtBox5_5;
				secilen = txtBox5_6;
				
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				//secilen = txtBox1_2;
				
			}
		  });
		contentPane.add(txtBox5_6);
		
		txtBox5_7 = new JTextField();
		txtBox5_7.setEnabled(false);
		txtBox5_7.setHorizontalAlignment(SwingConstants.CENTER);
		txtBox5_7.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtBox5_7.setColumns(10);
		txtBox5_7.setBounds(600, 322, 63, 50);
		txtBox5_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				secilen = txtBox5_7;
				lblHata.setVisible(false);
			}
		});
		

		txtBox5_7.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
			
				secilen = txtBox5_8;
				onceki = txtBox5_7;
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				onceki = txtBox5_6;
				secilen = txtBox5_7;
				
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				//secilen = txtBox1_2;
				
			}
		  });
		contentPane.add(txtBox5_7);
		
		txtBox5_8 = new JTextField();
		txtBox5_8.setEnabled(false);
		txtBox5_8.setHorizontalAlignment(SwingConstants.CENTER);
		txtBox5_8.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtBox5_8.setColumns(10);
		txtBox5_8.setBounds(693, 322, 63, 50);
		txtBox5_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				secilen = txtBox5_8;
				lblHata.setVisible(false);
			}
		});
		

		txtBox5_8.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
			
				secilen = txtBox5_9;
				onceki = txtBox5_8;
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				onceki = txtBox5_7;
				secilen = txtBox5_8;
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				//secilen = txtBox1_2;
				
			}
		  });
		contentPane.add(txtBox5_8);
		
		txtBox6_1 = new JTextField();
		txtBox6_1.setEnabled(false);
		txtBox6_1.setHorizontalAlignment(SwingConstants.CENTER);
		txtBox6_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtBox6_1.setColumns(10);
		txtBox6_1.setBounds(42, 382, 63, 50);
		txtBox6_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				secilen = txtBox6_1;
				lblHata.setVisible(false);
			}
		});
		

		txtBox6_1.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
			
				secilen = txtBox6_2;
				onceki = txtBox6_1;
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				onceki = txtBox6_1;
				secilen = txtBox6_1;
				
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				//secilen = txtBox1_2;
				
			}
		  });
		contentPane.add(txtBox6_1);
		
		txtBox6_2 = new JTextField();
		txtBox6_2.setEnabled(false);
		txtBox6_2.setHorizontalAlignment(SwingConstants.CENTER);
		txtBox6_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtBox6_2.setColumns(10);
		txtBox6_2.setBounds(135, 382, 63, 50);
		txtBox6_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				secilen = txtBox6_2;
				lblHata.setVisible(false);
			}
		});
		

		txtBox6_2.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
			
				secilen = txtBox6_3;
				onceki = txtBox6_2;
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				onceki = txtBox6_1;
				secilen = txtBox6_2;
				
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				//secilen = txtBox1_2;
				
			}
		  });
		contentPane.add(txtBox6_2);
		
		txtBox6_3 = new JTextField();
		txtBox6_3.setEnabled(false);
		txtBox6_3.setHorizontalAlignment(SwingConstants.CENTER);
		txtBox6_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtBox6_3.setColumns(10);
		txtBox6_3.setBounds(228, 382, 63, 50);
		txtBox6_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				secilen = txtBox6_3;
				lblHata.setVisible(false);
			}
		});
		

		txtBox6_3.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
			
				secilen = txtBox6_4;
				onceki = txtBox6_3;
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				onceki = txtBox6_2;
				secilen = txtBox6_3;
				
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				//secilen = txtBox1_2;
				
			}
		  });
		contentPane.add(txtBox6_3);
		
		txtBox6_4 = new JTextField();
		txtBox6_4.setEnabled(false);
		txtBox6_4.setHorizontalAlignment(SwingConstants.CENTER);
		txtBox6_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtBox6_4.setColumns(10);
		txtBox6_4.setBounds(321, 382, 63, 50);
		txtBox6_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				secilen = txtBox6_4;
				lblHata.setVisible(false);
			}
		});
		

		txtBox6_4.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
			
				secilen = txtBox6_5;
				onceki = txtBox6_4;
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				onceki = txtBox6_3;
				secilen = txtBox6_4;
				
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				//secilen = txtBox1_2;
				
			}
		  });
		contentPane.add(txtBox6_4);
		
		txtBox6_5 = new JTextField();
		txtBox6_5.setEnabled(false);
		txtBox6_5.setHorizontalAlignment(SwingConstants.CENTER);
		txtBox6_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtBox6_5.setColumns(10);
		txtBox6_5.setBounds(414, 382, 63, 50);
		txtBox6_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				secilen = txtBox6_5;
				lblHata.setVisible(false);
			}
		});
		

		txtBox6_5.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
			
				secilen = txtBox6_6;
				onceki = txtBox6_5;
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				onceki = txtBox6_4;
				secilen = txtBox6_5;
				
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				//secilen = txtBox1_2;
				
			}
		  });
		contentPane.add(txtBox6_5);
		
		txtBox6_6 = new JTextField();
		txtBox6_6.setEnabled(false);
		txtBox6_6.setHorizontalAlignment(SwingConstants.CENTER);
		txtBox6_6.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtBox6_6.setColumns(10);
		txtBox6_6.setBounds(507, 382, 63, 50);
		txtBox6_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				secilen = txtBox6_6;
				lblHata.setVisible(false);
			}
		});
		

		txtBox6_6.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
			
				secilen = txtBox6_7;
				onceki = txtBox6_6;
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				onceki = txtBox6_5;
				secilen = txtBox6_6;
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				//secilen = txtBox1_2;
				
			}
		  });
		contentPane.add(txtBox6_6);
		
		txtBox6_7 = new JTextField();
		txtBox6_7.setEnabled(false);
		txtBox6_7.setHorizontalAlignment(SwingConstants.CENTER);
		txtBox6_7.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtBox6_7.setColumns(10);
		txtBox6_7.setBounds(600, 382, 63, 50);
		txtBox6_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				secilen = txtBox6_7;
				lblHata.setVisible(false);
			}
		});
		

		txtBox6_7.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
			
				secilen = txtBox6_8;
				onceki = txtBox6_7;
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				onceki = txtBox6_6;
				secilen = txtBox6_7;
				
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				//secilen = txtBox1_2;
				
			}
		  });
		contentPane.add(txtBox6_7);
		
		txtBox6_8 = new JTextField();
		txtBox6_8.setEnabled(false);
		txtBox6_8.setHorizontalAlignment(SwingConstants.CENTER);
		txtBox6_8.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtBox6_8.setColumns(10);
		txtBox6_8.setBounds(693, 382, 63, 50);
		txtBox6_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				secilen = txtBox6_8;
				lblHata.setVisible(false);
			}
		});
		

		txtBox6_8.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
			
				secilen = txtBox6_9;
				onceki = txtBox6_8;
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				onceki = txtBox6_7;
				secilen = txtBox6_8;
				
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				//secilen = txtBox1_2;
				
			}
		  });
		contentPane.add(txtBox6_8);
		
		txtBox1_9 = new JTextField();
		txtBox1_9.setHorizontalAlignment(SwingConstants.CENTER);
		txtBox1_9.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtBox1_9.setEnabled(false);
		txtBox1_9.setColumns(10);
		txtBox1_9.setBounds(787, 82, 63, 50);
		txtBox1_9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				secilen = txtBox1_9;
				if(secilen.isEnabled()==true)
					txtBox1_9.setBackground(Color.white);
				lblHata.setVisible(false);
			}
		});
		txtBox1_9.getDocument().addDocumentListener(new DocumentListener() {


			@Override
			public void insertUpdate(DocumentEvent e) {
			
				secilen = txtBox1_9;
				onceki = txtBox1_9;
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				secilen = txtBox1_9;
				onceki = txtBox1_8;
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				
				
			}
		  });
		contentPane.add(txtBox1_9);
		
		txtBox2_9 = new JTextField();
		txtBox2_9.setHorizontalAlignment(SwingConstants.CENTER);
		txtBox2_9.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtBox2_9.setEnabled(false);
		txtBox2_9.setColumns(10);
		txtBox2_9.setBounds(787, 142, 63, 50);
		txtBox2_9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				secilen = txtBox2_9;
				lblHata.setVisible(false);
			}
		});
		txtBox2_9.getDocument().addDocumentListener(new DocumentListener() {


			@Override
			public void insertUpdate(DocumentEvent e) {
			
				secilen = txtBox2_9;
				onceki = txtBox2_9;
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				secilen = txtBox2_9;
				onceki = txtBox2_8;
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				
				
			}
		  });
		contentPane.add(txtBox2_9);
		
		txtBox3_9 = new JTextField();
		txtBox3_9.setHorizontalAlignment(SwingConstants.CENTER);
		txtBox3_9.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtBox3_9.setEnabled(false);
		txtBox3_9.setColumns(10);
		txtBox3_9.setBounds(787, 202, 63, 50);
		txtBox3_9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				secilen = txtBox3_9;
				lblHata.setVisible(false);
			}
		});
		txtBox3_9.getDocument().addDocumentListener(new DocumentListener() {


			@Override
			public void insertUpdate(DocumentEvent e) {
			
				secilen = txtBox3_9;
				onceki = txtBox3_9;
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				onceki = txtBox3_8;
				secilen = txtBox3_9;
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				
				
			}
		  });
		contentPane.add(txtBox3_9);
		
		txtBox4_9 = new JTextField();
		txtBox4_9.setHorizontalAlignment(SwingConstants.CENTER);
		txtBox4_9.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtBox4_9.setEnabled(false);
		txtBox4_9.setColumns(10);
		txtBox4_9.setBounds(787, 262, 63, 50);
		txtBox4_9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				secilen = txtBox4_9;
				lblHata.setVisible(false);
			}
		});
		txtBox4_9.getDocument().addDocumentListener(new DocumentListener() {


			@Override
			public void insertUpdate(DocumentEvent e) {
			
				secilen = txtBox4_9;
				onceki = txtBox4_9;
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				onceki = txtBox4_8;
				secilen = txtBox4_9;
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				
				
			}
		  });
		contentPane.add(txtBox4_9);
		
		txtBox5_9 = new JTextField();
		txtBox5_9.setHorizontalAlignment(SwingConstants.CENTER);
		txtBox5_9.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtBox5_9.setEnabled(false);
		txtBox5_9.setColumns(10);
		txtBox5_9.setBounds(787, 322, 63, 50);
		txtBox5_9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				secilen = txtBox5_9;
				lblHata.setVisible(false);
			}
		});
		txtBox5_9.getDocument().addDocumentListener(new DocumentListener() {


			@Override
			public void insertUpdate(DocumentEvent e) {
			
				secilen = txtBox5_9;
				onceki = txtBox5_9;
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				onceki = txtBox5_8;
				secilen = txtBox5_9;
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				
				
			}
		  });
		contentPane.add(txtBox5_9);
		
		txtBox6_9 = new JTextField();
		txtBox6_9.setHorizontalAlignment(SwingConstants.CENTER);
		txtBox6_9.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtBox6_9.setEnabled(false);
		txtBox6_9.setColumns(10);
		txtBox6_9.setBounds(787, 382, 63, 50);
		txtBox6_9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				secilen = txtBox6_9;
				lblHata.setVisible(false);
			}
		});
		txtBox6_9.getDocument().addDocumentListener(new DocumentListener() {


			@Override
			public void insertUpdate(DocumentEvent e) {
			
				secilen = txtBox6_9;
				onceki = txtBox6_9;
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				onceki = txtBox6_8;
				secilen = txtBox6_9;
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				
				
			}
		  });
		contentPane.add(txtBox6_9);
		
		txtBoxDenklem1 = new JTextField();
		txtBoxDenklem1.setHorizontalAlignment(SwingConstants.CENTER);
		txtBoxDenklem1.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtBoxDenklem1.setEnabled(false);
		txtBoxDenklem1.setColumns(10);
		txtBoxDenklem1.setBounds(42, 439, 63, 50);
		txtBoxDenklem1.setVisible(false);
		contentPane.add(txtBoxDenklem1);
		
		txtBoxDenklem2 = new JTextField();
		txtBoxDenklem2.setHorizontalAlignment(SwingConstants.CENTER);
		txtBoxDenklem2.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtBoxDenklem2.setEnabled(false);
		txtBoxDenklem2.setColumns(10);
		txtBoxDenklem2.setBounds(135, 439, 63, 50);
		txtBoxDenklem2.setVisible(false);
		
		contentPane.add(txtBoxDenklem2);
		
		txtBoxDenklem3 = new JTextField();
		txtBoxDenklem3.setHorizontalAlignment(SwingConstants.CENTER);
		txtBoxDenklem3.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtBoxDenklem3.setEnabled(false);
		txtBoxDenklem3.setColumns(10);
		txtBoxDenklem3.setBounds(228, 439, 63, 50);
		txtBoxDenklem3.setVisible(false);
		contentPane.add(txtBoxDenklem3);
		
		txtBoxDenklem4 = new JTextField();
		txtBoxDenklem4.setHorizontalAlignment(SwingConstants.CENTER);
		txtBoxDenklem4.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtBoxDenklem4.setEnabled(false);
		txtBoxDenklem4.setColumns(10);
		txtBoxDenklem4.setBounds(321, 439, 63, 50);
		txtBoxDenklem4.setVisible(false);
		contentPane.add(txtBoxDenklem4);
		
		txtBoxDenklem5 = new JTextField();
		txtBoxDenklem5.setHorizontalAlignment(SwingConstants.CENTER);
		txtBoxDenklem5.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtBoxDenklem5.setEnabled(false);
		txtBoxDenklem5.setColumns(10);
		txtBoxDenklem5.setBounds(414, 439, 63, 50);
		txtBoxDenklem5.setVisible(false);
		contentPane.add(txtBoxDenklem5);
		
		txtBoxDenklem6 = new JTextField();
		txtBoxDenklem6.setHorizontalAlignment(SwingConstants.CENTER);
		txtBoxDenklem6.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtBoxDenklem6.setEnabled(false);
		txtBoxDenklem6.setColumns(10);
		txtBoxDenklem6.setBounds(507, 439, 63, 50);
		txtBoxDenklem6.setVisible(false);
		contentPane.add(txtBoxDenklem6);
		
		txtBoxDenklem7 = new JTextField();
		txtBoxDenklem7.setHorizontalAlignment(SwingConstants.CENTER);
		txtBoxDenklem7.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtBoxDenklem7.setEnabled(false);
		txtBoxDenklem7.setColumns(10);
		txtBoxDenklem7.setBounds(600, 439, 63, 50);
		txtBoxDenklem7.setVisible(false);
		contentPane.add(txtBoxDenklem7);
		
		txtBoxDenklem8 = new JTextField();
		txtBoxDenklem8.setHorizontalAlignment(SwingConstants.CENTER);
		txtBoxDenklem8.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtBoxDenklem8.setEnabled(false);
		txtBoxDenklem8.setColumns(10);
		txtBoxDenklem8.setBounds(693, 439, 63, 50);
		txtBoxDenklem8.setVisible(false);
		contentPane.add(txtBoxDenklem8);
		
		txtBoxDenklem9 = new JTextField();
		txtBoxDenklem9.setHorizontalAlignment(SwingConstants.CENTER);
		txtBoxDenklem9.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtBoxDenklem9.setEnabled(false);
		txtBoxDenklem9.setColumns(10);
		txtBoxDenklem9.setBounds(787, 442, 63, 50);
		txtBoxDenklem9.setVisible(false);
		contentPane.add(txtBoxDenklem9);
		
		lblHata = new JLabel("Hatalı değer girdiniz, lütfen tekrar deneyiniz...");
		lblHata.setForeground(Color.RED);
		lblHata.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblHata.setBounds(132, 439, 482, 50);
		lblHata.setVisible(false);
		contentPane.add(lblHata);
		
		lblBasarili = new JLabel("Tebrikler Başardınız.");
		lblBasarili.setForeground(Color.GREEN);
		lblBasarili.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblBasarili.setBounds(135, 436, 482, 50);
		lblBasarili.setVisible(false);
		contentPane.add(lblBasarili);
		
		JButton btnAnaMenu = new JButton("Ana Menü");
		btnAnaMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			myTimer.cancel();
				Ana_Menu frm = new Ana_Menu();
				frm.setVisible(true);
				dispose();
			}
		});
		btnAnaMenu.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnAnaMenu.setBounds(749, 10, 101, 50);
		contentPane.add(btnAnaMenu);
		
		lblNewLabel = new JLabel("19011021 - Yusuf Taha Kara");
		lblNewLabel.setForeground(Color.GRAY);
		lblNewLabel.setBounds(653, 680, 197, 13);
		contentPane.add(lblNewLabel);
		
		lblSure = new JLabel("");
		lblSure.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSure.setBounds(656, 8, 83, 50);
		contentPane.add(lblSure);
		
		btnDevamEt = new JButton("DEVAM ET");
		btnDevamEt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                btnBasla.setVisible(false);
                btnDevamEt.setVisible(false);
				try {
					 
					btn0.setEnabled(true);
					btn1.setEnabled(true);
					btn2.setEnabled(true);
					btn3.setEnabled(true);
					btn4.setEnabled(true);
					btn5.setEnabled(true);
					btn6.setEnabled(true);
					btn7.setEnabled(true);
					btn8.setEnabled(true);
					btn9.setEnabled(true);
					btnTopla.setEnabled(true);
					btnCikar.setEnabled(true);
					btnBol.setEnabled(true);
					btnCarp.setEnabled(true);
					btnTahminEt.setEnabled(true);
					btnSil.setEnabled(true);
					btnEsittir.setEnabled(true);
					btnSonraBitir.setEnabled(true);
					
	                txtBox1_1.setEnabled(true);
					txtBox1_2.setEnabled(true);
					txtBox1_3.setEnabled(true);
					txtBox1_4.setEnabled(true);
					txtBox1_5.setEnabled(true);
					txtBox1_6.setEnabled(true);
					txtBox1_7.setEnabled(true);
					txtBox1_8.setEnabled(true);
					txtBox1_9.setEnabled(true);
					
					txtBox2_1.setEnabled(false);
					txtBox2_2.setEnabled(false);
					txtBox2_3.setEnabled(false);
					txtBox2_4.setEnabled(false);
					txtBox2_5.setEnabled(false);
					txtBox2_6.setEnabled(false);
					txtBox2_7.setEnabled(false);
					txtBox2_8.setEnabled(false);
					txtBox2_9.setEnabled(false);
					
	                txtBox3_1.setEnabled(false);
					txtBox3_2.setEnabled(false);
					txtBox3_3.setEnabled(false);
					txtBox3_4.setEnabled(false);
					txtBox3_5.setEnabled(false);
					txtBox3_6.setEnabled(false);
					txtBox3_7.setEnabled(false);
					txtBox3_8.setEnabled(false);
					txtBox3_9.setEnabled(false);
					
	                txtBox4_1.setEnabled(false);
					txtBox4_2.setEnabled(false);
					txtBox4_3.setEnabled(false);
					txtBox4_4.setEnabled(false);
					txtBox4_5.setEnabled(false);
					txtBox4_6.setEnabled(false);
					txtBox4_7.setEnabled(false);
					txtBox4_8.setEnabled(false);
					txtBox4_9.setEnabled(false);
					
	                txtBox5_1.setEnabled(false);
					txtBox5_2.setEnabled(false);
					txtBox5_3.setEnabled(false);
					txtBox5_4.setEnabled(false);
					txtBox5_5.setEnabled(false);
					txtBox5_6.setEnabled(false);
					txtBox5_7.setEnabled(false);
					txtBox5_8.setEnabled(false);
					txtBox5_9.setEnabled(false);
					
	                txtBox6_1.setEnabled(false);
					txtBox6_2.setEnabled(false);
					txtBox6_3.setEnabled(false);
					txtBox6_4.setEnabled(false);
					txtBox6_5.setEnabled(false);
					txtBox6_6.setEnabled(false);
					txtBox6_7.setEnabled(false);
					txtBox6_8.setEnabled(false);
					txtBox6_9.setEnabled(false);
					
					
					txtBox1_8.setVisible(false);
					txtBox2_8.setVisible(false);
					txtBox3_8.setVisible(false);
					txtBox4_8.setVisible(false);
					txtBox5_8.setVisible(false);
					txtBox6_8.setVisible(false);
					
					txtBox1_9.setVisible(false);
					txtBox2_9.setVisible(false);
					txtBox3_9.setVisible(false);
					txtBox4_9.setVisible(false);
					txtBox5_9.setVisible(false);
					txtBox6_9.setVisible(false);

					
					
					btnTahminEt.setEnabled(true);
					// kaydettiğimiz oyunun verilerini okunup satırlar doldurulacak
					FileInputStream fileIn = new FileInputStream("sonraBitir.txt");
					ObjectInputStream in = new ObjectInputStream(fileIn);

					 SonraBitirClass ist = (SonraBitirClass) in.readObject(); 
						in.close();
						fileIn.close();
							 
					 sayacCalistir(ist.getSure());
					 
				        
					 
					 String[] dizi = ist.getDenklem().split(" ");
					 
					 
					    	if(dizi.length>=1)
							 txtBoxDenklem1.setText(dizi[0]);
							if(dizi.length>=2)
								txtBoxDenklem2.setText(dizi[1]);
							if(dizi.length>=3)
								txtBoxDenklem3.setText(dizi[2]);
							if(dizi.length>=4)
								txtBoxDenklem4.setText(dizi[3]);
							if(dizi.length>=5)
								txtBoxDenklem5.setText(dizi[4]);
							if(dizi.length>=6)
								txtBoxDenklem6.setText(dizi[5]);
							if(dizi.length>=7) 
								txtBoxDenklem7.setText(dizi[6]);
							if(dizi.length>=8) {
								txtBoxDenklem8.setText(dizi[7]);
								
								
								
								txtBox1_8.setVisible(true);
								txtBox2_8.setVisible(true);
								txtBox3_8.setVisible(true);
								txtBox4_8.setVisible(true);
								txtBox5_8.setVisible(true);
								txtBox6_8.setVisible(true);

							}

							if(dizi.length>=9) {
								txtBoxDenklem9.setText(dizi[8]);
					
								txtBox1_9.setVisible(true);
								txtBox2_9.setVisible(true);
								txtBox3_9.setVisible(true);
								txtBox4_9.setVisible(true);
								txtBox5_9.setVisible(true);
								txtBox6_9.setVisible(true);
							}	 
					 
					 
				 String[] diziSatir = ist.getBirinciSatir().split(" ");
					if(diziSatir.length>=1)
					 txtBox1_1.setText(diziSatir[0]);
					if(diziSatir.length>=2)
					txtBox1_2.setText(diziSatir[1]);
					if(diziSatir.length>=3)
					txtBox1_3.setText(diziSatir[2]);
					if(diziSatir.length>=4)
					txtBox1_4.setText(diziSatir[3]);
					if(diziSatir.length>=5)
					txtBox1_5.setText(diziSatir[4]);
					if(diziSatir.length>=6)
					txtBox1_6.setText(diziSatir[5]);
					if(diziSatir.length>=7) 
						txtBox1_7.setText(diziSatir[6]);
					if(diziSatir.length>=8) 
						txtBox1_8.setText(diziSatir[7]);		
					if(diziSatir.length>=9) 
						txtBox1_9.setText(diziSatir[8]);
					
				if(diziSatir.length == dizi.length)
					btnTahminEt.doClick();
				
				diziSatir = ist.getIkinciSatir().split(" ");
				if(diziSatir.length>=1)
				 txtBox2_1.setText(diziSatir[0]);
				if(diziSatir.length>=2)
				txtBox2_2.setText(diziSatir[1]);
				if(diziSatir.length>=3)
				txtBox2_3.setText(diziSatir[2]);
				if(diziSatir.length>=4)
				txtBox2_4.setText(diziSatir[3]);
				if(diziSatir.length>=5)
				txtBox2_5.setText(diziSatir[4]);
				if(diziSatir.length>=6)
				txtBox2_6.setText(diziSatir[5]);
				if(diziSatir.length>=7) 
					txtBox2_7.setText(diziSatir[6]);
				if(diziSatir.length>=8) 
					txtBox2_8.setText(diziSatir[7]);		
				if(diziSatir.length>=9) 
					txtBox2_9.setText(diziSatir[8]);
				
			if(diziSatir.length == dizi.length)
				btnTahminEt.doClick();
			
			diziSatir = ist.getUcuncuSatir().split(" ");
			if(diziSatir.length>=1)
			 txtBox3_1.setText(diziSatir[0]);
			if(diziSatir.length>=2)
			txtBox3_2.setText(diziSatir[1]);
			if(diziSatir.length>=3)
			txtBox3_3.setText(diziSatir[2]);
			if(diziSatir.length>=4)
			txtBox3_4.setText(diziSatir[3]);
			if(diziSatir.length>=5)
			txtBox3_5.setText(diziSatir[4]);
			if(diziSatir.length>=6)
			txtBox3_6.setText(diziSatir[5]);
			if(diziSatir.length>=7) 
				txtBox3_7.setText(diziSatir[6]);
			if(diziSatir.length>=8) 
				txtBox3_8.setText(diziSatir[7]);		
			if(diziSatir.length>=9) 
				txtBox3_9.setText(diziSatir[8]);
			
		if(diziSatir.length == dizi.length)
			btnTahminEt.doClick();
                     
		diziSatir = ist.getDorduncuSatir().split(" ");
		if(diziSatir.length>=1)
		   txtBox4_1.setText(diziSatir[0]);
		if(diziSatir.length>=2)
		   txtBox4_2.setText(diziSatir[1]);
		if(diziSatir.length>=3)
		   txtBox4_3.setText(diziSatir[2]);
		if(diziSatir.length>=4)
		   txtBox4_4.setText(diziSatir[3]);
		if(diziSatir.length>=5)
		   txtBox4_5.setText(diziSatir[4]);
		if(diziSatir.length>=6)
		   txtBox4_6.setText(diziSatir[5]);
		if(diziSatir.length>=7) 
			txtBox4_7.setText(diziSatir[6]);
		if(diziSatir.length>=8) 
			txtBox4_8.setText(diziSatir[7]);		
		if(diziSatir.length>=9) 
			txtBox4_9.setText(diziSatir[8]);
		
	if(diziSatir.length == dizi.length)
		btnTahminEt.doClick();
	
	diziSatir = ist.getBesinciSatir().split(" ");
	if(diziSatir.length>=1)
	   txtBox5_1.setText(diziSatir[0]);
	if(diziSatir.length>=2)
	   txtBox5_2.setText(diziSatir[1]);
	if(diziSatir.length>=3)
	   txtBox5_3.setText(diziSatir[2]);
	if(diziSatir.length>=4)
	   txtBox5_4.setText(diziSatir[3]);
	if(diziSatir.length>=5)
	   txtBox5_5.setText(diziSatir[4]);
	if(diziSatir.length>=6)
	   txtBox5_6.setText(diziSatir[5]);
	if(diziSatir.length>=7) 
		txtBox5_7.setText(diziSatir[6]);
	if(diziSatir.length>=8) 
		txtBox5_8.setText(diziSatir[7]);		
	if(diziSatir.length>=9) 
		txtBox5_9.setText(diziSatir[8]);
	
    if(diziSatir.length == dizi.length)
	 btnTahminEt.doClick();
             
	diziSatir = ist.getAltıncıSatir().split(" ");
	if(diziSatir.length>=1)
	   txtBox6_1.setText(diziSatir[0]);
	if(diziSatir.length>=2)
	   txtBox6_2.setText(diziSatir[1]);
	if(diziSatir.length>=3)
	   txtBox6_3.setText(diziSatir[2]);
	if(diziSatir.length>=4)
	   txtBox6_4.setText(diziSatir[3]);
	if(diziSatir.length>=5)
	   txtBox6_5.setText(diziSatir[4]);
	if(diziSatir.length>=6)
	   txtBox6_6.setText(diziSatir[5]);
	if(diziSatir.length>=7) 
		txtBox6_7.setText(diziSatir[6]);
	if(diziSatir.length>=8) 
		txtBox6_8.setText(diziSatir[7]);		
	if(diziSatir.length>=9) 
		txtBox6_9.setText(diziSatir[8]);
	
    if(diziSatir.length == dizi.length)
	 btnTahminEt.doClick();
                 

					
				} catch (IOException i) {
					i.printStackTrace();
					return ;
				} catch (ClassNotFoundException c) {
					System.out.println("SonraBitirClass bulunamadi...");
					c.printStackTrace();
					return ;
				}
				
			}
		});
		btnDevamEt.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnDevamEt.setBounds(457, 8, 167, 50);
		contentPane.add(btnDevamEt);
		

		
		btnBasla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
		                btnBasla.setVisible(false);
		                btnDevamEt.setVisible(false);
			
					
		                try {
							System.out.println(generateEquation());  
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
                    
					secilen = txtBox1_1;
					onceki = txtBox1_1;
			       
					sayacCalistir(0);
			        
					btn0.setEnabled(true);
					btn1.setEnabled(true);
					btn2.setEnabled(true);
					btn3.setEnabled(true);
					btn4.setEnabled(true);
					btn5.setEnabled(true);
					btn6.setEnabled(true);
					btn7.setEnabled(true);
					btn8.setEnabled(true);
					btn9.setEnabled(true);
					btnTopla.setEnabled(true);
					btnCikar.setEnabled(true);
					btnBol.setEnabled(true);
					btnCarp.setEnabled(true);
					btnTahminEt.setEnabled(true);
					btnSil.setEnabled(true);
					btnEsittir.setEnabled(true);
					btnSonraBitir.setEnabled(true);
	                txtBox1_1.setEnabled(true);
					txtBox1_2.setEnabled(true);
					txtBox1_3.setEnabled(true);
					txtBox1_4.setEnabled(true);
					txtBox1_5.setEnabled(true);
					txtBox1_6.setEnabled(true);
					txtBox1_7.setEnabled(true);
					txtBox1_8.setEnabled(true);
					txtBox1_9.setEnabled(true);

			   
			    

			}
		});
		
	}
}
