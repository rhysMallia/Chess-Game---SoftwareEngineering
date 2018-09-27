import java.io.*;
import java.util.*;

public class PlayerDatabase {

	
		private static ArrayList<Player> players=new ArrayList<Player>(); 
		private static int numPlayers = 0;
		private static String fileName = "players.txt";
		
		public static void savePlayers() throws IOException {
            PrintWriter output = null;
            
            try {
                
                output = new PrintWriter(new FileOutputStream(fileName));
                
                for (int i = 0; i < players.size() && players.get(i) != null; i++) {
                    
                    output.println(players.get(i).getName() + "," + players.get(i).getPassword());
                }   
            } catch (FileNotFoundException e) {
                System.out.println(e);
            }
            output.close();
        }
        
        public static void loadPlayers() throws IOException {
            
            try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    
                    Scanner scanner = new Scanner(line).useDelimiter(",");
                    if (scanner.hasNext()) {
                        String name = scanner.next();
                        String password = scanner.next();
                        
                        players.add(new Player(name, password));
                    }
                }
            } catch (IOException e) {
                
            }
            
            
                
        }
		public static ArrayList<Player> getPlayers() {
			return players;
		}
		
		public static int getNumPlayers() {
			return numPlayers;
		}
		
		public static void decrementNumPlayers() {
			numPlayers--;
		}
		
		public static boolean registerPlayer(String playerName, String playerPassword) {
			boolean playerNameDuplicate = false;
			boolean regOk = false;
			
			if(players.isEmpty()){
		        Player temp = new Player(playerName,playerPassword);
	            players.add (temp);
	            regOk = true;
			} else {
				for(int i = 0; i < players.size(); i++) {
				    
					if((playerName.equals(players.get(i).getName()))) {
					    
						playerNameDuplicate = true;
						break;	
					}	
				}
				
				if(!playerNameDuplicate) {
					Player temp = new Player(playerName,playerPassword);
					players.add (temp);
					regOk = true;
				} else {
					System.out.println("Name has already been used. Use a different name!");
				}
			}
			
			return regOk;
			
		}
		
		public static boolean playerLogin(String playerName, String playerPassword) {
			   
			boolean success = false;
			boolean duplicate = false;
			
			for(int i = 0; i < players.size(); i++) {
			    
				if((players.get(i).getName()).equals(playerName) && 
				        (players.get(i).getPassword()).equals(playerPassword) 
				        && !(players.get(i).getLoggedIn())) {
					players.get(i).setLoggedIn(true);
					numPlayers++;
					System.out.printf("%s has logged in!\n", players.get(i).getName());
					success = true;
					break;
				} else if((players.get(i).getName()).equals(playerName) && 
				        (players.get(i).getPassword()).equals(playerPassword) 
				        && (players.get(i).getLoggedIn())) {
					System.out.printf("%s is already logged in!\n", players.get(i).getName());
					duplicate = true;
					break;
				} 
			}
			
			if(!success && !duplicate) {
				System.out.println("Name or password is incorrect!");
			}
			
			return success; 
		}
}
