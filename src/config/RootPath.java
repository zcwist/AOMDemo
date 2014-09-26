package config;

public class RootPath {
	private static RootPath rootPath;
	private String root;
	RootPath(){
		
	}
	public static RootPath getInstance(){
		if (rootPath == null){
			rootPath = new RootPath();
		}
		return rootPath;
	}
	
	public String getRoot(){
		return root;
	}
	
	public void setRoot(String root){
		this.root = root;
	}
}
