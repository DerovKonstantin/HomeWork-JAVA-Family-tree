//import java.util.List;

public class Human {
    private Parents p;
    private Brothers_Sisters bs;
    private Children c;

    private String nameFIO;
    private Gender gender;
    private int age;

    private String parentsFIO;
    private String brothers_SistersFIO;
    private String childrenFIO;

    public Human(String nameFIO, Gender gender, int age, Parents p, String pFIO, Brothers_Sisters bs, String bsFIO, Children c, String cFIO){
        this.nameFIO = nameFIO;
        this.gender = gender;
        this.age = age;
        this.parentsFIO = pFIO;
        this.brothers_SistersFIO = bsFIO;
        this.childrenFIO = cFIO;
    }
    
// Перегрузка ------------------------------------------
  
    public Human(String nameFIO, Gender gender, int age, Parents p, String pFIO, Brothers_Sisters bs, String bsFIO){
        this(nameFIO, gender, age, null, pFIO, null, bsFIO, null," - ");
    }

    public Human(String nameFIO, Gender gender, int age, Parents p, String pFIO, Children c, String cFIO){
        this(nameFIO, gender, age, null, pFIO, null, " - ", null, cFIO);
    }

    public Human(String nameFIO, Gender gender, int age, Brothers_Sisters bs, String bsFIO, Children c, String cFIO){
        this(nameFIO, gender, age, null, " - ", null, bsFIO, null, cFIO);
    }

    public Human(String nameFIO, Gender gender, int age, Parents p, String pFIO){
        this(nameFIO, gender, age, null, pFIO, null, " - ", null, " - ");
    }

    public Human(String nameFIO, Gender gender, int age, Brothers_Sisters bs, String bsFIO){
        this(nameFIO, gender, age, null, " - ", null, bsFIO, null, " - ");
    }

    public Human(String nameFIO, Gender gender, int age, Children c, String cFIO){
        this(nameFIO, gender, age, null, " - ", null, " - ", null, cFIO);
    }

    public Human(String nameFIO, Gender gender, int age){
        this(nameFIO, gender, age, null, " - ", null, " - ", null, " - ");
    }

//------------- age = 0

    public Human(String nameFIO, Gender gender, Parents p, String pFIO, Brothers_Sisters bs, String bsFIO){
        this(nameFIO, gender, 0, null, pFIO, null, bsFIO, null," - ");
    }

    public Human(String nameFIO, Gender gender, Parents p, String pFIO, Children c, String cFIO){
        this(nameFIO, gender, 0, null, pFIO, null, " - ", null, cFIO);
    }

    public Human(String nameFIO, Gender gender, Brothers_Sisters bs, String bsFIO, Children c, String cFIO){
        this(nameFIO, gender, 0, null, " - ", null, bsFIO, null, cFIO);
    }

    public Human(String nameFIO, Gender gender, Parents p, String pFIO){
        this(nameFIO, gender, 0, null, pFIO, null, " - ", null, " - ");
    }

    public Human(String nameFIO, Gender gender, Brothers_Sisters bs, String bsFIO){
        this(nameFIO, gender, 0, null, " - ", null, bsFIO, null, " - ");
    }

    public Human(String nameFIO, Gender gender, Children c, String cFIO){
        this(nameFIO, gender, 0, null, " - ", null, " - ", null, cFIO);
    }

    public Human(String nameFIO, Gender gender){
        this(nameFIO, gender, 0, null, " - ", null, " - ", null, " - ");
    }

//----------- gender = null

    public Human(String nameFIO, int age, Parents p, String pFIO, Brothers_Sisters bs, String bsFIO){
        this(nameFIO, null, age, null, pFIO, null, bsFIO, null," - ");
    }

    public Human(String nameFIO, int age, Parents p, String pFIO, Children c, String cFIO){
        this(nameFIO, null, age, null, pFIO, null, " - ", null, cFIO);
    }

    public Human(String nameFIO, int age, Brothers_Sisters bs, String bsFIO, Children c, String cFIO){
        this(nameFIO, null, age, null, " - ", null, bsFIO, null, cFIO);
    }

    public Human(String nameFIO, int age, Parents p, String pFIO){
        this(nameFIO, null, age, null, pFIO, null, " - ", null, " - ");
    }

    public Human(String nameFIO, int age, Brothers_Sisters bs, String bsFIO){
        this(nameFIO, null, age, null, " - ", null, bsFIO, null, " - ");
    }

    public Human(String nameFIO, int age, Children c, String cFIO){
        this(nameFIO, null, age, null, " - ", null, " - ", null, cFIO);
    }

    public Human(String nameFIO, int age){
        this(nameFIO, null, age, null, " - ", null, " - ", null, " - ");
    }

//----------- age = 0 gender = null

    public Human(String nameFIO, Parents p, String pFIO, Brothers_Sisters bs, String bsFIO){
        this(nameFIO, null, 0, null, pFIO, null, bsFIO, null," - ");
    }

    public Human(String nameFIO, Parents p, String pFIO, Children c, String cFIO){
        this(nameFIO, null, 0, null, pFIO, null, " - ", null, cFIO);
    }

    public Human(String nameFIO, Brothers_Sisters bs, String bsFIO, Children c, String cFIO){
        this(nameFIO, null, 0, null, " - ", null, bsFIO, null, cFIO);
    }

    public Human(String nameFIO, Parents p, String pFIO){
        this(nameFIO, null, 0, null, pFIO, null, " - ", null, " - ");
    }

    public Human(String nameFIO, Brothers_Sisters bs, String bsFIO){
        this(nameFIO, null, 0, null, " - ", null, bsFIO, null, " - ");
    }

    public Human(String nameFIO, Children c, String cFIO){
        this(nameFIO, null, 0, null, " - ", null, " - ", null, cFIO);
    }

    public Human(String nameFIO){
        this(nameFIO, null, 0, null, " - ", null, " - ", null, " - ");
    }
    
    public Human(){
        this(" - ", null, 0, null, " - ", null, " - ", null, " - ");
    }

//------------------------------------------------------------------

    public String getName(){
        return nameFIO;
    }

    public String getParents(){
        return parentsFIO;
    }

    public String getChildren(){
        return childrenFIO;
    }

    public String getBrothersSisters(){
        return brothers_SistersFIO;
    }

    public void setParents(String txt) {
        this.parentsFIO = txt;
    }

    public void setChildren(String txt) {
        this.childrenFIO = txt;
    }

    public void setBrothersSisters(String txt) {
        this.brothers_SistersFIO = txt;
    }

// На печать -------------------------------------------

    @Override
    public String toString() {
        return nameFIO + " ... " + gender + " ... " + age;
    }
}