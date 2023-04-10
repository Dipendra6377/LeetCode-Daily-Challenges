class Solution {
    public boolean isValid(String s) {
        Stack<Character> st=new Stack<>();
        int i=0;
        int n=s.length();

        while(i<n){
            char c=s.charAt(i);

            if(c=='(' || c=='[' || c=='{'){
                st.push(c);
            }
            else {
                if(st.isEmpty()) return false;

                if((st.peek()=='(' && c==')') || (st.peek()=='[' && c==']') || (st.peek()=='{' && c=='}')) st.pop();

                else{ return false;
                }
            }
            i++;
        }
        if(st.isEmpty()) return true;
        return false;
    }
}