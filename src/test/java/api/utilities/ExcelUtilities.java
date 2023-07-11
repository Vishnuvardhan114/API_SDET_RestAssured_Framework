package api.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtilities {
	String path;
	File fl;
	FileInputStream fi;
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	Row row;
	Cell cell;
	FileOutputStream fo;
	CellStyle style;
	
	public ExcelUtilities(String path) {
		this.path=path;
		
	}



	public int getRowCount(String sheetName) throws IOException {
		fl = new File(path);
		fi= new FileInputStream(fl);
		workbook= new XSSFWorkbook(fi);
		sheet= workbook.getSheet(sheetName);

		int count= sheet.getLastRowNum();
		workbook.close();
		fi.close();

		return count;

	}
	
	public int getCellCount(String sheetName,int rowNum) throws IOException {
		fl = new File(path);
		fi= new FileInputStream(fl);
		workbook= new XSSFWorkbook(fi);
		sheet= workbook.getSheet(sheetName);
		row=sheet.getRow(rowNum);
		

		int count= row.getLastCellNum();
		workbook.close();
		fi.close();

		return count;

	}
	
	public String getCellData(String sheetName,int rowNum,int colNum) throws IOException {
		fl = new File(path);
		fi= new FileInputStream(fl);
		workbook= new XSSFWorkbook(fi);
		sheet= workbook.getSheet(sheetName);
		row=sheet.getRow(rowNum);
		cell=row.getCell(colNum);
		
		DataFormatter formatter= new DataFormatter();
		String data;
		try {
			data=formatter.formatCellValue(cell);
		} catch (Exception e) {
			data="";
		}
	
		workbook.close();
		fi.close();

		return data;

	}
	
	public void setCellData(String sheetName,int rowNum,int colNum,String data) throws IOException {
		
		fl= new File(path);
		if (!fl.exists()) {   //If workbook does not exist
			workbook= new XSSFWorkbook();
			fo= new FileOutputStream(path);
			workbook.write(fo);
			workbook.close();
			fo.close();
		}
		fi=new FileInputStream(path);
		
		workbook=new XSSFWorkbook(fi);
		
		if (workbook.getSheetIndex(sheetName)==-1) { //If sheet does not exist
			workbook.createSheet(sheetName);
			
		}
		sheet=workbook.getSheet(sheetName);
		
		if (sheet.getRow(rowNum)==null) { // If the Row does not exist
			sheet.createRow(rowNum);
			
		}
		row = sheet.getRow(rowNum);
		cell= row.createCell(colNum);//Creates the cell to place the data
		cell.setCellValue(data);
		
		fo= new FileOutputStream(path);
		workbook.write(fo);
		workbook.close();
		fo.close();
		fi.close();
		
		
		
	}
	
	public void fillRedColor(String sheetName,int rowNum,int colNum) throws IOException {
		fi= new FileInputStream(path);
		workbook= new XSSFWorkbook(fi);
		sheet= workbook.getSheet(sheetName);
		row= sheet.getRow(rowNum);
		cell=row.getCell(colNum);
		
		style= workbook.createCellStyle();
		
		
		style.setFillForegroundColor(IndexedColors.RED.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		cell.setCellStyle(style);
		fo = new FileOutputStream(path);
		workbook.write(fo);
		workbook.close();
		fi.close();
		fo.close();
		 
		
		
		
	}
	public void fillGreenColor(String sheetName,int rowNum,int colNum) throws IOException {
		fi= new FileInputStream(path);
		workbook= new XSSFWorkbook(fi);
		sheet= workbook.getSheet(sheetName);
		row= sheet.getRow(rowNum);
		cell=row.getCell(colNum);
		
		style= workbook.createCellStyle();
		
		
		style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		cell.setCellStyle(style);
		fo = new FileOutputStream(path);
		workbook.write(fo);
		workbook.close();
		fi.close();
		fo.close();
		 
		
		
		
	}

}
