package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ConnectDB.ConnectDB;
import Entity.NguyenLieu;

public class NguyenLieu_DAO {
	public ArrayList<NguyenLieu> getAllTableNguyenLieu() {
		ArrayList<NguyenLieu> dsnl = new ArrayList<NguyenLieu>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select * from NGUYENLIEU";
			Statement statement = con.createStatement();
			//thuc thi cau lenh sql tra ve doi tuong result
			ResultSet rs = statement.executeQuery(sql);
			//duyet tren ket qua tra ve
			while(rs.next()) {
				String maNL = rs.getString(1);
				String tenNL = rs.getString(2);
				int soLuong  = rs.getInt(3);
				String donVi = rs.getString(4);
				NguyenLieu nl = new NguyenLieu(maNL, tenNL, soLuong, donVi);
				dsnl.add(nl);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return dsnl;
	}
	
	public ArrayList<String> getDonVi() {
		ArrayList<String> donVi = new ArrayList<String>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select distinct donVi from NGUYENLIEU";
			Statement statement = con.createStatement();
			//thuc thi cau lenh sql tra ve doi tuong result
			ResultSet rs = statement.executeQuery(sql);
			//duyet tren ket qua tra ve
			while(rs.next()) {
				String donVi1 = rs.getString(1);
				donVi.add(donVi1);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return donVi;
	}
	
//	public static void updateNguyenLieu(NguyenLieu nl) {
//		try (
//				Connection con = ConnectDB.getConnection();
//				PreparedStatement update = con.prepareStatement("update NGUYENLIEU "
//						+ "set tenNguyenLieu = ?, soLuong = ?"
//						+ "where maNguyenLieu = ?");
//				){
//			update.setString(1, nl.getTenNguyenLieu());
//			update.setInt(2, nl.getSoLuong());
//			update.setString(3, nl.getMaNguyenLieu());
//			update.executeUpdate();
//			
//		}catch (Exception e) {
//			e.printStackTrace();
//			
//		}
//	}

	public boolean create(NguyenLieu nl) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("insert into" + 
					" NGUYENLIEU values(?, ?, ?, ?)");
			stmt.setString(1,nl.getMaNguyenLieu());
			stmt.setString(2,nl.getTenNguyenLieu());
			stmt.setInt(3, nl.getSoLuong());
			
			stmt.setString(4,nl.getDonVi());
			
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			throw new IllegalArgumentException("Mã đã tồn tại");
		}
		finally {
			try {
					stmt.close();
			} catch (SQLException e) { 
				// TODO Auto-generated catch block 
				e.printStackTrace();
			}
		}
		return n > 0;
		
	}

	public boolean update(NguyenLieu nl) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("update NGUYENLIEU set tenNguyenLieu =?, soLuong =soLuong+?, donVi=? where maNguyenLieu =? ");
			stmt.setString(1, nl.getTenNguyenLieu());
			stmt.setInt(2, nl.getSoLuong());
			stmt.setString(3, nl.getDonVi());
			stmt.setString(4, nl.getMaNguyenLieu());
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
//	
//	public ArrayList<NguyenLieu> finddsma(String id) {
//	    ArrayList<NguyenLieu> dskh = new ArrayList<NguyenLieu>();
//	    try {
//	        ConnectDB.getInstance();
//	        Connection con = ConnectDB.getConnection();
//	        String sql = "SELECT * FROM NGUYENLIEU WHERE maNguyenLieu=?";
//	        PreparedStatement statement = con.prepareStatement(sql);
//	        statement.setString(1, id);
//	        // Thực thi câu lệnh SQL và nhận kết quả
//	        ResultSet rs = statement.executeQuery();
//	        // Duyệt qua kết quả trả về
//	        while (rs.next()) {
//	            String maNL = rs.getString(1);
//	            String tenNL = rs.getString(2);
//	            int soLuong = rs.getInt(3);
//	            NguyenLieu nl = new NguyenLieu(maNL, tenNL, soLuong);
//	            dskh.add(nl);
//	        }
//	    } catch (SQLException e) {
//	        e.printStackTrace();
//	    }
//	    return dskh;
//	}
//	
//	public ArrayList<NguyenLieu> finddsten(String name) {
//	    ArrayList<NguyenLieu> dskh = new ArrayList<NguyenLieu>();
//	    try {
//	        ConnectDB.getInstance();
//	        Connection con = ConnectDB.getConnection();
//	        String sql = "SELECT * FROM NGUYENLIEU WHERE tenNguyenLieu=?";
//	        PreparedStatement statement = con.prepareStatement(sql);
//	        statement.setString(1, name);
//	        // Thực thi câu lệnh SQL và nhận kết quả
//	        ResultSet rs = statement.executeQuery();
//	        // Duyệt qua kết quả trả về
//	        while (rs.next()) {
//	            String maNL = rs.getString(1);
//	            String tenNL = rs.getString(2);
//	            int soLuong = rs.getInt(3);
//	            NguyenLieu nl = new NguyenLieu(maNL, tenNL, soLuong);
//	            dskh.add(nl);
//	        }
//	    } catch (SQLException e) {
//	        e.printStackTrace();
//	    }
//	    return dskh;
//	}
//	

//	public boolean datNL(NguyenLieu nl) {
//		ConnectDB.getInstance();
//	    Connection con = ConnectDB.getConnection();
//	    PreparedStatement stmtGetSoLuong = null;
//	    PreparedStatement stmtUpdateSoLuong = null;
//	    int n = 0;
//	    try {
//	        // Truy vấn để lấy giá trị hiện tại của soLuong
//	        stmtGetSoLuong = con.prepareStatement("SELECT soLuong =? FROM NGUYENLIEU WHERE maNguyenLieu = ?");
//	        stmtGetSoLuong.setString(1, nl.getMaNguyenLieu());
//	        ResultSet rs = stmtGetSoLuong.executeQuery();
//	        int soLuongHienTai = 0;
//	        if (rs.next()) {
//	            soLuongHienTai = rs.getInt("soLuong");
//	        }
//	        
//	        System.out.println(soLuongHienTai);
//	        
//	        // Cập nhật soLuong trong bảng NGUYENLIEU
//	        stmtUpdateSoLuong = con.prepareStatement("UPDATE NGUYENLIEU SET soLuong = ? WHERE maNguyenLieu = ?");
//	        stmtUpdateSoLuong.setInt(1, soLuongHienTai + nl.getSoLuong()); // Cập nhật giá trị mới của soLuong
//	        stmtUpdateSoLuong.setString(2, nl.getMaNguyenLieu());
//	        System.out.println(soLuongHienTai + nl.getSoLuong());
//	        n = stmtUpdateSoLuong.executeUpdate();
//		}catch (SQLException e) {
//			e.printStackTrace();
//			
//		}
//		return n >0;
//	}
	public boolean datNL(NguyenLieu nl) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("update NGUYENLIEU set soLuong =soLuong+? where tenNguyenLieu =? ");
			stmt.setInt(1, nl.getSoLuong());
			System.out.println(nl.getSoLuong());
			stmt.setString(2, nl.getTenNguyenLieu());
			System.out.println(nl.getTenNguyenLieu());
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
