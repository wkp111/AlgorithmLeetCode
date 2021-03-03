package com.wkp.algorithm;

import java.util.List;

public class Algorithm {
    static {
        System.loadLibrary("native-lib");
    }

    /**
     * 1.两数之和
     * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。
     *
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
     *
     * 你可以按任意顺序返回答案。
     *
     * 示例 1：
     *
     * 输入：nums = [2,7,11,15], target = 9
     * 输出：[0,1]
     * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
     * 示例 2：
     *
     * 输入：nums = [3,2,4], target = 6
     * 输出：[1,2]
     * 示例 3：
     *
     * 输入：nums = [3,3], target = 6
     * 输出：[0,1]
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/two-sum
     * @param nums 数组
     * @param target 目标和
     * @return 索引
     */
    public native int[] twoSum(int[] nums, int target);

    /**
     * 2.两数相加
     * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
     *
     * 请你将两个数相加，并以相同形式返回一个表示和的链表。
     *
     * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     *
     *  
     *
     * 示例 1：
     *
     *
     * 输入：l1 = [2,4,3], l2 = [5,6,4]
     * 输出：[7,0,8]
     * 解释：342 + 465 = 807.
     * 示例 2：
     *
     * 输入：l1 = [0], l2 = [0]
     * 输出：[0]
     * 示例 3：
     *
     * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
     * 输出：[8,9,9,9,0,0,0,1]
     *  
     *
     * 提示：
     *
     * 每个链表中的节点数在范围 [1, 100] 内
     * 0 <= Node.val <= 9
     * 题目数据保证列表表示的数字不含前导零
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/add-two-numbers
     * @param l1 链表1
     * @param l2 链表2
     * @return 结果
     */
    public native ListNode addTwoNumbers(ListNode l1, ListNode l2);

    /**
     * 3. 无重复字符的最长子串
     * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
     *
     *  
     *
     * 示例 1:
     *
     * 输入: s = "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     * 示例 2:
     *
     * 输入: s = "bbbbb"
     * 输出: 1
     * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
     * 示例 3:
     *
     * 输入: s = "pwwkew"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
     * 示例 4:
     *
     * 输入: s = ""
     * 输出: 0
     *  
     *
     * 提示：
     *
     * 0 <= s.length <= 5 * 104
     * s 由英文字母、数字、符号和空格组成
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
     * @param s 子串
     * @return 长度
     */
    public native int lengthOfLongestSubstring(String s);

    /**
     * 4. 寻找两个正序数组的中位数
     * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的中位数。
     *
     * 进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？
     *
     *  
     *
     * 示例 1：
     *
     * 输入：nums1 = [1,3], nums2 = [2]
     * 输出：2.00000
     * 解释：合并数组 = [1,2,3] ，中位数 2
     * 示例 2：
     *
     * 输入：nums1 = [1,2], nums2 = [3,4]
     * 输出：2.50000
     * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
     * 示例 3：
     *
     * 输入：nums1 = [0,0], nums2 = [0,0]
     * 输出：0.00000
     * 示例 4：
     *
     * 输入：nums1 = [], nums2 = [1]
     * 输出：1.00000
     * 示例 5：
     *
     * 输入：nums1 = [2], nums2 = []
     * 输出：2.00000
     *  
     *
     * 提示：
     *
     * nums1.length == m
     * nums2.length == n
     * 0 <= m <= 1000
     * 0 <= n <= 1000
     * 1 <= m + n <= 2000
     * -106 <= nums1[i], nums2[i] <= 106
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
     *
     * @param nums1 有序数组1
     * @param nums2 有序数组2
     * @return 中位数
     */
    public native double findMedianSortedArrays(int[] nums1, int[] nums2);

    /**
     * 5. 最长回文子串
     * 给你一个字符串 s，找到 s 中最长的回文子串。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：s = "babad"
     * 输出："bab"
     * 解释："aba" 同样是符合题意的答案。
     * 示例 2：
     *
     * 输入：s = "cbbd"
     * 输出："bb"
     * 示例 3：
     *
     * 输入：s = "a"
     * 输出："a"
     * 示例 4：
     *
     * 输入：s = "ac"
     * 输出："a"
     *  
     *
     * 提示：
     *
     * 1 <= s.length <= 1000
     * s 仅由数字和英文字母（大写和/或小写）组成
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
     * @param s 原始串
     * @return 回文串
     */
    public native String longestPalindrome(String s);

