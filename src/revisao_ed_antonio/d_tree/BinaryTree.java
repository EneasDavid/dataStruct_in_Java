package revisao_ed_antonio.d_tree;

import java.util.Objects;

public class BinaryTree {
  protected Node root;

  public enum Side {
    LEFT,
    RIGHT
  }

  // Insere a raiz na árvore
  public Node insertRoot(int value) {
    if (root != null) {
      throw new IllegalStateException("Root already defined");
    }
    root = new Node(value);
    return root;
  }

  // Insere um nó à esquerda ou à direita de um nó pai
  public Node insertNode(int value, Node parent, Side side) {
    Objects.requireNonNull(parent);
    Node node = new Node(value);
    node.parent = parent;

    switch (side) {
      case LEFT -> {
        if (parent.left != null) {
          node.left = parent.left;
          node.left.parent = node;
        }
        parent.left = node;
      }
      case RIGHT -> {
        if (parent.right != null) {
          node.right = parent.right;
          node.right.parent = node;
        }
        parent.right = node;
      }
      default -> throw new IllegalStateException();
    }
    return node;
  }

  // Deleta um nó da árvore
  public void deleteNode(Node node) {
    if (node.parent == null && node != root) {
      throw new IllegalStateException("Node has no parent and is not root");
    }

    if (node.left == null && node.right == null) {
      setParentsChild(node, null);
    } else if (node.right == null) {
      setParentsChild(node, node.left);
    } else if (node.left == null) {
      setParentsChild(node, node.right);
    } else {
      removeNodeWithTwoChildren(node);
    }

    node.parent = null;
    node.left = null;
    node.right = null;
  }

  // Remove um nó com dois filhos
  private void removeNodeWithTwoChildren(Node node) {
    Node leftTree = node.left;
    Node rightTree = node.right;

    setParentsChild(node, leftTree);

    Node rightMostChildOfLeftTree = leftTree;
    while (rightMostChildOfLeftTree.right != null) {
      rightMostChildOfLeftTree = rightMostChildOfLeftTree.right;
    }

    rightMostChildOfLeftTree.right = rightTree;
    rightTree.parent = rightMostChildOfLeftTree;
  }

  // Atribui o filho ao nó pai
  private void setParentsChild(Node node, Node child) {
    if (node == root) {
      root = child;
      if (child != null) {
        child.parent = null;
      }
      return;
    }

    if (node.parent.left == node) {
      node.parent.left = child;
    } else if (node.parent.right == node) {
      node.parent.right = child;
    } else {
      throw new IllegalStateException(
          "Node "
              + node.data
              + " is neither a left nor a right child of its parent "
              + node.parent.data);
    }

    if (child != null) {
      child.parent = node.parent;
    }
  }

  // Retorna a raiz da árvore
  public Node getRoot() {
    return root;
  }

  // Converte a árvore em uma string (visualização)
  public String toString() {
    StringBuilder builder = new StringBuilder();
    appendNodeToStringRecursive(getRoot(), builder);
    return builder.toString();
  }

  // Método auxiliar para formatação da string
  private void appendNodeToStringRecursive(Node node, StringBuilder builder) {
    appendNodeToString(node, builder);
    if (node.left != null) {
      builder.append(" L{");
      appendNodeToStringRecursive(node.left, builder);
      builder.append('}');
    }
    if (node.right != null) {
      builder.append(" R{");
      appendNodeToStringRecursive(node.right, builder);
      builder.append('}');
    }
  }

  // Adiciona a representação do nó à string
  protected void appendNodeToString(Node node, StringBuilder builder) {
    builder.append(node.data);
  }

  // Impressão em pré-ordem (Raiz, Esquerda, Direita)
  public void printPreOrder(Node node) {
    if (node != null) {
      System.out.print(node.data + " ");
      printPreOrder(node.left);
      printPreOrder(node.right);
    }
  }

  // Impressão em ordem (Esquerda, Raiz, Direita)
  public void printInOrder(Node node) {
    if (node != null) {
      printInOrder(node.left);
      System.out.print(node.data + " ");
      printInOrder(node.right);
    }
  }

  // Impressão em pós-ordem (Esquerda, Direita, Raiz)
  public void printPostOrder(Node node) {
    if (node != null) {
      printPostOrder(node.left);
      printPostOrder(node.right);
      System.out.print(node.data + " ");
    }
  }
}