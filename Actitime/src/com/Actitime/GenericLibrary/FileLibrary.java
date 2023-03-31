package com.Actitime.GenericLibrary;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * This class is a generic class which is having non static methods to perform data driven testing
 * @author shrikant
 *
 */

public class FileLibrary {
	/**
	 * 
	 * @param key
	 * @return
	 * @throws IOException
	 */
public String readDataFromProperty(String key) throws IOException {
	FileInputStream fis = new FileInputStream("./TestData/commondata.property");
	Properties p=new Properties();
	p.load(fis);
	String value = p.getProperty(key);
	return value;
	}

/**
 * This method is non static method used to be date from exel sheet
 * @param Sheetname
 * @param row
 * @param cell
 * @return
 * @throws EncryptedDocumentException
 * @throws IOException
 */
public String readDataFromExelSheet(String Sheetname,int row,int cell) throws EncryptedDocumentException, IOException {
	FileInputStream fis1 = new FileInputStream("./TestData/ActitimeTestData.xlsx");
	Workbook wb = WorkbookFactory.create(fis1);
	String value = wb.getSheet(Sheetname).getRow(row).getCell(cell).getStringCellValue();
	
	return value;
	}
}
