package Entity;

import java.util.Objects;

public class DoUong {
	private String maDoUong;
	private String tenDoUong;
	private double giaTien;
	private String loaiDoUong;
	
	
	public DoUong() {
		// TODO Auto-generated constructor stub
	}
	
	public DoUong(String maDoUong) {
		super();
		this.maDoUong=maDoUong;
	}

	public DoUong(String maDoUong, String tenDoUong, double giaTien, String loaiDoUong) {
		super();
		this.maDoUong = maDoUong;
		this.tenDoUong = tenDoUong;
		this.giaTien = giaTien;
		this.loaiDoUong = loaiDoUong;
	}

	public String getMaDoUong() {
		return maDoUong;
	}

	public void setMaDoUong(String maDoUong) {
		this.maDoUong = maDoUong;
	}

	public String getTenDoUong() {
		return tenDoUong;
	}

	public void setTenDoUong(String tenDoUong) {
		this.tenDoUong = tenDoUong;
	}

	public double getGiaTien() {
		return giaTien;
	}

	public void setGiaTien(double giaTien) {
		this.giaTien = giaTien;
	}

	public String getLoaiDoUong() {
		return loaiDoUong;
	}

	public void setLoaiDoUong(String loaiDoUong) {
		this.loaiDoUong = loaiDoUong;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maDoUong);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
//		if (getClass() != obj.getClass())
//			return false;
		DoUong other = (DoUong) obj;
		return Objects.equals(maDoUong, other.maDoUong);
	}

	@Override
	public String toString() {
		return "DoUong [maDoUong=" + maDoUong + ", tenDoUong=" + tenDoUong + ", giaTien=" + giaTien + ", loaiDoUong="
				+ loaiDoUong + "]";
	}
	
	
}
