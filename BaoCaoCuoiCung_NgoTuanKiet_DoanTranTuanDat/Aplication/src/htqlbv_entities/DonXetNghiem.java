package htqlbv_entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * 
 * @author Doãn Trần Tuấn Đạt - 16035741 Ngô Tuấn Kiệt - 16044771
 *
 */
@Entity
public class DonXetNghiem {
	@Id
	private String IDXetNghiem;
	@Column(columnDefinition = "nvarchar(50)")
	private String NoiDung;
	@Column(columnDefinition = "nvarchar(50)")
	private String KetQua;

	@ManyToOne
	@JoinColumn(name = "IdBenhAn", referencedColumnName = "IdBenhAn")
	private BenhAn benhAn;

	public DonXetNghiem() {
		super();
	}

	public DonXetNghiem(String iDXetNghiem, String noiDung, String ketQua, BenhAn benhAn) {
		super();
		IDXetNghiem = iDXetNghiem;
		NoiDung = noiDung;
		KetQua = ketQua;
		this.benhAn = benhAn;
	}

	public String getIDXetNghiem() {
		return IDXetNghiem;
	}

	public void setIDXetNghiem(String iDXetNghiem) {
		IDXetNghiem = iDXetNghiem;
	}

	public String getNoiDung() {
		return NoiDung;
	}

	public void setNoiDung(String noiDung) {
		NoiDung = noiDung;
	}

	public String getKetQua() {
		return KetQua;
	}

	public void setKetQua(String ketQua) {
		KetQua = ketQua;
	}

	public BenhAn getBenhAn() {
		return benhAn;
	}

	public void setBenhAn(BenhAn benhAn) {
		this.benhAn = benhAn;
	}

	@Override
	public String toString() {
		return "DonXetNghiem [IDXetNghiem=" + IDXetNghiem + ", NoiDung=" + NoiDung + ", KetQua=" + KetQua + ", benhAn="
				+ benhAn + "]";
	}

}
