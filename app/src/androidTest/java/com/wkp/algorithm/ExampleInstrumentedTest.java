package com.wkp.algorithm;

import android.content.Context;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import org.junit.Test;
import org.junit.runner.RunWith;
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
}