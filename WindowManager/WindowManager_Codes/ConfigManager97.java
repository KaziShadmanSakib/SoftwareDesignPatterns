import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class ConfigManager97 {
    private ArrayList<Item97> components = new ArrayList<Item97>();

    public ConfigManager97(ArrayList<Item97> components){
        this.components = components;
    }
    
    public ArrayList<Item97> parseFile() throws FileNotFoundException{
        Item97 component;
        File textFile = new File("C:\\Users\\Asus\\IdeaProjects\\Assignment03_SDP\\src\\formatTXT97.txt");
        Scanner scan = new Scanner(textFile);
        while(scan.hasNextLine()){
            String[] tempString = scan.nextLine().split(",");
            for(int i = 0; i< tempString.length; i++){
                if(i > 1){
                    tempString[i] = tempString[i].split(":")[1];
                }
                
            }
            component = new Item97(tempString[0], tempString[1], Integer.parseInt(tempString[2]), Integer.parseInt(tempString[3]), Integer.parseInt(tempString[4]), Integer.parseInt(tempString[5]),tempString[6], Integer.parseInt(tempString[7]));
            this.components.add(component);
            
            
        }
        scan.close();
        

        return this.components;
    }
    
}
