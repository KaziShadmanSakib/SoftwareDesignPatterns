import javax.swing.JButton;

public class ButtonAdapter97 {
    private String value;
    private int X;
    private int Y;
    private int height;
    private int width;

    public ButtonAdapter97(){
        
    }

    public ButtonAdapter97(String value, int X, int Y, int height, int width){
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

    public JButton buildButton(){
        JButton button = new JButton();
        button.setText(this.value);
        button.setBounds(this.X, this.Y, this.width, this.height);
        return button;
    }
    
}
