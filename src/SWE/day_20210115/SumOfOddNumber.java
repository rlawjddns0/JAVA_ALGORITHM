package SWE.day_20210115;

import java.util.Scanner;
import java.io.FileInputStream;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
public class SumOfOddNumber
{
    public static void main(String args[]) throws Exception
    {
        int testCase;
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        testCase=Integer.parseInt(br.readLine());//test case 받기
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