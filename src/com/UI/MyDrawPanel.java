package com.UI;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

public class MyDrawPanel extends JPanel {
    public static final int OFFSET = 0;
    public static final int SPACE = 50;

    public static final int WIDTH = 650;
    public static final int HEIGHT = 650;
    public int redI[] = {-1, -1, -1, -1};
    public int blueI[] = {-1, -1, -1, -1};
    public int greenI[] = {-1, -1, -1, -1};
    public int yellowI[] = {-1, -1, -1, -1};
    public OurColor chanceToPlay = OurColor.RED;
    public int index = 1;
    public boolean isRedInPlay[] = {false, false, false, false};
    public boolean isBlueInPlay[] = {false, false, false, false};
    public boolean isYellowInPlay[] = {false, false, false, false};
    public boolean isGreenInPlay[] = {false, false, false, false};
    public boolean redRoundDone[] = {false, false, false, false};
    public boolean blueRoundDone[] = {false, false, false, false};
    public boolean yellowRoundDone[] = {false, false, false, false};
    public boolean greenRoundDone[] = {false, false, false, false};
    public int x = 250;
    public int y = 0;
    public int diceNumber;
    public int baseIndex = 0;
    int[] piecesOrder = {1, 2, 3, 48, 4, 47, 5, 46, 6, 45, 7, 39, 40, 41, 42, 43, 44,
            8, 9, 10, 11, 12, 13, 38, 14, 37, 36, 35, 34, 33, 32, 20,
            19, 18, 17, 16, 15, 31, 21, 30, 22, 29, 23, 28, 24, 27, 26, 25};
    private ArrayList<Pieces> allPieces = new ArrayList<Pieces>();
    private ArrayList<MovePiece> movePieces = new ArrayList<MovePiece>();
    private ArrayList<BasePiece> basePieces = new ArrayList<BasePiece>();
    private ArrayList<MovePiece> redMovePieces = new ArrayList<MovePiece>();
    private ArrayList<MovePiece> blueMovePieces = new ArrayList<MovePiece>();
    private ArrayList<MovePiece> yellowMovePieces = new ArrayList<MovePiece>();
    private ArrayList<MovePiece> greenMovePieces = new ArrayList<MovePiece>();
    private String level =
            "#####&&&#####\n"
                    + "#$$##&B&##$$#\n"
                    + "#$$##&B&##$$#\n"
                    + "#####&B&#####\n"
                    + "#####&B&#####\n"
                    + "&&&&&&#&&&&&&\n"
                    + "&RRRR###YYYY&\n"
                    + "&&&&&&#&&&&&&\n"
                    + "#####&G&#####\n"
                    + "#####&G&#####\n"
                    + "#$$##&G&##$$#\n"
                    + "#$$##&G&##$$#\n"
                    + "#####&&&#####\n";

