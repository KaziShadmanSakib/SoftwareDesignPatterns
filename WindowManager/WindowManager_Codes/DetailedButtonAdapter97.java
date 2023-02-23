import java.awt.Font;

import javax.swing.JButton;

public class DetailedButtonAdapter97 extends ButtonAdapter97 {
    private String font;
    private int fontSize;
    

    public DetailedButtonAdapter97(String value, int X, int Y, int height, int width, String font, int fontSize){
        super(value,X,Y,height,width);
        this.font = font;
        this.fontSize = fontSize;
    }

    public JButton buildButton(){
        JButton button = new JButton();
        button.setText(super.getValue());
        button.setBounds(super.getX(), super.getY(), super.getWidth(), super.getHeight());
        Font f = new Font(this.font,Font.PLAIN,this.fontSize);
        //System.out.println("this.font++this.fontSize");
        button.setFont(f);
        return button;
    }

}
