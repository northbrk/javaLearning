public class HouseService {
    private House[] houses;
    private int count = 0;//统计房屋数量
    private int id = 0;


    /**
     * @param id
     * @return
     * @description 根据输入的id寻找房子，没找到则返回null
     */
    public House findbyID(int id) {
        for (int i = 0; i < houses.length; i++) {
            if (houses[i].getHouseID() == id) {
                return houses[i];
            }
        }
        return null;
    }

    /**
     * @param house
     */
    public void add(House house) {
        houses = addHouse(houses, house);
        count++;
    }

    /**
     * @param oldHouse
     * @param house
     * @return
     * @description 将输入的house加入oldHouse, 并返回newHouse
     */
    public House[] addHouse(House[] oldHouse, House house) {
        House[] newHouse;
        if (oldHouse == null) {
            newHouse = new House[1];
            newHouse[0] = house;
        } else {
            newHouse = new House[oldHouse.length + 1];
            for (int i = 0; i < oldHouse.length; i++) {
                newHouse[i] = oldHouse[i];
            }
            newHouse[oldHouse.length] = house;
        }
        return newHouse;
    }

    public boolean del(int delId) {
        int index = -1;
        for (int i = 0; i < houses.length; i++) {
            if (houses[i].getHouseID() == delId) {
                index = i;
            }
        }
        if (index != -1) {
            return false;
        }
        for (int i = 0; i < houses.length; i++) {
            if (houses[i].getHouseID() == delId) {
                houses=delHouse(houses,houses[i]);
                count--;
                break;
            }
        }

        return true;
    }

    public House[] delHouse(House[] oldHouse, House house) {
        House[] newHouse = new House[oldHouse.length - 1];
        for (int i = 0, j = 0; i < oldHouse.length; i++,j++) {
            if (oldHouse[j].getHouseID() == house.getHouseID()) {
                j++;
                continue;
            }
            newHouse[i] = oldHouse[j];
        }
        return newHouse;
    }


}
