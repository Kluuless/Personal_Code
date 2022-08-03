import WumpusWorldBreadthFirst as wwbf
import WumpusWorldDepthFirst as wwdf
import WumpusWorldBoard as wwb
import datetime as dt

bfvictories = 0
bfscores = []
bftimes = []
bftimeouts = 0
bfFinScores = []

dfvictories = 0
dfscores = []
dftimes = []
dftimeouts = 0
dfFinScores = []

for i in range(1000):
    if i % 100 == 0: print(i//10,"% done.",sep='')
    board1 = wwb.board_init()
    board2 = [["","","",""],["","","",""],["","","",""],["","","",""]]
    for r in range(len(board1)):
        for c in range(len(board1[r])):
            board2[r][c] = board1[r][c]

    now = dt.datetime.now()
    bfresults = wwbf.playCB(board1,printScore=False,printBoard=False,stop=False,printStart=False)
    bftimes.append((dt.datetime.now() - now).microseconds)
    
    now = dt.datetime.now()
    dfresults = wwdf.playCB(board2,False,False,False,False)
    dftimes.append((dt.datetime.now() - now).microseconds)

    if bfresults[0]: bfvictories += 1
    if dfresults[0]: dfvictories += 1

    bfscores.append(bfresults[1])
    dfscores.append(dfresults[1])

    if bfresults[1] < -1000: bftimeouts += 1
    else: bfFinScores.append(bfresults[1])
    if dfresults[1] < -1000: dftimeouts += 1
    else: dfFinScores.append(dfresults[1])
    
    wwbf.reset()
    wwdf.reset()

print("Breadth First Results:")
print(bfvictories,"victories.")
print("Average Score:",sum(bfscores)/len(bfscores))
print("Total Time:",sum(bftimes))
print("Number of timeouts:",bftimeouts)
print("Average Score of Finished Games:",sum(bfresults)/len(bfresults))
print()
print("Depth First Results:")
print(dfvictories,"victories")
print("Average Score:",sum(dfscores)/len(dfscores))
print("Total Time:",sum(dftimes))
print("Number of timeouts:",dftimeouts)
print("Average Score of Finished Games:",sum(dfresults)/len(dfresults))
