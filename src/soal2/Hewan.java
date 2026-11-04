package soal2;

/**
 * Superclass Hewan untuk mendemonstrasikan pewarisan (inheritance) dan polimorfisme.
 * 
 * @author Muhammad Fathir
 */
public class Hewan {
    /** Nama hewan dengan visibilitas protected agar dapat diakses oleh subclass. */
    protected String nama;

    /**
     * Mengonstruksi objek Hewan baru.
     *
     * @param nama nama hewan
     */
    public Hewan(String nama) {
        this.nama = nama;
        System.out.println("Hewan dibuat: " + nama);
    }

    /**
     * Mencetak suara dasar hewan secara generik.
     */
    public void suara() {
        System.out.println("...");
    }

    /**
     * Mencetak aktivitas makan hewan lalu memanggil suara().
     */
    public void makan() {
        System.out.println(nama + " makan");
        suara();
    }
}
