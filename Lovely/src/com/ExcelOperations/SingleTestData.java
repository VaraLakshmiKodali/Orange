package com.ExcelOperations;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class SingleTestData 
{
	public static void main(String[] args) throws IOException
	{
		FileInputStream File=new FileInputStream("./src/com/ExcelSheets/SingleTestDataFile.xlsx");
				
		XSSFWorkbook Workbook=new XSSFWorkbook(File);
		
		XSSFSheet Sheet=Workbook.getSheet("Sheet1");
		
		Row Row=Sheet.getRow(0);
		
		Cell RowOfCell=Row.getCell(0);
		
		String Data=RowOfCell.getStringCellValue();
		System.out.println(Data);
		Workbook.close();
		
	}
}
