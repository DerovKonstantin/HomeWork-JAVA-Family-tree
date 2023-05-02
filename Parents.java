import java.io.*;

public class Parents implements Serializable {
    private Father parent_fatherFIO;
    private Mother parent_motherFIO;

    public Parents(Father parent_fatherFIO, Mother parent_motherFIO){
        this.parent_fatherFIO = parent_fatherFIO;
        this.parent_motherFIO = parent_motherFIO;
    }

    public Parents(Father parent_fatherFIO){
        this(parent_fatherFIO, null);
    }

    public Parents(Mother parent_motherFIO){
        this(null, parent_motherFIO);
    }

    public Parents(){
        this(null, null);
    }

    public String getParentFatherFIO(){
        if (parent_fatherFIO != null){
            return parent_fatherFIO.getFather();
        }
        return null;
    }

    public String getParentMotherFIO(){
        if (parent_motherFIO != null){
            return parent_motherFIO.getMother();
        }
        return null;
    }

    public String getParentsFIO(){
        StringBuilder string_builder = new StringBuilder();
        if (parent_fatherFIO != null & parent_motherFIO == null){
            string_builder.append(parent_fatherFIO.getFather() + ".");
        }
        if (parent_fatherFIO == null & parent_motherFIO != null){
            string_builder.append(parent_motherFIO.getMother() + ".");
        }
        if (parent_fatherFIO != null & parent_motherFIO != null){
            string_builder.append(parent_fatherFIO.getFather() + ", " + parent_motherFIO.getMother() + ".");
        }
        return string_builder.toString();
    }

    public void setParentFatherFIO(String txt) {
        if (parent_fatherFIO == null){
            parent_fatherFIO = new Father();
            parent_fatherFIO.setfatherFIO(txt);
        }
        else{
            parent_fatherFIO.setfatherFIO(txt);
        }
    }

    public void setParentMotherFIO(String txt) {
        if (parent_motherFIO == null){
            parent_motherFIO = new Mother();
            parent_motherFIO.setmotherFIO(txt);
        }
        else{
            parent_motherFIO.setmotherFIO(txt);
        }
    }

    public void delParentFather() {
        parent_fatherFIO.delFather();
    }

    public void delParentMother() {
        parent_motherFIO.delMother();
    }

}