    /**
     * 6. Z 字形变换
     * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
     *
     * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
     *
     * P   A   H   N
     * A P L S I I G
     * Y   I   R
     * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
     *
     * 请你实现这个将字符串进行指定行数变换的函数：
     *
     * string convert(string s, int numRows);
     *  
     *
     * 示例 1：
     *
     * 输入：s = "PAYPALISHIRING", numRows = 3
     * 输出："PAHNAPLSIIGYIR"
     * 示例 2：
     * 输入：s = "PAYPALISHIRING", numRows = 4
     * 输出："PINALSIGYAHRPI"
     * 解释：
     * P     I    N
     * A   L S  I G
     * Y A   H R
     * P     I
     * 示例 3：
     *
     * 输入：s = "A", numRows = 1
     * 输出："A"
     *  
     *
     * 提示：
     *
     * 1 <= s.length <= 1000
     * s 由英文字母（小写和大写）、',' 和 '.' 组成
     * 1 <= numRows <= 1000
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/zigzag-conversion
     * @param s 原字串
     * @param numRows Z字形行数
     * @return 行数拼接字串
     */
    public native String convert(String s, int numRows);

    /**
     * 7. 整数反转
     * 给你一个 32 位的有符号整数 x ，返回 x 中每位上的数字反转后的结果。
     *
     * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
     *
     * 假设环境不允许存储 64 位整数（有符号或无符号）。
     *  
     *
     * 示例 1：
     *
     * 输入：x = 123
     * 输出：321
     * 示例 2：
     *
     * 输入：x = -123
     * 输出：-321
     * 示例 3：
     *
     * 输入：x = 120
     * 输出：21
     * 示例 4：
     *
     * 输入：x = 0
     * 输出：0
     *  
     *
     * 提示：
     *
     * -231 <= x <= 231 - 1
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/reverse-integer
     * @param x 原值
     * @return 反转值
     */
    public native int reverse(int x);

    /**
     * 8. 字符串转换整数 (atoi)
     * 请你来实现一个 myAtoi(string s) 函数，使其能将字符串转换成一个 32 位有符号整数（类似 C/C++ 中的 atoi 函数）。
     *
     * 函数 myAtoi(string s) 的算法如下：
     *
     * 读入字符串并丢弃无用的前导空格
     * 检查下一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。 确定最终结果是负数还是正数。 如果两者都不存在，则假定结果为正。
     * 读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。
     * 将前面步骤读入的这些数字转换为整数（即，"123" -> 123， "0032" -> 32）。如果没有读入数字，则整数为 0 。必要时更改符号（从步骤 2 开始）。
     * 如果整数数超过 32 位有符号整数范围 [−231,  231 − 1] ，需要截断这个整数，使其保持在这个范围内。具体来说，小于 −231 的整数应该被固定为 −231 ，大于 231 − 1 的整数应该被固定为 231 − 1 。
     * 返回整数作为最终结果。
     * 注意：
     *
     * 本题中的空白字符只包括空格字符 ' ' 。
     * 除前导空格或数字后的其余字符串外，请勿忽略 任何其他字符。
     *  
     *
     * 示例 1：
     *
     * 输入：s = "42"
     * 输出：42
     * 解释：加粗的字符串为已经读入的字符，插入符号是当前读取的字符。
     * 第 1 步："42"（当前没有读入字符，因为没有前导空格）
     *          ^
     * 第 2 步："42"（当前没有读入字符，因为这里不存在 '-' 或者 '+'）
     *          ^
     * 第 3 步："42"（读入 "42"）
     *            ^
     * 解析得到整数 42 。
     * 由于 "42" 在范围 [-231, 231 - 1] 内，最终结果为 42 。
     * 示例 2：
     *
     * 输入：s = "   -42"
     * 输出：-42
     * 解释：
     * 第 1 步："   -42"（读入前导空格，但忽视掉）
     *             ^
     * 第 2 步："   -42"（读入 '-' 字符，所以结果应该是负数）
     *              ^
     * 第 3 步："   -42"（读入 "42"）
     *                ^
     * 解析得到整数 -42 。
     * 由于 "-42" 在范围 [-231, 231 - 1] 内，最终结果为 -42 。
     * 示例 3：
     *
     * 输入：s = "4193 with words"
     * 输出：4193
     * 解释：
     * 第 1 步："4193 with words"（当前没有读入字符，因为没有前导空格）
     *          ^
     * 第 2 步："4193 with words"（当前没有读入字符，因为这里不存在 '-' 或者 '+'）
     *          ^
     * 第 3 步："4193 with words"（读入 "4193"；由于下一个字符不是一个数字，所以读入停止）
     *              ^
     * 解析得到整数 4193 。
     * 由于 "4193" 在范围 [-231, 231 - 1] 内，最终结果为 4193 。
     * 示例 4：
     *
     * 输入：s = "words and 987"
     * 输出：0
     * 解释：
     * 第 1 步："words and 987"（当前没有读入字符，因为没有前导空格）
     *          ^
     * 第 2 步："words and 987"（当前没有读入字符，因为这里不存在 '-' 或者 '+'）
     *          ^
     * 第 3 步："words and 987"（由于当前字符 'w' 不是一个数字，所以读入停止）
     *          ^
     * 解析得到整数 0 ，因为没有读入任何数字。
     * 由于 0 在范围 [-231, 231 - 1] 内，最终结果为 0 。
     * 示例 5：
     *
     * 输入：s = "-91283472332"
     * 输出：-2147483648
     * 解释：
     * 第 1 步："-91283472332"（当前没有读入字符，因为没有前导空格）
     *          ^
     * 第 2 步："-91283472332"（读入 '-' 字符，所以结果应该是负数）
     *           ^
     * 第 3 步："-91283472332"（读入 "91283472332"）
     *                      ^
     * 解析得到整数 -91283472332 。
     * 由于 -91283472332 小于范围 [-231, 231 - 1] 的下界，最终结果被截断为 -231 = -2147483648 。
     *  
     *
     * 提示：
     *
     * 0 <= s.length <= 200
     * s 由英文字母（大写和小写）、数字（0-9）、' '、'+'、'-' 和 '.' 组成
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/string-to-integer-atoi
     * @param s 字串
     * @return int值
     */
    public native int myAtoi(String s);

