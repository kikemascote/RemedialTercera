package mx.sostech.tree;

import mx.sostech.node.calificacion;
import mx.sostech.queue.tqueue;

public class tree {
    public class btree<T extends Comparable<T>> implements Comparable<T> {

        public calificacion<T> root = null;
        private int height = 0;
        private int count = 0;
        private int size = 0;
        private tqueue<calificacion<T>> cola;

        public btree() {
            root = new calificacion<T>();
        }

        public btree(T value) {
            this.root = new calificacion<T>(value);
            size++;
        }

        public void add(T value) {
            if (root.getValue() == null)
                root.setValue(value);

            else {
                count = 0;
                add(value, root);
            }
            if (count > height)
                height = count;
            size++;
        }

        private void add(T value, calificacion<T> root) {
            count++;
            if (root.getValue().compareTo(value) >= 1) {
                if (root.getLeft() == null) {
                    root.setLeft(new calificacion<>(value));
                    return;
                } else {

                    add(value, root.getLeft());
                }
            } else if (root.getValue().compareTo(value) <= -1
                    || root.getValue().compareTo(value) == 0) {
                if (root.getRight() == null) {
                    root.setRight(new calificacion<>(value));
                    return;
                } else {

                    add(value, root.getRight());
                }
            }
        }

        public boolean remove(T value) {
            calificacion<T> tmp = DeepSearch(value);

            if (tmp != null) {
                size--;
                return remove(value, tmp, isChild(value));
            } else
                return false;
        }

        private boolean remove(T value, calificacion<T> root, calificacion<T> papu) {

            if (isChild(value) == null) {
                calificacion<T> min = MinSearch(root.getRight());
                min.setLeft(root.getLeft());
                this.root = root.getRight();
                return true;
            }

            if (root.getLeft() == null && root.getRight() == null) {
                if (papu.getLeft() != null && papu.getLeft().equals(root)) {
                    papu.setLeft(null);
                } else if (papu.getRight() != null)
                    papu.setRight(null);
                return true;
            } else if (root.getLeft() != null && root.getRight() == null) {
                if (papu.getLeft().equals(root))
                    papu.setLeft(root.getLeft());
                else
                    papu.setRight(root.getLeft());
                return true;
            } else if (root.getLeft() == null && root.getRight() != null) {
                if (papu.getLeft().equals(root))
                    papu.setLeft(root.getRight());
                else
                    papu.setRight(root.getRight());
                return true;
            } else {
                if (papu.getLeft().equals(root)) {
                    calificacion<T> Left = MinSearch(root.getRight());
                    Left.setLeft(root.getLeft());
                    papu.setLeft(root.getRight());
                } else {
                    calificacion<T> Left = MinSearch(root.getRight());
                    Left.setLeft(root.getLeft());
                    papu.setRight(root.getRight());
                }
                return true;
            }
        }


        public void PrintInorder() {
            if (!isEmpty())
                PrintInorder(root);
        }

        private void PrintInorder(calificacion<T> root) {
            if (root != null) {
                PrintInorder(root.getLeft());
                System.out.println(root.getValue().toString());
                PrintInorder(root.getRight());
            }
        }

        public void PrintPreOrder() {
            if (!isEmpty())
                PrintPreOrder(root);
        }

        public void PrintPreOrder(calificacion<T> root) {
            if (root != null) {
                System.out.println(root.getValue().toString());
                PrintPreOrder(root.getLeft());
                PrintPreOrder(root.getRight());
            }
        }

        public void PrintPostOrder() {
            if (!isEmpty())
                PrintPostOrder(root);
        }

        public void PrintPostOrder(calificacion<T> root) {
            if (root != null) {
                PrintPostOrder(root.getLeft());
                PrintPostOrder(root.getRight());
                System.out.println(root.getValue().toString());
            }
        }

        public calificacion<T> isChild(T value) {
            if (DeepSearch(value) == null)
                return null;
            return isChild(value, root, null);
        }

        private calificacion<T> isChild(T value, calificacion<T> root, calificacion<T> papu) {
            if (root != null) {
                if (root.getValue().equals(value))
                    return papu;
                if (root.getValue().compareTo(value) <= -1)
                    return isChild(value, root.getRight(), root);
                else
                    return isChild(value, root.getLeft(), root);
            } else
                return null;
        }

        public boolean isEmpty() {
            return (root == null);
        }

        public calificacion<T> DeepSearch(T value) {
            return DeepSearch(value, root);
        }

        private calificacion<T> DeepSearch(T value, calificacion<T> root) {
            if (root != null) {
                if (root.getValue().equals(value))
                    return root;
                if (root.getValue().compareTo(value) <= -1)
                    return DeepSearch(value, root.getRight());
                else
                    return DeepSearch(value, root.getLeft());
            } else
                return null;
        }

        public calificacion<T> breadthSearch(T value) throws Exception {
            int h = height(root);
            int i;
            cola = new tqueue<calificacion<T>>(size);
            for (i = 1; i <= h; i++)
                breadthSearch(root, i);
            while (!cola.isEmpty()) {
                if (cola.front().getValue().equals(value))
                    return cola.deQueue();
                else
                    cola.deQueue();
            }
            return null;
        }

        private void breadthSearch(calificacion<T> root, int level) throws Exception {
            if (root == null)
                return;
            if (level == 1)
                cola.enQueue(root);
            else if (level > 1) {
                breadthSearch(root.getLeft(), level - 1);
                breadthSearch(root.getRight(), level - 1);
            }
        }

        private calificacion<T> MinSearch(calificacion<T> root) {
            while (root.getLeft() != null)
                root = root.getLeft();
            return root;
        }

        private calificacion<T> MaxSearch(calificacion<T> root) {
            while (root.getRight() != null)
                root = root.getRight();
            return root;
        }

        public int height(calificacion<T> root) {
            if (root == null)
                return 0;
            else {
                int lheight = height(root.getLeft());
                int rheight = height(root.getRight());

                if (lheight > rheight)
                    return (lheight + 1);
                else return (rheight + 1);
            }
        }

        public int MaxDepth() {
            return height(root) - 1;
        }

        public void Clear() {
            Clear(root);
            this.root = null;
        }

        private void Clear(calificacion<T> root) {
            if (root != null) {
                Clear(root.getLeft());
                Clear(root.getRight());
                root.setLeft(null);
                root.setRight(null);
            }
        }

        private boolean exists(T value) {
            return (DeepSearch(value) != null);
        }

        @Override
        public int compareTo(T o) {
            return 0;
        }
    }
}
