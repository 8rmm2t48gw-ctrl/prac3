package practice17;

public class StudentList {
    private Student head;
    private Student tail;
    private int size;

    public StudentList(){
        head=null;
        tail=null;
        size=0;
    }

    public boolean isEmpty(){
        return head==null;
    }

    public int size(){
        return size;
    }

    public boolean add(Student student){
        if(student==null || find(student.getId())!=null){
            return false;
        }
        student.setNext(null);
        if(isEmpty()){
            head=student;
        }else{
            tail.setNext(student);
        }
        tail=student;
        size++;
        return true;
    }

    public Student find(int id){
        Student current=head;
        while(current!=null){
            if(current.getId()==id){
                return current;
            }
            current=current.getNext();
        }
        return null;
    }

    public boolean remove(int id){
        Student current=head;
        Student previous=null;
        while(current!=null && current.getId()!=id){
            previous=current;
            current=current.getNext();
        }
        if(current==null){
            return false;
        }
        if(previous==null){
            head=current.getNext();
        }else{
            previous.setNext(current.getNext());
        }
        if(current==tail){
            tail=previous;
        }
        current.setNext(null);
        size--;
        return true;
    }

    public boolean printById(int id){
        Student student=find(id);
        if(student==null){
            return false;
        }
        student.print();
        return true;
    }

    public void printAll(){
        if(isEmpty()){
            System.out.println("картотека пуста");
            return;
        }
        Student current=head;
        int number=1;
        while(current!=null){
            System.out.print(number+". ");
            current.print();
            current=current.getNext();
            number++;
        }
        System.out.println("всего студентов: "+size);
    }

    public void clear(){
        head=null;
        tail=null;
        size=0;
    }
}
