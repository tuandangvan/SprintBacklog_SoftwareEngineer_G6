package DAO.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Connection.DBConnection;
import DAO.IAccountDao;
import Models.AccountModel;

public class AccountDaoImpl extends DBConnection implements IAccountDao{

	@Override
	public void insert(AccountModel account) {
		String sql = "INSERT INTO Account(userName, password, role) VALUES(?, ?, ?)";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, account.getUserName());
			ps.setString(2, account.getPassword());
			ps.setString(3, account.getRole());
			
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void edit(AccountModel account) {
		String sql = "UPDATE  Account SET password=?, role=? WHERE userName=?";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, account.getPassword());
			ps.setString(2, account.getRole());
			ps.setString(3, account.getUserName());
			
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(String userName) {
		String sql = "DELETE FROM Account WHERE userName = ?";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userName);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public AccountModel getUser(String userName) {
		String sql = "SELECT * FROM Account WHERE userName = ? ";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userName);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				AccountModel acc = new AccountModel();
				acc.setUserName(rs.getString("userName"));
				acc.setPassword(rs.getString("password"));
				acc.setRole(rs.getString("role"));
				return acc;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<AccountModel> getAll() {
		List<AccountModel> accs= new ArrayList<AccountModel>();
		String sql = "SELECT * FROM Account";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				AccountModel acc = new AccountModel();
				acc.setUserName(rs.getString("userName"));
				acc.setPassword(rs.getString("password"));
				acc.setRole(rs.getString("role"));
				accs.add(acc);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return accs;
	}
}
