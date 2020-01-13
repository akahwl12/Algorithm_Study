package day0722;

public class Test01 {
	public static void main(String[] args) {
		int[][] arr = {{1,2,3}, {4,5,6}, {7,8,9}};
		
		// 상, 하, 좌, 우
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		
//		int x=1, y=1;	// 기준 인덱스
		

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {	// 모든 i, j를 기준으로
				System.out.print(arr[i][j] + "의 이웃 : ");

				for (int d = 0; d < 4; d++) {	// 상하좌우 4개방향 순회하기
					int nextX = i + dx[d];
					int nextY = j + dy[d];
		
					if(nextX>=0 && nextX<3 && nextY>=0 && nextY<3) {	// 배열의 인덱스 범위내의 경우에만
						System.out.print(arr[nextX][nextY] + " ");	// 인접 원소 출력하기
					}
				}
				System.out.println();
			}
		}
		
	}
}
