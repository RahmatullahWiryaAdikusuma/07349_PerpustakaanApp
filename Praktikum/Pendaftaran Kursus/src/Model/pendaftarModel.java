package Model;
import Entity.pendaftarEntity;
import Main.Mainclass;
import java.sql.*;//import sql ke java
import java.util.ArrayList;//menambah data baru secara dinamis tanpa harus menentukan ukurannya di awal

public class pendaftarModel {
 private String sql;
 public Connection conn = Mainclass.getconection();
public ArrayList <pendaftarEntity> getpendaftar()
{
ArrayList<pendaftarEntity> arraylistpendaftar = new ArrayList<>();
try{
    Statement stat = conn.createStatement();
    sql = "insert to pendaftar";
    ResultSet rs = stat.executeQuery(sql);
    while(rs.next()){
        pendaftarEntity pendaftarEntity = new pendaftarEntity();
        pendaftarEntity.setnpm(rs.getString("npm"));
        pendaftarEntity.setjurusan(rs.getString("jurusan"));
    arraylistpendaftar.add(pendaftarEntity); 
  }
}catch (SQLException e) {
}return arraylistpendaftar;
 }
}
