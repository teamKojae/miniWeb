package hmmteresting.kojae.Controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import hmmteresting.kojae.DAO.AdminProcess;

/**
 * Servlet implementation class AdminStudentUpload
 */
@WebServlet("/AdminExcelUpload.do")
public class AdminExcelUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AdminExcelUpload() {
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String filePath = "/excel/";	//업로드 될 경로 (폴더생성)
		int size = 1024*1024*10;  			// 업로드 용량 10MB
		
		// 업로드될 실제 경로 (이클리스상 경로)
		String uploadPath = request.getServletContext().getRealPath(filePath);
		
		// 이클립스 상대경로로 엑셀 저장
		MultipartRequest multi = new MultipartRequest(request,uploadPath,size,"UTF-8",new DefaultFileRenamePolicy() );
		
		
		// 이클립스 상대경로에 있는 엑셀을 Read
		AdminProcess adminDAO = new AdminProcess();
		
		adminDAO.insertUserUseExcel(multi.getFile("file").toString());
		response.sendRedirect("/galaxy/hosting/bitcamp");
	}
	

}

