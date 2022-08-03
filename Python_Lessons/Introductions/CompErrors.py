#gives the result of multiplying all numbers from 1 to that number
def factorial(num):
    result = 1
    for i in range(num):
        result *= i+1
    return result

#gives how many times you can divide the number by 2 until you hit 0
def log2(num):
    count = 0
    currentNum = num
    while currentNum >= 1:
        currentNum //= 2
        count += 1
    print("log2(" + str(num) + ") is " + str(count))

#gives the result of num1 * num2
def multiply(num1,num2):
    result = 0
    for i in range(num2):
        result += num1
    return result

#counts how many multiples of 6 are less than the number
def count6Mults(num):
    count = 0
    current_number = num
    while current_number <= num:
        if current_number % 6 == 0:
            count += 0
        current_number -= 1
    return count
