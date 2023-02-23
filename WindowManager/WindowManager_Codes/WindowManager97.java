import java.io.FileNotFoundException;
import java.util.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class WindowManager97 extends JFrame{

   // private Container container;
   private static WindowManager97 instance = null;

    private WindowManager97(){
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       setSize(900, 600);
       setLayout(null);
       
        

    }
    
    public static WindowManager97 getInstance(){
        if(instance == null){
            instance = new WindowManager97();
        }
        return instance;
    }
    
    public void loadUI(ConfigManager97 config , int UIType){

        ArrayList<Item97> components = new ArrayList<Item97>();
        
        
        try{
            components = config.parseFile();
            

        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
        
        String tempLabel = new String();
        tempLabel = components.get(1).getName();
        String tempButton = new String();
        tempButton = components.get(0).getName();
        for(int i = 0 ; i < components.size(); i++){
            if(components.get(i).getName() == tempLabel){
                LabelAdapter97 labelBuilder = new LabelAdapter97();
                if(UIType == 1){
                    labelBuilder = new LabelAdapter97(components.get(1).getValue(),components.get(1).getX(), components.get(1).getY(), components.get(1).getWidth(), components.get(1).getHeight());
                }
                else if( UIType == 2){
                    labelBuilder = new DetailedLabelAdapter97(components.get(i).getValue(),components.get(i).getX(), components.get(i).getY(), components.get(i).getWidth(), components.get(i).getHeight(), components.get(i).getFont(), components.get(i).getFontSize());
                }
                
                JLabel label = labelBuilder.buildLabel();
                this.getContentPane().add(label);
            }
            else if(components.get(i).getName() == tempButton){
                ButtonAdapter97 buttonBuilder = new ButtonAdapter97();
                if(UIType == 1){
                    buttonBuilder = new ButtonAdapter97(components.get(0).getValue(), components.get(0).getX(), components.get(0).getY(), components.get(0).getHeight(), components.get(0).getWidth());
                }
                else if(UIType == 2){
                    buttonBuilder = new DetailedButtonAdapter97(components.get(i).getValue(), components.get(i).getX(), components.get(i).getY(), components.get(i).getHeight(), components.get(i).getWidth(), components.get(i).getFont(), components.get(i).getFontSize());
                }
                JButton button = buttonBuilder.buildButton();
                this.getContentPane().add(button);
            }
        }
        this.setVisible(true);
    }
    
}
