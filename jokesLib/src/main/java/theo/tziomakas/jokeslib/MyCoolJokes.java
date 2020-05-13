package theo.tziomakas.jokeslib;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.util.Arrays.asList;

public class MyCoolJokes {

    List<String> list = asList(
            "My dog used to chase people on a bike a lot. It got so bad, finally I had to take his bike away.",
            "What is the difference between a snowman and a snowwoman? - Snowballs",
            "My girlfriend says that I am snoopy. But OK, maybe she meant it differently when she wrote it in her diary.",
            "What is see-through and smells of carrots? - A rabbit fart.",
            "Today I found my first grey pubic hair. I got really excited, but not as much as the other people in the lift.",
            "Yes, money cannot buy you happiness, but I’d still feel a lot more comfortable crying in a new BMW than on a bike.",
            "Don’t be sad when a bird craps on your head. Be happy that dogs can’t fly."
    );

    public String getJoke(){
        Random random = new Random();

        String randomJoke = list.get(random.nextInt(list.size()));

        return  randomJoke;
    }

}
