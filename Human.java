import java.io.*;
import java.util.List;

public class Human implements Serializable {
    private String nameFIO;
    private Gender gender;
    private int age;

    private Parents parentsFIO;
    private BrothersSisters brothers_sistersFIO;
    private Сhildren childrenFIO;

    public Human(String nameFIO, Gender gender, int age, Parents parentsFIO, BrothersSisters brothers_sistersFIO, Сhildren childrenFIO){
        this.nameFIO = nameFIO;
        this.gender = gender;
        this.age = age;
        this.parentsFIO = parentsFIO;
        this.brothers_sistersFIO = brothers_sistersFIO;
        this.childrenFIO = childrenFIO;
    }

    public Human(String nameFIO, Gender gender, int age, Parents parentsFIO, BrothersSisters brothers_sistersFIO){
        this(nameFIO, gender, age, parentsFIO, brothers_sistersFIO, null);
    }

    public Human(String nameFIO, Gender gender, int age, Parents parentsFIO){
        this(nameFIO, gender, age, parentsFIO, null, null);
    }

    public Human(String nameFIO, Gender gender, int age){
        this(nameFIO, gender, age, null, null, null);
    }

    public Human(String nameFIO, Gender gender){
        this(nameFIO, gender, 0, null, null, null);
    }

    public Human(String nameFIO){
        this(nameFIO, null, 0, null, null, null);
    }

    public Human(){
        this("No name", null, 0, null, null, null);
    }

    public Human(String nameFIO, Gender gender, int age, Parents parentsFIO, Сhildren childrenFIO){
        this(nameFIO, gender, age, parentsFIO, null, childrenFIO);
    }

    public Human(String nameFIO, Gender gender, int age, Сhildren childrenFIO){
        this(nameFIO, gender, age, null, null, childrenFIO);
    }

    public Human(String nameFIO, Gender gender, Сhildren childrenFIO){
        this(nameFIO, gender, 0, null, null, childrenFIO);
    }

    public Human(String nameFIO, Сhildren childrenFIO){
        this(nameFIO, null, 0, null, null, childrenFIO);
    }

    public Human(String nameFIO, Gender gender, int age, BrothersSisters brothers_sistersFIO, Сhildren childrenFIO){
        this(nameFIO, gender, age, null, brothers_sistersFIO, childrenFIO);
    }

    public Human(String nameFIO, Gender gender, int age, BrothersSisters brothers_sistersFIO){
        this(nameFIO, gender, age, null, brothers_sistersFIO, null);
    }

    public Human(String nameFIO, Gender gender, BrothersSisters brothers_sistersFIO, Сhildren childrenFIO){
        this(nameFIO, gender, 0, null, brothers_sistersFIO, childrenFIO);
    }

    public Human(String nameFIO, BrothersSisters brothers_sistersFIO, Сhildren childrenFIO){
        this(nameFIO, null, 0, null, brothers_sistersFIO, childrenFIO);
    }

    public Human(String nameFIO, BrothersSisters brothers_sistersFIO){
        this(nameFIO, null, 0, null, brothers_sistersFIO, null);
    }

    public Human(String nameFIO, Gender gender, Parents parentsFIO, BrothersSisters brothers_sistersFIO, Сhildren childrenFIO){
        this(nameFIO, gender, 0, parentsFIO, brothers_sistersFIO, childrenFIO);
    }

    public Human(String nameFIO, Parents parentsFIO, BrothersSisters brothers_sistersFIO, Сhildren childrenFIO){
        this(nameFIO, null, 0, parentsFIO, brothers_sistersFIO, childrenFIO);
    }
    
    public Human(String nameFIO, Parents parentsFIO, Сhildren childrenFIO){
        this(nameFIO, null, 0, parentsFIO, null, childrenFIO);
    }

    public Human(String nameFIO, Parents parentsFIO){
        this(nameFIO, null, 0, parentsFIO, null, null);
    }

