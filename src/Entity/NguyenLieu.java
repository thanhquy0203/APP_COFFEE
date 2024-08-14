package Entity;

import java.util.Objects;

public class NguyenLieu {
	private String maNguyenLieu;
	private String tenNguyenLieu;
	private int soLuong;
	private String donVi;
	
	
	public NguyenLieu() {
		// TODO Auto-generated constructor stub
	}
	
	public NguyenLieu(String maNguyenLieu) {
		super();
		this.maNguyenLieu=maNguyenLieu;
	}


	public NguyenLieu(String maNguyenLieu, String tenNguyenLieu, int soLuong, String donVi) {
		super();
		this.maNguyenLieu = maNguyenLieu;
		this.tenNguyenLieu = tenNguyenLieu;
		this.soLuong = soLuong;
		this.donVi = donVi;
	}

	public String getMaNguyenLieu() {
		return maNguyenLieu;
	}

	public void setMaNguyenLieu(String maNguyenLieu) {
		this.maNguyenLieu = maNguyenLieu;
	}

	public String getTenNguyenLieu() {
		return tenNguyenLieu;
	}

	public void setTenNguyenLieu(String tenNguyenLieu) {
		this.tenNguyenLieu = tenNguyenLieu;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	
	

	public String getDonVi() {
		return donVi;
	}

	public void setDonVi(String donVi) {
		this.donVi = donVi;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maNguyenLieu);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
//		if (getClass() != obj.getClass())
//			return false;
		NguyenLieu other = (NguyenLieu) obj;
		return Objects.equals(maNguyenLieu, other.maNguyenLieu);
	}

	@Override
	public String toString() {
		return "NguyenLieu [maNguyenLieu=" + maNguyenLieu + ", tenNguyenLieu=" + tenNguyenLieu + ", soLuong=" + soLuong
				+ ", donVi=" + donVi + "]";
	}

	

	
	
	
}
