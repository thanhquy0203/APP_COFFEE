package Entity;

import java.util.Objects;

public class The {
	private int soThe;
	private String tinhTrang;
	
	public The() {
		// TODO Auto-generated constructor stub
	}
	
	public The(int soThe) {
		super();
		this.soThe = soThe;
	}

	public The(int soThe, String tinhTrang) {
		super();
		this.soThe = soThe;
		this.tinhTrang = tinhTrang;
	}

	public int getSoThe() {
		return soThe;
	}

	public void setSoThe(int soThe) {
		this.soThe = soThe;
	}

	public String getTinhTrang() {
		return tinhTrang;
	}

	public void setTinhTrang(String tinhTrang) {
		this.tinhTrang = tinhTrang;
	}

	@Override
	public int hashCode() {
		return Objects.hash(soThe);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
//		if (getClass() != obj.getClass())
//			return false;
		The other = (The) obj;
		return soThe == other.soThe;
	}

	@Override
	public String toString() {
		return "The [soThe=" + soThe + ", tinhTrang=" + tinhTrang + "]";
	}

	
}
