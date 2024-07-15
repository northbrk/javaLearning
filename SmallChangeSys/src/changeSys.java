/**
 * @author kyo
 * @version 1.0
 */

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


//使用Java 开发 零钱通项目 , 可以完成1.收益入账，2.消费，3.查看明细，4.退出系统等功能.
//化繁为简.
//1) 先完成显示菜单，并可以选择
//2) 完成零钱通明细.
//3) 完成收益入账
//4) 消费
//5) 退出
public class changeSys {
    public static void main(String[] args) {
        change myAccount = new change(0);
        myAccount.content();
    }
}

class change {
    private double changeAccount;
    private String[] changeDetail;
    private int lengthCount = 0;

    public change(double changeAccount) {
        this.changeAccount = changeAccount;
    }

    public String[] getChangeDetail() {
        return changeDetail;
    }

    public void setChangeDetail(String[] changeDetail) {
        this.changeDetail = changeDetail;
    }

    public int getLengthCount() {
        return lengthCount;
    }

    public void setLengthCount(int lengthCount) {
        this.lengthCount = lengthCount;
    }

    public double getChangeAccount() {
        return changeAccount;
    }

    public void setChangeAccount(double changeAccount) {
        this.changeAccount = changeAccount;
    }

    public void content() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("=============零钱通菜单=============");
            System.out.println("1 零钱通明细");
            System.out.println("2 收益入账");
            System.out.println("3 消费");
            System.out.println("4 退出系统");
            System.out.println("输入数字选择要使用的功能（1-4）：");
            int choice = sc.nextInt();//选择使用的功能
            if (choice == 1) {
                changeDetail();
            } else if (choice == 2) {
                System.out.println("请输入收益：");
                changeProfit(sc.nextDouble());
            } else if (choice == 3) {
                System.out.println("请输入消费数额：");
                double consume=sc.nextDouble();
                System.out.println("请输入消费事宜：");
                String consumeDetail=sc.next();
                changeConsume(consume,consumeDetail);
            } else if (choice == 4) {
                System.out.println("你确定要退出码？y/n");
                char ch = sc.next().charAt(0);
                if (ch == 'y' || ch == 'Y') {
                    break;
                }
            } else {
                System.out.println("输入有误！");
                //content();
            }
        }

    }

    /**
     * @description 以String数组的类型输出零钱通明细
     */
    public void changeDetail() {
        System.out.println("=============零钱通明细=============");
        if (changeDetail == null) {
            System.out.println("无明细");
            return;
        }
        for (int i = 0; i < changeDetail.length; i++) {
            System.out.println(changeDetail[i]);
        }
    }

    /**
     * @param profit
     * @description 将输入的数据以String形式存储到changeDetail中
     */
    public void changeProfit(double profit) {
        Scanner sc = new Scanner(System.in);
        while(true){//判断数值是否合法
            if(profit <= 0) {
                System.out.println("输入有误！请重新输入:");
                profit = sc.nextDouble();
            }
            else{
                break;
            }
        }
        changeAccount += profit;

        arrTool arrTool = new arrTool();
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        changeDetail = arrTool.addString(changeDetail, "收益入账\t+" + profit + "\t" + format.format(date) + "\t余额:" +
                "\t" + changeAccount);
    }

    /**
     * @description 将消费明细写入消费记录，并且更新账户余额
     * @param consume
     * @param consumeDetail
     */
    public void changeConsume(double consume, String consumeDetail) {
        Scanner sc = new Scanner(System.in);
        while(true){//判断数值是否合法
            if(consume <= 0) {
                System.out.println("输入有误！请重新输入:");
                consume = sc.nextDouble();
            }
            else{
                break;
            }
        }
        changeAccount -= consume;

        arrTool arrTool = new arrTool();
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        changeDetail = arrTool.addString(changeDetail, consumeDetail + "\t-" + consume + "\t" + format.format(date) + "\t余额:" +
                "\t" + changeAccount);

    }
}

class arrTool {
    private String[] arr;

    /**
     * @param oldArr
     * @param str
     * @return
     * @description 实现了将数组增加一位的功能
     */
    public String[] addString(String[] oldArr, String str) {
        if (oldArr == null) {
            String[] newArr = new String[1];
            newArr[0] = str;
            return newArr;
        } else {
            String[] newArr = new String[oldArr.length + 1];
            for (int i = 0; i < oldArr.length; i++) {//复制旧数组内容
                newArr[i] = oldArr[i];
            }
            newArr[oldArr.length] = str;
            return newArr;
        }

    }
}