package gudangsepatu07349;

public class Admin07349 extends BiodataAdmin07349{
    private String password07349;
    
    public Admin07349(String nama07349, String kode07349, String alamat07349) {
        super(nama07349, kode07349, alamat07349);
        this.password07349=password07349;
    }
   public String getPassword(){
   return password07349;
   }
   public void setPassword(String password07349){
   this.password07349=password07349;
   }
}
