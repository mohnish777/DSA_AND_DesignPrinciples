package destinationFaang.heap

import kotlin.math.min

class MinHeap(private val capacity: Int) {
    private val heap = IntArray(capacity)
    private var size = 0

    // Helper methods
    private fun parent(i: Int) = (i - 1) / 2
    private fun leftChild(i: Int) = 2 * i + 1
    private fun rightChild(i: Int) = 2 * i + 2
    private fun isLeaf(i: Int) = i >= size / 2 && i < size

    // Insert a new element into the heap
    fun insert(element: Int) {
        if (size == capacity) throw IllegalStateException("Heap is full")

        heap[size] = element
        var current = size
        size++

        while (heap[current] < heap[parent(current)]) {
            swap(current, parent(current))
            current = parent(current)
        }
    }

    // Remove and return the minimum element from the heap
    fun removeMin(): Int {
        if (size == 0) throw IllegalStateException("Heap is empty")

        val min = heap[0]
        heap[0] = heap[--size]
        heapify(0)

        return min
    }

    // Heapify the heap starting from a given index
    private fun heapify(i: Int) {
        if (isLeaf(i)) return

        val left = leftChild(i)
        val right = rightChild(i)
        var smallest = i

        if (left < size && heap[left] < heap[i]) {
            smallest = left
        }

        if (right < size && heap[right] < heap[smallest]) {
            smallest = right
        }

        if (smallest != i) {
            swap(i, smallest)
            heapify(smallest)
        }
    }

    // Swap two elements in the heap array
    private fun swap(i: Int, j: Int) {
        val temp = heap[i]
        heap[i] = heap[j]
        heap[j] = temp
    }

    fun printHeap(): String {
        return heap.contentToString()
    }

    // Main method for testing
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val minHeap = MinHeap(10)
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