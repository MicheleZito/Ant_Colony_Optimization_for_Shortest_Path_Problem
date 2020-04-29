
public class Adjacency 
{
	private GraphNode node;
	private int distance;
	private float pheromone;
	
	public Adjacency(GraphNode gr, int dist)
	{
		this.node = gr;
		this.distance = dist;
		this.setPheromone(ShortestACOConstants.THETA0);
	}
	
	
	public void addPheromone(float pheromone)
	{
		if((this.pheromone + pheromone) < ShortestACOConstants.THETA_MAX)
			this.setPheromone(this.pheromone + pheromone);
		else
			this.setPheromone(ShortestACOConstants.THETA_MAX);
	}

	public void evaporate()
	{
		if(this.pheromone * (1.0F - ShortestACOConstants.RHO) < ShortestACOConstants.THETA_MIN)
			this.setPheromone(ShortestACOConstants.THETA_MIN);
		else
			this.setPheromone(this.pheromone * (1.0F - ShortestACOConstants.RHO));
	}
	
	public GraphNode getNode()
	{
		return this.node;
	}
	
	public void setNode(GraphNode node)
	{
		this.node = node;
	}
	
	public int getLength() 
	{
		return this.distance;
	}

	public void setLength(int length)
	{
		this.distance = length;
	}
	
	public float getPheromone() 
	{
		return this.pheromone;
	}

	private void setPheromone(float pheromone)
	{
		this.pheromone = pheromone;
	}
}
