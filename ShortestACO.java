import java.util.Vector;

public class ShortestACO 
{
	private Graph graph;
	private Vector<Ant> ants;
	private Path bestPath;
	private int bestPathLen;
	private int numOfPathsFound;
	
	
	public ShortestACO(Graph gr)
	{
		this.graph = gr;
		this.ants = new Vector<>();
		this.bestPath = new Path();
		this.bestPathLen = 0;
		this.numOfPathsFound = 0;
		
		for(int i = 0; i < ShortestACOConstants.NUM_ANTS; i++)
		{
			Ant temp = new Ant(this);
			this.ants.add(temp);
		}
	}
	

	public void start()
	{
		long startTime = System.currentTimeMillis();
		
		int j = 0;
		while( (j < ShortestACOConstants.MAX_ITERATIONS) && (System.currentTimeMillis() - startTime <= ShortestACOConstants.MAX_TIME_TO_WAIT))
		{

			for(Ant t : this.ants)
			{
				t.setStart(this.graph.getStart());
				t.startTrip();
				t.applyPheromone();
			}

			this.graph.updateEdges();
			j++;
		}

		if(this.bestPathLen != 0)
		{
                    System.out.println("\n" + "Shortest Path: ");
                    Vector<GraphNode> nodesOnPath = this.bestPath.getNodes();
                    for(GraphNode t : nodesOnPath)
                    {
                        System.out.print(" -> " + t.getName());
                    }
                    System.out.println("\n\n" + "Total Distance: " + this.bestPath.getTotaLength());
                }
                else
                {
                    System.out.println("\n\n" + "No path found. Maybe The node is not connected");
                }
	}


	public GraphNode getEndNode()
	{
		return this.graph.getEnd();
	}
	
	public int getBestPathLength()
	{
		return this.bestPathLen;
	}
	
	
	public void setBestPath(Path newPath)
	{
		if(this.numOfPathsFound == 0)
		{
			this.bestPath = newPath;
			this.bestPathLen = newPath.getTotaLength();
			this.numOfPathsFound++;
		}
		else
		{
			if(newPath.getTotaLength() < this.bestPathLen)
			{
				this.bestPath = newPath;
				this.bestPathLen = newPath.getTotaLength();
			}
		}
	}
}
