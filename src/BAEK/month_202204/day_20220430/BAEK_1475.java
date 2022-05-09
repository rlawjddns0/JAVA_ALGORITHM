package BAEK.month_202204.day_20220430;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BAEK_1475 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int[] visit = new int[10];

		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			if (c == '6') {
				if (visit[6] != 0) {
					if (visit[9] != 0 && visit[6]<=visit[9]) {
						visit[6]++;
					} else if (visit[9] == 0) {
						visit[9]++;
					}else if(visit[9]!=0 && visit[6]>=visit[9]) {
						visit[9]++;
					}
				} else if (visit[6] == 0) {
					visit[6]++;
				}

			} else if (c == '9') {
				if (visit[9] != 0) {
					if (visit[6] != 0 && visit[6]>=visit[9]) {
						visit[9]++;
					} else if (visit[6] == 0) {
						visit[6]++;
					}else if(visit[6]!=0 && visit[6]<=visit[9]) {
						visit[6]++;
					}
				} else if (visit[9] == 0) {
					visit[9]++;
				}

			} else {
				visit[c - '0']++;
			}

		}
//		System.out.println(Arrays.toString(visit));
		Arrays.sort(visit);
		
		System.out.println(visit[9]);
		
		
		
		
	}
}
