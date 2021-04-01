package BAEK.month_202104.day_20210401;

import java.util.Arrays;
import java.util.Scanner;

public class BAEK_21278 {
	static long[][] D;//Integer.MAX���� �������� ��찡 �־ �� ��� int�� ������ �Ѿ�� �׷��� lon������ ����
	static int N,M;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		M=sc.nextInt();
		D=new long[N+1][N+1];
		
		for(int i=1; i<N+1; i++) {
			Arrays.fill(D[i], Integer.MAX_VALUE);
		}
		for(int i=1; i<N+1; i++) {
			D[i][i]=0;
		}
		for(int i=0; i<M; i++) {
			int from=sc.nextInt();
			int to=sc.nextInt();
			D[from][to]=1;
			D[to][from]=1;
		}
		
		floyd();
		dfs(new int[2], 0,1);//(1,2) �� (2,1)�̳� ����
		System.out.println(ch1+" "+ch2+" "+Sum);
		
	}
	static int Sum=Integer.MAX_VALUE;
	static int ch1, ch2;
	public static void dfs(int[] sel, int k, int idx) {
		if(k==sel.length) {
			//System.out.println(Arrays.toString(sel));
			int tmpsum=0;
			for(int i=1; i<N+1; i++) {
				if(sel[0]==i || sel[1]==i)continue;//ġŲ���� ����
				int min=Integer.MAX_VALUE;
				for(int j=0; j<sel.length; j++) {
					min=(int)Math.min(min, D[i][sel[j]]);//ġŲ���� �ƴѰ����� ġŲ�� ������ �Ÿ��� ���� �ּ��� �Ÿ� ���ϱ�(���� ����� ġŲ��)���ϱ� 
				}
				tmpsum+=(min*2);
				
			}
			//System.out.println(tmpsum);
			//sel[0]�� ������ ���� ������
			if(tmpsum<Sum) {//ġŲ�������� �Ÿ��� ���� ������ ���Դ�
				Sum=tmpsum;//���� ������ ����
				ch1=sel[0];//��ȣ�� ���� ġŲ��
				ch2=sel[1];//ū ġŲ��
			}else if(Sum==tmpsum) {//����
				if(sel[0]<ch1) {//������ ���� ġŲ�� ��ȣ���� ���� �� ġŲ�� ��ȣ�� �� �۴�
					ch1=sel[0];
					ch2=sel[1];
				}else if(sel[0]==ch1) {//������ ������
					if(sel[1]<ch2) {//ū�� ��
						ch1=sel[0];
						ch2=sel[1];
					}
				}
			}
			
			
			
			
			return;
		}
		
		
		for(int i=idx; i<N+1; i++) {
			sel[k]=i;
			dfs(sel,k+1,i+1);
		}
		
	}
	
	public static void print() {
		for(int i=1; i<N+1; i++) {
			for(int j=1; j<N+1; j++) {
				System.out.print(D[i][j]+" ");
			}
			System.out.println();
		}
	}
	public static void floyd() {
		
		for(int k=1; k<N+1; k++) {
			for(int i=1; i<N+1; i++) {
				for(int j=1; j<N+1; j++) {
					D[i][j]=Math.min(D[i][k]+D[k][j], D[i][j]);
				}
			}
		}
		
	}

}
