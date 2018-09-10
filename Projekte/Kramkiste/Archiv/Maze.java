package maze;

/**
 *
 * @author JSkopp
 */

public class Maze {

    static int[][] maze = { {2, 6, 12, 12, 10, 6, 10, 4, 12, 10},
                            {5, 9, 6, 8, 5, 9, 5, 12, 10, 3},
                            {6, 8, 7, 12, 12, 14, 8, 6, 9, 3},
                            {7, 10, 3, 2, 6, 9, 6, 9, 4, 11},
                            {3, 5, 9, 3, 5, 12, 9, 4, 14, 11},
                            {3, 6, 10, 7, 12, 12, 14, 14, 9, 3},
                            {3, 1, 7, 9, 6, 10, 1, 3, 4, 9},
                            {5, 10, 5, 8, 3, 5, 10, 5, 12, 10},
                            {2, 5, 12, 12, 9, 2, 5, 12, 12, 11},
                            {5, 12, 12, 12, 12, 13, 12, 12, 12, 9}};

    static int h = maze.length; // height of the maze
    static int w = maze[0].length; // width of the maze

    static int s_x = 0; // start at this x-coordinate
    static int s_y = 0; // start at this y-coordinate
    static int t_x = w - 1; // destination is at this x-coordinate
    static int t_y = h - 1; // destination is at this y-coordinate

    public static void display() {
		for (int i = 0; i < h; i++) {
			// draw the north edge
			for (int j = 0; j < w; j++) {
				System.out.print((maze[i][j] & 1) == 0 ? "+---" : "+   ");
			}
			System.out.println("+");
			// draw the west edge and waypoints
			for (int j = 0; j < w; j++) {
                String d = (maze[i][j] & 8) == 0 ? "| " : "  ";
                d += (maze[i][j] & 16) != 0 ? "*" : " ";
                d += " ";
				System.out.print(d);
			}
			System.out.println("|");
		}
		// draw the bottom line
		for (int j = 0; j < w; j++) {
			System.out.print("+---");
		}
		System.out.println("+");
	}

    /// set a waypoint for the given position (x, y)
    public static void setWaypoint(int x, int y) {
        maze[y][x] |= 16;
    }

    /// unset a waypoint for the given position (x, y)
    public static void unsetWaypoint(int x, int y) {
        maze[y][x] &= 15;
    }

    /// return true iff (if and only if) there is a waypoint set for the given position (x, y)
    public static boolean isWaypoint(int x, int y) {
        return (maze[y][x] & 16) != 0;
    }

    /// return true iff we can move from the given position (x, y) into the given direction
    public static boolean check(int x, int y, char dir) {
        int cell = maze[y][x];
        switch(dir) {
            case 'N':
                return (cell & 1) != 0;
            case 'S':
                return (cell & 2) != 0;
            case 'E':
                return (cell & 4) != 0;
            case 'W':
                return (cell & 8) != 0;
            default:
                System.out.println("Error: Unknown direction!");
                return false;
        }
    }

    /// return true iff there is a path from (s_x, s_y) to (t_x, t_y)
    /// if yes: additionally set waypoints for one possible path
   
    /*public static boolean search() {
          return true;
    } */

    
    /* public static boolean searchRec(int x, int y) {
       return true;
    } */

	public static void main(String[] args) {
        display();
    //    System.out.println(search());
      //  display();
	}

}

