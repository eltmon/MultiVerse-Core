package com.onarandombox.MultiVerseCore.commands;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.onarandombox.utils.PurgeWorlds;

import com.onarandombox.MultiVerseCore.MVCommandHandler;
import com.onarandombox.MultiVerseCore.MultiVerseCore;

public class MVPurge extends MVCommandHandler {

    public MVPurge(MultiVerseCore plugin) {
        super(plugin);
    }

    @Override
    public boolean perform(CommandSender sender, String[] args) {
        if(!(args.length>0)){
            return false;
        }
        
        if(!(sender instanceof Player)){
            sender.sendMessage("This command needs to be used from inside the game!");
            return true;
        }        

        Player p = (Player) sender;
        List<String> creatures = new ArrayList<String>();
        
        for(String creature : args[0].toUpperCase().split(",")){
            creatures.add(creature);
        }
        
        new PurgeWorlds(plugin).purge(sender, p.getWorld(), creatures);
        
        return true;
    }

}
