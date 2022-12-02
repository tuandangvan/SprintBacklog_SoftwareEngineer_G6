package DAO.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Connection.DBConnection;
import DAO.TopicDao;
import Models.TopicModel;

public class TopicDaoImpl extends DBConnection implements TopicDao {

	@Override
	public void insert(TopicModel topic) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO Topics(topicId,topicName, detail, signUpId, majorId) VALUES (?,?,?,?,?)";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);

			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void edit(TopicModel topic) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(String id) {
		String sql = "DELETE FROM topics WHERE topicId = ?";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// TODO Auto-generated method stub

	}

	@Override
	public TopicModel get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TopicModel get(String topicName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TopicModel> getAll() {
		List<TopicModel> topics = new ArrayList<TopicModel>();
		String sql = "SELECT * FROM Topics";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				TopicModel topic = new TopicModel();
				topic.setTopicId(rs.getString("topicId"));
				topic.setTopicName(rs.getString("topicName"));
				topic.setDetail(rs.getString("detail"));
				topic.setSignUpId(rs.getString("signUpId"));
				topic.setMajorId(rs.getString("majorId"));
				topics.add(topic);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return topics;
	}

}
