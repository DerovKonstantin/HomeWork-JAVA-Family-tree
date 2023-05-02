import java.util.List;
import java.util.ArrayList;
import java.io.*;

public class FamilyTree implements Serializable {
    private List<Human> human_list;

    public FamilyTree(){
        human_list = new ArrayList<>();
    }

    public void addHuman(Human human){
        human_list.add(human);
    }

    public void synchronizationHumanAndParents(Human human){// синхрон с родителями/////////////
        synchronizationHumanAndParent(human, human.getHumanParentFather());
        synchronizationHumanAndParent(human, human.getHumanParentMother());
    } 

    public void synchronizationHumanAndParent(Human human, String parents_name){
        String name = human.getHumanName();
        if (human.getHumanParents() != null){
            if (parents_name != null){
                if (getHuman(parents_name) == null){
                    human_list.add(new Human(parents_name));
                }
                Human parent = getHuman(parents_name);
                if (parent.getHumanChildren() == null || !parent.getHumanChildren().contains(name)){
                    parent.setHumanChildren(name);
                }
            }
        }
    }

    public void synchronizationHumanAndBroSis(Human human){
        String name = human.getHumanName();
        if (human.getHumanBrothersSisters() != null){
            for (String brothers_sisters_name: human.getHumanBrothersSistersList()){
                if (getHuman(brothers_sisters_name) == null){
                    human_list.add(new Human(brothers_sisters_name));
                }
                Human brothers_sisters = getHuman(brothers_sisters_name);
                if (brothers_sisters.getHumanBrothersSisters() == null  || !brothers_sisters.getHumanBrothersSisters().contains(name)){
                    brothers_sisters.setHumanBrothersSisters(name);
                }
            }
        }
    }

    public void synchronizationHumanAndСhildren(Human human){
        String name = human.getHumanName();
        if (human.getHumanChildren() != null){
            for (String children_name: human.getHumanChildrenList()){
                if (getHuman(children_name) == null){
                    human_list.add(new Human(children_name));
                }
                Human children = getHuman(children_name);
                if (children.getHumanParents() == null  ||  !children.getHumanParents().contains(name)){
                    if (human.getHumanParentFather() == null & human.getHumanGender() == Gender.Male){
                        children.setHumanParentFather(name);
                    }
                    else {
                        if (human.getHumanParentMother() == null){
                        children.setHumanParentMother(name);
                        }
                    }
                }
            }
        }
    }

    public void synchronization(){
        for (int i = 0; i < human_list.size(); i++){
            synchronizationHumanAndParents(human_list.get(i));
            synchronizationHumanAndBroSis(human_list.get(i));
            synchronizationHumanAndСhildren(human_list.get(i));
        }
    }

    public String getInfoList(){
        StringBuilder string_builder = new StringBuilder();
        for (Human human: human_list){  
            string_builder.append("   " + human.getHumanName() + "\n");
        }
        string_builder.insert(0, "-------------------------------------------------------\n");
        string_builder.append("-------------------------------------------------------\n");
        return string_builder.toString();
    }
    
    public Human getHuman(String human_name){
        for (Human human: human_list){  
            if (human_name.contains(human.getHumanName())){
                return human;
            }  
        }
        return null;
    }

    public List<Human> getHumanList(){
        return human_list;
    }

    public List<String> getSearchHuman(String search_name){// Поиск лююдей с указанной фамилией именем
        List<String> name_found_list = new ArrayList<>();
        search_name = search_name.toLowerCase();
        if (search_name.contains(" ")){
            String[] search_names = search_name.split(" ");
            for (Human human: human_list){ 
                int i = 0;
                boolean name_found = true;
                while (name_found & i < search_names.length){       
                    if (!human.getHumanName().toLowerCase().contains(search_names[i++])){//
                        name_found = false;
                    }
                }  
                if (name_found){
                    name_found_list.add(human.getHumanName());
                }
            }
            return name_found_list;
        }
        else{
            for (Human human: human_list){
                if (human.getHumanName().toLowerCase().contains(search_name)){
                    name_found_list.add(human.getHumanName());
                }
            }
            return name_found_list;
        }
    }

}

