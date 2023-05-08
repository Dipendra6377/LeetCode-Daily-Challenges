//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            String[] wordList = new String[n];
            for(int i = 0; i < n; i++){
                wordList[i] = br.readLine().trim();
            }
            String startWord, targetWord;
            startWord = br.readLine().trim();
            targetWord = br.readLine().trim();
            Solution obj = new Solution();
            int ans = obj.wordLadderLength(startWord, targetWord, wordList);
            System.out.println(ans);
       }
    }
}

// } Driver Code Ends

class pair{
    String first;
    int second;
    
    pair(String first,int second){
        this.first=first;
        this.second=second;
    }
}
class Solution
{
    public int wordLadderLength(String startWord, String targetWord, String[] wordList)
    {
        // Code here
        Queue<pair> q=new LinkedList<>();
        Set<String> st=new HashSet<>();
        int n=wordList.length;

        q.add(new pair(startWord,1));
        for(int i=0;i<n;i++){
            st.add(wordList[i]);
        }
        if(st.contains(startWord)){
            st.remove(startWord);
        }
        
        while(!q.isEmpty()){
            String word = q.peek().first;
            int step = q.peek().second;
            
            q.remove();
            
            if(word.equals(targetWord)==true){
                return step;
            }
            
            for(int i=0;i<word.length();i++){
                for(char c='a';c<='z';c++){
                    char[] charWord = word.toCharArray();
                    charWord[i]=c;
                    String replaceWord=new String(charWord);
                    
                    if(st.contains(replaceWord)){
                    st.remove(replaceWord);
                    q.add(new pair(replaceWord,step+1));
                }
                }
            }
        }
        return 0;
    }
}