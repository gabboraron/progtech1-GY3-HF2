package hf2;

/**
 * @author buriansandor
 */
public class Student {
     protected int nrofnotes = 0;
     protected int avg = 0;
     protected boolean homework = false;
     protected String name = "";

    public Student(String name) {
        this.name = name;
    }
     
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean isHomework() {
        return homework;
    }

    public void setNrofnotes(int nrofnotes) {
        this.nrofnotes = nrofnotes;
    }

    public void setAvg(int avg) {
        this.avg = avg;
    }

    public void setHomework(boolean homework) {
        this.homework = homework;
    }

    public int getNrofnotes() {
        return nrofnotes;
    }

    public int getAvg() {
        return avg;
    }    
}
