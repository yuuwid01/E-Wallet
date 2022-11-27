import java.util.ArrayList;

// Class Entitas
public class Dompet {
    int pemasukan = 0;
    int pengeluaran = 0;
    Saldo saldo = new Saldo();
    ArrayList<Transaksi> daftarTransaksi = new ArrayList<>();

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
}
