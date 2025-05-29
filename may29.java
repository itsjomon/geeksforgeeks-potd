/*
class Node {
    int data;
    Node left, right;

    public Node(int data){
        this.data = data;
    }
}
*/
class Solution {
    class Result {
        int maxSum = 0;
        int maxLen = 0;
    }

    public int sumOfLongRootToLeafPath(Node root) {
        Result result = new Result();
        dfs(root, 0, 0, result);
        return result.maxSum;
    }

    private void dfs(Node node, int currLen, int currSum, Result result) {
        if (node == null) {
            return;
        }

        currLen += 1;
        currSum += node.data;

        if (node.left == null && node.right == null) {
            if (currLen > result.maxLen) {
                result.maxLen = currLen;
                result.maxSum = currSum;
            } else if (currLen == result.maxLen) {
                result.maxSum = Math.max(result.maxSum, currSum);
            }
            return;
        }

        dfs(node.left, currLen, currSum, result);
        dfs(node.right, currLen, currSum, result);
    }
}
