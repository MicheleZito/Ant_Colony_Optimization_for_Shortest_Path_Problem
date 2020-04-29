import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.lang.System.exit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AntColonyOptimization
{
    public static void main(String[] args)
    {
        Graph grp = new Graph();
        grp.buildGraph();
        grp.print_Graph();
        
        System.out.print("\n"+"Enter name of starting node:  ");
                
        InputStreamReader r=new InputStreamReader(System.in);  
        BufferedReader br1 = new BufferedReader(r);  
        try 
        {
            grp.setStart(br1.readLine());
        }
        catch (IOException ex)
        {
            Logger.getLogger(Graph.class.getName()).log(Level.SEVERE, null, ex);
        }
         System.out.print("\n"+"Enter name of ending node:  ");
                 
        try 
        {
            grp.setEnd(br1.readLine());
        }
        catch (IOException ex)
        {
            Logger.getLogger(Graph.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        ShortestACO aco = new ShortestACO(grp);
        aco.start();
    }
    
}
