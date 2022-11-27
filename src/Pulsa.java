
// Class Entitas
public class Pulsa extends Transaksi {
    VoucherPulsa vPulsa;
    String kodeVoucher;

    public Pulsa(VoucherPulsa vPulsa, int totalBayar) {
        super("Pembelian Pulsa", vPulsa.harga, totalBayar);
        this.vPulsa = vPulsa;
        this.kodeVoucher = NumericString.generate(16);
    }

}