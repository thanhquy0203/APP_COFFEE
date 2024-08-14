package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ConnectDB.ConnectDB;
import Entity.The;

public class The_DAO {
	public ArrayList<The> getAllTableThe() {
		ArrayList<The> dst = new ArrayList<The>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select * from THE";
			Statement statement = con.createStatement();
			//thuc thi cau lenh sql tra ve doi tuong result
			ResultSet rs = statement.executeQuery(sql);
			//duyet tren ket qua tra ve
			while(rs.next()) {
				int soT = rs.getInt(1);
				String tinhTrang = rs.getString(2);
				The the = new The(soT,tinhTrang);
				dst.add(the);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return dst;
	}
	
	public boolean capNhat(String so) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n =0;
		try {
			stmt = con.prepareStatement("update THE set tinhTrang = ? where soThe = ?");
			stmt.setString(1, "Da co khach");
			stmt.setString(2, so);
			n = stmt.executeUpdate();
		} catch(SQLException e) {
			throw new IllegalArgumentException(e);
		} finally {
			try {
				stmt.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return n>0;
	}
}
