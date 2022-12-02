package Services.Impl;

import java.util.List;

import DAO.IStudentDao;
import DAO.Impl.StudentDaoImpl;
import Models.StudentModel;
import Services.IStudentService;

public class StudentServiceImpl implements IStudentService{
	IStudentDao studentDao = new StudentDaoImpl();

	@Override
	public void insert(StudentModel student) {
		// TODO Auto-generated method stub
		studentDao.insert(student);
	}

	@Override
	public void edit(StudentModel student) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		studentDao.delete(id);
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
		// TODO Auto-generated method stub
		return studentDao.getAll();
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