package model;

public class HumanPlayer extends Player
{
    protected int money;
    protected int currentBet;

    public HumanPlayer(int money)
    {
        super();
        this.money = money;
    }

    public int getMoney()
    {
        return money;
    }

    public void setBet(int bet)
    {
        System.out.println("Setting bet to "+bet);
        money-=bet;
        currentBet = bet;
    }

    public void win(int money)
    {
        this.money+=money;
    }
}
