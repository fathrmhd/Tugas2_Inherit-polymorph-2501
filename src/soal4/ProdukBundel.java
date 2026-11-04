package soal4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Subclass ProdukBundel (Tantangan Opsional) yang membungkus beberapa produk sekaligus
 * dengan potongan diskon paket bundel sebesar 15 persen.
 * 
 * @author Muhammad Fathir
 */
public class ProdukBundel extends Produk {
    /** Nilai diskon paket bundel sebesar 15 persen. */
    public static final double DISKON_BUNDEL = 0.15;

    /** Daftar produk yang termasuk ke dalam bundel. */
    private List<Produk> daftarItem;

    /**
     * Mengonstruksi objek ProdukBundel baru dengan kumpulan produk yang di-bundel.
     *
     * @param kode       kode unik paket bundel
     * @param nama       nama paket bundel
     * @param daftarItem daftar produk yang dimasukkan ke dalam paket, tidak boleh kosong
     * @throws IllegalArgumentException jika daftarItem bernilai null atau kosong
     */
    public ProdukBundel(String kode, String nama, List<Produk> daftarItem) {
        super(kode, nama, 0.0);
        if (daftarItem == null || daftarItem.isEmpty()) {
            throw new IllegalArgumentException("Daftar item bundel tidak boleh null atau kosong.");
        }
        this.daftarItem = new ArrayList<>(daftarItem); // Defensive copy
    }

    /**
     * Menghitung total harga akhir bundel berdasarkan akumulasi harga masing-masing item
     * lalu dipotong diskon bundel 15 persen.
     *
     * @return harga akhir paket bundel
     */
    @Override
    public double hitungHargaAkhir() {
        double subtotal = 0.0;
        for (Produk item : daftarItem) {
            subtotal += item.hitungHargaAkhir();
        }
        return subtotal * (1.0 - DISKON_BUNDEL);
    }

    /**
     * Menghasilkan teks deskripsi paket bundel beserta jumlah item di dalamnya.
     *
     * @return deskripsi seperti "bundel 3 produk"
     */
    @Override
    public String deskripsi() {
        return "bundel " + daftarItem.size() + " produk";
    }

    /**
     * Mengembalikan daftar produk anggota bundel yang tidak dapat dimodifikasi (unmodifiable list).
     *
     * @return list produk bundel
     */
    public List<Produk> getDaftarItem() {
        return Collections.unmodifiableList(daftarItem);
    }
}
