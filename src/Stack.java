public class Stack<T> {
    Node<T> head = null;

    public Stack() {
    }

    public T peek() {
        if (this.head == null) {
            throw new RuntimeException("Não é possível espiar o elemento para uma pilha vazia");
        }

        return this.head.getData();
    }

    public void push(T data) {
        this.head = new Node<>(data, this.head);
    }

    public void pop() {
        if (this.head == null) {
            throw new RuntimeException("Não é possível remover o elemento de uma pilha vazia");
        }
        this.head = this.head.getPrevious();
    }
    public boolean empty() {
        if (this.head == null) {
            return head == null;
        }
        return false;
    }
}

