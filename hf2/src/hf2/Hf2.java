package hf2;

import java.util.Scanner;
import java.util.Vector;

/**
 *
 * @author Sándor
 */
public class Hf2 {
    
    Scanner sc = new Scanner(System.in);
    
    private Vector<Student> students;

    public Hf2() {
        students = new Vector();
    }
    
    // A diákok bevitele:
    void bevitel() {
      Student ember;
      String nev;
      System.out.println("\nDiak neve: ");
      nev=sc.next();
      while (!nev.equals("0")) {
        ember = new Student(nev);
        if ( students.contains(ember))
          System.out.println("Van mar ilyen nevu diak!");
        else {
          students.add(ember);
          System.out.println("Letrehozva");
          
          /*System.out.println("neve: "); 
          ember.setName(sc.next());
          students.add(ember);*/
        }
        System.out.println("\nDiak neve: ");
        nev=sc.next();
      }
    }

    void lista4() {
      System.out.println("\n Created Students:");
      for (int i=0; i<students.size(); i++) {
        System.out.println(students.get(i).getName());
      }
      /*Student tmp = students.get(1);
      System.out.println(tmp.getName());*/
    }    
    
    public void menu() {
        int tmpavg;
        int note;
        boolean homework = false;
        
        String valasz;
        Scanner sc = new Scanner(System.in);  //Standerd input objektum.
        do {
            System.out.println("\n *** \n ud-uj_diakok_hozzadasa \n jadd-jegy_hozzaadasa_nevhez \n beadadd-Beadando_hozzadasa \n zhadd-mindne_diaknak_sorban_jegybeiras \n kiir-minden_adatot_kilistaz \n \n v-kilepes \n *** \n");
            valasz = sc.next();
            switch (valasz) {
                case "ud":
                    System.out.println("Add meg a diakok neveit sorban, a ciklusbol kilepeshez hasznald a '0'-t");
                    this.bevitel();
                    break;
                case "jadd":
                    System.out.println("Diak neve:");
                    String tmpname = sc.nextLine();
                    System.out.println("Diak neve2:");
                    tmpname = sc.nextLine();
                    jegyadas(tmpname);
                    break;
                case "kiir":
                    listAllData();
                    break;
                case "beadadd":
                    beadandoadas();
                    break;
                case "zhadd":
                    zhjegybeiras();
                    break;
                default :
                    System.out.println("FIGYELEM Ilyen opcio nincs a menuben");
            }
        } while (!valasz.equals("v"));
    }
    
    public void zhjegybeiras(){
        System.out.println("Add meg a jegyeket a nevekhez");
        int tmpnote = 0;
        int tmpidx = 0;
        for (Student t : students) {
            System.out.print(t.getName()+":\t");
            tmpnote = sc.nextInt();
            students.get(tmpidx).setNrofnotes(students.get(tmpidx).getNrofnotes()+1);
            students.get(tmpidx).setAvg((int) ((students.get(tmpidx).getAvg()+tmpnote)/students.get(tmpidx).getNrofnotes()));
            ++tmpidx;
        }
    }
    
    public void beadandoadas(){
        String tmpname ="";
        System.out.println("Add meg a diak nevet:");
        tmpname = sc.nextLine();
        System.out.println("Add meg a diak nevet2:");
        tmpname = sc.nextLine();
        int tmpidx = kereses(tmpname);
        
        if(tmpidx>(-1)){
            System.out.println("Valtoztass a beadando allapotan: (i/n | i-van n-nincs)");
            String tmpnote = sc.nextLine();
            if(tmpnote.equals("i")){
                students.get(tmpidx).setHomework(true);
            }else{
                students.get(tmpidx).setHomework(false);
            }
        }else{
            System.out.println("FIGYELEM  Nincs ilyen diak!");
        }
    }
    
    public void listAllData(){
        System.out.println("A teljes diakbazis minden adata:");
        
        Student bestStudent = new Student("tmp");
        int tmpgyakjegyszamlalo = 0;
        int avg = 0;
        
        for (Student t : students) {
          System.out.println(t.getName()+ "\t jegyeinek szama: " + t.getNrofnotes() + "\t atlaga: " + t.getAvg() + "\t beadando van-e: " + t.isHomework());
          if(t.getAvg()>= bestStudent.getAvg() ){
              bestStudent.setAvg(t.getAvg());
              bestStudent.setName(t.getName());
              bestStudent.setHomework(t.isHomework());
              bestStudent.setNrofnotes(t.getNrofnotes());
          }
          
          if(t.isHomework()){
              ++tmpgyakjegyszamlalo;
          }
          
          avg += t.getAvg();
        }
        
        System.out.println("---");
        System.out.println("A legjobb tanulo: "+ bestStudent.getName()+ "\t jegyeinek szama: " + bestStudent.getNrofnotes() + "\t atlaga: " + bestStudent.getAvg() + "\t beadando van-e: " + bestStudent.isHomework());
        System.out.println(tmpgyakjegyszamlalo + " db diak kaphat gyakjegyet");
        System.out.println("Atlag: "+(avg/students.size()));
        System.out.println("---");
    }
    
    public void jegyadas(String name){
        //System.out.println("LOG  jegyadas indul");
        //System.out.println("LOG  megadott nev: "+name);
        int tmpidx = kereses(name);
        //System.out.println("LOG  kereses vege");
        //System.out.println("LOG  visszakapott ertek: "+tmpidx);
        if(tmpidx != (-1)){
            System.out.println("Add meg az uj jegyet: ");
            int tmpnote = sc.nextInt();
            students.get(tmpidx).setNrofnotes(students.get(tmpidx).getNrofnotes()+1);
            students.get(tmpidx).setAvg((int) ((students.get(tmpidx).getAvg()+tmpnote)/students.get(tmpidx).getNrofnotes()));
        } else {
            System.out.println("FIGYELEM  Nincs ilyen diak!");
        }
    }
    
    int kereses(String nev) {
      //System.out.println("LOG  kereses indul");  
      //System.out.println("LOG  megadott nev: "+nev);  
      boolean found = false;
      Integer idx = 0;
      Integer len = students.size();
      while((!found) || (idx.equals(len+1))){
          if (students.get(idx).getName().equals(nev)){
              found = true;
              return idx;
          } else {
            ++idx;  
          }
      }
      return -1;
    }    
    
    public static void main(String[] args) {
        Hf2 st = new Hf2();
        st.menu();
        /*System.out.println("Add meg a diakok neveit sorban, a ciklusbol kilepeshez hasznald a '0'-t");
        st.bevitel();
        st.lista4();
       
        System.out.println("Add meg a diakok neveit sorban, a ciklusbol kilepeshez hasznald a '0'-t");        */
        //st.lista4();
    }
}
