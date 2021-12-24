def aStarAlgo(start_node, stop_node):
    open_set = set(start_node)
    closed_set = set()
    g = {}  # store distance from starting node
    parents = {}  # parents contains an adjacency map of all nodes
    cost = 0.0
    # ditance of starting node from itself is zero
    g[start_node] = 0
    # start_node is root node i.e it has no parent nodes
    # so start_node is set to its own parent node
    parents[start_node] = start_node

    while len(open_set) > 0:
        n = None # to declare every node that's open to traverse

        # node with lowest f() is found
        for v in open_set:
            if n == None or g[v] + heuristic(v) < g[n] + heuristic(n): # n = none to make sure that that v is the lowest
                n = v 

        if n == stop_node or Graph_nodes[n] == None:
            pass
        else:
            for (m, weight) in get_neighbors(n):
                # nodes 'm' not in first and last set are added to first
                # n is set its parent
                if m not in open_set and m not in closed_set:
                    open_set.add(m)
                    parents[m] = n
                    g[m] = g[n] + weight


                # for each node m,compare its distance from start i.e g(m) to the
                # from start through n node
                else:
                    if g[m] > g[n] + weight:
                        # update g(m)
                        g[m] = g[n] + weight
                        cost += g[m]
                        # change parent of m to n
                        parents[m] = n

                        # if m in closed set,remove and add to open
                        if m in closed_set:
                            closed_set.remove(m)
                            open_set.add(m)

        if n == None:
            print('Path does not exist!')
            return None

        # if the current node is the stop_node
        # then we begin reconstructin the path from it to the start_node
        if n == stop_node:
            get_neighbors(n)
            cost += weight
            path = []
        # add all the nodes while it's not the root
            while parents[n] != n:
                path.append(n)
            #After appending the children go back to the parents   
                n = parents[n]
        # then add the root
            path.append(start_node)
        #Reverse the path so it's from root to goal

            path.reverse()

            print('Path found: {}'.format(path))
            print("and it costed: " + str(float(cost)))
            return path

        # remove n from the open_list, and add it to closed_list
        # because all of his neighbors were inspected
        open_set.remove(n)
        closed_set.add(n)

    print('Path does not exist!')
    return None


# define fuction to return neighbor and its distance
# from the passed node
def get_neighbors(v):
    if v in Graph_nodes:
        return Graph_nodes[v]
    else:
        return None


# for simplicity we ll consider heuristic distances given
# and this function returns heuristic distance for all nodes
def heuristic(n):
    H_dist = {
        'A': 10.4,
        'B': 6.7,
        'C': 4.0,
        'D': 8.9,
        'E': 6.9,
        'S': 11.0,
        'F': 3.0,
        'G': 0,

    }

    return H_dist[n]


# Describe your graph here
Graph_nodes = {
    'S': [('A',2),('D',5)],
    'A': [('B', 1), ('S', 2),('D',2)],
    'B': [('C', 4), ('A', 1),('E',5)],
    'C': [('B',4)],
    'E': [('D', 2),('B',5),('F',4)],
    'F': [('G',3)],
    'D': [('S', 5),('A',2),('E',2)],


}
aStarAlgo('S', 'G')
