import java.util.List;
import java.util.ArrayList;

public class FamilyTree{
    private static List<Human> human_list;

    public FamilyTree(){
        human_list = new ArrayList<>();
    }

    public void addHuman(Human human){
        human_list.add(human);
    }


    public static void synchronization(){/////////////////////////////////
        for (Human human: human_list){
            String name = human.getName();
            ///////////////////////////////// синх по родителям
            if (human.getParents().length() > 3){
                if (human.getParents().contains(", ")){
                    String[] txt_parents = human.getParents().split(", ");
                    for (String name_parents: txt_parents){
                        Human human_parents = getPerson(name_parents);
                        if (human_parents != null){ 
                            if (!human_parents.getChildren().contains(name)){
                                String str = human_parents.getChildren().replaceAll(" - ", "");
                                str = String.join(", ", str, name);//////////////////////////
                                //String str = String.join(", ", human_parents.getChildren(), name);
                                human_parents.setChildren(str);
                            }
                        }
                    }
                }
                else{
                    Human human_parents = getPerson(human.getParents());
                    if (human_parents != null){
                        if (!human_parents.getChildren().contains(name)){
                            String str = human_parents.getChildren().replaceAll(" - ", "");
                            str = String.join(", ", str, name);////////////////////////////
                            //String str = String.join(", ", human_parents.getChildren(), name);
                            human_parents.setChildren(str);
                        }
                    }
                }
            }
            /////////////////////////////////////////////////// по брат/сист
            if (human.getBrothersSisters().length() > 3){
                if (human.getBrothersSisters().contains(", ")){
                    String[] txt_BroSis = human.getBrothersSisters().split(", ");
                    for (String name_BroSis: txt_BroSis){
                        Human human_BroSis = getPerson(name_BroSis);
                        if (human_BroSis != null){ 
                            if (!human_BroSis.getBrothersSisters().contains(name)){   
                                String str = human_BroSis.getBrothersSisters().replaceAll(" - ", "");
                                str = String.join(", ", str, name);////////////////////////////
                                //String str = String.join(", ", human_BroSis.getBrothersSisters(), name);
                                human_BroSis.setBrothersSisters(str);
                            }
                        }
                    }
                }
                else{
                    Human human_BroSis = getPerson(human.getBrothersSisters());
                    if (human_BroSis != null){
                        if (!human_BroSis.getBrothersSisters().contains(name)){
                            String str = human_BroSis.getBrothersSisters().replaceAll(" - ", "");
                            str = String.join(", ", str, name);/////////////////////////////
                            //String str = String.join(", ", human_BroSis.getBrothersSisters(), name);
                            human_BroSis.setBrothersSisters(str);
                        }
                    }
                }
            }
            ///////////////////////////////////////////////////// по детям
            if (human.getChildren().length() > 3){
                if (human.getChildren().contains(", ")){
                    String[] txt_Chil = human.getChildren().split(", ");
                    for (String name_Chil: txt_Chil){
                        Human human_Chil = getPerson(name_Chil);
                        if (human_Chil != null){ 
                            if (!human_Chil.getParents().contains(name)){ 
                                String str = human_Chil.getParents().replaceAll(" - ", "");
                                str = String.join(", ", str, name);/////////////////////////////
                                //String str = String.join(", ", human_Chil.getParents(), name);
                                human_Chil.setParents(str);
                            }
                        }
                    }
                }
                else{
                    Human human_Chil = getPerson(human.getChildren());
                    if (human_Chil != null){
                        if (!human_Chil.getChildren().contains(name)){
                            String str = human_Chil.getParents().replaceAll(" - ", "");
                            str = String.join(", ", str, name);//////////////////////////////////
                            //String str = String.join(", ", human_Chil.getChildren(), name);
                            human_Chil.setChildren(str);
                        }
                    }
                }
            }
        }  
    }
/* ///////////////////////////////////////////////////////////////////////////////////////////////////
    public static void synchronization(Human human1, Human human2){/////////////////////////////////
        for (Human human: human_list){
            String name = human.getName();
            if (human.getParents().length() > 3){
                if (human.getParents().contains(", ")){
                    String[] txt_parents = human.getParents().split(", ");
                    for (String name_parents: txt_parents){
                        Human human_parents = getPerson(name_parents);
                        if (human_parents != null){ 
                            if (!human_parents.getChildren().contains(name)){   
                                //StringBuilder string_builder = new StringBuilder();
                                //string_builder.append(human_parents.getChildren() + ", " + name);
                                String str = String.join(", ", human_parents.getChildren(), name);
                                human_parents.setParents(str);
                            }
                        }
                    }
                }
                else{
                    Human human_parents = getPerson(human.getParents());
                    if (human_parents != null){
                        if (!human_parents.getChildren().contains(name)){
                            String str = String.join(", ", human_parents.getChildren(), name);
                            human_parents.setParents(str);
                        }
                    }
                }
            }
        }  
    }
*/

    public static Human getPerson(String txt){// для создания копии данных человека
        for (Human human: human_list){  
            if (txt.contains(human.getName())){
                return human;
            }  
        }
        return null;
    }
  
    public static String getSearchPerson(String txt){// Поиск человека с указанным именем и фамилией или просто именем
        StringBuilder string_builder = new StringBuilder();
        txt = txt.toLowerCase();//
        int count = 0;
        if (txt.contains(" ")){
            String[] words = txt.split(" ");
            for (Human human: human_list){ 
                boolean Match_found = true; int i = 0;
                while (Match_found && i < words.length){       
                    if (!human.getName().toLowerCase().contains(words[i++])){//
                        Match_found = false;
                    }
                }  
                if (Match_found){
                    string_builder.append("   " + (++count) + ") " + human + "\n");
                }
            }
            if (string_builder.length() == 0){
                return "-------------------------------------------------------\n   Такого имени не найдено"
                + "\n-------------------------------------------------------";
            }
            else{
                string_builder.insert(0, "-------------------------------------------------------\n");
                string_builder.append("-------------------------------------------------------");
                return string_builder.toString();
            }
        }
        else{
            for (Human human: human_list){
                if (human.getName().toLowerCase().contains(txt)){
                    string_builder.append("   " + (++count) + ") " + human + "\n");
                }
            }
            if (string_builder.length() == 0){
                return "-------------------------------------------------------\n   Такого имени не найдено"
                + "\n-------------------------------------------------------";
            }
            else{
                string_builder.insert(0, "-------------------------------------------------------\n");
                string_builder.append("-------------------------------------------------------");
                return string_builder.toString();
            }
        }
    }
   
/* 
    public static String getHumanInfo(){
        StringBuilder string_builder = new StringBuilder();
        string_builder.append("\n/////////////////////////////////////////////////\n");
        for (Human human: human_list){
            string_builder.append(human);
            string_builder.append("\n");
        }
        string_builder.append("/////////////////////////////////////////////////\n");
        return string_builder.toString();
    }
*/

}

