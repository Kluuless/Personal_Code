frequency = {'a': 1,
             'b': 1,
             'c': 2,
             'd': 3,
             'e': 5,
             'f': 8,
             'g': 13,
             'h': 21}

string = "abccdddeeeeeffffffffggggggggggggghhhhhhhhhhhhhhhhhhhhh"

def huff(code):
    string = "abccdddeeeeeffffffffggggggggggggghhhhhhhhhhhhhhhhhhhhh"
    result = ""
    for ch in string:
        result += code[ch]
    return len(result)

def isValid(code):
    keys = list(code.keys())
    for ch1 in range(len(keys)):
        for ch2 in range(ch1,len(keys)):
            if ch1 != ch2:
                if code[keys[ch1]] == code[keys[ch2]][0:len(code[keys[ch1]])]:
                    return False
    return True

codes = []

codes.append({'a': '111',
              'b': '110',
              'c': '101',
              'd': '100',
              'e': '011',
              'f': '010',
              'g': '001',
              'h': '000'})
codes.append({'a': '11101',
              'b': '11100',
              'c': '1101',
              'd': '1100',
              'e': '101',
              'f': '100',
              'g': '01',
              'h': '00'})
codes.append({'a': '11111110',
              'b': '1111110',
              'c': '111110',
              'd': '11110',
              'e': '1110',
              'f': '110',
              'g': '10',
              'h': '0'})
codes.append({'a': '111100',
              'b': '11101',
              'c': '11100',
              'd': '1101',
              'e': '1100',
              'f': '101',
              'g': '100',
              'h': '0'})
codes.append({'a': '1111111',
              'b': '1111110',
              'c': '111110',
              'd': '11110',
              'e': '1110',
              'f': '110',
              'g': '10',
              'h': '0'})

for code in range(len(codes)):
    if (isValid(codes[code])):
        print("code"+str(code+1)+": "+str(huff(codes[code]))+",",100*huff(codes[code])/huff(codes[0]),end="%\n")
    else:
        print("code",code+1,"is invalid.")
