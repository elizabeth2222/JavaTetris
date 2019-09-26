
public class Shape {
    public Vector2 position;
    public Vector2 pivotPoint;
    
    public Unit[] units;
    
    public Shape(int randomShape, Vector2 pos) {
	position = pos; // initial position
	//System.out.println(pos.x + ", " + pos.y);
	
	if(randomShape != 0) {
	    units = new Unit[4];
	    units[0] = new Unit(7, new Vector2(pos.x, pos.y));
	    units[1] = new Unit(7, new Vector2(pos.x+1, pos.y));
	    units[2] = new Unit(7, new Vector2(pos.x+1, pos.y+1));
	    units[3] = new Unit(7, new Vector2(pos.x+2, pos.y+1));
	}
    }
    
    public Vector2 getShapePos() {
	return position;
    }
    
    public Vector2[] getUnitsPos() {
	Vector2[] unitsPos = new Vector2[units.length];
	for(int i =0; i<unitsPos.length; i++) {
	    unitsPos[i] = units[i].pos;
	}
	return unitsPos;
    }

    public void setUnitsPos(int move) {
	for(int i =0; i<units.length; i++) {
	    units[i].setPos(move);
	}
    }
}
