package soal4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

/**
 * Merepresentasikan keranjang belanja (shopping cart) yang menerapkan komposisi (relasi has-a)
 * dengan menyimpan koleksi objek bertipe Produk.
 * 
 * @author Muhammad Fathir
 */
public class Keranjang {
    /** Daftar produk yang tersimpan di dalam keranjang belanja. */
    private ArrayList<Produk> daftarProduk;

    /**
     * Mengonstruksi keranjang belanja kosong.
     */
    public Keranjang() {
        this.daftarProduk = new ArrayList<>();
    }

    /**
     * Menambahkan produk ke dalam keranjang.
     * Melakukan pengecekan duplikasi kode produk.
     *
     * @param produk objek produk yang akan dimasukkan
     * @throws IllegalArgumentException jika parameter produk bernilai null
     * @throws IllegalStateException    jika kode produk sudah ada di dalam keranjang
     */
    public void tambah(Produk produk) {
        if (produk == null) {
            throw new IllegalArgumentException("Produk yang ditambahkan tidak boleh null.");
        }
        for (Produk p : daftarProduk) {
            if (p.getKode().equalsIgnoreCase(produk.getKode())) {
                throw new IllegalStateException("Kode produk '" + produk.getKode() + "' sudah ada di keranjang.");
            }
        }
        daftarProduk.add(produk);
    }

    /**
     * Menghitung total harga seluruh produk di keranjang secara polimorfik.
     * Sesuai ketentuan, perulangan tidak boleh menggunakan instanceof.
     *
     * @return akumulasi harga akhir seluruh produk
     */
    public double hitungTotal() {
        double total = 0.0;
        for (Produk p : daftarProduk) {
            total += p.hitungHargaAkhir(); // Menjalankan dispatch dinamis
        }
        return total;
    }

    /**
     * Mencetak struk belanja ke konsol.
     * Format per baris: kode | nama | deskripsi | RpNNN
     * Diakhiri dengan baris total belanja: TOTAL: RpNNN
     * Tidak diperkenankan menggunakan operator instanceof.
     */
    public void cetakStruk() {
        for (Produk p : daftarProduk) {
            System.out.printf(Locale.US, "%s | %s | %s | Rp%.0f%n",
                    p.getKode(), p.getNama(), p.deskripsi(), p.hitungHargaAkhir());
        }
        System.out.printf(Locale.US, "TOTAL: Rp%.0f%n", hitungTotal());
    }

    /**
     * Menghitung dan mencetak jumlah produk per kategori (Fisik, Digital, Langganan).
     * Menerapkan urutan pengecekan instanceof dan downcasting yang aman,
     * memastikan Langganan dicek sebelum ProdukDigital.
     */
    public void hitungPerJenis() {
        int fisik = 0;
        int digital = 0;
        int langganan = 0;

        for (Produk p : daftarProduk) {
            if (p instanceof Langganan) {
                Langganan l = (Langganan) p; // Downcasting aman ke Langganan
                langganan++;
            } else if (p instanceof ProdukDigital) {
                ProdukDigital d = (ProdukDigital) p; // Downcasting aman ke ProdukDigital
                digital++;
            } else if (p instanceof ProdukFisik) {
                ProdukFisik f = (ProdukFisik) p; // Downcasting aman ke ProdukFisik
                fisik++;
            }
        }

        System.out.printf("Fisik: %d, Digital: %d, Langganan: %d%n", fisik, digital, langganan);
    }

    /**
     * Mengembalikan daftar produk yang ada di keranjang (unmodifiable view).
     *
     * @return daftar produk
     */
    public List<Produk> getDaftarProduk() {
        return Collections.unmodifiableList(daftarProduk);
    }
}
