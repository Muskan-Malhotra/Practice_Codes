#User function Template for python3

from typing import List

class Solution:
     def findOrder(self, alien_dict: List[str], N: int, K: int) -> str:
        from collections import deque
        ord_a = ord("a")
        cton = lambda c: ord(c) - ord_a
        ntoc = lambda n: chr(n + ord_a)
        # Building adjacency list for topological sort
        adj = [[] for i in range(K)]
        indegree = [0] * K
        for i in range(N - 1):
            for c1, c2 in zip(alien_dict[i], alien_dict[i + 1]):
                if c1 != c2:
                    c1i, c2i = cton(c1), cton(c2)
                    adj[c1i].append(c2i)
                    indegree[c2i] += 1
                    break
        # Topological sort
        order = []
        q = deque([i for i in range(K) if indegree[i] == 0])
        while q:
            u = q.popleft()
            order.append(ntoc(u))
            for v in adj[u]:
                indegree[v] -= 1
                if indegree[v] == 0:
                    q.append(v)
        return order




#{ 
 # Driver Code Starts
#Initial Template for Python 3


class sort_by_order:

    def __init__(self, s):
        self.priority = {}
        for i in range(len(s)):
            self.priority[s[i]] = i

    def transform(self, word):
        new_word = ''
        for c in word:
            new_word += chr(ord('a') + self.priority[c])
        return new_word

    def sort_this_list(self, lst):
        lst.sort(key=self.transform)


if __name__ == '__main__':
    t = int(input())
    for _ in range(t):
        line = input().strip().split()
        n = int(line[0])
        k = int(line[1])

        alien_dict = [x for x in input().strip().split()]
        duplicate_dict = alien_dict.copy()
        ob = Solution()
        order = ob.findOrder(alien_dict, n, k)
        s = ""
        for i in range(k):
            s += chr(97 + i)
        l = list(order)
        l.sort()
        l = "".join(l)
        if s != l:
            print(0)
        else:
            x = sort_by_order(order)
            x.sort_this_list(duplicate_dict)

            if duplicate_dict == alien_dict:
                print(1)
            else:
                print(0)

# } Driver Code Ends