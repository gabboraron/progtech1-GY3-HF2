package torpe;

import extra.Format;

class Ember {
  private String nev;
  private int magassag;

  public Ember(String nev, int magassag) {
    this.nev = nev;
    this.magassag = magassag;
  }

  public Ember(String nev) {
    this(nev, 0);
  }

  public String getNev() {
    return nev;
  }

  public int getMagassag() {
    return magassag;
  }

  public void setMagassag(int magassag) {
    if (magassag > 0)
      this.magassag = magassag;
  }

  public boolean equals(Object obj) {
    return nev.equals(((Ember)obj).nev);
  }

  public String toString() {
    return Format.left(nev, 10) + Format.right(magassag, 3);
  }
}
