package soal2;

/**
 * Merepresentasikan bangun datar lingkaran dengan jari-jari.
 * 
 * @author Muhammad Fathir
 */
public class Lingkaran {
    /** Jari-jari lingkaran. */
    protected double jariJari;

    /**
     * Mengonstruksi objek Lingkaran dengan jari-jari tertentu.
     *
     * @param jariJari panjang jari-jari lingkaran
     */
    public Lingkaran(double jariJari) {
        this.jariJari = jariJari;
    }

    /**
     * Mengonstruksi objek Lingkaran default dengan jari-jari 0.
     */
    public Lingkaran() {
        this(0.0);
    }

    /**
     * Menghitung luas lingkaran dengan rumus PI * r^2.
     *
     * @return luas lingkaran
     */
    public double luas() {
        return Math.PI * jariJari * jariJari;
    }

    /**
     * Menghitung keliling lingkaran dengan rumus 2 * PI * r.
     *
     * @return keliling lingkaran
     */
    public double keliling() {
        return 2 * Math.PI * jariJari;
    }

    /**
     * Mengembalikan nilai jari-jari lingkaran.
     *
     * @return jari-jari lingkaran
     */
    public double getJariJari() {
        return jariJari;
    }
}
