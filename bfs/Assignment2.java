import java.util.*;
import java.io.*;

public class Assignment2 
{
  
  public static void main(String[] args) throws Exception
  {
    FileReader fr= new FileReader("./directedinput.txt");
    Scanner input= new Scanner(fr);
    int nodes= (int)input.nextInt();
    int edges= (int)input.nextInt();
    input.nextLine();
  
    int[][] adjMatrix= new int[nodes+1][nodes+1];
    for(int i=0; i<edges; i++)
    {
      int from= (int)input.nextInt();
      int to = (int)input.nextInt();
      //input.nextLine();
      adjMatrix[from][to]++;
    }
    BFS(adjMatrix, nodes);
  }
  public static void BFS(int [][] a, int n )
  {
    boolean [] visited= new boolean[n+1];
    Queue queue= new LinkedList();
    for(int i=1; i<=n;i++)
    {
      if(visited[i])
      {
        continue;
      }
      
      visited[i]=true;
      System.out.println(i);
      queue.add(i);
      
      while(!queue.isEmpty())
      {
        int src= (int) queue.remove();
        for(int j =1; j<=n; j++)
        {
          if(a[src][j]==1 && !visited[j])
          {
            visited[j]= true;
            System.out.println(j);
            queue.add(j);
          }
        }
      }
//      if(i==1)
//      {
//        queue.add(i);
//        visited[1]=i;
//      }
//      else
//      {
//        for(int j = 1; i<=n;j++)
//        {
//          if(a[i][j]==1)
//          {
//            while(int count=1)
//            {
//              if(visited[count]==a[i][j])
//              {
//                break;
//              }
//              count++;
//            }
//            queue.add(j
//                    }
//      }
    }
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