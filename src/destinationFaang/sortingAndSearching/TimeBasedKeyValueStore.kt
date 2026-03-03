package destinationFaang.sortingAndSearching

import java.util.TreeMap

class TimeBasedKeyValueStore {

    private val map: HashMap<String, TreeMap<Int, String>> = HashMap<String, TreeMap<Int, String>>()

    fun set(key: String, value: String, timestamp: Int) {
        map.computeIfAbsent(key) { TreeMap() } [timestamp] = value
    }

    // under the hood - compute if absent
    fun set2(key: String, value: String, timestamp:Int) {
        var treeMap: TreeMap<Int, String>? = map[key]
        if (treeMap == null) {
            treeMap = TreeMap()
            map[key] = treeMap
        }
        treeMap[timestamp] = value
    }

    fun get(key: String, timestamp: Int): String {
        val treeMap: TreeMap<Int, String>? = map[key]

        val entry = treeMap?.floorEntry(timestamp)

        return entry?.value ?: ""
    }

}


fun main() {
    val timeMap = TimeBasedKeyValueStore()

    println("---- Basic Example ----")
    timeMap.set("foo", "bar", 1)
    println(timeMap.get("foo", 1))  // Expected: bar
    println(timeMap.get("foo", 3))  // Expected: bar

    timeMap.set("foo", "bar2", 4)
    println(timeMap.get("foo", 4))  // Expected: bar2
    println(timeMap.get("foo", 5))  // Expected: bar2


    println("\n---- Edge Case: No Such Key ----")
    println(timeMap.get("unknown", 5))  // Expected: ""


    println("\n---- Edge Case: Timestamp Before Any Set ----")
    val tm2 = TimeBasedKeyValueStore()
    tm2.set("a", "x", 10)
    println(tm2.get("a", 5))  // Expected: ""


    println("\n---- Multiple Keys ----")
    val tm3 = TimeBasedKeyValueStore()
    tm3.set("a", "apple", 1)
    tm3.set("b", "banana", 2)
    println(tm3.get("a", 1))  // Expected: apple
    println(tm3.get("b", 2))  // Expected: banana
    println(tm3.get("a", 2))  // Expected: apple


    println("\n---- Multiple Updates Same Key ----")
    val tm4 = TimeBasedKeyValueStore()
    tm4.set("key", "v1", 1)
    tm4.set("key", "v2", 2)
    tm4.set("key", "v3", 3)
    println(tm4.get("key", 2))  // Expected: v2
    println(tm4.get("key", 3))  // Expected: v3
    println(tm4.get("key", 100)) // Expected: v3
}