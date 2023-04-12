package YusufTahaKara;
@SuppressWarnings("serial")

public class SonraBitirClass implements java.io.Serializable {
	private int sure;
	private String denklem;
	private String birinciSatir;
	private String ikinciSatir;
	private String ucuncuSatir;
	private String dorduncuSatir;
	private String besinciSatir;
	private String altıncıSatir;
	public SonraBitirClass(int sure, String denklem, String birinciSatir, String ikinciSatir, String ucuncuSatir,
			String dorduncuSatir, String besinciSatir, String altıncıSatir) {
		this.sure = sure;
		this.denklem = denklem;
		this.birinciSatir = birinciSatir;
		this.ikinciSatir = ikinciSatir;
		this.ucuncuSatir = ucuncuSatir;
		this.dorduncuSatir = dorduncuSatir;
		this.besinciSatir = besinciSatir;
		this.altıncıSatir = altıncıSatir;
	}
	public int getSure() {
		return sure;
	}
	public void setSure(int sure) {
		this.sure = sure;
	}
	public String getDenklem() {
		return denklem;
	}
	public void setDenklem(String denklem) {
		this.denklem = denklem;
	}
	public String getBirinciSatir() {
		return birinciSatir;
	}
	public void setBirinciSatir(String birinciSatir) {
		this.birinciSatir = birinciSatir;
	}
	public String getIkinciSatir() {
		return ikinciSatir;
	}
	public void setIkinciSatir(String ikinciSatir) {
		this.ikinciSatir = ikinciSatir;
	}
	public String getUcuncuSatir() {
		return ucuncuSatir;
	}
	public void setUcuncuSatir(String ucuncuSatir) {
		this.ucuncuSatir = ucuncuSatir;
	}
	public String getDorduncuSatir() {
		return dorduncuSatir;
	}
	public void setDorduncuSatir(String dorduncuSatir) {
		this.dorduncuSatir = dorduncuSatir;
	}
	public String getBesinciSatir() {
		return besinciSatir;
	}
	public void setBesinciSatir(String besinciSatir) {
		this.besinciSatir = besinciSatir;
	}
	public String getAltıncıSatir() {
		return altıncıSatir;
	}
	public void setAltıncıSatir(String altıncıSatir) {
		this.altıncıSatir = altıncıSatir;
	}
	
	

}
