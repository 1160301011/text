package eightnumber;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class treesearch {

	private int[][] source = new int[3][3];
	private int[][] target = new int[3][3];
	private EightPuzzle eightPuzzle, targeteightPuzzle;
	private int depth = 0;
	private Stack<EightPuzzle> stack = new Stack<EightPuzzle>();
	private LinkedList<EightPuzzle> searched_list = new LinkedList<EightPuzzle>();
	private Queue<EightPuzzle> queue = new LinkedList<EightPuzzle>();

	public treesearch() {

		// 初始化
		stack.clear();
		searched_list.clear();
		queue.clear();

		Scanner scanner = new Scanner(System.in);
		// 输入初始位置
		System.out.println("请输入初始位置（其中输入0代表空白块，例如：2 8 3 1 0 4 7 6 5）：");
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				source[i][j] = scanner.nextInt();
			}
		}
		// 输入目标位置
		System.out.println("请输入目标位置（其中输入0代表空白块，例如：2 8 3 1 4 0 7 6 5）：");
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				target[i][j] = scanner.nextInt();
			}
		}

		eightPuzzle = new EightPuzzle(source);
		eightPuzzle.setDepth(depth);
		// 设置栈底元素
		stack.push(eightPuzzle);
		targeteightPuzzle = new EightPuzzle(target);
		scanner.close();
		// 设置队首元素
		queue.offer(eightPuzzle);
	}

	// 深度优先搜索
	// 栈的方式实现
	public void depthFirstSearch() {
		long start = System.currentTimeMillis(); 
		//System.out.println("深度优先搜索方法路径！");
		if (!searched_list.isEmpty())
			searched_list.clear();//清空搜索列表
		while (!stack.isEmpty()) {
			EightPuzzle moveeightPuzzle = stack.pop();
			depth = moveeightPuzzle.getDepth();
			moveeightPuzzle.getPostion();
			int x = moveeightPuzzle.getx();
			int y = moveeightPuzzle.gety();
			//moveeightPuzzle.print();
			searched_list.add(moveeightPuzzle);
			if (moveeightPuzzle.isEquals(targeteightPuzzle)) {
				System.out.println("可达");
				long end = System.currentTimeMillis();
		        System.out.println("Depth-First "+(end - start + "ms"));  
				return;
			}
			depth++;
			EightPuzzle temp = null;
			temp = moveeightPuzzle.depthClone();
			if (EightPuzzledirection.canmove(x, y, 1)) {
				temp = EightPuzzledirection.movePosition(moveeightPuzzle, 1);
				temp.setDepth(depth);
				if (!searched_list.contains(temp)) {
					stack.push(temp);
				}
			}
			if (EightPuzzledirection.canmove(x, y, 2)) {
				temp = EightPuzzledirection.movePosition(moveeightPuzzle, 2);
				temp.setDepth(depth);
				if (!searched_list.contains(temp)) {
					stack.push(temp);
				}
			}
			if (EightPuzzledirection.canmove(x, y, 3)) {
				temp = EightPuzzledirection.movePosition(moveeightPuzzle, 3);
				temp.setDepth(depth);
				if (!searched_list.contains(temp)) {
					stack.push(temp);
				}
			}
			if (EightPuzzledirection.canmove(x, y, 4)) {
				temp = EightPuzzledirection.movePosition(moveeightPuzzle, 4);
				temp.setDepth(depth);
				if (!searched_list.contains(temp)) {
					stack.push(temp);
				}
			}
		}
		System.out.println("不可达");
	}

	// 宽度（广度）优先搜索实现
	public void breadthFirstSearch() {
		long start = System.currentTimeMillis();
		if (!searched_list.isEmpty())
			searched_list.clear();//清空搜索列表
		//System.out.println("广度优先搜索方法路径！");
		while (!queue.isEmpty()) {
			EightPuzzle moveeightPuzzle = queue.poll();
			depth = moveeightPuzzle.getDepth();
			moveeightPuzzle.getPostion();
			int x = moveeightPuzzle.getx();
			int y = moveeightPuzzle.gety();
			//moveeightPuzzle.print();
			searched_list.add(moveeightPuzzle);

			if (moveeightPuzzle.isEquals(targeteightPuzzle)) {
				//System.out.println("已找到目标搜素路径");
				long end = System.currentTimeMillis();
		        System.out.println("Breadth-First "+(end - start + "ms"));
				return;
			}
			depth++;
			EightPuzzle temp = null;
			temp = moveeightPuzzle.depthClone();
			if (EightPuzzledirection.canmove(x, y, 1)) {
				temp = EightPuzzledirection.movePosition(moveeightPuzzle, 1);
				temp.setDepth(depth);
				if (!searched_list.contains(temp)) {
					queue.offer(temp);
				}
			}
			if (EightPuzzledirection.canmove(x, y, 2)) {
				temp = EightPuzzledirection.movePosition(moveeightPuzzle, 2);
				temp.setDepth(depth);
				if (!searched_list.contains(temp)) {
					queue.offer(temp);
				}
			}
			if (EightPuzzledirection.canmove(x, y, 3)) {
				temp = EightPuzzledirection.movePosition(moveeightPuzzle, 3);
				temp.setDepth(depth);
				if (!searched_list.contains(temp)) {
					queue.offer(temp);
				}
			}
			if (EightPuzzledirection.canmove(x, y, 4)) {
				temp = EightPuzzledirection.movePosition(moveeightPuzzle, 4);
				temp.setDepth(depth);
				if (!searched_list.contains(temp)) {
					queue.offer(temp);
				}
			}
		}
		//System.out.println("没有搜索到需要的目标");
	}
	public void hillclimb(){
	  long start = System.currentTimeMillis(); 
	//System.out.println("hill-climb方法路径！");
    if (!searched_list.isEmpty())
      searched_list.clear();
    while (!stack.isEmpty()) {
      EightPuzzle moveeightPuzzle = stack.pop();
      depth = moveeightPuzzle.getDepth();
      moveeightPuzzle.getPostion();
      int x = moveeightPuzzle.getx();
      int y = moveeightPuzzle.gety();
      //moveeightPuzzle.print();
      searched_list.add(moveeightPuzzle);
      if (moveeightPuzzle.isEquals(targeteightPuzzle)) {
        long end = System.currentTimeMillis();
        System.out.println("hill-climb "+(end - start + "ms"));
        return;
      }
      if (depth < 4) {
        depth++;
        EightPuzzle temp = null;
        temp = moveeightPuzzle.depthClone();
        if (EightPuzzledirection.canmove(x, y, 1)) {
          temp = EightPuzzledirection.movePosition(moveeightPuzzle, 1);
          temp.setDepth(depth);
          if (!searched_list.contains(temp)||(searched_list.contains(temp)&&
              searched_list.get(searched_list.indexOf(temp)).getDepth()!=temp.getDepth())) {
            stack.push(temp);
          }
        }
        if (EightPuzzledirection.canmove(x, y, 2)) {
          temp = EightPuzzledirection.movePosition(moveeightPuzzle, 2);
          temp.setDepth(depth);
          if (!searched_list.contains(temp)||(searched_list.contains(temp)&&
              searched_list.get(searched_list.indexOf(temp)).getDepth()!=temp.getDepth())) {
            stack.push(temp);
          }
        }
        if (EightPuzzledirection.canmove(x, y, 3)) {
          temp = EightPuzzledirection.movePosition(moveeightPuzzle, 3);
          temp.setDepth(depth);
          if (!searched_list.contains(temp)||(searched_list.contains(temp)&&
              searched_list.get(searched_list.indexOf(temp)).getDepth()!=temp.getDepth())) {
            stack.push(temp);
          }
        }
        if (EightPuzzledirection.canmove(x, y, 4)) {
          temp = EightPuzzledirection.movePosition(moveeightPuzzle, 4);
          temp.setDepth(depth);
          if (!searched_list.contains(temp)||(searched_list.contains(temp)&&
              searched_list.get(searched_list.indexOf(temp)).getDepth()!=temp.getDepth())) {
            stack.push(temp);
          }
        }
      }
    }
    //System.out.println("没有搜索到需要的目标");
	}
	//Best-First搜索
	public void best_first() {
    long start = System.currentTimeMillis();
    if (!searched_list.isEmpty())
      searched_list.clear();//清空搜索列表
    //System.out.println("best_first方法路径！");
    while (!queue.isEmpty()) {
      EightPuzzle moveeightPuzzle = queue.poll();
      depth = moveeightPuzzle.getDepth();
      moveeightPuzzle.getPostion();
      int x = moveeightPuzzle.getx();
      int y = moveeightPuzzle.gety();
      //moveeightPuzzle.print();
      searched_list.add(moveeightPuzzle);

      if (moveeightPuzzle.isEquals(targeteightPuzzle)) {
        //System.out.println("已找到目标搜素路径");
        long end = System.currentTimeMillis();
            System.out.println("Best-First "+(end - start + "ms"));
        return;
      }
      depth++;
      EightPuzzle temp = null;
      temp = moveeightPuzzle.depthClone();
      if (EightPuzzledirection.canmove(x, y, 1)) {
        temp = EightPuzzledirection.movePosition(moveeightPuzzle, 1);
        temp.setDepth(depth);
        if (!searched_list.contains(temp)) {
          queue.offer(temp);
        }
      }
      if (EightPuzzledirection.canmove(x, y, 2)) {
        temp = EightPuzzledirection.movePosition(moveeightPuzzle, 2);
        temp.setDepth(depth);
        if (!searched_list.contains(temp)) {
          queue.offer(temp);
        }
      }
      if (EightPuzzledirection.canmove(x, y, 3)) {
        temp = EightPuzzledirection.movePosition(moveeightPuzzle, 3);
        temp.setDepth(depth);
        if (!searched_list.contains(temp)) {
          queue.offer(temp);
        }
      }
      if (EightPuzzledirection.canmove(x, y, 4)) {
        temp = EightPuzzledirection.movePosition(moveeightPuzzle, 4);
        temp.setDepth(depth);
        if (!searched_list.contains(temp)) {
          queue.offer(temp);
        }
      }
    }
    //System.out.println("没有搜索到需要的目标");
  }
	public List<EightPuzzle> sort(List<EightPuzzle> eightPuzzles,EightPuzzle eightPuzzle){
	  Map<Integer, EightPuzzle> map = new HashMap<Integer, EightPuzzle>();
	  List<Integer> eIntegers = new ArrayList<Integer>();
	  for(int i = 0;i < eightPuzzles.size();i++){
	    map.put(EightPuzzle.calculate(eightPuzzles.get(0), eightPuzzle), eightPuzzles.get(0));
	    eIntegers.add(EightPuzzle.calculate(eightPuzzles.get(0), eightPuzzle));
	  }
	  int[] eight = new int[eIntegers.size()];
	  for(int i = 0;i < eIntegers.size();i++){
	    eight[i] = eIntegers.get(i);
	  }
	  for(int i = 0;i < eight.length;i++){
	    for(int j = 0;j < eight.length;j++){
	      int temp = eight[i];
	      eight[i] = eight[j];
	      eight[j] = temp;
	    }
	  }
	  List<EightPuzzle> eightPuzzles2 = new ArrayList<EightPuzzle>();
	  for(int i = 0;i<eight.length;i++){
	    eightPuzzles2.add(map.get(eight[i]));
	  }
	  return eightPuzzles2;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		treesearch epa = new treesearch();
		epa.depthFirstSearch();
		epa.breadthFirstSearch();
		epa.hillclimb();
		epa.best_first();
	}
	/*
	 * 测试用例 【1】2 8 3 1 0 4 7 6 5 2 8 3 1 4 0 7 6 5 【2】2 8 3 1 0 4 7 6 5
	 * 
	 */
}
