package Alogrithm.Encoding;

import Alogrithm.*;
import java.util.*;

public class EncodingAlgo {

    private TreeNode root = null;
    private Map<Character, String> codeMap = new HashMap<>();

    private Map<Character, Integer> getFrequencyOfCharacter(String s) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }
        return freqMap;
    }

    private TreeNode createTree(PriorityQueue<TreeNode> min_heap) {
        if (min_heap.isEmpty()) {
            return null;
        }
        while (min_heap.size() > 1) {
            TreeNode a = min_heap.poll();
            TreeNode b = min_heap.poll();
            System.out.println(a.c + "-" + a.count  + " " + b.c + "-" + b.count);
            TreeNode node = new TreeNode('\0', a.count + b.count);
            node.left = a;
            node.right = b;
            min_heap.add(node);
        }

        return min_heap.poll();
    }

    private PriorityQueue<TreeNode> createHeapAccordingToCountOfCharacterString(String s) {
        Map<Character, Integer> freqMap = getFrequencyOfCharacter(s);
        PriorityQueue<TreeNode> min_heap = new PriorityQueue<>((a, b) -> a.count == b.count ? a.c - b.c : a.count - b.count);
        for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
            TreeNode node = new TreeNode(entry.getKey(), entry.getValue());
            min_heap.add(node);
        }
        return min_heap;
    }

    private void createCompressTree(String s) {
        PriorityQueue<TreeNode> count_min_heap = createHeapAccordingToCountOfCharacterString(s);
        root = createTree(count_min_heap);

    }

    public Map<Character, String> generateCharacterCompressedMap(String s) {
        createCompressTree(s);
        if (s.length() == 0) {
            return null;
        }
        preOrderTravel(root, "", codeMap);
        return codeMap;

    }

    private void preOrderTravel(TreeNode node, String code, Map<Character, String> map) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            map.put(node.c, code);
            return;
        }
        preOrderTravel(node.left, code + '0', map);
        preOrderTravel(node.right, code + '1', map);
    }

    public static void main(String[] args) {
        EncodingAlgo test = new EncodingAlgo();
        Map<Character, String> map = test.generateCharacterCompressedMap("abcd");
        for (Map.Entry<Character, String> entry : map.entrySet()) {
            System.out.println(entry);
        }

    }
}
