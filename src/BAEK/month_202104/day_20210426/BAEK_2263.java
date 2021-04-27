package BAEK.month_202104.day_20210426;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BAEK_2263 {
	static int n;
	static int[] arr;
	static int[] inorder;
	static int[] postorder;
	static int in,po,t;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		n=Integer.parseInt(br.readLine());
		arr=new int[n+1];
		inorder=new int[n+1];
		postorder=new int[n+1];
		in=0;
		po=0;
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		for(int i=1; i<=n; i++) {
			inorder[i]=Integer.parseInt(st.nextToken());
		}
		st=new StringTokenizer(br.readLine()," ");
		for(int j=1; j<=n; j++) {
			postorder[j]=Integer.parseInt(st.nextToken());
		}
		for(int i=1; i<=n; i++) {
			arr[inorder[i]]=i;
		}
		getPreorder(1,n,1,n);
		
		
	}
	private static void getPreorder(int inS, int inE, int poS, int poE) {
		if(inS>inE || poS>poE) {
			return;
		}
		
		System.out.print(postorder[poE]+" ");
		
		int middle=arr[postorder[poE]];
		int left=middle-inS;
		getPreorder(inS, middle-1, poS, poS+left-1);
		getPreorder(middle+1, inE, poS+left, poE-1);	
		
	}
	

}
