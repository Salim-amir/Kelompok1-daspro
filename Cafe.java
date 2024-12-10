import java.util.Scanner;

public class Cafe {
    // Daftar menu
    static String[] menu = {"Kopi Hitam", "Latte", "Teh Tarik", "Mie Goreng"};
    static int[] harga = {15000, 22000, 12000, 10000};

    // Variabel untuk menyimpan semua pesanan
    static int maxPesanan = 100; // Batas maksimal pesanan
    static String[][] pesanan = new String[maxPesanan][4]; // [nama pelanggan, nomor meja, nama menu, jumlah item]
    static int[] totalHargaPesanan = new int[maxPesanan];
    static int jumlahPesanan = 0; // Jumlah pesanan yang sudah dicatat

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Menu utama
            System.out.println("\n===== MENU UTAMA =====");
            System.out.println("1. Tambahkan Pesanan");
            System.out.println("2. Tampilkan Daftar Pesanan");
            System.out.println("3. Keluar");
            System.out.print("Pilih menu: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine(); // Membersihkan buffer

            if (pilihan == 1) {
                tambahPesanan(scanner);
            } else if (pilihan == 2) {
                tampilkanPesanan();
            } else if (pilihan == 3) {
                System.out.println("Terima kasih! Program selesai.");
                break;
            } else {
                System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }

        scanner.close();
    }

    // Fungsi untuk menampilkan daftar menu
    public static void tampilkanMenu() {
        System.out.println("\n===== MENU KAFE =====");
        for (int i = 0; i < menu.length; i++) {
            System.out.println((i + 1) + ". " + menu[i] + " = Rp " + harga[i]);
        }
    }

    // Fungsi untuk menambahkan pesanan
    public static void tambahPesanan(Scanner scanner) {
        if (jumlahPesanan >= maxPesanan) {
            System.out.println("Pesanan penuh! Tidak dapat menambah pesanan lagi.");
            return;
        }

        // Input data pelanggan
        System.out.print("Masukkan nama pelanggan: ");
        String namaPelanggan = scanner.nextLine();
        System.out.print("Masukkan nomor meja: ");
        String nomorMeja = scanner.nextLine();

        int totalHarga = 0;

        while (true) {
            tampilkanMenu();
            System.out.print("Pilih menu (masukkan nomor menu, atau 0 untuk selesai): ");
            int pilihanMenu = scanner.nextInt();

            if (pilihanMenu == 0) {
                break;
            }

            if (pilihanMenu < 1 || pilihanMenu > menu.length) {
                System.out.println("Nomor menu tidak valid. Silakan coba lagi.");
                continue;
            }

            System.out.print("Masukkan jumlah item untuk " + menu[pilihanMenu - 1] + ": ");
            int jumlahItem = scanner.nextInt();

            if (jumlahItem <= 0) {
                System.out.println("Jumlah item harus lebih dari 0. Silakan coba lagi.");
                continue;
            }

            // Menyimpan pesanan
            pesanan[jumlahPesanan][0] = namaPelanggan;
            pesanan[jumlahPesanan][1] = nomorMeja;
            pesanan[jumlahPesanan][2] = menu[pilihanMenu - 1];
            pesanan[jumlahPesanan][3] = String.valueOf(jumlahItem);

            int hargaPesanan = jumlahItem * harga[pilihanMenu - 1];
            totalHargaPesanan[jumlahPesanan] = hargaPesanan;
            totalHarga += hargaPesanan;

            jumlahPesanan++;
        }

        System.out.println("Pesanan berhasil ditambahkan.");
        System.out.println("Total harga pesanan: Rp " + totalHarga);
    }

    // Fungsi untuk menampilkan daftar pesanan
    public static void tampilkanPesanan() {
        System.out.println("\n===== DAFTAR PESANAN =====");
        if (jumlahPesanan == 0) {
            System.out.println("Belum ada pesanan.");
            return;
        }

        String currentCustomer = "";
        String currentTable = "";
        int customerTotal = 0;

        for (int i = 0; i < jumlahPesanan; i++) {
            if (!pesanan[i][0].equals(currentCustomer) || !pesanan[i][1].equals(currentTable)) {
                // Jika ada perubahan pelanggan/meja, cetak total pelanggan sebelumnya
                if (!currentCustomer.isEmpty()) {
                    System.out.println("Total: Rp " + customerTotal);
                    System.out.println("--------------------");
                }
                // Set pelanggan baru
                currentCustomer = pesanan[i][0];
                currentTable = pesanan[i][1];
                customerTotal = 0;
                System.out.println("\nPelanggan: " + currentCustomer + " (Meja " + currentTable + ")");
            }
            // Cetak detail pesanan
            System.out.println(pesanan[i][2] + " x " + pesanan[i][3] + " = Rp " + totalHargaPesanan[i]);
            customerTotal += totalHargaPesanan[i];
        }
        // Cetak total untuk pelanggan terakhir
        if (!currentCustomer.isEmpty()) {
            System.out.println("Total: Rp " + customerTotal);
            System.out.println("--------------------");
        }
    }
}