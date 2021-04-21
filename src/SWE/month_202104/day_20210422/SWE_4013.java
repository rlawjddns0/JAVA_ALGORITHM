package SWE.month_202104.day_20210422;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWE_4013 {
	static int K;
	static int[] dx = { 1, -1 };
	// static multiQ[] mq;
	static indexQ[] iq;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int TC=Integer.parseInt(br.readLine());
		
		for(int t=1; t<=TC; t++) {
			K=Integer.parseInt(br.readLine());
			
			iq = new indexQ[4];
			for (int i = 0; i < 4; i++) {
				StringTokenizer st=new StringTokenizer(br.readLine()," ");
				int[] tmp=new int[8];
				for(int j=0; j<8; j++) {
					tmp[j]=Integer.parseInt(st.nextToken());
				}
				iq[i]=new indexQ(tmp);
			}
			int[][] arr = new int[K][2];
			for (int i = 0; i < K; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				arr[i][0] = Integer.parseInt(st.nextToken());
				arr[i][1] = Integer.parseInt(st.nextToken());
			}
			
			// 1 �ð� ���� -1 �ݽð�
			// �ð��°� ť�� -> ������ �ݽð�� �ݴ�
			for (int i = 0; i < K; i++) {
				int num = arr[i][0];
				int dir = arr[i][1];
				if (num == 1) {// ù ��° ��Ϲ���
					int R1 = iq[0].idx[2];// ������ ���
					iq[0].move(dir);// ȸ��
					dir *= -1;// ���� �ٲ��ְ�

					int R2 = iq[1].idx[2];
					if (R1 == iq[1].idx[6])
					{continue;}	
					else {
						iq[1].move(dir);
						dir *= -1;
					}

					int R3 = iq[2].idx[2];
					if (R2 == iq[2].idx[6]) {
						continue;
					}
					else {
						iq[2].move(dir);
						dir *= -1;
					}

					if (R3 == iq[3].idx[6])
					{continue;}
					else {
						iq[3].move(dir);

					}

				} else if (num == 2) {
					int L1 = iq[1].idx[6];/// 2��° ��� ����
					int R1 = iq[1].idx[2];
					iq[1].move(dir);
					dir *= -1;

					if (iq[0].idx[2] == L1) {// 1��° ��� ���� Ȯ��

					} else {
						iq[0].move(dir);
						
					}

					int R2 = iq[2].idx[2];
					if (iq[2].idx[6] == R1) {// 3��° Ȯ��
						continue;
					} else {
						iq[2].move(dir);
						dir *= -1;
					}

					if (R2 == iq[3].idx[6]) {
						continue;
					} else {
						iq[3].move(dir);
					}

				} else if (num == 3) {
					int L3 = iq[2].idx[6];/// 3��° ��� ����
					int R3 = iq[2].idx[2];

					iq[2].move(dir);
					dir *= -1;

					if (R3 == iq[3].idx[6]) {// 4 ��°

					} else {
						
						iq[3].move(dir);
					}

					int L2 = iq[1].idx[6];
					if (L3 == iq[1].idx[2]) {// 2��°
						continue;
					} else {
						iq[1].move(dir);
						dir *= -1;
					}

					if (L2 == iq[0].idx[2]) {// 1 ��°
						continue;
					} else {
						iq[0].move(dir);
					}
				} else {
					int L4 = iq[3].idx[6];
					iq[3].move(dir);
					dir *= -1;

					int L3 = iq[2].idx[6];
					if (L4 == iq[2].idx[2]) {
						continue;
					} else {
						iq[2].move(dir);
						dir *= -1;
					}

					int L2 = iq[1].idx[6];
					if (L3 == iq[1].idx[2]) {
						continue;
					} else {
						iq[1].move(dir);
						dir *= -1;
					}

					if (L2 == iq[0].idx[2]) {
						continue;
					} else {
						iq[0].move(dir);
					}
				}
				
			}
			String result = "";

			for(int a=3; a>=0; a--) {
				//System.out.println(Arrays.toString(iq[a].idx));
				if(iq[a].idx[0]==1) {
					result+=iq[a].idx[0];
				}
				else {
					result+="0";
				}
			}


			System.out.println("#"+t+" "+Integer.parseInt(result, 2));
			
		}
	}

}
class indexQ {
	int[] idx;

	public indexQ(int[] ch) {
		this.idx =ch; 
	}

	@Override
	public String toString() {
		return "indexQ [idx=" + Arrays.toString(idx) + "]";
	}

	public void move(int n) {
		if (n == 1) {// �ð�
			int temp = idx[7];
			for (int i = 7; i >= 1; i--) {
				idx[i] = idx[i - 1];
			}
			idx[0] = temp;
		} else {// �ݽð�
			int temp = idx[0];
			for (int i = 0; i <= 6; i++) {
				idx[i] = idx[i + 1];
			}
			idx[7] = temp;
		}
	}

}