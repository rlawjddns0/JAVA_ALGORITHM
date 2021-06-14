package BAEK.month_202106.day_20210614;

import java.util.Scanner;

public class BAEK_2482 {
	static int n,k;
	static int[][] dp;
	static final int mod=1000000003;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		n=sc.nextInt();
		k=sc.nextInt();
		
		dp = new int[n + 1][n + 1];

        for(int i = 1; i <= n; i++){
            // i�� �߿��� 1���� �����ϴ� ����� i���̴�.
            dp[i][1] = i;
            // 0���� ������ ���� 1�� �ʱ�ȭ�Ѵ�.
            // ��ȭ���� ���ؼ��� 1�� �ʱ�ȭ�ؾ��Ѵ�.
            dp[i][0] = 1;
        }
		
     // i�� 3�̸��� ���� ����� �ʿ䰡 ����.
        for(int i = 3; i <= n; i++){
            // n���� �� �� n/2�� ���� �� ���� ���� ���� 0�����̴�.
            // �׷��� ������ j�� ������ ������ ���� �����Ѵ�.
            for(int j = 2; j <= (i + 1) / 2; j++){
                // i��° ���� �������� ���� ��� + i��° ���� ������ ���
                dp[i][j] = (dp[i - 1][j] + dp[i - 2][j - 1]) % mod;
            }
        }
        
        System.out.println((dp[n - 3][k - 1] + dp[n - 1][k]) % mod);
        
	}

}
