package homework;

public class ProductMgr {
	private Product[] products;
	private int index = 0;
	
	public ProductMgr() {
		products = new Product[100];
	}
	
	public void addProduct(Product product) {
		if(index>=0 && index <products.length) {
			products[index++] = product;
		}
	}
	
	public void search() {
		for (int i = 0; i < index; i++) {
			if(products[i] != null)
				System.out.println(products[i]);
		}
	}
	
	public void searchIsbn(String isbn) {
		boolean check = false;
		for (int i = 0; i < index; i++) {
			if(products[i].getIsbn().equals(isbn)) {
				System.out.println(products[i]);
				check = true;
			}
		}
		if(!check) {
			System.out.println("상품 정보가 존재하지 않습니다.");
		}
	}
	
	public void searchName(String name) {
		boolean check = false;
		for (int i = 0; i < index; i++) {
			if(products[i].getName().contains(name)) {
				System.out.println(products[i]);
				check = true;
			}
		}
		if(!check) {
			System.out.println("상품 정보가 존재하지 않습니다.");
		}
	}
	
	public int searchPrice(String p) {
		int sum = 0, cnt = 0;
		for (int i = 0; i < index; i++) {
			if(p.equals("냉장고")&&products[i] instanceof Refrigerator) //냉장고
				sum += products[i].getPrice() * products[i].getCount();
			else if(p.equals("스마트폰")&&products[i] instanceof SmartPhone) //스마트폰
				sum += products[i].getPrice() * products[i].getCount();
			else if(p.equals("TV")&&products[i] instanceof TV) //티비
				sum += products[i].getPrice() * products[i].getCount();
		}
		return sum;
	}
	public int searchCount(String p) {
		int sum = 0;
		for (int i = 0; i < index; i++) {
			if(p.equals("냉장고")&&products[i] instanceof Refrigerator) //냉장고
				sum += products[i].getCount();
			else if(p.equals("스마트폰")&&products[i] instanceof SmartPhone) //스마트폰
				sum += products[i].getCount();
			else if(p.equals("TV")&&products[i] instanceof TV) //티비
				sum += products[i].getCount();
		}
		return sum;
	}
	
	
	public double getInchAvg() {
		double sum = 0, cnt=0;
		for (int i = 0; i < index; i++) {
			if(products[i] instanceof TV) { //냉장고
				TV tv = (TV)products[i];
				sum += tv.getInch();
				cnt++;
			}
		}
		return sum/cnt;
	}
	
	public int getLiters() {
		int sum = 0;
		for (int i = 0; i < index; i++) {
			if(products[i] instanceof Refrigerator) { //냉장고
				Refrigerator rf = (Refrigerator)products[i];
				sum += rf.getL();
			}
		}
		return sum;
	}
	public int getSmartPhoneCount() {
		int sum = 0;
		for (int i = 0; i < index; i++) {
			if(products[i] instanceof SmartPhone) { //냉장고
				SmartPhone sp = (SmartPhone)products[i];
				sum += sp.getCount();
			}
		}
		return sum;
	}
	
	public Product[] seachByPrice(String name, int price) {
		Product[] tmp = new Product[index];
		int idx = 0;
		
		for (int i = 0; i < index; i++) {
			if(name.contains("냉장고")&&products[i] instanceof Refrigerator&&products[i].getPrice()<=price) //냉장고
				tmp[idx++] = products[i];
			else if(name.contains("스마트폰")&&products[i] instanceof SmartPhone&&products[i].getPrice()<=price) //스마트폰
				tmp[idx++] = products[i];
			else if(name.contains("TV")&&products[i] instanceof TV&&products[i].getPrice()<=price) //티비
				tmp[idx++] = products[i];
		}
		
		return tmp;
	}
	
	public void deleteIsbn(String isbn) {
		boolean check = false;
		for (int i = 0; i < index; i++) {
			if(products[i].getIsbn().equals(isbn)) {
				products[i] = null;
				check = true;
			}
		}
		if(!check) {
			System.out.println("상품 정보가 존재하지 않습니다.");
		}
	}
	
	public int getPriceSum() {
		int sum = 0;
		for (int i = 0; i < index; i++) {
			sum+=products[i].getPrice();
		}
		return sum;
	}
}
