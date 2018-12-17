#include <stdio.h>
#define MAX 502

int dp[MAX][MAX];
int map[MAX][MAX];

int main() {
	int n;
	int maxx=0;
	scanf("%d", &n);
	for(int i=0;i<n;i++) {
		for(int j=0;j<=i;j++) {
			scanf("%d ",&dp[i][j]);
		}
	}

	map[0][0] = dp[0][0];
	for(int i=1;i<n;i++) {
		for(int j=0;j<=i;j++) {
			if(j==0) {
				map[i][j] = map[i-1][j] + dp[i][j];
			}else if(j==i) {
				map[i][j] = map[i-1][j-1] + dp[i][j];
			}else {
				if(map[i-1][j-1] > map[i-1][j])		map[i][j] = map[i-1][j-1] + dp[i][j];
				else	map[i][j] = map[i-1][j] + dp[i][j];
			}
		}
	}

	for(int i=0;i<n;i++) {
		if(map[n-1][i]>maxx)
			maxx = map[n-1][i];
	}
	printf("%d", maxx);
}
