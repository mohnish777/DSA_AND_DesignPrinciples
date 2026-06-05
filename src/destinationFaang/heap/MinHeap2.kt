package destinationFaang.heap

class MinHeap2(val capacity: Int) {
    private var size: Int = 0
    private val heap: IntArray = IntArray(capacity)

    // helper functions
    fun parent(i: Int) = (i - 1) / 2
    fun leftChild(i: Int) = i*2 + 1
    fun rightChild(i: Int) = i*2 + 2
    fun isLeaf(i: Int)  =  (i*2 + 1) >= size && i < size

    fun insert(element: Int) {
        if (size == capacity) throw IllegalStateException("Heap is full")

        heap[size] = element
        var current = size
        size++

        while (heap[current] < heap[parent(current)]) {
            swap(i = current, j = parent(current))
            current = parent(current)
        }
    }

    fun swap(i: Int, j: Int) {
        val temp = heap[i]
        heap[i] = heap[j]
        heap[j] = temp
    }

    fun removeMin(): Int {
        val min = heap[0]
        heap[0] = heap[--size]
        heapify(0)
        return min
    }

    fun heapify(i: Int) {
        if (isLeaf(i)) return
        var smallest = i
        val leftChild = leftChild(i)
        val rightChild = rightChild(i)

        if (heap[leftChild] < heap[smallest]) {
            smallest = leftChild
        }

        if (heap[rightChild] < heap[smallest]) {
            smallest = rightChild
        }

        if (smallest != i) {
            swap(i, smallest)
            heapify(smallest)
        }
    }

    fun printHeap(): String {
        return heap.contentToString()
    }


    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val minHeap = MinHeap2(10)
            minHeap.insert(5)
            minHeap.insert(3)
            minHeap.insert(17)
            minHeap.insert(10)
            minHeap.insert(84)
            minHeap.insert(19)
            minHeap.insert(6)
            minHeap.insert(22)
            minHeap.insert(9)

            println("Min value: ${minHeap.removeMin()}")
            println(minHeap.printHeap())
        }
    }

}