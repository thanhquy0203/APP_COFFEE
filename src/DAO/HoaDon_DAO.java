package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import ConnectDB.ConnectDB;
import Entity.HoaDon;
import Entity.KhachHang;
import Entity.NhanVien;
import Entity.The;

public class HoaDon_DAO {
	public ArrayList<HoaDon> getAllTableHoaDon() {
		ArrayList<HoaDon> dshd = new ArrayList<HoaDon>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select * from HOADON ORDER BY ngayBan ASC";
			Statement statement = con.createStatement();
			//thuc thi cau lenh sql tra ve doi tuong result
			ResultSet rs = statement.executeQuery(sql);
			//duyet tren ket qua tra ve
			while(rs.next()) {
				String maHD = rs.getString(1);
				Double tongTien= rs.getDouble(2);
				LocalDate ngayBan = rs.getDate(3).toLocalDate();
				NhanVien maNV = new NhanVien(rs.getString(4));
				KhachHang maKH = new KhachHang(rs.getString(5));
				The soT = new The(rs.getInt(6));
				HoaDon hd = new HoaDon(maHD, tongTien, ngayBan, maNV, maKH, soT);
				dshd.add(hd);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return dshd;
	}
	

	public ArrayList<HoaDon> fillter(int ngay, int thang, int nam, String nv) {
	    ArrayList<HoaDon> dshd = new ArrayList<HoaDon>();
	    try {
	        ConnectDB.getInstance();
	        Connection con = ConnectDB.getConnection();
	        String sql = "SELECT * FROM HOADON WHERE (DAY(ngayBan) = ? OR ? = '') AND (MONTH(ngayBan) = ? OR ? = '') AND (YEAR(ngayBan) = ? OR ? = '') AND (maNhanVien = ? OR ? = '') ORDER BY maNhanVien ASC, ngayBan ASC";
	        PreparedStatement statement = con.prepareStatement(sql);
	        statement.setInt(1, ngay);
	        statement.setString(2, (ngay == 0) ? "" : String.valueOf(ngay));
	        statement.setInt(3, thang);
	        statement.setString(4, (thang == 0) ? "" : String.valueOf(thang));
	        statement.setInt(5, nam);
	        statement.setString(6, (nam == 0) ? "" : String.valueOf(nam));
	        statement.setString(7, nv);
	        statement.setString(8, (nv == null) ? "" : nv);
	        ResultSet rs = statement.executeQuery();
	        while (rs.next()) {
	            String maHD = rs.getString(1);
	            Double tongTien = rs.getDouble(2);
	            LocalDate ngayBan = rs.getDate(3).toLocalDate();
	            NhanVien maNV = new NhanVien(rs.getString(4));
	            KhachHang maKH = new KhachHang(rs.getString(5));
	            The maB = new The(rs.getInt(6));
	            HoaDon hd = new HoaDon(maHD, tongTien, ngayBan, maNV, maKH, maB);
	            dshd.add(hd);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return dshd;
	}

	public boolean insert(HoaDon hd) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n =0;
		try {
			stmt = con.prepareStatement("insert into" + " HOADON values (?,?,?,?,?,?)");
			stmt.setString(1, hd.getMaHoaDon());
			stmt.setDouble(2, hd.getTongTien());
			String ngayBanString = hd.getNgayBan().toString();
			stmt.setObject(3, ngayBanString);
			stmt.setString(4, hd.getMaNhanVien().getMaNhanVien());
			stmt.setString(5, hd.getMaKhachHang().getMaKhachHang());
			stmt.setInt(6,hd.getSoThe().getSoThe());
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

	public ArrayList<HoaDon> search(int ngay, int thang, int nam, String nv,String kh,String hd) {
	    ArrayList<HoaDon> dshd = new ArrayList<HoaDon>();
	    try {
	        ConnectDB.getInstance();
	        Connection con = ConnectDB.getConnection();
	        String sql = "SELECT * FROM HOADON WHERE (DAY(ngayBan) = ? OR ? = '') AND (MONTH(ngayBan) = ? OR ? = '') AND (YEAR(ngayBan) = ? OR ? = '') AND (maNhanVien = ? OR ? = '') AND (maKhachHang = ? OR ? = '') AND (maHoaDon = ? OR ? = '')";
	        PreparedStatement statement = con.prepareStatement(sql);
	        statement.setInt(1, ngay);
	        statement.setString(2, (ngay == 0) ? "" : String.valueOf(ngay));
	        statement.setInt(3, thang);
	        statement.setString(4, (thang == 0) ? "" : String.valueOf(thang));
	        statement.setInt(5, nam);
	        statement.setString(6, (nam == 0) ? "" : String.valueOf(nam));
	        statement.setString(7, nv);
	        statement.setString(8, (nv == null) ? "" : nv);
	        statement.setString(9, kh);
	        statement.setString(10, (kh == null) ? "" : kh);
	        statement.setString(11, hd);
	        statement.setString(12, (hd == null) ? "" : hd);
	        ResultSet rs = statement.executeQuery();
	        while (rs.next()) {
	            String maHD = rs.getString(1);
	            Double tongTien = rs.getDouble(2);
	            LocalDate ngayBan = rs.getDate(3).toLocalDate();
	            NhanVien maNV = new NhanVien(rs.getString(4));
	            KhachHang maKH = new KhachHang(rs.getString(5));
	            The maB = new The(rs.getInt(6));
	            HoaDon hd1 = new HoaDon(maHD, tongTien, ngayBan, maNV, maKH, maB);
	            dshd.add(hd1);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return dshd;
	}
}
