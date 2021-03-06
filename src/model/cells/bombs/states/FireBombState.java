package model.cells.bombs.states;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import model.cells.CellState;
import model.cells.characters.player.Player;
import model.cells.characters.player.states.ArmoredState;
import model.cells.characters.player.states.UnarmoredState;

public class FireBombState implements CellState {

    private String bombPath;
    private Image sprite;

    public FireBombState() {
        bombPath = "view/resources/bomb.png";
        sprite = new Image(bombPath);
    }

    @Override
    public void draw(GraphicsContext cell, int x, int y) {
        cell.drawImage(sprite, x * 32, y * 32);
    }

    @Override
    public void receivePlayer() {
        Player player = Player.getPlayer();

        if (player.getPlayerState() instanceof ArmoredState) {
            player.setPlayerState(new UnarmoredState());
        }
        else {
            player.setHealth(player.getHealth() - 30);
        }


    }
}
