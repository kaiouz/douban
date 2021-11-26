package io.github.kaiouz.douban.user;

public class User {

    /**
     * id
     */
    private String id;

    /**
     * 昵称
     */
    private String nickname;


    public User(String id, String nickname) {
        this.id = id;
        this.nickname = nickname;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
