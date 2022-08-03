sample1 = [0,1,2,3,4,5,6,7,8,9]
sample2 = [5,2,9,2,8,1,7,6,4,5]
sample3 = [9,8,7,6,5,4,3,2,1,0]
sample4 = []
sample5 = [2,4,6,8]

def linearSearch(lst, num):
    for i in range(len(lst)):
        if lst[i] == num:
            return i
    return "NIL"

def binarySearch(lst, num):
    if len(lst) == 1:
        if (lst[0] == num): return 0
        else: return "NIL"
    elif len(lst) == 0:
        return "NIL"
    elif lst[len(lst)//2] == num: return len(lst)//2
    elif lst[len(lst)//2] < num:
        if len(lst)//2 == 0: return "NIL"
        else:
            i = binarySearch(lst[len(lst)//2:],num)
            if i == "NIL": return i
            else: return i + (len(lst)//2)
    else:
        if len(lst)//2 == 0: return "NIL"
        else:
            return  binarySearch(lst[:len(lst)//2],num)
            
