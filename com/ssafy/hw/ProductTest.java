package com.ssafy.hw;

public class ProductTest {
	public static void main(String[] args) {
		ProductMgrImpl pmgi = ProductMgrImpl.getInstacne();
		
		//상품 정보를 저장
		pmgi.add(new TV("01", "삼성TV", 1500000, 25, 60, "OLED"));
		pmgi.add(new TV("02", "xCanvas", 750000, 8, 25, "LCD"));
		pmgi.add(new Refrigerator("03", "삼성냉장고", 2500000, 13, 300));
		pmgi.add(new Refrigerator("04", "삼성 김치냉장고", 3000000, 6, 400));
		pmgi.add(new TV("05", "LGTV", 600000, 40, 30, "LED"));
		pmgi.add(new TV("06", "대우TV", 500000, 10, 36, "LCD"));
		pmgi.add(new Refrigerator("07", "엘지냉장고", 2000000, 8, 200));
		pmgi.add(new Refrigerator("08", "엘지김치냉장고", 1500000, 7, 450));
		pmgi.add(new TV("09", "삼성벽걸이티비", 2000000, 5, 70, "OLED"));
		
		//상품정보 전체를 검색하는 기능
		pmgi.print(pmgi.search());
		
		//상품번호로 상품을 검색하는 기능
		pmgi.print(pmgi.search("03"));
		
		//삼품명으로 상품을 검색하는 기능(상품명 부분 검색 가능)
		pmgi.print(pmgi.searchByName("삼성"));
		
		//TV정보만 검색
		pmgi.print(pmgi.searchOnlyTV());
		
		//Refrigerator만 검색
		pmgi.print(pmgi.searchOnlyRefrigerator());
		
		//400L 이상의 Refrigerator 검색
		pmgi.print(pmgi.searchRefrigerator(400));
		
		//50inch 이상의 TV검색
		pmgi.print(pmgi.searchByTV(50));
		
		//상품번호와 가격을 입력 받아 상품 가격을 변경할 수 있는 기능
		System.out.println("--------------------------------------------------------------------------");
		pmgi.print(pmgi.search("09"));
		pmgi.modiftPrice("09", 6000000);
		pmgi.print(pmgi.search("09"));
		System.out.println("--------------------------------------------------------------------------");
		
		//상품번호로 상품을 삭제하는 기능
		pmgi.deleteByISBN("06");
		pmgi.print(pmgi.search());
		
		//전체 재고 상품 금액을 구하는 기능
		String[] sum = pmgi.sumPrice();
		for (int i = 0; i < sum.length; i++) {
			System.out.println(sum[i]);
		}
		
	}
}
