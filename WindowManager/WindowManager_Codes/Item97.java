public class Item97 {
    private String name;
    private String value;
    private int X;
    private int Y;
    private int height;
    private int width;
    private String font;
    private int fontSize;

    public Item97(){
        this.name = "";
        this.value = "";
        this.X = 0;
        this.Y = 0;
        this.height = 0;
        this.width = 0;
    }
    
    public Item97(String name, String value, int X, int Y, int height, int width){
        this.name = name;
        this.value = value;
        this.X = X;
        this.Y = Y;
        this.height = height;
        this.width = width;
    }

    public Item97(String name, String value, int X, int Y, int height, int width, String font, int fontSize){
        this.name = name;
        this.value = value;
        this.X = X;
        this.Y = Y;
        this.height = height;
        this.width = width;
        this.font = font;
        this.fontSize = fontSize;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getValue(){
        return this.value;
    }

    public void setValue(String value){
        this.value = value;
    }

    public int getX(){
        return this.X;
    }

    public void setX(int X){
        this.X = X;
    }

    public int getY(){
        return this.Y;
    }

    public void setY(int Y){
        this.Y = Y;
    }

    public int getHeight(){
        return this.height;
    }
    public void setHeight(int height){
        this.height = height;
    }

    public int getWidth(){
        return this.width;
    }

    public void setWidth(int width){
        this.width = width;
    }

    public String getFont(){
        return this.font;
    }

    public void setFont(String font){
        this.font = font;
    }

    public int getFontSize(){
        return this.fontSize;
    }

    public void setFontSize(int fontSize){
        this.fontSize = fontSize;
    }
    
}
