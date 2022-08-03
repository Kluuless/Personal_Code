def mul5(m, n):
    multi5 = 0
    for number in range(m, n):
        if number % 5 == 0:
            multi5 += 1
    return multi5
