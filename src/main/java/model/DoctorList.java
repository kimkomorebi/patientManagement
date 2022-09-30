package model;

public class DoctorList {
	String d_code;//의사 코드
	String d_name;//의사 이름
	String d_addr;//의사 주소
	String title;//진료 과목
	String p_addr;//환자 주소
	String d_tel;//의사 번호
	public String getD_code() {
		return d_code;
	}
	public void setD_code(String d_code) {
		this.d_code = d_code;
	}
	public String getD_name() {
		return d_name;
	}
	public void setD_name(String d_name) {
		this.d_name = d_name;
	}
	public String getD_addr() {
		return d_addr;
	}
	public void setD_addr(String d_addr) {
		this.d_addr = d_addr;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getP_addr() {
		return p_addr;
	}
	public void setP_addr(String p_addr) {
		this.p_addr = p_addr;
	}
	public String getD_tel() {
		return d_tel;
	}
	public void setD_tel(String d_tel) {
		this.d_tel = d_tel;
	}
}
