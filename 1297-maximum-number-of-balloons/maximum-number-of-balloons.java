class Solution {
    public int maxNumberOfBalloons(String text) {
        HashMap<Character, Integer> map = new HashMap<>();
        char[] ch = text.toCharArray();
        for (char c : ch) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        String target = "balloon";
        char[] tar = target.toCharArray();
        int count = -1;
        boolean valid=true;
        while (valid) {
            for (char c : tar) {
                if (map.containsKey(c)) {
                    if (map.get(c) <= 0) {
                        valid=false;
                    } else {
                        map.put(c, map.getOrDefault(c, 0) - 1);
                    }
                }else{
                    valid=false;
                }

            }
            count++;

        }
        return count;



    }
}