package com.DecisionMakingStatements;
public class NestedIf
{
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		int var1=20;
		int var2=30;
		int var3=20;
		if(var1<var2)
		{
			System.out.println("The Value of the string var1 is Less than the value of the Variable var2");
			if(var1==var3)
			{
				System.out.println("Both the Values of the Variables var1 and var3 are same");
			}
			System.out.println("****");
		}
		System.out.println("####");
	}
}
