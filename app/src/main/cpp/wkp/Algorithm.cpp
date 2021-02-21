//
// Created by wkp on 2021/1/23 0023.
//
#include <map>
#include <string>
#include "Algorithm.h"
#include "android/log.h"

vector<int> Algorithm::twoNum(vector<int> nums, int target) {
    map<int, int> numMap;
    vector<int> result(2);
    for (int i = 0; i < nums.size(); ++i) {
        const map<int, int>::iterator &iterator = numMap.find(target - nums[i]);
        if (iterator != numMap.end()) {
            result[0] = iterator->second;
            result[1] = i;
            return result;
        }
        numMap[nums[i]] = i;
    }
    return {-1, -1};
}

ListNode *Algorithm::addTwoNumbers(ListNode *l1, ListNode *l2) {
    if (!l1) {
        return l2;
    }
    if (!l2) {
        return l1;
    }
    ListNode *tail, *retn = l1;
    int plus = 0;
    while (l1 && l2) {
        l1->val += l2->val + plus;
        plus = l1->val / 10;
        l1->val %= 10;
        tail = l1;
        l1 = l1->next;
        l2 = l2->next;
    }
    while (l1) {
        l1->val += plus;
        plus = l1->val / 10;
        l1->val %= 10;
        tail = l1;
        l1 = l1->next;
    }
    if (l2) {
        tail->next = l2;
    }
    while (l2) {
        l2->val += plus;
        plus = l2->val / 10;
        l2->val %= 10;
        tail = l2;
        l2 = l2->next;
    }
    if (plus) {
        tail->next = static_cast<ListNode *>(malloc(sizeof(ListNode)));
        tail->next->val = plus;
        tail->next->next = NULL;
    }
    return retn;
}

int Algorithm::lengthOfLongestSubstring(string s) {
    __android_log_print(ANDROID_LOG_INFO, "wkpzs", "s: %s", s.c_str());
    int start(0), end(0), length(0), result(0);
    int sSize = s.size();
    vector<int> vec(128, -1);
    while (end < sSize) {
        char tempChar = s[end];
        if (vec[int(tempChar)] >= start) {
            start = vec[int(tempChar)] + 1;
            length = end - start;
        }
        vec[int(tempChar)] = end++;
        length++;
        result = max(length, result);
    }
    __android_log_print(ANDROID_LOG_INFO, "wkpzs", "result: %d", result);
    return result;
}

double Algorithm::findMedianSortedArrays(vector<int> &nums1, vector<int> &nums2) {
    int m = nums1.size();
    int n = nums2.size();
    if (m > n) {
        return findMedianSortedArrays(nums2, nums1);
    }
    int totalPreSize = (m + n + 1) / 2;
    int left = 0, right = m;
    int preMax = 0, nextMin = 0;
    while (left <= right) {
        int i = (left + right) / 2;
        int j = totalPreSize - i;
        int nums1LeftMax = i == 0 ? INT_MIN : nums1[i - 1];
        int nums1RightMin = i == m ? INT_MAX : nums1[i];
        int nums2LeftMax = j == 0 ? INT_MIN : nums2[j - 1];
        int nums2RightMin = j == n ? INT_MAX : nums2[j];
        if (nums1LeftMax <= nums2RightMin) {
            preMax = max(nums1LeftMax, nums2LeftMax);
            nextMin = min(nums1RightMin, nums2RightMin);
            left = i + 1;
        } else {
            right = i - 1;
        }
    }
    return (m + n) % 2 == 0 ? (preMax + nextMin) / 2.0 : preMax;
}

static pair<int, int> expandAroundCenter(const string &s, int left, int right){
    while (left >= 0 && right < s.size() && s[left] == s[right]) {
        --left;
        ++right;
    }
    return {left + 1, right - 1};
}

string Algorithm::longestPalindrome(const string& s) {
    __android_log_print(ANDROID_LOG_INFO, "wkpzs", "s: %s", s.c_str());
    int start = 0, end = 0;
    for (int i = 0; i < s.size(); ++i) {
        auto  [left1, right1] = expandAroundCenter(s, i, i);
        auto [left2, right2] = expandAroundCenter(s, i, i + 1);
        if (right1 - left1 > end - start) {
            start = left1;
            end = right1;
        }
        if (right2 - left2 > end - start) {
            start = left2;
            end = right2;
        }
    }
    __android_log_print(ANDROID_LOG_INFO, "wkpzs", "start: %d, end: %d", start, end);
    return s.substr(start, end - start + 1);
}

string Algorithm::convert(string s, int numRows) {
    if (numRows == 1) {
        return s;
    }
    vector<string> rows(min(numRows, int(s.size())));
    int curRow = 0;
    bool goingDown = false;
    for (char c : s) {
        rows[curRow] += c;
        if (curRow == 0 || curRow == numRows - 1) {
            goingDown = !goingDown;
        }
        curRow += goingDown ? 1 : -1;
    }
    string result;
    for (const string& row : rows) {
        result += row;
    }
    return result;
}

int Algorithm::reverse(int x) {
    int rev = 0;
    int max = INT_MAX / 10;
    int min = INT_MIN / 10;
    while (x != 0) {
        int pop = x % 10;
        x = x / 10;
        if (rev > max || (rev == max && pop > 7)) {
            return 0;
        }
        if (rev < min || (rev == min && pop < -8)) {
            return 0;
        }
        rev = rev * 10 + pop;
    }
    return rev;
}
