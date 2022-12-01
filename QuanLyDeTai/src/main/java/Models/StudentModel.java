package Models;

import java.sql.Date;

public class StudentModel {
	private String studentId;
	private String studentName;
	private Boolean gender;
	private Date birth;
	private String email;
	private String phone;
	private String address;
	private Boolean lead;
	private String groupId;
	private String majorId;
	
	
	public StudentModel() {
		super();
	}
	
	public StudentModel(String studentId, String studentName, Boolean gender, Date birth, String email, String phone,
			String address, Boolean lead, String groupId, String majorId) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.gender = gender;
		this.birth = birth;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.lead = lead;
		this.groupId = groupId;
		this.majorId = majorId;
	}

	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public Boolean getGender() {
		return gender;
	}
	public void setGender(Boolean gender) {
		this.gender = gender;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Boolean getLead() {
		return lead;
	}
	public void setLead(Boolean lead) {
		this.lead = lead;
	}
	public String getGroupId() {
		return groupId;
	}
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	public String getMajorId() {
		return majorId;
	}
	public void setMajorId(String majorId) {
		this.majorId = majorId;
	}

}
