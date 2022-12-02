package Services;

import java.util.List;

import Models.StudentModel;

public interface IStudentService {
	void insert(StudentModel student);
	void edit(StudentModel student);
	void delete(String id);
	StudentModel get(int id);
	StudentModel get(String studentName);
	List<StudentModel> getAll();
	List<StudentModel> findAll();
	StudentModel findById(int id);
}
