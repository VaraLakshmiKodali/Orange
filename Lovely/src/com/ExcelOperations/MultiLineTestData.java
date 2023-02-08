package com.ExcelOperations;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class MultiLineTestData
{
	public static void main(String[] args) throws IOException
	{
		FileInputStream File=new FileInputStream("./src/com/ExcelSheets/MultiTestData.xlsx");
		
		XSSFWorkbook WorkBook=new XSSFWorkbook(File);
		
		XSSFSheet Sheet= WorkBook.getSheet("Sheet1");
		
		int RowsCount=Sheet.getLastRowNum();
			
		
		for(int RowIndex=0;RowIndex<=RowsCount;RowIndex++)
		{
			Row Row=Sheet.getRow(RowIndex);
			
						
			int RowOfCellsCount=Row.getLastCellNum();
			
						
			for(int RowOfCellsIndex=0;RowOfCellsIndex<RowOfCellsCount;RowOfCellsIndex++)
			{
				Cell RowOfCell=Row.getCell(RowOfCellsIndex);
				String Data=RowOfCell.getStringCellValue();
				
				System.out.print(Data+"  ");
				
			}
			System.out.println();
		}
		WorkBook.close();
	}
}
