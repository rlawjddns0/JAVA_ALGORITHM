package BAEK.month_202108.day_20210822;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class BAEK_4358 {

	static Comparator<String> comparator = (s1, s2) -> s1.compareTo(s2);
	static Map<String, Integer> map = new TreeMap<>(comparator);
	static HashSet<String> set = new HashSet<>();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		int i=0;
		while (scanner.hasNextLine()) {
			String str = scanner.nextLine();
			set.add(str);
			if(map.get(str)!=null) {
				map.put(str, map.get(str) + 1);
			}else {
				map.put(str, 1);
			}
			i++;
			
		}
		
		for( Map.Entry<String, Integer> elem : map.entrySet() ){
			System.out.println( String.format("%s %.4f", elem.getKey(), (float)(((float)elem.getValue()/(float)i*100.0))) );
		}

		
		
		
		
		
		

	}

}
