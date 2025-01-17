package Alogrithm.Encoding;

import Alogrithm.*;
import java.util.*;

public class EncodingAlgo {

    public Map<Character, Integer> getFrequencyOfCharacter(String s) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }
        return freqMap;
    }

    public TreeNode createTree(PriorityQueue<TreeNode> min_heap) {
        return null;
    }

    public Map<Character, String> compressString(String s) {
        Map<Character, Integer> freqMap = getFrequencyOfCharacter(s);
        TreeNode root = null;
        PriorityQueue<TreeNode> min_heap = new PriorityQueue<>((a, b) -> a.count - b.count);
        for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
            TreeNode node = new TreeNode(entry.getKey(), entry.getValue());
            min_heap.add(node);
        }
        while (!min_heap.isEmpty()) {
            System.out.println(min_heap.poll().c);
        }
        return null;
    }

    public static void main(String[] args) {
        EncodingAlgo test = new EncodingAlgo();

    }
}
