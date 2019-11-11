package htqlbv_entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
/**
 * 
 * @author 
 * Doãn Trần Tuấn Đạt - 16035741
 * Ngô Tuấn Kiệt      - 16044771
 *
 */
@Entity
public class Thuoc {
	private double DonGia;
	@Id
	private String IDThuoc;
	@Column(columnDefinition = "nvarchar(550)")
	private String TenThuoc;

	@OneToMany(mappedBy = "IDThuoc", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<ChiTietKhoThuoc> chiTietKhoThuocs;

	public Thuoc() {
		super();
	}

	public Thuoc(double donGia, String iDThuoc, String tenThuoc) {
		super();
		DonGia = donGia;
		IDThuoc = iDThuoc;
		TenThuoc = tenThuoc;

	}

	public double getDonGia() {
		return DonGia;
	}

	public void setDonGia(double donGia) {
		DonGia = donGia;
	}

	public String getIDThuoc() {
		return IDThuoc;
	}

	public void setIDThuoc(String iDThuoc) {
		IDThuoc = iDThuoc;
	}

	public String getTenThuoc() {
		return TenThuoc;
	}

	public void setTenThuoc(String tenThuoc) {
		TenThuoc = tenThuoc;
	}

	public List<ChiTietKhoThuoc> getChiTietKhoThuocs() {
		return chiTietKhoThuocs;
	}

	public void setChiTietKhoThuocs(List<ChiTietKhoThuoc> chiTietKhoThuocs) {
		this.chiTietKhoThuocs = chiTietKhoThuocs;
	}

	@Override
	public String toString() {
		return "Thuoc [DonGia=" + DonGia + ", IDThuoc=" + IDThuoc + ", TenThuoc=" + TenThuoc + "]";
	}

}
