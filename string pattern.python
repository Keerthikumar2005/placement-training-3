
def kmp(p):
    l=[0]*len(p)
    j=0
    for i in range(1,len(p)):
        while j>0 and p[i]!=p[j]:
            j=l[j-1]
        if p[i]==p[j]: j+=1
        l[i]=j
    return l

def search(t,p):
    l=kmp(p)
    j=0
    for i in range(len(t)):
        while j>0 and t[i]!=p[j]:
            j=l[j-1]
        if t[i]==p[j]: j+=1
        if j==len(p):
            print(i-j+1)
            j=l[j-1]

search("ababcabcabababd","ababd")
