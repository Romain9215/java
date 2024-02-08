package fr.epita.assistants.drawing;

public class Triangle extends Sharp{
    public Triangle(int length)
    {
        super(length);
    }

    public void draw()
    {
        for (int i = 0; i < this.length; i++)
        {
            for (int j = 0; j < this.length; j++)
            {
                if (j == 0)
                {
                    System.out.print("# ");
                    continue;
                }
                if (i == this.length - 1)
                {
                    System.out.print("# ");
                    continue;
                }
                if (j == i)
                {
                    System.out.print("# ");
                }
                System.out.print("  ");
            }
            System.out.println();
        }
    }
}
