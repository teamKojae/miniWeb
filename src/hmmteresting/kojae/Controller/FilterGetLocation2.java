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
			@WebServlet("/FilterGetExam2.do")
			public class FilterGetLocation2 extends HttpServlet {
				private static final long serialVersionUID = 1L;
			    public FilterGetLocation2() {  }
			
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
					

					String[] getColumn = request.getParameterValues("paramName[]");
					String[] getWhereQuery = request.getParameterValues("paramValue[]");
					
					
					List<String> column = new ArrayList<String>();
					List<String> whereQuery = new ArrayList<String>();
					for(String str : getColumn ) 
						column.add(str);
					
					for(String str : getWhereQuery)
						whereQuery.add(str);
					
					System.out.println("column  : "+column.get(0));
					System.out.println("whereQuery  : "+whereQuery.get(0));
					//request.get

					
					
					AdminProcess adminProcess = new AdminProcess();
					List<SchoolBean> schoolList = adminProcess.getLoactionName(column,whereQuery);
					
					String gson = new Gson().toJson(schoolList);
					System.out.println(gson);
					response.getWriter().write(gson);
					
				}
			
			}
