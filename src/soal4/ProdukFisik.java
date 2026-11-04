package soal4;

import java.util.Locale;

/**
 * Subclass ProdukFisik yang merepresentasikan barang fisik nyata yang memerlukan biaya pengiriman.
 * 
 * @author Muhammad Fathir
 */
public class ProdukFisik extends Produk {
    /** Tarif ongkos kirim standar per kilogram (Rp10.000). */
    public static final double ONGKOS_KIRIM_PER_KG = 10000.0;

    /** Berat barang fisik dalam satuan kilogram (kg). */
    private double beratKg;

    /**
     * Mengonstruksi objek ProdukFisik baru.
     *
     * @param kode       kode unik produk
     * @param nama       nama produk fisik
     * @param hargaDasar harga dasar produk
     * @param beratKg    berat barang dalam kg, harus lebih dari 0
     * @throws IllegalArgumentException jika berat barang negatif atau nol
     */
    public ProdukFisik(String kode, String nama, double hargaDasar, double beratKg) {
        super(kode, nama, hargaDasar);
        if (beratKg <= 0) {
            throw new IllegalArgumentException("Berat barang harus lebih besar dari 0 kg.");
        }
        this.beratKg = beratKg;
    }

    /**
     * Menghitung harga akhir produk fisik: hargaDasar + (beratKg * ONGKOS_KIRIM_PER_KG).
     *
     * @return harga akhir termasuk ongkos kirim
     */
    @Override
    public double hitungHargaAkhir() {
        return hargaDasar + (beratKg * ONGKOS_KIRIM_PER_KG);
    }

    /**
     * Menghasilkan teks deskripsi jenis produk fisik beserta beratnya.
     *
     * @return deskripsi seperti "fisik 1.5 kg"
     */
    @Override
    public String deskripsi() {
        return String.format(Locale.US, "fisik %.1f kg", beratKg);
    }

    /**
     * Mengembalikan berat barang fisik.
     *
     * @return berat dalam kg
     */
    public double getBeratKg() {
        return beratKg;
    }
}
