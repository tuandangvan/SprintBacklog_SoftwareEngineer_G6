package Models;

public class TopicModel {
	private String topicId;
	private String topicName;
	private String detail;
	private String signUpId;
	private String majorId;
	
	
	public TopicModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public TopicModel(String topicId, String topicName, String detail, String signUpId, String majorId) {
		super();
		this.topicId = topicId;
		this.topicName = topicName;
		this.detail = detail;
		this.signUpId = signUpId;
		this.majorId = majorId;
	}


	public String getTopicId() {
		return topicId;
	}
	public void setTopicId(String topicId) {
		this.topicId = topicId;
	}
	public String getTopicName() {
		return topicName;
	}
	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getSignUpId() {
		return signUpId;
	}
	public void setSignUpId(String signUpId) {
		this.signUpId = signUpId;
	}
	public String getMajorId() {
		return majorId;
	}
	public void setMajorId(String majorId) {
		this.majorId = majorId;
	}
	
	
	
}
