# Tugas 2 Praktikum Pemrograman Berorientasi Objek: Inheritance, Composition, dan Polimorfisme

## 1. Identitas Mahasiswa & Repository
- **Nama Lengkap**: Muhammad Fathir
- **NPM**: 250810701100001
- **Kelas Praktikum**: Pemrograman Berorientasi Objek A
- **Mata Kuliah**: Praktikum Pemrograman Berorientasi Objek
- **Tautan Repository**: [https://github.com/fathrmhd/Tugas2_Inherit-polymorph-2501](https://github.com/fathrmhd/Tugas2_Inherit-polymorph-2501)

---

## 2. Deskripsi Singkat
Repositori ini berisi solusi  untuk Tugas 2 Praktikum Pemrograman Berorientasi Objek.

---

## 3. Fitur Utama
Berikut adalah fungsionalitas utama yang dapat dinikmati oleh pengguna program pada masing-masing modul:
- **Soal 1 (Katalog & Perangkat Elektronik)**: Pengguna dapat mencatat data spesifikasi berbagai jenis perangkat (Laptop, Ponsel, Laptop Gaming), mendapatkan perhitungan pajak otomatis 10%, menghitung potongan harga diskon promo khusus laptop, serta melihat ringkasan perangkat lengkap dengan otomatisasi penambahan masa garansi 6 bulan pada laptop gaming.
- **Soal 2 (Eksplorasi Perilaku Objek & Polimorfisme)**: Menyajikan analisis runtime dan perilaku sistem terhadap siklus hidup objek (pemanggilan konstruktor berantai), dampak overriding method terhadap eksekusi superclass, proteksi terhadap *runtime type error* menggunakan pengecekan tipe aman, serta konsekuensi kesalahan perancangan relasi *is-a*.
- **Soal 3 (Geometri Garis & Titik Koordinat)**: Pengguna dapat membuat garis dari titik koordinat Kartesius 2D dengan berbagai variasi input (overloading), menghitung panjang garis secara akurat menggunakan rumus jarak Euclidean titik, serta menjamin integritas koordinat garis dari perubahan liar objek luar berkat penerapan *defensive copying*.
- **Soal 4 (Sistem Kasir Keranjang Belanja Toko Digital)**: Pengguna dapat menambahkan berbagai komoditas (barang fisik berongkos kirim, produk digital berdiskon 10%, layanan langganan dengan diskon durasi 20%, serta paket produk bundel hemat 15%), mencetak struk belanja terperinci secara polimorfik, mengelompokkan jumlah barang per jenis secara akurat, serta dicegah dari kesalahan duplikasi kode produk melalui sistem validasi exception.

---

## 4. Konsep OOP yang Diterapkan

| Nama Konsep | Lokasi Penerapan | Alasan Pemilihan Konsep |
| :--- | :--- | :--- |
| **Inheritance (`is-a`)** | `soal1.Laptop extends Perangkat`, `soal1.LaptopGaming extends Laptop`, `soal4.ProdukFisik extends Produk` | Merefleksikan relasi taksonomi alami dunia nyata, mencegah duplikasi atribut dasar (`merek`, `harga`, `kode`), dan memungkinkan substitusi polimorfik. |
| **Access Modifier `protected`** | Atribut `harga` di `soal1.Perangkat`, atribut `hargaDasar` di `soal4.Produk` | Mengizinkan subclass (`Laptop`, `ProdukFisik`, `ProdukDigital`) mengakses variabel harga secara langsung untuk kalkulasi promo/ongkir tanpa membuka akses ke sembarang kelas luar. |
| **Keyword `super`** | Konstruktor subclass (`Laptop`, `Ponsel`, `LaptopGaming`, `Langganan`) dan pemanggilan `super.infoSingkat()` | Memastikan inisialisasi superclass selalu tereksekusi pada baris pertama dan memperluas fungsionalitas deskripsi tanpa menyalin ulang kode superclass. |
| **Composition (`has-a`)** | `soal3.Garis` memiliki dua atribut `soal3.Titik`, `soal4.Keranjang` memiliki `ArrayList<Produk>` | Memisahkan tanggung jawab secara modular (*loose coupling*); garis terdiri dari dua titik dan keranjang menampung daftar produk tanpa memaksakan relasi pewarisan yang keliru. |
| **Defensive Copying & Anti-Aliasing** | Konstruktor, getter, dan setter pada `soal3.Garis` | Mencegah kebocoran enkapsulasi di mana mutasi pada objek referensi luar dapat secara tidak sengaja merusak kondisi internal garis. |
| **Method Overloading** | Konstruktor `Garis(Titik, Titik)` dan `Garis(double, double, double, double)` pada `soal3.Garis` | Memberikan kenyamanan kepada pemanggil untuk menginstansiasi objek dari berbagai kombinasi tipe argumen yang berbeda dengan tetap mendelegasikan logika ke satu tempat melalui `this(...)`. |
| **Method Overriding & Polimorfisme** | `hitungHargaAkhir()` dan `deskripsi()` pada turunan `Produk`, `infoSingkat()` pada turunan `Perangkat` | Mengimplementasikan perilaku dinamis (*dynamic dispatch*) sehingga kelas pengelola seperti `Keranjang` dapat memperlakukan seluruh objek secara seragam tanpa pengkondisian tipe manual. |
| **Safe Downcasting & `instanceof`** | `hitungPerJenis()` pada `soal4.Keranjang`, penanganan `h2` pada `soal2.TesSoal2` | Mengidentifikasi tipe konkret objek secara aman pada runtime sebelum dilakukan casting demi menghindari malafungsi `ClassCastException`. |
| **Exception Handling & Data Validation** | `IllegalArgumentException` pada konstruktor `Perangkat`, `Produk`, dan `IllegalStateException` pada `Keranjang.tambah()` | Memastikan integritas dan invarian data aplikasi terjaga sejak instansiasi awal dan menolak state keranjang yang tidak konsisten (duplikasi kode barang). |

---

## 5. Struktur Project
Struktur folder repositori sebagai berikut:
```text
Tugas2_Inherit-polymorph-2501/
├── src/
│   ├── soal1/
│   │   ├── Perangkat.java
│   │   ├── Laptop.java
│   │   ├── Ponsel.java
│   │   ├── LaptopGaming.java
│   │   └── TesSoal1.java
│   ├── soal2/
│   │   ├── Hewan.java
│   │   ├── Kucing.java
│   │   ├── A.java
│   │   ├── B.java
│   │   ├── Lingkaran.java
│   │   ├── Titik.java
│   │   └── TesSoal2.java
│   ├── soal3/
│   │   ├── Titik.java
│   │   ├── Garis.java
│   │   └── TesSoal3.java
│   └── soal4/
│       ├── Produk.java
│       ├── ProdukFisik.java
│       ├── ProdukDigital.java
│       ├── Langganan.java
│       ├── ProdukBundel.java     
│       ├── Keranjang.java
│       └── TesSoal4.java
├── .gitignore
├── Tugas2_PrakPboA.pdf
└── README.md
```

---

## 6. Contoh Output Eksekusi

### Soal 1: Hierarki Perangkat Elektronik
```text
Asus | garansi 24 bulan | RAM 16 GB | layar 14.0 inci
Samsung | garansi 12 bulan | 128 GB | 3 kamera
MSI | garansi 18 bulan | RAM 32 GB | layar 15.6 inci | GPU RTX 4060
Pajak laptop: Rp800000
Promo laptop 10 persen: Rp7200000
```

### Soal 2: Analisis Output, Error, dan Polimorfisme
```text
=== SOAL 2 BAGIAN A ===
Hewan dibuat: Tom
Kucing dibuat
Tom makan
meong
meong
Tom memanjat
Hewan dibuat: Generik

[Uji Downcasting Tanpa Pengecekan]
Tertangkap ClassCastException: class soal2.Hewan cannot be cast to class soal2.Kucing (soal2.Hewan and soal2.Kucing are in unnamed module of loader 'app')

[Uji Downcasting Aman dengan instanceof]
Objek h2 bukan merupakan instance dari Kucing, downcasting dibatalkan secara aman.

=== SOAL 2 BAGIAN B ===
A dibuat
init B, nilai=0
B dibuat, nilai=5

=== SOAL 2 BAGIAN C ===
78.53981633974483
0.0
0.0
```

### Soal 3: Titik dan Garis (Aliasing & Defensive Copying)
```text
(0.0, 0.0) - (3.0, 4.0) panjang=5.0
(1.0, 1.0) - (5.0, 5.0)
```

### Soal 4: Mini Project Toko Digital & Exception Handling
```text
F01 | Keyboard Mekanik | fisik 1.5 kg | Rp515000
D01 | Ebook Java | digital 20.0 MB | Rp90000
L01 | Kelas Online | langganan 12 bulan | Rp1440000
TOTAL: Rp2045000
Fisik: 1, Digital: 1, Langganan: 1
Gagal: Kode produk 'F01' sudah ada di keranjang.

--- Demo Fitur Tambahan (ProdukBundel) ---
Paket: Paket Belajar & Gear | Deskripsi: bundel 2 produk | Total Asli: Rp303000 | Harga Bundel (Diskon 15%): Rp253300
```

---

## 7. Jawaban Soal dan Analisis Konsep

### Pertanyaan Tambahan Soal 1
**Instruksi**: Ubah `harga` menjadi `private` pada kelas `Perangkat`, lalu lakukan kompilasi. Salin pesan error yang muncul dan jelaskan mengapa error tersebut muncul.
- **Pesan Error Kompilasi**:
  ```text
  src/soal1/Laptop.java:53: error: harga has private access in Perangkat
          return harga - (harga * diskonPersen / 100.0);
                 ^
  src/soal1/Laptop.java:53: error: harga has private access in Perangkat
          return harga - (harga * diskonPersen / 100.0);
                          ^
  2 errors
  ```
- **Penjelasan**:
  Pesan error tersebut muncul karena atribut `harga` yang diberi hak akses (*modifier*) `private` pada kelas `Perangkat` hanya dapat diakses secara langsung dari dalam tubuh kelas `Perangkat` itu sendiri. Subclass seperti `Laptop` memang mewarisi status dan perilaku dari superclass-nya, namun tidak diberikan hak akses langsung ke field privat superclass. Agar atribut tersebut dapat diakses secara langsung oleh kelas turunannya tanpa membuka akses publik secara bebas, atribut harus dideklarasikan sebagai `protected`. Jika tetap ingin menggunakan `private`, maka kelas turunan wajib mengaksesnya secara tidak langsung menggunakan getter publik `getHarga()`.

---

### Jawaban Soal 2 (Bagian A, B, dan C)

#### 1. Output lengkap program sampai program berhenti (Bagian A asli sebelum perbaikan)
```text
Hewan dibuat: Tom
Kucing dibuat
Tom makan
meong
meong
Tom memanjat
Hewan dibuat: Generik
Exception in thread "main" java.lang.ClassCastException: class soal2.Hewan cannot be cast to class soal2.Kucing
        at soal2.TesSoal2.main(TesSoal2.java:18)
```

#### 2. Jika komentar pada baris `h.panjat();` dihapus, error apa yang muncul, pada tahap kompilasi atau runtime, dan mengapa?
Error yang muncul terjadi pada **tahap kompilasi (compile-time error)** dengan pesan `cannot find symbol: method panjat() location: variable h of type Hewan`. Hal ini terjadi karena kompiler Java memeriksa keabsahan pemanggilan method berdasarkan **tipe statis (compile-time type)** dari variabel referensi `h`, yaitu kelas `Hewan`. Pada kelas `Hewan`, method `panjat()` belum pernah dideklarasikan (hanya ada pada kelas `Kucing`). Walaupun objek aktual di memori heap adalah instans dari `Kucing`, kompiler menolak kode tersebut demi keselamatan pengetikan (*type-safety*) sebelum program dapat dijalankan.

#### 3. Baris mana yang menyebabkan `ClassCastException`? Perbaiki dengan `instanceof` tanpa mengubah tipe variabel `h2`.
Baris yang menyebabkan exception fatal tersebut adalah:
```java
Kucing k2 = (Kucing) h2;
```
Perbaikan aman menggunakan operator `instanceof`:
```java
if (h2 instanceof Kucing) {
    Kucing k2 = (Kucing) h2;
    k2.panjat();
} else {
    System.out.println("h2 bukan merupakan instance dari Kucing, downcasting dibatalkan secara aman.");
}
```

#### 4. Pada `h.makan()`, method `suara()` milik kelas mana yang dijalankan, padahal `makan()` ditulis di `Hewan`? Jelaskan dengan istilah tipe statis dan tipe dinamis.
Method `suara()` yang dijalankan adalah milik kelas **`Kucing`** (menghasilkan cetakan `"meong"`). Hal ini terjadi karena variabel `h` memiliki **tipe statis** `Hewan` (tipe deklarasi acuan), namun memiliki **tipe dinamis** `Kucing` (tipe objek nyata yang dialokasikan di heap melalui `new Kucing("Tom")`). Di Java, method non-statis dan non-privat bersifat virtual secara default dan diselesaikan menggunakan mekanisme **dynamic method dispatch** (late binding). Ketika method `makan()` yang ada di kelas induk memanggil `suara()`, JVM merujuk ke tabel metode virtual (*vtable*) milik objek dinamis sesungguhnya (`Kucing`). Karena kelas `Kucing` meng-override method `suara()`, maka implementasi spesifik milik `Kucing`-lah yang dipanggil pada saat runtime.

#### 5. Prediksi output untuk `new B();`, mengapa nilai "init B" bukan 5, dan apa risiko memanggil overridable method di dalam constructor?
- **Prediksi dan Hasil Output**:
  ```text
  A dibuat
  init B, nilai=0
  B dibuat, nilai=5
  ```
- **Penyebab**: Saat objek turunan dibuat (`new B()`), konstruktor superclass `A()` dieksekusi terlebih dahulu sebelum isi konstruktor subclass. Di dalam `A()`, method `init()` dipanggil. Berdasarkan polimorfisme dinamis, method yang terpicu adalah `init()` milik `B` yang telah meng-override `init()` milik `A`. Namun, pada tahap ini, inisialisasi eksplisit atribut milik `B` (`int nilai = 5;`) belum sempat dijalankan oleh JVM. Akibatnya, variabel `nilai` masih memegang nilai bawaan tipe primitif Java untuk integer, yaitu `0`.
- **Risiko**: Memanggil method yang dapat dioverride dari dalam constructor sangat berbahaya (*partially constructed object smell*). Method turunan dapat secara tidak sengaja mengakses atribut yang belum diinisialisasi atau objek dependensi yang masih bernilai `null`, memicu `NullPointerException` atau kerusakan data logika yang sangat sulit dilacak.

#### 6. Mengapa `l3.luas()` menghasilkan 0.0 padahal tipe variabelnya Lingkaran? Apakah "Titik adalah sebuah Lingkaran" masuk akal sebagai relasi is-a? Apa konsekuensinya jika suatu method mengharapkan Lingkaran yang selalu punya luas lebih dari nol?
- **Penyebab hasil 0.0**: Variabel `l3` memiliki tipe dinamis `Titik` (`new Titik()`). Pemanggilan method `luas()` dialihkan secara polimorfik ke method `luas()` hasil override di kelas `Titik`, yang secara eksplisit mengembalikan nilai `0.0`.
- **Analisis Relasi is-a**: Secara konsep matematis dan semantik domain nyata, relasi ini **tidak masuk akal**. Sebuah titik adalah entitas nol-dimensi tanpa dimensi radius, sedangkan lingkaran adalah bangun dua-dimensi yang eksistensinya mensyaratkan jari-jari bernilai positif ($r > 0$). Memaksakan hubungan ini melanggar prinsip **Liskov Substitution Principle (LSP)** dalam arsitektur OOP.
- **Konsekuensi**: Jika terdapat modul lain yang mengharapkan objek `Lingkaran` memiliki luas positif (misalnya untuk menghitung massa jenis $\rho = \frac{massa}{luas}$), pengiriman objek `Titik` yang bertopeng sebagai `Lingkaran` akan memicu kesalahan fatal pembagian dengan nol (`ArithmeticException` atau nilai `Infinity`/`NaN`), yang merusak integritas perhitungan sistem.

---

### Jawaban Pertanyaan dan Tugas Soal 3
#### 1. Apa yang tercetak pada baris kedua dan mengapa?
- **Prediksi & Hasil Sebelum Perbaikan**: `(100.0, 1.0) - (5.0, 5.0)`
- **Alasan**: Konstruktor `Garis` awal menugaskan referensi objek titik luar secara langsung ke atribut internalnya (`this.awal = awal;`). Kondisi ini menimbulkan fenomena **aliasing**, di mana variabel referensi luar `t` dan variabel privat `awal` di dalam `Garis` menunjuk ke satu alamat memori yang persis sama di heap. Saat kode luar menjalankan `t.setX(100)`, nilai koordinat x internal garis ikut termutasi tanpa kendali.

#### 2. Perubahan konstruktor Garis (Defensive Copy) dan hasil cetak setelah perbaikan:
- **Perbaikan Kode**:
  ```java
  public Garis(Titik awal, Titik akhir) {
      if (awal == null || akhir == null) {
          throw new IllegalArgumentException("Titik awal dan akhir tidak boleh null.");
      }
      this.awal = new Titik(awal.getX(), awal.getY());
      this.akhir = new Titik(akhir.getX(), akhir.getY());
  }
  ```
- **Hasil Cetak Setelah Perbaikan**: `(1.0, 1.0) - (5.0, 5.0)`.

#### 3. Kapan perilaku sebelum perbaikan justru lebih tepat, dan kapan sesudah perbaikan lebih tepat?
- **Sebelum Perbaikan (Shared Reference / Aliasing)** lebih tepat ketika: Sistem dirancang untuk menggunakan model data terhubung (*graph/network topology*) di mana satu titik simpul (*vertex*) dimiliki bersama oleh banyak garis. Menggeser satu simpul diharapkan secara reaktif menggeser seluruh garis yang terhubung padanya tanpa overhead duplikasi memori.
- **Sesudah Perbaikan (Defensive Copy)** lebih tepat ketika: Objek `Garis` harus bersifat mandiri (*encapsulated immutable entity*), terlindung dari *side-effects* yang tidak sengaja dilakukan oleh klien eksternal, dan aman digunakan dalam lingkungan konkurensi (*multi-threading thread-safety*).

#### 4. Seandainya Garis dibuat dengan extends Titik, masalah desain apa yang muncul ditinjau dari relasi is-a dan has-a?
- **Tinjauan `is-a`**: Terjadi pelanggaran konsep fundamental karena "Garis adalah Titik" (*a Line is a Point*) adalah pernyataan yang keliru. Garis memiliki panjang dan dua koordinat batas, sedangkan titik hanya merepresentasikan posisi tunggal.
- **Tinjauan `has-a`**: Secara struktural, garis tersusun atas dua titik (*a Line has-a start Point and has-a end Point*). Jika dipaksakan `extends Titik`, objek `Garis` secara aneh mewarisi sepasang atribut `(x, y)` milik superclass sebagai titik pangkal, lalu harus menambah atribut `Titik akhir` terpisah di tubuhnya. Hal ini merusak kohesi kelas, membingungkan pembaca kode, dan mencemari method titik (seperti apa arti `setX()` pada sebuah garis?).

---

### Bagian Analisis Konsep

#### 1. Perbedaan Method Overriding dan Method Overloading
Method *overloading* adalah teknik mendefinisikan beberapa method bernama sama di dalam satu kelas yang dibedakan berdasarkan variasi daftar parameternya, di mana penentuan method yang dipanggil terjadi pada saat kompilasi (*compile-time polymorphism* / *static binding*). Contoh penerapannya pada tugas ini terdapat pada kelas `soal3.Garis`, yang menyediakan konstruktor `Garis(Titik, Titik)` dan konstruktor overload `Garis(double, double, double, double)`. Sebaliknya, method *overriding* adalah pendefinisian ulang method milik superclass oleh subclass dengan nama, tipe kembalian, dan daftar parameter yang identik, di mana resolusi eksekusi dilakukan saat program berjalan (*runtime polymorphism* / *dynamic dispatch*). Contohnya diterapkan pada kelas `soal4.ProdukFisik` yang menimpa method `hitungHargaAkhir()` dari kelas `Produk`. Overriding sangat bergantung pada relasi pewarisan (*inheritance*) untuk merealisasikan fleksibilitas polimorfisme, sedangkan overloading dapat terjadi tanpa keterlibatan pewarisan.

#### 2. Kapan Memilih Inheritance dan Kapan Memilih Composition?
Inheritance (`is-a`) sebaiknya dipilih ketika terdapat hubungan taksonomi yang kokoh di mana subclass benar-benar merupakan spesialisasi murni dari superclass dan sanggup menggantikan perannya secara utuh tanpa melanggar kontrak perilaku (*Liskov Substitution Principle*). Contoh dari tugas ini adalah `LaptopGaming extends Laptop` dan `Laptop extends Perangkat`, karena laptop gaming secara alami adalah sebuah laptop dan memiliki seluruh sifat perangkat elektronik. Di sisi lain, composition (`has-a`) dipilih ketika suatu entitas dibentuk dari gabungan komponen-komponen mandiri, memerlukan fleksibilitas pergantian komponen pada saat runtime, atau ketika kita ingin menghindari keterikatan hirarki yang kaku (*favor composition over inheritance*). Contoh penerapannya adalah kelas `soal3.Garis` yang memiliki dua objek `Titik`, serta kelas `soal4.Keranjang` yang mengelola daftar `Produk`. Melalui komposisi, keranjang belanja tidak perlu menjadi turunan dari produk, melainkan berperan sebagai wadah modular penampung produk.

#### 3. Analisis Penggunaan `instanceof` pada Soal 4 dan Risiko Downcasting
Method `cetakStruk()` dan `hitungTotal()` tidak memerlukan `instanceof` karena kedua fungsionalitas tersebut bersandar penuh pada keunggulan polimorfisme dinamis (*dynamic method dispatch*); superclass `Produk` telah mendeklarasikan kontrak method `hitungHargaAkhir()` dan `deskripsi()` yang dioverride oleh tiap subclass, sehingga JVM secara otomatis mengeksekusi logika yang tepat sesuai objek konkret di keranjang. Sebaliknya, method `hitungPerJenis()` wajib menggunakan `instanceof` karena tujuannya adalah melakukan kategorisasi dan introspeksi tipe spesifik objek (*type introspection*) yang bukan merupakan bagian dari perilaku polimorfik umum produk. Pada `hitungPerJenis()`, pengecekan `Langganan` harus mendahului `ProdukDigital` karena `Langganan` adalah subclass dari `ProdukDigital`, sehingga pengecekan terbalik akan menyebabkan langganan keliru dihitung sebagai produk digital. Downcasting tidak selalu aman karena tipe statis superclass belum tentu menyimpan referensi objek yang sesuai di memori heap; memaksakan downcasting tanpa verifikasi `instanceof` akan melemparkan `ClassCastException` yang dapat menghentikan jalannya aplikasi secara mendadak.

---

## 7. Batasan dan Pengembangan Lanjutan
Meskipun sistem telah berhasil mengimplementasikan seluruh kebutuhan spesifikasi dan tantangan opsional dengan baik, terdapat beberapa batasan yang dapat dikembangkan lebih lanjut di masa depan:
- **Penyimpanan Data Persisten**: Data keranjang belanja dan katalog perangkat saat ini masih bersifat sementara (*in-memory*); integrasi basis data (seperti SQLite/PostgreSQL) atau serialisasi JSON/XML dapat ditambahkan agar data tidak hilang saat program ditutup.
- **Antarmuka Grafis (GUI / Web)**: Program saat ini berjalan berbasis Command Line Interface (CLI); pengembangan antarmuka visual berbasis JavaFX atau antarmuka web modern akan meningkatkan kenyamanan pengguna.
- **Sistem Diskon dan Kupon Fleksibel**: Logika diskon saat ini masih tertanam statis di dalam kelas produk; penerapan pola desain *Strategy Pattern* akan memungkinkan sistem menerapkan kombinasi kode promo, diskon hari raya, atau diskon bertingkat secara dinamis tanpa mengubah kode kelas produk.
- **Validasi Stok dan Inventaris**: Sistem belum membatasi kuantitas ketersediaan stok fisik; penambahan modul inventaris akan mencegah pelanggan memesan barang yang telah habis di gudang.
