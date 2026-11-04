package soal2;

/**
 * Subclass B yang mewarisi A untuk memperlihatkan bahaya memanggil overridable method di dalam constructor.
 * 
 * @author Muhammad Fathir
 */
public class B extends A {
    /** Nilai atribut diinisialisasi dengan angka 5 setelah super() selesai dijalankan. */
    private int nilai = 5;

    /**
     * Constructor B yang memanggil constructor superclass A secara eksplisit.
     */
    public B() {
        super();
        System.out.println("B dibuat, nilai=" + nilai);
    }

    /**
     * Meng-override method init() dari kelas A.
     * Saat method ini terpanggil dari constructor A(), atribut nilai di B belum diinisialisasi
     * sehingga masih bernilai default (0).
     */
    @Override
    public void init() {
        System.out.println("init B, nilai=" + nilai);
    }

    /**
     * Mengembalikan nilai atribut.
     *
     * @return nilai saat ini
     */
    public int getNilai() {
        return nilai;
    }
}
