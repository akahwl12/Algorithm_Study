package ws;

import java.util.HashMap;

public class ws03_baby_gin_2 {
	static boolean baby;
	static int[] num = {1,3,2,3,1,2,1,1,4};
	static HashMap<Integer, Integer> map = new HashMap<>();
	public static void main(String[] args) {
		
		for (int i = 0; i < num.length; i++) {
			int key = num[i];
			if(map.get(key)==null) {
				map.put(key, 1);
			}
			else {
				map.replace(key, map.get(key)+1);
			}
		}
		
		for (int key : map.keySet()) {
			map.replace(key, map.get(key)%3);
			System.out.println(key + " : " + map.get(key));
		}
		
		for (int key : map.keySet()) {
//			if(key)
			System.out.println(key + " : " + map.get(key));
		}
		
	}
}
