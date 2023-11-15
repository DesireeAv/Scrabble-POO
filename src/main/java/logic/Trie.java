/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author klob
 */
import java.util.HashMap;

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (!node.children.containsKey(c)) {
                node.children.put(c, new TrieNode());
            }
            node = node.children.get(c);
        }
        node.isEndOfWord = true;
    }

    public boolean search(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (!node.children.containsKey(c)) {
                return false;
            }
            node = node.children.get(c);
        }
        return node.isEndOfWord;
    }

    private class TrieNode {
        private HashMap<Character, TrieNode> children;
        private boolean isEndOfWord;

        public TrieNode() {
            children = new HashMap<>();
            isEndOfWord = false;
        }
    }
    
    public void fill(){
        try {
            BufferedReader reader = new BufferedReader(new FileReader("Diccionario.txt"));
            String line;

            while ((line = reader.readLine()) != null) {
                // Inserta cada palabra en el Trie
                this.insert(line.trim());
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        Trie trie = new Trie();

        System.out.println(trie.search("amigo"));  // Debería imprimir true
        System.out.println(trie.search("app"));    // Debería imprimir true
        System.out.println(trie.search("ap"));     // Debería imprimir false
    }
}
