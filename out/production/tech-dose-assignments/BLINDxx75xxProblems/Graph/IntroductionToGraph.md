### **What is a graph data structure?**

There are two types of data structures

1.  Linear
2.  Non – linear

We are aware of linear data structures such as arrays, stacks, queues, and linked lists. They are called linear because data elements are arranged in a linear or sequential manner.

The only non-linear data structure that we’ve seen so far is Tree. In fact, a tree is a special type of graph with some restrictions. Graphs are data structures that have a wide-ranging application in real life. These include analysis of electrical circuits, finding the shortest routes between two places, building navigation systems like Google Maps, even social media using graphs to store data about each user, etc. To understand and use the graph data structure, let’s get familiar with the definitions and terms associated with graphs. 

### **Definitions and Terminology**

A graph is a non-linear data structure consisting of nodes that have data and are connected to other nodes through edges.

![](https://lh4.googleusercontent.com/tUHFhIbd3F9K3VUOos44xhQkm9C5bPSFqE0YNvb_jA7OyNKoJETnGwqTefsELqG9JBJGXF2E2SEw_XFfvNW_ccXfTMtY3oU2e9C2aJ4tg1d21mZKtNTVyGTxzOh_nH33VyX4tI8_LoyuLk16xh1wLV8)

**Nodes** are circles represented by numbers. Nodes are also referred to as vertices. They store the data. The numbering of the nodes can be done in any order, no specific order needs to be followed.

In the following example, the number of nodes or vertices = 5

![](https://lh6.googleusercontent.com/EvubdJVOvjpezR_W1H0CC7DyF2iuIXYS82bUbonCG2tviYKikvVwXYShjmCtpDW6-z2SsY35arCxYiCVC8S_BAYguZ3L0U2Gc7w3z6tX7dUL7uzttOd45F_U4TwiJ2EFrdl_9-VAzw1nJ27jT-o9lBQ)

Two nodes are connected by a horizontal line called **Edge**. Edge can be directed or undirected. Basically, pairs of vertices are called edges.

In the above example, the edge can go from 1 to 4 or from 4 to 1, i.e. a bidirectional edge can be in both directions, hence called an **undirected edge**. Thus, the pairs (1,4) and (4,1) represent the same edge.

### **Types of Graphs**

![](https://lh4.googleusercontent.com/tUHFhIbd3F9K3VUOos44xhQkm9C5bPSFqE0YNvb_jA7OyNKoJETnGwqTefsELqG9JBJGXF2E2SEw_XFfvNW_ccXfTMtY3oU2e9C2aJ4tg1d21mZKtNTVyGTxzOh_nH33VyX4tI8_LoyuLk16xh1wLV8)

1.  **An undirected graph** is a graph where edges are bidirectional, with no direction associated with them, i.e, there will be an undirected edge. In an undirected graph, the pair of vertices representing any edge is unordered. Thus, the pairs (u, v) and (v, u) represent the same edge.

2.  **A directed graph** is a graph where all the edges are directed from one vertex to another, i.e, there will be a directed edge. It contains an ordered pair of vertices. It implies each edge is represented by a directed pair <u, v>. Therefore, <u, v> and <v, u> represent two different edges.

There can be multi-directed edges, hence bidirectional edges, as shown in the example below.

**![](https://lh3.googleusercontent.com/E_CDW6CMmoSMeR4eF4rZv1KCu_2J1A0mCnrvnGht11KlYxpShakokXwfrdYNtU3NdMfJ9K04GJigU1fuqaCFCA-m5pS31Wx_iJ01aSZFkrdq4Bn3QkchFoh3iRak9YgwQIwn8Ugu2CpU8XgPipvkKJM)**

### **Structure of Graph** 

Does every graph have a cycle? 

The answer is No! Let us consider the following examples to understand this. 

![](https://lh6.googleusercontent.com/eYBIqocyU9uOAa0K6BWVEatAVU6ACYanjvRMla0ZUSFXtHe45o4thIha0SoXUmG_YQUN59tyF0xcLL8wNARzSeg08S5ar-L_ajHD6eB8k69IYwRwp-r7j-B1gKlGN8JCUBBVBwMXINSinuibYBd3qOw)

**Fig. 1** does not form a cycle but still, it is a graph. 

**Fig. 2** is an example of a binary tree. It can also be called a graph because it follows all the rules. We’ve nodes and edges, and this is the minimal condition to be called a graph. 

So a graph does not necessarily mean to be an enclosed structure, it can be an open structure as well. A graph is said to have a cycle if it starts from a node and ends at the same node. There can be multiple cycles in a graph.

![](https://lh6.googleusercontent.com/DfrUwFWWXA6dvxsUpgsuPHMkV1tUm_0g8b2IHT-xz3wWsWAv5ho1PWK_qKoy-5fNanrupZqZj5Go058l1xm3i-CCkGbD35EI4LIfAx7sJ0sENXyUKzu9t7BUu3_oqIk9D_4vE7DpwDZiWeParWoUu5s)

If there is at least one cycle present in the graph then it is called an **Undirected Cyclic Graph.**

In the following examples of directed graphs, the first directed graph is not cyclic as we can’t start from a node and end at the same node. Hence it is called **Directed Acyclic Graph,** commonly called **DAG.**

![](https://lh6.googleusercontent.com/vCVUDaBeBU2yQiG_okHHQ8nVs2SnPkIxvlkdzy6HJxgi8rKriovb18x9wonxe7DZCH7rDhRO2KBZ7E8dJNDmXHZJxaIcwFAfDL59Klvo_L0eXJKTTVikWP7AcBl_0rkmj9m87vTqjEXvtwh-8LT-R6Y)

If we just add an edge to the directed graph, then at least one cycle is present in the graph, hence it becomes **Directed Cyclic Graph**.

**Path in a Graph**  ![](https://lh3.googleusercontent.com/DgZLJ9dhn39Y1Mi4lUQTGRFHtWIOq2Dc6vDlAoCr7KG9RgPpIe26dhbdZV3IpvkwrajaXlu1TuTUWa7YRI5OiGDhTqowOkjCLe9qP7bUPW8G4Hqn01DR9SqXr0zMQNj7rA72TEQAz8PFpcA59F65gwc)

The path contains a lot of nodes and each of them is reachable.

Consider the given graph,

![](https://lh3.googleusercontent.com/DgZLJ9dhn39Y1Mi4lUQTGRFHtWIOq2Dc6vDlAoCr7KG9RgPpIe26dhbdZV3IpvkwrajaXlu1TuTUWa7YRI5OiGDhTqowOkjCLe9qP7bUPW8G4Hqn01DR9SqXr0zMQNj7rA72TEQAz8PFpcA59F65gwc)

```
1 2 3 5 is a path.
1 2 3 2 1 is not a path, because a node can’t appear twice in a path.
1 3 5 is not a path, as adjacent nodes must have an edge and there is no edge between 1 and 3.

```

**Degree of Graph**

It is the number of edges that go inside or outside that node.

For **undirected graphs**, the degree is the number of edges attached to a node.

```
Example, 
D(3) = 3
D(4) = 2

```

![](https://lh6.googleusercontent.com/aWFxTzgddfx2DcjMj76TXJL-eyq4xDGn4jzH06XPl1WNd1JX_kiwYsph7wMWRL62cFO26D-FnDi_2FgNDkr3k8-pyFtxbFQ7j8t1Pzb6UQ2uVQtwj1dqrLL4qPYdu5DkO2vtqElmJVhJb3XUI0JSSSQ)

**Property:** It states that the total degree of a graph is equal to twice the number of edges. This is because every edge is associated/ connected to two nodes.

![](https://lh3.googleusercontent.com/zdJj0zt2y88JF9ZOYbqAnDhJHmjkU__fvTFN2VFPagpN9An7E2maWBM_2VzZgcR7HYwFOKwR4_-A0IQgJ2JJZKMzfwAUeO868Pw8v5NGZ_E1ohPZENaK6k4aXuEDJcOCsM1nokolCE0BD8O_inRdaOo)

```
Total Degree of a graph = 2 x E
Example, (2+2+3+2+3) = 2 x 6 => 12 = 12 

```

![](https://lh6.googleusercontent.com/XiEe3nbiQ8264b1FFwSfYw8Y2MpgP3c7VjPdGPR3IkKDnbGai-yEbStojHxTTFpISU0nmbLyEuSkO7fBcgWdlM586VWVg6r5QuTn7CvSvEvC1Zpzi67YfBaXfVn2Infpn-G1shC0UXkovNZwyG8TDPY)

For **directed graphs,** we’ve Indegree and Outdegree. **The indegree** of a node is the number of incoming edges. **The** **outdegree** of a node is the number of outgoing edges.

### **Edge Weight**

A graph may have weights assigned on its edges. It is often referred to as the cost of the edge.

![](https://lh6.googleusercontent.com/9Q7ypOgGXXBPkK5_h3IN6dn1zKvlp08dq3Sigu6OwDDHTpSOkhVYV4fzRGJo4nPNbh06w7zjtW-ByNd9Sr6l-baugCmYAzVsruqwHVAIXxDvQiEg_gx2plkwPzpHAJPpemcZsL3s2Oab6axDdtxygBM)

If weights are not assigned then we assume the unit weight, i.e, 1. In applications, weight may be a measure of the cost of a route. For example, if vertices A and B represent towns in a road network, then weight on edge AB may represent the cost of moving from A to B, or vice versa.

<iframe loading="lazy" title="L1. Introduction to Graph | Types | Different Conventions Used" width="810" height="456" data-lazy-type="iframe" data-src="https://www.youtube.com/embed/M3_pLsDdeuU?feature=oembed" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen="" src="https://www.youtube.com/embed/M3_pLsDdeuU?feature=oembed"></iframe>