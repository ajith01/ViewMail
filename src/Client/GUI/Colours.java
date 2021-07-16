package Client.GUI;

public enum Colours {
    Light,
    Default,
    Dark;

    public static String getCSSPath(Colours colour){
        switch(colour){
            case Light:
                return "CSS/lightTheme.css";
            case Default:
                return "CSS/defaultTheme.css";
            case Dark:
                return "CSS/darkTheme.css";
            default:
                return null;
        }
    }
}
