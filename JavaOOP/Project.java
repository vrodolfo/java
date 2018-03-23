public class Project{
	private String name;
	private String desc;
	private int initialCost;

	public Project(){
		this("Default Name", "Default Desc", 0);
	}

	public Project(String name){
		this(name, "Default Desc", 0);
	}


	public Project(String name, String desc, int initialCost){
		this.name = name;
		this.desc = desc;
		this.initialCost = initialCost;
	}

	public void setInitialCost(int initialCost){
		this.initialCost = initialCost;
	}

	public int getInitialCost(){
		return initialCost;
	}

	public void setName(String name){
		this.name = name;
	}

	public void setDesc(String desc){
		this.desc = desc;
	}

	public String getName(){
		return name;
	}

	public String getDesc(){
		return desc;
	}

	public String elevatorPitch(){
		return (name +", "+ desc + ", cost: $" + initialCost);
	}


}