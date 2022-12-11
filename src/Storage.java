
import java.util.ArrayList;

import entity.VoucherPulsa;
import utils.Rupiah;

public class Storage {
    private static ArrayList<VoucherPulsa> pulsaList = new ArrayList<>();

    public static void setInitialItem() {
        pulsaList.add(new VoucherPulsa("Voucher 5.000", 6000));
        pulsaList.add(new VoucherPulsa("Voucher 10.000", 11000));
        pulsaList.add(new VoucherPulsa("Voucher 20.000", 21000));
        pulsaList.add(new VoucherPulsa("Voucher 25.000", 26000));
        pulsaList.add(new VoucherPulsa("Voucher 50.000", 51000));
    }

    public static ArrayList<VoucherPulsa> getPulsaList() {
        return pulsaList;
    }

    public static void lihatItemPulsa() {
        int i = 1;

        for (VoucherPulsa pulsa : pulsaList) {
            System.out.println(i + ". "
                    + pulsa.getTitle()
                    + " (Rp." + Rupiah.format(pulsa.getHarga())
                    + ")");
            i += 1;
        }

        System.out.println();
    }

}
