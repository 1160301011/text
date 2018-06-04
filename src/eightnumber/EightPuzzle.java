package eightnumber;

import java.util.Arrays;

public class EightPuzzle implements Cloneable{
  
  /*利用一个二维的数组来存储数据*/
  public int[][] data;
  private int x,y;
  private int depth;
  
  //无参构造函数
  public EightPuzzle(){
      data = new int[3][3];
  }
  //传递一个数组，进行初始化的构造函数
  public EightPuzzle(int [][] data){
      this.data = data;
  }
  
  public boolean isEquals(EightPuzzle ep){
      return Arrays.deepEquals(this.data, ep.data);       
  }
  
  
  @Override
  public String toString(){
      StringBuffer sb = new StringBuffer(20);
      for (int i = 0; i < 3; i++){
          for (int j = 0; j < 3; j++){
              sb.append(this.data[i][j]);
              sb.append(" ");
          }
      }
      return sb.toString();
  }
  
  // 获取空格的位置
  public void getPostion() {
      for (int i = 0; i < 3; i++) {
          for (int j = 0; j < 3; j++) {
              if (this.data[i][j] == 0) {
                  this.setx(i);
                  this.sety(j);
              }
          }
      }
  }
  
  public void setx(int x) {
      this.x = x;
  }
  
  public void sety(int y) {
      this.y = y;
  }
  
  public int getx() {
      return x;
  }
  
  public int gety() {
      return y;
  }
  
  public int getDepth() {
      return depth;
  }
  
  public void setDepth(int depth) {
      this.depth = depth;
  }
  public static int calculate(EightPuzzle eightPuzzle,EightPuzzle eightPuzzle2){
    int size = 0;
    for(int i = 0;i < 3;i++){
      for(int j = 0;j < 3;j++){
        if(eightPuzzle.data[i][j]!=eightPuzzle2.data[i][j]){
          size++;
        }
      }
    }
    return size;
  }
  public void print(){
      System.out.println(this.toString());
  }
  
  //浅拷贝
  @Override
  protected EightPuzzle clone() throws CloneNotSupportedException {
      // TODO Auto-generated method stub
      return new EightPuzzle(Arrays.copyOf(this.data, this.data.length));
  }
  //深拷贝
  public EightPuzzle depthClone(){
      EightPuzzle eightPuzzle = new EightPuzzle();
      for (int i = 0 ; i < 3; i++)
          for (int j = 0 ; j < 3; j++)
        	  eightPuzzle.data[i][j] = this.data[i][j];
      eightPuzzle.depth = this.depth;
      return eightPuzzle;
  }
  
  public static void main(String[] args) {
      
  }
  @Override
  public boolean equals(Object obj) {
      // TODO Auto-generated method stub
      return this.isEquals((EightPuzzle)obj);
      //&&(this.getDepth() == ((EightPuzzle)obj).getDepth()
  }
  
}