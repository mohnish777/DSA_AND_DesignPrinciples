package destinationFaang.slidingWindow

// leetcode - 121. Best Time to Buy and Sell Stock
// 3hrs - 40mins


fun bestTimeToBuyStock(prices: IntArray): Int {
    var min = prices[0]
    var profit = 0

    for ( i in 0 until prices.size) {
        if(min > prices[i]) {
            min = prices[i]
        }
        profit = maxOf(profit, prices[i]-min)
    }

    return profit
}

fun main() {
    println(bestTimeToBuyStock(intArrayOf(7,1,5,3,6,4))) // 5
    println(bestTimeToBuyStock(intArrayOf(7,6,4,3,1))) // 0
}

// time complexity O(N)