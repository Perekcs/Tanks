package Game;

import java.io.File;
import java.io.IOException;
import java.util.InvalidPropertiesFormatException;
import java.util.Objects;
import java.util.Scanner;

public final class Map {
    private final int[][] tiles;
    private final int width;
    private final int height;

    private Map(int[][] tiles) {
        this.tiles = tiles;
        width = tiles.length;
        height = tiles[0].length;
    }

    public static Map fromArray(int[][] array) {
        return new Map(array);
    }

    public static Map fromMapFolder(String mapName) throws IOException {
        return Map.fromFile(new File((Objects.requireNonNull(Map.class.getResource("/maps/" + mapName + ".map")).getPath())));
    }

    public static Map fromFile(File file) throws IOException {
        Scanner scanner = new Scanner(file);
        if(!scanner.hasNextInt())
            throw new InvalidPropertiesFormatException("Invalid map format");
        final int width = scanner.nextInt();
        if(width <= 0)
            return null;
        final int height = scanner.nextInt();
        if(height <= 0)
            throw new InvalidPropertiesFormatException("Invalid map format");
        int[][] tiles = new int[width][height];
        int i = 0;
        while(scanner.hasNextInt()){
            tiles[i % width][i++ / height] = scanner.nextInt();
        }
        if(i < width * height - 1)
            System.err.println("STRANGE BEHAVIOUR");
        return fromArray(tiles);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public boolean isValidPosition(int x, int y) {
        return x >= 0 && x < width && y >= 0 && y < height;
    }

    public int getTile(int x, int y) throws IndexOutOfBoundsException {
        if(!isValidPosition(x, y))
            throw new IndexOutOfBoundsException(String.format("Position (%d, %d) is outside the map", x, y));
        return tiles[x][y];
    }
}
