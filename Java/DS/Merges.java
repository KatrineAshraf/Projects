package Java.DS;
public class Merges{
 public static int []  mergesort(int []a) {
	 //to return the array as it is, if it holds one place
	 if (a.length <= 1) return a;
	 else {
		 
		 int mid = a.length/2;
		 int [] L = new int [mid];
		 int [] R;
		 if(a.length % 2 == 0) R = new int[mid];
		 else R = new int[mid +1];
		 // put the elements in the array from first index till mid index in a separate array (L)
		 for (int i = 0; i<mid; i++) {
			 L[i] = a[i];
		 }
		 /* put the rest of the elements in the array from index after mid to last index in 
		 another separate array (R) */
		 for (int i = 0; i<R.length; i++) {
			 R[i] = a[i+mid];
		 }
		 // create a new array to place the elements sorted
		 int [] sorted = new int[a.length];
		 /*make a recursive loop for both L and R to be separated by half into many arrays
		   till each has an array of 1 element then merge them again  */
		 L = mergesort(L);
		 R = mergesort(R);
		 sorted = merge(L,R);
		 return sorted;
		 
	 }
	 
 }
 private static int [] merge(int [] L, int [] R) {
	 /* i,j and k are pointers for 3 arrays
	   i for the L array , j for the R array, and k for the sorted array */
	 int i=0,j=0,k=0;
	 int [] sorted = new int[L.length + R.length];
	 /* i will point at first element in L, same for j but in R
	  the pointed elements will be compared and the smaller one will be placed in the
	  final array (sorted)  */
	 while(i<L.length && j < R.length) {
		 if (L[i]<= R[j]) {sorted[k] = L[i]; i++; k++; }
		 else {sorted[k] = R[j]; j++; k++; }
	 }
	 // the rest of the elements in R or L will be added when there's no elements to compare to000
	 while (i<L.length) {sorted[k] = L[i]; i++; k++;}
	 while (j<R.length) {sorted[k] = R[j]; j++; k++;}
	 return sorted;}}