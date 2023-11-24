/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 *
 * @author klob
 */
import java.util.HashMap;

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
        fill();
    }

    private void insert(String word) {
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
    
    public void fill(){
        String nombreArchivo = "/DiccionarioLAST.txt";

        // Abre el archivo como un recurso del classpath
        try (InputStream is = Trie.class.getResourceAsStream(nombreArchivo);
             BufferedReader br = new BufferedReader(new InputStreamReader(is))) {

            // Lee el contenido del archivo línea por línea
            String linea;
            while ((linea = br.readLine()) != null) {
                this.insert(linea);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private class TrieNode {
        private HashMap<Character, TrieNode> children;
        private boolean isEndOfWord;

        public TrieNode() {
            children = new HashMap<>();
            isEndOfWord = false;
        }
    }
    
}