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
		
		int[] top = new int[N / 2];//석순
		int[] bottom = new int[N / 2];//종유석
		int q=0,w=0;
		for(int i=0; i<N/2; i++) {
			int tp1=Integer.parseInt(br.readLine());
			int tp2=Integer.parseInt(br.readLine());
			bottom[q++]=tp1;
			top[w++]=tp2;
		}
		
		//오름차순 정렬
		Arrays.sort(bottom);
		Arrays.sort(top);
		
		int ans=Integer.MAX_VALUE;
		int cnt=0;
		//System.out.println(Arrays.toString(top));
		//System.out.println(Arrays.toString(bottom));
		for (int h = 1; h <= H; h++) {
			//높이 h에서 개똥벌레가 파괴하는 종유석,석순 갯수 구하기
			int b=search(bottom,h-1);//종유석 기준 바닥부터
			int t=search(top,H-h);//석순 기준 천장부터
			int tmp= b+t;
			//System.out.println(tmp);
			if(tmp<ans) {//최솟값
				ans=tmp;
				cnt=1;//갠신
			}
			else if(tmp==ans) {//최솟값이 같으면 ++
				cnt++;
			}
		}
		System.out.println(ans+" "+cnt);
		
	}
	public static int search(int[] arr,int h) {
		
		int left=0;
		int right=arr.length-1;//인덱스로 접근 할꺼라서-1
		
		while(left<=right){
			int mid=(left+right)/2;
			//파괴를 시작하는 높이릐 최솟값을 구해야함
			if(arr[mid]<=h) {//현재 선택한 방해물의 크기가 개똥벌레가 날아온 높이보다 작거나 같다(파괴하지 않음);
				left=mid+1;//기준을 높임
			}else {//개똥벌레가 날아가는 높이보다 방해물 높이가 더 크가 (파괴)
				right=mid-1;//기준을 낮춤
			}
		}
		//개똥벌레가 h로 날아올때 arr[right]밑으로 날라가면 파괴하지 않음
		return (arr.length)-(right+1);//arr[right]부터 파괴를 하니까 전체길이-(right+1)-> right은 길이가 아닌 index값이니까 +1
	}
}
