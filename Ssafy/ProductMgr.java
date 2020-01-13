package Ssafy;

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
			if(products[i] != null && products[i].getIsbn().equals(isbn)) {
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
			if(products[i] != null && products[i].getName().contains(name)) {
				System.out.println(products[i]);
				check = true;
			}
		}
		if(!check) {
			System.out.println("상품 정보가 존재하지 않습니다.");
		}
	}
	
	public void searchOnlyTV() {
		for (int i = 0; i < index; i++) {
			if(products[i] != null && !(products[i] instanceof Refrigerator))
				System.out.println(products[i]);
		}
	}
	
	public void searchOnlyRefrigerator() {
		for (int i = 0; i < index; i++) {
			if(products[i] != null && !(products[i] instanceof TV))
				System.out.println(products[i]);
		}
	}
	
	public void deleteIsbn(String isbn) {
		boolean check = false;
		for (int i = 0; i < index; i++) {
			if(products[i] != null && products[i].getIsbn().equals(isbn)) {
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
			if(products[i] != null)
				sum+=products[i].getPrice();
		}
		return sum;
	}
}
