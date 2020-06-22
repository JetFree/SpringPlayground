import java.util.Arrays;
import java.util.Random;

public class RandomFortuneService implements FortuneService {
    @Override
    public String getFortune() {
        Random random = new Random();
        return Arrays.asList("Nice day!", "Bad luck!", "Stars say yes!").get(random.nextInt(3));
    }
}
