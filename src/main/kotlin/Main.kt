import com.google.ortools.Loader

fun main() {
    println("Starting Knapsack!")

    Loader.loadNativeLibraries()
    Knapsack.solve()
}