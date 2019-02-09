
class TreeNode:

    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

    def __str__(self):
        return str(self.val) + ' left: ' + self.left + ' right: ' + self.right
