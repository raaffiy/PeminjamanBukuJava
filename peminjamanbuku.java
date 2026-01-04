import java.util.ArrayList;
import java.util.Scanner;

public class peminjamanbuku {

    ArrayList<String> kodeBuku;
    ArrayList<String> judulBuku;
    ArrayList<String> namaPeminjam;
    ArrayList<Integer> lamaPinjam; 

    public peminjamanbuku() {
        kodeBuku = new ArrayList<>();
        judulBuku = new ArrayList<>();
        namaPeminjam = new ArrayList<>();
        lamaPinjam = new ArrayList<>();
    }

    public void tambahBuku() {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nBerapa buku yang ingin ditambahkan: ");
        int jumlahBuku = sc.nextInt();
        sc.nextLine(); // membersihkan newline
        System.err.println("=============================");

        for (int i = 0; i < jumlahBuku; i++) {
            String kode;

            // Cek agar kode buku tidak boleh sama
            while (true) {
                System.out.print("Masukkan kode buku ke-" + (i + 1) + ": ");
                kode = sc.nextLine();

                if (kodeBuku.contains(kode)) {
                    System.out.println("Kode buku sudah ada! Silakan masukkan kode lain.");
                } else {
                    kodeBuku.add(kode);
                    break;
                }
            }

            System.out.print("Masukkan judul buku: ");
            judulBuku.add(sc.nextLine());

            System.out.print("Masukkan nama peminjam: ");
            namaPeminjam.add(sc.nextLine());

            System.out.print("Masukkan lama pinjam (hari): ");
            lamaPinjam.add(sc.nextInt());
            sc.nextLine(); // membersihkan newline

            System.out.println("\nBuku ke-" + (i + 1) + " berhasil ditambahkan.");
            System.err.println("=============================");
        }
    }

    public void ubahData() {
        Scanner sc = new Scanner(System.in);
        System.err.println("\n=============================");
        System.out.print("Masukkan kode buku yang ingin diubah: ");
        String kode = sc.nextLine();

        int index = kodeBuku.indexOf(kode);
        if (index != -1) {
            System.out.print("Judul buku baru: ");
            judulBuku.set(index, sc.nextLine());

            System.out.print("Nama peminjam baru: ");
            namaPeminjam.set(index, sc.nextLine());

            System.out.print("Lama pinjam baru (hari): ");
            lamaPinjam.set(index, sc.nextInt());

            System.out.println("\nData buku berhasil diubah.");
            System.err.println("=============================");
        } else {
            System.out.println("Buku tidak ditemukan.");
        }
    }

    public void tampilData() {
        System.out.println("\n=== DAFTAR BUKU PINJAMAN ===");
        for (int i = 0; i < kodeBuku.size(); i++) {
            System.out.println(
                "Kode: " + kodeBuku.get(i) +
                ", Judul: " + judulBuku.get(i) +
                ", Peminjam: " + namaPeminjam.get(i) +
                ", Lama Pinjam: " + lamaPinjam.get(i) + " hari"
            );
        }
    }

    public void hapusBuku() {
        Scanner sc = new Scanner(System.in);
        System.err.println("\n=============================");
        System.out.print("Masukkan kode buku yang ingin dihapus: ");
        String kode = sc.nextLine();

        int index = kodeBuku.indexOf(kode);
        if (index != -1) {
            kodeBuku.remove(index);
            judulBuku.remove(index);
            namaPeminjam.remove(index);
            lamaPinjam.remove(index);
            System.out.println("Buku berhasil dihapus.");
        } else {
            System.out.println("Buku tidak ditemukan.");
        }
    }

    public void hitungDenda() {
        Scanner sc = new Scanner(System.in);
        System.err.println("\n=============================");
        System.out.print("Masukkan kode buku: ");
        String kode = sc.nextLine();

        int index = kodeBuku.indexOf(kode);
        if (index != -1) {
            System.out.print("Masukkan jumlah hari keterlambatan: ");
            int telat = sc.nextInt();

            int denda = telat * 2000; 
            System.out.println("Judul Buku: " + judulBuku.get(index));
            System.out.println("Total denda: Rp " + denda);
            System.err.println("=============================");
        } else {
            System.out.println("Buku tidak ditemukan.");
        }
    }

    public void menu() {
        Scanner sc = new Scanner(System.in);
        int pilih;

        do {
            System.out.println("\n=== MENU PERPUSTAKAAN ===");
            System.out.println("1. Tambah Buku Pinjaman");
            System.out.println("2. Ubah Data Buku");
            System.out.println("3. Tampilkan Daftar Buku");
            System.out.println("4. Hapus Buku dari Daftar Pinjaman");
            System.out.println("5. Hitung Denda");
            System.out.println("6. Keluar");
            System.out.print("Pilih menu: ");
            pilih = sc.nextInt();
            sc.nextLine();

            switch (pilih) {
                case 1:
                    tambahBuku();
                    break;
                case 2:
                    ubahData();
                    break;
                case 3:
                    tampilData();
                    break;
                case 4:
                    hapusBuku();
                    break;
                case 5:
                    hitungDenda();
                    break;
                case 6:
                    System.out.println("Terima kasih.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
                }
        } while (pilih != 6);
    }

    public static void main(String[] args) {
        peminjamanbuku app = new peminjamanbuku();
        app.menu();
    }
}
