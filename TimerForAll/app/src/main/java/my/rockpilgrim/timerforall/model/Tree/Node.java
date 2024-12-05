package my.rockpilgrim.timerforall.model.Tree;

import java.util.ArrayList;

import my.rockpilgrim.timerforall.presenter.timer.Timer;

public class Node<T extends Timer> {

    public T timer;
    private Node<T> parent;
    private int index;
    private ArrayList<Node<T>> children;

    public Node(T timer, Node parent) {
        this.timer = timer;
        this.parent = parent;
        children = new ArrayList<>();
    }

    public Node(T timer) {
        this.timer = timer;
        children = new ArrayList<>();
    }

    public void addChild(Node child) {
        child.setParent(this);
        children.add(child);
    }

    public void setIndex(int index) {
        this.index = index;
        timer.setIndex(index);
    }

    public ArrayList<T> getChildren() {
        ArrayList<T> kids = new ArrayList<>();
        for (Node<T> o : children) {
            kids.add(o.timer);
        }
        return kids;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }





    public ArrayList<Node<T>> getChildrenNode() {
        return children;
    }

    public Node<T> getChild(int index) {
        return children.get(index);
    }

    public T getChildObj(int index) {
        return children.get(index).timer;
    }
    public int getIndex() {
        return index;
    }


    public int sizeCildren() {
        return children.size();
    }
}