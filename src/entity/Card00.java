package entity;


public class Card00 {
    private String name;
    private Level00 level00;
    private Type00 type00;
    private Integer isTop = 0;

    public Card00() {

    }

    public Card00(String name, Level00 level00, Type00 type00) {
        this.name = name;
        this.level00 = level00;
        this.type00 = type00;
    }

    public Card00(String name, Level00 level00, Type00 type00, Integer isTop) {
        this.name = name;
        this.level00 = level00;
        this.type00 = type00;
        this.isTop = isTop;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Level00 getLevel() {
        return level00;
    }

    public void setLevel(Level00 level00) {
        this.level00 = level00;
    }

    public Type00 getType() {
        return type00;
    }

    public void setType(Type00 type00) {
        this.type00 = type00;
    }

    public Integer getIsTop() {
        return isTop;
    }

    public void setIsTop(Integer isTop) {
        this.isTop = isTop;
    }
}
