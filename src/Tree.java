import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Tree {
    private String name;
    private Tree left;
    private Tree right;

    public Tree(String name) {
        this.name = name;
    }

    public boolean contains(String query) {
        if (query.compareTo(name) < 0) {
            return left != null && left.contains(query);
        } else if (query.compareTo(name) > 0) {
            return right != null && right.contains(query);
        } else {
            return name.equals(query);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Tree getLeft() {
        return left;
    }

    public void setLeft(Tree left) {
        this.left = left;
    }

    public Tree getRight() {
        return right;
    }

    public void setRight(Tree right) {
        this.right = right;
    }

    public boolean isNamePyramid() {

        // Проверяем левого ребенка
        if (left != null) {
            if (left.getName().length() < this.name.length()) {
                return false;
            }
            if (!left.isNamePyramid()) { // рекурсия для проверки потомков
                return false;
            }
        }

        // Проверяем правого ребенка
        if (right != null) {
            if (right.getName().length() < this.name.length()) {
                return false;
            }
            if (!right.isNamePyramid()) {  // рекурсия для проверки потомков
                return false;
            }
        }

        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        appendInOrder(sb);
        return sb.toString();
    }

    // обход в порядке "узел(левое, правое)"
    private void appendInOrder(StringBuilder sb) {
        sb.append(name);
        if (left == null && right == null) {
            return;
        }
        sb.append('(');
        if (left != null) left.appendInOrder(sb);
        sb.append(", ");
        if (right != null) right.appendInOrder(sb);
        sb.append(')');
    }
}
