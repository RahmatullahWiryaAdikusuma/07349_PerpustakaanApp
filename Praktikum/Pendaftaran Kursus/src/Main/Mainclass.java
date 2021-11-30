package Main;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.sql.DriverManager;
import java.sql.Connection;


import java.sql.Statement;
import java.sql.ResultSet;

public class Mainclass {

    static String driver = "com.mysql.cj.jdbc.Driver";
    static final String url = "jdbc:mysql://localhost:3306/db_pendaftar";
    static final String USER = "root";
    static final String PASS = "";

    static Connection conn;
    static Statement stmt;
    static ResultSet rs;
    static InputStreamReader inputStreamReader = new InputStreamReader(System.in);
    static BufferedReader input = new BufferedReader(inputStreamReader);

    public static void main(String[] args) {

        try {
            // register driver
            Class.forName(driver);

            conn = DriverManager.getConnection(url, USER, PASS);
            stmt = conn.createStatement();

            while (!conn.isClosed()) {
                showMenu();
            }

            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    static void showMenu() {
        System.out.println(" MENU UTAMA ");
        System.out.println("1. Insert Data Pendaftar");
        System.out.println("2. Show Data Pendaftar");
        System.out.println("3. Edit Data Pendaftar");
        System.out.println("4. Delete Data Pendaftar");
        System.out.println("5. Keluar");
        System.out.print("PILIHAN => ");

        try {
            int pilihan = Integer.parseInt(input.readLine());

            switch (pilihan) {
                case 5:
                    System.exit(0);
                    break;
                case 1:
                    insertpendaftar();
                    break;
                case 2:
                    showData();
                    break;
                case 3:
                    updatependaftar();
                    break;
                case 4:
                    deletependaftar();
                    break;
                default:
                    System.out.println("Pilihan salah!");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void showData() {
        String sql = "SELECT *FROM pendaftar";

        try {
            rs = stmt.executeQuery(sql);
            
            System.out.println("+--------------------------------+");
            System.out.println("|    DATA PENDAFTAR KURSUS  |");
            System.out.println("+--------------------------------+");

            while (rs.next()) {
                int id = rs.getInt("id");
                String nama = rs.getString("nama");
                String npm = rs.getString("npm");
                String jurusan = rs.getString("jurusan");
                String alamat = rs.getString("alamat");
                
                System.out.println(String.format("%d. %s. %s. %s. %s", id, nama, npm, jurusan, alamat));
            }

        } catch (Exception e) {} //eror handler
    }

    static void insertpendaftar() {
        try {
            // ambil input dari user
            System.out.print("Nama : ");
            String nama = input.readLine().trim();//menghapus semua spasi dari teks kecuali satu spasi antar kata
            System.out.print("Npm : ");
            String npm = input.readLine().trim();
            System.out.print("jurusan : ");
            String jurusan = input.readLine().trim();
            System.out.print("Alamat : ");
            String alamat = input.readLine().trim();
            // query simpan
            String sql = "INSERT INTO pendaftar (nama, npm, jurusan, alamat) VALUE('%s', '%s', '%s', '%s')";
            sql = String.format(sql, nama, npm, jurusan, alamat);

            stmt.execute(sql);//Simpan data database
            
        } catch (Exception e) {
        }

    }

    static void updatependaftar() {
        try {
            
            // ambil input dari user
            System.out.print("ID Pendaftar yang mau diedit: ");
            int id = Integer.parseInt(input.readLine());
            System.out.print("Nama : ");
            String nama = input.readLine().trim();
            System.out.print("Npm : ");
            String npm = input.readLine().trim();
            System.out.println("jurusan : ");
            String jurusan = input.readLine().trim();
            System.out.println("Alamat : ");
            String alamat = input.readLine().trim();

            // query update
            String sql = "UPDATE pendaftar SET nama='%s', npm='%s', jurusan='%s', alamat='%s', WHERE id=%d";
            sql = String.format(sql, nama, npm, jurusan, alamat, id);

            // update data pendaftar
            stmt.execute(sql);
            
        } catch (Exception e) {
        }
    }

    static void deletependaftar() {
        try {
            
            System.out.print("ID pendaftar yang mau dihapus: ");
            int idpendaftar = Integer.parseInt(input.readLine());//mengubah String mjd desimal/int dan membaca input user
            
            // buat query hapus
            String sql = String.format("DELETE FROM pendaftar WHERE id=%d", idpendaftar);

            // hapus data
            stmt.execute(sql);
            
            System.out.println("Data telah terhapus...");
        } catch (Exception e) {          
        }
    }

    public static Connection getconection() {
        throw new UnsupportedOperationException("Not supported yet."); //membuang eror
    }
}
   