    /**
     * 9. 回文数
     * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
     *
     * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：x = 121
     * 输出：true
     * 示例 2：
     *
     * 输入：x = -121
     * 输出：false
     * 解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
     * 示例 3：
     *
     * 输入：x = 10
     * 输出：false
     * 解释：从右向左读, 为 01 。因此它不是一个回文数。
     * 示例 4：
     *
     * 输入：x = -101
     * 输出：false
     *  
     *
     * 提示：
     *
     * -231 <= x <= 231 - 1
     *  
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/palindrome-number
     * 进阶：你能不将整数转为字符串来解决这个问题吗？
     * @param x 回文数
     * @return 是否为回文数
     */
    public native boolean isPalindrome(int x);

    /**
     * 10. 正则表达式匹配
     * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
     *
     * '.' 匹配任意单个字符
     * '*' 匹配零个或多个前面的那一个元素
     * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
     *
     *  
     * 示例 1：
     *
     * 输入：s = "aa" p = "a"
     * 输出：false
     * 解释："a" 无法匹配 "aa" 整个字符串。
     * 示例 2:
     *
     * 输入：s = "aa" p = "a*"
     * 输出：true
     * 解释：因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
     * 示例 3：
     *
     * 输入：s = "ab" p = ".*"
     * 输出：true
     * 解释：".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
     * 示例 4：
     *
     * 输入：s = "aab" p = "c*a*b"
     * 输出：true
     * 解释：因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
     * 示例 5：
     *
     * 输入：s = "mississippi" p = "mis*is*p*."
     * 输出：false
     *  
     *
     * 提示：
     *
     * 0 <= s.length <= 20
     * 0 <= p.length <= 30
     * s 可能为空，且只包含从 a-z 的小写字母。
     * p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
     * 保证每次出现字符 * 时，前面都匹配到有效的字符
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/regular-expression-matching
     *
     * @param s 待校验字串
     * @param p 正则字串
     * @return 是否匹配
     */
    public native boolean isMatch(String s, String p);

    /**
     * 42. 接雨水
     * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
     *
     *  
     *
     * 示例 1：
     *
     *
     *
     * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
     * 输出：6
     * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
     * 示例 2：
     *
     * 输入：height = [4,2,0,3,2,5]
     * 输出：9
     *  
     *
     * 提示：
     *
     * n == height.length
     * 0 <= n <= 3 * 104
     * 0 <= height[i] <= 105
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/trapping-rain-water
     * @param height 高度集
     * @return 集雨量
     */
    public native int trap(int[] height);

    /**
     * 55. 跳跃游戏
     * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
     *
     * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
     *
     * 判断你是否能够到达最后一个下标。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：nums = [2,3,1,1,4]
     * 输出：true
     * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
     * 示例 2：
     *
     * 输入：nums = [3,2,1,0,4]
     * 输出：false
     * 解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
     *  
     *
     * 提示：
     *
     * 1 <= nums.length <= 3 * 104
     * 0 <= nums[i] <= 105
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/jump-game
     * @param nums 步数集
     * @return 是否可以跳到最后
     */
    public native boolean canJump(int[] nums);

