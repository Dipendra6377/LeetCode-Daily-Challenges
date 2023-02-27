//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class comp implements Comparator<ArrayList<String>> {
    // override the compare() method
    public int compare(ArrayList<String> a, ArrayList<String> b)
    {
        String x = "";
        String y = "";
        for(int i=0; i<a.size(); i++)
            x += a.get(i);
        for(int i=0; i<b.size(); i++)
            y += b.get(i);
        return x.compareTo(y);
    }
}

public class GFG
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
            ArrayList<ArrayList<String>> ans = obj.findSequences(startWord, targetWord, wordList);
            if(ans.size()==0)
                System.out.println(-1);
            else
            {
                Collections.sort(ans, new comp());
                for(int i=0; i<ans.size(); i++)
                {
                    for(int j=0; j<ans.get(i).size(); j++)
                    {
                        System.out.print(ans.get(i).get(j) + " ");
                    }
                    System.out.println();
                }
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public ArrayList<ArrayList<String>> findSequences(String beginWord, String endWord, String[] wordList)
    {
        // Code here
        
        Set<String> set = new HashSet<>();
        int n =wordList.length;

        for(int i=0;i<n;i++){
            set.add(wordList[i]);
        }
        Queue<ArrayList<String>> q=new LinkedList<>();
        ArrayList<String> list = new ArrayList<>();
        list.add(beginWord);
        q.add(list);

        ArrayList<String> level = new ArrayList<>();
        level.add(beginWord);
        int lvl=0;
        ArrayList<ArrayList<String>> ans = new ArrayList<>(); 

        while(!q.isEmpty()){
            ArrayList<String > sublist = q.peek();
            q.remove();

            if(sublist.size()>lvl){
                lvl++;
                for(String s:level){
                    set.remove(s);
                }
            }
            String word = sublist.get(sublist.size()-1);
            if(word.equals(endWord)){
                if(ans.size()==0) ans.add(sublist);
                else if(ans.get(0).size()==sublist.size()) ans.add(sublist);
            }

            for(int i=0;i<word.length();i++){
                for(char c='a' ;c<='z';c++){
                    char replacedcharWord[] =word.toCharArray();
                    replacedcharWord[i]=c;
                    String replaceWord = new String(replacedcharWord);
                    if(set.contains(replaceWord)==true){
                        sublist.add(replaceWord);

                        ArrayList<String> temp = new ArrayList<>(sublist);
                        q.add(temp);
                        level.add(replaceWord);
                        sublist.remove(sublist.size()-1);
                    }
                }
            }
        }
        return ans;
    }
}