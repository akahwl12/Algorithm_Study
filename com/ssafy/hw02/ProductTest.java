package com.ssafy.hw02;

import java.util.List;

public class ProductTest {
	public static void main(String[] args) {
		ProductTest pt = new ProductTest();
		
		pt.add(new TV("01", "삼성TV", 1500000, 25, 60));
		pt.add(new TV("02", "xCanvas", 750000, 8, 25));
		pt.add(new Refrigerator("03", "삼성냉장고", 2500000, 13, 300));
		pt.add(new Refrigerator("04", "삼성 김치냉장고", 3000000, 6, 400));
		pt.add(new TV("05", "LGTV", 600000, 40, 30));
		pt.add(new TV("06", "대우TV", 500000, 10, 36));
		pt.add(new Refrigerator("07", "엘지냉장고", 2000000, 8, 200));
		pt.add(new Refrigerator("08", "엘지김치냉장고", 1500000, 7, 450));
		pt.add(new TV("09", "삼성벽걸이티비", 2000000, 5, 70));
		
		pt.print(pt.search());
		
		pt.print(pt.searchByISBN("23"));
		
		pt.print(pt.searchRefrigeratorByLiter(800));
		
		pt.print(pt.searchTvByInch(90));
		
		pt.print(pt.searchOnlyTv());
		
		pt.print(pt.searchOnlyRefrigerator());
		
		pt.print(pt.searchByISBN("03"));
		pt.modifyPrice("03", 3500000);
		pt.print(pt.searchByISBN("03"));
		
		pt.deleteByISBN("07");
		pt.print(pt.search());
		
		for (String sp : pt.sumPrice()) {
			System.out.println(sp);
		}
		System.out.println("----------------------------------");
		
		pt.save();
		System.out.println("----------------------------------");
		pt.deleteByISBN("01");
		pt.deleteByISBN("02");
		pt.deleteByISBN("03");
		pt.print(pt.search());
		
		//저장 후 1,2,3번을 지워도 저장했던 파일을 불러내면 살아있다.
		pt.open();
		pt.print(pt.search());
	}
	
	ProductMgrImpl pmgr = ProductMgrImpl.getInstance();
	
	public void print(Product pp) {
		if(pp!=null) {
			System.out.println(pp);
		}
		System.out.println("----------------------------------");
	}
	
	public void print(List<Product> prs) {
		if(prs!=null) {
			for (Product pp : prs) {
				System.out.println(pp);
			}
		}
		System.out.println("----------------------------------");
	}
	
	public void add(Product p) {
		try {
			pmgr.add(p);
		} catch (DuplicateException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public List<Product> search() {
		return pmgr.search();
	}
	
	public Product searchByISBN(String isbn) {
		try {
			return pmgr.searchByISBN(isbn);
		} catch (CodeNotFoundException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	public List<Product> searchRefrigeratorByLiter(double liter) {
		try {
			return pmgr.searchRefrigeratorByLiter(liter);
		} catch (ProductNotFoundException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	public List<Product> searchTvByInch(double inch) {
		try {
			return pmgr.searchTvByInch(inch);
		} catch (ProductNotFoundException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	public List<Product> searchOnlyTv() {
		return pmgr.searchOnlyTV();
	}
	
	public List<Product> searchOnlyRefrigerator() {
		return pmgr.searchOnlyRefrigerator();
	}
	
	public void modifyPrice(String isbn, int price) {
		pmgr.modifyPrice(isbn, price);
	}
	
	public void deleteByISBN(String isbn) {
		pmgr.deleteByISBN(isbn);
	}
	
	public String[] sumPrice() {
		return pmgr.sumPrice();
	}
	
	public void open() {
		pmgr.open();
	}
	
	public void save() {
		pmgr.save();
	}
}
