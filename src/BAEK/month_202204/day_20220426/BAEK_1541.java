package BAEK.month_202204.day_20220426;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class BAEK_1541 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		input = "+" + input;
		StringBuffer sb = new StringBuffer(input);
		int numA = 0;
		int numB = 0;
		for (int i = 0; i < sb.length(); i++) {
			if (sb.charAt(i) == '-') {
				for (int j = i + 1; j < sb.length(); j++) {
					if (sb.charAt(j) == '+') {
						sb.replace(j, j + 1, "-");
					}

					if (sb.charAt(j) == '-') {
						i = j - 1;
						break;
					}

				}
			}
		}
		
		System.out.println(sb.toString());

		for (int i = 0; i < sb.length(); i++) {
			if (sb.charAt(i) == '+') {
				int j = i;
				for (j = i + 1; j < sb.length(); j++) {
					if (sb.charAt(j) == '+' || sb.charAt(j) == '-') {

						break;
					}
				}
				int k = 0;
				if (sb.substring(i + 1, j).charAt(0) == '0') {
					String tmp = sb.substring(i + 1, j);
					for (k = 0; k < tmp.length(); k++) {

						if (tmp.charAt(k) != '0') {
							numA += Integer.parseInt(tmp.substring(k, tmp.length()));
							break;
						}
					}
				} else {
					numA += Integer.parseInt(sb.substring(i + 1, j));
					i = j - 1;
				}
			}

			if (sb.charAt(i) == '-') {
				int j = i;
				for (j = i + 1; j < sb.length(); j++) {
					if (sb.charAt(j) == '+' || sb.charAt(j) == '-') {

						break;
					}
				}
				int k = 0;
				if (sb.substring(i + 1, j).charAt(0) == '0') {
					String tmp = sb.substring(i + 1, j);
					for (k = 0; k < tmp.length(); k++) {

						if (tmp.charAt(k) != '0') {
							numB -= Integer.parseInt(tmp.substring(k, tmp.length()));
							break;
						}
					}
				} else {
					numB -= Integer.parseInt(sb.substring(i + 1, j));
					i = j - 1;
				}
			}
		}

		System.out.println(numA + numB);

	}
}
