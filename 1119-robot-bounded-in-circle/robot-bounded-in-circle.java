class Solution {
    public boolean isRobotBounded(String instructions) {
                //calculate coordinates after 1st cycle
        //calculate direction after 1st cycle

        //if coordinate is (0,0) then return true
        //if resulting direction is not North return true
        //starting is North and ending is north with coordinates other than (0,0) after 1st cycle => no matter how many cycles you go through it is resulting in displacement without forming circle
        //if resulting direction is SOUTH, making another cycle with given instructions => retracing the path but in opp direction => eventually going to end up facing north
        //if resulting direction is EAST or WEST, making another cycle with given instruction => requires 3 more cycles to reach the inital point

        int x = 0;
        int y = 0;
        String facing = "North";
        for (int instruction = 0; instruction < instructions.length(); instruction++) {
            if (instructions.charAt(instruction) == 'G') {
                switch (facing) {
                    case ("North"):
                        y = y + 1;
                        break;
                    case ("South"):
                        y = y - 1;
                        break;
                    case ("East"):
                        x = x + 1;
                        break;
                    case ("West"):
                        x = x - 1;
                }
            } else if (instructions.charAt(instruction) == 'R') {
                facing = switch (facing) {
                    case ("North") -> "East";
                    case ("South") -> "West";
                    case ("East") -> "South";
                    case ("West") -> "North";
                    default -> facing;
                };
            } else if (instructions.charAt(instruction) == 'L') {
                facing = switch (facing) {
                    case ("North") -> "West";
                    case ("South") -> "East";
                    case ("East") -> "North";
                    case ("West") -> "South";
                    default -> facing;
                };
            }
        }
        return x == 0 && y == 0 || !facing.equals("North");
    }
}