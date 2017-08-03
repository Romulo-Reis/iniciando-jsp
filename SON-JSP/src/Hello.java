

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

/**
 * Servlet implementation class Hello
 */
@WebServlet("/Hello")
public class Hello extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Hello() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		
		String name = request.getParameter("name");
		String lastName = request.getParameter("lastname");
		
		out.println("Hello World - SON By: " + name +" "+ lastName);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JSONObject json = formatJson(request.getReader());
		System.out.println(json.get("name"));
		System.out.println(json.toString());
		//String body = request.getReader().lines().reduce("", (acc, actual)->acc+actual);
		//System.out.println(body);
	}
	private JSONObject formatJson(BufferedReader reader){
		StringBuffer bs = new StringBuffer();
		String line = null;
		try{
			while((line = reader.readLine())!=null){
				bs.append(line);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		JSONObject json = new JSONObject(bs.toString());
		return json;
	}

}
