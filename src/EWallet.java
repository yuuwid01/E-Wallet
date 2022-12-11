import java.util.ArrayList;

import entity.TopUp;
import entity.Transaksi;
import entity.User;

// Class Core (Inti)
public class EWallet {
    private static ArrayList<User> akunTerdaftar = new ArrayList<>();

    public static void initialUser() {
        User user = new User("Test", "user", "1", "081", "123");

        Auth.register(user);

    }

    public static int cekSaldo(User user) {
        return user.getDompet().getSaldo().getSaldo();
    }

    public static void topUp(User user, TopUp transaksi) {
        user.getDompet().tambahTransaksi(transaksi);
        user.getDompet().getSaldo().tambahSaldo(transaksi.getNominalHarga());
    }

    public static boolean beliPulsa(User user, Transaksi transaksi) {
        boolean status = user.getDompet().getSaldo().ambilSaldo(transaksi.getNominalHarga());
        if (status) {
            user.getDompet().tambahTransaksi(transaksi);
        }
        return status;
    }

    public static ArrayList<User> getAkunTerdaftar() {
        return akunTerdaftar;
    }

}