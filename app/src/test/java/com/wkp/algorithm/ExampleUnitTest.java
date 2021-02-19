package com.wkp.algorithm;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void twoNum() {
        int[] nums = {2, 7, 11, 15};
        Algorithm algorithm = new Algorithm();
        int[] twoSum = algorithm.twoSum(nums, 9);
        System.out.println(twoSum[0]);
        System.out.println(twoSum[1]);
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
}