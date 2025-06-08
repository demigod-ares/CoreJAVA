package Threads;


// all are ANSI standard colours
public enum ThreadColor {
    RESET("\u001B[0m"),
    BLACK("\u001B[30m"),
    RED("\u001B[31m"),
    GREEN("\u001B[32m"),
    BLUE("\u001B[34m"),
    PURPLE("\u001B[35m"),
    CYAN("\u001B[36m");

    private final String code;

    ThreadColor(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
