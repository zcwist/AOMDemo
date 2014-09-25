package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import config.EntityConfig;

public class ExcelUtil {
	public void test(){
		try {
			read("D:/","demo","xls");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void generateAXlsByEntity(String entityName){
		Workbook wb = new HSSFWorkbook();
		Sheet sheet = wb.createSheet("本表中录入数据");
		Row row = sheet.createRow(0);
		ArrayList<String> propertyList = EntityConfig.getInstance().getPropertyListByEntityName("Sheet");
		for (int i=0; i < propertyList.size(); i++){
			row.createCell(i).setCellValue(propertyList.get(i));
		}
		try {
			FileOutputStream fileOut = new FileOutputStream("D:/" + entityName + ".xls");
			wb.write(fileOut);
			fileOut.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	private void read(String path, String fileName, String fileType)throws IOException{
		InputStream is = new FileInputStream(path + fileName + "." + fileType);
		Workbook wb = null;
		wb = new HSSFWorkbook(is);

		Sheet sheet1 = wb.getSheetAt(0);
		System.out.println(sheet1.getLastRowNum());
		for (Row row: sheet1){
			for (Cell cell: row){
				System.out.println(cell.getCellType());
			}
		}
		
		wb.close();
	}
}
