package _355DesignTwitter;

import java.util.*;

class Tweet {
    int id;
    int timestamp;

    public Tweet(int id, int timestamp) {
        this.id = id;
        this.timestamp = timestamp;
    }
}

class Twitter {
    Map<Integer, List<Integer>> followMap;  // id, followees
    Map<Integer, List<Tweet>> tweetsMap;    // id, tweets
    int now;

    /** Initialize your data structure here. */
    public Twitter() {
        followMap = new HashMap<>();
        tweetsMap = new HashMap<>();
        now = 0;
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        now++;
        if (tweetsMap.containsKey(userId)) {
            tweetsMap.get(userId).add(new Tweet(tweetId, now));
        } else {
            List<Tweet> tweets = new LinkedList<>();
            tweets.add(new Tweet(tweetId, now));
            tweetsMap.put(userId, tweets);
        }
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> followees = new LinkedList<>();
        if (followMap.containsKey(userId)) {
            followees.addAll(followMap.get(userId));
        }
        followees.add(userId);
        PriorityQueue<Tweet> queue = new PriorityQueue<>(10, new Comparator<Tweet>() {
            @Override
            public int compare(Tweet o1, Tweet o2) {
                return o2.timestamp - o1.timestamp;
            }
        });
        Set<Tweet> dedupTweets = new HashSet<>();
        for (Integer follower : followees) {
            if (tweetsMap.containsKey(follower)) {
                dedupTweets.addAll(tweetsMap.get(follower));
            }
        }
        queue.addAll(dedupTweets);

        List<Integer> res = new LinkedList<>();
        for (int i = 0; i < 10 && !queue.isEmpty(); i++) {
            res.add(queue.poll().id);
        }
        return res;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {    // self -> other
        if (followMap.containsKey(followerId)) {
            followMap.get(followerId).add(followeeId);
        } else {
            List<Integer> followees = new LinkedList<>();
            followees.add(followeeId);
            followMap.put(followerId, followees);
        }
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (!followMap.containsKey(followerId)) {
            return;
        }
        List<Integer> followees = followMap.get(followerId);
        followees.remove((Integer) followeeId);
        if (followees.isEmpty()) {
            followMap.remove(followerId);
        }
    }
}


public class Solution {
    public static void main(String[] args) {
        Twitter t = new Twitter();
        t.postTweet(1, 5);
        System.out.println(t.getNewsFeed(1));
    }
}
