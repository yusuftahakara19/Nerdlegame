package YusufTahaKara;

import static org.junit.Assert.*;

import org.junit.Test;

public class GenerateEquationTest {

  
 
  @Test
   public void testUzunlukKontrol() {
	  FrmYeniOyun test =new FrmYeniOyun();
	   String s = test.generateEquation();
	   String mysz2 = s.replaceAll("\\s","");
	   String s_uzunluk = Integer.toString(mysz2.length());
	   String uzunluk="789";
	   boolean expect =true;
	   boolean actual = uzunluk.contains(s_uzunluk);
	   assertEquals(expect,actual);
   }
  
  @Test
  public void testIstatistikGetir() {
	  FrmYeniOyun test =new FrmYeniOyun();
	 Object ist = test.istatistikGetir();
     Istatistik ist_expect = new Istatistik(0, 0, 0, 0, 0);
     Class actual = ist.getClass();   
     Class expect = ist_expect.getClass();
     assertEquals(expect,actual);
     
  }
  
  @Test
  public void istatistikGuncellemeBasariliMi() {
	  FrmYeniOyun test =new FrmYeniOyun();
	  
		Istatistik ist = test.istatistikGetir();
		//degerlerin kaybolmaması için güncel verileri okuyup, onlar ile güncelleme yaptık
	   boolean actual = test.istatistikGuncelle(ist.getYaridaBirakilan(),ist.getBasarisizOyunAdet(),ist.getBasariliOyunAdet(),ist.getBasarililarOrtKacSatirdaTamamlanmis(),ist.getBasarililarOrtSure());
	   boolean expect =true;
	   assertEquals(expect,actual);
  }
  
  @Test
  public void sonraBitirClassOkuma() {
	  FrmYeniOyun test =new FrmYeniOyun(); 
	   boolean actual = test.sonraBitirClassDosyaOku();
	   boolean expect =true;
	   assertEquals(expect,actual);
  }
  


}
