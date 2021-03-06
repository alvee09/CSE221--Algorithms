import java.util.Scanner;
 

public class heapsort 
{    
    private static int n;
    
    public static void sort(int arr[])
    {       
        heapify(arr);        
        for (int i = n; i > 0; i--)
        {
            swap(arr,i, 0);
            n = n-1;
            maxheap(arr, 0);
        }
    }     
     
    public static void heapify(int arr[])
    {
        n = arr.length-1;
        for (int i = n/2; i >= 0; i--)
            maxheap(arr, i);        
    }
           
    public static void maxheap(int arr[], int i)
    { 
        int Left = 2*i ;
        int Right = 2*i + 1;
        int lar = i;
        if (Left <= n && arr[Left] < arr[lar])
            lar = Left;
        if (Right <= n && arr[Right] < arr[lar])        
            lar = Right;
 
        if (lar != i)
        {
            swap(arr, i, lar);
            maxheap(arr, lar);
        }
    }    
   
    public static void swap(int arr[], int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp; 
    }    
    
    public static void main(String[] args) 
    {
        Scanner scan = new Scanner( System.in );        
        System.out.println("Heap Sort Test\n");
        int n, i;    
       
        System.out.println("Enter number of integer elements");
        n = scan.nextInt();    
        
        int arr[] = new int[ n ];
        
        System.out.println("\nEnter "+ n +" integer elements");
        for (i = 0; i < n; i++)
            arr[i] = scan.nextInt();
        
        sort(arr);
       
        System.out.println("\nElements after sorting ");        
        for (i = 0; i < n; i++)
            System.out.print(arr[i]+" ");            
        System.out.println();            
    }    
}