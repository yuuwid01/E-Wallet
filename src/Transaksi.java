
// Class Entitas
public class Transaksi {
    String jenisTransaksi;
    String tanggalTransaksi;
    String nominalHarga;
    String totalBayar;

    public Transaksi(String jenisTransaksi, String nominalHarga, String totalBayar) {
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
}
