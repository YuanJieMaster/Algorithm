/**
有序数组的平方
给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
示例 1：
输入：nums = [-4,-1,0,3,10]
输出：[0,1,9,16,100]
解释：平方后，数组变为 [16,1,0,9,100]
排序后，数组变为 [0,1,9,16,100]
示例 2：
输入：nums = [-7,-3,2,3,11]
输出：[4,9,9,49,121]
提示：
1 <= nums.length <= 104
-104 <= nums[i] <= 104
nums 已按 非递减顺序 排序
进阶：
请你设计时间复杂度为 O(n) 的算法解决本问题
尝试了暴力解法之后再尝试一下 O(n) 的算法
显然我们是需要利用数组中局部的有序性，而原地换的话不太好换
这里开辟了一个新的切片用于存储结果，算是一种空间换时间的策略
*/

package main

import "fmt"

func main() {
	nums := []int{-4, -1, 0, 3, 10}
	fmt.Println(sortedSquares(nums))
}

func sortedSquares(nums []int) []int {
	length := len(nums)
	negative := -1
	for i := 0; i < length && nums[i] < 0; i++ {
		negative = i
	}
	res := make([]int, 0, length)
	left := negative
	right := negative + 1
	for left >= 0 || right < length {
		if left == -1 || right < length && -nums[left] > nums[right] {
			res = append(res, nums[right]*nums[right])
			right++
		} else if right == length || -nums[left] <= nums[right] {
			res = append(res, nums[left]*nums[left])
			left--
		}
	}
	return res
}
