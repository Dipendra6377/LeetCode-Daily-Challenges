class Solution {
    public String removeStars(String s) {
        int n=s.length();
        Stack<Character> st =new Stack<>();
        for(int i=0;i<n;i++){
            char c=s.charAt(i);
            
            if(c=='*'){
                st.pop();
            }
            else{
                st.push(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        
        for(char c:st){
            sb.append(c);
        }
        return sb.toString();
    }
}