package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ConnectDB.ConnectDB;
import Entity.HoaDon;
import Entity.NhanVien;
import Entity.TaiKhoan;

public class NhanVien_DAO {
	public ArrayList<NhanVien> getAllTableNhanVien() {
		ArrayList<NhanVien> dsnv = new ArrayList<NhanVien>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select * from NHANVIEN";
			Statement statement = con.createStatement();
			//thuc thi cau lenh sql tra ve doi tuong result
			ResultSet rs = statement.executeQuery(sql);
			//duyet tren ket qua tra ve
			while(rs.next()) {
				String maNV = rs.getString(1);
				String tenNV = rs.getString(2);
				String diaChi = rs.getString(3);
				String sdt = rs.getString(4);
				Double luong = rs.getDouble(5);
				String chucVu = rs.getString(6);
				TaiKhoan tk = new TaiKhoan(rs.getString(7));
				NhanVien nv = new NhanVien(maNV, tenNV, diaChi, sdt, luong, chucVu, tk);
				dsnv.add(nv);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return dsnv;
	}
	
	public boolean insert(NhanVien nv) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n =0;
		try {
			stmt = con.prepareStatement("insert into" + " NHANVIEN values (?,?,?,?,?,?,?)");
			stmt.setString(1, nv.getMaNhanVien());
			stmt.setString(2, nv.getTenNhanVien());
			stmt.setString(3, nv.getDiaChi());
			stmt.setString(4, nv.getSoDienThoai());
			stmt.setDouble(5, nv.getLuong());
			stmt.setString(6,nv.getChucVu());
			stmt.setString(7,nv.getTaiKhoan().getTaiKhoan());
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
	
	public ArrayList<NhanVien> getAllTableNhanVienByTaiKhoan(String taiKhoan) {
		ArrayList<NhanVien> dsnv = new ArrayList<NhanVien>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select * from NHANVIEN where tenTK = ?";
			PreparedStatement statement = con.prepareStatement(sql);
	        statement.setString(1, taiKhoan);
			//thuc thi cau lenh sql tra ve doi tuong result
	        ResultSet rs = statement.executeQuery();
			//duyet tren ket qua tra ve
			while(rs.next()) {
				String maNV = rs.getString(1);
				String tenNV = rs.getString(2);
				String diaChi = rs.getString(3);
				String sdt = rs.getString(4);
				Double luong = rs.getDouble(5);
				String chucVu = rs.getString(6);
				TaiKhoan tk = new TaiKhoan(rs.getString(7));
				NhanVien nv = new NhanVien(maNV, tenNV, diaChi, sdt, luong, chucVu, tk);
				dsnv.add(nv);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return dsnv;
	}
	
	public boolean update(NhanVien nv) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("update NHANVIEN set tenNhanVien =?, diaChi =?, soDienThoai=?, luong=?, chucVu=?,tenTK = ? where maNhanVien =? ");
		
			stmt.setString(1, nv.getTenNhanVien());
			stmt.setString(2, nv.getDiaChi());
			stmt.setString(3, nv.getSoDienThoai());
			stmt.setDouble(4, nv.getLuong());
			stmt.setString(5,nv.getChucVu());
			stmt.setString(6, nv.getTaiKhoan().getTaiKhoan());
			stmt.setString(7, nv.getMaNhanVien());
			n = stmt.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
			
		}
		finally {
			try {
				stmt.close();
			}
			catch (SQLException e) {
				e.printStackTrace();
			 }
			}
		return n >0;
	}
	
	public boolean delete(String ma) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("delete from NHANVIEN where maNhanVien =? ");
		
			stmt.setString(1, ma);
			n = stmt.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
			
		}
		finally {
			try {
				stmt.close();
			}
			catch (SQLException e) {
				e.printStackTrace();
			 }
			}
		return n >0;
	}
}
