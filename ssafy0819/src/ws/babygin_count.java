package ws;

public class babygin_count {
	static int[] cards = {1,3,2,7,8,9};
	static int[] map = new int[10];
	static boolean isBaby=true;
	
	public static void main(String[] args) {
		for (int i = 0; i < cards.length; i++) {
			map[cards[i]]++;
		}
		
		for (int i = 0; i < map.length-2; i++) {	
			if(map[i]>=3) {
				map[i]%=3;
			}
			if(map[i]>0 && map[i+1]>0 && map[i+2]>0) {	// 연속된 수가 있다면 제외해준다.
				map[i]--;
				map[i+1]--;
				map[i+2]--;
				i--;
			}
		}
		for (int i = 0; i < map.length; i++) {
			if(map[i]!=0) {	// 0이 아닌 수가 나오면 베이비진 아니다
				isBaby = false;
			}
		}
		
		if(isBaby) {
			System.out.println("Babygin!!");
		}
		else {
			System.out.println("Not Babygin!!");
		}
	}
}
