package soal2;

/**
 * Superclass A untuk menguji urutan inisialisasi constructor dan method overriding.
 * 
 * @author Muhammad Fathir
 */
public class A {
    /**
     * Constructor A yang mencetak pesan pembuatan dan memanggil method init().
     */
    public A() {
        System.out.println("A dibuat");
        init();
    }

    /**
     * Method inisialisasi tingkat superclass yang dapat dioverride oleh subclass.
     */
    public void init() {
        System.out.println("init A");
    }
}
