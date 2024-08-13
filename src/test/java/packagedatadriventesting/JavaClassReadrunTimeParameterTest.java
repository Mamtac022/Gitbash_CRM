package packagedatadriventesting;

public class JavaClassReadrunTimeParameterTest {

	public static void main(String[] args) 
	{
		
		System.out.println(args.length);
		for(String var: args)
		{
			System.out.println(var);
		}
	}

}