    /**
     * 102. 二叉树的层序遍历
     * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
     *
     *  
     *
     * 示例：
     * 二叉树：[3,9,20,null,null,15,7],
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * 返回其层序遍历结果：
     *
     * [
     *   [3],
     *   [9,20],
     *   [15,7]
     * ]
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal
     * @param root 树根
     * @return 层级遍历
     */
    public native List<List<Integer>> levelOrder(TreeNode root);

    /**
     * 103. 二叉树的锯齿形层序遍历
     * 给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
     *
     * 例如：
     * 给定二叉树 [3,9,20,null,null,15,7],
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * 返回锯齿形层序遍历如下：
     *
     * [
     *   [3],
     *   [20,9],
     *   [15,7]
     * ]
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal
     * @param root 二叉树
     * @return 锯齿形层序
     */
    public native List<List<Integer>> zigzagLevelOrder(TreeNode root);

    /**
     * 121. 买卖股票的最佳时机
     * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
     *
     * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
     *
     * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：[7,1,5,3,6,4]
     * 输出：5
     * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
     *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
     * 示例 2：
     *
     * 输入：prices = [7,6,4,3,1]
     * 输出：0
     * 解释：在这种情况下, 没有交易完成, 所以最大利润为 0。
     *  
     *
     * 提示：
     *
     * 1 <= prices.length <= 105
     * 0 <= prices[i] <= 104
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
     * @param prices 价格表
     * @return 最大收益
     */
    public native int maxProfit1(int[] prices);

    /**
     * 122. 买卖股票的最佳时机 II
     * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
     *
     * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
     *
     * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
     *
     *  
     *
     * 示例 1:
     *
     * 输入: [7,1,5,3,6,4]
     * 输出: 7
     * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
     *      随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
     * 示例 2:
     *
     * 输入: [1,2,3,4,5]
     * 输出: 4
     * 解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
     *      注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
     *      因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
     * 示例 3:
     *
     * 输入: [7,6,4,3,1]
     * 输出: 0
     * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
     *  
     *
     * 提示：
     *
     * 1 <= prices.length <= 3 * 10 ^ 4
     * 0 <= prices[i] <= 10 ^ 4
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii
     * @param prices 价格表
     * @return 最大收益
     */
    public native int maxProfit2(int[] prices);

    /**
     * 123. 买卖股票的最佳时机 III
     * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
     *
     * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
     *
     * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
     *
     *  
     *
     * 示例 1:
     *
     * 输入：prices = [3,3,5,0,0,3,1,4]
     * 输出：6
     * 解释：在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
     *      随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。
     * 示例 2：
     *
     * 输入：prices = [1,2,3,4,5]
     * 输出：4
     * 解释：在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。  
     *      注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。  
     *      因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
     * 示例 3：
     *
     * 输入：prices = [7,6,4,3,1]
     * 输出：0
     * 解释：在这个情况下, 没有交易完成, 所以最大利润为 0。
     * 示例 4：
     *
     * 输入：prices = [1]
     * 输出：0
     *  
     *
     * 提示：
     *
     * 1 <= prices.length <= 105
     * 0 <= prices[i] <= 105
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii
     * @param prices 价格表
     * @return 最高收益
     */
    public native int maxProfit3(int[] prices);

    /**
     * 860. 柠檬水找零
     * 在柠檬水摊上，每一杯柠檬水的售价为 5 美元。
     *
     * 顾客排队购买你的产品，（按账单 bills 支付的顺序）一次购买一杯。
     *
     * 每位顾客只买一杯柠檬水，然后向你付 5 美元、10 美元或 20 美元。你必须给每个顾客正确找零，也就是说净交易是每位顾客向你支付 5 美元。
     *
     * 注意，一开始你手头没有任何零钱。
     *
     * 如果你能给每位顾客正确找零，返回 true ，否则返回 false 。
     *
     * 示例 1：
     *
     * 输入：[5,5,5,10,20]
     * 输出：true
     * 解释：
     * 前 3 位顾客那里，我们按顺序收取 3 张 5 美元的钞票。
     * 第 4 位顾客那里，我们收取一张 10 美元的钞票，并返还 5 美元。
     * 第 5 位顾客那里，我们找还一张 10 美元的钞票和一张 5 美元的钞票。
     * 由于所有客户都得到了正确的找零，所以我们输出 true。
     * 示例 2：
     *
     * 输入：[5,5,10]
     * 输出：true
     * 示例 3：
     *
     * 输入：[10,10]
     * 输出：false
     * 示例 4：
     *
     * 输入：[5,5,10,10,20]
     * 输出：false
     * 解释：
     * 前 2 位顾客那里，我们按顺序收取 2 张 5 美元的钞票。
     * 对于接下来的 2 位顾客，我们收取一张 10 美元的钞票，然后返还 5 美元。
     * 对于最后一位顾客，我们无法退回 15 美元，因为我们现在只有两张 10 美元的钞票。
     * 由于不是每位顾客都得到了正确的找零，所以答案是 false。
     *  
     *
     * 提示：
     *
     * 0 <= bills.length <= 10000
     * bills[i] 不是 5 就是 10 或是 20
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/lemonade-change
     * @param bills 货币集
     * @return 是否找零
     */
    public native boolean lemonadeChange(int[] bills);

