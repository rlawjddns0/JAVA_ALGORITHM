package BAEK.month_202101.day_20210117;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//N���� ������ �־�����. �̶�, �ּڰ��� �ִ��� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
public class bronze3_10818 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));//scanner���� ����
		int N=Integer.parseInt(br.readLine());
		StringTokenizer st;
		st = new StringTokenizer(br.readLine()," ");//N���� ���� ������ �������� �д´�
		
		int min=1000000;
		int max=-1000000;
		int arr[] = new int[N];
		for(int i =0; i<N; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
			
		}
		for(int i=0; i<N; i++) {
			if(arr[i]<min) {
				min=arr[i];
			}
			
			if(arr[i]>max) {
				max=arr[i];
			}
		}
		
		
		System.out.println(min+ " " +max);
		
		
	}

}
