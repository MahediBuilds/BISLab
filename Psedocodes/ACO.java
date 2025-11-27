AntColonyOptimization():

    1. Define the set of cities and compute distances between them.

    2. Initialize parameters:
         - number of ants
         - alpha (pheromone importance)
         - beta (heuristic importance)
         - rho (pheromone evaporation rate)
         - initial pheromone value
         - maximum number of iterations

       Initialize pheromone matrix with the initial pheromone value.

    3. Repeat for each iteration until stopping criteria:
         For each ant:
            a. Choose a random starting city.
            b. Build a route by probabilistically selecting the next city
               based on pheromone level and heuristic information (1/distance).
            c. Complete the tour by returning to the starting city.
            d. Compute the total length of the route.

         Track the best route found in this iteration.

         Update pheromone trails:
            a. Evaporate pheromone on every edge.
            b. Deposit pheromone on edges belonging to good routes
               (deposition amount is inversely proportional to route length).

    4. After all iterations, output the best route and its length.





  ACO_TSP():

    initialize pheromone[i][j] = initial_pheromone for all city pairs (i, j)

    best_route = null
    best_length = ∞

    for iteration = 1 to max_iterations:

        for each ant k:

            route = empty list
            current_city = random start city
            unvisited = all cities except current_city
            add current_city to route

            while unvisited not empty:
                for each city j in unvisited:
                    heuristic[j] = 1 / distance(current_city, j)
                    probability[j] = (pheromone[current_city][j]^alpha) * (heuristic[j]^beta)
                normalize probabilities
                next_city = select city based on probability
                add next_city to route
                remove next_city from unvisited
                current_city = next_city

            add start city to end of route (complete tour)
            route_length = compute_length(route)

            if route_length < best_length:
                best_route = route
                best_length = route_length

        // pheromone evaporation
        for each pair (i, j):
            pheromone[i][j] = (1 - rho) * pheromone[i][j]

        // pheromone reinforcement
        for each ant k:
            for each edge (i, j) in route_k:
                pheromone[i][j] = pheromone[i][j] + (Q / route_length_k)

    return best_route, best_length
