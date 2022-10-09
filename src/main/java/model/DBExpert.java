package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DBExpert {
	final private String driver = "oracle.jdbc.OracleDriver";
	final private String url = "jdbc:oracle:thin:@//localhost:1521/xe";
	private Connection con = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	
	public boolean putDeletePatientSecond(PatientList pl) {
		String delete = "delete from patient_doctor_info where p_code = ? and d_code = ?";
		boolean result = false;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,"hr","hr");
			pstmt = con.prepareStatement(delete);
			pstmt.setString(1, pl.getP_code());
			pstmt.setString(2, pl.getD_code());
			pstmt.executeUpdate();
			con.commit();
			result = true;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close(); con.close();
			}catch(Exception e) {}
		}
		return result;
	}
	
	public boolean putDeletePatient(PatientList pl) {
		String delete = "delete from patient_course_info where p_code = ? and m_code = ?";
		boolean result = false;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,"hr","hr");
			pstmt = con.prepareStatement(delete);
			pstmt.setString(1, pl.getP_code());
			pstmt.setString(2, pl.getM_code());
			pstmt.executeUpdate();
			con.commit();
			result = true;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close(); con.close();
			}catch(Exception e) {}
		}
		return result;
	}
	
	public PatientList getDeletePatientDetail(String p_code) {
		String select = "select pd.p_code, pt.name, pt.addr, cs.title, dt.name, pc.room, to_char(pc.reg_date, 'YYYY-MM-DD')"
				+ " from patient_doctor_info pd, patient_info pt,"
				+ " doctor_info dt, course_info cs, patient_course_info pc"
				+ " where pd.p_code = pt.p_code"
				+ " and pd.d_code = dt.d_code"
				+ " and pt.p_code = pc.p_code"
				+ " and pc.m_code = cs.m_code"
				+ " and dt.m_code = pc.m_code"
				+ " and pd.p_code = ?";
		PatientList pl = new PatientList();
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,"hr","hr");
			pstmt = con.prepareStatement(select);
			pstmt.setString(1, p_code);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				pl.setP_code(rs.getString(1));
				pl.setP_name(rs.getString(2));
				pl.setAddr(rs.getString(3));
				pl.setTitle(rs.getString(4));
				pl.setD_name(rs.getString(5));
				pl.setRoom(rs.getString(6));
				pl.setReg_date(rs.getString(7));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();pstmt.close();con.close();
			}catch(Exception e) {}
		}
		return pl;
	}
	
//	public boolean putPatientUpdateTwo(PatientList pl) {
//		String update = "update patient_doctor_info set"
//				+" d_code = ? where p_code = ? and d_code = ?";
//		boolean result = false;
//		try {
//			Class.forName(driver);
//			con = DriverManager.getConnection(url,"hr","hr");
//			pstmt = con.prepareStatement(update);
//			pstmt.setString(1, pl.getD_code());
//			System.out.println("첫번째D_code:"+pl.getD_code());
//			pstmt.setString(2, pl.getP_code());
//			System.out.println("p_code:"+pl.getP_code());
//			pstmt.setString(3, pl.getD_code());
//			System.out.println("두번째D_code:"+pl.getD_code());
//
//			pstmt.executeUpdate();
//			con.commit();
//			result = true;
//		}catch(Exception e) {
//			e.printStackTrace();
//		}finally {
//			try {
//				pstmt.close(); con.close();
//			}catch(Exception e) {}
//		}
//		return result;
//		
//	}
	
