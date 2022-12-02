package DAO;

import java.util.List;

import Models.StudentModel;

public interface IStudentDao {
	void insert(StudentModel student);
	void edit(StudentModel student);
	void delete(String id);
	StudentModel get(int id);
	StudentModel get(String studentName);
	List<StudentModel> getAll();
	List<StudentModel> findAll();
	StudentModel findById(int id);
}
