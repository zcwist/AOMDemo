package config;

import util.XMLUtil;

public abstract class Config implements Updatable{
	protected static XMLUtil xmlUtil;
	public void update(){
		xmlUtil.update();
	}
	

}
