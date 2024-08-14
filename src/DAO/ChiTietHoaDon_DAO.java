package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import ConnectDB.ConnectDB;
import Entity.ChiTietHoaDon;
import Entity.DoUong;
import Entity.HoaDon;
import Entity.ChiTietHoaDon;
import Entity.KhachHang;
import Entity.NhanVien;
import Entity.The;

public class ChiTietHoaDon_DAO {
	public boolean insert(ChiTietHoaDon ct) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n =0;
		try {
			stmt = con.prepareStatement("insert into" + " CHITIETHOADON values (?,?,?,?)");
			stmt.setString(1, ct.getMaHoaDon().getMaHoaDon());
			stmt.setString(2, ct.getMaDoUong().getMaDoUong());
			stmt.setInt(3, ct.getSoLuong());
			stmt.setDouble(4, ct.getDonGia());
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
	
	public ArrayList<ChiTietHoaDon> getAllTableChiTietHoaDon() {
		ArrayList<ChiTietHoaDon> dscthd = new ArrayList<ChiTietHoaDon>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select * from CHITIETHOADON";
			Statement statement = con.createStatement();
			//thuc thi cau lenh sql tra ve doi tuong result
			ResultSet rs = statement.executeQuery(sql);
			//duyet tren ket qua tra ve
			while(rs.next()) {
				HoaDon hd = new HoaDon(rs.getString(1));
				DoUong du = new DoUong(rs.getString(2));
				int soL= rs.getInt(3);
				double donGia = rs.getDouble(4);
				ChiTietHoaDon cthd = new ChiTietHoaDon(hd, du, soL, donGia);
				dscthd.add(cthd);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return dscthd;
	}
	
	public ArrayList<ChiTietHoaDon> search(String hd,String du,String hd1) {
	    ArrayList<ChiTietHoaDon> dscthd = new ArrayList<ChiTietHoaDon>();
	    try {
	        ConnectDB.getInstance();
	        Connection con = ConnectDB.getConnection();
	        String sql = "SELECT * FROM CHITIETHOADON WHERE (maHoaDon = ? OR ? = '') AND (maDoUong = ? OR ? = '') AND maHoaDon = ?";
	        PreparedStatement statement = con.prepareStatement(sql);
	        statement.setString(1, hd);
	        statement.setString(2, (hd == null) ? "" : hd);
	        statement.setString(3, du);
	        statement.setString(4, (du == null) ? "" : du);
	        statement.setString(5, hd1);
	        ResultSet rs = statement.executeQuery();
	        while (rs.next()) {
	            HoaDon hd2 = new HoaDon(rs.getString(1));
	            DoUong du1 = new DoUong(rs.getString(2));
	            int sl = rs.getInt(3);
	            double donGia = rs.getDouble(4);
	            ChiTietHoaDon cthd = new ChiTietHoaDon(hd2, du1, sl, donGia);
	            dscthd.add(cthd);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return dscthd;
	}
	
	public ArrayList<ChiTietHoaDon> getAllTableChiTietHoaDonByHoaDon(String hd1) {
		ArrayList<ChiTietHoaDon> dscthd = new ArrayList<ChiTietHoaDon>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select * from CHITIETHOADON where maHoaDon = ?";
			PreparedStatement statement = con.prepareStatement(sql);
	        statement.setString(1, hd1);
			//thuc thi cau lenh sql tra ve doi tuong result
	        ResultSet rs = statement.executeQuery();
			//duyet tren ket qua tra ve
			while(rs.next()) {
				HoaDon hd = new HoaDon(rs.getString(1));
				DoUong du = new DoUong(rs.getString(2));
				int soL= rs.getInt(3);
				double donGia = rs.getDouble(4);
				ChiTietHoaDon cthd = new ChiTietHoaDon(hd, du, soL, donGia);
				dscthd.add(cthd);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return dscthd;
	}
}
