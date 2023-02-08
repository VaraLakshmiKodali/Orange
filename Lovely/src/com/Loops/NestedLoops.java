package com.Loops;
public class NestedLoops
{
	public static void main(String[] args) 
	{
		for(int i=1;i<=5;i++)
		{
			for(int k=0;k<i;k++)
			{
				System.out.println("Live Tech");
			}
		}
		
		
		System.out.println("\n ******* ");
		for(int i=1;i<=5;i++)
		{
			for(int k=0;k<i;k++)
			{
				System.out.println(i);
			}
		}
		
		
		System.out.println("\n ****** ");
		for(int i=1;i<=5;i++)
		{
			for(int k=0;k<i;k++)
			{
				System.out.println(k);
			}
		}
		
		
		System.out.println("\n ********** ");
		for(int i=1;i<=5;i++)
		{
			for(int k=0;k<i;k++)
			{
				System.out.print(k);
			}
			System.out.println(i);
		}
		
		
		System.out.println("\n ****** ");
		for(int i=1;i<=5;i++)
		{
			for(int k=0;k<i;k++)
			{
			System.out.print(i);
			}
			System.out.println();
		}
	
		
		System.out.println(" ********* ");
		for(int i=1;i<=5;i++)
		{
			System.out.println();
			for(int k=0;k<i;k++)
			{
				System.out.println(i);
			}
		}
		
		
		System.out.println(" ********** ");
		for(int i=1;i<=5;i++)
		{
			System.out.println();
			for(int k=0;k<i;k++)
			{
				System.out.print(k);
			}
		}
		
			
		System.out.println(" ********** ");
		for(int i=1;i<=5;i++)
		{
			System.out.println(i);
			for(int k=0;k<i;k++)
			{
				System.out.print(k);
			}
		}

		
		System.out.println(" ********** ");
		for(int i=1;i<=5;i++)
		{
			System.out.println();
			for(int k=0;k<i;k++)
			{
				System.out.print("*");
			}
		}
	}
}

