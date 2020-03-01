package contoller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import VO.DAO;
import model.ModelViewBean;

/**
 * Servlet implementation class SelectFilterRequest
 */
@WebServlet("/SelectFilterRequest.do")
public class SelectFilterRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<ModelViewBean> list = new ArrayList<ModelViewBean>();

		String studentName = request.getParameter("studentName");
		String studentNo = request.getParameter("studentNo");
		String schoolName = request.getParameter("schoolName");
		String examDate = request.getParameter("examDate");
		String examCode = request.getParameter("examCode");
		String locationName = request.getParameter("locationName");
		JSONObject obj = new JSONObject();
		DAO dao = DAO.getInstance();
		String selcetData = dao.SelectWhere(schoolName, studentName, studentNo);
		list.addAll(dao.SelcetFilter(selcetData, examDate, examCode, locationName));
		obj.put("result", list);
		response.setContentType("application/x-json; charset=UTF-8");
		response.getWriter().print(obj);
		response.getWriter().flush();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
