package BAEK.month_2022201.day_20220105;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BAEK_19942 {
	static int N;
	static int protain, fat,carbo, vitamin;
	static int[][] input;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		
		input=new int[N][5];
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		
		protain=Integer.parseInt(st.nextToken());
		fat=Integer.parseInt(st.nextToken());
		carbo=Integer.parseInt(st.nextToken());
		vitamin=Integer.parseInt(st.nextToken());
		
		for(int i=0; i<N; i++) {
			st=new StringTokenizer(br.readLine()," ");
			input[i][0]=Integer.parseInt(st.nextToken());//단
			input[i][1]=Integer.parseInt(st.nextToken());//지
			input[i][2]=Integer.parseInt(st.nextToken());//탄
			input[i][3]=Integer.parseInt(st.nextToken());//비타민
			input[i][4]=Integer.parseInt(st.nextToken());//가격
		}
		
		answer_list=new ArrayList<>();
		permutation(new boolean[N], 0);
		if(answer_list.size()==0) {
			System.out.println("-1");
			return;
		}
		System.out.println(MIN_MONEY);
		Collections.sort(answer_list);
		String ans=answer_list.get(0);
		for(int i=0; i<ans.length(); i++) {
			System.out.print(ans.charAt(i));
		}
		
		
	}
	static int MIN_MONEY=Integer.MAX_VALUE;
	static ArrayList<String> answer_list;
	private static void permutation(boolean[] visit, int k) {
		if(k==N) {
			
			int sumProtain=0;
			int sumFat=0;
			int sumCarbo=0;
			int sumVitamin=0;
			int sumMoney=0;
			
			for(int i=0; i<N; i++) {
				if(visit[i]) {
					sumProtain+=input[i][0];
					sumFat+=input[i][1];
					sumCarbo+=input[i][2];
					sumVitamin+=input[i][3];
					sumMoney+=input[i][4];
				}
			}
			
			
			if(sumProtain>=protain && sumFat>=fat && sumCarbo >= carbo && sumVitamin >= vitamin && MIN_MONEY>sumMoney) {
				answer_list.clear();
				MIN_MONEY=Math.min(MIN_MONEY, sumMoney);
				String str="";
				for(int i=0; i<N; i++) {
					if(visit[i]) {
						str+=(i+1+" ");
					}
				}
				answer_list.add(str);
			}
			
			if(sumProtain>=protain && sumFat>=fat && sumCarbo >= carbo && sumVitamin >= vitamin && MIN_MONEY==sumMoney) {
				String str="";
				for(int i=0; i<N; i++) {
					if(visit[i]) {
						str+=(i+1+" ");
					}
				}
				answer_list.add(str);
			}
			
			
			
			
			return;
		}
		
		
	
			visit[k]=true;
			permutation(visit,k+1);
			visit[k]=false;
			permutation(visit,k+1);
		
		
		
		
	}
}
