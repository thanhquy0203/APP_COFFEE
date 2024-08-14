package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ConnectDB.ConnectDB;
import Entity.DoUong;

public class DoUong_DAO {
	public ArrayList<DoUong> getAllTableDoUong() {
		ArrayList<DoUong> dsdu = new ArrayList<DoUong>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select * from DOUONG";
			Statement statement = con.createStatement();
			//thuc thi cau lenh sql tra ve doi tuong result
			ResultSet rs = statement.executeQuery(sql);
			//duyet tren ket qua tra ve
			while(rs.next()) {
				String maDU = rs.getString(1);
				String tenDU = rs.getString(2);
				double diem = rs.getDouble(3);
				String loaiDoUong = rs.getString(4);
				DoUong du = new DoUong(maDU,tenDU, diem, loaiDoUong);
				dsdu.add(du);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return dsdu;
	}
}
