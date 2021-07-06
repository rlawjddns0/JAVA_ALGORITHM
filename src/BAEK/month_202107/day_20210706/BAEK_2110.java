package BAEK.month_202107.day_20210706;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BAEK_2110 {
	static int N,C;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		N=Integer.parseInt(st.nextToken());
		C=Integer.parseInt(st.nextToken());
		arr=new int[N];
		int left=0;
		int right=0;
		int middle=0;
		for(int i=0; i<N; i++) {
			arr[i]=Integer.parseInt(br.readLine());
			
		}
		
		Arrays.sort(arr);
//		System.out.println(Arrays.toString(arr));
		
		right=arr[C-1]-arr[0];//공유기 최대 거리
		left=1;// 공유기 최소거리
		int ans=0;
		int first=0;
		int second=0;
		while(left<=right) {
			middle=(left+right)/2;
			int cnt=1;
			first=arr[0];
			for(int i=1; i<N; i++) {
				second=arr[i];
				if(second-first>=middle) {//만약에 결정한 거리(middle)가 두 공유기 사이에 거리보다 작으면  
					first=second;//공유기는 다시 first에 설치해야 한다. 1  4   5 -> first=1,  second=3,   이고 middle이 만약 2이면 1과 3에 설치를 해야 되는데 3은 없다  그래서 시작지점을 다시 
                        // first로 바꿔준다->공유기를 4에 설치한다
					cnt++;//공유기 설치 갯수 ++
				}
			}
//			System.out.println(middle);
//			System.out.println(cnt);
			
			
			if(cnt>=C) {//만약 공유기 설치 갯수가 많으면 범위를 넓혀준다.
				ans=middle;
				left=middle+1;
			}else{
				right=middle-1;
			}
			
			
		}
		 System.out.println(ans);
		
		
		
		
	}

}
