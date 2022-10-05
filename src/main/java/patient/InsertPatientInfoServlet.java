package patient;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DBExpert;
import model.PatientList;

/**
 * Servlet implementation class InsertPatientInfoServlet
 */
@WebServlet("/insertPatientInfo.do")
public class InsertPatientInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertPatientInfoServlet() {
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
		String p_code = request.getParameter("P_CODE");
		String p_name = request.getParameter("P_NAME");
		String addr = request.getParameter("ADDR");
		String title = request.getParameter("TITLE");
		String d_name = request.getParameter("D_NAME");
		String room = request.getParameter("ROOM");
		DBExpert dbe = new DBExpert();
		PatientList pl = new PatientList();
		pl.setP_code(p_code);
		pl.setP_name(p_name);
		pl.setAddr(addr);
		
		String McodeList = dbe.searchMcode(title);
		pl.setM_code(McodeList);
		String dcode = dbe.searchDoctorCode(d_name);
		pl.setD_code(dcode);
		pl.setRoom(room);
		pl.setTitle(title);
		
		boolean result = dbe.putPatientInfo(pl);
		if(result) {
			response.sendRedirect("insertPatientInfoResult.jsp?R=Y");
		}else {
			response.sendRedirect("insertPatientInfoResult.jsp?R=N");
		}
	}

}
