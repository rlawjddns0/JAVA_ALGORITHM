package Programers.day_20210310;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class 카카오_수식최대화 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		long ans;

		ans = solution(str);
		System.out.println(ans);
	}

	static int[] op = new int[3];// 0:+ , 1:*, 2:-
	static char[] ch = { '+', '*', '-' };
	static ArrayList<String> st;
	static int op_cnt;
	static ArrayList<String> tmp_st;
	public static long solution(String expression) {
		long answer = 0;
		st = new ArrayList<String>();//숫자와 연산자 담을 리스트
		tmp_st=new ArrayList<String>();//복사할때 필요한 임시 리스트
		char[] tmp = expression.toCharArray();//문자열로 바꾸고
		StringBuffer sb_num = new StringBuffer();// 숫자와 연산자 나누기위해서
		for (int i = 0; i < tmp.length; i++) {
			if (tmp[i] >= '0' && tmp[i] <= '9') {// 숫자만 담는다
				sb_num.append(tmp[i]);
			} else if (tmp[i] == '+' || tmp[i] == '*' || tmp[i] == '-') {// 연산자가 나오면
				st.add(sb_num.toString());//앞에 담았더 숫자 스트링으로 바꿔서 리스트에 저장
				tmp_st.add(sb_num.toString());//임시 배열에도 저장
				sb_num.setLength(0);//숫자 버퍼 비워주고
				//나중에 + - * 로 순열 만들기 위해서 카운트 헤줌
				if (tmp[i] == '+')
					op[0]++;
				if (tmp[i] == '*')
					op[1]++;
				if (tmp[i] == '-')
					op[2]++;
				st.add(Character.toString(tmp[i]));//마지막으로 연산자 리스트에 저장
				tmp_st.add(Character.toString(tmp[i]));//임시 배열에도 똑같이 저장
			}
		}
		if (sb_num.length() != 0) {//마지막에 숫자 남으니까 
			st.add(sb_num.toString());//리스트에 저장
			tmp_st.add(sb_num.toString());
		}
		//연산자 확인 해서 순열 생성
		if (op[0] > 0)
			op_cnt++;
		if (op[1] > 0)
			op_cnt++;
		if (op[2] > 0)
			op_cnt++;
		dfs(new int[op_cnt], 0, visit);
		answer=ans;
		return answer;
	}

	static boolean[] visit = new boolean[3];
	static long ans;
	private static void dfs(int[] sel, int k, boolean[] visit) {

		if (k == op_cnt) {
			
			System.out.println(st.toString());
			for(int i=0; i<sel.length; i++) {
				char tp=ch[sel[i]];//연산자 하나 꺼내서
				for(int j=0; j<st.size(); j++) {
					if(st.get(j).equals(Character.toString(tp))) {//지금 제일 우선 순위 연산자랑 비교해서 맞으면
						String first=st.get(j-1);//연산자 인덱스 기준 앞에꺼는 숫자니께
						String op=st.get(j);//지금 인덱스는 연산자
						String last=st.get(j+1);//다음 인덱스는 숫자
						String sum;
						if(op.equals("+")) {//연산자가 더하기면
							sum=Long.toString(Long.parseLong(first)+Long.parseLong(last));//더해주고
							//리스트라서 인덱스를 지울때 잘 생각하고 지워야함 
							st.remove(j--);
							st.remove(j--);
							st.set(j+1, sum);//해보니까 이렇게 해야 맞는 자리에 들어감

						}
						else if(op.equals("*")) {
						
							sum=Long.toString(Long.parseLong(first)*Long.parseLong(last));
							st.remove(j--);
							st.remove(j--);
							st.set(j+1, sum);
						}
						else {
							sum=Long.toString(Long.parseLong(first)-Long.parseLong(last));
							st.remove(j--);
							st.remove(j--);
							st.set(j+1, sum);
						}
					}
				}
				System.out.println(st.toString());

			}
			
			ans=Math.max(ans, Math.abs(Long.parseLong(st.get(0))));//마지막에 남은 리스트가 곧 연산 결과
			st.clear();//리스트 비워주고
			st.addAll(tmp_st);//다시 복사
			return;
		}

		for (int i = 0; i < 3; i++) {
			if (op[i] == 0) {
				visit[i] = true;
				continue;
			} else {
				if (!visit[i]) {
					sel[k] = i;
					visit[i] = true;
					dfs(sel, k + 1, visit);
					visit[i] = false;
					
				}
			}
		}

	}

}
