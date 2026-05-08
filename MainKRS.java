import java.util.Scanner;

public class MainKRS {
    public static void menu() {
        System.out.println("\n=== MENU ANTRIAN KRS ===");
        System.out.println("1. Tambah Antrian");
        System.out.println("2. Proses KRS (2 Mahasiswa)");
        System.out.println("3. Tampilkan Semua Antrian");
        System.out.println("4. Tampilkan 2 Antrian Terdepan");
        System.out.println("5. Tampilkan Antrian Paling Akhir");
        System.out.println("6. Jumlah Antrian");
        System.out.println("7. Jumlah Mahasiswa yang Sudah Melakukan Proses KRS");
        System.out.println("8. Jumlah Mahasiswa yang Belum Melakukan Proses KRS");
        System.out.println("9. Kosongkan Antrian");
        System.out.println("0. Keluar");
        System.out.print("Pilih menu: ");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AntrianKRS antrian = new AntrianKRS(10);

        int pilih;
        do {
            menu();
            pilih = sc.nextInt();
            sc.nextLine();

            switch (pilih) {
                case 1:
                    System.out.print("NIM   : ");
                    String nim = sc.nextLine();
                    System.out.print("Nama  : ");
                    String nama = sc.nextLine();
                    System.out.print("Prodi : ");
                    String prodi = sc.nextLine();
                    System.out.print("Kelas : ");
                    String kelas = sc.nextLine();

                    MahasiswaKRS m = new MahasiswaKRS(nim, nama, prodi, kelas);
                    antrian.enqueue(m);
                    break;

                case 2:
                    antrian.dequeue2();
                    break;

                case 3:
                    antrian.printAll();
                    break;

                case 4:
                    antrian.peekFront2();
                    break;

                case 5:
                    antrian.peekRear();
                    break;

                case 6:
                    antrian.jumlahAntrian();
                    break;

                case 7:
                    antrian.jumlahDiproses();
                    break;

                case 8:
                    antrian.belumProses();
                    break;

                case 9:
                    antrian.clear();
                    break;

                case 0:
                    System.out.println("Program selesai.");
                    break;

                default:
                    System.out.println("Menu tidak valid!");
            }

        } while (pilih != 0);

        sc.close();
    }
}