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
		int N=Integer.parseInt(st.nextToken());//컨베이어 벨트의 길이
		int K=Integer.parseInt(st.nextToken());//내구도 0인 칸의 개수
		arr=new int[2*N];
		location=new int[N];
		Queue<Boolean> flag=new LinkedList<Boolean>();
		st=new StringTokenizer(br.readLine()," ");
		for(int i=0; i<2*N; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		int up=0;//올라가는 위치
		int down=N-1;//내려가는 위치
		int R=1;
		int out=0;
		L:while(true) {
			out++;
			
			move1(arr);//벨트 한칸 회전
			move2(location);//로보 위치를 가지고 있는 배열
			if(location[location.length-1]!=0) {
				flag.poll();
				location[location.length-1]=0;
			}
			
			if(!flag.isEmpty())//로봇이 있으면
			{
				int loc=0;
				for(int i=N-1; i>=0; i--) {
					if(location[i]!=0)//앞에 로봇 찾음
					{
						loc=i;//제일 앞에 있는 로봇의 위치
						while(loc+1<=down && arr[loc+1]!=0) {//앞에 로봇이 없거나 내구도가 0이 아니면
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
			
			if(arr[up]!=0 && location[up]==0) {//컨베이어의 올리는 위치에 내구도가 0이 아니고 현재 올리는 위치에 로봇이 없다면
				flag.add(true);//로봇 올리고
				arr[up]--;//내구도 내리고
				location[up]=R;//로복 위치 갱신
				
				R++;
				
			}
		
			int count=0;//과정 끝날때마다 확인
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
