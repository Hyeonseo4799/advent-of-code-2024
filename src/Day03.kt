fun main() {
    fun part1(input: List<String>): Int {
        return input.flatMap { Regex("mul\\(\\d+,\\d+\\)").findAll(it) }.sumOf { match ->
            match.value.substringAfter("(")
                .replace(")", "")
                .split(",")
                .let { it.first().toInt() * it.last().toInt() }
        }
    }

    fun part2(input: List<String>): Int {
        var enabled = true
        return input.flatMap { Regex("""(mul\((\d+),(\d+)\)|do\(\)|don't\(\))""").findAll(it) }.sumOf {
            if ("mul" in it.value) {
                if (enabled) return@sumOf it.groupValues[2].toInt() * it.groupValues[3].toInt()
             } else if ("'" in it.value) enabled = false
            else enabled = true
            0
        }

    }

    val testInput = readInput("Day03_test")
//    part1(testInput).println()


    val input = readInput("Day03")
//    part1(input).println()
    part2(input).println()
}
