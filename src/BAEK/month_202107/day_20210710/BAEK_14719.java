package BAEK.month_202107.day_20210710;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * 
 * �� ����� �� ���� Ž���Ͽ� ���� ������ ������ ����
 *
 */
public class BAEK_14719 {
	static int H,W;
	static int[][] map;
	static int[] rain;
	static int[] dx= {1,-1};
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		H=Integer.parseInt(st.nextToken());
		W=Integer.parseInt(st.nextToken());
		map=new int[H][W];
		rain=new int[W];
		//�Է�
		st=new StringTokenizer(br.readLine()," ");
		for(int i=0; i<W; i++) {
			rain[i]=Integer.parseInt(st.nextToken());
		}
		
		
		//�Է����� ��� �ױ�
		//1�̸� ����̰� 0�̸� �� ����
		for(int i=0; i<W; i++) {
			for(int j=0; j<rain[i]; j++) {
				map[j][i]=1;
			}
		}
		
		
		
		
//		print();
		
		
		
		int cnt=0;
		for(int i=0; i<H; i++) {
			for(int j=0; j<W; j++) {
				if(map[i][j]==0) {
					if(check(i,j)) {//�� ���� �˻��ؿ� ���������� ������ ���δ�.
						cnt++;
					}
				}
			}
		}
		
		
		
		System.out.println(cnt);
		
	}
	private static boolean check(int y, int x) {
		
		int cnt=0;//�� �������� �� ������ ����� ���� �ִ��� ����� ���� üũ
		
		//������ �˻�
		int nx=x;
		while(true) {
			if(nx<0 || nx>=W)break;
			if(map[y][nx]==1) {//���������� �� ���ô��� ������� �����ִ�.
				cnt++;//���� üũ
				break;
			}
			nx+=dx[0];
		}
		
		//���� �˻�
		nx=x;
		while(true) {
			if(nx<0 || nx>=W)break;
			if(map[y][nx]==1) {//�������� �� ���ô��� �����ִ�.
				cnt++;//���� üũ
				break;
			}
			nx+=dx[1];
		}
		
		if(cnt!=2)return false;//������ 2���� �ƴϴ� ->�������� �ʴ�.
		
		
		
		return true;//�� ������ ������� �����ִ�.->����� ���� üũ�� 2����
	}
	private static void print() {
		for(int i=0; i<H; i++) {
			for(int j=0; j<W; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}

}
