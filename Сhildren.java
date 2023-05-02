import java.util.List;
import java.util.ArrayList;
import java.io.*;

public class Сhildren implements Serializable {
    private List<String> children_list;

    public Сhildren(){
        children_list = new ArrayList<>();
    }

    public Сhildren(String ...namesFIO){
        children_list = new ArrayList<>();
        for(String name: namesFIO){
            children_list.add(name);
        }
    }

    public List<String> getСhildrenFIO(){
        return children_list;
    }

    public void setСhildrenFIO(String txt) {
        children_list.add(txt);
    }

    public void delСhildrenFIO(String txt) {

        if (children_list.size() > 1){
            children_list.remove(txt);
        }
        else if (children_list.size() == 1){
            this.children_list = null;
        }
    }
    
}
