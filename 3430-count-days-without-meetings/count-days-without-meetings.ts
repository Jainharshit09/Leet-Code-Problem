function countDays(days: number, meetings: number[][]): number {
    let  ans=0;
    let prevTime=0;
    meetings.sort((a, b) => a[0] - b[0]);
    for (const meet of meetings) {
        const start=meet[0];
        const end=meet[1];
        if(start>prevTime+1){
            ans+=start-prevTime-1;
        }
        prevTime=Math.max(end,prevTime);
    }
    ans+=days-prevTime;
    return ans;
};