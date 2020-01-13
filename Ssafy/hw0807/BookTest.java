package com.ssafy.edu.ws;

import java.util.List;
import java.util.Scanner;

public class BookTest {

	public static void main(String[] args) {
		BookTest m = new BookTest();
		m.open();
		int num = 0;
		while (true) {
			num = m.menu();
			if (num == 0)
				break;
			switch (num) {
			case 1:
				m.add();
				break;
			case 2:
				m.search();
				break;
			case 3:
				m.searchByISBN();
				break;
			case 4:
				m.searchByTitle();
				break;
			case 5:
				m.buyByISBN();
				break;
			case 6:
				m.sellByISBN();
				break;
			case 7:
				m.save();
				break;
			case 8:
				m.read();
				break;
			case 9:
				m.send();
				break;
			}

		}
	}

	BookMgrImpl bmgr = BookMgrImpl.getInstance();
	Scanner s = new Scanner(System.in);

	public int menu() {
		int result = 0;
		System.out.println("==================================");
		System.out.println("========== 책관리 프로그램 ===========");
		System.out.println("==================================");
		System.out.println("1. 책 등록");
		System.out.println("2. 책목록 보기");
		System.out.println("3. 책 검색(ISBN으로 검색)");
		System.out.println("4. 책 검색(제목으로 검색)");
		System.out.println("5. 책 구매(ISBN으로 검색)");
		System.out.println("6. 책 판매(ISBN으로 검색)");
		System.out.println("7. 책 정보 파일 저장");
		System.out.println("8. 책 정보 파일로 부터 읽어오기");
		System.out.println("9. 서버로 책 보내기");
		System.out.println("0. 종료");
		System.out.println("원하는 번호를 선택 하세요.");
		result = Integer.parseInt(s.nextLine());
		return result;
	}
	public void open() {
		bmgr.open();
	}
	public void print(List<Book> lb) {
		for (Book b : lb) {
			System.out.println(b);
		}
	}

	public void add() {
		System.out.println("책 정보를 입력하세요. 형식:isbn,제목,가격,수량");
		// ... 구현하세요.
		String[] info = s.nextLine().split(",");
		bmgr.add(new Book(info[0].trim(), info[1].trim(), Integer.parseInt(info[2]), Integer.parseInt(info[3])));
	}

	public void search() {
		System.out.println(">>>>>>>>  책목록 보기 ");
		// 구현하세요.
		print(bmgr.search());
	}

	public void searchByISBN() {
		System.out.println(">>>>>>>>  책 검색 (isbn으로 검색) ");
		System.out.println("검색하고자하는 isbn을 입력하세요.");
		// 구현하세요
		String isbn = s.nextLine();
		for (Book nb : bmgr.search()) {
			if(nb.getIsbn().equals(isbn)) {
				System.out.println(nb);
			}
		}
	}
	
	public void buyByISBN() {
		System.out.println(">>>>>>>>  구매할 책 검색 (ISBN, 구매량) ");
		System.out.println("구매하고자하는 상품 번호와 구매수량을 입력하세요.");
		String ss = s.nextLine();
		String[] sss = ss.split(",");
		String isbn = sss[0];
		int quantity = Integer.parseInt(sss[1]);
		
		try {
			bmgr.buy(isbn, quantity);
		} catch (ISBNNotFoundException e) {
			System.out.println(isbn + " 번호가 없습니다.");
		}
	}
	
	public void sellByISBN() {
		System.out.println(">>>>>>>>  판매할 책 검색 (ISBN, 판매량) ");
		System.out.println("구매하고자하는 상품 번호와 판매수량을 입력하세요.");
		String ss = s.nextLine();
		String[] sss = ss.split(",");
		String isbn = sss[0];
		int quantity = Integer.parseInt(sss[1]);
		
		try {
			bmgr.sell(isbn, quantity);
		} catch (QuantityException e) {
			System.out.println("상품의 갯수가 부족합니다. 못팔아요.");
		} catch (ISBNNotFoundException e) {
			System.out.println(isbn + " 번호가 없습니다.");
		}
	}

	public void searchByTitle() {
		System.out.println(">>>>>>>>  책 검색 (제목으로 검색) ");
		System.out.println("검색하고자하는 제목을 입력하세요.");
		// 구현하세요.
		String title = s.nextLine();
		for (Book nb : bmgr.search()) {
			if(nb.getTitle().contains(title)) {
				System.out.println(nb);
			}
		}
	}
	
	public void save() {
		bmgr.close();
	}
	
	private void read() {
		bmgr.open();
	}
	
	private void send() {
		System.out.println(">>>>>>>>  서버로 책 보내기 ");
		bmgr.send();
	}
	
}
