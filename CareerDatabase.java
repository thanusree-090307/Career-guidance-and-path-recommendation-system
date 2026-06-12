package P1;
import java.util.ArrayList;
import java.util.Scanner;

class Career{
	String careerName;
	String skill;
	String interest;
	String description;
	
	 Career(String careerName, String skill,String interest, String description) {
		
		this.careerName=careerName;
		this.skill=skill;
		this.interest=interest;
		this.description=description;
		
	}
	void display() {
		System.out.println("----------------------------");
		System.out.println("Career Name: "+careerName);
		System.out.println("Required Skill: "+skill);
		System.out.println("Interest Area: "+interest);
		System.out.println("Description: "+description);
	}
}
public class CareerDatabase {
	
	public static Career linearSearch(ArrayList<Career> c1,String target)
	{
	    for(Career c : c1)
	    {
	        if(c.careerName.equalsIgnoreCase(target))
	        {
	            return c;
	        }
	    }
	    return null;
	}
	
	public static Career binarySearch(ArrayList<Career> c1,String target)
	{
	    int low=0;
	    int high=c1.size()-1;

	    while(low<=high)
	    {
	        int mid=(low+high)/2;

	        int result=
	        c1.get(mid).careerName.compareToIgnoreCase(target);

	        if(result==0)
	        {
	            return c1.get(mid);
	        }
	        else if(result<0)
	        {
	            low=mid+1;
	        }
	        else
	        {
	            high=mid-1;
	        }
	    }
	    return null;
	}
	
	public static void main(String[] args) {
		String choice;
		Scanner sc=new Scanner(System.in);
		ArrayList<Career> c1 = new ArrayList<>();
		CareerPathFinder obj = new CareerPathFinder(5);
		c1.add(new Career("Software Developer","Java","Programming","Develops software applications"));
		c1.add(new Career("Data Analyst","Statistics","Analytics","Analyzes and interprets data"));
		c1.add(new Career("Cyber Security Analyst","Networking","Security","Protects systems from cyber threats"));
		c1.add(new Career("UI/UX Designer","Design","Creativity","Designs user interfaces"));
		c1.add(new Career("Web Developer","HTML","Web Development","Builds websites"));
		
		obj.adjmat[0][1] = 1; 
		obj.adjmat[1][4] = 1; 
		obj.adjmat[2][3] = 1; 
		obj.adjmat[3][4] = 1;
		System.out.println("===========WELCOME TO CAREER GUIDANCE===========\n");
		
		do {
			System.out.println("1.Add career\n2.View career\n3.Search career(Linear)\n4.Career Recommendations\n5.Sort Careers\n6.Search career(Binary)\n7.Compare Search Algorithms\n8.Career Path Finder (BFS)");
			System.out.print("Enter your choice:");
			int opt=sc.nextInt();
			System.out.println("-----------------------------");
			sc.nextLine();
			if(opt==1) {
				System.out.println("Enter following details:");
				String name,skill,inst,des;
				System.out.print("Career Name: ");
				name=sc.nextLine();
				System.out.print("Required Skill: ");
				skill=sc.nextLine();
				System.out.print("Interest Area: ");
				inst=sc.nextLine();
				System.out.print("Description: ");
				des=sc.nextLine();
				c1.add(new Career(name,skill,inst,des));
				System.out.print("Career Added!\n");
			}
			else if(opt==2) {
				for(Career c : c1)
				{
				    c.display();
				    System.out.println();
				}
			}
			else if(opt==3) {
				System.out.print("Enter Career Name to Search: ");
				String sn = sc.nextLine();
				Career result = linearSearch(c1,sn);
				if(result != null)
				{
				    System.out.println("Career Found");
				    result.display();
				}
				else
				{
				    System.out.println("Career Not Found");
				}
			}
			else if(opt==4) {
				System.out.print("Enter Your Skill: ");
				String userSkill = sc.nextLine();

				System.out.print("Enter Your Interest: ");
				String userInterest = sc.nextLine();
				boolean recommended = false;
				for(Career c : c1)
				{
					if(c.skill.equalsIgnoreCase(userSkill)
							   &&
							   c.interest.equalsIgnoreCase(userInterest))
							{
							    System.out.println("\nRecommended Career:");
							    c.display();
							    recommended = true;
							}
				}
				if(!recommended)
				{
				    System.out.println("No Suitable Career Found");
				}
			}
			else if(opt==5)
			{
			    for(int i=0;i<c1.size()-1;i++)
			    {
			        for(int j=0;j<c1.size()-i-1;j++)
			        {
			            if(c1.get(j).careerName.compareToIgnoreCase(
			               c1.get(j+1).careerName) > 0)
			            {
			                Career temp = c1.get(j);
			                c1.set(j, c1.get(j+1));
			                c1.set(j+1, temp);
			            }
			        }
			    }

			    System.out.println("Careers Sorted Successfully!");
			    for(Career c : c1)
			    {
			        c.display();
			        System.out.println();
			    }
			}
			else if(opt==6)
			{
			    boolean sorted = true;

			    for(int i=0;i<c1.size()-1;i++)
			    {
			        if(c1.get(i).careerName.compareToIgnoreCase(
			           c1.get(i+1).careerName) > 0)
			        {
			            sorted = false;
			            break;
			        }
			    }

			    if(!sorted)
			    {
			        System.out.println(
			        "Please sort careers first before using Binary Search.");
			    }
			    else
			    {
			        System.out.print("Enter Career Name to Search: ");
			        String target = sc.nextLine();

			        Career result = binarySearch(c1,target);

			        if(result != null)
			        {
			            System.out.println("Career Found!!");
			            result.display();
			        }
			        else
			        {
			            System.out.println("Career Not Found");
			        }
			    }
			}
			else if(opt==7) {
				System.out.print("Enter Career Name: ");
				String target = sc.nextLine();

				long linearStart = System.nanoTime();
				linearSearch(c1,target);
				long linearEnd = System.nanoTime();

				long binaryStart = System.nanoTime();
				binarySearch(c1,target);
				long binaryEnd = System.nanoTime();

				System.out.println("Linear Search Time: "
				        +(linearEnd-linearStart)+" ns");

				System.out.println("Binary Search Time: "
				        +(binaryEnd-binaryStart)+" ns");
			}
			else if(opt==8) {
				System.out.println("Available Career Paths:");
				    System.out.println("0. Web Developer");
				    System.out.println("1. Software Developer");
				    System.out.println("2. Data Analyst");
				    System.out.println("3. Data Engineer");
				    System.out.println("4. AI Engineer");

				    System.out.print("Choose Starting Career: ");

				    int start = sc.nextInt();

				    obj.BFSProcedure(start);
			}
			System.out.println("Enter yes to continue No to Exit");
			choice=sc.next();
		}while(choice.equalsIgnoreCase("yes"));
		System.out.println("Exiting.......\nExited from the site!!");
	}

}
