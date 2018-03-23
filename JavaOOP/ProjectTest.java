public class ProjectTest{
	public static void main(String[] args){
		Project p1 = new Project();
		Project p2 = new Project("Just Name");
		Project p3 = new Project("Name", " and Desc", 25000);

		Portfolio port = new Portfolio();

		System.out.println(p1.elevatorPitch());
		System.out.println(p2.elevatorPitch());
		System.out.println(p3.elevatorPitch());

		System.out.println(p1.getName());
		System.out.println(p2.getName());
		System.out.println(p3.getName());

		p1.setName("Rodolfo");
		System.out.println(p1.getName());

		port.addProject(p1);
		port.addProject(p2);
		port.addProject(p3);
		System.out.println(port.getPortfolioCost());

		port.showPortfolio();

	}
}