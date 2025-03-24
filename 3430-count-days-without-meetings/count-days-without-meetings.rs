impl Solution {
    pub fn count_days(days: i32, mut meetings: Vec<Vec<i32>>) -> i32 {
        let mut ans = 0;
        let mut prev_time = 0;

        meetings.sort_by_key(|meeting| meeting[0]);

        for meet in &meetings {
            if let [start, end] = meet.as_slice() {
                if start > &(prev_time + 1) {
                    ans += start - prev_time - 1;
                }
                prev_time = prev_time.max(*end);
            }
        }

        ans += days - prev_time;
        ans
    }
}
