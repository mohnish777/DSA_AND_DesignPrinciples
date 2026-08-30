package Navan

class Node<K, V>(
    val key: K? = null,
    var value: V? = null,
    var next: Node<K, V>? = null,
    var previous: Node<K,V>? = null
)

class LruCache<K: Any, V: Any>(
    private val capacity: Int
) {

    private val cache: MutableMap<K, Node<K,V>> = mutableMapOf<K, Node<K,V>>()
    val head: Node<K, V> = Node()
    val tail: Node<K, V> = Node()

    init {
        require(capacity > 0) {
            "Capacity must be greater than zero"
        }

        head.next = tail
        tail.previous = head
    }

    fun get(key: K): V? {
        val node: Node<K, V> = cache[key] ?: return null
        moveToFront(node)

        return node.value
    }

    fun moveToFront(node: Node<K,V>) {
        removeNode(node)
        addToFront(node)
    }

    fun removeNode(node: Node<K, V>) {
        val previousNode = node.previous
        val nextNode = node.next

        previousNode?.next = nextNode
        nextNode?.previous = previousNode

        node.previous = null
        node.next = null
    }

    fun addToFront(node: Node<K, V>) {
        val currentFirst = head.next

        head.next = node
        node.next = currentFirst
        node.previous = head
        currentFirst?.previous = node
    }

    fun put(key: K, value: V) {
        val existingNode = cache[key]

        if (existingNode !=null) {
            existingNode.value = value
            moveToFront(existingNode)
            return
        }

        val newNode = Node(key = key, value = value)

        cache[key] = newNode
        addToFront(newNode)

        if (cache.size > capacity) {
            removeLeastRecentlyUsed()
        }
    }


    fun removeLeastRecentlyUsed() {
        val lastRecentlyUsed = tail.previous
        if (lastRecentlyUsed == null || lastRecentlyUsed === head) {
            return
        }

        removeNode(lastRecentlyUsed)

        val key = lastRecentlyUsed.key

        if (key !=null) {
            cache.remove(key)
        }
    }

    fun printCache() {
        var curr = head.next
        print("Most recent ->")
        while (curr !==tail) {
            print("${curr?.key}=${curr?.value}->")
            curr = curr?.next
            if(curr === tail) {
                print("end")
            }
        }

        print("<- least recent")
    }

    fun removePrint(key: K): V? {
        val Node = cache.remove(key) ?: return null

        removeNode(Node)
        return Node.value
    }
}


fun main() {
    val cache = LruCache<Int, String>(3)

    cache.put(1, "banana")
    cache.put(2, "cherry")
    cache.put(3, "Apple")

    cache.printCache()

    cache.put(4, "Mango")
    cache.printCache()

    cache.removePrint(3)
    cache.printCache()

    cache.get(2)
}