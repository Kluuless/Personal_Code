import os
for a in ["log","stripped_log","stripped_wood","wood","hyphae","stripped_hyphae","stem","stripped_stem"]:
    for b in ["beehive","chest","chest_minecart","composter","hopper","ladder","stick"]:
        if os.path.exists(a+"/"+b+".json"):
            os.remove(a+"/"+b+".json")
