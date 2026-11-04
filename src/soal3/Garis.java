package soal3;

/**
 * Merepresentasikan segmen garis lurus yang tersusun atas dua objek Titik (awal dan akhir)
 * dengan konsep relasi komposisi (has-a).
 * Menerapkan prinsip defensive copying untuk mencegah kebocoran enkapsulasi (aliasing).
 * 
 * @author Muhammad Fathir
 */
public class Garis {
    /** Titik ujung awal dari segmen garis. */
    private Titik awal;

    /** Titik ujung akhir dari segmen garis. */
    private Titik akhir;

    /**
     * Mengonstruksi garis dengan dua objek Titik.
     * Menerapkan defensive copy agar perubahan koordinat pada objek luar tidak memengaruhi objek garis.
     *
     * @param awal  titik pangkal awal
     * @param akhir titik ujung akhir
     * @throws IllegalArgumentException jika parameter awal atau akhir bernilai null
     */
    public Garis(Titik awal, Titik akhir) {
        if (awal == null || akhir == null) {
            throw new IllegalArgumentException("Titik awal dan akhir tidak boleh null.");
        }
        // Penerapan defensive copy:
        this.awal = new Titik(awal.getX(), awal.getY());
        this.akhir = new Titik(akhir.getX(), akhir.getY());
    }

    /**
     * Constructor overload yang menerima koordinat desimal dari kedua titik.
     * Memanfaatkan constructor utama melalui keyword this(...) untuk menghindari redundansi logika.
     *
     * @param x1 koordinat x titik awal
     * @param y1 koordinat y titik awal
     * @param x2 koordinat x titik akhir
     * @param y2 koordinat y titik akhir
     */
    public Garis(double x1, double y1, double x2, double y2) {
        this(new Titik(x1, y1), new Titik(x2, y2));
    }

    /**
     * Mengembalikan salinan defensif dari titik awal.
     *
     * @return objek Titik salinan titik awal
     */
    public Titik getAwal() {
        return new Titik(awal.getX(), awal.getY());
    }

    /**
     * Mengubah titik awal garis dengan salinan defensif.
     *
     * @param awal titik awal baru
     * @throws IllegalArgumentException jika parameter awal bernilai null
     */
    public void setAwal(Titik awal) {
        if (awal == null) {
            throw new IllegalArgumentException("Titik awal tidak boleh null.");
        }
        this.awal = new Titik(awal.getX(), awal.getY());
    }

    /**
     * Mengembalikan salinan defensif dari titik akhir.
     *
     * @return objek Titik salinan titik akhir
     */
    public Titik getAkhir() {
        return new Titik(akhir.getX(), akhir.getY());
    }

    /**
     * Mengubah titik akhir garis dengan salinan defensif.
     *
     * @param akhir titik akhir baru
     * @throws IllegalArgumentException jika parameter akhir bernilai null
     */
    public void setAkhir(Titik akhir) {
        if (akhir == null) {
            throw new IllegalArgumentException("Titik akhir tidak boleh null.");
        }
        this.akhir = new Titik(akhir.getX(), akhir.getY());
    }

    /**
     * Menghitung panjang garis dengan mendelegasikan perhitungan jarak ke method jarakKe() milik Titik.
     *
     * @return panjang segmen garis
     */
    public double getPanjang() {
        return awal.jarakKe(akhir);
    }

    /**
     * Mengembalikan representasi String dari garis dengan memanggil toString() milik masing-masing Titik.
     *
     * @return string format "(x1, y1) - (x2, y2)"
     */
    @Override
    public String toString() {
        return awal.toString() + " - " + akhir.toString();
    }
}
