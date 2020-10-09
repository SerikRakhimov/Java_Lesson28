package music;

//import music.Music;

import org.springframework.stereotype.Component;

@Component
public class JazMusic implements Music {
    @Override
    public String song() {
        return "He song Jaz Music";
    }
}


