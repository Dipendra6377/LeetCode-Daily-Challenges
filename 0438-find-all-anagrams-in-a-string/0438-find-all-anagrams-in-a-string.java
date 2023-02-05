class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list=new ArrayList<>();
        int m=s.length();
        int n=p.length();

        if(n>m){
            return list;
        }
        int[] chars = new int[26];
        int[] charp = new int[26];
        for(int i=0;i<n;i++){
            chars[s.charAt(i)-'a']++;
            charp[p.charAt(i)-'a']++;
        }

        for(int i=0;i<=m-n;i++){
            if(sIsanagramOfp(chars,charp)){
                list.add(i);
            }
            chars[s.charAt(i)-'a']--;

            if(i+n<m){
                chars[s.charAt(i+n)-'a']++;
            }
        }
        return list;
    }

    public boolean sIsanagramOfp(int[] chars,int[] charp){
        for(int i=0;i<26;i++){
            if(chars[i]!=charp[i]){
                return false;
            }
        }
        return true;
    }
}