	package hmmteresting.kojae.DAO;
	
	import java.io.FileInputStream;
	import java.io.IOException;
	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.SQLException;
	import java.util.ArrayList;
	import java.util.Iterator;
	import java.util.List;
	
	import org.apache.poi.hssf.usermodel.HSSFWorkbook;
	import org.apache.poi.ss.usermodel.Cell;
	import org.apache.poi.ss.usermodel.Row;
	import org.apache.poi.ss.usermodel.Sheet;
	import org.apache.poi.ss.usermodel.Workbook;
	import org.apache.poi.xssf.usermodel.XSSFWorkbook;
	
	import hmmteresting.kojae.DAO.Util.SqlUtil;
	import hmmteresting.kojae.Model.GradeBean;
	
	public class AdminProcess {
		public AdminProcess() {
		}
	
		public List<GradeBean> excelData(String fileName) {
			List<GradeBean> gradeList = new ArrayList<GradeBean>();
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
	
				//모든 시트 개수 가져오기
				int numberOfSheets = workbook.getNumberOfSheets();
				GradeBean gradeBean = null;
				for (int i = 0; i < numberOfSheets; i++) {
					// 시트 1개 읽어서 저장
					Sheet sheet = workbook.getSheetAt(i);
					// 시트를 객체로 변환
					Iterator<Row> rowIterator = sheet.iterator();
					while (rowIterator.hasNext()) {
						gradeBean = new GradeBean();
						// 시트에 있는 row읽기
						Row row = rowIterator.next();
						// 열하나씩 읽어서 Iterator 객체로 저장
						Iterator<Cell> cellIterator = row.cellIterator();
						while (cellIterator.hasNext()) {
							// 열 하나에 대한 셀값 가져오기
							Cell cell = cellIterator.next();	
							// 타입에 따라 빈에 저장시키기
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:  	//String 형 셀
								gradeBean.setStudentNo(cell.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:  // 숫자형 셀
								int intValue = (int) cell.getNumericCellValue();
								switch (cell.getColumnIndex()) {
								case 2:
									gradeBean.setExamNo(intValue);
									break;
								case 3:
									gradeBean.setKoreanScore(intValue);
									break;
								case 4:
									gradeBean.setMathScore(intValue);
									break;
								case 5:
									gradeBean.setEnglishScore(intValue);
									break;
								case 6:
									gradeBean.setScienceScore(intValue);
									break;
								case 7:
									gradeBean.setHistoryScore(intValue);
									break;
								}
								break;
							case Cell.CELL_TYPE_FORMULA:   // 함수 사용한 셀
								int intValueFomula = (int) cell.getNumericCellValue();
								switch (cell.getColumnIndex()) {
								case 8:
									gradeBean.setTotlaScore(intValueFomula);
									break;
								case 9:
									gradeBean.setAverageScore(intValueFomula);
								}
								break;
							}
						}	//셀마다 읽기 끝
						gradeList.add(gradeBean);
					} // Row 열 읽기 끝
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			return gradeList;
		}
	
		public void insertExcelData(String fileName) {
	
			try {
				List<GradeBean> gradeList = excelData(fileName); 
	
				Connection connection = SqlUtil.getConnection();
	
				PreparedStatement pState = null;
				String sql = "INSERT INTO hmmteresting.grade "
						+ "(studentNo, examNo, koreanScore, mathScore, englishScore, scienceScore,historyScore,"
						+ "totalScore,averageScore) VALUES(?,?,?,?,?,?,?,?,?)";
	
				pState = connection.prepareStatement(sql);
				int index=0;
				for(GradeBean gradeBean : gradeList) {
					pState.setString(1, gradeBean.getStudentNo());
					pState.setInt(2, gradeBean.getExamNo());
					pState.setInt(3,gradeBean.getKoreanScore());
					pState.setInt(4,gradeBean.getMathScore());
					pState.setInt(5,gradeBean.getEnglishScore());
					pState.setInt(6,gradeBean.getScienceScore());
					pState.setInt(7,gradeBean.getHistoryScore());
					pState.setInt(8,gradeBean.getTotlaScore());
					pState.setInt(9,gradeBean.getAverageScore());
					pState.execute();
				}
			
				pState.close();
				
				connection.close();
	
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
	
			}
	
		}
		
		public void readExcelDataa(String fileName) {
			// List<Country> countriesList = new ArrayList<Country>();
	
			try {
				// Create the input stream from the xlsx/xls file
				FileInputStream fis = new FileInputStream(fileName);
	
				// Create Workbook instance for xlsx/xls file input stream
				Workbook workbook = null;
				if (fileName.toLowerCase().endsWith("xlsx")) {
					workbook = new XSSFWorkbook(fis);
				} else if (fileName.toLowerCase().endsWith("xls")) {
					workbook = new HSSFWorkbook(fis);
				}
	
				// Get the number of sheets in the xlsx file
				int numberOfSheets = workbook.getNumberOfSheets();
				Connection connection = SqlUtil.getConnection();
	
				PreparedStatement pState = null;
				String sql = "INSERT INTO hmmteresting.grade "
						+ "(studentNo, examNo, koreanScore, mathScore, englishScore, scienceScore,historyScore,"
						+ "totalScore,averageScore) VALUES(?,?,?,?,?,?,?,?,?)";
	
				pState = connection.prepareStatement(sql);
				// loop through each of the sheets
				for (int i = 0; i < numberOfSheets; i++) {
	
					// Get the nth sheet from the workbook
					Sheet sheet = workbook.getSheetAt(i);
	
					// every sheet has rows, iterate over them
					Iterator<Row> rowIterator = sheet.iterator();
					while (rowIterator.hasNext()) {
						// Get the row object
						Row row = rowIterator.next();
						// Every row has columns, get the column iterator and iterate over them
						Iterator<Cell> cellIterator = row.cellIterator();
						while (cellIterator.hasNext()) {
							// Get the Cell object
							Cell cell = cellIterator.next();
							// check the cell type and process accordingly
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								pState.setString(cell.getColumnIndex() + 1, cell.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								pState.setDouble(cell.getColumnIndex() + 1, cell.getNumericCellValue());
								break;
							case Cell.CELL_TYPE_FORMULA:
								pState.setDouble(cell.getColumnIndex() + 1, cell.getNumericCellValue());
							}
						} // end of cell iterator
						pState.execute();
					} // end of rows iterator
	
				} // end of sheets for loop
	
				// close file input stream
				fis.close();
				connection.close();
	
			} catch (IOException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
	
			}
	
		}
		public static void main(String[] args) {
			AdminProcess a = new AdminProcess();
			a.readExcelDataa("E:/excel/studentGrade.xlsx");
//			for(GradeBean grade : list) {
//				System.out.println(grade.toString());
//			}
		
		}
	}
