package soal1;

/**
 * Merepresentasikan laptop khusus gaming (LaptopGaming) yang merupakan turunan dari Laptop.
 * Memiliki tambahan komponen kartu grafis mandiri (GPU) serta garansi tambahan otomatis 6 bulan.
 * 
 * @author Muhammad Fathir
 */
public class LaptopGaming extends Laptop {
    /** Nilai konstanta tambahan masa garansi untuk laptop gaming (6 bulan). */
    public static final int TAMBAHAN_GARANSI_BULAN = 6;

    /** Nama atau seri kartu grafis (GPU) yang disematkan. */
    private String kartuGrafis;

    /**
     * Mengonstruksi objek LaptopGaming baru.
     * Meneruskan garansiBulan + TAMBAHAN_GARANSI_BULAN ke constructor superclass Laptop.
     *
     * @param merek           nama merek laptop
     * @param harga           harga laptop
     * @param garansiBulan    masa garansi dasar dalam bulan (sebelum tambahan 6 bulan)
     * @param ramGb           kapasitas RAM dalam GB
     * @param ukuranLayarInci ukuran layar dalam inci
     * @param kartuGrafis     nama/model GPU terpasang
     * @throws IllegalArgumentException jika parameter kartuGrafis kosong atau tidak valid
     */
    public LaptopGaming(String merek, double harga, int garansiBulan, int ramGb,
                        double ukuranLayarInci, String kartuGrafis) {
        super(merek, harga, garansiBulan + TAMBAHAN_GARANSI_BULAN, ramGb, ukuranLayarInci);
        if (kartuGrafis == null || kartuGrafis.trim().isEmpty()) {
            throw new IllegalArgumentException("Nama kartu grafis tidak boleh kosong.");
        }
        this.kartuGrafis = kartuGrafis;
    }

    /**
     * Mengembalikan informasi singkat laptop gaming dengan memanggil super.infoSingkat().
     *
     * @return string deskripsi singkat laptop gaming beserta GPU
     */
    @Override
    public String infoSingkat() {
        return super.infoSingkat() + " | GPU " + kartuGrafis;
    }

    /**
     * Mengembalikan nama atau model kartu grafis (GPU).
     *
     * @return model kartu grafis
     */
    public String getKartuGrafis() {
        return kartuGrafis;
    }
}
