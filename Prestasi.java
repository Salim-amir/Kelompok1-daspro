import java.util.ArrayList;
import java.util.Scanner;

public class Prestasi {

    static ArrayList<String[]> dataPrestasi = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int pilihan;

        do {
            System.out.println("=== PENCAATAN PRESTASI MAHASISWA ===");
            System.out.println("1. Tambah Data Prestasi");
            System.out.println("2. Tampilkan Semua Prestasi");
            System.out.println("3. Analisis Prestasi Berdasarkan Jenis");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = scanner.nextInt();
            scanner.nextLine(); 

            switch (pilihan) {
                case 1:
                    tambahDataPrestasi(scanner);
                    break;
                case 2:
                    tampilkanSemuaPrestasi();
                    break;
                case 3:
                    analisisPrestasiBerdasarkanJenis(scanner);
                    break;
                case 4:
                    System.out.println("Keluar program.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        } while (pilihan != 4);
    }

    public static void tambahDataPrestasi(Scanner scanner) {
        System.out.print("Masukkan Nama Mahasiswa: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan NIM Mahasiswa: ");
        String nim = scanner.nextLine();
        System.out.print("Masukkan Jenis Prestasi: ");
        String jenis = scanner.nextLine();
        
        String tingkat;
        while (true) {
            System.out.print("Masukkan Tingkat Prestasi (Lokal/Nasional/Internasional): ");
            tingkat = scanner.nextLine();
            if (tingkat.equalsIgnoreCase("Lokal") || tingkat.equalsIgnoreCase("Nasional") || 
                tingkat.equalsIgnoreCase("Internasional")) {
                break;
            } else {
                System.out.println("Tingkat prestasi tidak valid. Harap masukkan Lokal, Nasional, atau Internasional.");
            }
        }

        int tahun;
        while (true) {
            System.out.print("Masukkan Tahun Prestasi (2010 - 2024): ");
            tahun = scanner.nextInt();
            scanner.nextLine(); 
            if (tahun >= 2010 && tahun <= 2024) {
                break;
            } else {
                System.out.println("Tahun tidak valid. Coba lagi.");
            }
        }

    
        dataPrestasi.add(new String[]{nama, nim, jenis, tingkat, String.valueOf(tahun)});
        System.out.println("Data prestasi berhasil ditambahkan.\n");
    }

    public static void tampilkanSemuaPrestasi() {
        System.out.println("\n=== DAFTAR SEMUA PRESTASI ===");
        if (dataPrestasi.isEmpty()) {
            System.out.println("Belum ada data prestasi.");
        } else {
            for (String[] prestasi : dataPrestasi) {
                System.out.printf("Nama: %s | NIM: %s | Jenis: %s | Tingkat: %s | Tahun: %s\n",
                        prestasi[0], prestasi[1], prestasi[2], prestasi[3], prestasi[4]);
            }
        }
        System.out.println();
    }

    public static void analisisPrestasiBerdasarkanJenis(Scanner scanner) {
        System.out.print("Masukkan Jenis Prestasi yang Dicari: ");
        String jenisDicari = scanner.nextLine();
        System.out.println("\n=== ANALISIS PRESTASI BERDASARKAN JENIS ===");
        boolean ditemukan = true;
        for (String[] prestasi : dataPrestasi) {
            if (prestasi[2].equalsIgnoreCase(jenisDicari)) {
                System.out.printf("Nama: %s | NIM: %s | Jenis: %s | Tingkat: %s | Tahun: %s\n",
                        prestasi[0], prestasi[1], prestasi[2], prestasi[3], prestasi[4]);
                ditemukan = false;
            }
        }
        if (!ditemukan) {
            System.out.println("Tidak ada data dengan jenis prestasi tersebut.");
        }
        System.out.println();
    }
}