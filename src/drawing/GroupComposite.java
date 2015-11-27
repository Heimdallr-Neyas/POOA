package drawing;
import java.awt.Point;
import java.util.Iterator;
import java.util.Vector;

public class GroupComposite implements GroupInterface, Iterable<GroupInterface>{
	  //Collection de graphiques enfants.
    private Vector<GroupInterface> mChildFigures = new Vector<GroupInterface>();
    Point origin;
    public GroupComposite(){
    	origin = new Point();
    }
    
    //Ajoute le graphique à la composition.
    public void add(GroupInterface figure) {
        mChildFigures.add(figure);
    }

    //Retire le graphique de la composition.
    public void remove(GroupInterface figure) {
        mChildFigures.remove(figure);
    }
    
  //Vide la composition.
    public void removeAll() {
        mChildFigures.clear();
    }
    
    //Vide la composition.
    public boolean contain(GroupInterface s) {
        return mChildFigures.contains(s);
    }
    
    //Vide la composition.
    public boolean empty() {
        return mChildFigures.isEmpty();
    }
    
    /**
	 * Impl�mentation de l'interface Iterable<GroupInterface>
	 */
	public Iterator<GroupInterface> iterator(){
		return mChildFigures.iterator();
	}
	
	public void setOrigin(Point p){
		System.out.println("Erreur setOrigin");
		origin = p;
	}
	
	public Point getPoint(){
		System.out.println("Erreur getPoint");
		return origin;
	}
	
}