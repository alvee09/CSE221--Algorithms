import java.util.*;
import java.io.*;

public class UndirectedGraphReader 
{
  public static void main(String[] args) throws Exception
  {
    FileReader fr= new FileReader("./input.txt");
    Scanner input= new Scanner(fr);
    int nodes= (int)input.nextInt();
    int edges= (int)input.nextInt();
    input.nextLine();
  
    int[][] adjMatrix= new int[nodes+1][nodes+1];
    for(int i=0; i<edges; i++)
    {
      int from= (int)input.nextInt();
      int to = (int)input.nextInt();
      input.nextLine();
      
      adjMatrix[from][to]=1;
      adjMatrix[to][from]=1;
    }
    PrintMatrix(adjMatrix);
    System.out.println();
    PrintList(adjMatrix);
  }
  public static void PrintMatrix(int [][] a)
  {
    System.out.println("Adjacency Matrix:");
    System.out.print(" ");
    for(int i=1; i<a.length; i++)
    {
      System.out.print("|"+i);
    }
    System.out.println("|");
    for(int j=1; j<a.length; j++)
    {
      System.out.print(j+"|");
      for(int k= 1; k<a.length; k++)
      {
        System.out.print(a[j][k]+"|");
      }
      System.out.println();
    }
  }
  public static void PrintList(int [][] a)
  {
    System.out.println("Adjacency List:");
    for(int i=1; i<a.length; i++)
    {
      System.out.print(i+"|");
      for(int j=1; j<a.length; j++)
      {
        if(a[i][j]==1)
        {
          System.out.print("->"+j);
        }
      }
      System.out.println("->|");
    }
  }
}