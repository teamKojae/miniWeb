package hmmteresting.kojae.DAO;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
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

public class AdminProcess2_backup {
		public AdminProcess2_backup() {
			// TODO Auto-generated constructor stub
		}
	public void readExcelData(String fileName) {
	//	List<Country> countriesList = new ArrayList<Country>();

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
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/hmmteresting?", "root", "1234");
			System.out.println("Can use connetion");

			PreparedStatement pState = null;
			String sql = "INSERT INTO hmmteresting.grade " +
			"(studentNo, examNo, koreanScore, mathScore, englishScore, scienceScore,historyScore,"+
					"totalScore,averageScore) VALUES(?,?,?,?,?,?,?,?,?)";

			pState = conn.prepareStatement(sql);
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
						// 하드코딩냄시..^^;; 되는게 중요한거지 ~
					pState.execute();
				} // end of rows iterator

			} // end of sheets for loop

			// close file input stream
			fis.close();
			conn.close();

		} catch (IOException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
	
			
		}

	}
}
