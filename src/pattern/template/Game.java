package pattern.template;

/**
 * 模版模式
 */
public abstract class Game {
    //抽象出共有方法，具体实现不一样
    abstract void initialize();
    abstract void startPlay();
    abstract void endPlay();

    //模版代码
    public final void play() {
        initialize();  //初始化游戏
        startPlay();   //开始游戏
        endPlay();   //结束游戏
    }
}

class FootballGame extends Game {
    @Override
    void initialize() {
        System.out.println("FootballGame initializing...");
    }

    @Override
    void startPlay() {
        System.out.println("FootballGame starting...");
    }

    @Override
    void endPlay() {
        System.out.println("FootballGame ending...");
    }
}

class LOLGame extends Game {
    @Override
    void initialize() {
        System.out.println("LOLGame initializing...");
    }

    @Override
    void startPlay() {
        System.out.println("LOLGame starting...");
    }

    @Override
    void endPlay() {
        System.out.println("LOLGame ending...");
    }
}

class Demo {
    public static void main(String[] args) {
        Game footballGame = new FootballGame();
        footballGame.play();
        Game lol = new LOLGame();
        lol.play();
    }
}