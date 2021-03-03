//
// Created by wkp on 2021/1/23 0023.
//
#include <map>
#include <string>
#include <queue>
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

int Algorithm::myAtoi(string s) {
    if (s.empty()){
        return 0;
    }
    int size = s.size();
    int index = 0;
    while (index < size && s[index] == ' ') {
        index++;
    }
    if (index == size){
        return 0;
    }
    int sign = 1;
    if (s[index] == '+') {
        index++;
    } else if (s[index] == '-') {
        index++;
        sign = -1;
    }
    int res = 0;
    int max = INT_MAX / 10;
    int min = INT_MIN / 10;
    for (int i = index; i < size; ++i) {
        if (s[i] > '9' || s[i] < '0') {
            break;
        }
        int num = s[i] - '0';
        if (res > max || (res == max && num > 7)){
            return INT_MAX;
        }
        if (res < min || (res == min && num > 8)){
            return INT_MIN;
        }
        res = res * 10 + sign * num;
    }
    return res;
}

bool Algorithm::isPalindrome(int x) {
    if (x < 0 || (x % 10 == 0 && x != 0)) {
        return false;
    }
    int revNumber = 0;
    while (x > revNumber) {
        revNumber = revNumber * 10 + (x % 10);
        x /= 10;
    }
    return x == revNumber || x == revNumber / 10;
}

bool Algorithm::isMatch(string s, string p) {
    int m = s.size();
    int n = p.size();
    auto matches = [&](int i, int j){
        if (i == 0) {
            return false;
        }
        if (p[j - 1] == '.') {
            return true;
        }
        return s[i - 1] == p[j - 1];
    };
    vector<vector<int>> f(m + 1, vector<int>(n + 1));
    f[0][0] = true;
    for (int i = 0; i <= m; ++i) {
        for (int j = 1; j <= n; ++j) {
            if (p[j - 1] == '*') {
                f[i][j] |= f[i][j - 2];
                if (matches(i, j - 1)) {
                    f[i][j] |= f[i - 1][j];
                }
            } else {
                if (matches(i, j)) {
                    f[i][j] |= f[i - 1][j - 1];
                }
            }
        }
    }
    return f[m][n];
}

int Algorithm::trap(vector<int> &height) {
    int left = 0, right = height.size() - 1;
    int ans = 0;
    int left_max = 0, right_max = 0;
    while (left < right) {
        if (height[left] < height[right]) {
            (height[left] >= left_max) ? (left_max = height[left]) : (ans += (left_max - height[left]));
            left++;
        } else {
            (height[right] >= right_max) ? (right_max = height[right]) : (ans += (right_max - height[right]));
            right--;
        }
    }
    return ans;
}

bool Algorithm::canJump(vector<int> &nums) {
    int mostJump = 0;
    int length = nums.size();
    for (int i = 0; i < length; ++i) {
        if (i <= mostJump) {
            mostJump = max(mostJump, i + nums[i]);
            if (mostJump >= length - 1) {
                return true;
            }
        }
    }
    return false;
}

int Algorithm::maxProfit1(vector<int> &prices) {
    if (prices.empty()) {
        return 0;
    }
    int maxProfit = 0;
    int minPrice = INT_MAX;
    for (int price : prices) {
        if (price < minPrice) {
            minPrice = price;
        } else if (price - minPrice > maxProfit) {
            maxProfit = price - minPrice;
        }
    }
    return maxProfit;
}

int Algorithm::maxProfit2(vector<int> &prices) {
    if (prices.empty()) {
        return 0;
    }
    int maxProfit = 0;
    for (int i = 1; i < prices.size(); ++i) {
        if (prices[i] > prices[i - 1]) {
            maxProfit += prices[i] - prices[i - 1];
        }
    }
    return maxProfit;
}

int Algorithm::maxProfit3(vector<int> &prices) {
    if (prices.empty()) {
        return 0;
    }
    int buy1 = -prices[0], sell1 = 0;
    int buy2 = -prices[0], sell2 = 0;
    for (int i = 1; i < prices.size(); ++i) {
        buy1 = max(buy1, -prices[i]);
        sell1 = max(sell1, buy1 + prices[i]);
        buy2 = max(buy2, sell1 - prices[i]);
        sell2 = max(sell2, buy2 + prices[i]);
    }
    return sell2;
}

bool Algorithm::lemonadeChange(vector<int> &bills) {
    int five = 0, ten = 0;
    for (int bill : bills) {
        if (bill == 5) {
            five++;
        } else if (bill == 10){
            if (five == 0){
                return false;
            }
            five--;
            ten++;
        } else {
            if (ten > 0 && five > 0){
                ten--;
                five--;
            } else if (five >= 3){
                five -= 3;
            } else {
                return false;
            }
        }
    }
    return true;
}

void Algorithm::merge(vector<int> &A, int m, vector<int> &B, int n) {
    int pa = m - 1, pb = n - 1;
    int tail = m + n - 1;
    int cur;
    while (pa >= 0 || pb >= 0) {
        if (pa == -1){
            cur = B[pb--];
        } else if (pb == -1){
            cur = A[pa--];
        } else if (A[pa] > B[pb]) {
            cur = A[pa--];
        } else {
            cur = B[pb--];
        }
        A[tail--] = cur;
    }
}

int Algorithm::cuttingRope(int n) {
    if (n <= 3){
        return n - 1;
    }
    int a = n / 3, b = n % 3;
    if (b== 0) return (int)pow(3, a);
    if (b== 1) return (int)pow(3, a - 1) * 4;
    return (int)pow(3, a) * 2;
}

ListNode *Algorithm::getIntersectionNode(ListNode *headA, ListNode *headB) {
    ListNode *p1 = headA;
    ListNode *p2 = headB;
    while (p1 != p2) {
        p1 = p1 != nullptr ? p1->next : headB;
        p2 = p2 != nullptr ? p2->next : headA;
    }
    return p2;
}

vector<vector<int>> Algorithm::levelOrder(TreeNode *root) {
    vector<vector<int>> ret;
    if(!root){
        return ret;
    }
    queue<TreeNode*> q;
    q.push(root);
    while (!q.empty()) {
        ret.emplace_back();
        int currentLevelSize = q.size();
        for (int i = 1; i <= currentLevelSize; ++i) {
            auto node = q.front();
            q.pop();
            ret.back().push_back(node->val);
            if (node->left) q.push(node->left);
            if (node->right) q.push(node->right);
        }
    }
    return ret;
}

vector<vector<int>> Algorithm::zigzagLevelOrder(TreeNode *root) {
    vector<vector<int>> ret;
    if (!root) {
        return ret;
    }
    queue<TreeNode*> q;
    q.push(root);
    bool left2Right = true;
    int curLevelSize;
    while (!q.empty()) {
        curLevelSize = q.size();
        ret.emplace_back();
        vector<int> &level = ret.back();
        for (int i = 0; i < curLevelSize; ++i) {
            auto node = q.front();
            q.pop();
            if (left2Right) {
                level.push_back(node->val);
            } else {
                level.insert(level.begin(), node->val);
            }
            if (node->left) q.push(node->left);
            if (node->right) q.push(node->right);
        }
        left2Right = !left2Right;
    }
    return ret;
}
