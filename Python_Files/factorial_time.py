from datetime import datetime


#Factorial, computed iteratively
def f_i(n):
    if n < 0: return -1
    product = 1
    for i in range(1,n+1): product *= i
    return product

#Factorial, computed recursively (inefficiently)
def f_r1(n):
    if n < 0: return -1
    elif n == 0: return 1
    else: return n * f_r1(n-1)

#Factorial, computed recursively (efficiently)
def f_r2_helper(c,n,p):
    if n == c: return p
    else: return f_r2_helper(c+1,n,c*p)

def f_r2(n):
    if n < 0: return -1
    else: return f_r2_helper(0,n,1)

#shows the computation time for each function
def run(start=-100,end=100,p=True,r=False):
    f_i_start = datetime.now()
    for i in range(start,end): f_i(i)
    f_i_change = datetime.now()-f_i_start

    f_r1_start = datetime.now()
    for i in range(start,end): f_r1(i)
    f_r1_change = datetime.now()-f_r1_start

    f_r2_start = datetime.now()
    for i in range(start,end): f_r2(i)
    f_r2_change = datetime.now()-f_r2_start

    if p:
        print("f_i took " + str(f_i_change)[5:15] + " seconds.")
        print("f_r1 took " + str(f_r1_change)[5:15] + " seconds.")
        print("f_r2 took " + str(f_r2_change)[5:15] + " seconds.")

    if r:
        return (float(str(f_i_change)[5:15]),\
                float(str(f_r1_change)[5:15]),\
                float(str(f_r2_change)[5:15]))

def run_more(n=100,start=-100,end=100):
    times = []
    for i in range(n):
        times.append(run(start,end,False,True))
        if (((i/n)) * 100) % 10 == 0:
            print(str(int((i/n) * 100)) + "% done.")
    print("100% done.")
    aves = [0,0,0]
    for i in range(n):
        aves[0] += times[i][0]
        aves[1] += times[i][1]
        aves[2] += times[i][2]
    aves[0] /= n
    aves[1] /= n
    aves[2] /= n
    print("f_i on average took " + str(aves[0])[:7] + " seconds.")
    print("f_r1 on average took " + str(aves[1])[:7] + " seconds.")
    print("f_r2 on average took " + str(aves[2])[:7] + " seconds.")
