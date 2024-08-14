package Entity;

import java.util.Objects;

public class ChiTietDoUong {
	private DoUong maDoUong;
	private NguyenLieu maNguyenLieu;
	private int soLuong;
	
	public ChiTietDoUong() {
		// TODO Auto-generated constructor stub
	}
	
	public ChiTietDoUong(DoUong maDoUong,NguyenLieu maNguyenLieu) {
		super();
		this.maDoUong=maDoUong;
		this.maNguyenLieu=maNguyenLieu;
	}

	public ChiTietDoUong(DoUong maDoUong, NguyenLieu maNguyenLieu, int soLuong) {
		super();
		this.maDoUong = maDoUong;
		this.maNguyenLieu = maNguyenLieu;
		this.soLuong = soLuong;
	}

	public DoUong getMaDoUong() {
		return maDoUong;
	}

	public void setMaDoUong(DoUong maDoUong) {
		this.maDoUong = maDoUong;
	}

	public NguyenLieu getMaNguyenLieu() {
		return maNguyenLieu;
	}

	public void setMaNguyenLieu(NguyenLieu maNguyenLieu) {
		this.maNguyenLieu = maNguyenLieu;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maDoUong, maNguyenLieu);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
//		if (getClass() != obj.getClass())
//			return false;
		ChiTietDoUong other = (ChiTietDoUong) obj;
		return Objects.equals(maDoUong, other.maDoUong) && Objects.equals(maNguyenLieu, other.maNguyenLieu);
	}

	@Override
	public String toString() {
		return "ChiTietSanPham [maDoUong=" + maDoUong + ", maSanPham=" + maNguyenLieu + ", soLuong=" + soLuong + "]";
	}
	
	
}