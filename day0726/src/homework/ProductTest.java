package homework;

public class ProductTest {
	public static void main(String[] args) {
		ProductMgr pm = new ProductMgr();
		pm.addProduct(new TV("0001", "A티비", 1500000, 25, 27, "OLED"));
		pm.addProduct(new TV("0001", "A티비", 1500000, 25, 27, "OLED"));
		pm.addProduct(new TV("0002", "B티비", 750000, 8, 17, "LCD"));
		pm.addProduct(new Refrigerator("0003", "A냉장고", 2500000, 17, 300));
		pm.addProduct(new SmartPhone("0004", "A스마트폰", 800000, 10, "삼성", "SS01"));
		pm.addProduct(new Refrigerator("0005", "B냉장고", 2000000, 8, 270));
		pm.addProduct(new SmartPhone("0006", "B스마트폰", 950000, 7, "LG", "LG01"));
		pm.addProduct(new Refrigerator("0007", "C냉장고", 1900000, 4, 220));
		pm.addProduct(new TV("0008", "C티비", 600000, 5, 13, "LED"));
		pm.addProduct(new Refrigerator("0009", "D냉장고", 2100000, 3, 170));
		pm.addProduct(new TV("0010", "D티비", 550000, 2, 10, "OLED"));
		
		System.out.print("냉장고 재고 금액 : ");
		System.out.println(pm.searchPrice("냉장고"));
		System.out.print("스마트폰 재고 금액 : ");
		System.out.println(pm.searchPrice("스마트폰"));
		System.out.print("TV 재고 금액 : ");
		System.out.println(pm.searchPrice("TV"));
		
		System.out.print("냉장고 재고 수량 : ");
		System.out.println(pm.searchCount("냉장고"));
		System.out.print("스마트폰 재고 수량 : ");
		System.out.println(pm.searchCount("스마트폰"));
		System.out.print("TV 재고 수량 : ");
		System.out.println(pm.searchCount("TV"));
		
		System.out.print("TV 재고의 평균 인치 : ");
		System.out.println(pm.getInchAvg());
		
		
		
		
	}
}
