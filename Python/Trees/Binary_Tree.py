class Binary_Tree:


    def __init__(self, val = 0, left = None, right = None):
        self.val = val
        self.left = left
        self.right = right


    def insert(self, val):
        if val < self.val:
            if self.left is None:
                self.left = Binary_Tree(val)
            else:
                self.left.insert(val)
        else:
            if self.right is None:
                self.right = Binary_Tree(val)
            else:
                self.right.insert(val)


    def deleteleaves(self):
        if self.left is None and self.right is None:
            return None
        if self.left:
            self.left = self.left.deleteleaves()
        if self.right:
            self.right = self.right.deleteleaves()
        return self


    def printlevel(self, target_level, level = 0):
        if target_level == level:
            print(self.val, " ")
        else:
            if self.left:
                self.left.printlevel(target_level, level + 1)
            if self.right:
                self.right.printlevel(target_level, level + 1)


    def print_descending(self):
        if self.right:
            self.right.print_descending()
        print(self.val, " ")
        if self.left:
            self.left.print_descending()


    def delete_smaller(self, key):
        if self.val < key:
            if self.right:
                return self.right.delete_smaller(key)
            else:
                return None
        else:
            if self.left:
                self.left = self.left.delete_smaller(key)
            return self


    def print_sideways(self, level=0):
        if self.right:
            self.right.print_sideways(level + 1)
        print(' ' * 6 * level + '-> ' + str(self.val))
        if self.left:
            self.left.print_sideways(level + 1)
