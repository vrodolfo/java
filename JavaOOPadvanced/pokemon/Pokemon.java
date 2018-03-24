public class Pokemon{
    // your code here
    private int health;
    private String name;
    private String type;
    private static int count = 0;

    public Pokemon(){
    	this.health = 0;
    	this.name = "";
    	this.type = "";
        count++;
    }

    public Pokemon(int health, String name, String type){
    	this.health = health;
    	this.name = name;
    	this.type = type;
        count++;
    }

    public void setHealth(int health){
    	this.health = health;
    }
    public int getHealth(){
    	return health;
    }

    public void setName(String name){
    	this.name = name;
    }
    public String getName(){
    	return name;
    }

    public void setType(String type){
    	this.type = type;
    }
    public String getType(){
    	return type;
    }

    public int getCount(){
    	return count;
    }

}
