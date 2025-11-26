ParticleSwarmOptimization():

    // 1. Define the Problem
    define objective_function()

    // 2. Initialize Parameters
    set num_particles, inertia_weight (w), cognitive_coeff (c1), social_coeff (c2), max_iterations

    // 3. Initialize Particles
    for each particle i in 1..num_particles:
        position[i] = random_position()
        velocity[i] = random_velocity()

        // pbest = personal best
        pbest_position[i] = position[i]
        pbest_fitness[i] = evaluate(position[i], objective_function)

    // gbest = global best among all pbest
    gbest_position = position of particle with highest pbest_fitness
    gbest_fitness = best value among pbest_fitness

    iteration = 0

    while iteration < max_iterations and not convergence_reached():

        for each particle i:

            // 4. Evaluate Fitness
            fitness = evaluate(position[i], objective_function)

            // Update pbest
            if fitness better than pbest_fitness[i]:
                pbest_position[i] = position[i]
                pbest_fitness[i] = fitness

                // Update gbest if needed
                if fitness better than gbest_fitness:
                    gbest_position = position[i]
                    gbest_fitness = fitness

        // 5. Update Velocities and Positions
        for each particle i:
            velocity[i] = w * velocity[i]
                          + c1 * random() * (pbest_position[i] - position[i])
                          + c2 * random() * (gbest_position - position[i])

            position[i] = position[i] + velocity[i]

        iteration = iteration + 1

    // 7. Output the Best Solution
    return gbest_position, gbest_fitness
