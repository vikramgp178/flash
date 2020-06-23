package uiPageObjects;

import java.util.HashMap;
import java.util.TreeMap;

public class testprog {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="We have send you a text message with a code to your registered mobile number ending in 5329.\r\n" + 
				"\r\n" + 
				"You are paying CyberSource the amount of $1.01 using card ************<%=f_strCCNumPart%>.\r\n" + 
				"\r\n" + 
				"(OTP: 1234)";
		String SplitedString[]=s.split(": ");
		System.out.println(SplitedString[1].replaceAll("[^a-zA-Z0-9]", ""));
		
		String code="11 890";
		System.out.println("Old code :"+code+" new code is :"+code.replaceAll("\\s",""));
		
		
		 TreeMap<String, String> map1 = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
		 
	        map1.put("First", "A");
	        map1.put("Second", "B");
	        map1.put("Third", "C");
	         
	        //Same as map1
	        TreeMap<String, String> map2 = new TreeMap<>();
	 
	        map2.put("Third", "C");
	        map2.put("First", "A");
	        map2.put("Second", "B");
	         
	        //Different from map1
	        TreeMap<String, String> map3 = new TreeMap<>();
	 
	        map3.put("First", "a");
	        map3.put("Second", "B");
	        map3.put("Third", "C");
	        map3.put("Third", "D");
	         
	        System.out.println(map1.equals(map2));  //true
	        System.out.println(map1.equals(map3));  //false
	}

}
