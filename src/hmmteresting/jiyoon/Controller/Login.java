package hmmteresting.jiyoon.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hmmteresting.jiyoon.DAO.RequestModifyDAO;
import hmmteresting.jiyoon.model.StudentDTO;


@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String name = request.getParameter("name");
		String studentNo = request.getParameter("studentNo");
		String juminNo = request.getParameter("juminNo");
		
		if(name!=null && studentNo !=null && juminNo!=null) {
			
			//받아온값으로 DB에 연결해서 일치하는 정보가 있으면 -> studentMain.jsp로 이동 및 섹션 생성
			RequestModifyDAO dao = new RequestModifyDAO();
			StudentDTO student = new StudentDTO();
			student = dao.login(name, studentNo, juminNo);
			
			if(student!=null) {
				System.out.println(student.getStudentNo());
				response.sendRedirect("/resource/view/studentMain.jsp");
			}else{
				System.out.println("알맞는 정보가 없으니 다시 로그인으로 ");
				response.sendRedirect("/resource/view/login.jsp");
			}
		}else {
			response.sendRedirect("/resource/view/login.jsp");
		}

		
		
		//name, studentNo, juminNo 중에 null값이 있으면 다시 -> login.jsp로
		//정보를 입력해주세요.
		
		
	}

}
