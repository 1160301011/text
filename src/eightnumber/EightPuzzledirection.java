package eightnumber;

public class EightPuzzledirection {

  //�ж��ǲ��ǿ��Լ����ƶ�
  public static boolean canmove(int x, int y, int direction) {
      if ((direction == 1 && x == 0) || (direction == 2 && x == 2)
              || (direction == 3 && y == 2) || (direction == 4 && y == 0)) {
          return false;
      }
      return true;
  }

  //���ݸ����Ĳ��������пո�λ�õ��ƶ�
  //����1��ʾ���ϣ�2��ʾ���ң�-1��ʾ���£�-2��ʾ����
  public static EightPuzzle movePosition(EightPuzzle ep, int args) {
      
      EightPuzzle eightPuzzle = null;

      eightPuzzle = ep.depthClone();
      eightPuzzle.getPostion();
      int x = eightPuzzle.getx(), y = eightPuzzle.gety();

      //ָ��Ϊ�����ƶ�
      if (args == 1) {
          int temp = eightPuzzle.data[x][y];
          eightPuzzle.data[x][y] = eightPuzzle.data[x - 1][y];
          eightPuzzle.data[x - 1][y] = temp;
          //�ƶ��ɹ�
      }
      //ָ��Ϊ�����ƶ�
      else if (args == 2) {
          int temp = eightPuzzle.data[x][y];
          eightPuzzle.data[x][y] = eightPuzzle.data[x + 1][y];
          eightPuzzle.data[x + 1][y] = temp;
          //��ʾ�ƶ��ɹ�
      }
      //ָ��Ϊ�����ƶ�
      else if (args == 3) {
          int temp = eightPuzzle.data[x][y];
          eightPuzzle.data[x][y] = eightPuzzle.data[x][y + 1];
          eightPuzzle.data[x][y + 1] = temp;
          //�ƶ��ɹ�

      }
      //ָ��Ϊ�����ƶ�
      else if (args == 4) {
          int temp = eightPuzzle.data[x][y];
          eightPuzzle.data[x][y] = eightPuzzle.data[x][y - 1];
          eightPuzzle.data[x][y - 1] = temp;
          //�ƶ��ɹ�
      }
      //ָ���������
      else {
          return null;
      }
      return eightPuzzle;
  }
}