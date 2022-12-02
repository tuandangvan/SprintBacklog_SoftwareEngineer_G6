package DAO;

import java.util.List;

import Models.TopicModel;



public interface TopicDao {
	void insert(TopicModel topic);
	void edit(TopicModel topic);
	void delete(String id);
	TopicModel get(int id);
	TopicModel get(String topicName);
	List<TopicModel> getAll();
	
}
