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
	
	public boolean putPatientUpdateTwo(PatientList pl) {
		String update = "update patient_doctor_info set"
				+" d_code = ? where p_code = ? and d_code = ?";
		boolean result = false;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,"hr","hr");
			pstmt = con.prepareStatement(update);
			pstmt.setString(1, pl.getD_code());
			System.out.println("첫번째D_code:"+pl.getD_code());
			pstmt.setString(2, pl.getP_code());
			System.out.println("p_code:"+pl.getP_code());
			pstmt.setString(3, pl.getD_code());
			System.out.println("두번째D_code:"+pl.getD_code());

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
				+ "name=?, addr=? where p_code = ?";
		boolean result = false;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,"hr","hr");
			pstmt = con.prepareStatement(update);
			pstmt.setString(1, pl.getP_name());
			pstmt.setString(2, pl.getAddr());
			pstmt.setString(3, pl.getP_code());
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
	
	public PatientList getUpdatePatient(String p_code) {
		String select = "select pt.p_code, pt.name, pt.addr, cs.title, dt.name, pc.room, pc.reg_date"
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
//		String select = "select pa.p_code, pa.name, pa.addr, cs.title,dt.name,"
//				+ "pc.room, to_char(pc.reg_date, 'YYYY-MM-DD')"
//				+ " from patient_info pa, doctor_info dt, course_info cs, patient_course_info pc"
//				+ " where pc.p_code = pa.p_code"
//				+ " and pc.m_code = cs.m_code"
//				+ " and dt.m_code = pc.m_code";
//		String select ="select pa.p_code, pa.name, pa.addr, cs.title, dt.name,"
//				+ "pc.room, to_char(pc.reg_date, 'YYYY-MM-DD')"
//				+ " from patient_info pa, doctor_info dt, course_info cs, patient_doctor_info pd, patient_course_info pc"
//				+ " where pa.p_code = pd.p_code"
//				+ " and dt.d_code = pd.d_code"
//				+ " and cs.m_code = dt.m_code"
//				+ " and pc.m_code = dt.m_code";
//		String select = "select pt.p_code, pt.name, pt.addr, cs.title, dt.name, pc.room, pc.reg_date"
//				+ " from patient_info pt, course_info cs, doctor_info dt, patient_course_info pc"
//				+ " where pt.p_code = pc.p_code"
//				+ " and cs.m_code = pc.m_code"
//				+ " and dt.m_code = pc.m_code order by pt.p_code asc";
		String select = "select pt.p_code, pt.name, pt.addr, cs.title, dt.name, pc.room, pc.reg_date"
				+ " from patient_info pt, course_info cs, doctor_info dt, patient_course_info pc"
				+ " where pt.p_code = pc.p_code"
				+ " and cs.m_code = pc.m_code"
				+ " and dt.m_code = pc.m_code order by pt.p_code asc";
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
