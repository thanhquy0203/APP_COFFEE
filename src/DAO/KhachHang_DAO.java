package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ConnectDB.ConnectDB;
import Entity.KhachHang;

public class KhachHang_DAO {
	public ArrayList<KhachHang> getAllTableKhachHang() {
		ArrayList<KhachHang> dskh = new ArrayList<KhachHang>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select * from KHACHHANG";
			Statement statement = con.createStatement();
			// thuc thi cau lenh sql tra ve doi tuong result
			ResultSet rs = statement.executeQuery(sql);
			// duyet tren ket qua tra ve
			while (rs.next()) {
				String maKH = rs.getString(1);
				String tenKH = rs.getString(2);
				String diaChi = rs.getString(3);
				String soDienThoai = rs.getString(4);
				int diem = rs.getInt(5);
				KhachHang kh = new KhachHang(maKH, tenKH, diaChi, soDienThoai, diem);
				dskh.add(kh);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dskh;
	}

	public boolean create(KhachHang kh) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("insert into" + " KHACHHANG values (?,?,?,?,?)");
			stmt.setString(1, kh.getMaKhachHang());
			stmt.setString(2, kh.getTenKhachHang());
			stmt.setString(3, kh.getDiaChi());
			stmt.setString(4, kh.getSoDienThoai());
			stmt.setInt(5, 0);
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			throw new IllegalArgumentException(e);
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return n > 0;
	}

	public boolean update(KhachHang kh) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			String sql = "update KHACHHANG set tenKhachHang=?,diaChi=?,soDienThoai=?,diemTichLuy=? where maKhachHang =?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, kh.getTenKhachHang());
			stmt.setString(2, kh.getDiaChi());
			stmt.setString(3, kh.getSoDienThoai());
			stmt.setInt(4, kh.getDiemTichLuy());
			stmt.setString(5, kh.getMaKhachHang());
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return n > 0;
	}

	public boolean delete(String id) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("delete from KHACHHANG where maKhachHang=?");
			stmt.setString(1, id);
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return n > 0;
	}

	public ArrayList<KhachHang> findphone(String phone) {
	    ArrayList<KhachHang> dskh = new ArrayList<KhachHang>();
	    try {
	        ConnectDB.getInstance();
	        Connection con = ConnectDB.getConnection();
	        String sql = "SELECT * FROM KHACHHANG WHERE soDienThoai=?";
	        PreparedStatement statement = con.prepareStatement(sql);
	        statement.setString(1, phone);
	        // Thực thi câu lệnh SQL và nhận kết quả
	        ResultSet rs = statement.executeQuery();
	        // Duyệt qua kết quả trả về
	        while (rs.next()) {
	            String maKH = rs.getString(1);
	            String tenKH = rs.getString(2);
	            String diaChi = rs.getString(3);
	            String soDienThoai = rs.getString(4);
	            int diem = rs.getInt(5);
	            KhachHang kh = new KhachHang(maKH, tenKH, diaChi, soDienThoai, diem);
	            dskh.add(kh);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return dskh;
	}


	public ArrayList<KhachHang> findcode(String id) {
	    ArrayList<KhachHang> dskh = new ArrayList<KhachHang>();
	    try {
	        ConnectDB.getInstance();
	        Connection con = ConnectDB.getConnection();
	        String sql = "SELECT * FROM KHACHHANG WHERE maKhachHang=?";
	        PreparedStatement statement = con.prepareStatement(sql);
	        statement.setString(1, id);
	        // Thực thi câu lệnh SQL và nhận kết quả
	        ResultSet rs = statement.executeQuery();
	        // Duyệt qua kết quả trả về
	        while (rs.next()) {
	            String maKH = rs.getString(1);
	            String tenKH = rs.getString(2);
	            String diaChi = rs.getString(3);
	            String soDienThoai = rs.getString(4);
	            int diem = rs.getInt(5);
	            KhachHang kh = new KhachHang(maKH, tenKH, diaChi, soDienThoai, diem);
	            dskh.add(kh);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return dskh;
	}

}
