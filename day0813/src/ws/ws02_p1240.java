package ws;

import java.util.Scanner;

public class ws02_p1240 {
	static int T, N, M, idx, start, chk, ans;
	static String[] code = {"0001101", "0011001", "0010011", "0111101", "0100011", "0110001",
						"0101111", "0111011", "0110111", "0001011"};
	static boolean flag;
	static StringBuffer input;
	static int[][] map;
	static int[] decode = new int[8];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			M = sc.nextInt();
			map = new int[N][56];
			
			for (int i = 0; i < N; i++) {
				flag = false;
				idx = 55;
				ans = chk = 0;
				input = new StringBuffer(sc.next());
				for (int j = M-1; j >= 0 && idx>=0; j--) {
					if(Integer.parseInt(input.charAt(j)+"")!=0) {
						flag = true;
					}
					if(flag) {
						start = i;
						map[i][idx--] = Integer.parseInt(input.charAt(j)+"");
					}
				}
			}
			
			for (int i = 0; i < 8; i++) {
				StringBuffer read = new StringBuffer();
				for (int j = 0; j < 7; j++) {
					read.append(""+map[start][7*i+j]);	//7자리씩 StringBuffer에 추가
				}
				for (int j = 0; j < 10; j++) {
					if(code[j].equals(read.toString())) {	//code표와 비교
						decode[i] = j;
						break;
					}
				}
			}
			
			for (int i = 0; i < decode.length; i++) {
				if((i+1)%2==1) {
					chk += 3 * decode[i];
				}
				else {
					chk += decode[i];
				}
				ans+= decode[i];
			}
			if(chk%10!=0) {
				ans = 0;
			}
			System.out.println("#" + t + " " + ans);
		}
	}
}
