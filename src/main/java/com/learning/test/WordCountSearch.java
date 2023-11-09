package com.learning.test;

import java.util.Map;

public class WordCountSearch {
    //26 - lowercase
    // 5 -  !@#$_
    //digit - 10

    static class Node {
        char val;
        Node[] childNodes;
        int wordCount;

        Node() {
            childNodes = new Node[26];
            wordCount = 0;
        }

        Node(char val) {
            this.val = val;
        }
    }

    //Stirng - “Test Paragraph”
    private static Node storeWords(String[] words) {
        Node head = new Node();
        for(String word: words){
            Node currNode = head;
            char[] chars = word.toCharArray();
            for (int i = 0; i < chars.length; i++) {

                //TODO: Ignore punchucation marks

                int idx = chars[i] - 'a';
                if(currNode.childNodes[idx] == null){
                    currNode.childNodes[idx] = new Node();
                }

                currNode = currNode.childNodes[idx];
            }
            currNode.wordCount++;
        }
        return null;
    }

    public static Map<String, Integer> wordCount(String paragraph) {
        String[] words = paragraph.split(" ");

        storeWords(words);

        //

        return null;
    }
}
