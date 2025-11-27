Set the initial value of the host nest size n, discovery probability Pa ∈ (0, 1),
and maximum number of iterations MaxT.

Set t := 0   // counter initialization

For (i = 1 to n) do
    Generate initial population of n host nests xi^t.
    Evaluate fitness f(xi^t).
End for

Repeat

    Generate a new solution (cuckoo) xi^(t+1) randomly by Lévy flight.
    Evaluate fitness of xi^(t+1), i.e., f(xi^(t+1)).

    Choose a nest xj among n solutions randomly.

    If ( f(xi^(t+1)) > f(xj^t) ) then
        Replace solution xj with xi^(t+1).
    End if

    Abandon a fraction Pa of the worst nests.
    Build new nests at new locations using Lévy flight for the fraction Pa of worst nests.

    Keep the best solution (nest with highest quality).
    Rank the solutions and identify the current best solution.

    Set t = t + 1

Until (t ≥ MaxT)

Produce the best solution (best nest xi).
