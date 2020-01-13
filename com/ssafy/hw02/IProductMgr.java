package com.ssafy.hw02;

import java.util.List;

public interface IProductMgr {
	void add(Product product) throws DuplicateException;
	List<Product> search();
	Product searchByISBN(String isbn) throws CodeNotFoundException;
	List<Product> searchByName(String name);
	List<Product> searchOnlyTV();
	List<Product> searchOnlyRefrigerator();
	List<Product> searchRefrigeratorByLiter(double liter) throws ProductNotFoundException;
	List<Product> searchTvByInch(double inch) throws ProductNotFoundException;
	void modifyPrice(String isbn, int price);
	void deleteByISBN(String isbn);
	String[] sumPrice();
}
