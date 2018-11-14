package com.test.excel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


class ExcelController {


	void makeExcel(ArrayList<HashMap<String, String>> al) {
		
		Workbook workbook = new HSSFWorkbook(); //~2003
		//Workbook workbook2 = new XSSFWorkbook();
		
		Sheet sheet1 = workbook.createSheet("userdata");
		
		Row row = null;
		Cell cell = null;

		
		row = sheet1.createRow(0);
		
		cell = row.createCell(0);
		cell.setCellValue("uidx");
		
		cell = row.createCell(1);
		cell.setCellValue("id");
		
		cell = row.createCell(2);
		cell.setCellValue("name");
		
		cell = row.createCell(3);
		cell.setCellValue("pw");
		
		cell = row.createCell(4);
		cell.setCellValue("grantaa");
		
		cell = row.createCell(5);
		cell.setCellValue("tell");

		for (int i = 0; i < al.size(); i++) {
			row = sheet1.createRow(i + 1);
			
			cell = row.createCell(0);
			cell.setCellValue(al.get(i).get("uidx"));
			
			cell = row.createCell(1);
			cell.setCellValue(al.get(i).get("id"));
			
			cell = row.createCell(2);
			cell.setCellValue(al.get(i).get("name"));
			
			cell = row.createCell(3);
			cell.setCellValue(al.get(i).get("pw"));
			
			cell = row.createCell(4);
			cell.setCellValue(al.get(i).get("grantaa"));
			
			cell = row.createCell(5);
			cell.setCellValue(al.get(i).get("tell"));

		}

		File file = new File("C:\\temp\\dbExcel.xls");
		
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
