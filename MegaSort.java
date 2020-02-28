import java.io.*;
/**
 * A class that takes the count sort algorithm and modifies it for use with larger numbers.
 * It does so by taking the value of the k-th number and sorting it into a bucket of numbers 
 * with the same value. This process is repeated until the final k-th number is sorted through.
 * @author Dan Tat
 *
 */
public class MegaSort {
	
	public void megaSort(int[] a) { 

		for(int i=1;i<=4;i++) { // i = k-th number; k = length of longest number
			
			int[][] bucket=new int[10][a.length]; // Holds the value of each element based on the k-th number
			int[] bucketIndex={0,0,0,0,0,0,0,0,0,0}; // Tracks the amount of elements in each array, which is based on the k-th number
			
			for(int j=0;j<a.length;j++) { // Puts each element into its respective array based on the k-th number
				
				if(a[j]>0) {
					int index=kthNumber(a[j],i);
			    	bucket[index][bucketIndex[index]]=a[j];
			    	//System.out.println(bucket[1][bucketIndex[index]]);
			    	++bucketIndex[index];
				}
		    } // for
			
			// Places elements in the counter array into the original array
		    int a_index=0;
		    for(int j=0;j<10;j++) { // 10 = max
		    	
		    	for(int bIndex=0;bIndex<bucketIndex[j];bIndex++) {
		    	
		    		a[a_index]=bucket[j][bIndex];
		    		++a_index;
		    	}
		    } // for
		} // for
	} // megaSort
	
	public int kthNumber(int a,int k) { // Returns the value of the k-th number
		
		switch(k) {
		
		case 1: return a%10;
		case 2: return (a/10)%10;
		case 3: return (a/100)%10;
		default: return (a/1000)%10;
		}
	} // kthNumber
	
	public void first3Elements(int[] a) {
		
		for(int i=0;i<3;i++)
			System.out.println(a[i]);
	} // first3Elements

	public int[] readFileIntoList(String file) throws IOException {
		
		BufferedReader br=new BufferedReader(new FileReader (file));
		String line;
		int[] a=new int[1000000]; // Set to size of the file
		int i=0;
		
		try {
			
			while((line=br.readLine())!=null) {
				
				if(Integer.valueOf(line)>0) 
					a[i++]=Integer.valueOf(line);
			}
		}
		finally {
			
			br.close();
		}
		
		return a;
	}
	
	public static void main(String[] args) throws IOException {
		
		MegaSort sort=new MegaSort();
		int[] array;
		array=sort.readFileIntoList("C:\\Users\\Dan Tat\\eclipse-workspace\\cs-245-practice-05-dtat45-javaproject\\src\\1m-ints.txt");
		sort.megaSort(array);
		sort.first3Elements(array);
	}
}
