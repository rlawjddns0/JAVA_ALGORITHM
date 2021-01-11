package BACK;



//문자열 S를 입력받은 후에, 각 문자를 R번 반복해 새 문자열 P를 만든 후 출력하는 프로그램을 작성하시오. 
//즉, 첫 번째 문자를 R번 반복하고, 두 번째 문자를 R번 반복하는 식으로 P를 만들면 된다. S에는 QR Code "alphanumeric" 문자만 들어있다.




import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class bronze2_2675 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb=new StringBuffer();
		StringTokenizer st;
		
		int testCase=Integer.parseInt(br.readLine());
		
		while(testCase!=0) {
			st=new StringTokenizer(br.readLine(), " ");//공백을 기준으로 읽음
			int k=Integer.parseInt(st.nextToken());
			String s=st.nextToken();
			for(int i=0; i<s.length(); i++) {
				for(int j=0; j<k; j++) {
					sb.append(s.charAt(i));
				}
			}
			sb.append("\n");
			
			
			testCase--;
			
		}
		System.out.println(sb);
		
		//출력시 byte를 이용하면 더 효율적이다는 구글링
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringBuilder sb = new StringBuilder();
//        
//		int T = Integer.parseInt(br.readLine());        
// 
//		for (int i = 0; i < T; i++) {
// 
//			String[] str = br.readLine().split(" ");
// 
//			int R = Integer.parseInt(str[0]);
// 
//			for (byte val : str[1].getBytes()) {
//				for (int j = 0; j < R; j++) {
//					sb.append((char)val);
//				}
//			}
//			sb.append('\n');
//		}
//		System.out.print(sb);
//	}
		
		
		
		
		
	}

}
