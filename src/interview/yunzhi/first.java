package interview.yunzhi;

/**
 * @author Zero
 * @date 2022/11/18 15:30
 * @description
 * @since 1.8
 **/
public class first {
    public static void main(String[] args) {

    }
    private first(){}
    private static volatile first obj;
    public static first getInstance() {
        if(obj == null) {
            synchronized (obj) {
                obj = new first();
            }
        }
        return obj;
    }

}
