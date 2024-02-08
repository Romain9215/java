package fr.epita.assistants.drawing;

import lombok.Getter;

public class Entity implements IDrawable{

    private long id;
     private long SEQUENCE = 0;
    public Entity()
    {
        SEQUENCE++;
        id = SEQUENCE;
    }

    public long getId()
    {
        return id;
    }

    public void draw()
    {

    }


}
