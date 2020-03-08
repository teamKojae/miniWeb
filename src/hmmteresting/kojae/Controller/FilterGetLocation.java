			package hmmteresting.kojae.Controller;
			
			import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
			import java.util.List;
			
			import javax.servlet.ServletException;
			import javax.servlet.annotation.WebServlet;
			import javax.servlet.http.HttpServlet;
			import javax.servlet.http.HttpServletRequest;
			import javax.servlet.http.HttpServletResponse;
			
			import com.google.gson.Gson;
			
			import hmmteresting.kojae.DAO.AdminProcess;
			import hmmteresting.kojae.Model.SchoolBean;
			
			/**
			 * Servlet implementation class FilterGetExam
			 */
			@WebServlet("/FilterGetExam.do")
			public class FilterGetLocation extends HttpServlet {
				private static final long serialVersionUID = 1L;
			    public FilterGetLocation() {  }
			
				protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
					request.setCharacterEncoding("utf-8");
					response.setContentType("text/html; charset=utf-8");
					
					Enumeration params = request.getParameterNames();
					String name = null ;
					
					//파라미터 확인용
					System.out.println("----------------------------");
					while (params.hasMoreElements()){
					    name = (String)params.nextElement();
					    System.out.println(name + " : " +request.getParameter(name));
					}
					System.out.println("----------------------------");
					AdminProcess process = new AdminProcess();
					String locationName = request.getParameter("locationName");
					
					System.out.println(locationName);
					List<SchoolBean> list = null;
					if(locationName==null) list = process.getLocation();
					else list = process.getSchoolName(locationName);
					
					
					response.getWriter().write(new Gson().toJson(list));
					
				}
			
			}
