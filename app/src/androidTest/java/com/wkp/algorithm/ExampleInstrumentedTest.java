package com.wkp.algorithm;

import android.content.Context;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.wkp.algorithm", appContext.getPackageName());
    }

    @Test
    public void twoNum() {
        int[] nums = {2, 7, 11, 15};
        Algorithm algorithm = new Algorithm();
        int[] twoSum = algorithm.twoSum(nums, 26);
        System.out.println("wkp " + twoSum[0]);
        System.out.println("wkp " + twoSum[1]);
    }

    @Test
    public void addTwoNumbers() {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        Algorithm algorithm = new Algorithm();
        ListNode listNode = algorithm.addTwoNumbers(l1, l2);
        ListNode print = listNode;
        while (print != null) {
            System.out.println(print.val);
            print = print.next;
        }
    }

    @Test
    public void lengthOfLongestSubstring() {
        Algorithm algorithm = new Algorithm();
        int result = algorithm.lengthOfLongestSubstring("pwwkew");
        System.out.println("wkpzs result: " + result);
    }

    @Test
    public void findMedianSortedArrays() {
        int[] nums1 = {2};
        int[] nums2 = {};
        Algorithm algorithm = new Algorithm();
        double median = algorithm.findMedianSortedArrays(nums1, nums2);
        System.out.println("wkpzs median: " + median);
    }

    @Test
    public void longestPalindrome() {
        Algorithm algorithm = new Algorithm();
        String result = algorithm.longestPalindrome("cbbd");
        System.out.println("wkpzs result: " + result);
    }

    @Test
    public void convert() {
        Algorithm algorithm = new Algorithm();
        String convert = algorithm.convert("PAYPALISHIRING", 4);
        System.out.println("wkpzs convert: " + convert);
    }

    @Test
    public void reverse() {
        Algorithm algorithm = new Algorithm();
        int reverse = algorithm.reverse(123);
        System.out.println("wkpzs reverse: " + reverse);
    }

    @Test
    public void myAtoi() {
        Algorithm algorithm = new Algorithm();
        int atoi = algorithm.myAtoi("-91283472332");
        System.out.println("wkpzs atoi: " + atoi);
    }

    @Test
    public void isPalindrome() {
        Algorithm algorithm = new Algorithm();
        boolean palindrome = algorithm.isPalindrome(121);
        System.out.println("wkpzs palindrome: " + palindrome);
    }

    @Test
    public void isMatch() {
        Algorithm algorithm = new Algorithm();
        boolean match = algorithm.isMatch("aab", "c*a*b");
        System.out.println("wkpzs match: " + match);
    }

    @Test
    public void trap() {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        Algorithm algorithm = new Algorithm();
        int trap = algorithm.trap(height);
        System.out.println("wkpzs trap: " + trap);
    }

    @Test
    public void canJump() {
        int[] nums = {2, 3, 1, 1, 4};
        Algorithm algorithm = new Algorithm();
        boolean canJump = algorithm.canJump(nums);
        System.out.println("wkpzs canJump: " + canJump);
    }

    @Test
    public void maxProfit1() {
        int[] prices = {7, 1, 5, 3, 6, 4};
        Algorithm algorithm = new Algorithm();
        int maxProfit1 = algorithm.maxProfit1(prices);
        System.out.println("wkpzs maxProfit1: " + maxProfit1);
    }

    @Test
    public void maxProfit2() {
        int[] prices = {7, 1, 5, 3, 6, 4};
        Algorithm algorithm = new Algorithm();
        int maxProfit2 = algorithm.maxProfit2(prices);
        System.out.println("wkpzs maxProfit2: " + maxProfit2);
    }

    @Test
    public void maxProfit3() {
        int[] prices = {3,3,5,0,0,3,1,4};
        Algorithm algorithm = new Algorithm();
        int maxProfit3 = algorithm.maxProfit3(prices);
        System.out.println("wkpzs maxProfit3: " + maxProfit3);
    }

    @Test
    public void lemonadeChange() {
        int[] bills = {5, 5, 5, 10, 20};
        Algorithm algorithm = new Algorithm();
        boolean change = algorithm.lemonadeChange(bills);
        System.out.println("wkpzs change: " + change);
    }

    @Test
    public void merge() {
        int[] A = {1, 2, 3, 0, 0, 0};
        int[] B = {2, 5, 6};
        Algorithm algorithm = new Algorithm();
        algorithm.merge(A, 3, B, 3);
        System.out.println("wkpzs A toString: " + Arrays.toString(A));
    }

    @Test
    public void cuttingRope() {
        Algorithm algorithm = new Algorithm();
        int rope = algorithm.cuttingRope(10);
        System.out.println("wkpzs rope: " + rope);
    }

    private ListNode createListNode(int... list) {
        if (list == null || list.length == 0) {
            return null;
        }
        ListNode head = new ListNode(list[0]);
        ListNode p = head;
        for (int i = 1; i < list.length; i++) {
            p.next = new ListNode(list[i]);
            p = p.next;
        }
        return head;
    }

    private void printListNode(ListNode listNode) {
        if (listNode == null) {
            System.out.println("wkpzs listNode is null");
            return;
        }
        ListNode p = listNode;
        System.out.print("wkpzs listNode is ");
        while (p != null) {
            System.out.print(p.val + ", ");
            p = p.next;
        }
        System.out.println();
    }

    @Test
    public void getIntersectionNode() {
        ListNode headA = createListNode(4, 1, 8, 4, 5);
        ListNode headB = createListNode(5, 0, 1, 8, 4, 5);
        printListNode(headA);
        printListNode(headB);
        Algorithm algorithm = new Algorithm();
        ListNode intersectionNode = algorithm.getIntersectionNode(headA, headB);
        printListNode(intersectionNode);
    }

    private TreeNode createTreeNode(Integer... list) {
        if (list == null || list.length == 0) {
            return null;
        }
        List<TreeNode> listNode = new ArrayList<>();
        for (Integer integer : list) {
            if (integer == null) {
                listNode.add(null);
            } else {
                listNode.add(new TreeNode(integer));
            }
        }
        int size = listNode.size();
        for (int i = 0; i < size / 2 - 1; i++) {
            TreeNode p = listNode.get(i);
            TreeNode left = listNode.get(2 * i + 1);
            TreeNode right = listNode.get(2 * i + 2);
            if (p != null) {
                p.left = left;
                p.right = right;
            } else {
                listNode.add(2 * i, null);
                listNode.add(2 * i, null);
                size += 2;
            }
        }
        int lastIndex = size / 2 - 1;
        TreeNode lastNode = listNode.get(lastIndex);
        if (lastNode != null) {
            lastNode.left = listNode.get(lastIndex * 2 + 1);
            if (size % 2 == 1) {
                lastNode.right = listNode.get(lastIndex * 2 + 2);
            }
        }
        return listNode.get(0);
    }

    @Test
    public void levelOrder() {
        TreeNode root = createTreeNode(3, 9, 20, null, null, 15, 7, 10, 12, 11, 13, 14, 16);
        Algorithm algorithm = new Algorithm();
        List<List<Integer>> order = algorithm.levelOrder(root);
        for (List<Integer> integers : order) {
            Object[] objects = integers.toArray();
            System.out.println("wkpzs objects: " + Arrays.toString(objects));
        }
    }

    @Test
    public void zigzagLevelOrder() {
        TreeNode root = createTreeNode(3, 9, 20, null, null, 15, 7, 10, 12, 11, 13, 14, 16);
        Algorithm algorithm = new Algorithm();
        List<List<Integer>> order = algorithm.zigzagLevelOrder(root);
        for (List<Integer> integers : order) {
            Object[] objects = integers.toArray();
            System.out.println("wkpzs objects: " + Arrays.toString(objects));
        }
    }

    @Test
    public void sort() {
        int[] array = {1, 5, 3, 9, 20, 6, 5, 33, 8, 10, 88, 2, 7, 0};
        Algorithm algorithm = new Algorithm();
        algorithm.quickSort(array);
        System.out.println("wkpzs array: " + Arrays.toString(array));
    }
}