package soal3;

import java.util.Locale;

/**
 * Merepresentasikan koordinat dua dimensi (x, y) dalam bidang Kartesius.
 * Digunakan sebagai komponen penyusun objek Garis (komposisi).
 * 
 * @author Muhammad Fathir
 */
public class Titik {
    /** Koordinat absis (x). */
    private double x;

    /** Koordinat ordinat (y). */
    private double y;

    /**
     * Mengonstruksi titik pada posisi origin (0.0, 0.0).
     */
    public Titik() {
        this(0.0, 0.0);
    }

    /**
     * Mengonstruksi titik pada koordinat tertentu.
     *
     * @param x koordinat x
     * @param y koordinat y
     */
    public Titik(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Mengembalikan nilai koordinat x.
     *
     * @return nilai x
     */
    public double getX() {
        return x;
    }

    /**
     * Mengubah nilai koordinat x.
     *
     * @param x nilai x baru
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * Mengembalikan nilai koordinat y.
     *
     * @return nilai y
     */
    public double getY() {
        return y;
    }

    /**
     * Mengubah nilai koordinat y.
     *
     * @param y nilai y baru
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     * Menghitung jarak Euclidean antara titik ini dengan titik lain.
     *
     * @param lain objek Titik tujuan
     * @return jarak Euclidean antar kedua titik
     * @throws IllegalArgumentException jika titik lain bernilai null
     */
    public double jarakKe(Titik lain) {
        if (lain == null) {
            throw new IllegalArgumentException("Titik tujuan tidak boleh null.");
        }
        double deltaX = this.x - lain.x;
        double deltaY = this.y - lain.y;
        return Math.sqrt(deltaX * deltaX + deltaY * deltaY);
    }

    /**
     * Mengembalikan representasi String dari titik dalam format (x, y).
     *
     * @return representasi string koordinat
     */
    @Override
    public String toString() {
        return String.format(Locale.US, "(%.1f, %.1f)", x, y);
    }
}
