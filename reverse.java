package string;

import java.util.ArrayList;
import java.util.Collections;
public class reverse 
{
	public static void main(String[] args) {
		
		int mul;
		ArrayList arr=new ArrayList();
		for(int i=1;i<=10;i++)
		{
			mul=2*i;
			arr.add(mul);
		}
		System.out.println(arr);
		
		Collections.reverse(arr);
		System.out.println(arr);		
}
}
