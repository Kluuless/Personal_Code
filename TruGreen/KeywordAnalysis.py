#Keyword Analysis
#By: Kyle Luu

f = open("pyIn.csv","r")
words = f.read()
f.close()

counts = []
words = words.replace("\n",",").replace('"',"").replace("\t","")
while ",," in words:
    words = words.replace(",,",",")
words = words.split(",")

wordsDict = {}
for w in words:
    if len(w.strip()) > 0:
        word = w.lower()
        if word[:2] == "i ": word = "I" + word[1:]
        if word[::-1][:2] == "i ": word = word[:-1] + "I"
        for iContr in [" I ","I'm","I've","I'd","I'mma","I'll"]:
            word = word.replace(iContr.lower(),iContr)
        wordsDict[word.strip()] = wordsDict.get(word.strip(),0) + 1

for w in wordsDict.keys():
    counts.append([w,wordsDict[w]])

validChars = [" ","~","@","<",">","&","#","$",":","/","-","0","1","2","3","4", \
              "5","6","7","8","9",".","A","a","B","b","C","c","D","d","E","e", \
              "F","f","G","g","H","h","I","i","J","j","K","k","L","l","M","m", \
              "N","n","O","o","P","p","Q","q","R","r","S","s","T","t","U","u", \
              "V","v","W","w","X","x","Y","y","Z","z",'"','“',"”","'","’","/", \
              "_"]
def compare(wc1,wc2): #compares two word-count pairs
    if wc1[1] != wc2[1]:
        return wc2[1] - wc1[1]
    else:
        shortest = len(wc1[0]) if len(wc1[0]) < len(wc2[0]) else len(wc2[0])
        for i in range(shortest):
            if wc1[0][i] != wc2[0][i]:
                return validChars.index(wc1[0][i]) - validChars.index(wc2[0][i])
        return len(wc1[0]) - len(wc2[0])

def partition(l,start=0,end=-1): #partitions the array according to quicksort
    if end == -1: end = len(l)-1
    pivot = l[end]
    i = start-1
    for j in range(start,end):
        if compare(l[j],pivot) < 0:
            i += 1
            temp = l[j]
            l[j] = l[i]
            l[i] = temp
    temp = l[end]
    l[end] = l[i+1]
    l[i+1] = temp
    return i+1

def quickSort(l,start=0,end=-1): #sorts the list... O(n*log(n))
    if end == -1: end = len(l)-1
    if start < end:
        pivot = partition(l,start,end)
        quickSort(l,start,pivot-1)
        quickSort(l,pivot+1,end)

quickSort(counts)
counts.insert(0,["Word","Count"])

out = ""
for pair in counts:
    out += str(pair[0]) + "," + str(pair[1]) + "\n"

f = None
try: f = open("pyOut.csv","w")
except:
    f = open("pyOut.csv","x")
    f.close()
    f = open("pyOut.csv","w")

f.write(out)
f.close()
