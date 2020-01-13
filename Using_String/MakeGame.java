package Using_String;

import java.util.Random;

public class MakeGame {
	private static Random rand = new Random(System.currentTimeMillis());
	
	public static void pitch(int[] ball){
		boolean[] flag = new boolean[10];
		for(int i=0; i<3; i++){
			while(true){
				ball[i] = rand.nextInt(10);
				if(!flag[ball[i]]){
					flag[ball[i]]=true;
					break;
				}
			}
		}
	}
	public static int compare(int[] ball, int[] bat){
		boolean[] flag = new boolean[10];
		for(int i=0; i<3; i++) flag[ball[i]] = true;
		int scount = 0;
		int bcount = 0;
		for(int i=0; i<3; i++){
			if(ball[i]==bat[i]) ++scount;
			else if(flag[bat[i]]) ++bcount;
		}
		
		if(scount==3)
			return 1;
		else if(scount==0&&bcount==0) return -1;
		else{
			System.out.printf("S: %d, B: %d\n", scount, bcount);
			return 0;
		}
	}
}
