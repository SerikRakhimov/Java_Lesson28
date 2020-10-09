package music;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Objects;

/**
 * Музыкальный плэер для проигрывания поданного жанра музыки
 * Dependency Injection
 */
@Component
@Scope("prototype")
public class MusicPlayer {
    //объявления поля
    private Music music;

    @Value("${musicPlayer.volume}")
    private String volume;

    @Value("${musicPlayer.power}")
    private Integer power;

    @Value("${musicPlayer.isWorking}")
    private Boolean isWorking;

    private static MusicPlayer musicPlayer;


//    public MusicPlayer(PopMusic popMusic) {
//        this.music = popMusic;
//    }

    /**
     * дефолтный конструктор
     */
    public MusicPlayer() {
    }

    /**
     * Фабричный метод, всегда будет возравщать объект в единственном экземпляре
     * @return MusicPlayer
     */
    public static MusicPlayer getInstance() {

        if (Objects.isNull(musicPlayer)) {
            musicPlayer = new MusicPlayer();
        }
        return musicPlayer;
    }

    /**
     * метод проигрывающий любой жанр музыки
     */
    public void play() {
        System.out.println("MusicPlayer play: " + music.song());
    }


    @Autowired
    @Qualifier("popMusic")
    public void setMusic(Music music)
    {
        this.music = music;
    }






    public void setVolume(String volume) {
        this.volume = volume;
    }

    public void setPower(Integer power) {
        this.power = power;
    }

    /**
     * правильный метод для видимости Springa
     *
     * @param isWorking - рабочий ли музыкальный плэеер
     */
    public void setIsWorking(Boolean isWorking) {
        this.isWorking = isWorking;
    }

    /**
     * нехороший метод, Spring его никогда не увидит
     *
     * @param working - рабочий ли музыкальный плэеер
     */
    public void setWorking(Boolean working) {
        isWorking = working;
    }

    public Music getMusic() {
        return music;
    }

    public String getVolume() {
        return volume;
    }

    public Integer getPower() {
        return power;
    }

    public Boolean getIsWorking() {
        return isWorking;
    }

    @PostConstruct
    public void init() {
        System.out.println("Я инициализируюсь до извлечения меня из контейнера");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Я умираю, перед завершением всего Spring приложения");
    }


}
