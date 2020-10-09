package music;

import org.springframework.stereotype.Component;

public class ClassicMusic implements Music {

    @Override
    public String song() {
        return "He song Classic Music";
    }
}
