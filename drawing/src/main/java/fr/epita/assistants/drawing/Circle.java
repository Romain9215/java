package fr.epita.assistants.drawing;

public class Circle extends Entity{

    private int radius;
    public Circle(int radius)
    {
        this.radius = radius;
    }

    public void draw()
    {
        for (int i = -radius; i <= radius; i++) {
            for (int j = -radius; j <= radius; j++) {
                int x = Math.abs(radius * radius - (j * j + i * i));
                if (x < radius) {
                    System.out.print("#");
                } else {
                    System.out.print(" ");
                }
                if (j < radius) {
                    System.out.print(" ");
                }
            }
            if (i < radius) {
                System.out.println();
            }
        }
    }


}
