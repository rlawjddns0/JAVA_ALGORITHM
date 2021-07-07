package BAEK.month_202107.day_20210707;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BAEK_5014 {
	static int F,S,G,U,D;
	static boolean[] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		
		F=Integer.parseInt(st.nextToken());//���� ���� �� �� �ǹ��� ũ��
		S=Integer.parseInt(st.nextToken());//���� ��
		G=Integer.parseInt(st.nextToken());//���� ��
		U=Integer.parseInt(st.nextToken());//���� ���� �� �� �ִ���
		D=Integer.parseInt(st.nextToken());//�Ʒ��� �� �� �� �� �ִ���
		
		
		int ans=bfs();//�ּҰŸ��̹Ƿ� bfs�� ~
		if(ans==-1) {
			System.out.println("use the stairs");
		}else {
			System.out.println(ans);
		}
		
		
		
		
		
		
	}
	private static int bfs() {
		Queue<floor> q=new LinkedList<>();
		q.add(new floor(S,0));//�������� ���� �󸶳� �Ű������ ���� ī��Ʈ�� �־��ش� 
                              //ó�� ������ �ȿ����̴ϱ� 0
		visit=new boolean[F+1];//1���ʹϱ� +1

		visit[S]=true;//ó�� ������ ���� Ʈ��~
		
		
		while(!q.isEmpty()) {
			
			floor cur=q.poll();
			
			if(cur.current==G) {//���� ���� ���� ���� ���̸� ���ݱ��� �������� ī��Ʈ ����
				return cur.cnt;
			}
			
			
			if(cur.current+U<=F && !visit[cur.current+U]) {//���� �ö󰡴� ��� U�� ���Ѱ� F���� �۰ų� ���� ���� �湮 ���� �ʾҴٸ�
				q.offer(new floor(cur.current+U,cur.cnt+1));//U���� �� �־��ְ� ī��Ʈ +1
				visit[cur.current+U]=true;
			}
			
			if(cur.current-D>0 && !visit[cur.current-D]) {
				q.offer(new floor(cur.current-D,cur.cnt+1));
				visit[cur.current-D]=true;
			} 
			
			
			
			
		}
		
		
		return -1;
		
		
	
	}

}
class floor{
	int current;
	int cnt;
	public floor(int current, int cnt) {
		super();
		this.current = current;
		this.cnt = cnt;
	}
	
}