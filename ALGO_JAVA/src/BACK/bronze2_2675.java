package BACK;



//���ڿ� S�� �Է¹��� �Ŀ�, �� ���ڸ� R�� �ݺ��� �� ���ڿ� P�� ���� �� ����ϴ� ���α׷��� �ۼ��Ͻÿ�. 
//��, ù ��° ���ڸ� R�� �ݺ��ϰ�, �� ��° ���ڸ� R�� �ݺ��ϴ� ������ P�� ����� �ȴ�. S���� QR Code "alphanumeric" ���ڸ� ����ִ�.




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
			st=new StringTokenizer(br.readLine(), " ");//������ �������� ����
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
		
		//��½� byte�� �̿��ϸ� �� ȿ�����̴ٴ� ���۸�
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
