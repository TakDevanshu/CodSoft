import java.util.Scanner;

public class Calculator {
    public static void main (String[] args) {
        try (Scanner s = new Scanner(System.in)) {
            int marks[] = new int[5];    //assuming there are in total 5 subjects
            int total=0;
            System.out.println("Enter your marks of 5 subjects:");
            for( int i=0; i<5; i++) {    
                marks[i] = s.nextInt();
                total = total+marks[i];
            }
            float avg;
            avg = total/5;
            char grade;

            if(avg>=80){
               grade = 'A';
            }else if(avg>=60 && avg<80){
               grade = 'B';
            }
            else if(avg>=40 && avg<60){
               grade = 'C';
            }
            else {
               grade = 'D';
            }
        System.out.println("Total Marks:"+total+"  Average:"+avg+"  Grade:"+grade);
        }
    }
}
