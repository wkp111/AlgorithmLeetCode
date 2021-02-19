#include <jni.h>
#include <string>
#include "wkp/Algorithm.h"

ListNode* transform_c_listNode(JNIEnv *env, jobject listNode);
jobject transform_java_listNode(JNIEnv *env, ListNode *listNode);

extern "C"
JNIEXPORT jintArray JNICALL
Java_com_wkp_algorithm_Algorithm_twoSum(JNIEnv *env, jobject thiz, jintArray nums, jint target) {
    jsize length = env->GetArrayLength(nums);
    std::vector<int> vector(length);
    env->GetIntArrayRegion(nums, 0, length, &vector[0]);
    const std::vector<int> &result = Algorithm::twoNum(vector, target);
    jintArray res = env->NewIntArray(result.size());
    env->SetIntArrayRegion(res, 0, result.size(), &result[0]);
    return res;
}

ListNode* transform_c_listNode(JNIEnv *env, jobject listNode) {
    jclass nodeClass = env->FindClass("com/wkp/algorithm/ListNode");
    jfieldID valId = env->GetFieldID(nodeClass, "val", "I");
    jfieldID nextId = env->GetFieldID(nodeClass, "next", "Lcom/wkp/algorithm/ListNode;");
    jint val = env->GetIntField(listNode, valId);
    auto *result = static_cast<ListNode *>(malloc(sizeof(ListNode)));
    result->val = val;
    result->next = NULL;
    jobject next = env->GetObjectField(listNode, nextId);
    if (next) {
        result->next = transform_c_listNode(env, next);
    }
    return result;
}

jobject transform_java_listNode(JNIEnv *env, ListNode *listNode){
    jclass nodeClass = env->FindClass("com/wkp/algorithm/ListNode");
    jfieldID valId = env->GetFieldID(nodeClass, "val", "I");
    jfieldID nextId = env->GetFieldID(nodeClass, "next", "Lcom/wkp/algorithm/ListNode;");
    jobject result = env->AllocObject(nodeClass);
    env->SetIntField(result, valId, listNode->val);
    if (listNode->next) {
        env->SetObjectField(result, nextId, transform_java_listNode(env, listNode->next));
    }
    return result;
}

extern "C"
JNIEXPORT jobject JNICALL
Java_com_wkp_algorithm_Algorithm_addTwoNumbers(JNIEnv *env, jobject thiz, jobject l1, jobject l2) {
    ListNode *cl1 = transform_c_listNode(env, l1);
    ListNode *cl2 = transform_c_listNode(env, l2);
    ListNode *result = Algorithm::addTwoNumbers(cl1, cl2);
    return transform_java_listNode(env, result);
}

extern "C"
JNIEXPORT jint JNICALL
Java_com_wkp_algorithm_Algorithm_lengthOfLongestSubstring(JNIEnv *env, jobject thiz, jstring s) {
    int length = env->GetStringLength(s);
    char cs[length + 1];
    cs[length] = '\0';
    const char *temp = env->GetStringUTFChars(s, JNI_FALSE);
    strncpy(cs, temp, length);
    env->ReleaseStringUTFChars(s, temp);
    int result = Algorithm::lengthOfLongestSubstring(cs);
    return result;
}

extern "C"
JNIEXPORT jdouble JNICALL
Java_com_wkp_algorithm_Algorithm_findMedianSortedArrays(JNIEnv *env, jobject thiz, jintArray nums1,
                                                        jintArray nums2) {
    jsize len1 = env->GetArrayLength(nums1);
    jsize len2 = env->GetArrayLength(nums2);
    vector<int> c_nums1(len1);
    vector<int> c_nums2(len2);
    env->GetIntArrayRegion(nums1, 0, len1, &c_nums1[0]);
    env->GetIntArrayRegion(nums2, 0, len2, &c_nums2[0]);
    double result = Algorithm::findMedianSortedArrays(c_nums1, c_nums2);
    return result;
}

extern "C"
JNIEXPORT jstring JNICALL
Java_com_wkp_algorithm_Algorithm_longestPalindrome(JNIEnv *env, jobject thiz, jstring s) {
    int length = env->GetStringLength(s);
    char cs[length + 1];
    cs[length] = '\0';
    const char *temp = env->GetStringUTFChars(s, JNI_FALSE);
    strncpy(cs, temp, length);
    env->ReleaseStringUTFChars(s, temp);
    const string &result = Algorithm::longestPalindrome(cs);
    return env->NewStringUTF(result.c_str());
}