package practice9;

import java.util.ArrayList;

public class Task3 {
    public static void main(String[] args){
        ArrayList<Student> firstList=new ArrayList<>();
        firstList.add(new Student(105,"Анна"));
        firstList.add(new Student(102,"Иван"));
        firstList.add(new Student(109,"Ольга"));

        ArrayList<Student> secondList=new ArrayList<>();
        secondList.add(new Student(101,"Павел"));
        secondList.add(new Student(106,"Мария"));

        ArrayList<Student> students=new ArrayList<>();
        students.addAll(firstList);
        students.addAll(secondList);

        System.out.println("до сортировки:");
        printStudents(students);

        students=mergeSort(students);

        System.out.println("после сортировки:");
        printStudents(students);
    }

    public static ArrayList<Student> mergeSort(ArrayList<Student> students){
        if(students.size()<=1){
            return students;
        }

        int middle=students.size()/2;

        ArrayList<Student> left=new ArrayList<>(students.subList(0,middle));
        ArrayList<Student> right=new ArrayList<>(students.subList(middle,students.size()));

        left=mergeSort(left);
        right=mergeSort(right);

        return merge(left,right);
    }

    public static ArrayList<Student> merge(ArrayList<Student> left,ArrayList<Student> right){
        ArrayList<Student> result=new ArrayList<>();
        int i=0;
        int j=0;

        while(i<left.size() && j<right.size()){
            if(left.get(i).compareTo(right.get(j))<=0){
                result.add(left.get(i));
                i++;
            }else{
                result.add(right.get(j));
                j++;
            }
        }

        while(i<left.size()){
            result.add(left.get(i));
            i++;
        }

        while(j<right.size()){
            result.add(right.get(j));
            j++;
        }

        return result;
    }

    public static void printStudents(ArrayList<Student> students){
        for(Student student:students){
            System.out.println(student.getIDNumber()+" - "+student.getName());
        }
    }
}
