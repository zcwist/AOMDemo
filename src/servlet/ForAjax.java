package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import util.Transformer;
import config.EntityConfig;
import config.QueryConfig;
import config.RootPath;

public class ForAjax extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public ForAjax() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset=utf-8");
		String command = request.getParameter("Command");
		PrintWriter out = response.getWriter();
		if (command.equals("getQueryType")){
			try{
				out.println(Transformer.array2Json("value", QueryConfig.getInstance().getQueryTypeList()));
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if (command.equals("getPropertyList")){
			String queryType = request.getParameter("QueryType");
			try{
				out.println(Transformer.array2Json("value", QueryConfig.getInstance().getInputPropertyListByQueryType(queryType)));
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else if (command.equals("getQueryResult")){
			try {
				JSONObject queryData = new JSONObject(request.getParameter("QueryData"));
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if (command.equals("update")){
			System.out.println("Updating");
			QueryConfig.getInstance().update();
			System.out.println("Updated");
			out.println("{}");
		}
		
		
		
		

		
		

		out.flush();
		out.close();
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
		RootPath.getInstance().setRoot(getServletContext().getRealPath("/"));
	}

}
