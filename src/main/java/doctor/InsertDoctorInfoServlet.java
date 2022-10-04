package doctor;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DBExpert;
import model.DoctorList;

/**
 * Servlet implementation class InsertDoctorInfoServlet
 */
@WebServlet("/insertDoctorInfo.do")
public class InsertDoctorInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertDoctorInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");
		String d_code = request.getParameter("D_CODE");
		String d_name = request.getParameter("D_NAME");
		String d_addr = request.getParameter("D_ADDR");
		String title = request.getParameter("TITLE");
		String d_tel = request.getParameter("D_TEL");
		DoctorList dl = new DoctorList();
		DBExpert dbe = new DBExpert();
		dl.setD_code(d_code);
		dl.setD_name(d_name);
		dl.setD_addr(d_addr);
		String mcode = dbe.searchMcode(title);
		dl.setM_code(mcode);
		//dl.setTitle(title);
		dl.setD_tel(d_tel);
		boolean result = dbe.insertDoctorInfo(dl);
		if(result) {
			response.sendRedirect("insertDoctorResult.jsp?R=Y");
		}else {
			response.sendRedirect("insertDoctorResult.jsp?R=N");
		}
		
	}

}
