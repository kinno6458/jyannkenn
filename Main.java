import java.io.*;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Player user = new Player("ユーザ");
        Player com = new Player("CPU");

        
        System.out.println("1.グー");
        System.out.println("2.チョキ");
        System.out.println("3.パー");
        System.out.println("あなたの手を選択してください。>");


        String input = null;

        try {
            BufferedReader inputuser = new BufferedReader(
                    new InputStreamReader(System.in)
            );
            input = inputuser.readLine();
        } catch (IOException e) {
            System.out.print("システムエラー");
            System.exit(0);
            return;
        }

        if (input == null) {
            System.out.print("1-3の値を入力してください。");
            System.exit(0);
            return;
        }

        // ユーザの入力によりジャンケンの手をセットする
        if (input.equals("1")) {
            user.setHand(new Gu());
        } else if (input.equals("2")) {
            user.setHand(new Choki());
        } else if (input.equals("3")) {
            user.setHand(new Pa());
        } else {
            System.out.print("1-3の値を入力してください。");
            System.exit(0);
            return;
        }

        // comの手をランダムに設定する
        Random rand = new Random();
        int comHand = rand.nextInt(3) + 1; // 1から3のランダムな数を生成
        if (comHand == 1) {
            com.setHand(new Gu());
        } else if (comHand == 2) {
            com.setHand(new Choki());
        } else {
            com.setHand(new Pa());
        }

        // 結果を判定するメソッド
        int result = game.judge(user, com);

        // 結果表示
        System.out.println(
                user.getPlayerName() + "の手:" + user.getHand().getHandName()
        );
        System.out.println(
                com.getPlayerName() + "の手:" + com.getHand().getHandName()
        );

        if (result < 0) {
            System.out.println("結果:" + user.getPlayerName() + "の負け");
        } else if (result > 0) {
            System.out.println("結果:" + user.getPlayerName() + "の勝ち");
        } else {
            System.out.println("結果:あいこ");
        }
    }
}