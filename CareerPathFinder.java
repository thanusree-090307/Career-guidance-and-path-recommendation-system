package P1;

class CareerPathFinder
{
    int v;
    int[][] adjmat;
    boolean[] varr;

    CareerPathFinder(int v)
    {
        this.v = v;
        adjmat = new int[v][v];
        varr = new boolean[v];
    }

    public void BFSProcedure(int start)
    {
    	for(int i=0;i<v;i++)
        {
            varr[i] = false;
        }
    	
        String careers[] = {
            "Web Developer",
            "Software Developer",
            "Data Analyst",
            "Data Engineer",
            "AI Engineer"
        };

        int[] q = new int[v];

        int front = 0;
        int rear = 0;

        varr[start] = true;

        q[rear++] = start;

        System.out.println("Career Path:");

        while(front < rear)
        {
            int node = q[front++];

            System.out.print(careers[node] + " --> ");

            for(int i=0;i<v;i++)
            {
                if(adjmat[node][i]==1 && !varr[i])
                {
                    varr[i]=true;
                    q[rear++]=i;
                }
            }
        }

        System.out.println();
    }
}
