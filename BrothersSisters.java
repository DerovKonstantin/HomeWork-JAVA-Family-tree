import java.util.List;
import java.util.ArrayList;
import java.io.*;

public class BrothersSisters implements Serializable {
    private List<String> brothers_sistersFIO_list;

    public BrothersSisters(){
        brothers_sistersFIO_list = new ArrayList<>();
    }

    public BrothersSisters(String ...namesFIO){
        brothers_sistersFIO_list = new ArrayList<>();
        for(String name: namesFIO){
            brothers_sistersFIO_list.add(name);
        }
    }

    public List<String> getBrothersSistersFIO(){
        if (brothers_sistersFIO_list != null){
            return brothers_sistersFIO_list;
        }
        return null;
    }

    public void setBrothersSistersFIO(String txt) {
        brothers_sistersFIO_list.add(txt);
    }

    public void delBrothersSistersFIO(String txt) {
        if (brothers_sistersFIO_list.size() > 1){
            brothers_sistersFIO_list.remove(txt);
        }
        else if (brothers_sistersFIO_list.size() == 1){
            this.brothers_sistersFIO_list = null;
        }
    }

}
