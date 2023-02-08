package com.JumpStatements;
public class BreakAndContinue 
{
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		for(int i=1;i<=5;i++)
		{
			if(i==3)
			{
				System.out.println("Lovely");
			}
		}
		System.out.println(" **** Break Keyword ****");
		for(int i=1;i<=5;i++)
		{
			if(i==3)
			{
				break;
			}
			System.out.println(i+"Vara");
		}
		
		
		System.out.println(" **** Continue Keyword ****");
		for(int i=1;i<=5;i++)
		{
			if(i==3)
			{
				continue;
			}
			System.out.println(i+"Lovely");
		}
	}
}
