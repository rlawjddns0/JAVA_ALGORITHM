package SWE.month_202104.day_20210422;

//import java.io.BufferedReader;
//import java.io.InputStreamReader;
import java.io.*;
import java.util.StringTokenizer;
public class SWE_2115 {
	static int N,M,C,map[][];
	static int[] A,B;
	public static void main(String[] args) throws  IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int TC=Integer.parseInt(br.readLine());
		
		
		for (int t = 1; t <= TC; t++) {
			StringTokenizer st=new StringTokenizer(br.readLine()," ");
			N=Integer.parseInt(st.nextToken());
			M=Integer.parseInt(st.nextToken());
			C=Integer.parseInt(st.nextToken());
			map=new int[N][N];
			for(int i=0; i<N; i++) {
				st=new StringTokenizer(br.readLine()," ");
				for (int j = 0; j < N; j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			
			
			
			
			
			
			
			System.out.println("#"+t+" "+getMacBenefit());
			
		}
	}
	private static int getMacBenefit() {
		return processCombination();
	}
	
	
	private static int processCombination() {
		int result=0, A=0,B=0;
		
		for (int i = 0; i < N; i++) {
			for(int j=0; j<=N-M; j++) {//�ϲ� A�� ����
				//���õ� M���� ���뿡�� ���� �� �ִ� �ִ� ������ �ʿ��ϴ�
				maxSum=0;
				makeMaxSubset(i, j, 0, 0, 0);
				A=maxSum;
				
				
				//�ϲ� B�� ����
				//�ϲ� A�� ������
				maxSum=0;
//				B=0;
				for(int j2=j+M; j2<=N-M; j2++) {
					makeMaxSubset(i, j2, 0, 0, 0);
//					if(B<maxSum)B=maxSum;
				}
				
				//�ϲ� A�� �ٹ������
				for(int i2=i+1; i2<N; i2++) {
					for(int j2=0; j2<=N-M; j2++) {
						makeMaxSubset(i2, j2, 0, 0, 0);
//						if(B<maxSum)B=maxSum;
					}
				}
				if(result<A+maxSum) {
					result=A+maxSum;
				}
			}
		}
		return result;
		
		
		
	}
	private static int maxSum=0;
	private static void makeMaxSubset(int i, int j, int cnt, int sum, int powerSum) {
		//��� ���ұ��� �� �κ����տ� ����غôٸ�
		if(sum>C)return;
		if(cnt==M) {
			if(maxSum<powerSum) maxSum=powerSum;
			return;
		}
		
		
		//����
		makeMaxSubset(i, j+1, cnt+1, sum+map[i][j], powerSum+(map[i][j]*map[i][j]));
		makeMaxSubset(i, j+1, cnt+1, sum, powerSum);
		
		//����
		
		
	}

}