    public Human(String nameFIO, int age, Parents parentsFIO, BrothersSisters brothers_sistersFIO, Сhildren childrenFIO){
        this(nameFIO, null, age, parentsFIO, brothers_sistersFIO, childrenFIO);
    }

    public Human(String nameFIO, int age,  BrothersSisters brothers_sistersFIO, Сhildren childrenFIO){
        this(nameFIO, null, age, null, brothers_sistersFIO, childrenFIO);
    }

    public Human(String nameFIO, int age,  BrothersSisters brothers_sistersFIO){
        this(nameFIO, null, age, null, brothers_sistersFIO, null);
    }

    public String getHumanName(){
        return nameFIO;
    }

    public Gender getHumanGender(){
        if (gender != null){
            return gender;
        }
        return null;
    }

    public String getHumanParentFather(){
        if (parentsFIO != null){
            return parentsFIO.getParentFatherFIO();
        }
        return null;
    }

    public String getHumanParentMother(){
        if (parentsFIO != null){
            return parentsFIO.getParentMotherFIO();
        }
        return null;
    }

    public String getHumanParents(){
        if (parentsFIO != null){
            return parentsFIO.getParentsFIO();
        }
        return null;
    }

    public List<String> getHumanChildrenList(){
        if (childrenFIO != null){
            return childrenFIO.getСhildrenFIO();
        }
        return null;
    }

    public String getHumanChildren(){
        StringBuilder string_builder = new StringBuilder();
        if (childrenFIO != null){
            if (childrenFIO.getСhildrenFIO() == null ){
                return null;
            }
            for(String i: childrenFIO.getСhildrenFIO()){
                string_builder.append(i + ", ");
            }
            string_builder.replace(string_builder.length()-2, string_builder.length(), ".");
            return string_builder.toString();
        }
        return null;
    }

    public List<String> getHumanBrothersSistersList(){
        if (brothers_sistersFIO != null){
            return brothers_sistersFIO.getBrothersSistersFIO();
        }
        return null;
    }

    public String getHumanBrothersSisters(){
        StringBuilder string_builder = new StringBuilder();
        if (brothers_sistersFIO != null ){
            if (brothers_sistersFIO.getBrothersSistersFIO() == null ){
                return null;
            }
            for(String i: brothers_sistersFIO.getBrothersSistersFIO()){
                string_builder.append(i + ", ");
            }
            string_builder.replace(string_builder.length()-2, string_builder.length(), ".");
            return string_builder.toString();
        }
        return null;
    }

    public void setHumanParentFather(String txt) {
        if (parentsFIO == null){
            parentsFIO = new Parents();
            parentsFIO.setParentFatherFIO(txt);
        }
        else{
            parentsFIO.setParentFatherFIO(txt);
        }
    }

    public void setHumanParentMother(String txt) {
        if (parentsFIO == null){
            parentsFIO = new Parents();
            parentsFIO.setParentMotherFIO(txt);
        }
        else{
            parentsFIO.setParentMotherFIO(txt);
        }
    }

    public void setHumanChildren(String txt) {
        if (childrenFIO == null){
            childrenFIO = new Сhildren();
            childrenFIO.setСhildrenFIO(txt);
        }
        else{
            childrenFIO.setСhildrenFIO(txt);
        }
    }

    public void setHumanBrothersSisters(String txt) {
        if (brothers_sistersFIO == null){
            brothers_sistersFIO = new BrothersSisters();
            brothers_sistersFIO.setBrothersSistersFIO(txt);
        }
        else{
            brothers_sistersFIO.setBrothersSistersFIO(txt);
        }
    }

    public void delHumanBrothersSisters(String txt) {
        brothers_sistersFIO.delBrothersSistersFIO(txt);
    }

    public void delHumanChildren(String txt) {
        childrenFIO.delСhildrenFIO(txt);
    }

    public void delHumanParentFather() {
        parentsFIO.delParentFather();
    }

    public void delHumanParentMother() {
        parentsFIO.delParentMother();
    }

    @Override
    public String toString() {
        return nameFIO + " ... " + gender + " ... " + age;
    }
}