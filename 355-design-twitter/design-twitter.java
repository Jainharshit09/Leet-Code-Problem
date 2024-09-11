class Tweet implements Comparable<Tweet> {
    int time;
    int id;

    public Tweet(int time, int id) {
        this.time = time;
        this.id = id;
    }

    public int compareTo(Tweet t) {
        return t.time - this.time;
    }
}

class user {
    int userid;
    HashSet<Integer> set;
    List<Tweet> tweets;

    public user(int userid) {
        this.userid = userid;
        set = new HashSet<>();
        tweets = new LinkedList<>();
    }

    public void addTweets(Tweet t) {
        tweets.add(0, t);
    }

    public void add(int followeeid) {
        set.add(followeeid);
    }

    public void remove(int followeeid) {
        set.remove(followeeid);
    }
}

class Twitter {
    HashMap<Integer, user> map;
    int time;

    public Twitter() {
        map = new HashMap<>();
        time = 0;
    }

    public void postTweet(int userId, int tweetId) {
        time++;
        if (!map.containsKey(userId)) {
            map.put(userId, new user(userId));
        }
        user User = map.get(userId);
        User.addTweets(new Tweet(time, tweetId));
    }

    public List<Integer> getNewsFeed(int userId) {
          if (!map.containsKey(userId)) {
            return new ArrayList<>() ;
        }
        PriorityQueue<Tweet>pq=new PriorityQueue<>();
        user User=map.get(userId);
        for(int followeId:User.set){
            int count=0;
            for(Tweet tweet:map.get(followeId).tweets){
                pq.offer(tweet);
                count++;
                if(count>10){
                    break;
                }
            }
        }
        int count=0;
         for(Tweet tweet:User.tweets){
                pq.offer(tweet);
                count++;
                if(count>10){
                    break;
                }
            }
        List<Integer> result=new ArrayList<>();
        int index=0;
        while(!pq.isEmpty() && index<10){
            Tweet m=pq.poll();
            result.add(m.id);
            index++;
        }
        return result;
    }

    public void follow(int followerId, int followeeId) {
        if (!map.containsKey(followerId)) {
            map.put(followerId, new user(followerId));
        }
        if (!map.containsKey(followeeId)) {
            map.put(followeeId, new user(followeeId));
        }
        user User = map.get(followerId);
        User.add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (!map.containsKey(followerId)|| !map.containsKey(followeeId)) {
            return ;
        }
        user User = map.get(followerId);
        User.remove(followeeId);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */