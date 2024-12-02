import kotlin.math.abs

fun main() {
    fun part1(input: List<String>): Int {
        val result = input
            .map {
                Pair(
                    it.substringBefore(" ").toInt(),
                    it.substringAfterLast(" ").toInt()
                )
            }
            .unzip()
            .let { (fir, sec) ->
                fir.sorted().zip(sec.sorted()).sumOf { abs(it.second - it.first) }
            }
        return result
    }

    fun part2(input: List<String>): Int {
        val result = input
            .map {
                Pair(
                    it.substringBefore(" ").toInt(),
                    it.substringAfterLast(" ").toInt()
                )
            }
            .unzip()
            .let { (fir, sec) ->
                val map = sec.groupingBy { it }.eachCount()
                fir.sumOf { it * (map[it] ?: 0) }
            }
        return result
    }

    val testInput = readInput("Day01_test")
    check(part1(testInput) == 11)
    check(part2(testInput) == 31)

    val input = readInput("Day01")
    part1(input).println()
    part2(input).println()
}
