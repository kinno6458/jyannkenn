public class Choki implements Hand {

    private String HAND_NAME = "チョキ";



    /**

     手の強弱を比較する。

     返り値 -1 : 自身が引数で指定した手より弱い

     　　　　0 : 自身が引数で指定した手と同じ

     　　　　1 : 自身が引数で指定した手より強い

     */

    public int compare(Hand hand) {
        if(hand instanceof Choki) {
            return 0;
        } else if(hand instanceof Pa) {
            return 1;
        } else {
            return -1;
        }
    }



    public String getHandName() {

        return this.HAND_NAME;

    }

}