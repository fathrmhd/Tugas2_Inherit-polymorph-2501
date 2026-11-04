package soal1;

/**
 * Kelas pengujian untuk hierarki Perangkat Elektronik pada Soal 1.
 * 
 * @author Muhammad Fathir
 */
public class TesSoal1 {
    /**
     * Konstruktor privat untuk mencegah instansiasi kelas utilitas pengujian.
     */
    private TesSoal1() {
        // Tidak diinstansiasi
    }

    /**
     * Titik masuk utama program untuk menguji pembuatan objek dan pemanggilan method.
     *
     * @param args argumen baris perintah (tidak digunakan)
     */
    public static void main(String[] args) {
        Laptop l = new Laptop("Asus", 8000000, 24, 16, 14.0);
        Ponsel p = new Ponsel("Samsung", 5000000, 12, 128, 3);
        LaptopGaming g = new LaptopGaming("MSI", 15000000, 12, 32, 15.6, "RTX 4060");

        System.out.println(l.infoSingkat());
        System.out.println(p.infoSingkat());
        System.out.println(g.infoSingkat());
        System.out.printf("Pajak laptop: Rp%.0f%n", l.hitungPajak());
        System.out.printf("Promo laptop 10 persen: Rp%.0f%n", l.hitungHargaPromo(10));
    }
}
