#include <jni.h>
#include <string>
#include "wkp/Algorithm.h"
#include "android/log.h"

ListNode* transform_c_listNode(JNIEnv *env, jobject listNode);
jobject transform_java_listNode(JNIEnv *env, ListNode *listNode);
string transform_c_string(JNIEnv *env, jstring s);
vector<int> transform_c_int_array(JNIEnv *env, jintArray array);
jobject transform_java_int_list(JNIEnv *env, const vector<int>& array);
jobject transform_java_int_list_list(JNIEnv *env, const vector<vector<int>>& array);
TreeNode *transform_c_treeNode(JNIEnv *env, jobject treeNode);
jobject transform_java_treeNode(JNIEnv *env, TreeNode *treeNode);

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
    if (!listNode) {
        return nullptr;
    }
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

string transform_c_string(JNIEnv *env, jstring s){
    int length = env->GetStringLength(s);
    char cs[length + 1];
    cs[length] = '\0';
    const char *temp = env->GetStringUTFChars(s, JNI_FALSE);
    strncpy(cs, temp, length);
    env->ReleaseStringUTFChars(s, temp);
    return cs;
}

extern "C"
JNIEXPORT jint JNICALL
Java_com_wkp_algorithm_Algorithm_lengthOfLongestSubstring(JNIEnv *env, jobject thiz, jstring s) {
    const string &cs = transform_c_string(env, s);
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
    const string &cs = transform_c_string(env, s);
    const string &result = Algorithm::longestPalindrome(cs);
    return env->NewStringUTF(result.c_str());
}

extern "C"
JNIEXPORT jstring JNICALL
Java_com_wkp_algorithm_Algorithm_convert(JNIEnv *env, jobject thiz, jstring s, jint num_rows) {
    const string &cs = transform_c_string(env, s);
    const string &result = Algorithm::convert(cs, num_rows);
    return env->NewStringUTF(result.c_str());
}

extern "C"
JNIEXPORT jint JNICALL
Java_com_wkp_algorithm_Algorithm_reverse(JNIEnv *env, jobject thiz, jint x) {
    return Algorithm::reverse(x);
}

extern "C"
JNIEXPORT jint JNICALL
Java_com_wkp_algorithm_Algorithm_myAtoi(JNIEnv *env, jobject thiz, jstring s) {
    const string &cs = transform_c_string(env, s);
    return Algorithm::myAtoi(cs);
}

extern "C"
JNIEXPORT jboolean JNICALL
Java_com_wkp_algorithm_Algorithm_isPalindrome(JNIEnv *env, jobject thiz, jint x) {
    bool palindrome = Algorithm::isPalindrome(x);
    return palindrome ? JNI_TRUE : JNI_FALSE;
}

extern "C"
JNIEXPORT jboolean JNICALL
Java_com_wkp_algorithm_Algorithm_isMatch(JNIEnv *env, jobject thiz, jstring s, jstring p) {
    const string &cs = transform_c_string(env, s);
    const string &cp = transform_c_string(env, p);
    bool match = Algorithm::isMatch(cs, cp);
    return match ? JNI_TRUE : JNI_FALSE;
}

vector<int> transform_c_int_array(JNIEnv *env, jintArray array) {
    jsize length = env->GetArrayLength(array);
    vector<int> c_array(length);
    env->GetIntArrayRegion(array, 0, length, &c_array[0]);
    return c_array;
}

jobject transform_java_int_list(JNIEnv *env, const vector<int>& array){
    jclass listCls = env->FindClass("java/util/ArrayList");
    jmethodID addId = env->GetMethodID(listCls, "add", "(Ljava/lang/Object;)Z");
    jmethodID initId = env->GetMethodID(listCls, "<init>", "()V");
    jobject list = env->NewObject(listCls, initId);
    jclass intCls = env->FindClass("java/lang/Integer");
    jmethodID intId = env->GetMethodID(intCls, "<init>", "(I)V");
    for (int val : array) {
        jobject intObj = env->NewObject(intCls, intId, val);
        env->CallBooleanMethod(list, addId, intObj);
    }
    return list;
}

jobject transform_java_int_list_list(JNIEnv *env, const vector<vector<int>>& array){
    jclass listCls = env->FindClass("java/util/ArrayList");
    jmethodID addId = env->GetMethodID(listCls, "add", "(Ljava/lang/Object;)Z");
    jmethodID initId = env->GetMethodID(listCls, "<init>", "()V");
    jobject list = env->NewObject(listCls, initId);
    for (const vector<int>& vec : array) {
        jobject intList = transform_java_int_list(env, vec);
        env->CallBooleanMethod(list, addId, intList);
    }
    return list;
}

extern "C"
JNIEXPORT jint JNICALL
Java_com_wkp_algorithm_Algorithm_trap(JNIEnv *env, jobject thiz, jintArray height) {
    vector<int> c_height = transform_c_int_array(env, height);
    return Algorithm::trap(c_height);
}

extern "C"
JNIEXPORT jboolean JNICALL
Java_com_wkp_algorithm_Algorithm_canJump(JNIEnv *env, jobject thiz, jintArray nums) {
    vector<int> c_nums = transform_c_int_array(env, nums);
    bool jump = Algorithm::canJump(c_nums);
    return jump ? JNI_TRUE : JNI_FALSE;
}

