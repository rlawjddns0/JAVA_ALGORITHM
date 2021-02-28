package BAEK.month_202102.day_20210225;
/*
 * 
 * 
 * 다시풀기
 * 
 * 
 */
import java.util.Scanner;

public class BAEK_16987 {
	static int N;
	static egg[] e;
	static int ans=Integer.MIN_VALUE;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		e=new egg[N];
		egg[] tmp=new egg[N];
		for(int i=0; i<N; i++) {
			e[i]=new egg(sc.nextInt(),sc.nextInt(),i);
		}
		solve(0);
		System.out.println(ans);
		
	}
	public static void solve(int now) {
		
		if(now==N) {
			
			int count=0;
			for(int i=0;i<N; i++) {
				if(e[i].d<=0)count++;
			}
			if(ans<count)ans=count;
			return;
			
		}
		
		
		
		if(e[now].d<=0) {
			solve(now+1);
		}else {
			boolean f=false;
			for(int i=0; i<N; i++) {
				if(i==now || e[i].d<=0)continue;
				f=true;
				e[i].d-=e[now].w;
				e[now].d-=e[i].w;
				solve(now+1);
				e[i].d+=e[now].w;//복원
				e[now].d+=e[i].w;
			}
			if(!f)solve(now+1);
		}
		
		
	}

}
class egg{
	int d;
	int w;
	int idx;
	egg(int d, int w,int idx){
		this.d=d;
		this.w=w;
		this.idx=idx;
	}
	
}