//	public String searchPcode(String p_name) {//환자 코드/ 환자 번호 검색
//		String select = "select p_code from patient_info where name = ?";
//		String pcode = null;
//		try {
//			Class.forName(driver);
//			con = DriverManager.getConnection(url,"hr","hr");
//			pstmt = con.prepareStatement(select);
//			pstmt.setString(1, p_name);
//			rs = pstmt.executeQuery();
//			if(rs.next()) pcode = rs.getString(1);
//		}catch(Exception e) {
//			e.printStackTrace();
//		}finally {
//			try {
//				rs.close(); pstmt.close(); con.close();
//			}catch(Exception e) {}
//		}
//		return pcode;
//	}
	
	public boolean putPatientUpdateOne(PatientList pl) {
		String update = "update patient_info set "
				+ "name=?, addr=?, tel=? where p_code = ?";
		boolean result = false;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,"hr","hr");
			pstmt = con.prepareStatement(update);
			pstmt.setString(1, pl.getP_name());
			pstmt.setString(2, pl.getAddr());
			pstmt.setString(3, pl.getTel());
			pstmt.setString(4, pl.getP_code());
			pstmt.executeUpdate();
			result = true;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close(); con.close();
			}catch(Exception e) {}
		}
		return result;
	}
	
	public PatientList getUpdatePatientDetail(String p_code) {
		String select = "select p_code, name, addr, tel from patient_info"
				+ " where p_code = ?";
		PatientList pl = new PatientList();
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,"hr","hr");
			pstmt = con.prepareStatement(select);
			pstmt.setString(1, p_code);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				pl.setP_code(rs.getString(1));
				pl.setP_name(rs.getString(2));
				pl.setAddr(rs.getString(3));
				pl.setTel(rs.getString(4));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();pstmt.close();con.close();
			}catch(Exception e) {}
		}
		return pl;
	}
	
	public PatientList getDeletePatient(String p_code) {
		String select = "select pt.p_code, pt.name, pt.addr, cs.title, dt.name, pc.room, to_char(pc.reg_date, 'YYYY-MM-DD')"
				+ " from patient_info pt, course_info cs, doctor_info dt, patient_course_info pc"
				+ " where pt.p_code = pc.p_code"
				+ " and cs.m_code = pc.m_code"
				+ " and dt.m_code = pc.m_code and pt.p_code = ?";
		PatientList pl = new PatientList();
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,"hr","hr");
			pstmt = con.prepareStatement(select);
			pstmt.setString(1, p_code);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				pl.setP_code(rs.getString(1));
				pl.setP_name(rs.getString(2));
				pl.setAddr(rs.getString(3));
				pl.setTitle(rs.getString(4));
				pl.setD_name(rs.getString(5));
				pl.setRoom(rs.getString(6));
				pl.setReg_date(rs.getString(7));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close(); pstmt.close(); con.close();
			}catch(Exception e) {}
		}
		return pl;
	}
	
	public boolean insertDoctorInfo(DoctorList dl) {
		String insert = "insert into doctor_info values(?,?,?,?,?)";
		boolean result = false;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,"hr","hr");
			pstmt = con.prepareStatement(insert);
			pstmt.setString(1, dl.getD_code());
			pstmt.setString(2, dl.getD_name());
			pstmt.setString(3, dl.getM_code());
			pstmt.setString(4, dl.getD_addr());
			pstmt.setString(5, dl.getD_tel());
			pstmt.executeUpdate();
			con.commit();
			result = true;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close(); con.close();
			}catch(Exception e) {}
		}
		return result;
	}
	
	public String searchDoctorCode(String dname) {//의사 코드
		String select ="select d_code from doctor_info where name = ?";
		String dcode = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,"hr","hr");
			pstmt = con.prepareStatement(select);
			pstmt.setString(1, dname);
			rs = pstmt.executeQuery();
			if(rs.next()) dcode = rs.getString(1);
			System.out.println("닥터코드:"+dcode);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close(); pstmt.close(); con.close();
			}catch(Exception e) {}
		}
		return dcode;
	}
	public String searchMcode(String title){//진료코드
		String select = "select m_code from course_info where title = ?";
		String mcode = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, "hr","hr");
			pstmt = con.prepareStatement(select);
			pstmt.setString(1, title);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				mcode = rs.getString(1);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				pstmt.close(); con.close();
			}catch(Exception e) {}
		}
		return mcode;
	}
	
	public boolean putPatientInfo(PatientList pl) {
		String insert = "insert all"
				+ " into patient_info(p_code,name,addr) values(?,?,?)"
				+ " into patient_doctor_info(p_code,d_code) values(?,?)"
				+ " into patient_course_info(p_code,room,m_code, reg_date) values(?,?,?, sysdate)"
				+ " select * from dual";
		boolean result = false;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,"hr","hr");
			pstmt = con.prepareStatement(insert);
			pstmt.setString(1, pl.getP_code());
			pstmt.setString(2, pl.getP_name());
			pstmt.setString(3, pl.getAddr());
			pstmt.setString(4, pl.getP_code());
			pstmt.setString(5, pl.getD_code());
			pstmt.setString(6, pl.getP_code());
			pstmt.setString(7, pl.getRoom());
			pstmt.setString(8, pl.getM_code());
			pstmt.executeUpdate();
			con.commit();
			result = true;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close(); con.close();
			}catch(Exception e) {}
		}
		return result;
	}
	public ArrayList<String> getDoctorNameList(){
		String select = "select name from doctor_info";
		ArrayList<String> list = new ArrayList<String>();
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,"hr","hr");
			pstmt = con.prepareStatement(select);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String doctList = rs.getString(1);
				list.add(doctList);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close(); pstmt.close();con.close();
			}catch(Exception e) {}
		}
		return list;
	}
	
	public ArrayList<String> getTitleList(){
		String select = "select title from course_info";
		ArrayList<String> list = new ArrayList<String>();
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,"hr","hr");
			pstmt = con.prepareStatement(select);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String titleList = rs.getString(1);
				list.add(titleList);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close(); pstmt.close(); con.close();
			}catch(Exception e) {}
		}
		return list;
	}
	public ArrayList<DoctorList> getDoctorList(){
		String select = "select dt.d_code, dt.name, cs.title, dt.addr, dt.tel"
				+ " from doctor_info dt, course_info cs"
				+ " where dt.m_code = cs.m_code";
		ArrayList<DoctorList> list = new ArrayList<DoctorList>();
		DoctorList dl = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,"hr","hr");
			pstmt = con.prepareStatement(select);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				dl = new DoctorList();
				dl.setD_code(rs.getString(1));
				dl.setD_name(rs.getString(2));
				dl.setTitle(rs.getString(3));
				dl.setD_addr(rs.getString(4));
				dl.setD_tel(rs.getString(5));
				list.add(dl);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close(); pstmt.close(); con.close();
			}catch(Exception e) {}
		}
		return list;
	}
	public ArrayList<PatientList> getPatientList(){

		//외래키로 잡혀있는 patient_doctor_info pd와
		//patient_course_info에 다른 테이블과
		//동일한 값이 들어가 있고,
		//위 두 테이블에 입력된 데이터를 기반으로 출력해야 하기 때문에
		//위 두 테이블에 다 등가 조인을 해야 한다.
		String select = "select pd.p_code, pt.name, pt.addr, cs.title, dt.name, pc.room, to_char(pc.reg_date, 'YYYY-MM-DD')"
				+ " from patient_doctor_info pd, patient_info pt,"
				+ " doctor_info dt, course_info cs, patient_course_info pc"
				+ " where pd.p_code = pt.p_code"
				+ " and pd.d_code = dt.d_code"
				+ " and pt.p_code = pc.p_code"
				+ " and pc.m_code = cs.m_code"
				+ " and dt.m_code = pc.m_code"
				+ " order by pd.p_code asc";

		//patient_doctor_info;
		ArrayList<PatientList> list = new ArrayList<PatientList>();
		PatientList pl = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,"hr","hr");
			pstmt= con.prepareStatement(select);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				pl = new PatientList();
				pl.setP_code(rs.getString(1));
				pl.setP_name(rs.getString(2));
				pl.setAddr(rs.getString(3));
				pl.setTitle(rs.getString(4));
				pl.setD_name(rs.getString(5));
				pl.setRoom(rs.getString(6));
				pl.setReg_date(rs.getString(7));
				list.add(pl);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close(); pstmt.close(); con.close();
			}catch(Exception e) {}
		}
		return list;
	}
}
