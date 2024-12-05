package my.rockpilgrim.timerforall.model.Tree;

import java.util.ArrayList;

import my.rockpilgrim.timerforall.presenter.timer.Timer;

public class TreeHolder<T extends Timer> {

    public final Node<T> root;
    private ArrayList<Node<T>> childList;

    public TreeHolder() {
        root = new Node<T>(null, null);
        childList = new ArrayList<>();
    }

    public Node getParentOf(int index) {
        return childList.get(index).getParent();
    }

    public void addToRoot(T object) {
        Node child = new Node(object, root);
        root.addChild(child);
        childList.add(child);
        child.setIndex(childList.indexOf(child));
    }

    public void addTimer(int fatherIndex, T son) {
        if (fatherIndex == -1) {
            addToRoot(son);
            return;
        }
        Node child = new Node<T>(son);
        childList.get(fatherIndex).addChild(child);
        childList.add(child);
        child.setIndex(childList.indexOf(child));
    }

    public Node getChild(int index) {
        return childList.get(index);
    }

    public T getTimer(int index) {
        return childList.get(index).timer;
    }

    public int size() {
        return childList.size();
    }

    public void addChild(Node<T> father, Node<T> son) {
        father.addChild(son);
        childList.add(son);
        son.setIndex(childList.indexOf(son));
    }

    public int getFindIndexOf(T object) {
        for (int i = 0; i < childList.size(); i++) {
            if (childList.get(i).timer.equals(object)) {
//                System.out.println(i);
                return i;
            }
        }
        return -1;
    }
}
