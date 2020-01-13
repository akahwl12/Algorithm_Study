package homework;

public class SmartPhone extends Product{
	private String vender;
	private String model;
	
	public SmartPhone() {
		this("", "", 0, 0, "", "");
	}
	
	public SmartPhone(String i, String n, int p, int c, String v, String m) {
		super(i, n, p, c);
		this.vender = v;
		this.model = m;
	}

	public String getVender() {
		return vender;
	}

	public void setVender(String vender) {
		this.vender = vender;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	@Override
	public String toString() {
		return super.toString() + ", 벤더 = " + vender + ", 모델명 = " + model;
	}
	
	
}
