import java.awt.Font;

import javax.swing.JLabel;

public class DetailedLabelAdapter97 extends LabelAdapter97 {
    private String font;
    private int fontSize;

    public DetailedLabelAdapter97(String value, int X, int Y, int height, int width, String font, int fontSize){
        super(value,X,Y,height,width);
        this.font = font;
        this.fontSize = fontSize;
        
    }

    public JLabel buildLabel(){
        JLabel label = new JLabel();
        label.setText(super.getValue());
        label.setBounds(super.getX(), super.getY(), super.getWidth(), super.getHeight());
        Font f = new Font(this.font,Font.PLAIN,this.fontSize);
        label.setFont(f);
        return label;
    }
    
}
