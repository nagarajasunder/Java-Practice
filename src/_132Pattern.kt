import java.util.*
import kotlin.math.min

    class _132Pattern
    {
        fun main(args : Array<String>)
        {
            val sol = Solution()
            print(sol.find132pattern(intArrayOf(3,1,4,2)))
        }
    }

    class Solution
    {
        fun find132pattern(nums: IntArray): Boolean {
            val len = nums.size
            if (len < 3) {
                return false
            }
            val stack = Stack<Pair<Int, Int>>()
            var currentMin:Int = nums[0]
            for (i in 1 until len) {
                while (stack.isNotEmpty() && nums[i] >= stack.peek().first) {
                    stack.pop()
                }
                if (stack.isNotEmpty() && nums[i] > stack.peek().second) {
                    return true
                }
                stack.push(Pair(nums[i], currentMin))
                currentMin = min(currentMin, nums[i])
            }

            return false
        }
    }
