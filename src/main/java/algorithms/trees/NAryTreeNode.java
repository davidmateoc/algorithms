package algorithms.trees;

import java.util.List;

/**
 * Created by davidmateo on 2021-07-06
 */

public class NAryTreeNode {
    public int val;
    public List<NAryTreeNode> children;

    public NAryTreeNode() { }
    public NAryTreeNode(int val) {
        this.val = val;
    }

    public NAryTreeNode(int val, List<NAryTreeNode> children) {
        this.val = val;
        this.children = children;
    }
}
