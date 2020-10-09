package config;

import music.ClassicMusic;
import music.JazMusic;
import music.PopMusic;
import music.RockMusic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("music")
@PropertySource("classpath:beans.properties")
public class ApplicationConfig {

    @Bean
    public ClassicMusic classicMusic(){
        return new ClassicMusic();
    }
    @Bean
    public JazMusic jazMusic(){ return new JazMusic(); }
    @Bean
    public PopMusic popMusic(){
        return new PopMusic();
    }
    @Bean
    public RockMusic rockMusic(){
        return new RockMusic();
    }
}
