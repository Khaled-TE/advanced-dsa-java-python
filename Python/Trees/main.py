import sys
from pathlib import Path
sys.path.insert(0, str(Path(__file__).parent.parent))

import Binary_Tree
from Algorithms import utils
import random


path = Path(__file__).parent
for file in path.glob('*.py'):
    print(file)



numbers = [7, 3, 14, 22, 17, -15]
print(utils.find_max(numbers))

tree = Binary_Tree.Binary_Tree(150)
tree.insert(95)
tree.insert(175)
tree.insert(111)
tree.insert(92)
tree.insert(166)
tree.insert(200)


tree.print_sideways()
print("__________________")
tree.print_descending()
print("__________________")
tree.printlevel(2)
print("__________________")
tree = tree.delete_smaller(175)
tree.print_sideways()
print("__________________")
tree = tree.deleteleaves()
tree.print_sideways()
