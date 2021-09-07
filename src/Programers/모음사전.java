import java.util.*;
class Solution {
    static int cnt;
    static int ans;
    static boolean check;
    static char[] alpha={'A','E','I','O','U'};
    static ArrayList<String> list=new ArrayList<>();
    static StringBuffer sb=new StringBuffer();
    public int solution(String word) {
        int answer = 0;
        cnt=0;
        
        
        for(int i=1; i<=5; i++){
            permutation(new int[i], 0,word,i);
        }
        
        Collections.sort(list);
        
        for(int i=0; i<cnt; i++){
            if(list.get(i).equals(word)){
                answer=i+1;
                break;
            }
        }
        
        
        return answer;
    }
    public static void permutation(int[] sel, int k, String word,int end){
        if(k==end){
            sb.setLength(0);
            for(int i=0; i<end; i++){
                sb.append(alpha[sel[i]]);
            }
            list.add(sb.toString());
            
            return;
        }
        
        for(int i=0; i<5; i++){
            sel[k]=i;
            cnt++;
            permutation(sel,k+1,word,end);
        }
    }
}
