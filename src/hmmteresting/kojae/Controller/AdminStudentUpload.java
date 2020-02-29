package hmmteresting.kojae.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import hmmteresting.kojae.DAO.AdminProcess;

/**
 * Servlet implementation class AdminStudentUpload
 */
@WebServlet("/AdminStudentUpload.do")
public class AdminStudentUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AdminStudentUpload() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doget");
		System.out.println(request.getAttribute("file"));
		AdminProcess.readExcelData("E:\\excel\\studentGrade.xlsx");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost");
		AdminProcess.readExcelData("E:/excel/studentGrade.xlsx");
	}
	

}

