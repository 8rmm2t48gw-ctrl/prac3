package practice17;
import java.util.Scanner;

public class Task3 {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        CircularStudentList list=new CircularStudentList();
        int choice;

        do{
            System.out.println();
            System.out.println("--- картотека студентов (кольцевой список) ---");
            System.out.println("1-добавить студента");
            System.out.println("2-удалить студента по ID");
            System.out.println("3-показать студента по ID");
            System.out.println("4-показать всех студентов");
            System.out.println("5-очистить список");
            System.out.println("6-проверить список на пустоту");
            System.out.println("7-показать количество студентов");
            System.out.println("8-создать новый пустой список");
            System.out.println("0-выход");
            choice=CircularStudent.readInt(scanner,"выберите действие: ",0,8);

            switch(choice){
                case 1:
                    CircularStudent student=new CircularStudent();
                    student.readFromConsole(scanner);
                    if(list.add(student)){
                        System.out.println("студент добавлен");
                    }else{
                        System.out.println("студент с таким ID уже есть");
                    }
                    break;
                case 2:
                    int removeId=CircularStudent.readInt(scanner,"введите ID для удаления: ",1,Integer.MAX_VALUE);
                    if(list.remove(removeId)){
                        System.out.println("студент удалён");
                    }else{
                        System.out.println("студент не найден");
                    }
                    break;
                case 3:
                    int searchId=CircularStudent.readInt(scanner,"введите ID для поиска: ",1,Integer.MAX_VALUE);
                    if(!list.printById(searchId)){
                        System.out.println("студент не найден");
                    }
                    break;
                case 4:
                    list.printAll();
                    break;
                case 5:
                    list.clear();
                    System.out.println("список очищен");
                    break;
                case 6:
                    if(list.isEmpty()){
                        System.out.println("список пуст");
                    }else{
                        System.out.println("список не пуст");
                    }
                    break;
                case 7:
                    System.out.println("количество студентов: "+list.size());
                    break;
                case 8:
                    list=new CircularStudentList();
                    System.out.println("создан новый пустой список");
                    break;
                case 0:
                    System.out.println("завершение программы");
                    break;
            }
        }while(choice!=0);
        scanner.close();
    }
}
