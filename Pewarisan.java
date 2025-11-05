
// File: InheritanceExamples.java
// Tiga contoh: pewarisan sederhana, multilevel inheritance, dan access modifier

// 1️⃣ Pewarisan Sederhana
class AlatMusik {
    String nama;

    public void mainkan() {
        System.out.println("Alat musik sedang dimainkan...");
    }
}

class Gitar extends AlatMusik {
    int jumlahSenar;

    @Override
    public void mainkan() {
        System.out.println("Gitar dipetik menghasilkan suara merdu 🎸");
    }

    public void tuning() {
        System.out.println("Menyetem senar gitar...");
    }
}

// 2️⃣ Multilevel Inheritance
class Pegawai {
    String nama;
    double gaji;

    public void tampilData() {
        System.out.println("Nama Pegawai: " + nama);
        System.out.println("Gaji: Rp" + gaji);
    }
}

class Manajer extends Pegawai {
    String departemen;

    public void kelolaTim() {
        System.out.println("Manajer mengelola tim di departemen " + departemen);
    }
}

class Direktur extends Manajer {
    double bonusTahunan;

    public void tampilSemuaData() {
        tampilData();
        System.out.println("Departemen: " + departemen);
        System.out.println("Bonus Tahunan: Rp" + bonusTahunan);
    }
}

// 3️⃣ Access Modifier
class AkunBank {
    private String nomorRekening;
    protected double saldo;
    public String namaPemilik;

    public AkunBank(String namaPemilik, String nomorRekening, double saldo) {
        this.namaPemilik = namaPemilik;
        this.nomorRekening = nomorRekening;
        this.saldo = saldo;
    }

    private void tampilNomorRekening() {
        System.out.println("Nomor Rekening (private): " + nomorRekening);
    }

    public void infoAkun() {
        tampilNomorRekening();
        System.out.println("Nama Pemilik: " + namaPemilik);
        System.out.println("Saldo: Rp" + saldo);
    }
}

class RekeningTabungan extends AkunBank {
    public RekeningTabungan(String nama, String noRek, double saldo) {
        super(nama, noRek, saldo);
    }

    public void setor(double jumlah) {
        saldo += jumlah;
        System.out.println("Setor Rp" + jumlah + " berhasil. Saldo baru: Rp" + saldo);
    }

    public void tampilPemilik() {
        System.out.println("Pemilik rekening: " + namaPemilik);
    }
}

// Main Class
public class InheritanceExamples {
    public static void main(String[] args) {
        System.out.println("=== 1. Pewarisan Sederhana ===");
        Gitar gitar = new Gitar();
        gitar.nama = "Gitar Akustik";
        gitar.jumlahSenar = 6;
        System.out.println("Nama alat musik: " + gitar.nama);
        gitar.mainkan();
        gitar.tuning();

        System.out.println("\n=== 2. Multilevel Inheritance ===");
        Direktur dir = new Direktur();
        dir.nama = "Budi Santoso";
        dir.gaji = 15000000;
        dir.departemen = "Keuangan";
        dir.bonusTahunan = 5000000;
        dir.tampilSemuaData();
        dir.kelolaTim();

        System.out.println("\n=== 3. Access Modifier ===");
        RekeningTabungan rt = new RekeningTabungan("Andi", "1234567890", 500000);
        rt.infoAkun();
        rt.setor(200000);
        rt.tampilPemilik();
    }
}
