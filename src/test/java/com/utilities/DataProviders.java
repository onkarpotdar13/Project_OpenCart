package com.utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	// Data provider 1
	
	@DataProvider(name = "LoginData")	// all methods invoked from ExcelUtility class.
	public String [][] getData() throws IOException
	{
		String path = ".\\testData\\OpenCart_Project.xlsx"; // take excel file form testData folder.
		
		ExcelUtility excelUtility = new ExcelUtility(path);		// create an object for excel utility
		
		int totalRows = excelUtility.getRowCount("Sheet1");
		int totalCols = excelUtility.getCellCount("Sheet1",1);
		
		String logindata[][] = new String[totalRows][totalCols]; // create two dimensional string array which can be store 
		
		for(int i = 1; i<=totalRows; i++)	// read data form excel storing in two dimensional array.
		{
			for(int j = 0; j<totalCols; j++)	// i is rows and j is col
			{
				logindata[i-1][j] = excelUtility.getCellData("Sheet1", i, j); // 
			}
		}	
		return logindata;  // return two dimensional array.
	}

}
