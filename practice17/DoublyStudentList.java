package practice17;

public class DoublyStudentList {
    private DoublyStudent head;
    private DoublyStudent tail;
    private int size;

    public DoublyStudentList(){
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

    public boolean add(DoublyStudent student){
        if(student==null || find(student.getId())!=null){
            return false;
        }
        student.setNext(null);
        student.setPrev(tail);
        if(isEmpty()){
            head=student;
        }else{
            tail.setNext(student);
        }
        tail=student;
        size++;
        return true;
    }

    public DoublyStudent find(int id){
        DoublyStudent current=head;
        while(current!=null){
            if(current.getId()==id){
                return current;
            }
            current=current.getNext();
        }
        return null;
    }

    public boolean remove(int id){
        DoublyStudent current=find(id);
        if(current==null){
            return false;
        }
        DoublyStudent previous=current.getPrev();
        DoublyStudent next=current.getNext();
        if(previous==null){
            head=next;
        }else{
            previous.setNext(next);
        }
        if(next==null){
            tail=previous;
        }else{
            next.setPrev(previous);
        }
        current.setNext(null);
        current.setPrev(null);
        size--;
        return true;
    }

    public boolean printById(int id){
        DoublyStudent student=find(id);
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
        DoublyStudent current=head;
        int number=1;
        while(current!=null){
            System.out.print(number+". ");
            current.print();
            current=current.getNext();
            number++;
        }
        System.out.println("всего студентов: "+size);
    }

    public void printReverse(){
        if(isEmpty()){
            System.out.println("картотека пуста");
            return;
        }
        DoublyStudent current=tail;
        int number=1;
        while(current!=null){
            System.out.print(number+". ");
            current.print();
            current=current.getPrev();
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
