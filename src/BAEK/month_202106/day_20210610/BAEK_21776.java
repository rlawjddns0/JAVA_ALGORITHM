package BAEK.month_202106.day_20210610;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BAEK_21776 {
	static int N,C;
	static user[] user;
	static String[] card;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		N=Integer.parseInt(st.nextToken());
		C=Integer.parseInt(st.nextToken());
		user=new user[N];
		card=new String[C];
		for(int i=0; i<N; i++) {
			st=new StringTokenizer(br.readLine()," ");
			int num=Integer.parseInt(st.nextToken());
			user[i]=new user(num);
			for(int j=0; j<num; j++) {
				user[i].num[j]=Integer.parseInt(st.nextToken())-1;
			}
			
		}
		StringBuffer sb1=new StringBuffer();
		
		
		
		for(int i=0; i<C; i++) {
			String str=br.readLine();
			card[i]=str;
			for(int j=0; j<N; j++) {
				for(int k=0; k<user[j].n; k++) {
					if(user[j].num[k]==i) {
						user[j].card[user[j].idx++]=str;
					}
				}
			}
			
		}
		
//		for(int i=0; i<N; i++) {
//			System.out.println(user[i].toString());
//		}
		
		
		dfs(0,new int[C],new boolean[C]);
		
		ArrayList<String> answer=new ArrayList<>();
		for (String string : result) {
			answer.add(string);
		}
		
		Collections.sort(answer);
		
		for(int i=0; i<answer.size(); i++) {
			System.out.println(answer.get(i));
		}
		
		
	}
	static HashSet<String> result=new HashSet<>();
	private static void dfs(int k,int[] sel, boolean[] visit) {
		if(k==C) {
			if(!check(sel))return;
			
			ArrayList<String> tmp=new ArrayList<>();
			for(int i=0; i<C; i++) {
				if(card[sel[i]].contains(",")) {
					StringTokenizer st=new StringTokenizer(card[sel[i]],",");
					while(st.hasMoreTokens()) {
						tmp.add(st.nextToken());
					}
				}else {
					tmp.add(card[sel[i]]);
				}
			}
			
			if(tmp.get(0).contains("DEL")) {
				result.add("ERROR");
				return;
			}
			
			String ans="";
			StringBuffer sb=new StringBuffer();
			for(int i=0; i<tmp.size(); i++) {
				StringTokenizer st=new StringTokenizer(tmp.get(i)," ");
				String op=st.nextToken();
				String ch=st.nextToken();
				
				if(op.equals("ADD")) {
					sb.append(ch);
				}else if(op.equals("DEL")) {
					int idx=Integer.parseInt(ch);
					if(sb.length()>0 && sb.length()>idx) {
						sb.deleteCharAt(idx);
					}
					else {
						result.add("ERROR");
						return;
					}
				}
			}
			
			if(sb.length()==0) {
				result.add("EMPTY");
			}else {
				result.add(sb.toString());
			}
			
			
			
			return;
		}
		
		for(int i=0; i<C; i++) {
			if(visit[i])continue;
			sel[k]=i;
			visit[i]=true;
			dfs(k+1,sel,visit);
			visit[i]=false;
			
		}
		
		
		
		
		
	}
	private static boolean check(int[] sel) {
		
		int[] idx=new int[N];
		
		for(int i=0; i<sel.length; i++) {
			for(int j=0; j<N; j++) {
				for(int k=0; k<user[j].num.length; k++) {
					if(sel[i]==user[j].num[k]) {
						if(k==idx[j]) {
							idx[j]++;
						}else {
							return false;
						}
					}
				}
			}
		}
		
		
		
		
		
		
		return true;
	}

}
class user{
	int n;
	int idx=0;
	String[] card;
	int[] num;
	public user(int n) {
		super();
		this.n = n;
		this.card = new String[n];
		this.num=new int[n];
	}
	@Override
	public String toString() {
		return "user [n=" + n + ", card=" + Arrays.toString(card) + "]";
	}
	
}