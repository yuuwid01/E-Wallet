package entity;

public class VoucherPulsa {
    private String title;
    private int harga;

    public VoucherPulsa(String title, int harga) {
        this.title = title;
        this.harga = harga;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

}
