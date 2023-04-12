import com.google.ortools.algorithms.KnapsackSolver

/**
 * Sample showing how to model using the knapsack solver.
 */
object Knapsack {
    fun solve() {
        val solver = KnapsackSolver(
            KnapsackSolver.SolverType.KNAPSACK_MULTIDIMENSION_BRANCH_AND_BOUND_SOLVER, "test"
        )
        val values = longArrayOf(
            360, 83, 59, 130, 431, 67, 230, 52, 93, 125, 670, 892, 600, 38, 48, 147,
            78, 256, 63, 17, 120, 164, 432, 35, 92, 110, 22, 42, 50, 323, 514, 28, 87, 73, 78, 15, 26,
            78, 210, 36, 85, 189, 274, 43, 33, 10, 19, 389, 276, 312
        )
        val weights = arrayOf(
            longArrayOf(
                7, 0, 30, 22, 80, 94, 11, 81, 70, 64, 59, 18, 0, 36, 3, 8, 15, 42, 9,
                0, 42, 47, 52, 32, 26, 48, 55, 6, 29, 84, 2, 4, 18, 56, 7, 29, 93, 44, 71, 3, 86, 66, 31,
                65, 0, 79, 20, 65, 52, 13
            )
        )
        val capacities = longArrayOf(850)
        solver.init(values, weights, capacities)
        val computedValue = solver.solve()
        val packedItems = ArrayList<Int>()
        val packedWeights = ArrayList<Long>()
        var totalWeight = 0
        println("Total value = $computedValue")
        for (i in values.indices) {
            if (solver.bestSolutionContains(i)) {
                packedItems.add(i)
                packedWeights.add(weights[0][i])
                totalWeight = (totalWeight + weights[0][i]).toInt()
            }
        }
        println("Total weight: $totalWeight")
        println("Packed items: $packedItems")
        println("Packed weights: $packedWeights")
    }
}