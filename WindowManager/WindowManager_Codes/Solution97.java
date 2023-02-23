import java.util.*;


public class Solution97 {

    public static WindowManager97 wm;
    public static ConfigManager97 config;
    public static ArrayList<Item97> components;

   public static void main(String[] args) {
        components = new ArrayList<Item97>();

        System.out.println("Choose your input file :");
        System.out.println("1. Text File.");
        System.out.println("2. XML File.");

        

        Scanner scanner = new Scanner(System.in);
        int fileType = scanner.nextInt();
        
        System.out.println("Choose your UI style :");
        System.out.println("1. Simple");
        System.out.println("2. High Detailed");

        int UIType = scanner.nextInt();

        if(fileType == 1){
            config = new ConfigManager97(components);
        }
        else if(fileType == 2){
            config = new XMLConfigManager97(components);
        }

        
        WindowManager97.getInstance().loadUI(config, UIType);

    }
    
}
