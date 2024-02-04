# Overview

Visit [Daily Coding Problem](https://www.dailycodingproblem.com/)

Daily Coding Problem is a mailing list for coding interview problems that sends a coding problem everyday.
In this repository, I provide elegant solutions to these problems that are easy to understand and follow.

But before you start diving into the solutions, I'd recommend that you actually *do the problems*. This means writing the code and making it run. Getting stuck can be frustrating, but it's natural and the best way to learn.

# Problems

## Problem 1
This problem was recently asked by Google.

Given a list of numbers and a number k, return whether any two numbers from the list add up to k.

For example, given `[10, 15, 3, 7]` and `k` of `17`, return true since `10 + 7` is `17`.

Bonus: Can you do this in one pass?

[View Answer](./src/Problem1.java)

## Problem 2
This problem was asked by Uber.

Given an array of integers, return a new array such that each element at index `i` of the new array is the product of all the numbers in the original array except the one at `i`.

For example, if our input was `[1, 2, 3, 4, 5]`, the expected output would be `[120, 60, 40, 30, 24]`. If our input was `[3, 2, 1]`, the expected output would be `[2, 3, 6]`.

Follow-up: what if you can't use division?

[View Answer](./src/Problem2.java)

## Problem 3
This problem was asked by Google.

Given the root to a binary tree, implement `serialize(root)`, which serializes the tree into a string, and `deserialize(s)`, which deserializes the string back into the tree.

For example, given the following Node class

```
class Node:
    def __init__(self, val, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
```

The following test should pass:

```
node = Node('root', Node('left', Node('left.left')), Node('right'))
assert deserialize(serialize(node)).left.left.val == 'left.left'
```

[View Answer](./src/Problem3.java)

## Problem 4
This problem was asked by Stripe.

Given an array of integers, find the first missing positive integer in linear time and constant space. In other words, find the lowest positive integer that does not exist in the array. The array can contain duplicates and negative numbers as well.

For example, the input `[3, 4, -1, 1]` should give `2`. The input `[1, 2, 0]` should give `3`.

You can modify the input array in-place.

[View Answer](./src/Problem4.java)

## Problem 5
This problem was asked by Jane Street.

`cons(a, b)` constructs a pair, and `car(pair)` and `cdr(pair)` returns the first and last element of that pair. For example, `car(cons(3, 4))` returns `3`, and `cdr(cons(3, 4))` returns `4`.

Given this implementation of cons:

```
def cons(a, b):
    def pair(f):
        return f(a, b)
    return pair
```

Implement `car` and `cdr`.

[View Answer](./src/Problem5.java)

## Problem 7
This problem was asked by Facebook.

Given the mapping `a = 1, b = 2, ... z = 26`, and an encoded message, count the number of ways it can be decoded.

For example, the message `111` would give `3`, since it could be decoded as `aaa`, `ka`, and `ak`.

You can assume that the messages are decodable. For example, `001` is not allowed.

[View Answer](./src/Problem7.java)

## Problem 8
This problem was asked by Google.

A unival tree (which stands for "universal value") is a tree where all nodes under it have the same value.

Given the root to a binary tree, count the number of unival subtrees.

For example, the following tree has 5 unival subtrees:

```
   0
  / \
 1   0
    / \
   1   0
  / \
 1   1
```

[View Answer](./src/Problem8.java)

## Problem 9
This problem was recently asked by Google.
Given a list of numbers and a number k, return whether any two numbers from the list add up to k.
For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.
Bonus: Can you do this in one pass?

[View Answer](./src/Problem9.java)

## Problem 10
This problem was asked by Apple.

Implement a job scheduler which takes in a function `f` and an integer `n`, and calls `f` after `n` milliseconds.

[View Answer](./src/Problem10.java)

## Problem 11
This problem was asked by Twitter.

Implement an autocomplete system. That is, given a query string `s` and a set of all possible query strings, return all strings in the set that have `s` as a prefix.

For example, given the query string `de` and the set of strings `[dog, deer, deal]`, return `[deer, deal]`.

Hint: Try preprocessing the dictionary into a more efficient data structure to speed up queries.

[View Answer](./src/Problem11.java)

## Problem 12
This problem was asked by Amazon.

There exists a staircase with `N` steps, and you can climb up either `1` or `2` steps at a time. Given `N`, write a function that returns the number of unique ways you can climb the staircase. The order of the steps matters.

For example, if `N` is 4, then there are 5 unique ways:

```
    1, 1, 1, 1
    2, 1, 1
    1, 2, 1
    1, 1, 2
    2, 2
```

What if, instead of being able to climb `1` or `2` steps at a time, you could climb any number from a set of positive integers `X`? For example, if `X = {1, 3, 5}`, you could climb `1`, `3`, or `5` steps at a time.

[View Answer](./src/Problem12.java)

## Problem 13
This problem was asked by Amazon.

Given an integer `k` and a string `s`, find the length of the longest substring that contains at most `k` distinct characters.

For example, given `s = "abcba"` and `k = 2`, the longest substring with `k` distinct characters is `bcb`.

[View Answer](./src/Problem1.java)

## Problem 14
This problem was asked by Google.

The area of a circle is defined as `πr^2`. Estimate `π` to 3 decimal places using a Monte Carlo method.

Hint: The basic equation of a circle is `x2 + y2 = r2`.

[View Answer](./src/Problem13.java)

## Problem 15
This problem was asked by Facebook.

Given a stream of elements too large to store in memory, pick a random element from the stream with uniform probability.

[View Answer](./src/Problem15.java)

## Problem 16
This problem was asked by Twitter.

You run an e-commerce website and want to record the last `N` order ids in a log. Implement a data structure to accomplish this, with the following API:

    `record(order_id)`: adds the order_id to the log
    `get_last(i)`: gets the ith last element from the log. i is guaranteed to be smaller than or equal to N.

You should be as efficient with time and space as possible.

[View Answer](./src/Problem16.java)

## Problem 19
This problem was asked by Facebook.

A builder is looking to build a row of `N` houses that can be of `K` different colors. He has a goal of minimizing cost while ensuring that no two neighboring houses are of the same color.

Given an `N` by `K` matrix where the nth row and kth column represents the cost to build the nth house with kth color, return the minimum cost which achieves this goal.

[View Answer](./src/Problem19.java)

## Problem 20
This problem was asked by Google.

Given two singly linked lists that intersect at some point, find the intersecting node. The lists are non-cyclical.

For example, given `A = 3 -> 7 -> 8 -> 10` and `B = 99 -> 1 -> 8 -> 10`, return the node with value `8`.

In this example, assume nodes with the same value are the exact same node objects.

Do this in `O(M + N)` time (where `M` and `N` are the lengths of the lists) and constant space.

[View Answer](./src/Problem20.java)

## Problem 21
This problem was asked by Snapchat.

Given an array of time intervals (start, end) for classroom lectures (possibly overlapping), find the minimum number of rooms required.

For example, given `[(30, 75), (0, 50), (60, 150)]`, you should return `2`.

[View Answer](./src/Problem21.java)

## Problem 641
This problem was asked by Amazon.
Given a sorted array, find the smallest positive integer that is not the sum of a subset of the array.
For example, for the input `[1, 2, 3, 10]`, you should return `7`.
Do this in `O(N)` time.

[View Answer](./src/Problem641.java)

## Problem 662
This problem was asked by Amazon.
Given n numbers, find the greatest common denominator between them.
For example, given the numbers `[42, 56, 14]`, return `14`.

[View Answer](./src/Problem662.java)

## Problem 701
This problem was asked by Amazon.
At a popular bar, each customer has a set of favorite drinks, and will happily accept any drink among this set. For example, in the following situation, customer 0 will be satisfied with drinks 0, 1, 3, or 6.
```
preferences = {
    0: [0, 1, 3, 6],
    1: [1, 4, 7],
    2: [2, 4, 7, 5],
    3: [3, 2, 5],
    4: [5, 8]
}
```
A lazy bartender working at this bar is trying to reduce his effort by limiting the drink recipes he must memorize. Given a dictionary input such as the one above, return the fewest number of drinks he must learn in order to satisfy all customers.
For the input above, the answer would be `2`, as drinks `1` and `5` will satisfy everyone.

[View Answer](./src/Problem701.java)

## Problem 725
This problem was asked by Amazon.
Consider the following scenario: there are N mice and N holes placed at integer points along a line. Given this, find a method that maps mice to holes such that the largest number of steps any mouse takes is minimized.
Each move consists of moving one mouse one unit to the left or right, and only one mouse can fit inside each hole.
For example, suppose the mice are positioned at [1, 4, 9, 15], and the holes are located at [10, -5, 0, 16]. In this case, the best pairing would require us to send the mouse at 1 to the hole at -5, so our function should return 6.

[View Answer](./src/Problem725.java)

## Problem 738
This problem was asked by Amazon.
Given a string s and an integer k, break up the string into multiple lines such that each line has a length of k or less. You must break it up so that words don't break across lines. Each line has to have the maximum possible amount of words. If there's no way to break the text up, then return null.
You can assume that there are no spaces at the ends of the string and that there is exactly one space between each word.
For example, given the string "the quick brown fox jumps over the lazy dog" and k = 10, you should return: ["the quick", "brown fox", "jumps over", "the lazy", "dog"]. No string in the list has a length of more than 10.

[View Answer](./src/Problem738.java)

## Problem 746
This problem was asked by Amazon.
Implement a stack that has the following methods:
•	`push(val)`, which pushes an element onto the stack
•	`pop()`, which pops off and returns the topmost element of the stack. If there are no elements in the stack, then it should throw an error or return null.
•	`max()`, which returns the maximum value in the stack currently. If there are no elements in the stack, then it should throw an error or return null.
Each method should run in constant time.

[View Answer](./src/Problem746.java)

## Problem 867
This problem was asked by Google.

You are given an array of arrays of integers, where each array corresponds to a row in a triangle of numbers. For example, `[[1], [2, 3], [1, 5, 1]]` represents the triangle:
```
  1
 2 3
1 5 1
```
We define a path in the triangle to start at the top and go down one row at a time to an adjacent value, eventually ending with an entry on the bottom row. For example, `1 -> 3 -> 5`. The weight of the path is the sum of the entries.

Write a program that returns the weight of the maximum weight path.

[View Answer](./src/Problem867.java)

## Problem 1630
This problem was asked by Facebook.

Given a binary tree, return all paths from the root to leaves.

For example, given the tree:
```
   1
  / \
 2   3
    / \
   4   5
```

Return `[[1, 2], [1, 3, 4], [1, 3, 5]]`.

[View Answer](./src/Problem1630.java)

## Problem - Coin Change
Given a set of coins and a total money amount. Write a method to compute the smallest number of coins to make up the given amount. If the amount cannot be made up by any combination of the given coins, return -1.

For example:
Given `[2, 5, 10]` and `amount = 6`, the method should return `3`.
Given `[1, 2, 5]` and `amount = 7`, the method should return `2`.

[View Answer](./src/CoinChangeProblem.java)

## Problem - Distint Groups
This problem was asked by Amazon.

The given matrix represents a direct relation of users `0` to `n` with other users `0` to `n`. Each user `x` has direct relation to user `y` if `relations[x][y] == 1`. A group represents a set of users that are either directly or transitively related.
Therefore, relations `x -> y` and `y -> z` are part of the same group as `x` and `z` are related to each other through user `y`. Find the total number of distinct groups that exist in the given matrix.

[View Answer](./src/AmazonCodingProblemDistinctGroups.java)