package Ssafy;

public class ProductTest {
	public static void main(String[] args) {
		ProductMgr pm = new ProductMgr();
		
		
		//데이터 입력기능
		pm.addProduct(new TV("01", "삼성TV", 1500000, 25, 27, "OLED"));
		pm.addProduct(new TV("02", "xCanvas", 750000, 8, 17, "LCD"));
		pm.addProduct(new Refrigerator("03", "삼성냉장고", 2500000, 13, 300));
		pm.addProduct(new Refrigerator("04", "삼성 김치냉장고", 3000000, 6, 400));
		pm.addProduct(new TV("05", "LGTV", 600000, 40, 21, "LED"));
		pm.addProduct(new TV("06", "대우TV", 500000, 10, 17, "LCD"));
		pm.addProduct(new Refrigerator("07", "엘지냉장고", 2000000, 8, 200));
		pm.addProduct(new Refrigerator("08", "엘지김치냉장고", 1500000, 7, 250));
		pm.addProduct(new TV("09", "삼성벽걸이티비", 2000000, 5, 34, "OLED"));
				
		//상품 전체 검색기능
		pm.search();
		System.out.println("\n");
		
//		isbn으로 정보를 검색하는 기능
		pm.searchIsbn("06");
		System.out.println("\n");
		
//		상품명으로 정보를 검색하는 기능
		pm.searchName("삼성");
		System.out.println("\n");
		
//		TV 정보만 검색하는 기능
		pm.searchOnlyTV(); //01, 02, 05, 06, 09
		System.out.println("\n");
		
//		냉장고 정보만 검색하는 기능
		pm.searchOnlyRefrigerator();
		System.out.println("\n");	//03, 04, 07, 08
		
//		상품번호로 삭제 기능
		pm.deleteIsbn("06");
		System.out.println("06번 상품 삭제 후");
		pm.search();
		System.out.println("\n");
		
//		저장된 모든 상품의 금액 합계를 구하는 기능
		int sum = pm.getPriceSum();
		System.out.println(sum + "\n");
	}
}
