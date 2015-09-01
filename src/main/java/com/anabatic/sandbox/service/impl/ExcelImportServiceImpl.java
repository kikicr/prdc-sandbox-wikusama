package com.anabatic.sandbox.service.impl;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import com.anabatic.sandbox.service.ExcelImportService;

@Service
public class ExcelImportServiceImpl implements ExcelImportService {

	@Override
	public List<Map<String, Object>> getMapListFromSheet(InputStream in,int sheet) {
		InputStream fileIn=(InputStream) in;
		List<Map<String,Object>> listMap=new ArrayList<Map<String,Object>>();
		
		try {
			XSSFWorkbook wr=new XSSFWorkbook(fileIn);
			XSSFSheet sheetObject=wr.getSheetAt(sheet);
			Iterator<Row> rows=sheetObject.iterator();
			int counter=0;
			String header="";
			while(rows.hasNext()){
				Map<String,Object> map=new HashMap<String, Object>();
				Row row=(XSSFRow)rows.next();
				Iterator<Cell> cells=row.cellIterator();
				int rowCounter=0;
				
				while(cells.hasNext()){
					Cell cell=cells.next();
					if(counter>0){
						String arr[]=header.split("\t\t");	
						
					switch(cell.getCellType()){
					case Cell.CELL_TYPE_NUMERIC:
							
							map.put(arr[rowCounter],cell.getNumericCellValue());
							System.out.println(counter);
							System.out.println(cell.getNumericCellValue());
							listMap.add(map);
							
						break;
					case Cell.CELL_TYPE_STRING:
							
							map.put(arr[rowCounter],cell.getStringCellValue());
							System.out.println(counter);
							System.out.println(cell.getStringCellValue());
							listMap.add(map);
						break;
					}
					rowCounter++;
					}else{
						header+=cell.getStringCellValue()+"\t\t";
					}
					
					
				}
				counter++;
			}
			return listMap;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ArrayList<Map<String,Object>>(0);
	}

}
