package com.leetcode.second;

import java.util.*;

class Pair {
    int userid;
    int tweetId;

    public Pair(int userid, int tweetId) {
        this.userid = userid;
        this.tweetId = tweetId;
    }
}

public class DesignTwitter {
    Map<Integer, Set<Integer>> reversedFollowerRegister;
    List<Pair> tweets;

    int queryAmount = 10;

    public DesignTwitter() {
        reversedFollowerRegister = new HashMap<>();
        //write more? readmore?
        tweets = new LinkedList<>();
    }

    public void postTweet(int userId, int tweetId) {
        tweets.add(new Pair(userId, tweetId));
    }

    public List<Integer> getNewsFeed(int userId) {
       int k= queryAmount;
        LinkedList<Integer> result = new LinkedList<>();
        for (int i = tweets.size()-1; i >=0 && result.size() < 10; i--) {
            Pair pair = tweets.get(i);
            int currentTweetOwner = pair.userid;
            Set<Integer> followees = reversedFollowerRegister.getOrDefault(userId, new HashSet<>());
            if(currentTweetOwner == userId || followees.contains(currentTweetOwner)) {
                result.addLast(pair.tweetId);
            }
        }
        return result;
    }

    public void follow(int followerId, int followeeId) {
        Set<Integer> followees = this.reversedFollowerRegister.getOrDefault(followerId, new HashSet<>());
        followees.add(followeeId);
        reversedFollowerRegister.put(followerId, followees);
    }

    public void unfollow(int followerId, int followeeId) {
        Set<Integer> followees = this.reversedFollowerRegister.get(followerId);
        if(followees != null) {
            followees.remove(followeeId);
            reversedFollowerRegister.put(followerId, followees);
        }

    }

    public static void main(String[] args) {
        DesignTwitter twitter = new DesignTwitter();
        twitter.postTweet(1, 5); // User 1 posts a new tweet (id = 5).
        twitter.getNewsFeed(1);  // User 1's news feed should return a list with 1 tweet id -> [5]. return [5]
        twitter.follow(1, 2);    // User 1 follows user 2.
        twitter.postTweet(2, 6); // User 2 posts a new tweet (id = 6).
        System.out.println( twitter.getNewsFeed(1));  // User 1's news feed should return a list with 2 tweet ids -> [6, 5]. Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
        twitter.unfollow(1, 2);  // User 1 unfollows user 2.
        twitter.getNewsFeed(1);
    }
}
