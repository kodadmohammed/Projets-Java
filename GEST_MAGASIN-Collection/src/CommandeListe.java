import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class CommandeListe {

	private Map<Integer,Commande> liste=new HashMap<>();
	
	public void add(Commande c){
		
		liste.put(c.getNum�roC(), c);
		
	}

	public void Delete(int num�roC){
		liste.remove(num�roC);
	}

	public void Update(Commande c){
		if(liste.containsKey(c.getNum�roC())){
			liste.put(c.getNum�roC(), c);
		}
	}
	public Collection<Commande> getAllCommande(){
		
		return liste.values();
	}
	public Commande getOneCommande(int num�roC){
		return liste.get(num�roC);
	}
	
	
}
