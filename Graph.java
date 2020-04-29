import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static java.lang.System.exit;
import java.nio.file.Paths;
import java.util.Random;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Graph
{
	private Vector<GraphNode> nodes;
	private GraphNode start;
	private GraphNode end;
	

	public Graph()
	{
		this.nodes = new Vector<>();
		this.start = new GraphNode(null);
		this.end = new GraphNode(null);
	}
	

	public void updateEdges()
	{
		for(GraphNode t : nodes)
			t.updateAdjacentEdges();
	}

	public GraphNode getStart() {
		return start;
	}

	
	public void setStart(String name)
	{
            Boolean  cond = FALSE;
            for(GraphNode t : this.nodes)
            {
            	if(t.getName().equals(name))
            	{
                    this.start = t;
                    cond = TRUE;
                    break;
		}
            }
            if(!cond)
            {
                System.out.println("\n\n" + "[!!] Error : Insert name of existing node");
                exit(1);
            }
	}
	
	public GraphNode getEnd() {
		return end;
	}

	
	public void setEnd(String name)
	{
            Boolean  cond = FALSE;
            for(GraphNode t : this.nodes)
            {
            	if(t.getName().equals(name))
            	{
                    this.end = t;
                    cond = TRUE;
                    break;
		}
            }
            if(!cond)
            {
                System.out.println("\n\n" + "[!!] Error : Insert name of existing node");
                exit(1);
            }
	}
	
	
	public void buildGraph()
	{
                String current_path = Paths.get("").toAbsolutePath().toString().replace("\\", "/");
                
                System.out.print("Enter graph filename:");
                
                InputStreamReader r=new InputStreamReader(System.in);  
                BufferedReader br1 = new BufferedReader(r);  
 
                String input = "";
                try 
                {
                    input = br1.readLine();
                }
                catch (IOException ex)
                {
                    Logger.getLogger(Graph.class.getName()).log(Level.SEVERE, null, ex);
                }
                
		BufferedReader br = null;
		String line = "";
		String csvSplitBy = ",";

		String csvFile = current_path + "/graphs/" + input;
                
                try {

			br = new BufferedReader(new FileReader(csvFile));
			line = br.readLine();
			String[] element1 = line.split(csvSplitBy);
			int num_nodes = Integer.parseInt(element1[0]);
                        line = br.readLine();
                        String[] names = line.split(csvSplitBy);
                        for(String x : names)
                            this.nodes.add(new GraphNode(x));
                        for(int j = 0; j < num_nodes; j++)
                        {
                            line = br.readLine();
                            String[] element2 = line.split(csvSplitBy);
                            int num_adj = Integer.parseInt(element2[0]);
                            for(int i = 0; i < num_adj; i++)
                            {
                                line = br.readLine();
                                element2 = line.split(csvSplitBy);
                                String adjacent_name = element2[0];
                                int weight = Integer.parseInt(element2[1]);
                                for(GraphNode y : this.nodes)
                                {
                                    if(y.getName().equals(adjacent_name))
                                    {
                                        this.nodes.elementAt(j).addAdjacent(new Adjacency(y,weight));
                                    }
                                }
                            }
                        }
                }
                catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		finally 
		{
			if (br != null)
			{
				try
				{
					br.close();
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
			}
		}
	}

        
        public void print_Graph()
        {
            System.out.println("\n"+"Printing Graph" + "\n");
            for(GraphNode x : this.nodes)
            {
                System.out.println("\n"+ "Node name:  " +  x.getName());
                System.out.println("Adjacencies:");
                for(Adjacency t : x.getAdjacents())
                {
                    System.out.println(t.getNode().getName() + " with distance: " + t.getLength());
                }
            }
        }
}
