import java.util.Vector;


public class Path
{
	private int totaLength;
	private Vector<GraphNode> pathNodes;
	
	
	public Path()
	{
		this.pathNodes = new Vector<>();
		this.totaLength = 0;
	}
	
	
	public void releasePheromone(float bestLength)
	{
		float pheromoneToApply = (bestLength/this.totaLength);
		for(int i = 0; i < pathNodes.size()-1; i++)
		{
			this.pathNodes.elementAt(i).updatePheromoneOnEdge(this.pathNodes.elementAt(i+1), pheromoneToApply);
			this.pathNodes.elementAt(i+1).updatePheromoneOnEdge(this.pathNodes.elementAt(i), pheromoneToApply);
		}
	}
	
	public void add(GraphNode node)
	{
		this.pathNodes.add(node);
	}
	
	public int getTotaLength()
	{
		return totaLength;
	}

	
	public void calculateTotaLength()
	{
		for(int i = 0; i < this.pathNodes.size() -1; i++)
		{
			this.setTotaLength(this.getTotaLength() + this.pathNodes.elementAt(i).getDistanceFromNode(this.pathNodes.elementAt(i+1)));
		}
	}
	
	private void setTotaLength(int newLength)
	{
		this.totaLength = newLength;
	}
	
	public Vector<GraphNode> getNodes()
	{
		return this.pathNodes;
	}

}

