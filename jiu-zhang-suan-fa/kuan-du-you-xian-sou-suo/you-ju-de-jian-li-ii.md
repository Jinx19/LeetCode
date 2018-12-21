```
描述
给出一个二维的网格，每一格可以代表墙 2 ，房子 1，以及空 0 (用数字0,1,2来表示)，在网格中找到一个位置去建立邮局，
使得所有的房子到邮局的距离和是最小的。
返回所有房子到邮局的最小距离和，如果没有地方建立邮局，则返回-1.
```

```py
class Solution:
    """
    @param grid: a 2D grid
    @return: An integer
    """
    def shortestDistance(self, grid):
        # write your code here
        if not grid:
            return 0
        m = len(grid)
        n = len(grid[0])

        dist = [[sys.maxsize for j in range(n)] for i in range(m)]
        reachable_count = [[0 for j in range(n)]for i in range(m)];
        min_dist = sys.maxsize

        buildings = 0

        for i in range(m):
            for j in range(n):
                if grid[i][j] == 1:
                    self.bfs(grid,i,j,dist,m,n,reachable_count)
                    buildings += 1
        for i in range(m):
            for j in range(n):
                if reachable_count[i][j] == buildings and dist[i][j] < min_dist:
                    min_dist = dist[i][j]
        return min_dist if min_dist != sys.maxsize else -1

    def bfs(self,grid,i,j,dist,m,n,reachable_count):
        visited = [[False for y in range(n)] for x in range(m)]

        visited[i][j] = True

        q = collections.deque([(i,j,0)])

        while q:
            i,j,l = q.popleft()
            if dist[i][j] == sys.maxsize:
                dist[i][j] = 0
            dist[i][j] += l

            for x,y in ((1,0),(-1,0),(0,1),(0,-1)):
                nx, ny = i + x, j + y

                if nx > -1 and nx < m and ny > -1 and ny < n and not visited[nx][ny]:
                    visited[nx][ny] = True
                    if grid[nx][ny] == 0:
                        q.append((nx,ny,l+1))
                        reachable_count[nx][ny] += 1
```



