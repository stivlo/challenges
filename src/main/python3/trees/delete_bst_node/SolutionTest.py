

def main():
    root = TreeNode(5)
    root.left = TreeNode(3)
    root.left.left = TreeNode(2)
    root.left.right = TreeNode(4)
    root.right = TreeNode(6)
    root.right.right = TreeNode(7)
    s = Solution()
    s.deleteNode(root, 3)


if __name__ == "__main__":
    from TreeNode import TreeNode
    from Solution import Solution
    main()

