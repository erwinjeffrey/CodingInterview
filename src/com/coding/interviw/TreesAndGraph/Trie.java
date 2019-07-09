package com.coding.interviw.TreesAndGraph;

public class Trie {
    static TrieNode root = new TrieNode();

    /* if not present, inserts key into trie
    if the key is prefix of trie node
    just marks leaf node
     */

    static void insert(String key){
        int level;
        int lenght = key.length();
        int index;

        TrieNode pCrawl = root;

        for (level = 0; level < lenght ; level++) {
            index = key.charAt(level) - 'a';
            if(pCrawl.children[index] == null){
                pCrawl.children[index] = new TrieNode();
            }
            pCrawl = pCrawl.children[index];
        }
        // mark last node as leaf
        pCrawl.isEndOfWord = true;
    }

    // Returns true if key presents in trie, else false
    static boolean search(String key){
        int level;
        int length = key.length();
        int index;
        TrieNode pCrawl = root;

        for (level = 0; level <length ; level++) {
            index = key.charAt(level) - 'a';
            if(pCrawl.children[index] == null){
                return false;
            }
            pCrawl= pCrawl.children[index];
        }
        return (pCrawl != null && pCrawl.isEndOfWord);
    }
}
