package day0722;

public class Test01 {
	public static void main(String[] args) {
		int[][] arr = {{1,2,3}, {4,5,6}, {7,8,9}};
		
		// ��, ��, ��, ��
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		
//		int x=1, y=1;	// ���� �ε���
		

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {	// ��� i, j�� ��������
				System.out.print(arr[i][j] + "�� �̿� : ");

				for (int d = 0; d < 4; d++) {	// �����¿� 4������ ��ȸ�ϱ�
					int nextX = i + dx[d];
					int nextY = j + dy[d];
		
					if(nextX>=0 && nextX<3 && nextY>=0 && nextY<3) {	// �迭�� �ε��� �������� ��쿡��
						System.out.print(arr[nextX][nextY] + " ");	// ���� ���� ����ϱ�
					}
				}
				System.out.println();
			}
		}
		
	}
}
