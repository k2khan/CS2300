package controller;

import model.*;
import java.awt.event.ActionListener;

public interface BlackJackUI
{
    public void setOnHit(ActionListener hitListener);
    public void setOnStand(ActionListener standListener);
    public void showHand(Hand hand, boolean isDealerHand);
    public void peekHand(Hand hand);
    public void disableHit();
    public void disableStand();
    public void clearTable();
    public void enableHit();
    public void enableStand();

    public boolean playAgain(Result result);
}
