package BACK.day_20210203;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BACK_20055 {
   static Deque<Integer> arr;
   //static int location[];
   static int count;
   static int[] belt;
   static int[] location;
   static int N,K,result;
   public static void main(String[] args) throws IOException {
      // TODO Auto-generated method stub
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");
      N = Integer.parseInt(st.nextToken());// �����̾� ��Ʈ�� ����
      K = Integer.parseInt(st.nextToken());// ������ 0�� ĭ�� ����
      arr = new ArrayDeque<>();
      //location = new int[N];
      location = new int[N]; //�κ���ġ
      belt=new int[2*N]; //������
      st = new StringTokenizer(br.readLine(), " ");
      for (int i = 0; i < 2 * N; i++) {
         belt[i]=(Integer.parseInt(st.nextToken()));
      }
      
      while(true) {
         count=0;
         result++; //����
         move();
         moveRobot();
         input();
         for(int i=0; i<2*N; i++) {
            if(belt[i]==0)
               count++;
         }
         if(count>=K)
            break;
      }
      
      System.out.println(result);
      
   }
   private static void move() {
      
      int tmp1=belt[2*N-1];//������ ��
      for(int i=2*N-1; i>0; i--) {//�����̾� ��Ʈ �����̱�
         belt[i]=belt[i-1];
      }
      belt[0]=tmp1;
      
      int tmp2=location[N-1];
      for(int i=N-1; i>0; i--) {//�κ��� ��ġ�� ���� �����̱�
         location[i]=location[i-1];
      }
      location[0]=tmp2;
      
      
      if(location[N-1]==1) {//ȸ���ϰ� ���� �κ��� ������į�� ������ ��������
         location[N-1]=0;
      }
      
      
   }
   private static void moveRobot() {
      
      
      for(int i=N-2; i>=0; i--) {
         if(location[i]!=0) {
            int j=i;
            if(j+1<N &&belt[j+1]>0 && location[j+1]==0) {
               location[j]=0;
               location[j+1]=1;
               belt[j+1]--;
            }
//            while() {//�κ� �տ� �������� 1�̻��̰ų� �κ��� ������
//               location[j]=0;
//               location[j+1]=1;
//               belt[j+1]--;
//               j++;
//            }
            if(location[N-1]==1) {//�κ��� �������� ������ ������
            location[N-1]=0;
         }
            
         }
         
      }
      
      
      
   }
   private static void input() {
      
      if(location[0]==0&& belt[0]>0) {
         location[0]=1;
         belt[0]--;
      }
      
   }

}