package SWE.month_202104.day_20210412;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.StringTokenizer;
/*
 * 
 * �ٽ� Ǯ��~~~
 */
public class SWE_5644 {
	static int M,bcCnt;
	static int[] pathA, pathB,playerA, playerB;
	static int[][]bc;
	static int[] dx= {0,0,1,0,-1};
	static int[] dy= {0,-1,0,1,0};
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int TC=Integer.parseInt(br.readLine());
		playerA=new int[2];
		playerB=new int[2];
		
		
		
		for(int t=1; t<=TC; t++) {
			StringTokenizer st=new StringTokenizer(br.readLine()," ");
			M=Integer.parseInt(st.nextToken());
			bcCnt=Integer.parseInt(st.nextToken());
			
			playerA[0]=playerA[1]=1;//A�� ��ġ 
			playerB[0]=playerB[1]=10;//B�� ��ġ
			
			pathA=new int[M+1];
			pathB=new int[M+1];
			
			bc=new int[bcCnt][4];
			
			
			StringTokenizer stA=new StringTokenizer(br.readLine()," ");
			StringTokenizer stB=new StringTokenizer(br.readLine()," ");
			
			
			//i=0���� 0���� 
			for(int i=1; i<=M; i++) {
				pathA[i]=Integer.parseInt(stA.nextToken());
			}
			for(int i=1; i<=M; i++) {
				pathB[i]=Integer.parseInt(stB.nextToken());
			}
			
			for(int i=0; i<bcCnt; i++) {
				st=new StringTokenizer(br.readLine()," ");
				bc[i][0]=Integer.parseInt(st.nextToken());//x
				bc[i][1]=Integer.parseInt(st.nextToken());//y
				bc[i][2]=Integer.parseInt(st.nextToken());//�Ÿ�
				bc[i][3]=Integer.parseInt(st.nextToken());//������

			}
			
			System.out.println("#"+t+" "+move());
			
		}//enc TC
		
		
	}//end main
	private static int move() {

		int totalSum=0;
		//�Žð������� �� ��ġ�켭 �� �÷��̾��� �ִ� �������� ����Ͽ� �ջ�
		
		for (int t = 0; t <=M; t++) {//�ʱ���ġ�� ���� �õ�
			
			playerA[0]+=dx[pathA[t]];
			playerA[1]+=dy[pathA[t]];
			
			playerB[0]+=dx[pathB[t]];
			playerB[1]+=dy[pathB[t]];
			
			
			//�� ��ġ���� �ִ� ������ ���
			totalSum+=getMaxCharge();
			
		}
		
		
		
		return totalSum;
	}
	private static int check(int a, int x, int y) {
		
		return Math.abs(bc[a][0]-x)+Math.abs(bc[a][1]-y)<=bc[a][2]?bc[a][3]: 0;
		
		
		
	}
	private static int getMaxCharge() {
		
		int max=0;
		for (int a = 0; a < bcCnt; a++) {//playesA�� ������ BC
			for (int b = 0; b < bcCnt; b++) {//�÷��̾� B�� ������ BC
				int sum=0;
				int amountA=check(a,playerA[0],playerA[1]);
				int amountB=check(b,playerB[0],playerB[1]);
				
				
				if(a!=b)sum=amountA+amountB;
				else sum=Math.max(amountA, amountB);
				
				if(max<sum)max=sum;
				
			}
			
		}
		
		
		
		
		
		return max;
	}

}
