package com.example.talha.projectdatastructure;

/**
 * Created by Talha on 22-Dec-15.
 */

public class MyBST {
    BSTNode root;

    public MyBST() {
        this.root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void insert(int difficultyLevel, TrueFalse[] questions) {
        root = insert(root, difficultyLevel, questions);
    }

    private BSTNode insert(BSTNode node, int difficultyLevel, TrueFalse[] questions) {
        if (node == null) {
            node = new BSTNode(difficultyLevel, questions);
        } else if (difficultyLevel <= node.getDifficultyLevel()) {
            node.left = insert(node.left, difficultyLevel, questions);
        } else {
            node.right = insert(node.right, difficultyLevel, questions);
        }
        return node;
    }

    public void delete(int difficultyLevel) {
        if (isEmpty()) {
            return;
        }

        if (search(difficultyLevel) == false) {
            System.out.println("Value not found.");
            return;
        } else {
            root = delete(root, difficultyLevel);
            System.out.println("Value has been deleted.");
        }
    }

    private BSTNode delete(BSTNode node, int difficultyLevel) {
        BSTNode p, p2, n;

        if (node.getDifficultyLevel() == difficultyLevel) {
            BSTNode lt, rt;
            lt = node.getLeft();
            rt = node.getRight();

            if (lt == null && rt == null) {
                return null;
            }

            else if (lt == null) {
                p = rt;
                return p;
            } else if (rt == null) {
                p = lt;
                return p;
            } else {
                p = rt;
                p2 = rt;

                while (p.getLeft() != null) {
                    p = p.getLeft();
                }
                p.setLeft(lt);
                return p2;
            }
        }

        else if (difficultyLevel < node.getDifficultyLevel()) {
            n = delete(node.getLeft(), difficultyLevel);
            node.setLeft(n);
        } else {
            n = delete(node.getRight(), difficultyLevel);
            node.setRight(n);
        }
        return node;
    }

    public int countNodes() {
        return countNodes(root);
    }

    private int countNodes(BSTNode root) {
        if (root == null) {
            return 0;
        } else {
            int l = 1;
            l += countNodes(root.getLeft());
            l += countNodes(root.getRight());
            return l;
        }
    }

    public boolean search(int difficultyLevel) {
        return search(root, difficultyLevel);
    }

    private boolean search(BSTNode r, int val) {
        boolean found = false;

        while (r != null && !found) {
            int rval = r.getDifficultyLevel();
            if (val < rval) {
                r = r.getLeft();
            } else if (val > rval) {
                r = r.getRight();
            } else {
                found = true;
                break;
            }
            found = search(r, val);
        }
        return found;
    }

    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(BSTNode r) {
        if (r != null) {
            inOrder(r.getLeft());
            System.out.println(r.getDifficultyLevel() + " ");
            inOrder(r.getRight());
        }
    }

    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(BSTNode r) {
        if (r != null) {
            System.out.println(r.getDifficultyLevel() + " ");
            inOrder(r.getLeft());
            inOrder(r.getRight());
        }
    }

    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(BSTNode r) {
        if (r != null) {
            inOrder(r.getLeft());
            inOrder(r.getRight());
            System.out.println(r.getDifficultyLevel() + " ");
        }
    }

    public TrueFalse[] bringQuestions(){
        return bringQuestions(root);
    }

    private TrueFalse[] bringQuestions(BSTNode r) {

        BSTNode s = r;
        BSTNode t = r;

        while (s.getLeft() != null) {
            t = s;
            s = s.getLeft();
        }

        TrueFalse[] TF = s.getQuestions();

        if (s.getRight()!=null) {
            t.setLeft(s.getRight());
        }
        root = t;
        return TF;
    }


}
