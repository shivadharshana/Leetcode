class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];

       
        for (char t : tasks) {
            freq[t - 'A']++;
        }

       
        int max = 0;
        for (int f : freq) {
            max = Math.max(max, f);
        }

       
        int maxCount = 0;
        for (int f : freq) {
            if (f == max) maxCount++;
        }

       
        int partCount = max - 1;
        int partLength = n - (maxCount - 1);
        int emptySlots = partCount * partLength;
        int availableTasks = tasks.length - max * maxCount;
        int idles = Math.max(0, emptySlots - availableTasks);

        return tasks.length + idles;
    }
}