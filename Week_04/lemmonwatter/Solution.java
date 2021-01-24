public class Solution {
    public boolean lemonadeChange(int[] bills) {
        //5 美元直接收下
        //10 美元 必须有5 美元在手才可以收下
        //20 美元 手上必须有15美元：一张10美元、一张5美元 或者 3张5美元，因为 5 美元的重要性，应该优先找零 10 + 5
        //5 美元 和 10 美元的数量
        int five = 0;
        int ten = 0;
        for (int bill : bills) {
            if (bill == 5) {
                five ++;
            } else if (bill == 10) {
                if (five == 0) {
                    return false;
                }
                five--;
                ten++;
            } else {
                if (five > 0 && ten > 0) {
                    five--;
                    ten--;
                } else if (five > 3) {
                    five = five - 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}