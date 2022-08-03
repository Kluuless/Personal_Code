import os
def replace():
    files = os.listdir()
    for file in files:
        if file[-5:] == ".json":
            ofile = open(file,"r")
            text = ofile.read()
            ofile.close()
            ofile = open(file,"w")
            text = text.replace("oak",file[:-5])
            text = text.replace("_planks","")
            ofile.write(text)
            ofile.close()
replace()
