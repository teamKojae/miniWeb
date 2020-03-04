package hmmteresting.soobin.Controoler;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import hmmteresting.kojae.DAO.Util.SqlUtil;
import hmmteresting.soobin.DAO.ExamDAO;
import hmmteresting.soobin.model.ModelExamBean;
import hmmteresting.soobin.model.ModelViewBean;

/**
 * Servlet implementation class SelectExamRequest
 */
@WebServlet("/SelectExamRequest.do")
public class SelectExamRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SqlUtil sqlUtil = new SqlUtil();
		PreparedStatement pState = null;
		ResultSet rest = null;
		List<ModelExamBean> list = new ArrayList<ModelExamBean>();
		ModelViewBean modelViewBean = new ModelViewBean();
		
		String examDate=request.getParameter("examDate");
		ExamDAO dao = new ExamDAO();
		list.addAll(dao.SelcetExamDate(examDate));
		String gson=new Gson().toJson(list);
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(gson);
	}

}
