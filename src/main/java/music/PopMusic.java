package music;


import org.springframework.stereotype.Component;

@Component
public class PopMusic implements Music {

    @Override
    public String song() {
        return "He song Pop Music";
    }
}
