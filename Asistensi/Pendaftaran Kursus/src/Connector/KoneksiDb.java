package Connector;
import java.sql.*;//import sql

public class KoneksiDb {
    
    // Menyiapkan paramter JDBC untuk koneksi ke datbase
    static String driver = "com.mysql.cj.jdbc.Driver";
    static final String url = "jdbc:mysql://localhost:3306/db_pendaftar";
    static final String USER = "root";
    static final String PASS = "";

    // Menyiapkan objek yang diperlukan untuk mengelola database
    static Connection conn;
    static Statement stmt;
    static ResultSet rs;

    public static void main(String[] args) {
        
        // Melakukan koneksi ke database
        // harus dibungkus dalam blok try/catch
        try {
            // register driver yang akan dipakai
            Class.forName(driver);
            
            // buat koneksi ke database
            conn = DriverManager.getConnection(url, USER, PASS);
            
            // buat objek statement
            stmt = conn.createStatement();
            
            // buat query ke database
            String sql = "SELECT * FROM pendaftar";
            
            // eksekusi query dan simpan hasilnya di obj ResultSet = tabel selector
            rs = stmt.executeQuery(sql);
            
            // tampilkan hasil query
            while(rs.next()){
                System.out.println("ID Pendaftar: " + rs.getInt("id"));
                System.out.println("Nama pendaftar : " + rs.getString("nama"));
                System.out.println("Npm pendaftar  : " + rs.getString("npm"));
                System.out.println("Alamat pendaftar :" + rs.getString("alamat"));
                System.out.println("jurusan : "+ rs.getString("jurusan"));
            }
            
            stmt.close();//menutup statement
            conn.close();//menutup database
            
      
       }catch(Exception e){} //eror handler
    }
}