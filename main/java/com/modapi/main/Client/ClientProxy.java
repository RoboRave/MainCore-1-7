package com.modapi.main.Client;


public class ClientProxy extends com.modapi.main.Server.CommonProxy{
	//public static Block Test;
	private static final ClientProxy INSTANCE = new ClientProxy();
	//private Block block;
	public static ClientProxy instance()
	{
		return INSTANCE;
	}
	public String getCurrentLanguage() {
		// TODO Auto-generated method stub
		return null;
	}
}