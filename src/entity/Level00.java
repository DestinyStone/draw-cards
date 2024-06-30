package entity;


public enum Level00 {
    LEVEL1(1, "✫", 0.4),
    LEVEL2(2, "✫✫", 0.3),
    LEVEL3(3, "✫✫✫", 0.2),
    LEVEL4(4, "✫✫✫✫", 0.08),
    LEVEL5(5, "✫✫✫✫✫", 0.02)
    ;

    private Integer value;
    private String message;
    private Double probability;

    Level00(Integer value, String message, Double probability) {
        this.value = value;
        this.message = message;
        this.probability = probability;
    }

    public Double getProbability() {
        return probability;
    }

    public void setProbability(Double probability) {
        this.probability = probability;
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
