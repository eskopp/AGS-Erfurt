print("TEST")
a = input()
dummy = a[0]
l = [len(a)]
y = l[0] - 1
a[0] = a[y]
a[y] = dummy
print(a)

