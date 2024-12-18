//SALIM AMIR
//244107060085
//16

import java.util.Scanner;

public class UAS1E16 {
    static final int MAKS_TIM16 = 6; 
    static String[] namaTim16 = new String[MAKS_TIM16];
    static int[] skorLevel116 = new int[MAKS_TIM16];
    static int[] skorLevel216 = new int[MAKS_TIM16];
    static int[] totalSkor16 = new int[MAKS_TIM16];
    static int jumlahTim16 = 0;
    static Scanner scanner16 = new Scanner(System.in);
    
    public static void main(String[] args) {
        int pilihan16;
        do {
            tampilkanMenu16();
            pilihan16 = scanner16.nextInt();
            
            switch (pilihan16) {
                case 1:
                    inputDataTim16();
                    break;
                case 2:
                    tampilkanTabelSkor16();
                    break;
                case 3:
                    tentukanJuara16();
                    break;
                case 4:
                    System.out.println("Program selesai");
                    break;
                default:
                    System.out.println("Menu tidak valid");
            }
        } while (pilihan16 != 4);
    }
    
    public static void tampilkanMenu16() {
        System.out.println("\n=== MENU UTAMA ===");
        System.out.println("1. Input Data Skor Tim");
        System.out.println("2. Tampilkan Tabel Skor");
        System.out.println("3. Tentukan Juara");
        System.out.println("4. Keluar");
        System.out.print("Pilih menu (1-4): ");
    }
    
    public static void inputDataTim16() {
        
        jumlahTim16 = 0;
  
        for (int i = 0; i < MAKS_TIM16; i++) {
            scanner16.nextLine(); 
            System.out.print("Masukkan nama tim ke-" + (i + 1) + ": ");
            String nama16 = scanner16.nextLine();
            
            boolean namaBaru16 = true;
            for (int j = 0; j < jumlahTim16; j++) {
                if (nama16.equals(namaTim16[j])) {
                    namaBaru16 = false;
                    break;
                }
            }
            
            if (!namaBaru16) {
                System.out.println("Nama tim harus berbeda!");
                i--;
                continue;
            }

            int skor116;
            do {
                System.out.print("Masukkan skor " + nama16 + " untuk Level 1: ");
                skor116 = scanner16.nextInt();
                if (skor116 < 0) {
                    System.out.println("Error: Skor harus positif atau nol!");
                }
            } while (skor116 < 0);
  
            if (skor116 < 35) {
                skor116 = 0;
            }
          
            int skor216;
            do {
                System.out.print("Masukkan skor " + nama16 + " untuk Level 2: ");
                skor216 = scanner16.nextInt();
                if (skor216 < 0) {
                    System.out.println("Error: Skor harus positif atau nol!");
                }
            } while (skor216 < 0);
            
            namaTim16[jumlahTim16] = nama16;
            skorLevel116[jumlahTim16] = skor116;
            skorLevel216[jumlahTim16] = skor216;
            totalSkor16[jumlahTim16] = skor116 + skor216;
            jumlahTim16++;
        }
        
        for (int i = 0; i < jumlahTim16; i++) {

            if (totalSkor16[i] % 2 == 0) {
                totalSkor16[i] -= 15;
            }
            
            if (skorLevel116[i] > 50 && skorLevel216[i] > 50) {
                totalSkor16[i] += 16; 
            }
        }
    }
    
    public static void tampilkanTabelSkor16() {
        if (jumlahTim16 == 0) {
            System.out.println("Tidak ada data yang bisa ditampilkan.");
            return;
        }
        
        System.out.println("\nTabel Skor Turnamen");
        System.out.println("Nama Tim \tLevel 1 \tLevel 2 \tTotal Skor");
        
        for (int i = 0; i < jumlahTim16; i++) {
            System.out.printf("%-15s\t%d\t\t%d\t\t%d%n", 
                namaTim16[i], skorLevel116[i], skorLevel216[i], totalSkor16[i]);
        }
    }
    
    public static void tentukanJuara16() {
        if (jumlahTim16 == 0) {
            System.out.println("Tidak ada data yang bisa ditampilkan.");
            return;
        }
        
        int indeksPemenang16 = 0;
        for (int i = 1; i < jumlahTim16; i++) {
            if (totalSkor16[i] > totalSkor16[indeksPemenang16] || 
                (totalSkor16[i] == totalSkor16[indeksPemenang16] && 
                 skorLevel216[i] > skorLevel216[indeksPemenang16])) {
                indeksPemenang16 = i;
            }
        }
        
        boolean adaSeri16 = false;
        for (int i = 0; i < jumlahTim16; i++) {
            if (i != indeksPemenang16 && 
                totalSkor16[i] == totalSkor16[indeksPemenang16] && 
                skorLevel216[i] == skorLevel216[indeksPemenang16]) {
                adaSeri16 = true;
                break;
            }
        }
        
        if (adaSeri16) {
            System.out.println("Turnamen berakhir seri. Tim terbaik adalah Salim");
        } else {
            System.out.println("Selamat kepada Tim " + namaTim16[indeksPemenang16] + 
                             " yang telah memenangkan kompetisi!");
        }
    }
}
