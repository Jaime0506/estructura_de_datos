package tree;

import java.awt.Canvas; 
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.HashMap;
import java.util.Map;

public class TreeCanvas extends Canvas {
    private BinaryTree<?> tree;
    private Map<Node<?>, Point> nodePositions;
    private int canvasWidth;

    /**
     * Create the panel.
     */
    public TreeCanvas(int canvasWidth, int canvasHeight) {
        this.nodePositions = new HashMap<>();
        this.canvasWidth = canvasWidth;
    }

    public void setTree(BinaryTree<?> tree) {
        this.tree = tree;
    }

    private void calculateNodePositions(Node<?> node, int x, int y, int xOffset, int depth) {
        if (node == null) {
            return;
        }

        Point position = new Point(x, y);
        nodePositions.put(node, position);

        int horizontalSpacing = 50; // Espacio horizontal entre nodos
        int verticalSpacing = 100;

        if (node.left != null) {
            int leftX = x - xOffset;
            calculateNodePositions(node.left, leftX - horizontalSpacing, y + verticalSpacing, xOffset / 2, depth - 1);
        }

        if (node.right != null) {
            int rightX = x + xOffset;
            calculateNodePositions(node.right, rightX + horizontalSpacing, y + verticalSpacing, xOffset / 2, depth - 1);
        }
    }

    private void drawTree(Graphics g, Node<?> node) {
        if (node == null) {
            return;
        }

        Point position = nodePositions.get(node);

        if (position != null) {
            g.setColor(Color.BLACK);
            g.fillOval(position.x - 20, position.y - 20, 40, 40);
            g.setColor(Color.WHITE);
            g.drawString(String.valueOf(node.data), position.x - 10, position.y + 5);

            if (node.left != null) {
                Point leftPosition = nodePositions.get(node.left);
                g.setColor(Color.BLACK);
                g.drawLine(position.x, position.y, leftPosition.x, leftPosition.y);
                drawTree(g, node.left);
            }

            if (node.right != null) {
                Point rightPosition = nodePositions.get(node.right);
                g.setColor(Color.BLACK);
                g.drawLine(position.x, position.y, rightPosition.x, rightPosition.y);
                drawTree(g, node.right);
            }
        }
    }

    private int calculateDepth(Node<?> node) {
        if (node == null) {
            return 0;
        }

        int leftDepth = calculateDepth(node.left);
        int rightDepth = calculateDepth(node.right);

        return Math.max(leftDepth, rightDepth) + 1;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if (tree != null) {
            int startX = canvasWidth / 2;
            int startY = 50;
            calculateNodePositions(tree.root, startX, startY, 200, calculateDepth(tree.root));

            drawTree(g, tree.root);
        }
    }
}
