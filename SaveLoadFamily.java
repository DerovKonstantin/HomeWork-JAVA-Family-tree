import java.io.*;

public class SaveLoadFamily{
    private static FamilyTree family_tree;

    public SaveLoadFamily(){
        family_tree = new FamilyTree();
    }

    public void saveFamily(FamilyTree family_tree, String file_name){
        try(ObjectOutputStream save_family_tree = new ObjectOutputStream(new FileOutputStream(file_name))){
            save_family_tree.writeObject(family_tree);
            System.out.print("\n-------------------------------------------------------\nДанные были сохранены!\n");
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        } 
    }
    
    public FamilyTree loadFamily(String file_name){
        try(ObjectInputStream load_family_tree = new ObjectInputStream(new FileInputStream(file_name))){
            family_tree = ((FamilyTree)load_family_tree.readObject());
            System.out.print("-------------------------------------------------------\nСписок загруженных данных...\n");
            for(Human human : family_tree.getHumanList()){
                System.out.printf("   Name: %s\n", human.getHumanName());
            }
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        } 
        return family_tree;
    }

}
