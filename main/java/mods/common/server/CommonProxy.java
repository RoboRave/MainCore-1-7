package mods.common.server;

public abstract class CommonProxy 
{

	public abstract void Load();
	public abstract void log(String par1);
	
	public void logClient(String par1)
	{
		System.out.print("MainCore-All: "+par1);
		
	}
}
