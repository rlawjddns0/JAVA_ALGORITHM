package BACK.day_20210123;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class BACK_13335 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st=new StringTokenizer(br.readLine()," ");
		int n=Integer.parseInt(st.nextToken());//Ʈ���� ����
		int bridge_length=Integer.parseInt(st.nextToken());//�ٸ��� �ö󰥼� �ִ� Ʈ�� ��==�ٸ��� ����
		int L=Integer.parseInt(st.nextToken());//����
		Queue<Integer> q=new LinkedList<Integer>();
		st=new StringTokenizer(br.readLine()," ");
		int[] arr=new int[n];
		for(int i=0; i<n; i++)
			arr[i]=Integer.parseInt(st.nextToken());
		
		
		int time=0;
		int sumOfq=0;
		for(int i=0; i<n; i++) {
			while(true) {
					if(q.isEmpty()) {//q�� ��� ������ q�� Ʈ�� �ø���
						q.offer(arr[i]);//q�� Ʈ�� �ø���
						sumOfq+=arr[i];//���� ���
						time++;//�ö����ϲ� time++
						break;
					}
					else if(q.size()==bridge_length) {//�ٸ� ���� Ʈ���� �� �ö� ����
						sumOfq-=q.poll();//�� �տ��� �ϳ� ����
						
					}
					else {//�ٸ� ���� Ʈ���� �� �ö� �� ������
						if(sumOfq+arr[i]>L) {//�ٸ����� �ִ� Ʈ���� ���Կ� ���� ���� Ʈ���� ���� ���� ������ �Ѿ��
							q.offer(0);//0�� �ٸ��� �־��ְ�
							time++;
							
						}else {//�۰ų� ������ 
							q.offer(arr[i]);
							sumOfq+=arr[i];
							time++;
							break;
						}
					}
					
					
			}
		}
		
				
			
			
			
		System.out.println(time+bridge_length);//������ Ʈ���� �ٸ� ���̸�ŭ �����̹Ƿ� �ٸ� ���̸� �����ش�.
			
			
		
		
		

	}

}
