package Entity;

import java.util.Objects;

public class ChiTietHoaDon {
	private HoaDon maHoaDon;
	private DoUong maDoUong;
	private int soLuong;
	private double donGia;
	
	public ChiTietHoaDon() {
		// TODO Auto-generated constructor stub
	}
	
	public ChiTietHoaDon(HoaDon maHoaDon,KhachHang maKhachHang,DoUong maDoUong) {
		super();
		this.maHoaDon=maHoaDon;
		this.maDoUong=maDoUong;
	}

	public ChiTietHoaDon(HoaDon maHoaDon, DoUong maDoUong, int soLuong, double donGia) {
		super();
		this.maHoaDon = maHoaDon;
		this.maDoUong = maDoUong;
		this.soLuong = soLuong;
		this.donGia = donGia;
	}

	public HoaDon getMaHoaDon() {
		return maHoaDon;
	}

	public void setMaHoaDon(HoaDon maHoaDon) {
		this.maHoaDon = maHoaDon;
	}

	public DoUong getMaDoUong() {
		return maDoUong;
	}

	public void setMaDoUong(DoUong maDoUong) {
		this.maDoUong = maDoUong;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public double getDonGia() {
		return donGia;
	}

	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maDoUong, maHoaDon);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
//		if (getClass() != obj.getClass())
//			return false;
		ChiTietHoaDon other = (ChiTietHoaDon) obj;
		return Objects.equals(maDoUong, other.maDoUong) && Objects.equals(maHoaDon, other.maHoaDon);
	}

	@Override
	public String toString() {
		return "ChiTietHoaDon [maHoaDon=" + maHoaDon + ", maDoUong=" + maDoUong + ", soLuong=" + soLuong + ", donGia="
				+ donGia + "]";
	}

	
	
}
