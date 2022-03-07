package Programers.day_20220307;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 가장_먼_노드 {
	public static void main(String[] args) {
		int n=6;
		int[][] edge= {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
		System.out.println(solution(n,edge));
	}
	public static int solution(int n, int[][] edge) {
		
        int answer = 0;
        ArrayList<Integer>[] graph=new ArrayList[n];
        for(int i=0; i<n; i++) {
        	graph[i]=new ArrayList<>();
        }
        
        for(int i=0; i<edge.length; i++) {
        	int from =edge[i][0];
        	int to=edge[i][1];
        	graph[from-1].add(to-1);
        	graph[to-1].add(from-1);
        }
        
        boolean[] visit=new boolean[n];
        visit[0]=true;
        Queue<tt> q=new LinkedList<>();
        q.offer(new tt(0,0));
        int cnt=Integer.MIN_VALUE;
        
        while(!q.isEmpty()) {
        	tt cur=q.poll();
        	int tp=0;
        	for(int i=0; i<graph[cur.n].size(); i++) {
        		if(!visit[graph[cur.n].get(i)])tp++;
        	}
        	
        	
        	if(tp==0) {
        		if(cnt<cur.cnt) {
        			cnt=cur.cnt;
        			answer=1;
        			continue;
        		}else if(cnt==cur.cnt) {
        			answer++;
        			continue;

        		}
        	}
        	
        	for(int i=0; i<graph[cur.n].size(); i++) {
        		if(visit[graph[cur.n].get(i)])continue;
        		q.offer(new tt(graph[cur.n].get(i),cur.cnt+1));
        		visit[graph[cur.n].get(i)]=true;
        	}
        	
        	
        	
        	
        }
        
        
        
        
        
        
        return answer;
    }

    static class tt{
    	int n,cnt;

		public tt(int n, int cnt) {
			super();
			this.n = n;
			this.cnt = cnt;
		}
    	
    }
}
