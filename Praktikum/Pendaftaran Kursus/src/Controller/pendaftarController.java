package Controller;
import Entity.pendaftarEntity;
import java.util.ArrayList;

public class pendaftarController {
       public ArrayList<pendaftarEntity> getDatapendaftar(){    
return AllObjectModel.pendaftarModel.getpendaftar();
   }
}
