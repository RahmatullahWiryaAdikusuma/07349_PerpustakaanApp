package Entity;
public class pendaftarEntity extends UserEntityAbstract{
    private String npm,jurusan;
    public pendaftarEntity(){};
    public String getnpm(){
    return npm;
    }
    public void setnpm(String npm){
    this.npm=npm;
    }
    @Override
     public String getjurusan(){
    return jurusan;
    }
    @Override
    public void setjurusan(String jurusan){
    this.jurusan=jurusan;
    }

   
}
