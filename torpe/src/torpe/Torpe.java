package torpe;

//import extra.Console;
import java.util.Scanner;
import java.util.Vector;

public class Torpe {
  Scanner sc = new Scanner(System.in);  //Standerd input objektum.
  
  private Vector torpek;

  public Torpe() {
    torpek = new Vector();
  }

  // A törpök bevitele:
  void bevitel() {
    Ember ember;
    String nev;
    System.out.println("\nTorpe neve: ");
    nev=sc.next();
    while (!nev.equals("0")) {
      ember = new Ember(nev);
      if (torpek.contains(ember))
        System.out.println("Van mar ilyen torpe!");
      else {
        System.out.println("magassaga: "); 
        ember.setMagassag(sc.nextInt());
        torpek.add(ember);
      }
      System.out.println("\nTorpe neve: ");
      nev=sc.next();
    }
  }

  // Egyszerű lista, beépített módon:
  void lista1() {
    System.out.println("\nBeepitett lista:");
    System.out.println(torpek);
  }

  // torpek listázása index szerint, toString()-gel:
  void lista2() {
    System.out.println("\nLista index szerint:");
    for (int i=0; i<torpek.size(); i++) {
      System.out.println(torpek.get(i));
    }
  }

  // Listázás toString() nélkül:
  void lista3() {
    Ember ember;
    System.out.println("\nEgyeni lista:");
    for (int i = 0; i < torpek.size(); i++) {
      ember = (Ember)torpek.get(i);
      System.out.println("Nev: " + ember.getNev() +
        "  Magassag: " + ember.getMagassag());
    }
  }

  void lista4() {
    System.out.println("\nfor-each ciklussal:");
    for (Object t : torpek) {
      System.out.println(t);
    }
  }

  // Egy törpe megkeresése:
  void kereses() {
    System.out.println("\nKereses:");
    String nev;
    System.out.println("Torpe neve: ");
    nev=sc.next();
    Ember keresettEmber = new Ember(nev);
    int poz = torpek.indexOf(keresettEmber);
    if (poz >= 0)
      System.out.println("Van, magassaga:"+
        ((Ember)(torpek.get(poz))).getMagassag());
    else
      System.out.println("Nincs ilyen");
  }

  public static void main(String[] args) {   
    Torpe tp = new Torpe(); 
    tp.bevitel();
    tp.lista1();
    tp.lista2();
    tp.lista3();
    tp.lista4();
    tp.kereses();
  }
}
