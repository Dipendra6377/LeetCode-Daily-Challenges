class Solution {
    public long distinctNames(String[] idea) {
        Set<String>[] set=new Set[26];
        for(int i=0;i<26;i++){
            set[i]=new HashSet<>();
        }
        for(String s:idea){
            set[s.charAt(0)-'a'].add(s.substring(1));
        }
//        for(int i=0;i<26;i++){
//            System.out.print(set[i] +"  ");
//        }
        System.out.println();
        int[][] dp=new int[26][26];
        for(int i=0;i< 26;i++){
            for(String s:set[i]){
                //System.out.println(s + " ");
                for(int j=i+1;j<26;j++){
                    if(set[j].contains(s)){
                        //System.out.println(s + " " + set[j]);
                        dp[i][j]++;
                    }
                }
            }
        }
        //System.out.println("//////////////////");
        long res=0;

        for(int i=0;i<26;i++){
            for (int j = i + 1; j < 26; j++) {

                res += (set[i].size() - dp[i][j]) * (set[j].size() - dp[i][j]) * 2;
                //System.out.println(set[i] + "  " +set[j]);
                //System.out.println(i + " " + j);
                //System.out.println("res   " + res);
            }
        }
        return res;
    }
}