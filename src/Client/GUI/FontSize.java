package Client.GUI;

public enum FontSize {
    Small,
    Medium,
    Large;

    public static String getCSSPath(FontSize font){
        switch(font){
            case Small:
                return "CSS/smallFont.css";
            case Medium:
                return "CSS/mediumFont.css";
            case Large:
                return "CSS/bigFont.css";
            default:
                return null;
        }
    }
}
