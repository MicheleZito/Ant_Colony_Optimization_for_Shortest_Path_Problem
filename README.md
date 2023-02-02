# Ant_Colony_Optimization_for_Shortest_Path_Problem
Java implementation of the ACO algorithm for shortest path problem

This is a Java implementation of the Ant Colony Optimization algorithm for shortest path problem based on the paper 
" Shortest Path Problem Solving Based on Ant Colony Optimization Metaheuristic" by 
M. Głabowski, B. Musznicki, P. Nowak and P. Zwierzykowski

You can find the referenced paper here:
https://www.researchgate.net/publication/234065233_Shortest_Path_Problem_Solving_Based_on_Ant_Colony_Optimization_Metaheuristic


To execute this program you need to input a .csv file which defines the graph structure placed in the /graph folder.
On the first line of the file you must declare the number of nodes of the graph separate by a ',' and followed by a 0 (or any other number you need, that value is not used).
On the second line you must define the name of the nodes, separated by a ','.
Next you must define, in the order of the names of the nodes as before, for each node of the graph the number of adjacent nodes followed by a ',0'  .
Then you must define the adjacency list one node at line declaring the name of the adjacent node (written in the same way as in the second line of the file) followed by a ',' and the integer value of the weight (distance) of the edge.

You will find an example file in the /graph folder.
