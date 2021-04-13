package BAEK.month_202104.day_20210413;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BAEK_14226 {
	static boolean visit[][]=new boolean[3001][3001];//클립 보드에있는거 , 화면에 있는거
	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		int[] dp=new int[1001];
		int S=sc.nextInt();
		
		bfs(S);
		
		
		
		
	}

	private static void bfs(int s) {
		Queue<emoticon> q=new LinkedList<>();
		q.offer(new emoticon(0,1,0));
		visit[0][1]=true;
		
		while(!q.isEmpty()) {
			
			emoticon tmp=q.poll();
			
			
			if(tmp.screen==s) {
				System.out.println(tmp.time);
				break;
			}
			
			//클립보드에 저장
			q.offer(new emoticon(tmp.screen,tmp.screen,tmp.time+1));
			
			//붙이기
			if(!visit[tmp.clip][tmp.screen+tmp.clip] && tmp.clip!=0 && tmp.clip+tmp.screen<=s) {
				q.offer(new emoticon(tmp.clip, tmp.clip+tmp.screen, tmp.time+1));
				visit[tmp.clip][tmp.screen+tmp.clip]=true;
			}
			
			
			
			if(tmp.screen>=1 && !visit[tmp.clip][tmp.screen-1] ) {
				q.offer(new emoticon(tmp.clip,tmp.screen-1,tmp.time+1));
				visit[tmp.clip][tmp.screen-1]=true;
			}
			
			
		}
		
		
		
		
		
		
		
		
		
	}

}
class emoticon{
	int clip=0;
	int screen=0;
	int time=0;
	public emoticon(int clip, int screen, int time) {
		super();
		this.clip = clip;
		this.screen = screen;
		this.time = time;
	}
	
}
