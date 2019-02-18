package com.u8;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/**
 * 133
 * 克隆一张无向图，图中的每个节点包含一个 label （标签）和一个 neighbors （邻接点）列表 。
 */
public class UndirectedGraphNode {
    int label;
    List<UndirectedGraphNode> neighbors;
    UndirectedGraphNode(int x) { 
        label = x; neighbors = new ArrayList<UndirectedGraphNode>();
    }
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node, Map<Integer, UndirectedGraphNode> map) {
        if (node == null) {
            return null;
        }
        if (map.containsKey(node.label)) {
            return map.get(node.label);
        }
        UndirectedGraphNode copyNode = new UndirectedGraphNode(node.label);
        map.put(copyNode.label, copyNode);
        //开始复制node.列表
        List<UndirectedGraphNode> list = node.neighbors;
        List<UndirectedGraphNode> copyList = new ArrayList<>();
        for (UndirectedGraphNode next : list) {
            if (next.label != copyNode.label) {
                copyList.add(cloneGraph(next, map));
            }else {
                copyList.add(copyNode);
            }
        }
        copyNode.neighbors = copyList;
        map.put(copyNode.label, copyNode);
        return copyNode;
    }
}
