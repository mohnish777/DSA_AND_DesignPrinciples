package destinationFaang.heap

import java.util.PriorityQueue
// leet code 355
// 20hrs 30 mins
class DesignTwitter {

    // userId -> Set of followeeId
    private val followMap: HashMap<Int, MutableSet<Int>> = HashMap<Int, MutableSet<Int>>()

    // userId -> List of Pair(time, tweetId)
    private val tweetMap: HashMap<Int, MutableList<Pair<Int, Int>>> = HashMap<Int, MutableList<Pair<Int, Int>>>()

    private var time = 0

    fun postTweet(userId: Int, tweetId: Int) {
        if (tweetMap.containsKey(userId)) {
            tweetMap[userId] = mutableListOf()
        }
        tweetMap[userId]!!.add(Pair(time, tweetId))
        time++
    }

    fun getNewsFeed(userId: Int): List<Int> {
        val result: MutableList<Int> = mutableListOf()

        if(!followMap.containsKey(userId)) {
            followMap[userId] = mutableSetOf()
        }
        followMap[userId]!!.add(userId)

        val maxHeap: PriorityQueue<TweetNode> = PriorityQueue<TweetNode> { a,b ->
            b.time - a.time
        }

        for (followeeId in followMap[userId]!!) {
            val tweets: MutableList<Pair<Int, Int>>? = tweetMap[followeeId]

            if( tweets != null && tweets.isNotEmpty()) {
                val index = tweets.size - 1
                val (time, tweetId) = tweets[index]
                maxHeap.offer(
                    TweetNode(
                        tweetId = tweetId,
                        time = time,
                        index = index - 1,
                        followeeId = followeeId
                    )
                )
            }
        }

        while (maxHeap.isNotEmpty() && result.size < 10) {
            val node = maxHeap.poll()
            result.add(node.tweetId)

            if (node.index >=0) {
                val tweets = tweetMap[node.followeeId]!!
                val (time, tweetId) = tweets[node.index]
                maxHeap.offer(
                    TweetNode(
                        tweetId = tweetId,
                        time = time,
                        index = node.index - 1,
                        followeeId = node.followeeId
                    )
                )
            }
        }

        return result

    }

    fun follow(followerId: Int, followeeId: Int) {
        if (!followMap.containsKey(followerId)) {
            followMap[followerId] = mutableSetOf()
        }
        followMap[followerId]!!.add(followeeId)
    }

    fun unfollow(followerId: Int, followeeId: Int) {
        followMap[followerId]?.remove(followeeId)
    }

    data class TweetNode(
        val tweetId: Int,
        val time: Int,
        val index: Int, //keep the track of next most recent tweet index (in short 2nd last item of the list)
        val followeeId: Int // once we pop the tweet of a particular user we want to use same id to get user's list of tweets.
    )
}


/*
LeetCode 355 - Design Twitter Complexity Notes

T = total tweets stored in the system
F = number of people the user follows, including themself

postTweet:
Time: O(1)
Space per tweet: O(1)

follow:
Time: O(1) average

unfollow:
Time: O(1) average

getNewsFeed:
1. Add latest tweet from each followee to heap:
   O(F log F)

2. Poll at most 10 tweets from heap.
   Each poll/offer costs O(log F).

   O(10 log F) = O(log F)

Final getNewsFeed time:
O(F log F)

Extra space during getNewsFeed:
O(F)

Total space:
tweetMap stores all tweets: O(T)
followMap stores follow relationships: O(total follows)

Final space:
O(T + total follows)

Key idea:
Each followee has a sorted tweet list.
Start from each followee's latest tweet.
Use a max heap to repeatedly pick the newest tweet.
After picking one tweet, add the next older tweet from the same user.
Stop after collecting 10 tweets.
* */