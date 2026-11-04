package soal4;

import java.util.Locale;

/**
 * Subclass ProdukDigital yang merepresentasikan aset digital unduhan seperti ebook atau file digital.
 * Memperoleh potongan diskon digital otomatis sebesar 10 persen.
 * 
 * @author Muhammad Fathir
 */
public class ProdukDigital extends Produk {
    /** Nilai persentase potongan diskon produk digital (10 persen). */
    public static final double DISKON_DIGITAL = 0.10;

    /** Ukuran berkas digital dalam Megabyte (MB). */
    private double ukuranMb;

    /**
     * Mengonstruksi objek ProdukDigital baru.
     *
     * @param kode       kode unik produk
     * @param nama       nama produk digital
     * @param hargaDasar harga dasar produk
     * @param ukuranMb   ukuran file dalam MB, harus lebih dari 0
     * @throws IllegalArgumentException jika ukuran berkas negatif atau nol
     */
    public ProdukDigital(String kode, String nama, double hargaDasar, double ukuranMb) {
        super(kode, nama, hargaDasar);
        if (ukuranMb <= 0) {
            throw new IllegalArgumentException("Ukuran berkas digital harus lebih dari 0 MB.");
        }
        this.ukuranMb = ukuranMb;
    }

    /**
     * Menghitung harga akhir setelah dikurangi diskon digital 10 persen.
     *
     * @return harga akhir setelah potongan diskon
     */
    @Override
    public double hitungHargaAkhir() {
        return hargaDasar * (1.0 - DISKON_DIGITAL);
    }

    /**
     * Menghasilkan teks deskripsi jenis produk digital beserta ukuran berkasnya.
     *
     * @return deskripsi seperti "digital 20.0 MB"
     */
    @Override
    public String deskripsi() {
        return String.format(Locale.US, "digital %.1f MB", ukuranMb);
    }

    /**
     * Mengembalikan ukuran file dalam MB.
     *
     * @return ukuran file
     */
    public double getUkuranMb() {
        return ukuranMb;
    }
}
