package com.company.utils.search_algrithom;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author Administrator
 * @data 四月 15 2017 20:15.
 */
public class VisitTree {

//    List<TreeNode> list = new ArrayList<TreeNode>();

    public static List<TreeNode> preOrder(TreeNode root, List<TreeNode> list){
        if (root!=null){
            list.add(root);
            preOrder(root.left,list);
            preOrder(root.right,list);
        }
        return list;
    }

    public static List<TreeNode> inOrder(TreeNode root,List<TreeNode> list){
        if (root!=null){
            inOrder(root.left,list);
            list.add(root);
            inOrder(root.right,list);
        }
        return list;
    }

    public static List<TreeNode> postOrder(TreeNode root,List<TreeNode> list){
        if (root!=null){
            postOrder(root.left,list);
            postOrder(root.right,list);
            list.add(root);
        }
        return list;
    }

    public static  List<TreeNode> preIterative(TreeNode root,List<TreeNode> list){
        if (root != null){
            list.add(root);
            Stack<TreeNode> stack = new Stack<TreeNode>();
            if (root.right!=null) stack.push(root.right);
            if (root.left!=null) stack.push(root.left);
            while (!stack.isEmpty()){
                root = stack.pop();
                list.add(root);
                if (root.right!=null) stack.push(root.right);
                if (root.left!=null) stack.push(root.left);
            }
        }
        return list;
    }

    public static  List<TreeNode> inIterative(TreeNode root,List<TreeNode> list){
        if (root!=null){
            Stack<TreeNode> stack = new Stack<TreeNode>();
            stack.push(root);
            while (root.left!=null) {
                stack.push(root.left);
                root = root.left;
            }
            while (!stack.isEmpty()){
                root = stack.pop();
                list.add(root);
                if(root.right!=null) {
                    stack.push(root.right);
                    root = root.right;
                    while (root.left!=null) {
                        stack.push(root.left);
                        root = root.left;
                    }
                }
            }
        }
        return list;
    }

    public static  List<TreeNode> postIterative(TreeNode root,List<TreeNode> list){
        TreeNode p = root;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (root!=null){
            //左子树入栈
            for(;root.left!=null;root = root.left){
                stack.push(root);
            }
            //当前节点无右子节点或右子节点已输出
            while (root!=null &&(root.right==null||root.right==p)){
                list.add(root);
                p = root;//记录上一个已输出的节点
                if (stack.isEmpty())
                    return list;
                root = stack.pop();
            }
            //处理右子
            stack.push(root);
            root = root.right;
        }
        return list;
    }

    public static  List<TreeNode> levelIterative(TreeNode root,List<TreeNode> list){
        if (root!=null){
            List<TreeNode> queue = new LinkedList<TreeNode>();
            queue.add(root);
            while (!queue.isEmpty()){
                if (queue.get(0).left!=null) queue.add(queue.get(0).left);
                if (queue.get(0).right!=null) queue.add(queue.get(0).right);
                list.add(queue.remove(0));
            }
        }
        return list;
    }

    public static void display(List<TreeNode> list){
        list.forEach(l-> System.out.print(l.getValue()+" "));
    }
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        t1.left = t2;
        t1.right = t3;
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        t2.left = t4;
        t2.right = t5;
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);
        t3.left = t6;
        t3.right = t7;
        TreeNode t8 = new TreeNode(8);
        TreeNode t9 = new TreeNode(9);
        t4.left = t8;
        t4.right = t9;
        TreeNode t10 = new TreeNode(10);
        t5.right = t10;

        System.out.println("前序递归遍历输出为：");
        List<TreeNode> list = new ArrayList<TreeNode>();
        List<TreeNode> preOrder = preOrder(t1,list);
        display(preOrder);
        System.out.println();

        System.out.println("中序递归遍历输出为：");
        list = new ArrayList<TreeNode>();
        List<TreeNode> inOrder = inOrder(t1,list);
        display(inOrder);
        System.out.println();

        System.out.println("后序递归遍历输出为：");
        list = new ArrayList<TreeNode>();
        List<TreeNode> postOrder = postOrder(t1,list);
        display(postOrder);
        System.out.println();

        System.out.println("前序循环遍历输出为：");
        list = new ArrayList<TreeNode>();
        List<TreeNode> preIterative = preIterative(t1,list);
        display(preIterative);
        System.out.println();

        System.out.println("中序循环遍历输出为：");
        list = new ArrayList<TreeNode>();
        List<TreeNode> inIterative = inIterative(t1,list);
        display(inIterative);
        System.out.println();

        System.out.println("后序循环遍历输出为：");
        list = new ArrayList<TreeNode>();
        List<TreeNode> postIterative = postIterative(t1,list);
        display(postIterative);
        System.out.println();

        System.out.println("层级循环遍历输出为：");
        list = new ArrayList<TreeNode>();
        List<TreeNode> levelIterative = levelIterative(t1,list);
        display(levelIterative);
        System.out.println();
    }
}
