package Services;

import java.util.List;

import Models.TopicModel;

public interface ITopicService {
	void insert(TopicModel topic);
	void edit(TopicModel topic);
	void delete(String id);
	TopicModel get(int id);
	TopicModel get(String topicName);
	List<TopicModel> getAll();
}
