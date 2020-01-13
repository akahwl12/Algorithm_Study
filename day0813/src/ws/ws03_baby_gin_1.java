package ws;


public class ws03_baby_gin_1 {
	static boolean baby;
	static int[] num = {1,0,1,1,2,3};
	static int[] select = new int[num.length];
	static boolean[] chk = new boolean[num.length];
	public static void main(String[] args) {
		make(num, 0);
		System.out.println("is Baby-gin??  " + baby);
	}
	
	static void make(int[] array, int cnt) {
		if(cnt>=array.length) {
			baby = checkBaby(select);
			return;
		}
		for (int i = 0; i < array.length; i++) {
			if(!baby && !chk[i]) {
				chk[i] = true;
				select[cnt] = array[i];
				make(array, cnt+1);
				chk[i] = false;
			}
		}
	}
	
	static boolean checkBaby(int[] array) {
		int chk = 0;
		boolean isBaby = false;
		for (int i = 0; i < array.length/3; i++) {
			if((array[3*i]==array[3*i+1] && array[3*i+1]==array[3*i+2]) || (array[3*i]==array[3*i+1]-1 && array[3*i+1]==array[3*i+2]-1)) {
				chk++;
			}
		}
		if(chk==array.length/3) {
			isBaby = true;
		}
		
		return isBaby;
	}
}
