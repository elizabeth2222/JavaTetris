
public class Unit {
    int color;
    boolean stacked;
    Vector2 pos;
    
    public Unit(int col, Vector2 pos) {
	color = col;
	this.pos = pos;
    }
    
    public String toString() {
	return Integer.toString(color);
    }
    
    public void setPos(int move) {
	if(move == 1) {
	    this.pos.y -=1;
	} else if(move == 3) {
	    this.pos.y +=1;
	} else if(move == 2) {
	    this.pos.x +=1;
	}
    }

}
