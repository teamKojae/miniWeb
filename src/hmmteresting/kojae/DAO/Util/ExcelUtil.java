package hmmteresting.kojae.DAO.Util;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import hmmteresting.kojae.Model.ExamBean;
import hmmteresting.kojae.Model.GradeBean;
import hmmteresting.kojae.Model.SchoolBean;
import hmmteresting.kojae.Model.StudentBean;

public class ExcelUtil {

	public List<List<String>> excelData(String fileName) {
		List<String> gradeList = null;
		List<List<String> > totalList = new ArrayList<List<String>>();
		try {
			// Create the input stream from the xlsx/xls file
			FileInputStream fileInputStream = new FileInputStream(fileName);
			// Create Workbook instance for xlsx/xls file input stream
			Workbook workbook = null;
			if (fileName.toLowerCase().endsWith("xlsx")) {
				workbook = new XSSFWorkbook(fileInputStream);
			} else if (fileName.toLowerCase().endsWith("xls")) {
				workbook = new HSSFWorkbook(fileInputStream);
			}

			// 모든 시트 개수 가져오기
			int numberOfSheets = workbook.getNumberOfSheets();
			for (int i = 0; i < numberOfSheets; i++) {
				// 시트 1개 읽어서 저장
				Sheet sheet = workbook.getSheetAt(i);
				// 시트를 객체로 변환
				Iterator<Row> rowIterator = sheet.iterator();
				while (rowIterator.hasNext()) {
					// 시트에 있는 row읽기
					Row row = rowIterator.next();
					// 열하나씩 읽어서 Iterator 객체로 저장
					Iterator<Cell> cellIterator = row.cellIterator();
					gradeList = new ArrayList<String>();
					while (cellIterator.hasNext()) {
						
						// 열 하나에 대한 셀값 가져오기
						Cell cell = cellIterator.next();
						//모든타입 스트링타입으로
						cell.setCellType(HSSFCell.CELL_TYPE_STRING);
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING: // String 형 셀
							if(cell.getRowIndex()>1) {
							switch ( cell.getColumnIndex() + 1  ) {
								default : 
									gradeList.add(cell.getStringCellValue().trim());
								}
							}
						} // 셀마다 읽기 끝
					} // Row 열 읽기 끝
					if(! gradeList.isEmpty())
					totalList.add(gradeList);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return totalList;
	}

	/*
	 * public static void main(String[] args) { ExcelUtil excelUtil = new
	 * ExcelUtil(); List<GradeBean> a =
	 * excelUtil.excelData("E:/excel/studentGrade.xlsx"); StringTokenizer st = null;
	 * for( GradeBean b : a ) { System.out.println(b); }
	 * 
	 * 
	 * }
	 */
}
