package BAEK.month_202103.day_20210319;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;
/*
 * 문자열 폭팔
 * 접근:
 * 일단 result배열에 집어넣고 만약 폭팔 문자열 마지막 문자와 같은 문자가 들어오면 다시 거꾸로 가면서 폭팔 문자열이 맞는지 아닌지 확인
 * 맞으면 result배열에 마지막 인덱스인 idx값을 폭팔 문자열의 길이만큼 빼줌
 * 아니면 계속 진행
 * ->값을 삭제하고 붙이고 과정이 없고 그냥 위에 덮어버리는 형식이라 속도가 빠름
 * 마지막에 for문으로 idx값까지 출력하는식으로 하면 바로 시간초과 ;;;;;
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
			 * 만약 for문으로 idx값
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
