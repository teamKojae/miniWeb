package hmmteresting.jiyoon.Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import hmmteresting.jiyoon.DAO.studentDAO;
import hmmteresting.jiyoon.model.RequestModifyDTO;
import hmmteresting.jiyoon.model.StudentDTO;

//수정요청 내역 불러오는 select
@WebServlet("/SelectModify")
public class SelectModify extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		//세션값을 통해 sudentNO를 가져와서 넣어주기
		HttpSession httpSession = request.getSession(false);
		String studentNo = (String) httpSession.getAttribute("studentNo");
		
		ArrayList<RequestModifyDTO> list = new ArrayList<RequestModifyDTO>();
		studentDAO dao = new studentDAO();
		list = dao.selectModify(studentNo);
		
		request.setAttribute("list", list);
		request.getRequestDispatcher("/studentGradeModifyList").forward(request, response);
	}

}
