package Java.DS;
import java.util.*;
public class generator {
    public static void main (String[] args){
        Integer [] x = new Integer[100];
      x = generate(x);
      System.out.println(Arrays.toString(x));
      x = reverse(x);
      System.out.println(Arrays.toString(x));
      x = shuffle(x);
      System.out.println(Arrays.toString(x));
}
  static Integer [] generate(Integer [] a){
    for(int i =0; i<a.length;i++ ){a[i] = i+1;}
       return a;
    }
  
  static Integer [] shuffle (Integer [] a){
   List <Integer> xs = Arrays.asList(a);
      Collections.shuffle(xs);
      xs.toArray(a);
      return a;
  }
  static Integer [] reverse (Integer [] a){
   List <Integer> xs = Arrays.asList(a);
      Collections.reverse(xs);
      xs.toArray(a);
      return a;
  }
}