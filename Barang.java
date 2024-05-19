/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exam;

import java.util.Scanner;
import java.util.function.Function;
/**
 *
 * @author Asus
 */
public class Barang {
   public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // input jumlah data barang
        System.out.print("Masukkan jumlah data barang: ");
        int jumlahData = Integer.parseInt(scanner.nextLine());

        // array untuk menyimpan data barang
        String[] namaBarang = new String[jumlahData];
        int[] quantity = new int[jumlahData];
        int[] beratBarang = new int[jumlahData];

        // input data barang dengan validasi
        for (int i = 0; i < jumlahData; i++) {
            boolean isValid = false;

            while (!isValid) {
                System.out.println("\nMasukkan data barang ke-" + (i + 1) + ":");

                System.out.print("Nama barang (3-20 karakter): ");
                namaBarang[i] = scanner.nextLine();
                if (namaBarang[i].length() < 3 || namaBarang[i].length() > 20) {
                    System.out.println("Nama tidak valid. Harus antara 3-20 karakter.");
                    continue;
                }

                System.out.print("Quantity (1-100): ");
                quantity[i] = Integer.parseInt(scanner.nextLine());
                if (quantity[i] < 1 || quantity[i] > 100) {
                    System.out.println("Quantity tidak valid. Harus antara 1-100.");
                    continue;
                }

                System.out.print("Berat barang (1-100 kg): ");
                beratBarang[i] = Integer.parseInt(scanner.nextLine());
                if (beratBarang[i] < 1 || beratBarang[i] > 100) {
                    System.out.println("Berat barang tidak valid. Harus antara 1-100 kg.");
                    continue;
                }

                isValid = true; // jika semua input valid, akan keluar dari looping
            }
        }

        // lambda expression untuk menghitung jumlah berat barang
        Function<int[][], Integer> calculateTotalWeight = (data) -> {
            int totalBerat = 0;
            for (int i = 0; i < data[0].length; i++) {
                totalBerat += data[0][i] * data[1][i];
            }
            return totalBerat;
        };

        // hitung jumlah berat barang menggunakan lambda expression
        int totalBerat = calculateTotalWeight.apply(new int[][]{quantity, beratBarang});

        // menampilkan hasil
        System.out.println("\nTotal berat barang: " + totalBerat + " kg");
    }
}

