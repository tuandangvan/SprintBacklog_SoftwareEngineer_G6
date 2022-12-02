package Services.Impl;

import java.util.List;

import DAO.TopicDao;
import DAO.Impl.TopicDaoImpl;
import Models.TopicModel;
import Services.ITopicService;

public class TopicServiceImpl implements ITopicService{
	TopicDao topicDao = new TopicDaoImpl();

	@Override
	public void insert(TopicModel topic) {
		// TODO Auto-generated method stub
		topicDao.insert(topic);
	}

	@Override
	public void edit(TopicModel student) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public TopicModel get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TopicModel get(String studentName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TopicModel> getAll() {
		// TODO Auto-generated method stub
		return topicDao.getAll();
	}
}
