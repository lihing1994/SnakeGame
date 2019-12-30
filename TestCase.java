
public class TestCase
{
   public static void main(String [] args)
   {
   		SnakeGameMap snakeGameMap = new SnakeGameMap();
      	int [] x = new int []{0,1,2};
      	int [] y = new int []{0,0,0};
      	snakeGameMap.setTempX_Snake_one(x);
      	snakeGameMap.setTempY_Snake_one(y);
      	snakeGameMap.setTempX_Apple(0);
      	snakeGameMap.setTempY_Apple(0);
         assertEquals(snakeGameMap.Check_if_Snake_Eat_Food(),true);
         int [] x1 = new int []{1,2,3};
         int [] y1 = new int []{1,2,3};
         snakeGameMap.setTempX_Snake_one(x1);
         snakeGameMap.setTempY_Snake_one(y1);
         assertEquals(snakeGameMap.Check_if_Snake_Eat_Food(),false);
         //Following code test for the second player
         //The seoncd snake eat the food
         int [] x2 = new int []{0,1,2};
         int [] y2 = new int  []{0,0,0};
         snakeGameMap.setIs_one_player_game(2);
         snakeGameMap.setTempX_Snake_two(x2);
         snakeGameMap.setTempY_Snake_two(y2);
      	assertEquals(snakeGameMap.Check_if_Snake_Eat_Food(),true);
         //Tesing for eating itself
         int [] x3 = new int []{0,0,2};
         int [] y3 = new int []{0,0,0};
         snakeGameMap.setTempX_Snake_one(x3);
         snakeGameMap.setTempY_Snake_one(y3);
         assertEquals(snakeGameMap.Check_If_Snake_Eat_Itself(),true);
         int [] x4 = new int []{0,0,0};
         int [] y4 = new int []{0,2,3};
         snakeGameMap.setTempX_Snake_one(x4);
         snakeGameMap.setTempY_Snake_one(y4);
         assertEquals(snakeGameMap.Check_If_Snake_Eat_Itself(),false);
         //Test if two snake touch with each other
         assertEquals(snakeGameMap.Check_If_Snake_Touch_Each_Other(),true);
   }
   
}
