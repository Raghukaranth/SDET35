package com.crm.comcast.genericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * 
 * @author Raghavendra Karanth S
 *
 */
public class ExcelUtility {
	public FileInputStream fxl;
	
	/**
	 * 
	 * used to read data from the excel file for vtiger 
	 * @param name
	 * @param row
	 * @param cell
	 * @return
	 * @throws Throwable
	 */
	public String getDataFromExcelVtiger(String sheetName, int row, int cell) throws Throwable {
		fxl = new FileInputStream(IPathConstants.vtigerExcelPath);
		Workbook workbook = WorkbookFactory.create(fxl);
		
		return workbook.getSheet(sheetName).getRow(row).getCell(cell).getStringCellValue();
	}
	
	/**
	 * used to read data from excel for RMG
	 * @param name
	 * @param row
	 * @param cell
	 * @return
	 * @throws Throwable
	 */
	public String getDataFromExcelRmg(String sheetName, int row, int cell) throws Throwable {
		fxl = new FileInputStream(IPathConstants.rmgExcelPath);
		Workbook workbook = WorkbookFactory.create(fxl);
	
		return workbook.getSheet(sheetName).getRow(row).getCell(cell).getStringCellValue();
	}
	
	/**
	 *used to write the data for Vtiger excel cell
	 * @param name
	 * @param row
	 * @param cell
	 * @param value
	 * @throws Throwable
	 */
	public void setDataForExcelVtiger(String name, int row, int cell, String value) throws  Throwable {
		fxl = new FileInputStream(IPathConstants.vtigerExcelPath);
		Workbook workbook = WorkbookFactory.create(fxl);
		
		workbook.getSheet(name).getRow(row).createCell(cell).setCellValue(value);
		
		FileOutputStream fout = new FileOutputStream(IPathConstants.vtigerExcelPath);
		workbook.write(fout);
		fxl.close();
	}
	
	/**
	 * used to write the value for RMG excel file
	 * @param name
	 * @param row
	 * @param cell
	 * @param value
	 * @throws Throwable
	 */
	public void setDataForExcelRmg(String name, int row, int cell, String value) throws Throwable {
		FileInputStream fxl = new FileInputStream(IPathConstants.rmgExcelPath);
		Workbook workbook = WorkbookFactory.create(fxl);
		
		workbook.getSheet(name).getRow(row).createCell(cell).setCellValue(value);
		
		FileOutputStream fout = new FileOutputStream(IPathConstants.rmgExcelPath);
		workbook.write(fout);
		fxl.close();
	}
	
	/**
	 * to close opened excel files
	 * @throws Throwable
	 */
	public void closeExcelFiles() throws Throwable {
		fxl.close();
	}
}
