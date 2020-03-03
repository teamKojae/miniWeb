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

public class ExcelUtil3Test {

	
	public HashMap<String, List> excelData(String fileName) {
		List<GradeBean> gradeList = new ArrayList<GradeBean>();
		List<ExamBean> examList = new ArrayList<ExamBean>();
		List<StudentBean> studentList = new ArrayList<StudentBean>();
		HashMap<String, List> map = new HashMap<String, List>();
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
			GradeBean gradeBean = null;
			ExamBean examBean = null;
			StudentBean studentBean = null;
			for (int i = 0; i < numberOfSheets; i++) {
				// 시트 1개 읽어서 저장
				Sheet sheet = workbook.getSheetAt(i);
				// 시트를 객체로 변환
				Iterator<Row> rowIterator = sheet.iterator();
				while (rowIterator.hasNext()) {
					gradeBean = new GradeBean();
					examBean = new ExamBean();
					studentBean = new StudentBean();
					// 시트에 있는 row읽기
					Row row = rowIterator.next();
					// 열하나씩 읽어서 Iterator 객체로 저장
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						// 열 하나에 대한 셀값 가져오기
						Cell cell = cellIterator.next();
						// 타입에 따라 빈에 저장시키기
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING: // String 형 셀
							switch (cell.getColumnIndex()+1) {
								case 1:
									studentBean.setStudentNo(cell.getStringCellValue());
									break;
								case 2:
									studentBean.setStudentName(cell.getStringCellValue());

							}
							break;
						case Cell.CELL_TYPE_NUMERIC: // 숫자형 셀
							int intValue = (int) cell.getNumericCellValue();
							switch (cell.getColumnIndex()+1) {
								case 3:
									if( DateUtil.isCellDateFormatted(cell)) {
										Date date = cell.getDateCellValue();
										examBean.setExamDate( new SimpleDateFormat("yyyy-MM-dd").format(date));
									}
									
									break;
								case 4:
									examBean.setExamNo(intValue);
									break;
								case 5:
									gradeBean.setKoreanScore(intValue);
									break;
								case 6:
									gradeBean.setEnglishScore(intValue);
									break;
								case 7:
									gradeBean.setMathScore(intValue);
									break;
								case 8:
									gradeBean.setScienceScore(intValue);
									break;
								case 9:
									gradeBean.setHistoryScore(intValue);
							}
							break;
						case Cell.CELL_TYPE_FORMULA: // 함수 사용한 셀
							int intValueFomula = (int) cell.getNumericCellValue();
							switch (cell.getColumnIndex()) {
							case 10:
								gradeBean.setTotalScore(intValueFomula);
								break;
							case 11:
								gradeBean.setAverageScore(intValueFomula);
							}
							break;
						
						}
					} // 셀마다 읽기 끝
					examList.add(examBean);
					studentList.add(studentBean);
					gradeList.add(gradeBean);
				} // Row 열 읽기 끝
				map.put("exam", examList);
				map.put("student", studentList);
				map.put("grade", gradeList);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return map;
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
