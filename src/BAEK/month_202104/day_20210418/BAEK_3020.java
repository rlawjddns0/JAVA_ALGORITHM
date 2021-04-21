package BAEK.month_202104.day_20210418;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BAEK_3020 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		int N=Integer.parseInt(st.nextToken());
		int H=Integer.parseInt(st.nextToken());
		
		int[] top = new int[N / 2];//����
		int[] bottom = new int[N / 2];//������
		int q=0,w=0;
		for(int i=0; i<N/2; i++) {
			int tp1=Integer.parseInt(br.readLine());
			int tp2=Integer.parseInt(br.readLine());
			bottom[q++]=tp1;
			top[w++]=tp2;
		}
		
		//�������� ����
		Arrays.sort(bottom);
		Arrays.sort(top);
		
		int ans=Integer.MAX_VALUE;
		int cnt=0;
		//System.out.println(Arrays.toString(top));
		//System.out.println(Arrays.toString(bottom));
		for (int h = 1; h <= H; h++) {
			//���� h���� ���˹����� �ı��ϴ� ������,���� ���� ���ϱ�
			int b=search(bottom,h-1);//������ ���� �ٴں���
			int t=search(top,H-h);//���� ���� õ�����
			int tmp= b+t;
			//System.out.println(tmp);
			if(tmp<ans) {//�ּڰ�
				ans=tmp;
				cnt=1;//����
			}
			else if(tmp==ans) {//�ּڰ��� ������ ++
				cnt++;
			}
		}
		System.out.println(ans+" "+cnt);
		
	}
	public static int search(int[] arr,int h) {
		
		int left=0;
		int right=arr.length-1;//�ε����� ���� �Ҳ���-1
		
		while(left<=right){
			int mid=(left+right)/2;
			//�ı��� �����ϴ� ���̐l �ּڰ��� ���ؾ���
			if(arr[mid]<=h) {//���� ������ ���ع��� ũ�Ⱑ ���˹����� ���ƿ� ���̺��� �۰ų� ����(�ı����� ����);
				left=mid+1;//������ ����
			}else {//���˹����� ���ư��� ���̺��� ���ع� ���̰� �� ũ�� (�ı�)
				right=mid-1;//������ ����
			}
		}
		//���˹����� h�� ���ƿö� arr[right]������ ���󰡸� �ı����� ����
		return (arr.length)-(right+1);//arr[right]���� �ı��� �ϴϱ� ��ü����-(right+1)-> right�� ���̰� �ƴ� index���̴ϱ� +1
	}
}