    /**
     * 面试题 10.01. 合并排序的数组
     * 给定两个排序后的数组 A 和 B，其中 A 的末端有足够的缓冲空间容纳 B。 编写一个方法，将 B 合并入 A 并排序。
     *
     * 初始化 A 和 B 的元素数量分别为 m 和 n。
     *
     * 示例:
     *
     * 输入:
     * A = [1,2,3,0,0,0], m = 3
     * B = [2,5,6],       n = 3
     *
     * 输出: [1,2,2,3,5,6]
     * 说明:
     *
     * A.length == n + m
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/sorted-merge-lcci
     * @param A 大集合
     * @param m 大集合有效个数
     * @param B 小集合
     * @param n 小集合有效个数
     */
    public native void merge(int[] A, int m, int[] B, int n);

    /**
     * 剑指 Offer 14- I. 剪绳子
     * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
     *
     * 示例 1：
     *
     * 输入: 2
     * 输出: 1
     * 解释: 2 = 1 + 1, 1 × 1 = 1
     * 示例 2:
     *
     * 输入: 10
     * 输出: 36
     * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
     * 提示：
     *
     * 2 <= n <= 58
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/jian-sheng-zi-lcof
     * @param n 绳子长度
     * @return 最大乘积
     */
    public native int cuttingRope(int n);

    /**
     * 面试题 02.07. 链表相交
     * 给定两个（单向）链表，判定它们是否相交并返回交点。请注意相交的定义基于节点的引用，而不是基于节点的值。换句话说，如果一个链表的第k个节点与另一个链表的第j个节点是同一节点（引用完全相同），则这两个链表相交。
     *
     *
     * 示例 1：
     *
     * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
     * 输出：Reference of the node with value = 8
     * 输入解释：相交节点的值为 8 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
     *
     * 示例 2：
     *
     * 输入：intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
     * 输出：Reference of the node with value = 2
     * 输入解释：相交节点的值为 2 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，链表 B 为 [3,2,4]。在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
     *
     * 示例 3：
     *
     * 输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
     * 输出：null
     * 输入解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。由于这两个链表不相交，所以 intersectVal 必须为 0，而 skipA 和 skipB 可以是任意值。
     * 解释：这两个链表不相交，因此返回 null。
     *
     * 注意：
     *
     * 如果两个链表没有交点，返回 null 。
     * 在返回结果后，两个链表仍须保持原有的结构。
     * 可假定整个链表结构中没有循环。
     * 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/intersection-of-two-linked-lists-lcci
     * @param headA 链表1
     * @param headB 链表2
     * @return 相交节点
     */
    public native ListNode getIntersectionNode(ListNode headA, ListNode headB);

    /**
     * 冒泡排序
     * @param array 数组
     */
    public void bubbleSort(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    /**
     * 选择排序
     * @param array 数组
     */
    public void selectSort(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    /**
     * 快速排序
     * @param array 数组
     */
    public void quickSort(int[] array){
        if (array == null || array.length <= 1) {
            return;
        }
        sort(array, 0, array.length - 1);
    }

    private void sort(int[] array, int left, int right) {
        if (left > right) {
            return;
        }
        int base = array[left];
        int i = left;
        int j = right;
        while (i != j) {
            while (array[j] >= base && i < j) {
                j--;
            }
            while (array[i] <= base && i < j) {
                i++;
            }
            if (i < j) {
                int tem = array[i];
                array[i] = array[j];
                array[j] = tem;
            }
        }
        array[left] = array[i];
        array[i] = base;
        sort(array, left, i - 1);
        sort(array, i + 1, right);
    }
}
