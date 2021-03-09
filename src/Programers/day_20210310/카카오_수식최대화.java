package Programers.day_20210310;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class īī��_�����ִ�ȭ {

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
		st = new ArrayList<String>();//���ڿ� ������ ���� ����Ʈ
		tmp_st=new ArrayList<String>();//�����Ҷ� �ʿ��� �ӽ� ����Ʈ
		char[] tmp = expression.toCharArray();//���ڿ��� �ٲٰ�
		StringBuffer sb_num = new StringBuffer();// ���ڿ� ������ ���������ؼ�
		for (int i = 0; i < tmp.length; i++) {
			if (tmp[i] >= '0' && tmp[i] <= '9') {// ���ڸ� ��´�
				sb_num.append(tmp[i]);
			} else if (tmp[i] == '+' || tmp[i] == '*' || tmp[i] == '-') {// �����ڰ� ������
				st.add(sb_num.toString());//�տ� ��Ҵ� ���� ��Ʈ������ �ٲ㼭 ����Ʈ�� ����
				tmp_st.add(sb_num.toString());//�ӽ� �迭���� ����
				sb_num.setLength(0);//���� ���� ����ְ�
				//���߿� + - * �� ���� ����� ���ؼ� ī��Ʈ ����
				if (tmp[i] == '+')
					op[0]++;
				if (tmp[i] == '*')
					op[1]++;
				if (tmp[i] == '-')
					op[2]++;
				st.add(Character.toString(tmp[i]));//���������� ������ ����Ʈ�� ����
				tmp_st.add(Character.toString(tmp[i]));//�ӽ� �迭���� �Ȱ��� ����
			}
		}
		if (sb_num.length() != 0) {//�������� ���� �����ϱ� 
			st.add(sb_num.toString());//����Ʈ�� ����
			tmp_st.add(sb_num.toString());
		}
		//������ Ȯ�� �ؼ� ���� ����
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
				char tp=ch[sel[i]];//������ �ϳ� ������
				for(int j=0; j<st.size(); j++) {
					if(st.get(j).equals(Character.toString(tp))) {//���� ���� �켱 ���� �����ڶ� ���ؼ� ������
						String first=st.get(j-1);//������ �ε��� ���� �տ����� ���ڴϲ�
						String op=st.get(j);//���� �ε����� ������
						String last=st.get(j+1);//���� �ε����� ����
						String sum;
						if(op.equals("+")) {//�����ڰ� ���ϱ��
							sum=Long.toString(Long.parseLong(first)+Long.parseLong(last));//�����ְ�
							//����Ʈ�� �ε����� ���ﶧ �� �����ϰ� �������� 
							st.remove(j--);
							st.remove(j--);
							st.set(j+1, sum);//�غ��ϱ� �̷��� �ؾ� �´� �ڸ��� ��

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
			
			ans=Math.max(ans, Math.abs(Long.parseLong(st.get(0))));//�������� ���� ����Ʈ�� �� ���� ���
			st.clear();//����Ʈ ����ְ�
			st.addAll(tmp_st);//�ٽ� ����
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
