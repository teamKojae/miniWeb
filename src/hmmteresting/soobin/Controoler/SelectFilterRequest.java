	package hmmteresting.soobin.Controoler;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.google.gson.Gson;

import hmmteresting.kojae.DAO.Util.SqlUtil;
import hmmteresting.kojae.Model.GradeBean;
import hmmteresting.soobin.DAO.DAO;
import hmmteresting.soobin.model.ModelViewBean;

/**
 * Servlet implementation class SelectFilterRequest
 */
@WebServlet("/SelectFilterRequest.do")
public class SelectFilterRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		List<ModelViewBean> list = new ArrayList<ModelViewBean>();
			
		String studentName = request.getParameter("studentName");
		String studentNo = request.getParameter("studentNo");
		String schoolName = request.getParameter("schoolName");
		String examDate = request.getParameter("examDate");
		String examCode = request.getParameter("examCode");
		String locationName = request.getParameter("locationName");

		JSONObject obj = new JSONObject();
		GradeBean a = new GradeBean();
		DAO dao = new DAO();
		String selcetData = dao.SelectWhere(schoolName, studentName, studentNo);
		list.addAll(dao.SelcetFilter(selcetData, examDate, examCode, locationName));

		obj.put("result", list);
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append(obj.toString());
		request.setAttribute("list", list);
		String gson = new Gson().toJson(obj);

		response.getWriter().write(gson);

//		printWriter.write(stringBuffer.toString());

	}

//	protected void doGet(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		request.setCharacterEncoding("UTF-8");
//
//		List<ModelViewBean> list = new ArrayList<ModelViewBean>();
//
//		String studentName = request.getParameter("studentName");
//		String studentNo = request.getParameter("studentNo");
//		String schoolName = request.getParameter("schoolName");
//		String examDate = request.getParameter("examDate");
//		String examCode = request.getParameter("examCode");
//		String locationName = request.getParameter("locationName");
//	
//		JSONObject obj = new JSONObject();
//		GradeBean a = new GradeBean();
//		DAO dao =new DAO();
//		String selcetData = dao.SelectWhere(schoolName, studentName, studentNo);
//		list.addAll(dao.SelcetFilter(selcetData, examDate, examCode, locationName));
//		obj.put("result",list);
//		StringBuffer stringBuffer = new StringBuffer();
//		stringBuffer.append(obj.toString());
//		request.setAttribute("list", list);
//		String gson = new Gson().toJson(obj);
//		response.setContentType("application/json");
//		response.setCharacterEncoding("UTF-8");
//		 response.getWriter().write(gson);
//		System.out.println(gson);
//		
////		printWriter.write(stringBuffer.toString());
//	
//	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		SqlUtil sqlUtil = new SqlUtil();
		PreparedStatement pState = null;
		ResultSet rest = null;
		List<ModelViewBean> list = new ArrayList<ModelViewBean>();
		ModelViewBean modelViewBean = new ModelViewBean();

		request.setCharacterEncoding("UTF-8");
		String studentName = request.getParameter("studentName");
		String studentNo = request.getParameter("studentNo");
		String schoolName = request.getParameter("schoolName");
		String examDate = request.getParameter("examDate");
		String examCode = request.getParameter("examCode");
		String locationName = request.getParameter("locationName");
		DAO dao = new DAO();
		String selcetData = dao.SelectWhere(schoolName, studentName, studentNo);
		list.addAll(dao.SelcetFilter(selcetData, examDate, examCode, locationName));
		String gson = new Gson().toJson(list);
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(gson);

	}

}
