package ua.opnu;

import java.util.*;

public class Task {
    public static void main(String[] args) {

    }

    public void removeShorterStrings(List<String> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            String s1 = list.get(i);
            String s2 = list.get (i + 1);
            if (s1.length() <= s2.length()) {
                list.remove(i);
            } else {
                list.remove(i + 1);
            }
        }
    }

    public void stutter(List<String> list) {
        for (int i = 0; i < list.size(); i += 2) {
            list.add(i, list.get (i));
        }
    }

    public void switchPairs(List<String> list) {
        for (int i = 0; i < list.size() - 1; i += 2) {
            String temp = list.get(i);
            list.set(i, list.get(i + 1));
            list.set(i + 1, temp);
        }
    }

    public void removeDuplicates(List<String> list) {
        if (list.isEmpty()) return;
        for (int i = 0; i < list.size() -1; ) {
            if (list.get(i).equals(list.get(i + 1))) {
                list.remove(i + 1);
            } else {
                i++;
            }
        }
    }

    public void markLength4(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).length() == 4) {
                list.add(i, "****");
                i++;
            }
        }
    }

    public boolean isPalindrome(Queue<Integer> queue) {
        Stack<Integer> stack = new Stack <>();
        int size = queue.size();
        boolean palindrome = true;

        for (int i = 0; i < size; i++) {
            int n = queue.remove();
            queue.add(n);
            stack.push(n);
        }

        for (int i = 0; i < size; i++) {
            int n = queue.remove();
            if (n != stack.pop()) {
                palindrome = false;
            }
            queue.add(n);
        }
        return palindrome;
    }

    public void reorder(Queue<Integer> queue) {
        Stack<Integer> stack = new Stack<>();
        int size = queue.size();
        int positiveCount = 0;

        for (int i = 0; i < size; i++) {
            int n = queue.remove();
            if (n < 0) {
                stack.push(n);
            } else {
                queue.add(n);
                positiveCount++;
            }
        }

        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }

        for (int i = 0; i < positiveCount; i++) {
            queue.add(queue.remove());
        }
    }

    public void rearrange(Queue<Integer> queue) {
        Stack<Integer> stack = new Stack<>();
        int size = queue.size();

        for (int i = 0; i < size; i++) {
            int n = queue.remove();
            if (n % 2 == 0) {
                queue.add(n);
            } else {
                stack.push(n);
            }
        }

        int oddCount = stack.size();
        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }

        int evenCount = size - oddCount;
        for (int i = 0; i < evenCount; i++) {
            queue.add(queue.remove());
        }

        for (int i = 0; i < oddCount; i++) {
            stack.push(queue.remove());
        }

        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }
    }

    public int maxLength(Set<String> set) {
        int max = 0;
        for (String s : set) {
            if (s.length() > max) {
                max = s.length();
            }
        }
        return max;
    }

    public void removeEvenLength(Set<String> set) {
        Iterator<String> itr = set.iterator();
        while (itr.hasNext()) {
            String s = itr.next();
            if (s.length() % 2 == 0) {
                itr.remove();
            }
        }
    }

    public int numInCommon(List<Integer> list1, List<Integer> list2) {
        Set<Integer> set1 = new HashSet<>(list1);
        Set<Integer> set2 = new HashSet<>(list2);
        set1.retainAll(set2);
        return set1.size();
    }

    public boolean isUnique(Map<String, String> map) {
        Set<String> values = new HashSet<>();
        for (String value : map.values()) {
            if (values.contains(value)) {
                return false;
            }
            values.add(value);
        }
        return true;
    }

    public Map<String, Integer> intersect(Map<String, Integer> map1, Map<String, Integer> map2) {
        Map<String, Integer> result = new HashMap<>();
        for (String key : map1.keySet()) {
            if (map2.containsKey(key)) {
                Integer val1 = map1.get(key);
                Integer val2 = map2.get(key);
                if (Objects.equals(val1, val2)) {
                    result.put(key, val1);
                }
            }
        }
        return result;
    }

    public Map<String, Integer> reverse(Map<Integer, String> map) {
        Map <String, Integer> result = new HashMap<>();
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            result.put(entry.getValue(), entry.getKey());
        }
        return result;
    }

    public int rarest(Map<String, Integer> map) {
        if (map.isEmpty()) {
            throw new IllegalArgumentException("Map cannot be empty");
        }

        Map<Integer, Integer> counts = new HashMap<>();
        for (Integer val : map.values()) {
            counts.put(val, counts.getOrDefault(val, 0) +1);
        }

        int minCount = Integer.MAX_VALUE;
        int rerestVal = Integer.MAX_VALUE;

        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            int val = entry.getKey();
            int count = entry.getValue();

            if (count < minCount) {
                minCount = count;
                rerestVal = val;
            } else if (count == minCount) {
                if (val < rerestVal) {
                    rerestVal = val;
                }
            }
        }
        return rerestVal;

    }

    public int maxOccurrences(List<Integer> list) {
        if (list.isEmpty()) return 0;

        Map<Integer, Integer> counts = new HashMap<>();
        for (Integer n : list) {
            counts.put(n, counts.getOrDefault(n, 0) +1);
        }

        int max = 0;
        for (int count : counts.values()) {
            if (count > max) {
                max = count;
            }
        }
        return max;
    }

}
