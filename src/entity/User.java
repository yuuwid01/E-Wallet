package entity;

// Class Entitas
public class User {
    private String nama;
    private String username, password, noTelp;
    private String pin;
    private Dompet dompet;

    public User() {
    }

    public User(String nama, String username, String password, String noTelp, String pin) {
        this.nama = nama;
        this.username = username;
        this.password = password;
        this.noTelp = noTelp;
        this.pin = pin;
        this.dompet = new Dompet();
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNoTelp() {
        return noTelp;
    }

    public void setNoTelp(String noTelp) {
        this.noTelp = noTelp;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public Dompet getDompet() {
        return dompet;
    }

    public void setDompet(Dompet dompet) {
        this.dompet = dompet;
    }

}
