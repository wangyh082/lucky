import java.util.Random;

public class Main {
    public static final Object[][] prizeArr = new Object [][] {
    {1,345,15+360,"one一等奖",0},
    {2,45,75,"two二等奖",3},
    {3,105,135,"three三等奖",5},
    {4,165,195,"four四等奖",10},
    {5,225,255,"five五等奖",22},
    {6,285,315,"again再来一次",10},
    {7,15,45,"thanks谢谢参与",10},
    {8,75,105,"thanks谢谢参与",10},
    {9,135,165,"thanks谢谢参与",10},
    {10,195,225,"thanks谢谢参与",5},
    {11,255,285,"thanks谢谢参与",5},
    {12,315,345,"thanks谢谢参与",10},
    };

    private static AwardBean chouJiang(Object[][] prizearr2) {
        Integer obj[] = new Integer[prizearr2.length];
        for (int i = 0; i < prizearr2.length; i++) {
            obj[i] = (Integer) prizearr2[i][4];
        }
        Integer prizeIndex = getRandPrize(obj);
       // System.out.print(prizeIndex);
        int maxAngle = (Integer)prizeArr[prizeIndex][2];
        int minAngle = (Integer)prizeArr[prizeIndex][1];
        int angle = new Random().nextInt(4)+15+minAngle;

        String msg = (String)prizeArr[prizeIndex][3];

        AwardBean awardBean = new AwardBean();
        awardBean.setAngle(angle);
        awardBean.setMsg(msg);
        int prizeId = (Integer)prizeArr[prizeIndex][0];
        if( prizeId <= 6 ) {
            awardBean.setPrizeId(prizeId);
        }
        else {
            awardBean.setPrizeId(7);
        }
        return awardBean;
    }

    /**
     * 抽奖算法 根据概率获取奖项
     * @param obj
     * @return
     */
    private static Integer getRandPrize(Integer[] obj) {
        Integer result = null;
        int sum = 0;
        for (int i=0; i < obj.length; i++) {
            sum+=obj[i];
        }
        for (int i=0; i < obj.length; i++) {
            int randomNum = new Random().nextInt(sum)+1;
            if(randomNum <= obj[i]) {
                result = i;
                break;
            }
            else {
                sum -= obj[i];
            }
        }
        return result;
    }

    public static void main (String[] args) {
        AwardBean test = chouJiang(prizeArr);
        System.out.print(test.getMsg()+"\n");
        System.out.print(test.getAngle()+"\n");
        System.out.print(test.getPrizeId()+"\n");
    }
}
