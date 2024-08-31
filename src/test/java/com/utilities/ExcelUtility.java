package com.utilities;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	
	public FileInputStream fileInputStream;
	public FileOutputStream fileOutputStream;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	public CellStyle style;
	String path;
	
	public ExcelUtility(String path) 
	{
		this.path=path;
	}
	
	public int getRowCount(String sheetName) throws IOException 
	{
		fileInputStream = new FileInputStream(path);
		workbook = new XSSFWorkbook(fileInputStream);
		sheet = workbook.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum();
		workbook.close();
		fileInputStream.close();
		return rowCount;
	}
	
	public int getCellCount(String sheetName, int rowNumber) throws IOException
	{
		fileInputStream = new FileInputStream(path);
		workbook = new XSSFWorkbook(fileInputStream);
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(rowNumber);
		int cellCount = row.getLastCellNum();
		workbook.close();
		fileInputStream.close();
		return cellCount;
	}
	
	
	public String getCellData(String sheetName, int rowNumber, int colNumber) throws IOException
	{
		fileInputStream = new FileInputStream(path);
		workbook = new XSSFWorkbook(fileInputStream);
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(rowNumber);
		cell = row.getCell(colNumber);
		
		DataFormatter formatter = new DataFormatter();
		String data;
		try 
		{
			data = formatter.formatCellValue(cell); //Returns the formatted value of a cell as a String regard less of the cell type.
		}
		catch(Exception e) 
		{
			data="";
		}
		workbook.close();
		fileInputStream.close();
		return data;
	}
	
	public void setCellData(String sheetName, int rowNumber, int colNumber, String data) throws IOException
	{
		File xlFile = new File(path);
		
		if(!xlFile.exists())		// If File not exits then create new file.
		{
			workbook = new XSSFWorkbook();
			fileOutputStream = new FileOutputStream(path);
			workbook.write(fileOutputStream);
		}
		
		fileInputStream = new FileInputStream(path);
		workbook = new XSSFWorkbook(fileInputStream);
		
		if(workbook.getSheetIndex(sheetName) == -1)		// If sheet not exists then create new sheet.
			workbook.createSheet(sheetName);
		sheet = workbook.getSheet(sheetName);
		
		if(sheet.getRow(rowNumber) == null)		// It row not exist then create new row.
			sheet.createRow(rowNumber);
		row = sheet.getRow(rowNumber);
		
		cell = row.createCell(colNumber);
		cell.setCellValue(data);
		fileOutputStream = new FileOutputStream(path);
		workbook.write(fileOutputStream);
		workbook.close();
		fileInputStream.close();
		fileOutputStream.close();
	}
	
	public void fillGreenColor(String sheetName, int rowNumber, int colNumber) throws IOException
	{
		fileInputStream = new FileInputStream(path);
		workbook = new XSSFWorkbook(fileInputStream);
		sheet = workbook.getSheet(sheetName);
		
		row = sheet.getRow(rowNumber);
		cell = row.getCell(colNumber);
		
		style = workbook.createCellStyle();
		
		style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		cell.setCellStyle(style);
		workbook.write(fileOutputStream);
		workbook.close();
		fileInputStream.close();
		fileOutputStream.close();
	}
	
	public void fillRedColor(String sheetName, int rowNumber, int colNumber) throws IOException
	{
		fileInputStream = new FileInputStream(path);
		workbook = new XSSFWorkbook(fileInputStream);
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(rowNumber);
		cell = row.getCell(colNumber);
		
		style = workbook.createCellStyle();
		
		style.setFillForegroundColor(IndexedColors.RED.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		cell.setCellStyle(style);
		workbook.write(fileOutputStream);
		workbook.close();
		fileInputStream.close();
		fileOutputStream.close();
	}

}
