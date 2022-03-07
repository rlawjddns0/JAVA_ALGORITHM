package Programers.day_20220307;

public class 입국심사 {
	public static void main(String[] args) {
		int n=3;
		int[] times= {1, 99, 99};
		System.out.println(solution(n,times));
	}
	
	public static long solution(int n, int[] times) {
        long answer = Integer.MAX_VALUE;
        
        long left=0;
        long right=98765432100L;
        long middle=0;
        
        
        
        while(left<=right) {
        	middle=(left+right)/2;
        	long sum=0;
//        	System.out.println("left: "+left+" "+"right: "+right+" "+"middle:"+middle);
        	
        	for(int i=0; i<times.length; i++) {
        		sum+=middle/times[i];
        	}
        	
        	if(sum>n) {
        		right=middle-1;
        	}else if(sum<n){
        		
        		left=middle+1;
        	}else if(sum==n) {
        		answer=Math.min(answer, middle);
        		right=middle-1;
        	}
        	
        }
        
        
        
        
        return answer;
    }
}
