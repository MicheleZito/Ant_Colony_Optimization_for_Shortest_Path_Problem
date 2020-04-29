import java.util.Vector;

public class GraphNode 
{
	private String name;
	private Vector<Adjacency> adjs;
	
	
	public GraphNode(String name)
	{
		this.name = name;
		this.adjs = new Vector<>();
	}
	
	
	public String getName()
	{
		return this.name;
	}
	
	public void addAdjacent(Adjacency adj)
	{
		this.adjs.add(adj);
	}
	
	public Vector<Adjacency> getAdjacents()
	{
		return this.adjs;
	}
	
	
	public int getDistanceFromNode(GraphNode node)
	{
		for(Adjacency t : this.adjs)
		{
			if(t.getNode().equals(node))
			{
				return t.getLength();
			}
		}
		return -1;
	}
	
	
	public void updatePheromoneOnEdge(GraphNode node, float pheromone)
	{
		for(Adjacency t : this.adjs)
		{
			if(t.getNode().equals(node))
			{	
					t.addPheromone(pheromone);
					break;
			}
		}
	}
	
	
	public void updateAdjacentEdges()
	{
		for(Adjacency x : adjs)
		{
			x.evaporate();
		}
	}
	

	public void deleteAdjacent(GraphNode nodeToDelete)
	{
		for(Adjacency t : this.adjs)
		{
			if(t.getNode().equals(nodeToDelete))
			{
				this.adjs.removeElement(t);
				break;
			}
		}
	}
}

