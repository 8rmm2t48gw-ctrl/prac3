package practice17;
import java.util.Scanner;

public class DoublyStudent {
    private int id;
    private String name;
    private int age;
    private String group;
    private DoublyStudent next;
    private DoublyStudent prev;

    public DoublyStudent(){
        next=null;
        prev=null;
    }

    public void readFromConsole(Scanner scanner){
        id=readInt(scanner,"введите ID студента: ",1,Integer.MAX_VALUE);
        name=readText(scanner,"введите имя студента: ");
        age=readInt(scanner,"введите возраст: ",1,120);
        group=readText(scanner,"введите группу: ");
    }

    public void print(){
        System.out.println("ID: "+id+", имя: "+name+", возраст: "+age+", группа: "+group);
    }

    public int getId(){
        return id;
    }

    DoublyStudent getNext(){
        return next;
    }

    void setNext(DoublyStudent next){
        this.next=next;
    }

    DoublyStudent getPrev(){
        return prev;
    }

    void setPrev(DoublyStudent prev){
        this.prev=prev;
    }

    static int readInt(Scanner scanner,String text,int min,int max){
        while(true){
            System.out.print(text);
            if(!scanner.hasNextInt()){
                System.out.println("ошибка: введите целое число");
                scanner.nextLine();
                continue;
            }
            int value=scanner.nextInt();
            scanner.nextLine();
            if(value>=min && value<=max){
                return value;
            }
            System.out.println("число должно быть от "+min+" до "+max);
        }
    }

    private static String readText(Scanner scanner,String text){
        while(true){
            System.out.print(text);
            String value=scanner.nextLine().trim();
            if(!value.isEmpty()){
                return value;
            }
            System.out.println("поле не должно быть пустым");
        }
    }
}
