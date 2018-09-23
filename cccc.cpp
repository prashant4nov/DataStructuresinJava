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
vector<int> g[MAXN];

	int disc[MAXN];
	int low[MAXN];
	bool stackMember[MAXN];
	stack<int> st;
	int sccCount = 0;

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
void SCCUtil(int u, int tm)
{
	// A static variable is used for simplicity, we can avoid use
	// of static variable by passing a pointer.

	// Initialize discovery time and low value
	disc[u] = low[u] = ++tm;
	st.push(u);
	stackMember[u] = true;

	// Go through all vertices adjacent to this
	
	for (int i = 0; i < g[u].size(); ++i)
	{
		int v = g[u][i]; // v is current adjacent of 'u'

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
void SCC(int n)
{


	// Initialize disc and low, and stackMember arrays
	memset(disc, NIL, sizeof(disc));
	memset(low, NIL, sizeof(low));
	memset(stackMember, false, sizeof(stackMember));

	// Call the recursive helper function to find strongly
	// connected components in DFS tree with vertex 'i'
	for (int i = 0; i < n; i++)
		if (disc[i] == NIL)
			SCCUtil(i, 0);
	
}

// Driver program to test above function
int main()
{
    	int test, n, m, x, y;
	    scanf("%d", &test);
	
	
	while(test--) {
	    sccCount = 0;
	    scanf("%d %d", &n, &m);
	   for(int i = 0; i < n; i++)
            g[i].clear();
	    for(int i = 0; i < m; i++) {
	        scanf("%d %d", &x, &y);
	        g[x].push_back(y);
	    }
	    
	    
	    SCC(n);
	    
	    int out[sccCount];
	    int in[sccCount];
	    for(int i = 0; i < n; i++) {
	        for (int j = 0; j < g[i].size(); j++) {
		        if(disc[i] != disc[g[i][j]]) {
		            out[disc[i]]++;
		            in[disc[g[i][j]]]++;
		        }
	        }
	    }
	    
	    
	    int result1 = 0;
	    int result2 = 0;
	    for(int i = 0; i < sccCount; i++) {
	        if(out[i] == 0) {
	            result1++;
	        }
	        if(in[i] == 0) {
	            result2++;
	        }
	    }
	    
	    //cout<< "scc" << sccCount << "\n";
	    if(sccCount == 1) {
	        cout << 0 << "\n";
	    } else {
	        if(result1 <= result2) {
	            cout << result2 << "\n";
	        } else {
	            cout << result1 << "\n";
	        }
	    }
	    
	}
	return 0;
}
