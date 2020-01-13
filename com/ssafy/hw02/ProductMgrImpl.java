package com.ssafy.hw02;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ProductMgrImpl implements IProductMgr {

	ArrayList<Product> products = new ArrayList<>();
	HashMap<String, Product> hs = new HashMap<>();
	private static ProductMgrImpl pmgr = new ProductMgrImpl();
	private ProductMgrImpl() {
		products.clear();
	}
	public static ProductMgrImpl getInstance() {
		return pmgr;
	}

	private Product findByISBN(String isbn) {
		Product np = null;
		for (Product pp : products) {
			if(pp.getIsbn().equals(isbn)) {
				np = pp;
			}
		}
		return np;
	}
	
	@Override
	public void add(Product product) throws DuplicateException {
		Product np = findByISBN(product.getIsbn());
		if(np==null) {
			products.add(product);
		}
		else {
			throw new DuplicateException("상품 번호가 없습니다.");
		}
	}

	@Override
	public List<Product> search() {
		return products;
	}

	@Override
	public Product searchByISBN(String isbn) throws CodeNotFoundException {
		Product np = findByISBN(isbn);
		
		if(np!=null) {
			return np;
		}
		else {
			throw new CodeNotFoundException("상품번호 " + isbn + "과 일치하는 상품이 없습니다.");
		}
	}

	@Override
	public List<Product> searchByName(String name) {
		List<Product> lp = new ArrayList<>();
		for (Product pp : products) {
			if(pp.getName().contains(name)) {
				lp.add(pp);
			}
		}
		return lp;
	}

	@Override
	public List<Product> searchOnlyTV() {
		List<Product> lp = new ArrayList<>();
		for (Product pp : products) {
			if(pp instanceof TV) {
				lp.add(pp);
			}
		}
		return lp;
	}

	@Override
	public List<Product> searchOnlyRefrigerator() {
		List<Product> lp = new ArrayList<>();
		for (Product pp : products) {
			if(pp instanceof Refrigerator) {
				lp.add(pp);
			}
		}
		return lp;
	}

	@Override
	public List<Product> searchRefrigeratorByLiter(double liter) throws ProductNotFoundException {
		List<Product> lp = new ArrayList<>();
		for (Product pp : products) {
			if(pp instanceof Refrigerator) {
				Refrigerator rr = (Refrigerator) pp;
				if(rr.getLiter()>=liter) {
					lp.add(rr);
				}
			}
		}
		if(lp.size()==0) {
			throw new ProductNotFoundException(liter + "리터보다 큰 냉장고가 없습니다.");
		}
		else {
			return lp;
		}
	}

	@Override
	public List<Product> searchTvByInch(double inch) throws ProductNotFoundException {
		List<Product> lp = new ArrayList<>();
		for (Product pp : products) {
			if(pp instanceof TV) {
				TV tt = (TV) pp;
				if(tt.getInch()>=inch) {
					lp.add(tt);
				}
			}
		}
		if(lp.size()==0) {
			throw new ProductNotFoundException(inch + "inch 보다 큰 TV정보가 없습니다.");
		}
		else {
			return lp;
		}
	}

	@Override
	public void modifyPrice(String isbn, int price) {
		Product np = null;
		for (Product pp : products) {
			if(pp.getIsbn().equals(isbn)) {
				pp.setPrice(price);
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
	public String[] sumPrice() {	//재고 * 상품가
		String[] result = new String[products.size()];
		for (int i = 0; i < products.size(); i++) {
			int rst = products.get(i).getPrice() * products.get(i).getQuantity();
			result[i] = products.get(i).getIsbn() + " : " + rst + " 원";
		}
		return result;
	}
	
	public void open() {
		String fname= "product.dat";
		File fproduct = new File(fname);
		if(!fproduct.exists()) {
			try {
				fproduct.createNewFile();
			} catch (IOException e) {
				System.out.println("파일이 존재하지 않습니다.");
			}
			return;
		}
		products.clear();
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(new FileInputStream(fproduct));
			int count = ois.readInt();	//
			for (int i = 0; i < count; i++) {
				Product pp = (Product)ois.readObject();
				products.add(pp);
			}
			System.out.println("Open Successfully!!");
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		}
	}
	
	public void save() {
		String fname= "product.dat";
		File fproduct = new File(fname);
		if(!fproduct.exists()) {
			try {
				fproduct.createNewFile();
			} catch (IOException e) {
				System.out.println(e);
			}
		}
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(fproduct, false));
			oos.writeInt(products.size());
			for (Product ppp : products) {
				oos.writeObject(ppp);
				oos.flush();
			}
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		} finally {
			if(oos!=null) {
				try {
					oos.close();
				} catch (IOException e) {
					System.out.println(e);
				}
			}
			System.out.println("Save Successfully!!");
		}

	}

}
