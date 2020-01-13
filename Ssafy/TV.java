package Ssafy;

public class TV extends Product {

	private double inch;
	private String d_type;
	public TV(String i, String n, int p, int c, double inch, String d_type) {
		super(i, n, p, c);
		this.inch = inch;
		this.d_type = d_type;
	}
	@Override
	public String toString() {
		return super.toString() + ", 인치 = " + inch + ", 디스플레이 타입 = " + d_type;
	}
	
}
