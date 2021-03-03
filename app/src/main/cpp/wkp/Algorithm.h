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
struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL){}
};
class Algorithm {
public:
    static vector<int> twoNum(vector<int> nums, int target);

    static ListNode *addTwoNumbers(ListNode *l1, ListNode *l2);

    static int lengthOfLongestSubstring(string s);

    static double findMedianSortedArrays(vector<int> &nums1, vector<int> &nums2);

    static string longestPalindrome(const string& s);

    static string convert(string s, int numRows);

    static int reverse(int x);

    static int myAtoi(string s);

    static bool isPalindrome(int x);

    static bool isMatch(string s, string p);

    static int trap(vector<int> &height);

    static bool canJump(vector<int> &nums);

    static int maxProfit1(vector<int> &prices);

    static int maxProfit2(vector<int> &prices);

    static int maxProfit3(vector<int> &prices);

    static bool lemonadeChange(vector<int>& bills);

    static void merge(vector<int>& A, int m, vector<int>& B, int n);

    static int cuttingRope(int n);

    static ListNode *getIntersectionNode(ListNode *headA, ListNode *headB);

    static vector<vector<int>> levelOrder(TreeNode *root);

    static vector<vector<int>> zigzagLevelOrder(TreeNode *root);
};
#endif //ALGORITHM_ALGORITHM_H
