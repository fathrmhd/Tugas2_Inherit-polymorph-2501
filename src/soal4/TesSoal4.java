package soal4;

import java.util.ArrayList;
import java.util.List;

/**
 * Kelas pengujian untuk sistem toko digital pada Soal 4.
 * Menguji polimorfisme, inheritance, komposisi, downcasting aman, serta exception handling.
 * 
 * @author Muhammad Fathir
 */
public class TesSoal4 {
    /**
     * Konstruktor privat untuk mencegah instansiasi kelas utilitas pengujian.
     */
    private TesSoal4() {
        // Tidak diinstansiasi
    }

    /**
     * Titik masuk utama program untuk menguji skenario keranjang belanja.
     *
     * @param args argumen baris perintah
     */
    public static void main(String[] args) {
        Keranjang keranjang = new Keranjang();

        keranjang.tambah(new ProdukFisik("F01", "Keyboard Mekanik", 500000, 1.5));
        keranjang.tambah(new ProdukDigital("D01", "Ebook Java", 100000, 20));
        keranjang.tambah(new Langganan("L01", "Kelas Online", 150000, 20, 12));

        keranjang.cetakStruk();
        keranjang.hitungPerJenis();

        try {
            keranjang.tambah(new ProdukFisik("F01", "Mouse", 100000, 0.2));
        } catch (IllegalStateException e) {
            System.out.println("Gagal: " + e.getMessage());
        }

        // Pengujian opsional: Tantangan ProdukBundel
        System.out.println("\n--- Demo Fitur Tambahan (ProdukBundel) ---");
        List<Produk> itemBundel = new ArrayList<>();
        itemBundel.add(new ProdukFisik("F02", "Mouse Gaming", 250000, 0.3));
        itemBundel.add(new ProdukDigital("D02", "Cheat Sheet Java", 50000, 5));
        ProdukBundel paketHemat = new ProdukBundel("B01", "Paket Belajar & Gear", itemBundel);

        System.out.printf("Paket: %s | Deskripsi: %s | Total Asli: Rp303000 | Harga Bundel (Diskon 15%%): Rp%.0f%n",
                paketHemat.getNama(), paketHemat.deskripsi(), paketHemat.hitungHargaAkhir());
    }
}
