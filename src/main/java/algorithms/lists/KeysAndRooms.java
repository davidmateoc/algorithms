package algorithms.lists;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Create by davidmateo
 * Date: 2021-08-09
 * Time: 12:55 PM
 * Algorithm URL: https://leetcode.com/problems/keys-and-rooms/
 */

public class KeysAndRooms {

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] isRoomVisited = new boolean[rooms.size()];

        isRoomVisited[0] = true;
        addToKeyring(rooms, 0, isRoomVisited);


        for(boolean visited : isRoomVisited) {
                if(!visited) return false;
        }
        return true;
    }

    public void addToKeyring(List<List<Integer>> rooms, int roomNumber, boolean[] isRoomVisited) {

        for(int key : rooms.get(roomNumber)) {
            if(!isRoomVisited[key]) {
                isRoomVisited[key] = true;
                addToKeyring(rooms, key, isRoomVisited);
            }
        }
    }

    @Test
    public void canVisitAllRoomsTest() {
        List<List<Integer>> rooms = List.of(List.of(1, 3), List.of(3, 0, 1), List.of(2), List.of(0));
        Assert.assertFalse(canVisitAllRooms(rooms));
    }
}
