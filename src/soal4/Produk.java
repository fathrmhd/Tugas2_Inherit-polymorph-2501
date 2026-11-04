package soal4;

/**
 * Superclass Produk yang merepresentasikan barang atau komoditas di toko digital.
 * Menyimpan atribut kode, nama, dan harga dasar.
 * 
 * @author Muhammad Fathir
 */
public class Produk {
    /** Kode unik pengenal produk. */
    private String kode;

    /** Nama produk. */
    private String nama;

    /** Harga dasar produk dalam Rupiah. */
    protected double hargaDasar;

    /**
     * Mengonstruksi objek Produk dengan validasi kode, nama, dan harga dasar.
     *
     * @param kode       kode produk, tidak boleh null atau kosong
     * @param nama       nama produk, tidak boleh null atau kosong
     * @param hargaDasar harga dasar produk, tidak boleh negatif
     * @throws IllegalArgumentException jika parameter tidak valid
     */
    public Produk(String kode, String nama, double hargaDasar) {
        if (kode == null || kode.trim().isEmpty()) {
            throw new IllegalArgumentException("Kode produk tidak boleh kosong.");
        }
        if (nama == null || nama.trim().isEmpty()) {
            throw new IllegalArgumentException("Nama produk tidak boleh kosong.");
        }
        if (hargaDasar < 0) {
            throw new IllegalArgumentException("Harga dasar tidak boleh negatif.");
        }
        this.kode = kode;
        this.nama = nama;
        this.hargaDasar = hargaDasar;
    }

    /**
     * Mengembalikan kode unik produk.
     *
     * @return kode produk
     */
    public String getKode() {
        return kode;
    }

    /**
     * Mengembalikan nama produk.
     *
     * @return nama produk
     */
    public String getNama() {
        return nama;
    }

    /**
     * Mengembalikan harga dasar produk.
     *
     * @return harga dasar
     */
    public double getHargaDasar() {
        return hargaDasar;
    }

    /**
     * Menghitung harga akhir produk.
     * Pada kelas dasar, harga akhir sama dengan harga dasar.
     *
     * @return nominal harga akhir
     */
    public double hitungHargaAkhir() {
        return hargaDasar;
    }

    /**
     * Mengembalikan deskripsi atau keterangan spesifik produk.
     *
     * @return teks deskripsi produk
     */
    public String deskripsi() {
        return "produk umum";
    }
}
