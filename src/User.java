
// Class Entitas
public class User {
    String nama;
    String username, password, noTelp;
    String pin;
    Dompet dompet;

    public User(String nama, String username, String password,
            String noTelp, String pin) {
        this.nama = nama;
        this.username = username;
        this.password = password;
        this.noTelp = noTelp;
        this.pin = pin;
        this.dompet = new Dompet();
    }

    public void dataUser() {
        System.out.println("Nama            : " + nama);
        System.out.println("Username        : " + username);
        System.out.println("Password        : " + password);
        System.out.println("No Telp         : " + noTelp);
        System.out.println("PIN             : " + pin);
        dompet.dataDompet();
    }
}
