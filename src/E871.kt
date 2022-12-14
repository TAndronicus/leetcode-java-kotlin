import kotlin.math.max

private class E871 {
    fun minRefuelStops1(target: Int, startFuel: Int, stations: Array<IntArray>): Int {
        stations.sortBy { it[0] }
        var previousPosition = 0
        var possibleRefills = mutableListOf(Pair(startFuel, 0))
        for (station in stations) {
            val reached = mutableListOf<Pair<Int, Int>>()
            val distance = station[0] - previousPosition
            for (possibleRefill in possibleRefills) {
                if (distance > possibleRefill.first) continue
                else {
                    reached.add(Pair(possibleRefill.first - distance + station[1], possibleRefill.second + 1))
                    if (distance < possibleRefill.first) reached.add(Pair(possibleRefill.first - distance, possibleRefill.second))
                }
            }
            if (reached.isEmpty()) return -1
            possibleRefills = reached
            previousPosition = station[0]
        }
        val intList = possibleRefills
            .filter { possibleRefill -> possibleRefill.first >= target - previousPosition }
            .map { it.second }
            .toIntArray()
        return if (intList.isEmpty()) -1 else intList.sorted().first()
    }

    fun minRefuelStops2(target: Int, startFuel: Int, stations: Array<IntArray>): Int {
        stations.sortBy { it[0] }
        var previousPosition = 0
        var possibleRefills = mutableMapOf(0 to startFuel)
        for (station in stations) {
            val reached = mutableMapOf<Int, Int>()
            val distance = station[0] - previousPosition
            for ((refills, fuelLeft) in possibleRefills) {
                if (distance > fuelLeft) continue
                else {
                    reached.merge(refills + 1, fuelLeft - distance + station[1]) { left, right -> max(left, right) }
                    reached.merge(refills, fuelLeft - distance) { left, right -> max(left, right) }
                }
            }
            if (reached.isEmpty()) return -1
            possibleRefills = reached
            previousPosition = station[0]
        }
        for ((refills, fuelLeft) in possibleRefills.toSortedMap()) {
            if (fuelLeft >= target - previousPosition) return refills
        }
        return -1
    }
}


fun main() {
    val s = E871()
    println(s.minRefuelStops1(1, 1, arrayOf()) == 0)
    println(s.minRefuelStops1(100, 1, arrayOf(intArrayOf(10, 100))) == -1)
    println(s.minRefuelStops1(100, 10, arrayOf(intArrayOf(10, 60), intArrayOf(20, 30), intArrayOf(30, 30), intArrayOf(60, 40))) == 2)
    println(s.minRefuelStops2(1, 1, arrayOf()) == 0)
    println(s.minRefuelStops2(100, 1, arrayOf(intArrayOf(10, 100))) == -1)
    println(s.minRefuelStops2(100, 10, arrayOf(intArrayOf(10, 60), intArrayOf(20, 30), intArrayOf(30, 30), intArrayOf(60, 40))) == 2)
}