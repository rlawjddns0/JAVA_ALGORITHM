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
		int n=Integer.parseInt(st.nextToken());//트럭의 갯수
		int bridge_length=Integer.parseInt(st.nextToken());//다리에 올라갈수 있는 트럭 수==다리의 길이
		int L=Integer.parseInt(st.nextToken());//하중
		Queue<Integer> q=new LinkedList<Integer>();
		st=new StringTokenizer(br.readLine()," ");
		int[] arr=new int[n];
		for(int i=0; i<n; i++)
			arr[i]=Integer.parseInt(st.nextToken());
		
		
		int time=0;
		int sumOfq=0;
		for(int i=0; i<n; i++) {
			while(true) {
					if(q.isEmpty()) {//q가 비어 있으면 q에 트럭 올리기
						q.offer(arr[i]);//q에 트럭 올리기
						sumOfq+=arr[i];//하중 계산
						time++;//올라갔으니께 time++
						break;
					}
					else if(q.size()==bridge_length) {//다리 위에 트럭이 다 올라가 있음
						sumOfq-=q.poll();//맨 앞에서 하나 삭제
						
					}
					else {//다리 위에 트럭이 더 올라갈 수 있으면
						if(sumOfq+arr[i]>L) {//다리위에 있는 트럭의 무게와 지금 들어올 트럭의 무게 합이 하중을 넘어서면
							q.offer(0);//0을 다리에 넣어주고
							time++;
							
						}else {//작거나 같으면 
							q.offer(arr[i]);
							sumOfq+=arr[i];
							time++;
							break;
						}
					}
					
					
			}
		}
		
				
			
			
			
		System.out.println(time+bridge_length);//마지막 트럭은 다리 길이만큼 움직이므로 다리 길이를 더해준다.
			
			
		
		
		

	}

}
