package BAEK.month_202103.day_20210319;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;
/*
 * ���ڿ� ����
 * ����:
 * �ϴ� result�迭�� ����ְ� ���� ���� ���ڿ� ������ ���ڿ� ���� ���ڰ� ������ �ٽ� �Ųٷ� ���鼭 ���� ���ڿ��� �´��� �ƴ��� Ȯ��
 * ������ result�迭�� ������ �ε����� idx���� ���� ���ڿ��� ���̸�ŭ ����
 * �ƴϸ� ��� ����
 * ->���� �����ϰ� ���̰� ������ ���� �׳� ���� ��������� �����̶� �ӵ��� ����
 * �������� for������ idx������ ����ϴ½����� �ϸ� �ٷ� �ð��ʰ� ;;;;;
 */
public class BAEK_9935 {
	static char[] result;
	static int idx;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// Scanner sc = new Scanner(System.in);
		// StringBuffer sb=new StringBuffer();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		result = new char[str.length()];
		// Stack<Character> stack = new Stack<>();

		String bomb = br.readLine();
		int Bsize = bomb.length();
		int Ssize = str.length();
		idx = 0;
		for (int i = 0; i < Ssize; i++) {

			result[idx] = str.charAt(i);
			if (isBomb(result, idx, bomb)) {
				idx -= Bsize;
			}
			idx++;
		}
		if (idx <= 0) {
			System.out.println("FRULA");
		} else {
			/*
			 * ���� for������ idx��
			 */
			System.out.println(String.valueOf(result,0,idx));//
		}

	}

	private static boolean isBomb(char[] result, int idx, String bomb) {
		if (idx < bomb.length() - 1)
			return false;
		for (int i = 0; i < bomb.length(); i++) {
			if (bomb.charAt(i) != result[idx - bomb.length() + 1 + i])
				return false;
		}
		return true;

	}

}
