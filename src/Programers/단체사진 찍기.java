import java.util.*;
class Solution {
    static HashMap<Integer,Character> map;
    static int cnt;
    public int solution(int n, String[] data) {
        int answer = 0;
      //처음에 0번쨰에는 어피치 1번째에는 콘 ... 이런식으로 세운다.  
      map=new HashMap<>();
        map.put(0,'A');
        map.put(1,'C');
        map.put(2,'F');
        map.put(3,'J');
        map.put(4,'M');
        map.put(5,'N');
        map.put(6,'R');
        map.put(7,'T');
        
        cnt=0;
        //일렬로 세우는 경우이 수를 다 구한다.
        permutation(new HashMap<Character,Integer>() ,new boolean[8], 0,data);
        
        return cnt;
    }
    public static void permutation(HashMap order,boolean[] visit, int k,String[] data){
        if(k==8){
            // System.out.println(order.toString());
          //경우의 수 다 구했으면
            for(int i=0; i<data.length; i++){
                char m1=data[i].charAt(0);
                char c=data[i].charAt(3);
                char m2=data[i].charAt(2);
                int dist=data[i].charAt(4)-'0';
                dist=Math.abs(dist);
                if(c=='='){
                    if(Math.abs((int)order.get(m1)-(int)order.get(m2))!=dist+1){
                        return;
                    }
                }else if(c=='<'){
                    if(Math.abs((int)order.get(m1)-(int)order.get(m2))>=dist+1){
                        return;
                    }
                }
                else if(c=='>'){
                     if(Math.abs((int)order.get(m1)-(int)order.get(m2))<=dist+1){
                        return;
                    }
                }
            }      
            cnt++;
            
            return;
        }
        
        
        for(int i=0; i<8; i++){
            if(visit[i])continue;
          //k에 있는애가 i번째에 슨다.
            order.put(map.get(k),i);
            visit[i]=true;
            permutation(order,visit,k+1,data);
            visit[i]=false;
        }
        
        
        
    }
}
