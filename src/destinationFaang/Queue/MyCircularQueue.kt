package destinationFaang.Queue

class MyCircularQueue1(k: Int) {

    val data: IntArray = IntArray(k)
    var size: Int = 0
    var head: Int = 0
    var cap: Int = k

    // Insert at rear
    fun enQueue(value: Int): Boolean {
        if (full()) return false
        val tail = (head + size) % cap
        data[tail] = value
        size++
        return true
    }

    // Remove from front
    fun deQueue(): Boolean {
        if (isEmpty()) return false
        head = (head + 1) % cap
        size--
        return true
    }

    fun front(): Int {
        return if (isEmpty()) -1 else data[head]
    }

    fun rear(): Int {
        if (isEmpty()) return -1
        val tail = (head + size - 1) % cap
        return data[tail]
    }

    fun full(): Boolean {
        return cap == size
    }

    fun isEmpty(): Boolean {
        return size == 0
    }

    /*
    enQueue → O(1)
    deQueue → O(1)
    Front   → O(1)
    Rear    → O(1)
    */

    // space complexity O(K)

}


class MyCircularQueue2(k: Int) {
    val data: IntArray = IntArray(k)
    var size = 0
    var front: Int = 0
    var rear: Int = 0
    val cap: Int = k

    fun enQueue(value: Int): Boolean {
        if (full()) return false
        data[rear] = value
        rear = (rear + 1) % cap
        size++
        return true
    }

    fun deQueue(): Boolean {
        if (isEmpty()) return false
        front = (front + 1) % cap
        size--
        return true
    }


    fun isEmpty(): Boolean {
        return size == 0
    }

    fun full(): Boolean {
        return cap == size
    }

    fun rear(): Int {
        return if (isEmpty()) return -1 else data[(rear - 1 + cap ) % cap]
    }

    fun front(): Int {
        return if (isEmpty()) -1 else data[front]
    }
}