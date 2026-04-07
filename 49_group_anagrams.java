class Solution {
// Java
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<Integer, List<String>> anagramGroup = new HashMap<>();

        for (String str : strs) {
            char[] chars = str.toCharArray();
            Integer keySum =0;
            for (char c : chars) {
                keySum += c -'0';
            }
            if(!anagramGroup.containsKey(keySum)){
                anagramGroup.put(keySum, new ArrayList<>());
            }
            anagramGroup.get(keySum).add(str);
        }
        List<List<String>> result = new ArrayList<>();
        for(Map.Entry<Integer, List<String>> entry : anagramGroup.entrySet()){
            result.add(entry.getValue());
        }
        return result;
    }

}