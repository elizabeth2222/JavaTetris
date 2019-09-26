
public class Grid {
    public Unit unitCell;
    public int color;
    public String name;
    
    public Grid(String n) {
	//unitCell = null;
	color = 0;
	name = n;
	
    }
    
    public String toString() {
	if(color ==0) {
	    return name;
	}
	
	return Integer.toString(color);
    }
    
    public void setColor(int color) {
	this.color = color;
    }
}
