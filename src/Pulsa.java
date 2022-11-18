
// Class Entitas
public class Pulsa {
    VoucherPulsa vPulsa;
    String kodeVoucher;

    public Pulsa(VoucherPulsa vPulsa, int totalBayar) {
        this.vPulsa = vPulsa;
        this.kodeVoucher = NumericString.generate(16);
    }

}