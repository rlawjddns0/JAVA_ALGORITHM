package SWE.day_20210115;

import java.util.Scanner;
import java.io.FileInputStream;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
/*
   ����ϴ� Ŭ�������� Solution �̾�� �ϹǷ�, ������ Solution.java �� ����� ���� �����մϴ�.
   �̷��� ��Ȳ������ �����ϰ� java Solution ������� ���α׷��� �����غ� �� �ֽ��ϴ�.
 */
public class SumOfOddNumber
{
    public static void main(String args[]) throws Exception
    {
        int testCase;
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        testCase=Integer.parseInt(br.readLine());//test case �ޱ�
        String arr[]=new String[testCase];
        StringTokenizer st;
        StringBuffer sb=new StringBuffer();
        for(int i=0; i<testCase; i++) {
            st=new StringTokenizer(br.readLine()," ");
            int sum=0;
            for(int j=0; j<10; j++) {
                int num=Integer.parseInt(st.nextToken());
                if(num%2!=0) {
                    sum+=num;
                }
            }
            sb.append("#").append(i+1).append(" ").append(sum).append("\n");
             
        }
         
        System.out.println(sb);
         
         
         
    }
}