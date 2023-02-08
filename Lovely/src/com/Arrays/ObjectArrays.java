package com.Arrays;

public class ObjectArrays 
{
	public static void main(String[] args) 
	{
	
		Object array1[]=new Object[4];
		array1[0]="Lovely";
		array1[1]='V';
		array1[2]=10;
		array1[3]=10.2355;
		System.out.println(" ***** For Loop *****");
		for(int index=0;index<array1.length;index++)
		{
			System.out.println(array1[index]);
		}
		System.out.println(" ***** For Each Loop *****");
		for(Object index : array1)
		{
			System.out.println(index);
		}
		
	}
}
