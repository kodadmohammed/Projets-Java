
public class Commande {
    private int num�roC;
	private int quantite;
	private double total;
	Produit p=new Produit();
	
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public Produit getP() {
		return p;
	}
	public int getNum�roC() {
		return num�roC;
	}
	public void setNum�roC(int num�roC) {
		this.num�roC = num�roC;
	}
	public void setP(Produit p) {
		this.p = p;
	}
	public Commande(int num�roC, int quantite, double total, Produit p) {
		this.num�roC = num�roC;
		this.quantite = quantite;
		this.total = total;
		this.p = p;
	}
	public Commande() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Commande [num�roC=" + num�roC + ", quantite=" + quantite + ", total=" + total + ", p=" + p + "]";
	}
	
	
	
	
}
