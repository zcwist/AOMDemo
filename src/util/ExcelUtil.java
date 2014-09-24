package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class ExcelUtil {
	public void test(){
		try {
			read("D:/","demo","xls");
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
		for (Row row: sheet1){
			for (Cell cell: row){
				System.out.println(cell.getCellType());
			}
		}
		
		wb.close();
	}
}
