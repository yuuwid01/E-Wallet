package entity;

import utils.LocalDate;

public class Transaksi {
    protected String jenisTransaksi;
    protected String tanggalTransaksi;
    protected int nominalHarga;
    protected int totalBayar;

    public Transaksi(String jenisTransaksi, int nominalHarga, int totalBayar) {
        this.jenisTransaksi = jenisTransaksi;
        this.tanggalTransaksi = LocalDate.now();
        this.nominalHarga = nominalHarga;
        this.totalBayar = totalBayar;
    }

    public void dataTransaksi() {
        System.out.println("Jenis Transaksi : " + jenisTransaksi);
        System.out.println("Tgl Transaksi   : " + tanggalTransaksi);
        System.out.println("Nominal Harga   : " + nominalHarga);
        System.out.println("Total Bayar     : " + totalBayar);
    }

    public String getJenisTransaksi() {
        return jenisTransaksi;
    }

    public void setJenisTransaksi(String jenisTransaksi) {
        this.jenisTransaksi = jenisTransaksi;
    }

    public String getTanggalTransaksi() {
        return tanggalTransaksi;
    }

    public void setTanggalTransaksi(String tanggalTransaksi) {
        this.tanggalTransaksi = tanggalTransaksi;
    }

    public int getNominalHarga() {
        return nominalHarga;
    }

    public void setNominalHarga(int nominalHarga) {
        this.nominalHarga = nominalHarga;
    }

    public int getTotalBayar() {
        return totalBayar;
    }

    public void setTotalBayar(int totalBayar) {
        this.totalBayar = totalBayar;
    }

}
