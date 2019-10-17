package spring.intro.entities.enums;

public enum Edition {
    NORMAL("N"),
    PROMO("P"),
    GOLD("G");

    private String code;

    private Edition(String code){
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
