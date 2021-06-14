package BAEK.month_202106.day_20210614;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;
/*
 * ���� �����ϴ� ���ڿ��� ���ö����� ���ϴ°��� ��ȿ������
 * �׷��� �ϴ� ���� �����ϴ� ���ڿ��� ���̰� ���� �� ���ڿ��� ���̸� ���ϰ�
 * �� ���̰� �� ������ ��� ���ڿ��� ����
 * �߰��� ���� �����ϴ� ���ڿ��� �ϼ��Ǹ� �ʿ� ī��Ʈ +1
 * �׸��� �������� ��¸� ���ָ� �ȴ�
 * 
 */
public class BAEK_20166 {
	static int N,M;
	static char[][] map;
	static int K;
	static int cnt,Max;
	static int[] dx= {1,1,0,-1,-1,-1,0,1};
	static int[] dy= {0,1,1,1,0,-1,-1,-1};
	static int starty,startx;
	static HashMap<String, Integer> result;
	static String fav;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		String[] stringArray = new String[K]; // ������ ����� ���� Array
		map=new char[N][M];
		result=new HashMap<>();
		
		for(int i=0; i<N; i++) {
			map[i]=br.readLine().toCharArray();
		}
		
		for(int i=0; i<K; i++) {
			fav=br.readLine();//���� �����ϴ� ���ڿ�
			cnt=0;
			Max=Math.max(Max, fav.length());//�� ���ڿ��߿� ���� ū ���� ���ϱ�
			result.put(fav, 0);//�ʿ� ���� ���� �����ϴ� ���ڿ�, ���� 
			stringArray[i] = fav;
			
		}
		for(int j=0; j<N; j++) {
				for(int q=0; q<M; q++) {
					dfs(j,q,Character.toString(map[j][q]),1);//���ڿ� �ϳ� ������ ����
			}
		}
		StringBuilder sb = new StringBuilder();
//		System.out.println(result.toString());
		for(String key: stringArray) {
			sb.append(result.get(key)).append("\n");
		}
		
		System.out.println(sb);
		
		
	}
	private static void dfs(int y, int x,String str,int len) {
		
		if(result.containsKey(str)) {//���� �� ���ڿ��� ���� ������ �ִ� ���ڿ��̸�
			result.put(str, result.get(str)+1);//�� ���ڿ��� Ű��(����)+1
		}
		
		
		if(len==Max) {//���̰� �ƽ��� �Ѿ�� ����
			return;
		}
		
		
		for(int d=0; d<8; d++) {
			int ny=(y+dy[d]);
			int nx=(x+dx[d]);
			if(nx < 0)
				nx = M-1;
			else if(nx >= M)
				nx = 0;
			
			if(ny < 0)
				ny = N-1;
			else if(ny >= N)
				ny = 0;
			
			dfs(ny,nx,str+map[ny][nx],len+1);
		}
		
		
		
		
		
	}

}
