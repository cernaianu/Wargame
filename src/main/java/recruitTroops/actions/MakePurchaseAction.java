package recruitTroops.actions;

import model.Troop;
import playerState.PlayerStateController;
import playerState.PlayerStateLoader;
import playerState.PlayerStateWriter;
import recruitTroops.RecruitTroopsGUI;
import recruitTroops.guiAddons.TroopTable;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MakePurchaseAction implements ActionListener {
    private RecruitTroopsGUI gui;
    private PlayerStateController psc;
    private TroopTable tt;
    private String user;
    private int troopPos;

    public MakePurchaseAction(RecruitTroopsGUI gui, TroopTable tt, String user, int troopPos,PlayerStateController psc) {
        this.gui = gui;
        this.tt = tt;
        this.user = user;
        this.troopPos = troopPos;
        this.psc=psc;
    }
    public void makePurchase(String user,int troopPos,int count)
    {
        PlayerStateLoader pl=new PlayerStateLoader(user);
        PlayerStateWriter pw=new PlayerStateWriter();
        int value;
        value=pl.getTroops().get(troopPos).getCost()*count;
        if(value<=pl.getGold())
        {
            int remain=pl.getGold()-value;
            pw.updatePlayerStateGold(user,remain);
            Troop t=pl.getTroops().get(troopPos);
            t.setCount(t.getCount()+count);
            pw.updatePlayerState(user,t);
            gui.getGold().setText("Gold:"+remain);
            psc.updateGUIWithPlayer(user);
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Not enough gold!!!");
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        int count;
        try
        {
            count=Integer.parseInt(tt.getBuyTextField().getText());
        }
        catch (NumberFormatException ef)
        {
            count=0;
        }
        makePurchase(user,troopPos,count);
    }
}
