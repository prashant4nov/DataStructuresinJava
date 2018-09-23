// A C++ program to find strongly connected components in a given
// directed graph using Tarjan's algorithm (single DFS)
#include<iostream>
#include <list>
#include <stack>
#include <stdio.h>
#include <vector>
#include <queue>
#include <algorithm>
#include <string.h>
#include <stack> 
#include <list>

#define NIL -1
using namespace std;
#define MAXN 20005

	int disc[MAXN];
	int low[MAXN];
	bool stackMember[MAXN];
	stack<int> st;

// A class that represents an directed graph
class Graph
{
	// A Recursive DFS based function used by SCC()
	void SCCUtil(int u, int tm);
public:
	Graph(int V); // Constructor
	void addEdge(int v, int w); // function to add an edge to graph
	int* SCC(); // prints strongly connected components
	list<int> *adj; // A dynamic array of adjacency lists
	int sccCount;
	int V; // No. of vertices

};

Graph::Graph(int V)
{
	this->V = V;
	adj = new list<int>[V];
}

void Graph::addEdge(int v, int w)
{
	adj[v].push_back(w);
}

// A recursive function that finds and prints strongly connected
// components using DFS traversal
// u --> The vertex to be visited next
// disc[] --> Stores discovery times of visited vertices
// low[] -- >> earliest visited vertex (the vertex with minimum
//			 discovery time) that can be reached from subtree
//			 rooted with current vertex
// *st -- >> To store all the connected ancestors (could be part
//		 of SCC)
// stackMember[] --> bit/index array for faster check whether
//				 a node is in stack
void Graph::SCCUtil(int u, int tm)
{
	// A static variable is used for simplicity, we can avoid use
	// of static variable by passing a pointer.

	// Initialize discovery time and low value
	disc[u] = low[u] = ++tm;
	st.push(u);
	stackMember[u] = true;

	// Go through all vertices adjacent to this
	list<int>::iterator i;
	for (i = adj[u].begin(); i != adj[u].end(); ++i)
	{
		int v = *i; // v is current adjacent of 'u'

		// If v is not visited yet, then recur for it
		if (disc[v] == -1)
		{
			SCCUtil(v, tm);

			// Check if the subtree rooted with 'v' has a
			// connection to one of the ancestors of 'u'
			// Case 1 (per above discussion on Disc and Low value)
			low[u] = min(low[u], low[v]);
		}

		// Update low value of 'u' only of 'v' is still in stack
		// (i.e. it's a back edge, not cross edge).
		// Case 2 (per above discussion on Disc and Low value)
		else if (stackMember[v] == true)
			low[u] = min(low[u], disc[v]);
	}

	// head node found, pop the stack and print an SCC
	int w = 0; // To store stack extracted vertices
	if (low[u] == disc[u])
	{
		while (st.top() != u)
		{
			w = (int) st.top();
			//cout << w << " ";
			stackMember[w] = false;
			st.pop();
		}
		w = (int) st.top();
		//cout << w << "n";
		stackMember[w] = false;
		st.pop();
		sccCount++;
	}
}

// The function to do DFS traversal. It uses SCCUtil()
int* Graph::SCC()
{


	// Initialize disc and low, and stackMember arrays
	memset(disc, NIL, sizeof(disc));
	memset(low, NIL, sizeof(low));
	memset(stackMember, false, sizeof(stackMember));

	// Call the recursive helper function to find strongly
	// connected components in DFS tree with vertex 'i'
	for (int i = 0; i < V; i++)
		if (disc[i] == NIL)
			SCCUtil(i, 0);
	
	return disc;
}

// Driver program to test above function
int main()
{
    	int test, n, m, x, y;
	    scanf("%d", &test);
	
	
	while(test--) {
	    scanf("%d %d", &n, &m);
	    Graph *g = new Graph(n);
	    for(int i = 0; i < m; i++) {
	        scanf("%d %d", &x, &y);
	        g->addEdge(--x, --y);
	    }
	    
	    int *visited = g->SCC();
	    
	    int *out = new int[g->sccCount];
	    int *in = new int[g->sccCount];
	    for(int s = 0; s < n; s++) {
        	list<int>::iterator i;
	        for (i = g->adj[s].begin(); i != g->adj[s].end(); ++i) {
		        int t = *i; // v is current adjacent of 'u'
		        if(visited[s] != visited[t]) {
		            out[visited[s]]++;
		            in[visited[t]]++;
		        }
	        }
	    }
	    
	    int result1 = 0;
	    int result2 = 0;
	    for(int i = 0; i < g->sccCount; i++) {
	        if(out[i] == 0) {
	            result1++;
	        }
	        if(in[i] == 0) {
	            result2++;
	        }
	    }
	    
	    if(g->sccCount <= 1) {
	        cout << 0 << "\n";
	    } else {
	        if(result1 <= result2) {
	            cout << result2 << "\n";
	        } else {
	            cout << result1 << "\n";
	        }
	    }
	    
	   //delete(visited);
	   //delete(in);
	   //delete(out);
	   //delete(g);
	}
	return 0;
}
