package BACK.day_20210203;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BACK_20055 {
	static int arr[];
	static int location[];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		int N=Integer.parseInt(st.nextToken());//�����̾� ��Ʈ�� ����
		int K=Integer.parseInt(st.nextToken());//������ 0�� ĭ�� ����
		arr=new int[2*N];
		location=new int[N];
		Queue<Boolean> flag=new LinkedList<Boolean>();
		st=new StringTokenizer(br.readLine()," ");
		for(int i=0; i<2*N; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		int up=0;//�ö󰡴� ��ġ
		int down=N-1;//�������� ��ġ
		int R=1;
		int out=0;
		L:while(true) {
			out++;
			
			move1(arr);//��Ʈ ��ĭ ȸ��
			move2(location);//�κ� ��ġ�� ������ �ִ� �迭
			if(location[location.length-1]!=0) {
				flag.poll();
				location[location.length-1]=0;
			}
			
			if(!flag.isEmpty())//�κ��� ������
			{
				int loc=0;
				for(int i=N-1; i>=0; i--) {
					if(location[i]!=0)//�տ� �κ� ã��
					{
						loc=i;//���� �տ� �ִ� �κ��� ��ġ
						while(loc+1<=down && arr[loc+1]!=0) {//�տ� �κ��� ���ų� �������� 0�� �ƴϸ�
							arr[loc+1]--;
							int temp=location[loc];
							
							location[loc+1]=temp;
							location[loc]=0;
							loc++;
						}
						
							
					}
				}
				if(location[location.length-1]!=0) {
							flag.poll();
							location[location.length-1]=0;
						}
				
				int count=0;
				for(int i=0; i<arr.length; i++) {
					if(arr[i]==0)
						count++;
				}
				if(count>=K)
					break L;
				
			}
			
			if(arr[up]!=0 && location[up]==0) {//�����̾��� �ø��� ��ġ�� �������� 0�� �ƴϰ� ���� �ø��� ��ġ�� �κ��� ���ٸ�
				flag.add(true);//�κ� �ø���
				arr[up]--;//������ ������
				location[up]=R;//�κ� ��ġ ����
				
				R++;
				
			}
		
			int count=0;//���� ���������� Ȯ��
			for(int i=0; i<arr.length; i++) {
				if(arr[i]==0)
					count++;
			}
			if(count>=K)
				break L;
		
			
		}
		
		System.out.println(out);
		
		
		
	}
	
	public static void move1(int[] arr) {
		int temp = arr[arr.length - 1];

		for (int i = arr.length - 1; i >= 1; i--)
			arr[i] = arr[i - 1];
		arr[0] = temp;

	}
	public static void move2(int[] arr) {
		int temp =arr[arr.length - 1];

		for (int i = arr.length - 1; i >= 1; i--)
			arr[i] = arr[i - 1];
		arr[0] = temp;

	}
	
}
