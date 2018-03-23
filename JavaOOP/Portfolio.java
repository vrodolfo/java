import java.util.*;

public class Portfolio{
	private List<Project> projects;

	public Portfolio(){
		projects = new ArrayList<>();
	}

	public Portfolio(List<Project> projects){
		this.projects = projects;
	}
	
	public List<Project> getProjects(){
		return projects;
	}

	public void addProject(Project project){
		projects.add(project);
	}

	public int getPortfolioCost(){
		//loop projects a sum costs
		int sum = 0;
		for(int i=0; i< projects.size() ; i++){
			sum += projects.get(i).getInitialCost();
		}
		return sum;
	}

	
	public void showPortfolio(){
		for(int i=0; i< projects.size() ; i++){
			System.out.println("Name: " + projects.get(i).getName()+", Cost: "+projects.get(i).getInitialCost() +", Desc: " + projects.get(i).getDesc());
		}

	}


}