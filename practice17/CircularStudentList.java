package practice17;

public class CircularStudentList {
    private CircularStudent head;
    private CircularStudent tail;
    private int size;

    public CircularStudentList(){
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

    public boolean add(CircularStudent student){
        if(student==null || find(student.getId())!=null){
            return false;
        }
        if(isEmpty()){
            head=student;
        }else{
            tail.setNext(student);
        }
        tail=student;
        tail.setNext(head);
        size++;
        return true;
    }

    public CircularStudent find(int id){
        if(isEmpty()){
            return null;
        }
        CircularStudent current=head;
        do{
            if(current.getId()==id){
                return current;
            }
            current=current.getNext();
        }while(current!=head);
        return null;
    }

    public boolean remove(int id){
        if(isEmpty()){
            return false;
        }
        CircularStudent current=head;
        CircularStudent previous=tail;
        do{
            if(current.getId()==id){
                if(size==1){
                    head=null;
                    tail=null;
                }else{
                    previous.setNext(current.getNext());
                    if(current==head){
                        head=current.getNext();
                    }
                    if(current==tail){
                        tail=previous;
                    }
                }
                current.setNext(null);
                size--;
                return true;
            }
            previous=current;
            current=current.getNext();
        }while(current!=head);
        return false;
    }

    public boolean printById(int id){
        CircularStudent student=find(id);
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
        CircularStudent current=head;
        int number=1;
        do{
            System.out.print(number+". ");
            current.print();
            current=current.getNext();
            number++;
        }while(current!=head);
        System.out.println("всего студентов: "+size);
    }

    public void clear(){
        head=null;
        tail=null;
        size=0;
    }
}
