package rooms;

final public class Map {
    public static Room initmap[][];
    public static Room currentRoom;

    public static boolean checkDirection(int roomX, int roomY) {
        return ((roomX >= 0 && roomX < initmap.length) &&
                (roomY >= 0 && roomY < initmap.length) &&
                initmap[roomX][roomY] != null);
    }

    public static void moveDirection(int roomX, int roomY) {
        if (checkDirection(roomX, roomY)) {
            currentRoom = initmap[roomX][roomY];
        }
    }

    public static Room getRoom(Point point) {
        return initmap[point.getX()][point.getY()];
    }

    public static Room getRoom(int x, int y) {
        return initmap[x][y];
    }
}
