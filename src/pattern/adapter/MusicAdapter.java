package pattern.adapter;

public class MusicAdapter {
    private MediaPlayer mediaPlayer;
    private AdvancedMediaPlayer advancedMediaPlayer;

    public MusicAdapter(MediaPlayer mediaPlayer, AdvancedMediaPlayer advancedMediaPlayer) {
        this.mediaPlayer = mediaPlayer;
        this.advancedMediaPlayer = advancedMediaPlayer;
    }

    public void play(String type, String fileSource) {
        if (type.equals("mp3")) {
            mediaPlayer.playMP3(fileSource);
        } else if (type.equals("vlc")) {
            advancedMediaPlayer.playVlc(fileSource);
        } else if (type.equals("mp4")) {
            advancedMediaPlayer.playMp4(fileSource);
        } else {
            System.out.println("您输入的格式不支持");
        }
    }
}

interface MediaPlayer {
    void playMP3(String fileName);
}

class Mp3Impl implements MediaPlayer {
    public void playMP3(String fileName) {
        System.out.println(fileName + "正在播放");
    }
}

interface AdvancedMediaPlayer {
    void playMp4(String fileName);

    void playVlc(String fileName);
}

class VlcMp4Impl implements AdvancedMediaPlayer {
    @Override
    public void playMp4(String fileName) {
        System.out.println(fileName + "正在播放");
    }

    @Override
    public void playVlc(String fileName) {
        System.out.println(fileName + "正在播放");
    }
}

class Demo {
    public static void main(String[] args) {
        MusicAdapter musicAdapter = new MusicAdapter(new Mp3Impl(), new VlcMp4Impl());
        musicAdapter.play("mp3", "鸡.mp3");
        musicAdapter.play("vlc", "你.vlc");
        musicAdapter.play("mp4", "太.mp4");
    }
}
