package entity;

import utils.NumericString;

// Class Entitas
public class Pulsa extends Transaksi {
    private VoucherPulsa vPulsa;
    private String kodeVoucher;

    public Pulsa(VoucherPulsa vPulsa, int totalBayar) {
        super("Pembelian Pulsa", vPulsa.getHarga(), totalBayar);
        this.vPulsa = vPulsa;
        this.kodeVoucher = NumericString.generate(16);
    }

    public VoucherPulsa getvPulsa() {
        return vPulsa;
    }

    public void setvPulsa(VoucherPulsa vPulsa) {
        this.vPulsa = vPulsa;
    }

    public String getKodeVoucher() {
        return kodeVoucher;
    }

    public void setKodeVoucher(String kodeVoucher) {
        this.kodeVoucher = kodeVoucher;
    }

}