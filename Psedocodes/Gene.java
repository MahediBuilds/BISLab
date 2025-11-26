GeneExpressionAlgorithm():

    // 1. Define the Problem
    define objective_function()

    // 2. Initialize Parameters
    set population_size, num_genes, mutation_rate, crossover_rate, max_generations

    // 3. Initialize Population
    population = generate_random_sequences(population_size, num_genes)

    // 4. Evaluate Fitness
    for each sequence in population:
        fitness = evaluate(sequence, objective_function)

    generation = 0

    while generation < max_generations and not convergence_reached():

        // 5. Selection
        parents = select_based_on_fitness(population)

        offspring = []

        // 6. Crossover + 7. Mutation + 8. Gene Expression
        while size(offspring) < population_size:
            parent1 = choose(parents)
            parent2 = choose(parents)

            // crossover
            if random() < crossover_rate:
                child = perform_crossover(parent1, parent2)
            else:
                child = clone(parent1)

            // mutation
            if random() < mutation_rate:
                mutate(child)

            // gene expression (translate chromosome → functional solution)
            expressed_child = express(child)
            evaluate_fitness(expressed_child)

            add expressed_child to offspring

        // 9. Iterate (Replacement)
        population = offspring
        generation = generation + 1

    // 10. Output the Best Solution
    return best_individual(population)
