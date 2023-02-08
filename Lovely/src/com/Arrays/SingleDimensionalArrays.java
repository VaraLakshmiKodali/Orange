package com.Arrays;

public class SingleDimensionalArrays
{
	public static void main(String[] args)
	{
		int array1[]=new int[3];
		array1[0]=23;
		array1[1]=26;
		array1[2]=85;
		System.out.println(array1[0]);
		System.out.println(array1[1]);
		System.out.println(array1[2]);
		
		System.out.println("******* For Loop *******");
		for(int index=0;index<=3;index++)
		{
			System.out.println(index);
		}
		
		System.out.println(" ***********************");
		for(int index=0;index<array1.length;index++)
		{
			System.out.println(array1[index]);
		}
		String array2[]=new String[3];
		array2[0]="Lovely";
		array2[1]="Varam";
		array2[2]="Netha";
		System.out.println(array2[0]);
		System.out.println(array2[1]);
		System.out.println(array2[2]);
		
		System.out.println("******* For Each Loop *******");
		for(String index:array2)
		{
			System.out.println(index);
		}
	}
}
