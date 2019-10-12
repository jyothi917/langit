package com.facebook.generic.lib;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Filelib {
	
		public String getExcelData(String excelpath,String sheet,int r, int c ) throws Throwable
		{
			FileInputStream file1 = new FileInputStream(excelpath);
			Workbook wb=WorkbookFactory.create(file1);
			String cellValue=wb.getSheet(sheet).getRow(r).getCell(c).toString();
			
			
			return cellValue;

		}
		public int getRowCount(String excelpath,String sheet) throws Throwable
		{
			FileInputStream fis=new FileInputStream(excelpath);
			Workbook wb=WorkbookFactory.create(fis);
			int rowcount=wb.getSheet(sheet).getLastRowNum();
			return rowcount;
			
		}
		
		public void setExcelData(String excelpath,String sheet,int r, int c,String data ) throws Throwable
		{
			FileInputStream file1 = new FileInputStream(excelpath);
			Workbook wb=WorkbookFactory.create(file1);
			wb.getSheet(sheet).getRow(r).createCell(c).setCellValue(data);
			
			FileOutputStream fos=new FileOutputStream(excelpath);
			wb.write(fos);
			wb.close();
			
		}
		
		public String getPropertyKeyValue(String proppath,String key) throws Throwable
		{
			FileInputStream fis=new FileInputStream(proppath);
			Properties prop=new Properties();
			prop.load(fis);
			return prop.getProperty(key,"Incorrect key");
			
		}
}
