package hmmteresting.jiyoon.Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hmmteresting.jiyoon.DAO.RequestModifyDAO;
import hmmteresting.jiyoon.model.RequestModifyDTO;


@WebServlet("/SelectModify")
public class SelectModify extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		//세션값을 통해 sudentNO를 가져와서 넣어주기
		System.out.println("selectpage");
		 ArrayList<RequestModifyDTO> list = new ArrayList<RequestModifyDTO>();
		RequestModifyDAO dao = new RequestModifyDAO();
		list = dao.selectModify("111D526S3285"); //세션값구해서 넣어주기
		System.out.println(list);
		request.setAttribute("list", list);
				
		request.getRequestDispatcher("/resource/view/studentGradeModifyList.jsp").forward(request, response);
		//response.sendRedirect("/resource/view/studentGradeModifyList.jsp");
	}

}
