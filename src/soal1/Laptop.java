package soal1;

import java.util.Locale;

/**
 * Merepresentasikan perangkat komputer jinjing (Laptop) yang merupakan turunan dari Perangkat.
 * Menyimpan informasi tambahan berupa kapasitas RAM dan ukuran layar.
 * 
 * @author Muhammad Fathir
 */
public class Laptop extends Perangkat {
    /** Kapasitas RAM dalam Gigabyte (GB). */
    private int ramGb;

    /** Ukuran layar dalam satuan inci. */
    private double ukuranLayarInci;

    /**
     * Mengonstruksi objek Laptop baru.
     * Baris pertama memanggil constructor superclass.
     *
     * @param merek           nama merek laptop
     * @param harga           harga laptop
     * @param garansiBulan    durasi garansi dalam bulan
     * @param ramGb           kapasitas RAM dalam GB, harus bernilai positif
     * @param ukuranLayarInci ukuran diagonal layar dalam inci, harus bernilai positif
     * @throws IllegalArgumentException jika ramGb atau ukuranLayarInci tidak valid
     */
    public Laptop(String merek, double harga, int garansiBulan, int ramGb, double ukuranLayarInci) {
        super(merek, harga, garansiBulan);
        if (ramGb <= 0) {
            throw new IllegalArgumentException("Kapasitas RAM harus lebih dari 0 GB.");
        }
        if (ukuranLayarInci <= 0) {
            throw new IllegalArgumentException("Ukuran layar harus lebih dari 0 inci.");
        }
        this.ramGb = ramGb;
        this.ukuranLayarInci = ukuranLayarInci;
    }

    /**
     * Menghitung harga setelah promo diskon persen.
     * Mengakses atribut protected harga secara langsung tanpa getter.
     *
     * @param diskonPersen persentase diskon (0 - 100)
     * @return harga akhir setelah potongan diskon
     * @throws IllegalArgumentException jika persentase diskon di luar rentang 0 sampai 100
     */
    public double hitungHargaPromo(double diskonPersen) {
        if (diskonPersen < 0 || diskonPersen > 100) {
            throw new IllegalArgumentException("Persentase diskon harus berada di antara 0 dan 100.");
        }
        return harga - (harga * diskonPersen / 100.0);
    }

    /**
     * Mengembalikan informasi singkat laptop dengan memanfaatkan super.infoSingkat().
     *
     * @return string deskripsi singkat laptop
     */
    @Override
    public String infoSingkat() {
        return String.format(Locale.US, "%s | RAM %d GB | layar %.1f inci",
                super.infoSingkat(), ramGb, ukuranLayarInci);
    }

    /**
     * Mengembalikan kapasitas RAM laptop dalam GB.
     *
     * @return kapasitas RAM
     */
    public int getRamGb() {
        return ramGb;
    }

    /**
     * Mengembalikan ukuran layar laptop dalam inci.
     *
     * @return ukuran layar
     */
    public double getUkuranLayarInci() {
        return ukuranLayarInci;
    }
}
