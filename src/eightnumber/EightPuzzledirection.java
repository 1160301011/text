package eightnumber;

public class EightPuzzledirection {

  //判断是不是可以继续移动
  public static boolean canmove(int x, int y, int direction) {
      if ((direction == 1 && x == 0) || (direction == 2 && x == 2)
              || (direction == 3 && y == 2) || (direction == 4 && y == 0)) {
          return false;
      }
      return true;
  }

  //根据给出的参数，进行空格位置的移动
  //其中1表示向上，2表示向右，-1表示向下，-2表示向左
  public static EightPuzzle movePosition(EightPuzzle ep, int args) {
      
      EightPuzzle eightPuzzle = null;

      eightPuzzle = ep.depthClone();
      eightPuzzle.getPostion();
      int x = eightPuzzle.getx(), y = eightPuzzle.gety();

      //指令为向上移动
      if (args == 1) {
          int temp = eightPuzzle.data[x][y];
          eightPuzzle.data[x][y] = eightPuzzle.data[x - 1][y];
          eightPuzzle.data[x - 1][y] = temp;
          //移动成功
      }
      //指令为向下移动
      else if (args == 2) {
          int temp = eightPuzzle.data[x][y];
          eightPuzzle.data[x][y] = eightPuzzle.data[x + 1][y];
          eightPuzzle.data[x + 1][y] = temp;
          //表示移动成功
      }
      //指令为向右移动
      else if (args == 3) {
          int temp = eightPuzzle.data[x][y];
          eightPuzzle.data[x][y] = eightPuzzle.data[x][y + 1];
          eightPuzzle.data[x][y + 1] = temp;
          //移动成功

      }
      //指令为向左移动
      else if (args == 4) {
          int temp = eightPuzzle.data[x][y];
          eightPuzzle.data[x][y] = eightPuzzle.data[x][y - 1];
          eightPuzzle.data[x][y - 1] = temp;
          //移动成功
      }
      //指令输入错误
      else {
          return null;
      }
      return eightPuzzle;
  }
}