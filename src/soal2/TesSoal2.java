package soal2;

/**
 * Kelas pengujian untuk menganalisis urutan constructor, error kompilasi/runtime,
 * polimorfisme, upcasting, downcasting, serta relasi is-a pada Soal 2.
 * 
 * @author Muhammad Fathir
 */
public class TesSoal2 {
    /**
     * Konstruktor privat untuk mencegah instansiasi kelas utilitas pengujian.
     */
    private TesSoal2() {
        // Tidak diinstansiasi
    }

    /**
     * Titik masuk utama program untuk menjalankan simulasi Bagian A, Bagian B, dan Bagian C.
     *
     * @param args argumen baris perintah
     */
    public static void main(String[] args) {
        System.out.println("=== SOAL 2 BAGIAN A ===");
        Hewan h = new Kucing("Tom");
        h.makan();
        h.suara();
        // h.panjat(); // Menyebabkan compiler error jika diaktifkan karena tipe statis h adalah Hewan

        Kucing k = (Kucing) h; // Upcast yang aman karena objek sebenarnya adalah Kucing
        k.panjat();

        Hewan h2 = new Hewan("Generik");

        // Demonstrasi Exception sebelum perbaikan:
        try {
            System.out.println("\n[Uji Downcasting Tanpa Pengecekan]");
            Kucing k2 = (Kucing) h2; // Menyebabkan ClassCastException pada runtime
            k2.panjat();
        } catch (ClassCastException e) {
            System.out.println("Tertangkap ClassCastException: " + e.getMessage());
        }

        // Perbaikan aman sesuai Pertanyaan 3 menggunakan instanceof:
        System.out.println("\n[Uji Downcasting Aman dengan instanceof]");
        if (h2 instanceof Kucing) {
            Kucing k2 = (Kucing) h2;
            k2.panjat();
        } else {
            System.out.println("Objek h2 bukan merupakan instance dari Kucing, downcasting dibatalkan secara aman.");
        }

        System.out.println("\n=== SOAL 2 BAGIAN B ===");
        new B();

        System.out.println("\n=== SOAL 2 BAGIAN C ===");
        Lingkaran l1 = new Lingkaran(5);
        Titik l2 = new Titik();
        Lingkaran l3 = new Titik();
        System.out.println(l1.luas());
        System.out.println(l2.luas());
        System.out.println(l3.luas());
    }
}
