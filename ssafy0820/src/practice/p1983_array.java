package practice;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;
 
public class p1983_array {
    static int TC, N, K, ans;
    static String[] grades = {"A+","A0","A-","B+","B0","B-","C+","C0","C-","D0"};
    static LinkedList<Student> list = new LinkedList<>();
     
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         
        TC = sc.nextInt();
        for (int tc = 1; tc <= TC; tc++) {
            N = sc.nextInt();
            K = sc.nextInt();
            list.clear();
             
            for (int i = 1; i <= N; i++) {
                double sum = 0;
                sum += sc.nextInt()*0.35;
                sum += sc.nextInt()*0.45;
                sum += sc.nextInt()*0.2;
                list.add(new Student(sum, i));
            }
             
            list.sort(new Comparator<Student>() {
                @Override
                public int compare(Student o1, Student o2) {
                    if(o1.grade < o2.grade)
                        return 1;
                    else
                        return -1;
                }
            });
             
            for (int i = 0; i < list.size(); i++) {
                if(list.get(i).order==K) {
                    ans = (i)/(N/10);
                    break;
                }
            }
            System.out.println("#" + tc + " " + grades[ans]);
        }
    }
     
    static class Student {
        double grade;
        int order;
         
        Student(double g, int o) {
            grade = g;
            order = o;
        }
    }
}