package com.ExcelOperations;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteTestData
{
	public static void main(String[] args) throws IOException
	{
		FileInputStream File=new FileInputStream("./src/com/ExcelSheets/SingleTestDataFile.xlsx");
												
		
		XSSFWorkbook WorkBook=new XSSFWorkbook(File);
		
		XSSFSheet Sheet=WorkBook.getSheet("Sheet1");
		
		//Row Row=Sheet.getRow(0);
		//Cell RowOfCells=Row.getCell(0);
		//System.out.println(RowOfCells);
		System.out.println(Sheet.getLastRowNum());
		Row Rows=Sheet.createRow(3);
		
		Cell RowOfCell= Rows.createCell(3);
		
		RowOfCell.setCellValue("Hello");
		
		FileOutputStream File1=new FileOutputStream("./src/com/ExcelSheets/SingleTestDataFile.xlsx");
		WorkBook.write(File1);
		
		WorkBook.close();
	}
}
