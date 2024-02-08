package fr.epita.assistants.forkjoin;

import java.util.concurrent.RecursiveTask;

public class MyRecursiveTask extends RecursiveTask<Double> {

    final private double[][] matrix;
    final private int xLowerBound;
    final private int xUpperBound;
    final private int yLowerBound;
    final private int yUpperBound;

    public MyRecursiveTask(double[][] matrix, int xLowerBound, int xUpperBound, int yLowerBound, int yUpperBound) {
        this.matrix = matrix;
        this.xLowerBound = xLowerBound;
        this.xUpperBound = xUpperBound;
        this.yLowerBound = yLowerBound;
        this.yUpperBound = yUpperBound;
    }

    @Override
    protected Double compute() {
        if (xUpperBound - xLowerBound <= 5 && yUpperBound - yLowerBound <= 5) {
            double sum = 0.0;
            int count = 0;
            for (int i = xLowerBound; i < xUpperBound; i++) {
                for (int j = yLowerBound; j < yUpperBound; j++) {
                    sum += matrix[j][i];
                    count++;
                }
            }
            return count == 0 ? 0 : sum / count;

        } else {
            int midX = (xLowerBound + xUpperBound) / 2;
            int midY = (yLowerBound + yUpperBound) / 2;
            MyRecursiveTask topLeft = new MyRecursiveTask(matrix, xLowerBound, midX, yLowerBound, midY);
            MyRecursiveTask topRight = new MyRecursiveTask(matrix, xLowerBound, midX, midY, yUpperBound);
            MyRecursiveTask bottomLeft = new MyRecursiveTask(matrix, midX, xUpperBound, yLowerBound, midY);
            MyRecursiveTask bottomRight = new MyRecursiveTask(matrix, midX, xUpperBound, midY, yUpperBound);
            topLeft.fork();
            topRight.fork();
            bottomLeft.fork();
            bottomRight.fork();

            return (topLeft.join() + topRight.join() + bottomLeft.join() + bottomRight.join()) / 4.0;
        }
    }
}
