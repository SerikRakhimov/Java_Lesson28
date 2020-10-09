package music;

import org.springframework.stereotype.Component;

@Component
public class RockMusic implements Music {

    @Override
    public String song() {
        return "He song Rock Music";
    }
}
