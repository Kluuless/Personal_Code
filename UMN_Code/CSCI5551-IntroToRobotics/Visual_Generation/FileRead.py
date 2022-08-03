import json

def readFile(filename):
    file = open(filename,"r")
    o = json.load(file)
    file.close()
    return o
