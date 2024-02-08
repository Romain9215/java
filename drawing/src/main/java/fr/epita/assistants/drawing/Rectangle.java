package fr.epita.assistants.drawing;

public class Rectangle extends Sharp{


    private int width;
    public Rectangle(int width, int length)
    {
        super(length);
        this.width = width;
    }

    public void draw()
    {
        for (int i = 0; i < length; i++)
        {
            for (int j = 0; j < width; j++)
            {
                if (i == 0 || i == length - 1 || j == 0 ||j == width - 1)
                {
                    System.out.print("# ");
                }
                else
                {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

}
