/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
/**
 *
 * @author Asus
 */
public class Pengiriman {
    private String kodePengiriman;
    private int jarakTempuh;
    private String alamatAsal;
    private String alamatTujuan;
    private Date waktuPengiriman;
    private int durasiPengiriman;
    private String hitungKemungkinanTiba;
    private int hargaOngkir;

    public Pengiriman(String kodePengiriman, int jarakTempuh, String alamatAsal, String alamatTujuan, Date waktuPengiriman) {
        this.kodePengiriman = kodePengiriman;
        this.jarakTempuh = jarakTempuh;
        this.alamatAsal = alamatAsal;
        this.alamatTujuan = alamatTujuan;
        this.waktuPengiriman = waktuPengiriman;
        this.durasiPengiriman = hitungDurasiPengiriman(jarakTempuh);
        this.hitungKemungkinanTiba = hitungKemungkinanTiba();
        this.hargaOngkir = hitungHargaOngkir(jarakTempuh);
    }

    // untuk menghitung durasi pengiriman berdasarkan jarak tempuh
    private int hitungDurasiPengiriman(int jarakTempuh) {
        return (int) Math.ceil((double) jarakTempuh / 60);
    }

    // untuk menghitung harga ongkir berdasarkan jarak tempuh
    private int hitungHargaOngkir(int jarakTempuh) {
        int hargaPer10Km = 1000;
        int minimalOngkir = 6000;
        int harga = (int) Math.ceil((double) jarakTempuh / 10) * hargaPer10Km;
        return Math.max(harga, minimalOngkir);
    }
    
    // penjumlahan antara tanggal pengiriman dan durasi pengiriman
    // untuk menentukan tanggal kemungkinan tiba
    private String hitungKemungkinanTiba() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(waktuPengiriman);
        calendar.add(Calendar.DAY_OF_MONTH, durasiPengiriman);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        return dateFormat.format(calendar.getTime());
    }
    
    // untuk menampilkan data pengiriman
    public void tampilkanDataPengiriman() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        System.out.println("Kode Pengiriman: " + kodePengiriman);
        System.out.println("Jarak Tempuh (km): " + jarakTempuh);
        System.out.println("Alamat Asal: " + alamatAsal);
        System.out.println("Alamat Tujuan: " + alamatTujuan);
        System.out.println("Waktu Pengiriman: " + dateFormat.format(waktuPengiriman));
        System.out.println("Durasi Pengiriman: " + durasiPengiriman + " hari");
        System.out.println("Kemungkinan Tiba : " + hitungKemungkinanTiba);
        System.out.println("Harga Ongkir: Rp " + hargaOngkir);
    }

    public static Pengiriman inputPengiriman() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Masukkan kode pengiriman: ");
        String kodePengiriman = scanner.nextLine();

        System.out.println("Masukkan jarak tempuh (km): ");
        int jarakTempuh = Integer.parseInt(scanner.nextLine());

        System.out.println("Masukkan alamat asal: ");
        String alamatAsal = scanner.nextLine();

        System.out.println("Masukkan alamat tujuan: ");
        String alamatTujuan = scanner.nextLine();

        System.out.println("Masukkan waktu pengiriman (dd-mm-yyyy): ");
        String inputWaktu = scanner.nextLine();
        Date waktuPengiriman = null;
        try {
            waktuPengiriman = new SimpleDateFormat("dd-MM-yyyy").parse(inputWaktu);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return new Pengiriman(kodePengiriman, jarakTempuh, alamatAsal, alamatTujuan, waktuPengiriman);
    }
    
    public int getHargaOngkir() {
        return hargaOngkir;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Masukkan Data Pengiriman ===");
        Pengiriman pengiriman = Pengiriman.inputPengiriman();

        System.out.println("\n=== Data Pengiriman ===");
        pengiriman.tampilkanDataPengiriman();
    }
}
