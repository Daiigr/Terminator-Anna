package Daiigr.com;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.security.auth.login.LoginException;



public class Bot extends ListenerAdapter{
    private String StringMessage;
    private String CallerTarget;
    private static String Token;
    public static void main(String[] args) throws LoginException{

        try {
            File myObj = new File("Token.txt");
            if (myObj.createNewFile()) {
              System.out.println("File created, please insert token " + myObj.getName());
              System.exit(0);
            } else {
              System.out.println("Token.txt exists. Looking for token");
            }

            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                Token = myReader.nextLine();
                if(Token.isEmpty()==true){
                    System.out.println("No Token Detected");
                }else{
                System.out.println("Token Detected");
                }
            }
        myReader.close();
          } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
        
    try {
        JDABuilder.createDefault(Token).addEventListeners(new Bot())
        .setActivity(Activity.playing("Anna Simulator"))
        .build();
    } catch (Exception e) {
        System.out.print("Invalid Token");
    }
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
