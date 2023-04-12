package YusufTahaKara;

@SuppressWarnings("serial")
public class Istatistik implements java.io.Serializable {
	
	 
	
	private int yaridaBirakilan;
	 private int basarisizOyunAdet;
	 private int basariliOyunAdet;
	 private double basarililarOrtKacSatirdaTamamlanmis;
	 private double basarililarOrtSure;
	public int getYaridaBirakilan() {
		return yaridaBirakilan;
	}
	
	public Istatistik(int yaridaBirakilan, int basarisizOyunAdet, int basariliOyunAdet,
			double basarililarOrtKacSatirdaTamamlanmis, double basarililarOrtSure) {
		this.yaridaBirakilan = yaridaBirakilan;
		this.basarisizOyunAdet = basarisizOyunAdet;
		this.basariliOyunAdet = basariliOyunAdet;
		this.basarililarOrtKacSatirdaTamamlanmis = basarililarOrtKacSatirdaTamamlanmis;
		this.basarililarOrtSure = basarililarOrtSure;
	}

	public void setYaridaBirakilan(int yaridaBirakilan) {
		this.yaridaBirakilan = yaridaBirakilan;
	}
	public int getBasarisizOyunAdet() {
		return basarisizOyunAdet;
	}
	public void setBasarisizOyunAdet(int basarisizOyunAdet) {
		this.basarisizOyunAdet = basarisizOyunAdet;
	}
	public int getBasariliOyunAdet() {
		return basariliOyunAdet;
	}
	public void setBasariliOyunAdet(int basariliOyunAdet) {
		this.basariliOyunAdet = basariliOyunAdet;
	}
	public double getBasarililarOrtKacSatirdaTamamlanmis() {
		return basarililarOrtKacSatirdaTamamlanmis;
	}
	public void setBasarililarOrtKacSatirdaTamamlanmis(double basarililarOrtKacSatirdaTamamlanmis) {
		this.basarililarOrtKacSatirdaTamamlanmis = basarililarOrtKacSatirdaTamamlanmis;
	}
	public double getBasarililarOrtSure() {
		return basarililarOrtSure;
	}
	public void setBasarililarOrtSure(double basarililarOrtSure) {
		this.basarililarOrtSure = basarililarOrtSure;
	}
	

 
 
 
}
