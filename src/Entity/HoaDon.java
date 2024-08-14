package Entity;

import java.time.LocalDate;
import java.util.Objects;

public class HoaDon {
	private String maHoaDon;
	private double tongTien;
	private LocalDate ngayBan;
	private NhanVien maNhanVien;
	private KhachHang maKhachHang;
	private The soThe;
	
	public HoaDon() {
		// TODO Auto-generated constructor stub
	}
	
	public HoaDon(String maHoaDon) {
		super();
		this.maHoaDon=maHoaDon;
	}

	public HoaDon(String maHoaDon, double tongTien, LocalDate ngayBan, NhanVien maNhanVien, KhachHang maKhachHang,The soThe) {
		super();
		this.maHoaDon = maHoaDon;
		this.tongTien = tongTien;
		this.ngayBan = ngayBan;
		this.maNhanVien = maNhanVien;
		this.maKhachHang=maKhachHang;
		this.soThe = soThe;
	}

	

	public String getMaHoaDon() {
		return maHoaDon;
	}

	public void setMaHoaDon(String maHoaDon) {
		this.maHoaDon = maHoaDon;
	}

	public double getTongTien() {
		return tongTien;
	}

	public void setTongTien(double tongTien) {
		this.tongTien = tongTien;
	}

	public LocalDate getNgayBan() {
		return ngayBan;
	}

	public void setNgayBan(LocalDate ngayBan) {
		this.ngayBan = ngayBan;
	}

	public NhanVien getMaNhanVien() {
		return maNhanVien;
	}

	public void setMaNhanVien(NhanVien maNhanVien) {
		this.maNhanVien = maNhanVien;
	}

	public KhachHang getMaKhachHang() {
		return maKhachHang;
	}

	public void setMaKhachHang(KhachHang maKhachHang) {
		this.maKhachHang = maKhachHang;
	}

	public The getSoThe() {
		return soThe;
	}

	public void setSoThe(The soThe) {
		this.soThe = soThe;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maHoaDon);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
//		if (getClass() != obj.getClass())
//			return false;
		HoaDon other = (HoaDon) obj;
		return Objects.equals(maHoaDon, other.maHoaDon);
	}

	@Override
	public String toString() {
		return "HoaDon [maHoaDon=" + maHoaDon + ", tongTien=" + tongTien + ", ngayBan=" + ngayBan + ", maNhanVien="
				+ maNhanVien + ", maKhachHang=" + maKhachHang + ", soThe=" + soThe + "]";
	}

	
	
}
