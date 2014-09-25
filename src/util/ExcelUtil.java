package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import model.Entity;
import model.EntityBuilder;
import model.Property;
import model.PropertyType;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import config.EntityConfig;
import controller.EntityController;
import dao.EntityDao;

public class ExcelUtil {
	
	private String path = "D:/";
	private String fileName;
	private Row rowTitle;
	private String entityType;
	
	public ExcelUtil(String entityType, String path){
		this.entityType = entityType;
		this.path = path;
	}
	
	public ExcelUtil(String entityType, String path, String fileName){
		this.entityType = entityType;
		this.path = path;
		this.fileName = fileName;
	}
	
	public void test(){
	}
	public void generateAXlsByEntity(String entityName){		
		@SuppressWarnings("resource")
		Workbook wb = new HSSFWorkbook();
		Sheet sheet = wb.createSheet("本表中录入数据");
		Row row = sheet.createRow(0);
		ArrayList<String> propertyList = EntityConfig.getInstance().getPropertyListByEntityName(entityName);
		for (int i=0; i < propertyList.size(); i++){
			row.createCell(i).setCellValue(propertyList.get(i));
		}
		try {
			FileOutputStream fileOut = new FileOutputStream(path + entityName + ".xls");
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
	
	public void xls2DB()throws IOException{
		InputStream is = new FileInputStream(path + fileName + ".xls");
		Workbook wb = new HSSFWorkbook(is);
		
		EntityDao entityDao = null;
		try {
			entityDao = new EntityDao();
			
			Sheet sheet1 = wb.getSheetAt(0);
			rowTitle = sheet1.getRow(0);
			for (int i = 1; i <= sheet1.getLastRowNum(); i ++){
				entityDao.insertNewEntity(row2Entity(sheet1.getRow(i)));
			}
			wb.close();

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			entityDao.destroy();
		}

		
	}
	private Entity row2Entity(Row row){
		//Transform a row to entity, and insert into the db
		List<Property> propertyList = new ArrayList<Property>();
		for (int i = 0; i < row.getLastCellNum(); i ++){
			String title = rowTitle.getCell(i).getStringCellValue();
			PropertyType propertyType = new PropertyType(title);
			if (row.getCell(i) != null){
				row.getCell(i).setCellType(Cell.CELL_TYPE_STRING);
				Property property = new Property(propertyType,row.getCell(i).getStringCellValue());
				propertyList.add(property);
			}
		}
		EntityBuilder eb = new EntityBuilder(entityType, propertyList);
		EntityController ec = new EntityController();
		Entity entity;
		entity = ec.construct(eb);
		
		return entity;
	}
}
