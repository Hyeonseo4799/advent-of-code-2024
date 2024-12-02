fun main() {
    fun part1(input: List<String>): Int {
        val report = input.map { it.split(" ").map(String::toInt) }
        val isSafe = { list: List<Int> -> list.zipWithNext().all { (fir, sec) -> fir < sec && sec - fir in 1..3 } }
        return report.count {
            isSafe(it) || isSafe(it.reversed())
        }
    }

    fun part2(input: List<String>): Int {
        val report = input.map { it.split(" ").map(String::toInt) }
        val isSafe = { list: List<Int> -> list.zipWithNext().all { (fir, sec) -> fir < sec && sec - fir in 1..3 } }
        val isSafe2 = { list: List<Int> ->
            val badIndex = list.zipWithNext().indexOfFirst { (fir, sec) -> !(fir < sec && sec - fir in 1..3) }
            badIndex == -1 ||
                    isSafe(list.filterIndexed { i, _ -> i != badIndex }) ||
                    isSafe(list.filterIndexed { i, _ -> i != badIndex + 1 })
        }
        return report.count { isSafe2(it) || isSafe2(it.reversed()) }
    }

    val testInput = readInput("Day02_test")
    check(part1(testInput) == 2)
    check(part2(testInput) == 4)

    val input = readInput("Day02")
    part1(input).println()
    part2(input).println()
}
