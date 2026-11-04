package soal2;

/**
 * Subclass Kucing yang mewarisi sifat dan perilaku Hewan.
 * Meng-override method suara() dan menambahkan perilaku khusus panjat().
 * 
 * @author Muhammad Fathir
 */
public class Kucing extends Hewan {
    /**
     * Mengonstruksi objek Kucing baru dengan memanggil constructor superclass.
     *
     * @param nama nama kucing
     */
    public Kucing(String nama) {
        super(nama);
        System.out.println("Kucing dibuat");
    }

    /**
     * Meng-override method suara dari Hewan menjadi suara kucing ("meong").
     */
    @Override
    public void suara() {
        System.out.println("meong");
    }

    /**
     * Perilaku spesifik kelas Kucing untuk memanjat.
     */
    public void panjat() {
        System.out.println(nama + " memanjat");
    }
}
