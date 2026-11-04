package soal1;

/**
 * Kelas induk (superclass) yang merepresentasikan perangkat elektronik secara umum.
 * Menyimpan data dasar seperti merek, harga, dan masa garansi.
 * 
 * @author Muhammad Fathir
 */
public class Perangkat {
    /** Tarif pajak standar sebesar 10 persen. */
    public static final double TARIF_PAJAK = 0.10;

    /** Merek perangkat elektronik. */
    private String merek;

    /** Harga perangkat elektronik dalam satuan Rupiah (dapat diakses oleh subclass). */
    protected double harga;

    /** Durasi garansi dalam satuan bulan. */
    private int garansiBulan;

    /**
     * Mengonstruksi objek Perangkat baru dengan validasi data.
     *
     * @param merek        nama merek perangkat, tidak boleh null atau kosong
     * @param harga        harga perangkat dalam Rupiah, tidak boleh negatif
     * @param garansiBulan masa garansi dalam bulan, tidak boleh negatif
     * @throws IllegalArgumentException jika harga negatif, merek kosong, atau garansi negatif
     */
    public Perangkat(String merek, double harga, int garansiBulan) {
        if (merek == null || merek.trim().isEmpty()) {
            throw new IllegalArgumentException("Merek tidak boleh kosong.");
        }
        if (harga < 0) {
            throw new IllegalArgumentException("Harga tidak boleh negatif.");
        }
        if (garansiBulan < 0) {
            throw new IllegalArgumentException("Garansi bulan tidak boleh negatif.");
        }
        this.merek = merek;
        this.harga = harga;
        this.garansiBulan = garansiBulan;
    }

    /**
     * Mengembalikan nama merek perangkat.
     *
     * @return nama merek
     */
    public String getMerek() {
        return merek;
    }

    /**
     * Mengembalikan masa garansi perangkat dalam bulan.
     *
     * @return durasi garansi dalam bulan
     */
    public int getGaransiBulan() {
        return garansiBulan;
    }

    /**
     * Mengembalikan harga perangkat.
     *
     * @return harga perangkat
     */
    public double getHarga() {
        return harga;
    }

    /**
     * Menghitung nilai pajak perangkat berdasarkan tarif pajak standar.
     *
     * @return besaran pajak yang harus dibayar
     */
    public double hitungPajak() {
        return harga * TARIF_PAJAK;
    }

    /**
     * Menghasilkan ringkasan informasi singkat mengenai perangkat.
     *
     * @return string berisi merek dan masa garansi
     */
    public String infoSingkat() {
        return merek + " | garansi " + garansiBulan + " bulan";
    }
}
