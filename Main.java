import java.util.Scanner;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Реализовать, с учетом ооп подхода, приложение.
        //Для проведения исследований с генеалогическим древом.
        //Идея: описать некоторое количество компонент, например:
        //модель человека и дерева

        Human human1 = new Human("Derov Konstantin Pavlovich", Gender.Male, 40, new Parents(new Mother("Derova Olga Ivanovna")), new BrothersSisters("Derov Anton Pavlovich", "Osin Denis Ivanovich"));
        Human human2 = new Human("Derov Anton Pavlovich", Gender.Male, 42, new Parents(new Father("Derov Pavel Petrovich"), new Mother("Derova Olga Ivanovna")), new BrothersSisters("Derov Konstantin Pavlovich"));
        Human human3 = new Human("Derov Pavel Petrovich", Gender.Male, 68, new Parents(new Mother("Derova Galina Antonovna")), new Сhildren("Derov Konstantin Pavlovich", "Derov Anton Pavlovich"));
        Human human4 = new Human("Derova Olga Ivanovna", Gender.Female, 61, new Сhildren("Derov Konstantin Pavlovich", "Derov Anton Pavlovich"));
        Human human5 = new Human("Osin Denis Ivanovich", Gender.Male, new BrothersSisters("Derov Konstantin Pavlovich", "Derov Anton Pavlovich"), new Сhildren("Osina Katerina Ivanovna"));
        Human human6 = new Human("ErmoshkinDmirtriev Grigoryi Vladimirovich");
        Human human7 = new Human();

        FamilyTree family_tree = new FamilyTree();
        family_tree.addHuman(human1);
        family_tree.addHuman(human2);
        family_tree.addHuman(human3);
        family_tree.addHuman(human4);
        family_tree.addHuman(human5);
        family_tree.addHuman(human6);
        family_tree.addHuman(human7);
        family_tree.synchronization();// Синхронизация всех родственных связей

        SaveLoadFamily saveLoadFamily = new SaveLoadFamily();
        //saveLoadFamily.saveFamily(family_tree, "human.dat");
        //family_tree = saveLoadFamily.loadFamily("human.dat");
        System.out.print("\nПопытка в реализацию генеалогического древа.\n");
        System.out.print("\nДоброго времени суток.\n"
        + "Я помогу вам разобраться в вашем генеалогическом дереве, так же помогу вам вспомнить имена и фамилии ваших родственников.\n");
        boolean end = true;
        while(end){
            System.out.print("-------------------------------------------------------\n - Для загрузки данных введите load !!!"
            + "\n - Для прекращения введите end !!!\n - Введите имя или фамилию / имя и фамилию / часть имени и фамилии "
            + "(через пробел - Derov Konstantin Pavlovich), человека которого хотите найти.\n...");
            String name = input_txt();
            if (name.toLowerCase().contains("end")){
                end = false;
            }
            else if (name.toLowerCase().contains("load")){
                family_tree = saveLoadFamily.loadFamily("human.dat");
            }
            else{
                List<String> name_found_list = family_tree.getSearchHuman(name);
                boolean found_names_end = true;
                while(found_names_end){
                    if (name_found_list.size() == 0){
                        System.out.print("-------------------------------------------------------\n   Такого имени не найдено");
                        found_names_end = false;
                    }
                    if (name_found_list.size() == 1){
                        System.out.print("-------------------------------------------------------\n   " + name_found_list.get(0)
                        + "\n-------------------------------------------------------\n");
                        found_names_end = false;
                        Human found_human = family_tree.getHuman(name_found_list.get(0));
                        boolean found_human_end = true;
                        while(found_human_end){
                            System.out.print("Посмотреть имена...\n   0) Ничего\n   1) Родителей\n   2) Братьев-Сестер\n   3) Детей\n   4) Список всех родственников\n...");
                            int num = input_num();
                            switch (num){
                                case 0:
                                    found_names_end = false;
                                    found_human_end = false;
                                    break;
                                case 1:
                                    boolean found_parent_end = true;
                                    while(found_parent_end){
                                        System.out.print("-------------------------------------------------------\nРодители - " + found_human.getHumanParents()
                                        + "\n-------------------------------------------------------\n");
                                        System.out.print("Возможные действия...\n   0) Ничего\n   1) Добавить имя \n   2) Удалить имя\n   3) Переименовать\n   4) Сохранить данные\n...");
                                        int num_1 = input_num();
                                        switch (num_1){
                                            case 0:
                                                found_parent_end = false;
                                                break;
                                            case 1:
                                                boolean add_parent_end = true;
                                                while(add_parent_end){
                                                    System.out.print("-------------------------------------------------------\nРодители - " + found_human.getHumanParents()
                                                    + "\n-------------------------------------------------------\n");
                                                    System.out.print("Добавить имя...\n   0) Ничего\n   1) Отца \n   2) Матери\n...");
                                                    int num_1_1 = input_num();
                                                    switch (num_1_1){
                                                        case 0:
                                                            add_parent_end = false;
                                                            break;
                                                        case 1:
                                                            family_tree = add_Parent_name(found_human, family_tree, found_human.getHumanParentFather(), "add Father");
                                                            break;
                                                        case 2:
                                                            family_tree = add_Parent_name(found_human, family_tree, found_human.getHumanParentMother(), "add Mother");
                                                            break;
                                                        default:
                                                            System.out.println("Операция не распознана. Повторите ввод.");
                                                    }
                                                }
                                                break;
                                            case 2:
                                                boolean del_parent_end = true;
                                                while(del_parent_end){
                                                    System.out.print("-------------------------------------------------------\nРодители - " + found_human.getHumanParents()
                                                    + "\n-------------------------------------------------------\n");
                                                    System.out.print("Удалить имя...\n   0) Ничего\n   1) Отца \n   2) Матери\n...");
                                                    int num_1_2 = input_num();
                                                    switch (num_1_2){
                                                        case 0:
                                                            del_parent_end = false;
                                                            break;
                                                        case 1:
                                                            family_tree = del_Parent_name(found_human, family_tree, "удалено", found_human.getHumanParentFather(), "del Father");
                                                            break;
                                                        case 2:
                                                            family_tree = del_Parent_name(found_human, family_tree, "удалено", found_human.getHumanParentMother(), "del Mother");
                                                            break;
                                                        default:
                                                            System.out.println("Операция не распознана. Повторите ввод.");
                                                    }
                                                }
                                                break;
                                            case 3:
                                                boolean rename_parent_end = true;
                                                while(rename_parent_end){
                                                    System.out.print("-------------------------------------------------------\nРодители - " + found_human.getHumanParents()
                                                    + "\n-------------------------------------------------------\n");
                                                    System.out.print("Откорректировть имя...\n   0) Ничего\n   1) Отца \n   2) Матери\n...");
                                                    int num_1_3 = input_num();
                                                    switch (num_1_3){
                                                        case 0:
                                                            rename_parent_end = false;
                                                            break;
                                                        case 1:
                                                            family_tree = del_Parent_name(found_human, family_tree, "будет заменено", found_human.getHumanParentFather(), "del Father");
                                                            family_tree = add_Parent_name(found_human, family_tree, found_human.getHumanParentFather(), "add Father");
                                                            break;
                                                        case 2:
                                                            family_tree = del_Parent_name(found_human, family_tree, "будет заменено", found_human.getHumanParentMother(), "del Mother");
                                                            family_tree = add_Parent_name(found_human, family_tree, found_human.getHumanParentMother(), "add Mother");
                                                        default:
                                                            System.out.println("Операция не распознана. Повторите ввод.");
                                                    }
                                                }
                                                break;
                                            case 4:
                                                saveLoadFamily.saveFamily(family_tree, "human.dat");
                                                break;
                                            default:
                                                System.out.println("Операция не распознана. Повторите ввод.");
                                        }
                                    }
                                    break;
                                case 2:
                                    boolean found_brothers_sisters_end = true;
                                    while(found_brothers_sisters_end){
                                       System.out.print("-------------------------------------------------------\nБратья.Сестры - " + found_human.getHumanBrothersSisters()
                                        + "\n-------------------------------------------------------\n");
                                        System.out.print("Возможные действия...\n   0) Ничего\n   1) Добавить имена брата, сестры\n   2) Удалить имена\n   3) Переименовать\n   4) Сохранить данные\n...");
                                        int num_2 = input_num();
                                        switch (num_2){
                                            case 0:
                                                found_brothers_sisters_end = false;
                                                break;
                                            case 1:
                                                family_tree = add_brothers_sisters_childrens_name(found_human, family_tree, found_human.getHumanBrothersSisters(), "add BrotherSister");
                                                break;
                                            case 2:
                                                family_tree = del_brothers_sisters_childrens_name(found_human, family_tree, "для удаления", "удалено", found_human.getHumanBrothersSistersList(), "del BrotherSister");
                                                break;
                                            case 3:
                                                family_tree = del_brothers_sisters_childrens_name(found_human, family_tree, "для корректировки", "меняем на", found_human.getHumanBrothersSistersList(), "del BrotherSister");
                                                family_tree = add_brothers_sisters_childrens_name(found_human, family_tree, found_human.getHumanBrothersSisters(), "add BrotherSister");
                                                break;
                                            case 4:
                                                saveLoadFamily.saveFamily(family_tree, "human.dat");
                                                break;
                                            default:
                                                System.out.println("Операция не распознана. Повторите ввод.");
                                        }
                                    }
                                    break;
                                case 3:
                                    boolean found_children_end = true;
                                    while(found_children_end){
                                        System.out.print("-------------------------------------------------------\n   Дети - " + found_human.getHumanChildren()
                                        + "\n-------------------------------------------------------\n");
                                        System.out.print("Возможные действия...\n   0) Ничего\n   1) Добавить имена детей\n   2) Удалить имена\n   3) Переименовать\n   4) Сохранить данные\n...");
                                        int num_2 = input_num();
                                        switch (num_2){
                                            case 0:
                                                found_children_end = false;
                                                break;
                                            case 1:
                                                family_tree = add_brothers_sisters_childrens_name(found_human, family_tree, found_human.getHumanChildren(), "add Children");
                                                break;
                                            case 2:
                                                family_tree = del_brothers_sisters_childrens_name(found_human, family_tree, "для удаления", "удалено", found_human.getHumanChildrenList(), "del Children");
                                                break;
                                            case 3:
                                                family_tree = del_brothers_sisters_childrens_name(found_human, family_tree, "для корректировки", "меняем на", found_human.getHumanChildrenList(), "del Children");
                                                family_tree = add_brothers_sisters_childrens_name(found_human, family_tree, found_human.getHumanChildren(), "add Children");
                                                break;
                                            case 4:
                                                saveLoadFamily.saveFamily(family_tree, "human.dat");
                                                break;
                                            default:
                                                System.out.println("Операция не распознана. Повторите ввод.");
                                        }
                                    }
                                    break;
                                case 4:
                                    System.out.print(family_tree.getInfoList());
                                    break;
                                default:
                                    System.out.println("Операция не распознана. Повторите ввод.");
                            }
                        }
                    }
                    if (name_found_list.size() > 1){
                        print_Num_List_Of_Names("", name_found_list);
                        int num_name = input_num_max(name_found_list.size());
                        if (num_name == 0){
                            found_names_end = false;
                        }
                        else if (num_name > 0){
                            name_found_list = family_tree.getSearchHuman(name_found_list.get(num_name -1));
                        }
                    }
                }
            }
        }
    }
    
    public static String input_txt(){
        String txt;
        Scanner input = new Scanner(System.in);
        String txtCopy = txt = input.nextLine();
        while (!(txtCopy.replaceAll(" ", "").matches("^[a-zA-Z]*$"))){
            System.out.print("Введены неверные данные, введите текст (только буквенные символы - Derov Konstantin Pavlovich): - ");
            txtCopy = txt = input.nextLine();
        }
        //input.close();
        return txt;
    }

    public static int input_num(){
        String num_txt;
        Scanner input = new Scanner(System.in);
        num_txt = input.nextLine();
        while (!num_txt.matches("[-+]?\\d*\\.?\\d+")){
            System.out.print("Введены неверные данные, введите число: - ");
            num_txt = input.nextLine();
        }
        int num = Integer.parseInt (num_txt);
        //input.close();
        return num;
    }

    public static int input_num_max(int max){
        int num = input_num();
            while (num > max){
                System.out.print("Введены неверные данные, число не должно превышать (" + max + "): - ");
                num = input_num();
            }
        return num;
    }

    public static FamilyTree add_Parent_name(Human found_human, FamilyTree family_tree, String parent_names, String option){
        if (parent_names != null){//found_human.getHumanParentFather()
            System.out.print("-------------------------------------------------------\nИмя уже существует - " 
            + parent_names + "...\n");
        }
        else if (parent_names == null){
            System.out.print("Введите фамилию имя отчество через пробел (Derov Pavel Petrovich)\n...");
            String new_name = input_txt();
            if (option.equals("add Father")){
                found_human.setHumanParentFather(new_name);
            }
            if (option.equals("add Mother")){
                found_human.setHumanParentMother(new_name);
            }
            family_tree.synchronizationHumanAndParents(found_human);
        }
        return family_tree;
    }

    public static FamilyTree del_Parent_name(Human found_human, FamilyTree family_tree, String txt, String parent_names, String option){
        if (parent_names == null){//found_human.getHumanParentFather()
            System.out.print("Имя отсутствует...\n");
        }
        if (parent_names != null){
            System.out.print("Имя - " + parent_names + " " + txt + ".\n...");//удалено
            Human found_human_parent = family_tree.getHuman(parent_names);
            found_human_parent.delHumanChildren(found_human.getHumanName());
            if (option.equals("del Father")){
                found_human.delHumanParentFather();
            }
            if (option.equals("del Mother")){
                found_human.delHumanParentMother();
            }
        }
        return family_tree;
    }

    public static FamilyTree add_brothers_sisters_childrens_name(Human found_human, FamilyTree family_tree, String lists_of_names, String option){
        System.out.print("Введите фамилию имя отчество через пробел (Derov Anton Pavlovich)\n...");
        String new_name = input_txt();
        if (lists_of_names.contains(new_name)){
            System.out.print("-------------------------------------------------------\nТакое имя уже существует...\n");
        }
        else if (!lists_of_names.contains(new_name)){
            if (option.equals("add BrotherSister")){
                found_human.setHumanBrothersSisters(new_name);
                family_tree.synchronizationHumanAndBroSis(found_human);
            }
            if (option.equals("add Children")){
                found_human.setHumanChildren(new_name);
                family_tree.synchronizationHumanAndСhildren(found_human);
            }
        }
        return family_tree;
    }

    public static void print_Num_List_Of_Names(String txt, List<String> lists_of_names){
        int count = 0;
        StringBuilder string_builder = new StringBuilder();
        string_builder.append("Выберите варианты " + txt + " имени...\n   0) Ничего\n");//для удаления - корректировки имени
        for (String name: lists_of_names){//found_human.getHumanBrothersSistersList()
            string_builder.append("   " + (++count) + ") " + name + "\n");
        }
        string_builder.append("...");
        System.out.print(string_builder.toString());
    }

    public static FamilyTree del_brothers_sisters_childrens_name(Human found_human, FamilyTree family_tree, String txt1, String txt2, List<String> lists_of_names, String option){
        if (lists_of_names == null){
            System.out.print("Имена отсутствуют...\n");
        }
        if (lists_of_names != null){
            print_Num_List_Of_Names(txt1, lists_of_names);
            int num_del_name = input_num_max(lists_of_names.size());
            if (num_del_name > 0){ 
                String del_name = lists_of_names.get(num_del_name -1);
                System.out.print("Имя - " + del_name + " " + txt2 + "...\n");
                Human found_human_del_name = family_tree.getHuman(del_name);
                if (option.equals("del BrotherSister")){
                    found_human_del_name.delHumanBrothersSisters(found_human.getHumanName());
                    found_human.delHumanBrothersSisters(del_name);
                }
                if (option.equals("del Children")){
                    if (found_human_del_name.getHumanParentFather().equals(found_human.getHumanName())){
                        found_human_del_name.delHumanParentFather();
                    }
                    else if (found_human_del_name.getHumanParentMother().equals(found_human.getHumanName())){
                        found_human_del_name.delHumanParentMother();
                    }
                    found_human.delHumanChildren(del_name);
                }
            }
        }
        return family_tree;
    }

}
