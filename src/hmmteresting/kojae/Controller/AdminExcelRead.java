package hmmteresting.kojae.Controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import hmmteresting.kojae.DAO.Util.ExcelUtil;
import hmmteresting.kojae.Model.ExamBean;

/**
 * Servlet implementation class AdminExcelRead
 */
@WebServlet("/AdminExcelRead.do")
public class AdminExcelRead extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminExcelRead() {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		String filePath = "/excel/"; // 업로드 될 경로 (폴더생성)
		File file = new File(request.getServletContext().getRealPath(filePath));
		if( ! file.isDirectory()) {
			file.mkdir();
		}
		// ↑ (workSpace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\hmmteresting\excel)
		int size = 1024 * 1024 * 10; // 업로드 용량 10MB

		// 업로드될 실제 경로 (이클리스상 경로)
		String uploadPath = request.getServletContext().getRealPath(filePath);

		// 이클립스 상대경로로 엑셀 저장
		MultipartRequest multi = new MultipartRequest(request, uploadPath, size, "UTF-8",
				new DefaultFileRenamePolicy());
		
		ExcelUtil excelUtil = new ExcelUtil();
		List<List<String>> totalList = excelUtil.excelData(multi.getFile("file").toString());
		String gson = new Gson().toJson(totalList);
		System.out.println(gson);
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(gson);
	}

}
