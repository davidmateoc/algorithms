package algorithms.trees;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Create by davidmateo
 * Date: 2021-08-09
 * Time: 1:38 PM
 * Algorithm URL: https://leetcode.com/problems/n-ary-tree-preorder-traversal/
 */

public class NAryTreePreOrderTraversal {

    public List<Integer> preorder(NAryTreeNode root) {
        LinkedList<NAryTreeNode> stack = new LinkedList();
        LinkedList<Integer> result = new LinkedList();

        if(root == null) {
            return result;
        }
        stack.add(root);

        while(!stack.isEmpty()) {
            //We poll the last element of the stack
            NAryTreeNode node = stack.pollLast();
            result.add(node.val);

            //We need to reverse the children order before adding them to the stack. In order to do that its important
            //that the list of children are mutable so we can revert them.
            Collections.reverse(node.children);
            for(NAryTreeNode child : node.children) {
                stack.add(child);
            }
        }
        return result;
    }

    @Test
    public void preorderTest() {
        NAryTreeNode five = new NAryTreeNode(5);
        NAryTreeNode six = new NAryTreeNode(6);
        List<NAryTreeNode> threeList = new ArrayList();
        threeList.add(five);
        threeList.add(six);

        NAryTreeNode three = new NAryTreeNode(3, threeList);
        NAryTreeNode two = new NAryTreeNode(2);
        NAryTreeNode four = new NAryTreeNode(4);

        List<NAryTreeNode> oneList = new ArrayList();
        oneList.add(three);
        oneList.add(two);
        oneList.add(four);

        NAryTreeNode one = new NAryTreeNode(1, oneList);

        preorder(one);
    }
}