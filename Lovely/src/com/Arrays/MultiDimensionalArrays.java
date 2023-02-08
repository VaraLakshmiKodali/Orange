package com.Arrays;

public class MultiDimensionalArrays 
{
	public static void main(String[] args) 
	{
		String array1[][]=new String[2][2];
		array1[0][0]="Venkat Sir";
		array1[0][1]="Manual Testing";
		array1[1][0]="Srini Sir";
		array1[1][1]="Selenium";
		System.out.println(array1[0][0]);
		System.out.println(array1[0][1]);
		System.out.println(array1[1][0]);
		System.out.println(array1[1][1]);
		
		System.out.println("***** Nested Loops *****");
		for(int RowIndex=0;RowIndex<array1.length;RowIndex++)
		{
			for(int RowOfCell=0;RowOfCell<array1.length;RowOfCell++)
			{
				System.out.print(array1[RowIndex][RowOfCell]+" ");
			}
			System.out.println();
		}
			
	}
}
