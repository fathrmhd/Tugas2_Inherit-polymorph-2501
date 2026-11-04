package soal1;

/**
 * Merepresentasikan perangkat telepon genggam pintar (Ponsel) yang merupakan turunan dari Perangkat.
 * Menyimpan informasi tambahan kapasitas penyimpanan internal dan jumlah modul kamera.
 * 
 * @author Muhammad Fathir
 */
public class Ponsel extends Perangkat {
    /** Kapasitas penyimpanan internal dalam Gigabyte (GB). */
    private int kapasitasGb;

    /** Jumlah unit modul kamera pada ponsel. */
    private int jumlahKamera;

    /**
     * Mengonstruksi objek Ponsel baru.
     * Baris pertama memanggil constructor superclass.
     *
     * @param merek        nama merek ponsel
     * @param harga        harga ponsel
     * @param garansiBulan durasi garansi dalam bulan
     * @param kapasitasGb  kapasitas penyimpanan internal dalam GB, harus positif
     * @param jumlahKamera jumlah kamera, tidak boleh negatif
     * @throws IllegalArgumentException jika kapasitasGb atau jumlahKamera tidak valid
     */
    public Ponsel(String merek, double harga, int garansiBulan, int kapasitasGb, int jumlahKamera) {
        super(merek, harga, garansiBulan);
        if (kapasitasGb <= 0) {
            throw new IllegalArgumentException("Kapasitas penyimpanan harus lebih dari 0 GB.");
        }
        if (jumlahKamera < 0) {
            throw new IllegalArgumentException("Jumlah kamera tidak boleh negatif.");
        }
        this.kapasitasGb = kapasitasGb;
        this.jumlahKamera = jumlahKamera;
    }

    /**
     * Mengembalikan informasi singkat ponsel dengan memanfaatkan super.infoSingkat().
     *
     * @return string deskripsi singkat ponsel
     */
    @Override
    public String infoSingkat() {
        return super.infoSingkat() + " | " + kapasitasGb + " GB | " + jumlahKamera + " kamera";
    }

    /**
     * Mengembalikan kapasitas penyimpanan ponsel dalam GB.
     *
     * @return kapasitas penyimpanan
     */
    public int getKapasitasGb() {
        return kapasitasGb;
    }

    /**
     * Mengembalikan jumlah kamera pada ponsel.
     *
     * @return jumlah kamera
     */
    public int getJumlahKamera() {
        return jumlahKamera;
    }
}
