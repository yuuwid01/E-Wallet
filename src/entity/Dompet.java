package entity;

import java.util.ArrayList;

// Class Entitas
public class Dompet {
    private int pemasukan = 0;
    private int pengeluaran = 0;
    private Saldo saldo = new Saldo();
    private ArrayList<Transaksi> daftarTransaksi = new ArrayList<>();

    public Dompet() {
    }

    public Dompet(int pemasukan) {
        this.pemasukan = pemasukan;
    }

    public void tambahTransaksi(Transaksi transaksi) {
        if (transaksi instanceof TopUp) {
            pemasukan += transaksi.nominalHarga;
        } else {
            pengeluaran += transaksi.totalBayar;
        }
        daftarTransaksi.add(transaksi);
    }

    public int getPemasukan() {
        return pemasukan;
    }

    public void setPemasukan(int pemasukan) {
        this.pemasukan = pemasukan;
    }

    public int getPengeluaran() {
        return pengeluaran;
    }

    public void setPengeluaran(int pengeluaran) {
        this.pengeluaran = pengeluaran;
    }

    public Saldo getSaldo() {
        return saldo;
    }

    public void setSaldo(Saldo saldo) {
        this.saldo = saldo;
    }

    public ArrayList<Transaksi> getDaftarTransaksi() {
        return daftarTransaksi;
    }

    public void setDaftarTransaksi(ArrayList<Transaksi> daftarTransaksi) {
        this.daftarTransaksi = daftarTransaksi;
    }

}
