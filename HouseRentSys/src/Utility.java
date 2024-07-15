import java.util.*;

public class Utility {
    Scanner input = new Scanner(System.in);

    /**
     * @description 读取菜单选择数字
     * @return choice
     */
    public int readNum() {
        int choice;
        while(true){
            System.out.println("请输入要使用的功能(1-6):");
            choice = input.nextInt();
            if(choice <1||choice > 6){
                System.out.println("输入有误！");
                continue;
            }
            break;
        }
        return choice;
    }
}
