import java.io.*;

public class Father implements Serializable {
    private String fatherFIO;

    public Father(String fatherFIO){
        this.fatherFIO = fatherFIO;
    }

    public Father(){
        this(null);
    }

    public String getFather(){
        if (fatherFIO != null){
            return fatherFIO;
        }
        return null;
    }

    public void setfatherFIO(String txt) {
        this.fatherFIO = txt;
    }

    public void delFather() {
        this.fatherFIO = null;
    }

}
