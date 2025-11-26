ParticleSwarmOptimization():

    // 1. Define the Problem
    define objective_function()

    // 2. Initialize Parameters
    set num_particles, inertia_weight (w), cognitive_coeff (c1), social_coeff (c2), max_iterations

    // 3. Initialize Particles
    for each particle i in 1..num_particles:
        position[i] = random_position()
        velocity[i] = random_velocity()
        personal_best_position[i] = position[i]
        personal_best_fitness[i] = evaluate(position[i], objective_function)

    // Determine global best
    global_best_position = position of particle with highest fitness
    global_best_fitness = fitness(global_best_position)

    iteration = 0

    while iteration < max_iterations and not convergence_reached():

        // 4. Evaluate Fitness
        for each particle i:
            fitness = evaluate(position[i], objective_function)

            if fitness better than personal_best_fitness[i]:
                personal_best_position[i] = position[i]
                personal_best_fitness[i] = fitness

            if fitness better than global_best_fitness:
                global_best_position = position[i]
                global_best_fitness = fitness

        // 5. Update Velocities and Positions
        for each particle i:
            velocity[i] = w * velocity[i]
                          + c1 * random() * (personal_best_position[i] - position[i])
                          + c2 * random() * (global_best_position - position[i])

            position[i] = position[i] + velocity[i]

        iteration = iteration + 1

    // 7. Output the Best Solution
    return global_best_position, global_best_fitness
