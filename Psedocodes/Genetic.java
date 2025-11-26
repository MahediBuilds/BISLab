GeneticAlgorithm():

    // 1. Define the Problem
    define objective_function()

    // 2. Initialize Parameters
    set population_size, mutation_rate, crossover_rate, max_generations

    // 3. Create Initial Population
    population = generate_random_population(population_size)

    // 4. Evaluate Fitness
    for each individual in population:
        fitness = evaluate(individual, objective_function)

    generation = 0

    while generation < max_generations and not convergence_reached():

        // 5. Selection
        parents = select_based_on_fitness(population)

        offspring = []

        // 6. Crossover + 7. Mutation
        while size(offspring) < population_size:
            parent1 = choose(parents)
            parent2 = choose(parents)

            // crossover
            if random() < crossover_rate:
                child1, child2 = perform_crossover(parent1, parent2)
            else:
                child1 = clone(parent1)
                child2 = clone(parent2)

            // mutation
            if random() < mutation_rate:
                mutate(child1)
            if random() < mutation_rate:
                mutate(child2)

            add child1 to offspring
            add child2 to offspring

        // 8. Iteration (Replacement)
        population = offspring

        // Re-evaluate fitness for new generation
        for each individual in population:
            fitness = evaluate(individual, objective_function)

        generation = generation + 1

    // 9. Output the Best Solution
    return best_individual(population)
