	package example1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

@WebServlet("/E1")
public class Example extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String pw = req.getParameter("password");
		List<String> list = new ArrayList<String>();
		list.add(id);
		list.add(pw);
			JSONObject obj = new JSONObject();
			obj.put("result", list);
			
			
			System.out.println(obj.get("result"));
			resp.setContentType("application/x-json; charset=UTF-8");
			resp.getWriter().println(obj);
			resp.getWriter().flush();
			
	}
	
	
	
	
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		System.out.println(id);
		List<String> list = new ArrayList<String>();
		list.add(id);
		list.add(pw);

		System.out.println(list.get(0));
			System.out.println();
			JSONObject obj = new JSONObject();
			obj.put("result", list);

			System.out.println(obj.get("result"));
			response.setContentType("application/x-json; charset=UTF-8");
			response.getWriter().print(obj);
			response.getWriter().print("aaa");
	}

}
