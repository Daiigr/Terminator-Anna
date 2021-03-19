package Daiigr.com;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;


import javax.security.auth.login.LoginException;



public class Bot extends ListenerAdapter{
    private String StringMessage;
    private String CallerTarget;
    public static void main(String[] args) throws LoginException{
    

        JDABuilder.createDefault("ODIyNDkzNDExNDcwNDc1MjY1.YFTErg.X7MB45mi7mlkmWPpsrJxGOpvTHU").addEventListeners(new Bot())
        .setActivity(Activity.playing("Anna Simulator"))
        .build();
    }
    @Override
    public void onMessageReceived(MessageReceivedEvent event){
        Message msg = event.getMessage();
        StringMessage = msg.getContentRaw().toLowerCase();
        
        if(StringMessage.indexOf("i'm") > -1){
              CallerTarget = StringMessage.copyValueOf("i'm".toCharArray());
             StringMessage = StringMessage.replace(CallerTarget, "hello");
             StringMessage = StringMessage.substring(StringMessage.indexOf("hello"));

                MessageChannel channel = event.getChannel();
                channel.sendMessage(StringMessage).queue();

    }else if(StringMessage.indexOf("i am") > -1) {
             CallerTarget = StringMessage.copyValueOf("i am".toCharArray());
             StringMessage = StringMessage.replace(CallerTarget, "hello");
             StringMessage = StringMessage.substring(StringMessage.indexOf("hello"));

                MessageChannel channel = event.getChannel();
                channel.sendMessage(StringMessage).queue();

    } else if(StringMessage.indexOf("im") > -1){
        CallerTarget = StringMessage.copyValueOf("im".toCharArray());
             StringMessage = StringMessage.replace(CallerTarget, "hello ");
             StringMessage = StringMessage.substring(StringMessage.indexOf("hello"));

                MessageChannel channel = event.getChannel();
                channel.sendMessage(StringMessage).queue();

        }      
    }

    }