    public MyDrawPanel() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        initWorld();
    }

    public final void initWorld() {
        System.out.println("MyDrawing:initWorld");
        int x = OFFSET;
        int y = OFFSET;

        BoardPiece boardPiece;
        MovePiece movePiece;
        BasePiece basePiece;
        MovePiece redMovePiece;
        MovePiece blueMovePiece;
        MovePiece yellowMovePiece;
        MovePiece greenMovePiece;
        int ii = 0;
        int rii = 0;
        int bii = 0;
        int yii = 0;
        int gii = 0;
        for (int i = 0; i < level.length(); i++) {

            char item = level.charAt(i);

            if (item == '\n') {
                y += SPACE;
                x = OFFSET;
            } else if (item == '#') {
                boardPiece = new BoardPiece(x, y);
                allPieces.add(boardPiece);
                x += SPACE;
            } else if (item == '&') {
                movePiece = new MovePiece(x, y, OurColor.NONE);
                movePiece.setIndex(piecesOrder[ii]);
                ii++;
                allPieces.add(movePiece);
                movePieces.add(movePiece);

                x += SPACE;
            } else if (item == '$') {
                basePiece = new BasePiece(x, y);
                basePiece.setIndex(baseIndex);
                baseIndex++;
                allPieces.add(basePiece);
                basePieces.add(basePiece);
                x += SPACE;
            } else if (item == 'R') {
                redMovePiece = new MovePiece(x, y, OurColor.RED);
                redMovePiece.setIndex(rii);
                rii++;
                allPieces.add(redMovePiece);
                redMovePieces.add(redMovePiece);
                x += SPACE;
            } else if (item == 'B') {
                blueMovePiece = new MovePiece(x, y, OurColor.BLUE);
                blueMovePiece.setIndex(bii);
                bii++;
                allPieces.add(blueMovePiece);
                blueMovePieces.add(blueMovePiece);
                x += SPACE;
            } else if (item == 'Y') {
                yellowMovePiece = new MovePiece(x, y, OurColor.YELLOW);
                yellowMovePiece.setIndex(yii);
                yii++;
                allPieces.add(yellowMovePiece);
                yellowMovePieces.add(yellowMovePiece);
                x += SPACE;
            } else if (item == 'G') {
                greenMovePiece = new MovePiece(x, y, OurColor.GREEN);
                greenMovePiece.setIndex(gii);
                gii++;
                allPieces.add(greenMovePiece);
                greenMovePieces.add(greenMovePiece);
                x += SPACE;
            }


        }
        Collections.sort(movePieces);

    }


    public void attack(int iii, OurColor color) {
        System.out.println("Attack by " + color.name());
        for (int x = 0; x < 4; x++) {
            if (color != OurColor.RED && redI[x] == iii && !redRoundDone[x]) {
                redI[x] = -1;
                isRedInPlay[x] = false;
            }
            if (color != OurColor.BLUE && blueI[x] == iii && !blueRoundDone[x]) {
                blueI[x] = -1;
                isBlueInPlay[x] = false;
            }
            if (color != OurColor.YELLOW && yellowI[x] == iii && !yellowRoundDone[x]) {
                yellowI[x] = -1;
                isYellowInPlay[x] = false;
            }
            if (color != OurColor.GREEN && greenI[x] == iii && !greenRoundDone[x]) {
                greenI[x] = -1;
                isGreenInPlay[x] = false;
            }
        }
    }


    public void evaluateBasePieces() {

        if (redI[0] != -1)
            basePieces.get(0).setImage(new ImageIcon(this.getClass().getResource("images/base_piece.png")).getImage());
        else basePieces.get(0).setImage(new ImageIcon(this.getClass().getResource("images/red.png64")).getImage());
        if (redI[1] != -1)
            basePieces.get(1).setImage(new ImageIcon(this.getClass().getResource("images/base_piece.png")).getImage());
        else basePieces.get(1).setImage(new ImageIcon(this.getClass().getResource("images/red.png64")).getImage());
        if (redI[2] != -1)
            basePieces.get(4).setImage(new ImageIcon(this.getClass().getResource("images/base_piece.png")).getImage());
        else basePieces.get(4).setImage(new ImageIcon(this.getClass().getResource("images/red.png64")).getImage());
        if (redI[3] != -1)
            basePieces.get(5).setImage(new ImageIcon(this.getClass().getResource("images/base_piece.png")).getImage());
        else basePieces.get(5).setImage(new ImageIcon(this.getClass().getResource("images/red.png64")).getImage());


        if (blueI[0] != -1)
            basePieces.get(2).setImage(new ImageIcon(this.getClass().getResource("images/base_piece.png")).getImage());
        else basePieces.get(2).setImage(new ImageIcon(this.getClass().getResource("images/blue.png64")).getImage());
        if (blueI[1] != -1)
            basePieces.get(3).setImage(new ImageIcon(this.getClass().getResource("images/base_piece.png")).getImage());
        else basePieces.get(3).setImage(new ImageIcon(this.getClass().getResource("images/blue.png64")).getImage());
        if (blueI[2] != -1)
            basePieces.get(6).setImage(new ImageIcon(this.getClass().getResource("images/base_piece.png")).getImage());
        else basePieces.get(6).setImage(new ImageIcon(this.getClass().getResource("images/blue.png64")).getImage());
        if (blueI[3] != -1)
            basePieces.get(7).setImage(new ImageIcon(this.getClass().getResource("images/base_piece.png")).getImage());
        else basePieces.get(7).setImage(new ImageIcon(this.getClass().getResource("images/blue.png64")).getImage());

        if (greenI[0] != -1)
            basePieces.get(8).setImage(new ImageIcon(this.getClass().getResource("images/base_piece.png")).getImage());
        else basePieces.get(8).setImage(new ImageIcon(this.getClass().getResource("images/green.png64")).getImage());
        if (greenI[1] != -1)
            basePieces.get(9).setImage(new ImageIcon(this.getClass().getResource("images/base_piece.png")).getImage());
        else basePieces.get(9).setImage(new ImageIcon(this.getClass().getResource("images/green.png64")).getImage());
        if (greenI[2] != -1)
            basePieces.get(12).setImage(new ImageIcon(this.getClass().getResource("images/base_piece.png")).getImage());
        else basePieces.get(12).setImage(new ImageIcon(this.getClass().getResource("images/green.png64")).getImage());
        if (greenI[3] != -1)
            basePieces.get(13).setImage(new ImageIcon(this.getClass().getResource("images/base_piece.png")).getImage());
        else basePieces.get(13).setImage(new ImageIcon(this.getClass().getResource("images/green.png64")).getImage());

        if (yellowI[0] != -1)
            basePieces.get(10).setImage(new ImageIcon(this.getClass().getResource("images/base_piece.png")).getImage());
        else basePieces.get(10).setImage(new ImageIcon(this.getClass().getResource("images/yellow.png64")).getImage());
        if (yellowI[1] != -1)
            basePieces.get(11).setImage(new ImageIcon(this.getClass().getResource("images/base_piece.png")).getImage());
        else basePieces.get(11).setImage(new ImageIcon(this.getClass().getResource("images/yellow.png64")).getImage());
        if (yellowI[2] != -1)
            basePieces.get(14).setImage(new ImageIcon(this.getClass().getResource("images/base_piece.png")).getImage());
        else basePieces.get(14).setImage(new ImageIcon(this.getClass().getResource("images/yellow.png64")).getImage());
        if (yellowI[3] != -1)
            basePieces.get(15).setImage(new ImageIcon(this.getClass().getResource("images/base_piece.png")).getImage());
        else basePieces.get(15).setImage(new ImageIcon(this.getClass().getResource("images/yellow.png64")).getImage());

    }


    public void buildWorld(Graphics g) {
        System.out.println("MyDrawPanel:buildWorld\n");
        evaluateBasePieces();
        for (int i = 0; i < allPieces.size(); i++) {
            Pieces item = allPieces.get(i);
            g.drawImage(item.getImage(), item.x(), item.y(), this);
        }
        g.fillRect(300, 300, 50, 50);
        g.setColor(Color.orange);
        g.setFont(new Font("Verdana", Font.BOLD, 18));
        g.drawString(String.valueOf(diceNumber), 318, 330);
        Image image = null;
        for (int i = 0; i < 4; i++) {
            if (redI[i] != -1 && redI[i] != -10) {
                image = new ImageIcon(this.getClass().getResource("images/red" + i + ".png")).getImage();
                if (!redRoundDone[i]) {
                    g.drawImage(image, movePieces.get(redI[i]).x(), movePieces.get(redI[i]).y(), this);
                    attack(redI[i], OurColor.RED);
                } else g.drawImage(image, redMovePieces.get(redI[i]).x(), redMovePieces.get(redI[i]).y(), this);
            }
            if (blueI[i] != -1 && blueI[i] != -10) {
                image = new ImageIcon(this.getClass().getResource("images/blue" + i + ".png")).getImage();
                if (!blueRoundDone[i]) {
                    g.drawImage(image, movePieces.get(blueI[i]).x(), movePieces.get(blueI[i]).y(), this);
                    attack(blueI[i], OurColor.BLUE);
                } else g.drawImage(image, blueMovePieces.get(blueI[i]).x(), blueMovePieces.get(blueI[i]).y(), this);
            }
            if (yellowI[i] != -1 && yellowI[i] != -10) {
                image = new ImageIcon(this.getClass().getResource("images/yellow" + i + ".png")).getImage();
                if (!yellowRoundDone[i]) {
                    g.drawImage(image, movePieces.get(yellowI[i]).x(), movePieces.get(yellowI[i]).y(), this);
                    attack(yellowI[i], OurColor.YELLOW);
                } else
                    g.drawImage(image, yellowMovePieces.get(yellowI[i]).x(), yellowMovePieces.get(yellowI[i]).y(), this);
            }
            if (greenI[i] != -1 && greenI[i] != -10) {
                image = new ImageIcon(this.getClass().getResource("images/green" + i + ".png")).getImage();
                if (!greenRoundDone[i]) {
                    g.drawImage(image, movePieces.get(greenI[i]).x(), movePieces.get(greenI[i]).y(), this);
                    attack(greenI[i], OurColor.GREEN);
                } else g.drawImage(image, greenMovePieces.get(greenI[i]).x(), greenMovePieces.get(greenI[i]).y(), this);
            }
        }
    }

    public void updateChanceToPlay() {
        System.out.println(chanceToPlay);
        if (diceNumber == 6) {
            //do nothing. Player has another turn
            return;
        }
        switch (chanceToPlay) {
            case RED:
                chanceToPlay = OurColor.BLUE;
                break;
            case BLUE:
                chanceToPlay = OurColor.YELLOW;
                break;
            case YELLOW:
                chanceToPlay = OurColor.GREEN;
                break;
            case GREEN:
                chanceToPlay = OurColor.RED;
                break;
            default:
                ;
        }

    }

    public boolean HasMove(int pieceId, int diceNum) {

        switch (chanceToPlay) {
            case RED:
                if (isRedInPlay[pieceId] || (diceNum == 6 && !redRoundDone[pieceId]))
                    return true;
                break;
            case BLUE:
                if (isBlueInPlay[pieceId] || (diceNum == 6 && !blueRoundDone[pieceId]))
                    return true;
                break;
            case YELLOW:
                if (isYellowInPlay[pieceId] || (diceNum == 6 && !yellowRoundDone[pieceId]))
                    return true;
                break;
            case GREEN:
                if (isGreenInPlay[pieceId]|| (diceNum == 6 && !greenRoundDone[pieceId]))
                    return true;
                break;
            default:
                ;
        }
        return false;
    }


    public void move(int diceNumber, int pieceId) {
        System.out.println("PieceID:" + pieceId);
        switch (chanceToPlay) {
            case RED:
                System.out.println(redI[pieceId]);
                //if done, do nothing
                if (!isRedInPlay[pieceId] && redRoundDone[pieceId]) {
                    updateChanceToPlay();
                    return;
                }
                //if not started and 6, start
                if (!isRedInPlay[pieceId] && !redRoundDone[pieceId] && diceNumber == 6) {
                    redI[pieceId] = 39 - 1;
                    isRedInPlay[pieceId] = true;
                }
                //if not 6 and not started do nothing
                if (!isRedInPlay[pieceId]) {
                    repaint();
                    updateChanceToPlay();
                    return;
                }
                //while dice>0, move
                while (diceNumber > 0) {
                    redI[pieceId] = redI[pieceId] + 1;
                    //loop around board
                    if (redI[pieceId] > 47) {
                        redI[pieceId] = 0;
                    }
                    //if in finish and done
                    if (redRoundDone[pieceId] && redI[pieceId] >= 3) {
                        isRedInPlay[pieceId] = false;
                        repaint();
                        updateChanceToPlay();
                        return;
                    }
                    //move piece to finish
                    if (redI[pieceId] == 38) {
                        redRoundDone[pieceId] = true;
                        redI[pieceId] = 0;
                    }
                    diceNumber--;
                }
                break;
            case BLUE:
                System.out.println(blueI[pieceId]);
                if (!isBlueInPlay[pieceId] && blueRoundDone[pieceId]) {
                    updateChanceToPlay();
                    return;
                }
                if (!isBlueInPlay[pieceId] && !blueRoundDone[pieceId] && diceNumber == 6) {
                    blueI[pieceId] = 3 - 1;
                    isBlueInPlay[pieceId] = true;
                }
                if (!isBlueInPlay[pieceId] && diceNumber != 6) {
                    repaint();
                    updateChanceToPlay();
                    return;
                }

                while (diceNumber > 0) {
                    blueI[pieceId] = blueI[pieceId] + 1;
                    if (blueI[pieceId] > 47) {
                        blueI[pieceId] = 0;
                    }
                    if (blueRoundDone[pieceId] && blueI[pieceId] >= 3) {
                        isBlueInPlay[pieceId] = false;
                        repaint();
                        updateChanceToPlay();
                        return;
                    }
                    if (blueI[pieceId] == 2 && !blueRoundDone[pieceId]) {
                        blueRoundDone[pieceId] = true;
                        blueI[pieceId] = 0;
                    }
                    diceNumber--;
                }
                break;
            case YELLOW:
                System.out.println(yellowI[pieceId]);
                if (!isYellowInPlay[pieceId] && yellowRoundDone[pieceId]) {
                    updateChanceToPlay();
                    return;
                }
                if (!isYellowInPlay[pieceId] && !yellowRoundDone[pieceId] && diceNumber == 6) {
                    yellowI[pieceId] = 15 - 1;
                    isYellowInPlay[pieceId] = true;
                }
                if (!isYellowInPlay[pieceId] && diceNumber != 6) {
                    repaint();
                    updateChanceToPlay();
                    return;
                }
                while (diceNumber > 0) {
                    if (yellowRoundDone[pieceId]) {
                        yellowI[pieceId] = yellowI[pieceId] - 1;
                    } else {
                        yellowI[pieceId] = yellowI[pieceId] + 1;
                    }
                    if (yellowI[pieceId] > 47) {
                        yellowI[pieceId] = 0;
                    }

                    if (yellowRoundDone[pieceId] && yellowI[pieceId] == 0) {
                        isYellowInPlay[pieceId] = false;
                        repaint();
                        updateChanceToPlay();
                        return;
                    }
                    if (yellowI[pieceId] == 14) {
                        yellowRoundDone[pieceId] = true;
                        yellowI[pieceId] = 3;
                    }
                    diceNumber--;
                }
                break;
            case GREEN:
                if (!isGreenInPlay[pieceId] && greenRoundDone[pieceId]) {
                    updateChanceToPlay();
                    return;
                }
                System.out.println(greenI[pieceId]);
                if (!isGreenInPlay[pieceId] && !greenRoundDone[pieceId] && diceNumber == 6) {
                    greenI[pieceId] = 27 - 1;
                    isGreenInPlay[pieceId] = true;
                }
                if (!isGreenInPlay[pieceId] && diceNumber != 6) {
                    repaint();
                    updateChanceToPlay();
                    return;
                }
                while (diceNumber > 0) {

                    if (greenRoundDone[pieceId]) {
                        greenI[pieceId] = greenI[pieceId] - 1;
                    } else {
                        greenI[pieceId] = greenI[pieceId] + 1;
                    }
                    if (greenI[pieceId] > 47) {
                        greenI[pieceId] = 0;
                    }
                    if (greenRoundDone[pieceId] && greenI[pieceId] == 0) {
                        isGreenInPlay[pieceId] = false;
                        repaint();
                        updateChanceToPlay();
                        return;
                    }
                    if (greenI[pieceId] == 26) {
                        greenRoundDone[pieceId] = true;
                        greenI[pieceId] = 3;
                    }
                    diceNumber--;
                }
                break;
            default:
                ;

        }
        repaint();
        updateChanceToPlay();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        System.out.println("MyDrawingPanel:paint");
        buildWorld(g);
    }


    public void restart() {
        x = 250;
        y = 0;
        index = 1;
        initWorld();
    }

}
