package com.test.excel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel02 {

	public static void main(String[] args) {
		
		Workbook workbook = new HSSFWorkbook(); //~2003
		//Workbook workbook2 = new XSSFWorkbook();
		
		Sheet sheet1 = workbook.createSheet("��Ʈ ����");
		
		Row row = null;
		Cell cell = null;
		
		row = sheet1.createRow(0);
		
		cell = row.createCell(0);
		cell.setCellValue("�̸�");
		
		cell = row.createCell(1);
		cell.setCellValue("����");
		
		cell = row.createCell(2);
		cell.setCellValue("����");
		
		
		
		
		
		File file = new File("C:\\temp\\poiExcel.xls");
		
		try {
			FileOutputStream fileOut = new FileOutputStream(file);
			workbook.write(fileOut);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}

	}

}
