package Programers.day_20220307;

public class 타켓넘버 {
	public static void main(String[] args) {
		int[] numbers= {4, 1, 2, 1};
		int target=4;
		solution(numbers, target);
	}
	
	
	static int answer = 0;
	public static int solution(int[] numbers, int target) {
        
        
        
        
        combination(new boolean[numbers.length],0,0, numbers,target);
        
        
        
        
        
        
        
        
        
        return answer;
    }



	private static void combination(boolean[] visit, int k, int idx,int[] numbers, int target) {
		if(k==visit.length) {
			int sum=0;
			for(int i=0; i<k; i++) {
				if(visit[i]) {
					sum+=numbers[i];
				}else {
					sum-=numbers[i];
				}
			}
			if(sum==target)answer++;
			
			
			return;
		}
		
		
		
		
		for(int i=idx; i<visit.length; i++) {
			visit[i]=true;
			combination(visit,k+1,i+1,numbers,target);
			visit[i]=false;
			combination(visit,k+1,i+1,numbers,target);
		}
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
}














