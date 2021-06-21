package aquarium;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AquariumTests {
    private Aquarium aquarium;
    private Fish fish;
    private String name;
    @Before
    public void setUp(){
        name = "TestName";
        this.aquarium = new Aquarium("test_name", 1);
        this.fish = new Fish(name);
        this.aquarium.add(fish);

    }
    @Test(expected = NullPointerException.class)
    public void testNameSet(){
        new Aquarium(" ", 5);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testSetCapacity(){
        new Aquarium("test", -1);

    }
    @Test(expected = IllegalArgumentException.class)
    public void testAdd(){
        aquarium.add(fish);
        aquarium.add(fish);
    }
    @Test
    public void testAddIfAdded(){
        aquarium.add(fish);
        Assert.assertEquals(aquarium.getCapacity(), 1);
    }
    @Test
    public void testRemove(){
        aquarium.remove(this.name);
        Assert.assertEquals(1, aquarium.getCapacity());
    }


}

