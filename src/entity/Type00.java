package entity;


public enum Type00 {
    FIGURE(1, "人物"),
    ARMS(2, "武器"),
    ;

    private Integer value;
    private String message;
    Type00(Integer value, String message) {
        this.value = value;
        this.message = message;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
