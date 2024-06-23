import java.util.*;

class Solution {
  public int solution(int[] people, int limit) {
    Arrays.sort(people);
    int l = 0;
    int r = people.length - 1;
    int result = 0;
    if (l==r)
      return 1;

    while(l <= r) {
      result++;
      int remain = limit - people[r];
      r--;

      if (people[l] <= remain) {
        l++;
      }
    }
    return result;
  }
}