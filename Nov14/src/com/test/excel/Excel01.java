package com.test.excel;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class Excel01 {

	public static void main(String[] args) {
		
		WritableWorkbook workbook = null;
		WritableSheet sheet = null;
		Label label = null;
		
		File file = new File("C:\\temp\\excel02.xls");
		
		HashMap<String, String> hashMap = new HashMap<String, String>();
		hashMap.put("이름", "홍길동2");
		hashMap.put("나이", "30");
		hashMap.put("출생연도",  "=1950 + now()");
		
		HashMap<String, String> hashMap2 = new HashMap<>();
		hashMap2.put("이름",  "임길동");
		hashMap2.put("나이",  "20");
		hashMap2.put("출생연도",  "=1950 + now()");
		
		ArrayList<HashMap<String, String>> arrayList = new ArrayList<HashMap<String, String>>();
		//HashMap<Integer, Integer> int01 = new HashMap<>();
		
		arrayList.add(hashMap);
		arrayList.add(hashMap2);
		
		try {
			workbook = Workbook.createWorkbook(file);
			workbook.createSheet("명단", 0);
			sheet = workbook.getSheet(0);
			
			label = new Label(0,0,"이름");
			sheet.addCell(label);
			label = new Label(1,0,"나이");
			sheet.addCell(label);
			label = new Label(2,0,"연도");
			sheet.addCell(label);
			
			//
			for (int i = 0; i < arrayList.size(); i++) {

				HashMap<String, String> result = arrayList.get(0);
				label = new Label(0, (i + 1), result.get("이름"));
				sheet.addCell(label);
				label = new Label(1, (i + 1), result.get("나이"));
				sheet.addCell(label);
				label = new Label(2, (i + 1), result.get("출생연도"));
				sheet.addCell(label);
			}

			workbook.write();
			workbook.close();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		} catch (RowsExceededException e) {
			
			e.printStackTrace();
		} catch (WriteException e) {
			
			e.printStackTrace();
		}
		

	}

}
