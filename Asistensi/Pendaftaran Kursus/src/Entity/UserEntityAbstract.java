package Entity;
public abstract class UserEntityAbstract {
  protected int id;
  protected String nama, npm, jurusan,alamat;
 public UserEntityAbstract(){}
public UserEntityAbstract(String nama, String npm, String jurusan, String alamat){
    this.jurusan=jurusan;
    this.alamat=alamat;
}public int getId(){
    return id;
}public void setId(int id){
    this.id=id;
}public void setnpm(String npm){
    this.npm=npm;
}public String getjurusan(){
    return jurusan;
}public void setjurusan(String jurusan){
    this.jurusan=jurusan;
}public String getalamat(){
    return alamat;
}public void setalamat(String alamat){
    this.alamat=alamat;
}
}