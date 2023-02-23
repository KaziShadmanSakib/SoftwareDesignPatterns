import javax.swing.JLabel;

public class LabelAdapter97 {
    private String value;
    private int X;
    private int Y;
    private int height;
    private int width;

    public LabelAdapter97(){
        
    }

    public LabelAdapter97(String value, int X, int Y, int height, int width){
        this.value = value;
        this.X = X;
        this.Y = Y;
        this.height = height;
        this.width = width;
    }

    public String getValue(){
        return this.value;
    }

    public int getX(){
        return this.X;
    }

    public int getY(){
        return this.Y;
    }

    public int getWidth(){
        return this.width;
    }

    public int getHeight(){
        return this.height;
    }

    public JLabel buildLabel(){
        JLabel label = new JLabel();
        label.setText(this.value);
        label.setBounds(this.X, this.Y, this.width, this.height);
        return label;
    }
}
