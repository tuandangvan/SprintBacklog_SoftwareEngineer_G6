package DAO.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Connection.DBConnection;
import DAO.IStudentDao;
import Models.StudentModel;

public class StudentDaoImpl extends DBConnection implements IStudentDao {

	@Override
	public void insert(StudentModel student) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO students(studentId, studentName, gender, birth, email, phone, address, lead, groupId, majorId)"
				+ "VALUES(?, ?, ?, ?, ?, ?, ?, 1, 'G1', 'CNTT')";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, student.getStudentId());
			ps.setString(2, student.getStudentName());
			ps.setBoolean(3, student.getGender());
			ps.setDate(4, student.getBirth());
			ps.setString(5, student.getEmail());
			ps.setString(6, student.getPhone());
			ps.setString(7, student.getAddress());
			ps.setBoolean(8, student.getLead());
			ps.setString(9, student.getGroupId());
			ps.setString(10, student.getMajorId());
			
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void edit(StudentModel student) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public StudentModel get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StudentModel get(String studentName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StudentModel> getAll() {
		List<StudentModel> students = new ArrayList<StudentModel>();
		String sql = "SELECT * FROM Students";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				StudentModel student = new StudentModel();
				student.setStudentId(rs.getString("studentId"));
				student.setStudentName(rs.getString("studentName"));
				student.setGender(rs.getBoolean("gender"));
				student.setBirth(rs.getDate("birth"));
				student.setEmail(rs.getString("email"));
				student.setPhone(rs.getString("phone"));
				student.setAddress(rs.getString("address"));
				students.add(student);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return students;
	}

	@Override
	public List<StudentModel> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StudentModel findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
