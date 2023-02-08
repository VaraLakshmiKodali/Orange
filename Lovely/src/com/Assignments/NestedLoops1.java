package com.Assignments;
public class NestedLoops1 
{
	public static void main(String[] args) 
	{
		for(int i=10;i>5;i=i-2)
		{
			for(int k=20;k>i;k=k-4)
			{
				System.out.println("Lovely");
			}
		}

		System.out.println(" ******* ");
		for(int i=25;i>5;i=i-5)
		{
			for(int k=50;k>i;k=k-5)
			{
				System.out.println(i);
			}
		}
		
		System.out.println(" ****** ");
		for(int i=100;i>=50;i=i-10)
		{
			for(int k=110;k>i;k=k-10)
			{
				System.out.println(i);
			}
		}
		
		System.out.println(" ********** ");
		for(int i=100;i>50;i=i-20)
		{
			for(int k=110;k>i;k=k-10)
			{
				System.out.println(k);
			}
		}
		
		System.out.println(" ********** ");
		for(int i=100;i>50;i=i-10)
		{
			for(int k=110;k>i;k=k-10)
			{
				System.out.println(k+" ");
			}
			System.out.println( );
		}
		
		
		System.out.println(" ****** ");
		for(int i=100;i>50;i=i-10)
		{
			for(int k=110;k>i;k=k-10)
			{
			System.out.println(i);
			}
			System.out.println();
		}
		
		System.out.println(" ********* ");
		for(int i=100;i>50;i=i-10)
		{
			System.out.println();
			for(int k=110;k>i;k=k-10)
			{
				System.out.println(i);
			}
		}
		
		System.out.println(" \n********** ");
		for(int i=100;i>50;i=i-10)
		{
			System.out.println(i);
			for(int k=110;k>i;k=k-10)
			{
				System.out.println(k);
			}
		}
		System.out.println(" ********** ");
		for(int i=100;i>50;i=i-10)
		{
			System.out.println(i);
			for(int k=110;k>i;k=k-10)
			{
				System.out.println(k);
			}
		}
		System.out.println(" ********** ");
		for(int i=100;i>50;i=i-10)
		{
			System.out.println();
			for(int k=110;k>i;k=k-10)
			{
				System.out.print("*");
			}
		}
	}
}
