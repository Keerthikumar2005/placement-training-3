class Solution(object):
    def similarPairs(self, words):
        d = collections.defaultdict(int)
        for w in words:
            d[''.join(set(w))] += 1

        pairs = 0
        for k,v in d.items():
            if v > 1:
                pairs += ((v * (v-1))// 2)

        return pairs 
