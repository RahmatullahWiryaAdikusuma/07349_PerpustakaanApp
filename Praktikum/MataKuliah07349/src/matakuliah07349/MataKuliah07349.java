package matakuliah07349; 
import java.util.Scanner; 

public class MataKuliah07349 { 
    public static void main(String[] args) {
     Scanner input07349 =new Scanner(System.in); 
        int i07349=1,jumlahMk07349;
        String nama07349,npm07349,jurusan07349;
        String mataKuliah07349[]=new String[15];
        String grade07349[]=new String[15];
        int uts07349[]=new int[15];
        int uas07349[]=new int[15];
        double nilai07349[]=new double[15];
        
        System.out.println("|==================================|");
        System.out.println("|  ++Menghitung Nilai Mahasiswa++  |");
        System.out.println("|==================================|");
        System.out.print("   Masukan Jumlah Mata Kuliah: "); 
        jumlahMk07349 = input07349.nextInt();
        System.out.println("==================================");
        System.out.print("  Nama     : ");
        nama07349 = input07349.next();
        System.out.print("  NPM      : ");
        npm07349 = input07349.next();
        System.out.print("  Jurusan  : ");
        jurusan07349 = input07349.next();    
        System.out.println("==============================");
        
        do{//maka program akan melakukan
            System.out.print("\n Mata kuliah ke-"+i07349+" : ");
            mataKuliah07349[i07349] = input07349.next();
            System.out.print(" Nilai UTS  : ");
            uts07349[i07349] = input07349.nextInt();
            System.out.print(" Nilai UAS  : ");
            uas07349[i07349] = input07349.nextInt();
            nilai07349[i07349] = ((uts07349[i07349]*0.7)+(uas07349[i07349]*0.3));
        
                if (nilai07349[i07349]>=70) grade07349[i07349]="LULUS";
                    else if (nilai07349[i07349]<=70) grade07349[i07349]="GUGUR";                  
                            else grade07349[i07349]="GUGUR"; 
            i07349++;
        }while(i07349<=jumlahMk07349);
            
        System.out.println("\n==================================");
        System.out.println("\n\n Nama: "+nama07349+"            NPM: "+npm07349);
        System.out.println("=========================================");
        System.out.println(" Mata Kuliah             Nilai      Grade");
        System.out.println("=========================================");
        for(i07349=1;i07349<=jumlahMk07349;i07349++){
        System.out.println(" "+mataKuliah07349[i07349]+"                   "+nilai07349[i07349]+"       "+grade07349[i07349]);
            }
        System.out.println("\n\n===========");
        System.out.println(" Terima Kasih ");
        System.out.println("==============");
        System.exit(0);
    }
    
}

