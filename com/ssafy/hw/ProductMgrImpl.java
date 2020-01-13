package com.ssafy.hw;

import java.util.ArrayList;
import java.util.List;

public class ProductMgrImpl implements IProductMgr {

	private ArrayList<Product> products = new ArrayList<>();
	///////////////////// 싱글톤 ///////////////////////////
	private static ProductMgrImpl productmgr = new ProductMgrImpl();
	private ProductMgrImpl() {
		products.clear();
	}
	public static ProductMgrImpl getInstacne() {
		return productmgr;
	}
	/////////////////////////////////////////////////////
	
	public void print(List<Product> nproducts) {
		for (Product pp : nproducts) {
			System.out.println(pp);
		}
		System.out.println("\n");
	}
	public void print(Product nproduct) {
		System.out.println(nproduct);
		System.out.println("\n");
	}
	
	private Product findByISBN(String isbn) {	//!!!!핵심
		Product p = null;
		for (Product pp : products) {
			if(pp.getIsbn().equals(isbn)) {
				p = pp;
			}
		}
		return p;
	}
	
	@Override
	public void add(Product p) {
		Product pp = findByISBN(p.getIsbn());
		if(pp==null) { // 동일한 isbn이 없냐? 없다면~~
			products.add(p); // p를 추가
		}
	}

	@Override
	public List<Product> search() {
		return products;
	}

	@Override
	public Product search(String isbn) {
		return findByISBN(isbn);
	}

	@Override
	public List<Product> searchByName(String name) {
		List<Product> nproducts = new ArrayList<>();
		for (Product pp : products) {
			if(pp.getName().contains(name)) {
				nproducts.add(pp);
			}
		}
		return nproducts;
	}

	@Override
	public List<Product> searchOnlyTV() {
		List<Product> nproducts = new ArrayList<>();
		for (Product pp : products) {
			if(pp instanceof TV) {
				nproducts.add(pp);
			}
		}
		return nproducts;
	}

	@Override
	public List<Product> searchOnlyRefrigerator() {
		List<Product> nproducts = new ArrayList<>();
		for (Product pp : products) {
			if(pp instanceof Refrigerator) {
				nproducts.add(pp);
			}
		}
		return nproducts;
	}

	@Override
	public List<Product> searchRefrigerator(int liter) {
		List<Product> nproducts = new ArrayList<>();
		for (Product pp : products) {
			if(pp instanceof Refrigerator) {
				Refrigerator rr = (Refrigerator)pp;
				if(rr.getL() >= liter) {
					nproducts.add(rr);
				}
			}
		}
		return nproducts;
	}

	@Override
	public List<Product> searchByTV(double inch) {
		List<Product> nproducts = new ArrayList<>();
		for (Product pp : products) {
			if(pp instanceof TV) {
				TV tt = (TV)pp;
				if(tt.getInch() >= inch) {
					nproducts.add(tt);
				}
			}
		}
		return nproducts;
	}

	@Override
	public void modiftPrice(String isbn, int price) {
		for (int i = 0; i < products.size(); i++) {
			if(products.get(i).getIsbn().equals(isbn)) {
				products.get(i).setPrice(price);
			}
		}
	}

	@Override
	public void deleteByISBN(String isbn) {
		for (int i = 0; i < products.size(); i++) {
			if(products.get(i).getIsbn().equals(isbn)) {
				products.remove(i);
			}
		}
	}

	@Override
	public String[] sumPrice() {
		String goods[] = new String[products.size()];
		for (int i = 0; i < products.size(); i++) {
			Product pp = products.get(i);
			goods[i] = pp.getName() + " : " + (pp.getPrice() * pp.getCount()) + " 원";
		}
		return goods;
	}
}
