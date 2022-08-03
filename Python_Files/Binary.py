def binaryToBase10(num,total=0,place=1):
    #print(num,total,place)
    if num == 0: return total
    elif num == 1: return total + place
    else:
        if num%10 == 0: return binaryToBase10(num//10,total,place*2)
        else: return binaryToBase10(num//10,total+place,place*2)

def base10ToBinary(num):
    numS = ""
    largest2 = 1
    while (largest2 <= num): largest2 *= 2
    largest2 //= 2
    while largest2 > 0:
        numS += str(num//largest2)
        #print(num,largest2,numS)
        num %= largest2
        largest2 //= 2
    if numS == "": return num
    else: return eval(numS)
