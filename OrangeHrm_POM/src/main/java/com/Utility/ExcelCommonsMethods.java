package com.Utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelCommonsMethods 
{
	
	String fileInputPath,fileOutputPath,sheetName;
	XSSFWorkbook workBook;
	XSSFSheet sheet;
	Row row;
	Cell rowOfCell;
	

	public ExcelCommonsMethods(String fileInputPath,String fileOutputPath, String sheetName) throws IOException
	{
		
		this.fileInputPath=fileInputPath;
		this.fileOutputPath=fileOutputPath;
		this.sheetName=sheetName;
		
		FileInputStream file=new FileInputStream(fileInputPath);
		workBook=new XSSFWorkbook(file);
		
	}
	
	public String getCellValue(int rowIndex, int cellIndex)
	{
		
		sheet=workBook.getSheet(sheetName);
		row=sheet.getRow(rowIndex);
		
		Cell rowOfCell=row.getCell(cellIndex);
		return rowOfCell.getStringCellValue();

	}
	
	public void setCellValue(int rowIndex, int cellIndex, String data) throws IOException
	{

		sheet=workBook.getSheet(sheetName);
		row=sheet.getRow(rowIndex);
		rowOfCell=row.createCell(cellIndex);
		rowOfCell.setCellValue(data);
	
	}
	
	public void saveExcelData() throws IOException
	{

		FileOutputStream OutputStreamTestResultFile=new FileOutputStream(fileOutputPath);
		workBook.write(OutputStreamTestResultFile);

	}

}
