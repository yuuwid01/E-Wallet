
import java.util.Scanner;

public class LoginPage {
    Scanner scanner = new Scanner(System.in);

    public LoginPage() {
        run();
    }

    public void run() {
        String str = """
                ================= MY-WALLET ==================
                1. Login
                2. Register
                0. Keluar
                ==============================================
                """;
        int menu = -1;

        do {
            System.out.print(str);
            System.out.print("Pilih: ");
            menu = scanner.nextInt();
            scanner.nextLine();

            switch (menu) {
                case 1:
                    loginMenu();
                    break;
                case 2:
                    registerMenu();
                    break;
                case 0:
                    System.out.println("Keluar");
                    break;
                default:
                    System.out.println("Pilihan tidak valid");
                    break;
            }
            System.out.println();
        } while (menu != 0);
    }

    private void registerMenu() {
        String nama, username, password, noTelp, pin;

        do {
            System.out.println("\n----------------- DAFTAR AKUN -----------------");
            System.out.print("Nama      : ");
            nama = scanner.nextLine();

            System.out.print("Username  : ");
            username = scanner.nextLine();

            System.out.print("No Telp   : ");
            noTelp = scanner.nextLine();

            System.out.print("Password  : ");
            password = scanner.nextLine();

            System.out.print("Pin       : ");
            pin = scanner.nextLine();

            User userBaru = new User(nama, username, password, noTelp, pin);

            if (Auth.register(userBaru)) {
                System.out.println("----------------------------------------------");
                System.out.println("Berhasil mendaftarkan akun.");
                System.out.println("----------------------------------------------");
                break;
            } else {
                System.out.println("----------------------------------------------");
                System.out.println("Akun telah terdaftar sebelumnya.");
                System.out.println("----------------------------------------------");
            }
        } while (true);

    }

    private void loginMenu() {
        String username, password;
        boolean status = false;

        do {
            System.out.println("\n-------------------- LOGIN -------------------");

            System.out.print("Username  : ");
            username = scanner.nextLine();

            System.out.print("Password  : ");
            password = scanner.nextLine();

            status = Auth.login(username, password);

            if (status) {
                System.out.println("----------------------------------------------");
                System.out.println("Berhasil Login.");
                System.out.println("----------------------------------------------");
                System.out.println();
                new HomePage();
                break;
            } else {
                System.out.println("----------------------------------------------");
                System.out.println("Username atau password salah.");
                System.out.println("----------------------------------------------");
            }

        } while (status == false);

    }

}
