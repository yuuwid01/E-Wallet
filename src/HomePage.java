
import java.util.Scanner;

public class HomePage {
    private Scanner scanner = new Scanner(System.in);

    public HomePage() {
        run();
    }

    private void run() {
        String str = """
                ================= MY-WALLET ==================
                1. Beli Pulsa
                3. Cek Saldo
                4. TopUp
                5. Lihat Transaksi
                6. Profil
                0. Keluar
                ==============================================
                """;

        int menu = -1;

        do {
            System.out.print(str);
            System.out.print("Pilih: ");
            menu = scanner.nextInt();
            scanner.nextLine();

            switchMenu(menu);

        } while (menu != 0);

    }

    private void switchMenu(int menu) {

        switch (menu) {
            case 1:
                beliPulsa();
                break;
            case 2:
                System.out.println();
                break;
            case 3:
                cekSaldo();
                break;
            case 4:
                topUpMenu();
                break;
            case 5:
                lihatTransaksi();
                break;
            case 6:

                break;
            case 0:
                System.out.println("Keluar");
                break;
            default:
                System.out.println("Pilihan tidak valid");
                break;
        }
    }

    private void beliPulsa() {
        Storage.lihatItemPulsa();
        User akun = Auth.getUserLogged();
        int pilih = -1;

        x: do {
            System.out.println("-------------------- PULSA -------------------");
            System.out.println("Masukan -1 untuk membatalkan.");

            System.out.print("Pilih: ");
            pilih = scanner.nextInt();
            scanner.nextLine();

            if (pilih == -1) {
                System.out.println("----------------------------------------------");
                System.out.println();
                break x;
            }

            if (pilih > Storage.getPulsaList().size()) {
                System.out.println("Tidak ada Nominal Pulsa yang dipilih");
                System.out.println("----------------------------------------------");
                System.out.println();
            } else {
                VoucherPulsa pulsa = Storage.getPulsaList().get(pilih - 1);
                int totalHarga = pulsa.harga;

                int percobaan = 3;
                do {
                    System.out.print("Masukan PIN: ");
                    String pin = scanner.nextLine();

                    if (Auth.verifPin(pin)) {
                        if (akun.dompet.saldo.saldo >= totalHarga) {
                            Pulsa transaksiBaru = new Pulsa(pulsa, totalHarga);

                            EWallet.beliPulsa(akun, transaksiBaru);

                            System.out.println("Kamu telah membeli Voucher Pulsa senilai Rp."
                                    + Rupiah.format(pulsa.harga));
                            System.out.println("Voucher        : " + pulsa.title);
                            System.out.println("Seharga        : Rp." + Rupiah.format(pulsa.harga));
                            System.out.println("Total          : Rp." + Rupiah.format(totalHarga));
                            System.out.println("Kode Voucer    : " + transaksiBaru.kodeVoucher);
                            System.out.println("----------------------------------------------");
                            System.out.print("Lanjut...");
                            scanner.nextLine();
                            System.out.println();
                            break x;

                        } else {
                            System.out.println("Saldo anda tidak cukup!");
                            System.out.println("----------------------------------------------");
                            System.out.print("Lanjut...");
                            scanner.nextLine();
                            System.out.println();
                            break x;
                        }
                    } else {
                        percobaan -= 1;
                        System.out.println("PIN SALAH");
                        if (percobaan == 0) {
                            System.out.println("Kamu telah salah memasukan PIN sebanyak 3x");
                            System.out.println("Silakan coba lagi.");
                            System.out.println();
                            break x;
                        }
                        System.out.println();
                    }

                } while (percobaan > 0);
            }
        } while (pilih != -1);

    }

    private void topUpMenu() {
        User akun = Auth.getUserLogged();

        int nominal = 0;

        do {
            System.out.println("------------------- TOP UP -------------------");
            System.out.println("Masukan -1 untuk membatalkan.");

            System.out.print("Masukan Nominal: Rp. ");
            nominal = scanner.nextInt();
            scanner.nextLine();

            if (nominal >= 10000) {
                TopUp topUp = new TopUp(nominal);

                EWallet.topUp(akun, topUp);

                System.out.printf("Top up senilai Rp.%s berhasil.\n", Rupiah.format(nominal));
                System.out.println("----------------------------------------------");

                System.out.print("Lanjut...");
                scanner.nextLine();

                System.out.println();
                break;
            } else {
                System.out.println("Mininal top up harus diatas Rp.10.000");
                System.out.println("----------------------------------------------");
                System.out.println();
            }

        } while (nominal != -1);
    }

    private void cekSaldo() {
        System.out.println("------------------- CEK SALDO ----------------");
        User akun = Auth.getUserLogged();

        int percobaan = 3;
        do {
            System.out.print("Masukan PIN: ");
            String pin = scanner.nextLine();

            if (Auth.verifPin(pin)) {
                int saldo = akun.dompet.saldo.saldo;
                int pemasukan = akun.dompet.pemasukan;
                int pengeluaran = akun.dompet.pengeluaran;
                System.out.printf("Pemasukan      : Rp.%s\n", Rupiah.format(pemasukan));
                System.out.printf("Pengeluaran    : Rp.%s\n", Rupiah.format(pengeluaran));
                System.out.printf("Saldo saat ini : Rp.%s\n", Rupiah.format(saldo));
                System.out.println("----------------------------------------------");
                System.out.print("Lanjut...");
                scanner.nextLine();
                System.out.println();
                break;
            } else {
                percobaan -= 1;
                System.out.println("PIN SALAH");
                if (percobaan == 0) {
                    System.out.println("Kamu telah salah memasukan PIN sebanyak 3x");
                    System.out.println("Silakan coba lagi.");
                }
                System.out.println();
            }
        } while (percobaan > 0);
    }

    private void lihatTransaksi() {
        User akun = Auth.getUserLogged();
        Dompet dompet = akun.dompet;

        System.out.println("------------------ TRANSAKSI -----------------");

        for (Transaksi pembelian : dompet.daftarTransaksi) {

            if (pembelian instanceof Pulsa) {
                Pulsa pulsa = (Pulsa) pembelian;
                System.out.println("Tanggal Pembelian  : " + pembelian.tanggalTransaksi);
                System.out.println("Pulsa              : Rp." + pulsa.vPulsa.title);
                System.out.println("Harga              : Rp." + Rupiah.format(pulsa.vPulsa.harga));
                System.out.println("Bayar              : Rp." + Rupiah.format(pembelian.totalBayar));
                System.out.println("Kode Voucher       : " + pulsa.kodeVoucher);
            } else {
                System.out.println("Tanggal TopUp      : " + pembelian.tanggalTransaksi);
                System.out.println("Nominal TopUp      : Rp." + pembelian.nominalHarga);
            }
            System.out.println("----------------------------------------------");
        }
    }

}
