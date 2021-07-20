package BAEK.month_202107.day_20210712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 * �̺б׷������� �ƴ����� Ȯ���ϴ� ��������
 * �̺б׷����� ���� Ž�� ������ �̾����� ��� ������ �ٸ� ������ ������ �Ǿ�� �Ѵ�.
 * �� 1�� ������ ���������� Ž���� �����ϸ� 1�� ������ �̾����� �ٸ� �������� �Ķ����̾�� �Ѵ�.
 * �̷��� 1������ �湮���� ���� ������ Ȯ���ϸ鼭 ������ ������ �Ѵ�.
 * �׸��� ������ Ȯ���ϸ鼭 ��å�� ������ �̾����� ������ ������ ������ �̺б׷����� �ƴϴ�.
 */
public class BAEK_1707 {
	static int T;
	static int V,E;
	static ArrayList<Integer>[] g;
	static int[] visit;
	static int RED=1;//������ �����ϱ����ؼ� ���� ������. ���⼭ 0�� �̹�� �����̴�.
	static int BLUE=2;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		T=Integer.parseInt(br.readLine());
		
		for(int t=0; t<T; t++) {
			//�Է�
			StringTokenizer st=new StringTokenizer(br.readLine()," ");
			V=Integer.parseInt(st.nextToken());
			E=Integer.parseInt(st.nextToken());
			visit=new int[V+1];
			//��� ����Ʈ �ʱ�ȭ
			g=new ArrayList[V+1];
			for(int i=1; i<=V; i++) {
				g[i]=new ArrayList<>();
			}
			
			
			//����� ���� �Է�
			for(int i=0; i<E; i++) {
				st=new StringTokenizer(br.readLine()," ");
				int from=Integer.parseInt(st.nextToken());
				int to=Integer.parseInt(st.nextToken());
				//�� ����
				g[from].add(to);
				g[to].add(from);
			}
			for(int i=1; i<=V; i++) {
				if(visit[i]==0) {//�湮���� �ʾ�����
					bfs(i);//Ž��
				}
			}
			
			boolean flag=check();
			
			if(flag) {
				System.out.println("YES");
			}else {
				System.out.println("NO");
			}
			
		}
		
		
	}
	
	private static boolean check() {//�̺� �׷������� Ȯ���ϴ� �Լ�
		for(int i=1; i<=V; i++) {
			int size=g[i].size();//i ������ �̾����� ������ ��
			for(int j=0; j<size; j++) {
				int next=g[i].get(j);//i ������ �̾����� ����
				if(visit[i]==visit[next])return false;//���� ���� ������ �̺б׷����� �ƴϴ�.
			}
		}
		
		return true;
	}
	private static void bfs(int start) {
		
		Queue<Integer> q=new LinkedList<>();
		q.offer(start);
		int color=RED;//ó������ �������� �����ٰ� �����Ѵ�.
		visit[start]=color;//ù Ž�� ������ ������
		
		while(!q.isEmpty()) {
			
			int now=q.poll();
			if(visit[now]==RED) {//���� Ž�� ������ �������̸� ���� Ž�� ������ �Ķ������� �ٲ۴�.
				color=BLUE;
			}else if(visit[now]==BLUE) {//�ݴ�
				color=RED;
			}
			for(int i=0; i<g[now].size(); i++) {
				if(visit[g[now].get(i)]==0) {//���� �湮���� �ʾ�����
					visit[g[now].get(i)]=color;//�� ������ ���� Ž�� �������� �ٸ� ������ üũ
					q.offer(g[now].get(i));//ť�� �ִ´�.
				
				}
			}
			
		}
		
		
		
	}

}
