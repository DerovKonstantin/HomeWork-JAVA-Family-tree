import java.io.*;

public class Mother implements Serializable {
    private String motherFIO;

    public Mother(String motherFIO){
        this.motherFIO = motherFIO;
    }

    public Mother(){
        this(null);
    }

    public String getMother(){
        if (motherFIO != null){
            return motherFIO;
        }
        return null;
    }

    public void setmotherFIO(String txt) {
        this.motherFIO = txt;
    }

    public void delMother() {
        this.motherFIO = null;
    }

}

