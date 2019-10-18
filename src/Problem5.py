"""
This problem was asked by Jane Street.

cons(a, b) constructs a pair, and car(pair) and cdr(pair) returns the first and last element of that pair. For example, car(cons(3, 4)) returns 3, and cdr(cons(3, 4)) returns 4.

Given this implementation of cons:

def cons(a, b):
    def pair(f):
        return f(a, b)
    return pair
Implement car and cdr.
"""

# Given implementation
def cons(a, b):
    def pair(f):
        return f(a, b)
    return pair

def car(pair_func):
    def get_first_value(a, b):
        return a
    return pair_func(get_first_value)

def cdr(pair_func):
    def get_second_value(a, b):
        return b
    return pair_func(get_second_value)


def main():
    a = car(cons(3, 4))
    b = cdr(cons(3, 4))
    print (a, ',', b)

main()