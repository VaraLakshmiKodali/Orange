package com.Arrays;

import java.util.List;
public class ArrayList 
{
	public static void main(String[] args) 
	{
		List<Object>arrayList1=new java.util.ArrayList<Object>();
		arrayList1.add(10);
		arrayList1.add("Testing");
		arrayList1.add("V");
		arrayList1.add(10.425);
		for(int Index=0;Index<=arrayList1.size();Index++)
		{
			
			System.out.println(arrayList1.get(Index));
						
		}
		
		for(Object Index: arrayList1)
		{
			System.out.println(Index);
		}
		
	}
}








