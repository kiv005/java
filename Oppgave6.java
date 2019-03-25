package INF100_17H;

public class Oppgave6{
  
  public static void main(String[] args){
    Pokemon pokemon1 = new Pokemon("Pikachu");
    Pokemon pokemon2 = new Pokemon("Charmander");
       
    System.out.println(pokemon1.toString() + "\n" + pokemon2.toString());
    
    while(pokemon1.isConscious() && pokemon2.isConscious()){
      pokemon1.attack(pokemon2);
      if(pokemon2.isConscious()){
        pokemon2.attack(pokemon1);
      }
    }    
  }

/*  
                                  ,'\
    _.----.        ____         ,'  _\   ___    ___     ____
_,-'       `.     |    |  /`.   \,-'    |   \  /   |   |    \  |`.
\      __    \    '-.  | /   `.  ___    |    \/    |   '-.   \ |  |
 \.    \ \   |  __  |  |/    ,','_  `.  |          | __  |    \|  |
   \    \/   /,' _`.|      ,' / / / /   |          ,' _`.|     |  |
    \     ,-'/  /   \    ,'   | \/ / ,`.|         /  /   \  |     |
     \    \ |   \_/  |   `-.  \    `'  /|  |    ||   \_/  | |\    |
      \    \ \      /       `-.`.___,-' |  |\  /| \      /  | |   |
       \    \ `.__,'|  |`-._    `|      |__| \/ |  `.__,'|  | |   |
        \_.-'       |__|    `-._ |              '-.|     '-.| |   |
                                `'                            '-._|  
*/  
} 

  

