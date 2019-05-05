package MasterMind.Distributed;
public class MasterMindServer {
	
	private GameServer gameServer;
	
	public MasterMindServer() {
		gameServer = new GameServer();
	}           
    
    public void serve() {
    	this.gameServer.serve();
    }
        
    public static void main(String[] args) {
        new MasterMindServer().serve();
    }
}
