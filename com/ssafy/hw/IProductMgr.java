package com.ssafy.hw;

import java.util.List;

public interface IProductMgr {
	void add(Product b);
	List<Product> search();
	Product search(String isbn);
	List<Product> searchByName(String name);
	List<Product> searchOnlyTV();
	List<Product> searchOnlyRefrigerator();
	List<Product> searchRefrigerator(int liter);
	List<Product> searchByTV(double inch);
	void modiftPrice(String isbn, int price);
	void deleteByISBN(String isbn);
	String[] sumPrice();
}
