package BAEK.month_202106.day_20210608;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BAEK_21773 {
	static int T,n;
	static PriorityQueue<process> pq=new PriorityQueue<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		T=Integer.parseInt(st.nextToken());
		n=Integer.parseInt(st.nextToken());
		for(int i=0; i<n;i++) {
			st=new StringTokenizer(br.readLine()," ");
			pq.add(new process(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
		}
//		System.out.println(pq.toString());
		StringBuffer sb=new StringBuffer();
		for(int i=0; i<T; i++) {
			process tmp=pq.poll();
			sb.append(tmp.id).append("\n");
			tmp.v--;
			tmp.time--;
			if(tmp.time==0)continue;
			pq.offer(tmp);
//			System.out.println(pq.toString());
		}
		
		System.out.println(sb.toString());
		
		
		
		
	}

}
class process implements Comparable<process>{
	int id;
	int time;
	int v;
	public process(int id, int time, int v) {
		super();
		this.id = id;
		this.time = time;
		this.v = v;
	}
	@Override
	public String toString() {
		return "process [id=" + id + ", time=" + time + ", v=" + v + "]";
	}
	@Override
	public int compareTo(process o) {
		if(this.v==o.v) {
			return this.id-o.id;
		}
		return o.v-this.v;
	}
	
}