TreeNode* transform_c_treeNode(JNIEnv *env, jobject treeNode) {
    jclass nodeClass = env->FindClass("com/wkp/algorithm/TreeNode");
    jfieldID valId = env->GetFieldID(nodeClass, "val", "I");
    jfieldID leftId = env->GetFieldID(nodeClass, "left", "Lcom/wkp/algorithm/TreeNode;");
    jfieldID rightId = env->GetFieldID(nodeClass, "right", "Lcom/wkp/algorithm/TreeNode;");
    jint val = env->GetIntField(treeNode, valId);
    auto *result = static_cast<TreeNode *>(malloc(sizeof(TreeNode)));
    result->val = val;
    result->left = NULL;
    result->right = NULL;
    jobject left = env->GetObjectField(treeNode, leftId);
    if (left) {
        result->left = transform_c_treeNode(env, left);
    }
    jobject right = env->GetObjectField(treeNode, rightId);
    if (right) {
        result->right = transform_c_treeNode(env, right);
    }
    return result;
}

jobject transform_java_treeNode(JNIEnv *env, TreeNode *treeNode) {
    if (!treeNode) {
        return nullptr;
    }
    jclass nodeClass = env->FindClass("com/wkp/algorithm/TreeNode");
    jfieldID valId = env->GetFieldID(nodeClass, "val", "I");
    jfieldID leftId = env->GetFieldID(nodeClass, "left", "Lcom/wkp/algorithm/TreeNode;");
    jfieldID rightId = env->GetFieldID(nodeClass, "right", "Lcom/wkp/algorithm/TreeNode;");
    jobject result = env->AllocObject(nodeClass);
    env->SetIntField(result, valId, treeNode->val);
    if (treeNode->left) {
        env->SetObjectField(result, leftId, transform_java_treeNode(env, treeNode->left));
    }
    if (treeNode->right) {
        env->SetObjectField(result, rightId, transform_java_treeNode(env, treeNode->right));
    }
}

extern "C"
JNIEXPORT jobject JNICALL
Java_com_wkp_algorithm_Algorithm_levelOrder(JNIEnv *env, jobject thiz, jobject root) {
    TreeNode *c_root = transform_c_treeNode(env, root);
    const vector<vector<int>> &order = Algorithm::levelOrder(c_root);
    return transform_java_int_list_list(env, order);
}

extern "C"
JNIEXPORT jobject JNICALL
Java_com_wkp_algorithm_Algorithm_zigzagLevelOrder(JNIEnv *env, jobject thiz, jobject root) {
    TreeNode *c_root = transform_c_treeNode(env, root);
    const vector<vector<int>> &order = Algorithm::zigzagLevelOrder(c_root);
    return transform_java_int_list_list(env, order);
}

extern "C"
JNIEXPORT jint JNICALL
Java_com_wkp_algorithm_Algorithm_maxProfit1(JNIEnv *env, jobject thiz, jintArray prices) {
    vector<int> c_prices = transform_c_int_array(env, prices);
    return Algorithm::maxProfit1(c_prices);
}

extern "C"
JNIEXPORT jint JNICALL
Java_com_wkp_algorithm_Algorithm_maxProfit2(JNIEnv *env, jobject thiz, jintArray prices) {
    vector<int> c_prices = transform_c_int_array(env, prices);
    return Algorithm::maxProfit2(c_prices);
}

extern "C"
JNIEXPORT jint JNICALL
Java_com_wkp_algorithm_Algorithm_maxProfit3(JNIEnv *env, jobject thiz, jintArray prices) {
    vector<int> c_prices = transform_c_int_array(env, prices);
    return Algorithm::maxProfit3(c_prices);
}

extern "C"
JNIEXPORT jboolean JNICALL
Java_com_wkp_algorithm_Algorithm_lemonadeChange(JNIEnv *env, jobject thiz, jintArray bills) {
    vector<int> c_bills = transform_c_int_array(env, bills);
    bool change = Algorithm::lemonadeChange(c_bills);
    return change ? JNI_TRUE : JNI_FALSE;
}

extern "C"
JNIEXPORT void JNICALL
Java_com_wkp_algorithm_Algorithm_merge(JNIEnv *env, jobject thiz, jintArray a, jint m, jintArray b,
                                       jint n) {
    vector<int> c_a = transform_c_int_array(env, a);
    vector<int> c_b = transform_c_int_array(env, b);
    Algorithm::merge(c_a, m, c_b, n);
    env->SetIntArrayRegion(a, 0, c_a.size(), &c_a[0]);
}

extern "C"
JNIEXPORT jint JNICALL
Java_com_wkp_algorithm_Algorithm_cuttingRope(JNIEnv *env, jobject thiz, jint n) {
    return Algorithm::cuttingRope(n);
}

extern "C"
JNIEXPORT jobject JNICALL
Java_com_wkp_algorithm_Algorithm_getIntersectionNode(JNIEnv *env, jobject thiz, jobject head_a,
                                                     jobject head_b) {
    ListNode *c_head_a = transform_c_listNode(env, head_a);
    ListNode *c_head_b = transform_c_listNode(env, head_b);
    ListNode *intersectionNode = Algorithm::getIntersectionNode(c_head_a, c_head_b);
    return transform_java_listNode(env, intersectionNode);
}
