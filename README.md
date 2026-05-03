# advanced-dsa-java-python

Educational implementations of core data structures, written from scratch in Java and Python — no `java.util.PriorityQueue`, no `heapq`, no shortcuts. The goal is to understand each structure by building it.

## What's inside

### Java (`Java/`)

| Path | Description |
|---|---|
| [`Heaps/Heaparray.java`](Java/Heaps/Heaparray.java) | Array-backed min-heap with `siftUp` / `siftDown` and `extractMin`. |
| [`LinkedLists/Custom_LinkedList.java`](Java/LinkedLists/Custom_LinkedList.java) | Singly linked list with insert/remove at both ends and in-place reverse. |
| [`Stacks/Custom_Stack.java`](Java/Stacks/Custom_Stack.java) | Linked-list-backed stack with a `decompose` helper that splits a stack into two by alternating elements. |
| [`Stacks/SpecialStack.java`](Java/Stacks/SpecialStack.java) | Min-stack: `getmin()` runs in O(1) using an auxiliary stack. |
| [`Queues/PriorityQueue_Via_Stacks.java`](Java/Queues/PriorityQueue_Via_Stacks.java) | Min-priority queue built on two `Stack<Integer>`s — extract-min is O(1), insert is O(n). |
| [`Trees/AVLTree.java`](Java/Trees/AVLTree.java) | Self-balancing BST with the four rotation cases (LL, LR, RR, RL) and cached node heights. |

### Python (`Python/`)

| Path | Description |
|---|---|
| [`Trees/Binary_Tree.py`](Python/Trees/Binary_Tree.py) | Binary search tree with `insert`, `deleteleaves`, `delete_smaller`, `printlevel`, `print_descending`, and `print_sideways`. |
| [`Trees/main.py`](Python/Trees/main.py) | Driver that exercises the BST. |
| [`Algorithms/utils.py`](Python/Algorithms/utils.py) | Small helpers (e.g. `find_max`). |

## Running

### Java

Each Java file has a `main` method, so you can run them directly:

```bash
cd Java/Trees
javac AVLTree.java
java AVLTree
```

The same pattern works for any of the other classes.

### Python

```bash
cd Python/Trees
python3 main.py
```

`main.py` adds `Python/` to `sys.path` at runtime so it can import `Algorithms.utils` regardless of where you launch it from.

## Repo layout

```
advanced-dsa-java-python/
├── Java/
│   ├── Heaps/
│   ├── LinkedLists/
│   ├── Queues/
│   ├── Stacks/
│   └── Trees/
└── Python/
    ├── Algorithms/
    └── Trees/
```
