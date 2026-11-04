package soal4;

/**
 * Subclass Langganan yang merupakan turunan dari ProdukDigital untuk layanan berbasis periode.
 * Harga akhir dihitung dari hargaDasar dikali durasiBulan, dengan potongan diskon langganan 20 persen
 * jika durasi langganan minimal 12 bulan (tanpa menerapkan diskon digital).
 * 
 * @author Muhammad Fathir
 */
public class Langganan extends ProdukDigital {
    /** Nilai persentase potongan diskon langganan jangka panjang (20 persen). */
    public static final double DISKON_LANGGANAN = 0.20;

    /** Batas minimum durasi langganan untuk berhak mendapatkan diskon (12 bulan). */
    public static final int BATAS_DURASI_DISKON_BULAN = 12;

    /** Durasi langganan dalam satuan bulan. */
    private int durasiBulan;

    /**
     * Mengonstruksi objek Langganan baru.
     * Menerima urutan parameter: kode, nama, hargaDasar, ukuranMb, durasiBulan.
     *
     * @param kode        kode unik produk
     * @param nama        nama produk langganan
     * @param hargaDasar  harga dasar per bulan
     * @param ukuranMb    ukuran konten/aplikasi dalam MB
     * @param durasiBulan durasi langganan dalam bulan, harus lebih dari 0
     * @throws IllegalArgumentException jika durasi bulan kurang dari atau sama dengan 0
     */
    public Langganan(String kode, String nama, double hargaDasar, double ukuranMb, int durasiBulan) {
        super(kode, nama, hargaDasar, ukuranMb);
        if (durasiBulan <= 0) {
            throw new IllegalArgumentException("Durasi langganan harus lebih besar dari 0 bulan.");
        }
        this.durasiBulan = durasiBulan;
    }

    /**
     * Menghitung harga akhir: hargaDasar * durasiBulan, didiskon 20% jika durasi minimal 12 bulan.
     * Mengabaikan diskon digital dari superclass ProdukDigital.
     *
     * @return harga akhir langganan
     */
    @Override
    public double hitungHargaAkhir() {
        double total = hargaDasar * durasiBulan;
        if (durasiBulan >= BATAS_DURASI_DISKON_BULAN) {
            total *= (1.0 - DISKON_LANGGANAN);
        }
        return total;
    }

    /**
     * Menghasilkan teks deskripsi jenis layanan langganan beserta durasinya.
     *
     * @return deskripsi seperti "langganan 12 bulan"
     */
    @Override
    public String deskripsi() {
        return "langganan " + durasiBulan + " bulan";
    }

    /**
     * Mengembalikan durasi langganan dalam bulan.
     *
     * @return durasi dalam bulan
     */
    public int getDurasiBulan() {
        return durasiBulan;
    }
}
