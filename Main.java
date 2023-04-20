
import java.util.Scanner;

public class Main {

    private static final Parents Parents = null;
    private static final Brothers_Sisters Brothers_Sisters = null;
    private static final Children Children = null;

    public static void main(String[] args) {
        //Реализовать, с учетом ооп подхода, приложение.
        //Для проведения исследований с генеалогическим древом.
        //Идея: описать некоторое количество компонент, например:
        //модель человека и дерева

        //Human human = new Human("...", Gender.Male, 000, Parents, "Отец, Мать", Brothers_Sisters, "..., ...", Children, "..., ...");
        Human human1 = new Human("Derov Konstantin Pavlovich", Gender.Male, 40, Parents, "Derov Pavel Petrovich, Derova Olga Ivanovna", Brothers_Sisters, "Derov Anton Pavlovich");
        Human human2 = new Human("Derov Anton Pavlovich", Gender.Male, 42, Parents,"Derov Pavel Petrovich, Derova Olga Ivanovna", Brothers_Sisters, "Derov Konstantin Pavlovich");
        Human human3 = new Human("Derov Pavel Petrovich", Gender.Male, 68, Parents, "Derova Galina Antonovna");
        Human human4 = new Human("Derova Olga Ivanovna", Gender.Female, 61, Children, "Derov Konstantin Pavlovich, Derov Anton Pavlovich");
        Human human5 = new Human("Osin Denis Ivanovich", Brothers_Sisters, "Derov Konstantin Pavlovich, Derov Anton Pavlovich", Children, "Osina Katerina Ivanovna");
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

        FamilyTree.synchronization();// Синхронизация всех родственных связей

        System.out.print("\nПопытка в реализацию генеалогического древа.\n");
        System.out.print("\nДоброго времени суток.\n"
        + "Я помогу вам разобраться в вашем генеалогическом дереве, так же помогу вам вспомнить имена и фамилии ваших родственников.");
        boolean end = true;
        while(end){
            System.out.print("\n - Введите имя или фамилию / имя и фамилию / часть имени и фамилии (через пробел), человека которого хотите найти."
            + "\n - Для прекращения введите end !!!\n...");
            String name = input_txt();
            if (name.toLowerCase().contains("end")){
                end = false;
            }
            else{
                String found_names = FamilyTree.getSearchPerson(name);
                boolean found_names_end = true;
                while(found_names_end){
                    System.out.println(found_names);
                    if (!found_names.contains("1)")){
                        found_names_end = false;
                    }
                    if (found_names.contains("1)") & !found_names.contains("2)")){
                        Human found_human = FamilyTree.getPerson(found_names);
                        System.out.print("Посмотреть имена...\n   1) Родителей\n   2) Братьев - сестер\n   3) Детей\n   4) Ничего\n...");
                        int num = input_num();
                        switch (num){
                            case 1:
                                System.out.print("-------------------------------------------------------\n" + "   - " + found_human.getParents()
                                + "\n");
                                break;
                            case 2:
                                System.out.print("-------------------------------------------------------\n" + "   - " + found_human.getBrothersSisters()
                                + "\n");
                                break;
                            case 3:
                                System.out.print("-------------------------------------------------------\n" + "   - " + found_human.getChildren()
                                + "\n");
                                break;
                            case 4:
                                found_names_end = false;
                                break;
                            default:
                                System.out.println("Операция не распознана. Повторите ввод.");
                        }
                    }
                    if (found_names.contains("1)") & found_names.contains("2)")){
                        System.out.print("Введите фамилию имя отчество человека для далнейшего рассмотрения.\n...");
                        found_names = FamilyTree.getSearchPerson(input_txt());
                    }
                }
            }
        }
    }
    
    public static String input_txt(){
        Scanner input = new Scanner(System.in);
        String txt = input.nextLine();
        txt = txt.trim();
        String txtCopy = txt;
        boolean yes = true;
        while (yes){
            if (txtCopy.contains(" ")){
                String[] words = txtCopy.split(" ");
                for (String word: words){
                    if (!(word.matches("^[a-zA-Z]*$"))){
                        System.out.print("Введены неверные данные - " + word + ", введите текст (только буквенные символы):");
                        txt = input.nextLine();
                        txt = txt.trim();
                        txtCopy = txt;
                    }
                }
                yes = false;
            }
            else{
                if (!(txtCopy.matches("^[a-zA-Z]*$"))){
                    System.out.print("Введены неверные данные - " + txtCopy + ", введите текст (только буквенные символы):");
                    txt = input.nextLine();
                    txt = txt.trim();
                    txtCopy = txt;
                }
                else{
                    yes = false;
                }
            }
        }
        //while (!(txt != null && txt.matches("^[a-zA-Z]*$"))){
        //    System.out.print("Введены неверные данные, введите текст: - ");
        //    txt = input.nextLine();
        //}
        return txt;
    }

    public static int input_num(){
        int num;
        Scanner input = new Scanner(System.in);
        while (!input.hasNextInt()){
            System.out.print("Введены неверные данные, введите число: - ");
            input.nextInt();
        }
        num = input.nextInt();
        return num;
    }


}
