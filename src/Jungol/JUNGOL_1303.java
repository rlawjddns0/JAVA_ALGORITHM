package Jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JUNGOL_1303 {

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		int n=1;
		for(int i=1; i<=N ;i++) {
			for(int j=1; j<=M; j++) {
				System.out.print((n++)+" ");
			}
			System.out.println();
		}
	}

}
