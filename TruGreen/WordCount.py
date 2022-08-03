#Keyword Analysis
#By: Kyle Luu

#STEP 1: Read the file
f = open("pyIn.csv","r")
words = f.read()
f.close()

#STEP 2: remove all punctuation except for "'", replacing with space
holdWords = {"<phone_number>":"54321PN12345", "<zip_code>":"54321ZIP12345", \
             "<customer_number>":"54321CN12345", "<address>":"54321ADDR12345", \
             "<email_address>":"54321EADDR12345"}
for word in holdWords.keys():
    words = words.replace(word,holdWords[word])
words = words.replace("tru ","Tru")
words = words.replace("Tru ","Tru")
words = words.replace('’',"'")
words = words.replace("&"," and ")
words = words.replace("+"," and ")
for p in "\n\t,\"“”!?<>();—=…":
    words = words.replace(p," ")
for word in holdWords.keys():
    words = words.replace(holdWords[word],word)

numbers = "01234567890"
for char in range(0,len(words)-1):
    if words[char] in './-:' and \
       words[char-1] not in numbers and words[char+1] not in numbers:
        words = words[:char] + " " + words[char+1:]

while "  " in words:
    words = words.replace("  "," ")
words = words.split(" ")

#STEP 3: uncapitalize all words, then capitalize first letter and
#        put in dictionary as key, count of that word is the value
wordCount = {}
acronyms = ["asap"]
truWords = {"trugreen":"TruGreen", "trugreen's":"TruGreen's", \
            "trucomplete":"TruComplete", "truhealth":"TruHealth", \
            "true":"'True", "false":"'False"}
for w in words:
    if len(w.strip()) > 0:
        word = w.lower().strip()
        if word in acronyms: word = word.upper()
        else: word = word[0].upper() + word[1:]
        if word[-1] == ".": word = word[:-1]
        if word.lower() in truWords.keys(): word = truWords[word.lower()]
        if word[0] in "$0123456789": word = "'" + word
        wordCount[word] = wordCount.get(word,0) + 1

#STEP 4: remove the most common english words
commonWords = ["A","After","All","Am","An","And","Are","As","At","Be",\
               "Because","Been","But","By","Can","Can't","Cannot","Do",\
               "Does","Don't","Did","Didn't","For","From","Get","Go","Going",\
               "Had","Has","Have","Hello","He","He's","Hi","His","I","I'd",\
               "If","I'll","I'm","In","Is","It","I've","Just","Last","Let",\
               "Like","More","Me","My","No","Not","Of","Off","On","Or","Our",\
               "Ours","Please","She","She's","Sure","So","Thank","Thanks",\
               "That","The","Them","Then","There","These","They","This",\
               "Thus","To","Too","Very","Was","We","Were","Will","With",\
               "Won't","Would","You","Your","You're"]
for word in commonWords:
    try: wordCount.pop(word)
    except: pass 
        
#STEP 5: sort into list by count (primary) and alphabetical order (secondary)
countList = list(wordCount)
for w in range(len(countList)):
    countList[w] = [countList[w],wordCount[countList[w]]]

validChars = ["~","@","'","<",">","&","#","$",":","/","-","0","1","2","3","4", \
              "5","6","7","8","9",".","A","a","B","b","C","c","D","d","E","e", \
              "F","f","G","g","H","h","I","i","J","j","K","k","L","l","M","m", \
              "N","n","O","o","P","p","Q","q","R","r","S","s","T","t","U","u", \
              "V","v","W","w","X","x","Y","y","Z","z","_"]
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

quickSort(countList)
countList.insert(0,["Word","Count"])

out = ""
for pair in countList:
    out += str(pair[0]) + "," + str(pair[1]) + "\n"

f = None
try: f = open("pyOut.csv","w")
except:
    f = open("pyOut.csv","x")
    f.close()
    f = open("pyOut.csv","w")

f.write(out)
f.close()
