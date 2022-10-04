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
	
	public boolean putPatientInfo(PatientList pl) {
		
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
		String select = "select dt.d_code, dt.name, pt.addr, cs.title,dt.addr, dt.tel"
				+ " from doctor_info dt, patient_info pt, course_info cs"
				+ " where dt.m_code = cs.m_code"
				+ " and dt.addr = pt.addr";
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
				dl.setD_addr(rs.getString(3));
				dl.setTitle(rs.getString(4));
				dl.setP_addr(rs.getString(5));
				dl.setD_tel(rs.getString(6));
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
		String select = "select pa.p_code, pa.name, pa.addr, cs.title,dt.name,"
				+ "pc.room, to_char(pc.reg_date, 'YYYY-MM-DD')"
				+ " from patient_info pa, doctor_info dt, course_info cs, patient_course_info pc"
				+ " where pc.p_code = pa.p_code"
				+ " and pc.m_code = cs.m_code"
				+ " and dt.m_code = pc.m_code";
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
