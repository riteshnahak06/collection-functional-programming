package com.multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// hacker threads try to decryt passwork and try to steal money and in 10 sec my police thread will come
// if hacker didint taken money they polic will catch them
public class ThiefPolice {
    public static final int MAX_PASS=9999;

    public static void main(String[] args) {
        Random random=new Random();
        Vault vault=new Vault(random.nextInt(MAX_PASS));
        List<Thread> threadList=new ArrayList<>();
        threadList.add(new AscendingHackerThread(vault));
        threadList.add(new DescendingHackerThread(vault));
        threadList.add(new PoliceThread());

        for (Thread thread: threadList){
            thread.start();
        }

    }
    private static class Vault{
        private int password;
        public Vault(int password){
            this.password=password;
        }
        public boolean isCorrect(int pw){
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return this.password==pw;
        }
    }
    private static abstract class HackerThread extends Thread{
        protected Vault vault;
        public HackerThread(Vault vault){
            this.vault=vault;
            this.setName(this.getClass().getName());
            this.setPriority(MAX_PRIORITY);
        }
        @Override
        public void start(){
            System.out.println("Starting thread  "+this.getName());
            super.start();
        }
    }
    private static class AscendingHackerThread extends HackerThread{
        public AscendingHackerThread(Vault vault) {
            super(vault);
        }
        @Override
        public void run() {
            for (int i=0;i<MAX_PASS;i++){
                if (vault.isCorrect(i)){
                    System.out.println("Guessed password is correct is  "+i);
                    System.exit(0);
                }
            }
        }
    }
    private static class DescendingHackerThread extends HackerThread{

        public DescendingHackerThread(Vault vault) {
            super(vault);
        }
        @Override
        public void run() {
            for (int i=MAX_PASS;i>=0;i--){
                if (vault.isCorrect(i)){
                    System.out.println("Guessed password is correct is  "+i);
                    System.exit(0);
                }
            }
        }
    }
    private static class PoliceThread extends Thread{
        @Override
        public void run() {
            for (int i=0;i<10;i++){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Already waited "+i +" second");
            }
            System.out.println("Your Game is over hacker !!");
            System.exit(0);
        }
    }
}
