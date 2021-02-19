//
// Created by wkp on 2021/1/23 0023.
//
#include <vector>
using namespace std;
#ifndef ALGORITHM_ALGORITHM_H
#define ALGORITHM_ALGORITHM_H
struct ListNode{
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};
class Algorithm {
public:
    static vector<int> twoNum(vector<int> nums, int target);

    static ListNode *addTwoNumbers(ListNode *l1, ListNode *l2);

    static int lengthOfLongestSubstring(string s);

    static double findMedianSortedArrays(vector<int> &nums1, vector<int> &nums2);

    static string longestPalindrome(const string& s);
};
#endif //ALGORITHM_ALGORITHM_H
