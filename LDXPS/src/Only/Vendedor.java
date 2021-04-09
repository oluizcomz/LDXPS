/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Only;

/**
 *
 * @author luizn
 */
public class Vendedor {

	private String CDVEND;
	private String DSNOME;
	private int CDTAB;
	private String DTNASC;

	public Vendedor(String CDVEND, String DSNOME, int CDTAB, String DTNASC) {
		this.CDVEND = CDVEND;
		this.DSNOME = DSNOME;
		this.CDTAB = CDTAB;
		this.DTNASC = DTNASC;

	}

	public String getDTNASC() {
		return DTNASC;
	}

	public void setDTNASC(String DTNASC) {
		this.DTNASC = DTNASC;
	}

	public String getCDVEND() {
		return CDVEND;
	}

	public void setCDVEND(String CDVEND) {
		this.CDVEND = CDVEND;
	}

	public String getDSNOME() {
		return DSNOME;
	}

	public void setDSNOME(String DSNOME) {
		this.DSNOME = DSNOME;
	}

	public int getCDTAB() {
		return CDTAB;
	}

	public void setCDTAB(int CDTAB) {
		this.CDTAB = CDTAB;
	}

}
