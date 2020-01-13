package Ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * [S/W 문제해결 응용] 2일차 - 최대 상금
 * @author KSM
 *
 */
public class Solution_1244 {
   static int[] arr;
   static int[] visited; 
   static int size;
   static int times;
   static int max = 0;
   static StringBuilder sb = new StringBuilder();
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int TC = Integer.parseInt(br.readLine());
      
      for (int tc = 1; tc <= TC; tc++) {
         StringTokenizer st = new StringTokenizer(br.readLine());
         String num = st.nextToken(); // 숫자판
         max = 0;
         times = Integer.parseInt(st.nextToken()); // 교환 횟수
         size = num.length();
         arr = new int[size];
         visited = new int[1000000];// 최대 자리수 6, 최대 숫자 999999
         for (int i = 0; i < size; i++) {
            arr[i] = num.charAt(i)-'0';
         }
         dfs(0);
         
         System.out.println("#" + tc + " " + max);
      }
   }
   
   static void swap(int i, int j) {
      int temp = arr[i];
      arr[i] = arr[j];
      arr[j] = temp;
   }
   
   public static void dfs(int depth) {
	   sb.delete(0, sb.length());
	   for (int i = 0; i < arr.length; i++) {
		   sb.append(arr[i]);
	   }
	   int num = Integer.parseInt(sb.toString());
	   if (depth == times) {
		   max = Math.max(max, Integer.parseInt(sb.toString()));
		   return;
	   }   
	   if(visited[num] != 0) {
		   return;
	   }
      visited[num] = 1;
       

       for (int i = 0; i < size; i++) {
           for (int j = i+1; j < size; j++) {
               swap(i, j);
               dfs(depth + 1);
               swap(i, j);
           }
       }
   }
   
}
   