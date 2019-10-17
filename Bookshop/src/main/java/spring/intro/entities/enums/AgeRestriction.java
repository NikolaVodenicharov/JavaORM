package spring.intro.entities.enums;

public enum AgeRestriction {
    MINOR("M"),
    TEEN("T"),
    ADULT("A");

    private String code;

    private AgeRestriction(String code){
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
