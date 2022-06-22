
![telegram-cloud-photo-size-2-5301241940219641015-y](https://user-images.githubusercontent.com/37635860/175141582-ac039f5f-e2a3-4ffd-b808-f33e19e06aba.jpg)


**The solution:**

```math
ways[i][j] = ways[i-1][j] + ways[i][j-1]
```

```cpp
grid:(1 means dead)   ways:

0 0 1 0 0             1 1 0 0 0
0 0 0 0 0             1 2 2 2 2
0 1 0 0 1             1 0 2 4 0
1 0 0 0 0             0 0 2 6 6
0 0 0 0 0             0 0 2 8 14
```