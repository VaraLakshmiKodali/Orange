package com.DecisionMakingStatements;
public class IfElseIfExample 
{
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		int var1=10;
		int var2=50;
		int var3=30;
		if(var1>var2 && var1>var3)
		{
			System.out.println("Hello");
			System.out.println("The Value of the Variable Var1 is Greater Than the Variables var2 and var3");
		}
		else
			if(var2>var3)
			{
				System.out.println("Hello");
				System.out.println("The Value of the Variable var2 is Greater than the Variable var3 ");
			}
			else
			{
				System.out.println("Hello");
				System.out.println("The Value of the Variable var3 is Greater than the Variables var1 and var2");
			}
	}
}
