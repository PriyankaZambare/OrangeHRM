package Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.*;

public class XLUtiles {
	
	
	public static FileInputStream fis;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	
	public static int rowcount (String xlfile,String xlsheet) throws IOException
	{
		fis=new FileInputStream(xlfile);
		workbook=new XSSFWorkbook(fis);
		sheet=workbook.getSheet(xlsheet);
		int rowcount=sheet.getLastRowNum();
		workbook.close();
		fis.close();
		return rowcount;
		
	}
	
	public static int colcount (String xlfile,String xlsheet,int rownum ) throws IOException
	{
		fis=new FileInputStream(xlfile);
		workbook=new XSSFWorkbook(fis);
		sheet=workbook.getSheet(xlsheet);
		row=sheet.getRow(rownum);
		int colCount=row.getLastCellNum();
		workbook.close();
		fis.close();
		return colCount;
		
	
	}
	public static String getcellData(String xlfile,String xlsheet, int rownum,int colnum) throws IOException
	{
		fis=new FileInputStream(xlfile);
		workbook=new XSSFWorkbook(fis);
		sheet=workbook.getSheet(xlsheet);
		row=sheet.getRow(rownum);
		cell=row.getCell(colnum);
		
		String data;
		try
		{
			DataFormatter dataformatter=new DataFormatter();
			String celldata=dataformatter.formatCellValue(cell);
			return celldata;
			
		}
		catch(Exception e)
		{
			data ="";
		}
		workbook.close();
		fis.close();
		return data;
		
		
	}
	
	
	

}
