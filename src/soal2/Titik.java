package soal2;

/**
 * Subclass Titik yang mewarisi Lingkaran sebagai contoh anti-pattern pemodelan inheritance yang keliru.
 * Meng-override luas() dan keliling() menghasilkan 0.0 (merepresentasikan lingkaran berjari-jari 0).
 * 
 * @author Muhammad Fathir
 */
public class Titik extends Lingkaran {
    /**
     * Mengonstruksi Titik sebagai Lingkaran dengan jari-jari 0.
     */
    public Titik() {
        super(0.0);
    }

    /**
     * Meng-override method luas() untuk mengembalikan 0.0.
     *
     * @return nilai 0.0
     */
    @Override
    public double luas() {
        return 0.0;
    }

    /**
     * Meng-override method keliling() untuk mengembalikan 0.0.
     *
     * @return nilai 0.0
     */
    @Override
    public double keliling() {
        return 0.0;
    }
}
