package com.example.kopral.konverter;

public class KonversiHrf_Ee {
    private boolean cecek;
    CekJenisHuruf cjh;
    private boolean gantungan;
    private int indeksHuruf;
    private int indexHrfKonversi;
    private String[] tempHasilKonversi;
    private char[] tempKalimat;

    public void setCecek(boolean cck) {
        this.cecek = cck;
    }

    public KonversiHrf_Ee() {
        this.indexHrfKonversi = 0;
        this.indeksHuruf = 0;
        this.gantungan = false;
        this.cecek = false;
        this.cjh = new CekJenisHuruf();
        this.indexHrfKonversi = 0;
        this.indeksHuruf = 0;
        this.tempHasilKonversi = new String[0];
        this.tempKalimat = new char[0];
    }

    public KonversiHrf_Ee(int xIndeksHrfKonversi, int xIndeksHurufKe, char[] xTempKalimat, String[] xTempHasilKonversi) {
        this.indexHrfKonversi = 0;
        this.indeksHuruf = 0;
        this.gantungan = false;
        this.cecek = false;
        this.cjh = new CekJenisHuruf();
        this.indexHrfKonversi = xIndeksHrfKonversi;
        this.indeksHuruf = xIndeksHurufKe;
        this.tempHasilKonversi = xTempHasilKonversi;
        this.tempKalimat = xTempKalimat;
    }

    public void setGantungan(boolean gntg) {
        this.gantungan = gntg;
    }

    public boolean kndsGantungan() {
        return this.gantungan;
    }

    public void setTempHasilKonversi(String[] xTempHasilKonversi) {
        this.tempHasilKonversi = xTempHasilKonversi;
    }

    public String[] getTempHasilKonversi() {
        return this.tempHasilKonversi;
    }

    public void setTempKalimat(char[] xTempKalimat) {
        this.tempKalimat = xTempKalimat;
    }

    public char[] getTempKalimat() {
        return this.tempKalimat;
    }

    public void setIndeksHrfKonversi(int xIndeksHrfKonversi) {
        this.indexHrfKonversi = xIndeksHrfKonversi;
    }

    public int getIndexHrfKonversi() {
        return this.indexHrfKonversi;
    }

    public void setIndeksHuruf(int xIndeksHurufKe) {
        this.indeksHuruf = xIndeksHurufKe;
    }

    public int getIndexHuruf() {
        return this.indeksHuruf;
    }

    public void konversi_Ee() {
        if (this.indeksHuruf == 0) {
            this.tempHasilKonversi[this.indexHrfKonversi] = ")";
            this.indexHrfKonversi++;
        } else if (this.tempKalimat[this.indeksHuruf - 1] == ' ') {
            if (this.cjh.cekJenisHurufVokal(this.tempKalimat[this.indeksHuruf - 2]) || this.cecek || this.tempKalimat[this.indeksHuruf - 2] == 'h' || this.tempKalimat[this.indeksHuruf - 2] == 'r') {
                this.tempHasilKonversi[this.indexHrfKonversi] = "h)";
                this.indexHrfKonversi++;
            } else {
                this.tempHasilKonversi[this.indexHrfKonversi] = "\u00c0)";
                this.indexHrfKonversi++;
            }
        } else if (this.indeksHuruf != this.tempKalimat.length - 2 && this.tempKalimat[this.indeksHuruf + 1] == 'n' && this.tempKalimat[this.indeksHuruf + 2] == 'g') {
            this.tempHasilKonversi[this.indexHrfKonversi] = "%";
            this.indeksHuruf += 2;
            this.indexHrfKonversi++;
        } else if (this.tempKalimat[this.indeksHuruf + 1] == 'r') {
            if (!this.cjh.cekJenisHurufVokal(this.tempKalimat[this.indeksHuruf + 2]) || this.indeksHuruf == this.tempKalimat.length - 2) {
                this.tempHasilKonversi[this.indexHrfKonversi] = "$";
                this.indeksHuruf++;
                this.indexHrfKonversi++;
            } else {
                this.tempHasilKonversi[this.indexHrfKonversi] = ")";
                this.indexHrfKonversi++;
            }
        } else if (this.cjh.cekJenisHurufVokal(this.tempKalimat[this.indeksHuruf - 1]) || this.cecek) {
            this.tempHasilKonversi[this.indexHrfKonversi] = "h)";
            this.indexHrfKonversi++;
        } else {
            this.tempHasilKonversi[this.indexHrfKonversi] = ")";
            this.indexHrfKonversi++;
        }
        this.gantungan = false;
        this.cecek = false;
    }
}
