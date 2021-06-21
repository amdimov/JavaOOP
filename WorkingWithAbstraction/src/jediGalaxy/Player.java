package jediGalaxy;

public class Player {
    Position playerPosition;

    Player(int x, int y){
        this.playerPosition = new Position(x, y);
    }

    public Position getPlayerPosition() {
        return playerPosition;
    }
    public int getPlayerPositionX(){
        return this.playerPosition.getX();
    }
    public int getPlayerPositionY(){
        return this.playerPosition.getY();
    }
    public boolean ifPlayerInGalaxy(int[][] galaxyMatrix){
        return getPlayerPositionX() >= 0 && getPlayerPositionX() < galaxyMatrix.length
                && getPlayerPositionY() >= 0 && getPlayerPositionY() < galaxyMatrix[0].length;
    }
    public void movePositionX(boolean increase){
        if (!increase){
            this.playerPosition.setX(playerPosition.getX()-1);
        }else {
            this.playerPosition.setX(playerPosition.getX()+1);
        }
    }
    public void movePositionY(boolean increase){
        if (!increase){
            this.playerPosition.setY(playerPosition.getY()-1);
        }else {
            this.playerPosition.setY(playerPosition.getY()+1);
        }
    }
}
