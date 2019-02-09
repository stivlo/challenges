from TreeNode import TreeNode

# does not pass all tests
# https://leetcode.com/problems/delete-node-in-a-bst/submissions/
class Solution:

    def deleteNode(self, root: 'TreeNode', key: 'int') -> 'TreeNode':
        parent, toRemove = self.findNode(root, key)
        if toRemove is None:
            return root
        elif toRemove.left is None and toRemove.right is None:
            newChild = None
        elif toRemove.left is None:
            newChild = toRemove.right
        elif toRemove.right is None:
            newChild = toRemove.left
        else:
            minNode, minParent = self.findMinNode(toRemove.right)
            minParent.left = minNode.right
            newChild = minNode
            newChild.left = toRemove.left
            if minNode != toRemove.right:
                newChild.right = toRemove.right
        return self.appendNewChild(root, parent, toRemove, newChild)

    def findNode(self, root: 'TreeNode', key: 'int') -> ('TreeNode', 'TreeNode'):
        curNode = root
        parent = root
        while curNode is not None and curNode.val != key:
            parent = curNode
            if curNode.val > key:
                curNode = curNode.left
            else:
                curNode = curNode.right
        return parent, curNode

    def findMinNode(self, node: 'TreeNode') -> ('TreeNode', 'TreeNode'):
        parent = node
        minNode = node
        while minNode is not None and minNode.left is not None:
            parent = minNode
            minNode = minNode.left
        return parent, minNode

    def appendNewChild(self, root: 'TreeNode', parent: 'TreeNode', toRemove: 'TreeNode', newChild: 'TreeNode') -> 'TreeNode':
        if parent == toRemove:
            return newChild
        elif parent.left == toRemove:
            parent.left = newChild
        else:
            parent.right = newChild
        return root


