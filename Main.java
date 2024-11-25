import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

// Parent class untuk transaksi
class Transaksi {
    protected String noFaktur;
    protected String kodeBarang;
    protected String namaBarang;
    protected double hargaBarang;
    protected int jumlahBeli;

    // Constructor
    public Transaksi(String noFaktur, String kodeBarang, String namaBarang, double hargaBarang, int jumlahBeli) {
        this.noFaktur = noFaktur;
        this.kodeBarang = kodeBarang;
        this.namaBarang = namaBarang;
        this.hargaBarang = hargaBarang;
        this.jumlahBeli = jumlahBeli;
    }

    // Method untuk menghitung total harga
    public double hitungTotal() {
        return hargaBarang * jumlahBeli;
    }
}

// Subclass untuk menangani validasi dan exception handling
class ValidasiTransaksi extends Transaksi {
    public ValidasiTransaksi(String noFaktur, String kodeBarang, String namaBarang, double hargaBarang, int jumlahBeli) {
        super(noFaktur, kodeBarang, namaBarang, hargaBarang, jumlahBeli);
    }

    // Method untuk memvalidasi data input
    public void validasiData() throws IllegalArgumentException {
        if (hargaBarang < 0) {
            throw new IllegalArgumentException("Harga barang tidak boleh negatif.");
        }
        if (jumlahBeli <= 0) {
            throw new IllegalArgumentException("Jumlah beli harus lebih dari 0.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); // Format tanggal dan waktu

        // Login
        boolean loginBerhasil = false;
        while (!loginBerhasil) {
            System.out.println("+-----------------------------------------------------+");
            System.out.println("Log in");
            System.out.print("Username : ");
            String username = scanner.nextLine();
            System.out.print("Password : ");
            String password = scanner.nextLine();
            System.out.print("Captcha  : ");
            String captcha = scanner.nextLine();

            // Validasi login menggunakan metode equalsIgnoreCase() untuk mencocokkan string
            if (username.equalsIgnoreCase("kasir") && password.equals("kasir1") && captcha.equalsIgnoreCase("VWXYZ")) {
                System.out.println("Login berhasil");
                loginBerhasil = true;
            } else {
                System.out.println("Login gagal, silakan coba lagi.");
            }
            System.out.println("+-----------------------------------------------------+");
        }

        // Header Supermarket
        System.out.println("Selamat Datang di Supermarket 7Eleven");
        Date now = new Date(); // Mendapatkan waktu saat ini
        System.out.println("Tanggal dan Waktu : " + dateFormat.format(now)); // Format waktu menggunakan format()

        try {
            // Input data transaksi
            System.out.print("Masukkan No Faktur      : ");
            String noFaktur = scanner.nextLine();
            System.out.print("Masukkan Kode Barang    : ");
            String kodeBarang = scanner.nextLine();
            System.out.print("Masukkan Nama Barang    : ");
            String namaBarang = scanner.nextLine();
            System.out.print("Masukkan Harga Barang   : ");
            double hargaBarang = scanner.nextDouble();
            System.out.print("Masukkan Jumlah Beli    : ");
            int jumlahBeli = scanner.nextInt();

            // Membuat objek ValidasiTransaksi
            ValidasiTransaksi transaksi = new ValidasiTransaksi(noFaktur, kodeBarang, namaBarang, hargaBarang, jumlahBeli);

            // Validasi data
            transaksi.validasiData();

            // Menghitung total harga
            double totalHarga = transaksi.hitungTotal();

            // Menampilkan detail transaksi
            System.out.println("+-----------------------------------------------------+");
            System.out.println("No. Faktur      : " + noFaktur);

            // Menggunakan toUpperCase() untuk memformat kode barang menjadi huruf besar
            System.out.println("Kode Barang     : " + kodeBarang.toUpperCase());

            // Menampilkan nama barang
            System.out.println("Nama Barang     : " + namaBarang);

            // Menampilkan harga dan total
            System.out.println("Harga Barang    : Rp " + hargaBarang);
            System.out.println("Jumlah Beli     : " + jumlahBeli);
            System.out.println("TOTAL           : Rp " + totalHarga);
            System.out.println("+-----------------------------------------------------+");

            // Kasir
            String kasir = "Kasir Nana";
            System.out.println("Kasir : " + kasir);
            System.out.println("+-----------------------------------------------------+");

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Terjadi kesalahan: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
