#include <stdio.h>
#define MAX 40

int Table[MAX][2];
int n, max=0;

int main()
{
	scanf("%d", &n);

	int *m= new int[n];

	Table[0][0] = 1;	Table[0][1] = 0;
	Table[1][0] = 0;	Table[1][1] = 1;

	for(int i=0; i<n;i++)
	{
		scanf("%d",&m[i]);
		if(max<m[i])
			max = m[i];
	}

	for(int i=2; i<=max;i++)
	{
		Table[i][0] = Table[i-1][0] + Table[i-2][0];
		Table[i][1] = Table[i-1][1] + Table[i-2][1];
	}
	for(int i=0; i<n;i++)
		printf("%d %d\n", Table[m[i]][0], Table[m[i]][1]);

	delete[] m;
}