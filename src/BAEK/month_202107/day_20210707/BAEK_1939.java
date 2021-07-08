package BAEK.month_202107.day_20210707;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BAEK_1939 {
	static int N,M;
	static int start,end;
	static ArrayList<v>[] g;
	static boolean[] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		visit=new boolean[N+1];
		
		g=new ArrayList[N+1];
		for(int i=1; i<=N; i++) {
			g[i]=new ArrayList<v>();
		}
		int left=1;
		int right=0;//Integer.MAX_VAULE�� �ϸ� �޸� �ʰ��� ����
		int middle=0;
		int ans=0;
		for(int i=0; i<M; i++) {
			st=new StringTokenizer(br.readLine()," ");
			int from=Integer.parseInt(st.nextToken());
			int to=Integer.parseInt(st.nextToken());
			int w=Integer.parseInt(st.nextToken());
			g[from].add(new v(to,w));
			g[to].add(new v(from,w));
			right=Math.max(right, w);
		}
		
		st=new StringTokenizer(br.readLine()," ");
		start=Integer.parseInt(st.nextToken());
		end=Integer.parseInt(st.nextToken());
		
		
		while(left<=right) {//�ִ� �߷��� ã�� ���ؼ�
			middle=(left+right)/2;
			
			if(solution(middle)) {//���� ã�� �߷��� Ʈ��� ->���������� �������� middle�� �� �� ������
				ans=middle;//������ ����
				left=middle+1;//�ϴ� ���Ը� �� �÷�����.
			}else {//������
				right=middle-1;//���Ը� ������.
			}
			
			
			
			
			
		}
		
		
		
		System.out.println(ans);
		
	
	
	}
	static int ans=Integer.MIN_VALUE;
	private static boolean solution(int W) {
		Queue<Integer> q=new LinkedList<>();
		q.offer(start);
		Arrays.fill(visit, false);
		visit[start]=true;
		
		
		while(!q.isEmpty()) {
			int next=q.poll();
			
			if(next==end) {
				return true;
			}
			
			for(int i=0; i<g[next].size(); i++) {
				if(!visit[g[next].get(i).next]&& g[next].get(i).w>=W) {//���� �湮 ���߰�  �̺� Ž���� ���Է� �� �� ������
					q.offer((g[next].get(i).next));//ť�� �ְ�
					visit[g[next].get(i).next]=true;//�湮ó��
				}
			}
			
			
			
		}
		
		return false;
		
		
	}

}
class v{
	int next,w;

	public v(int next, int w) {
		super();
		this.next=next;
		this.w = w;
	}
	
}
