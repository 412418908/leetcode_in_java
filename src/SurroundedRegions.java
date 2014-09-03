import java.util.LinkedList;
import java.util.List;

/**
 * Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.
 * 
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 *
 * answer: �����������ĸ��߽���O��Ȼ�����BFS���ҵ��Ķ���Ҫ�����ģ�������һ���޸��ַ����ɡ�
 * �ر�ע����һ������ board �ǿգ����Խ����жϷ���ᵼ��RE
 * 
 */
public class SurroundedRegions {
	class Point{
		int x,y;
		Point(int i,int j){x=i;y=j;}
	}
    public void solve(char[][] board) {
    	int m = board.length;
    	if(m == 0){		//�пշ�ֹ run-time error�����ܺ� n һ���ж�
    		return;
    	}
    	int n = board[0].length;
    	if(n == 0){		//�пշ�ֹ run-time error
    		return;
    	}
    	for(int i=0;i<m;i++){
    		bfs(board,i,0);
    		bfs(board,i,n-1);
    	}
    	for(int j=0;j<n;j++){
    		bfs(board,0,j);
    		bfs(board,m-1,j);
    	}
    	
    	for(int i=0;i<m;i++){
    		for(int j=0;j<n;j++){
    			if(board[i][j] == 'O'){
    				board[i][j] = 'X';
    			}else if(board[i][j] == 'A'){
    				board[i][j] = 'O';
    			}
    		}
    	}

    }
    
    private void bfs(char[][] board,int x,int y){
    	if(board[x][y] != 'O'){
    		return ;
    	}
    	LinkedList<Point> queue = new LinkedList<>();
    	queue.add(new Point(x,y));
    	board[x][y] = 'A';
    	while(!queue.isEmpty()){
    		Point top = queue.poll();
    		int i = top.x;
    		int j = top.y;
    		addPoint(board,i-1,j,queue);
    		addPoint(board,i+1,j,queue);
    		addPoint(board,i,j-1,queue);
    		addPoint(board,i,j+1,queue);
    	}
    }
    
    private boolean addPoint(char[][] board,int x,int y,LinkedList<Point> queue){
    	if(x < 0 || x > board.length-1 || y < 0 || y > board[0].length-1 || board[x][y] != 'O'){
    		return false;
    	}else{
    	    queue.add(new Point(x,y));
    	    board[x][y] = 'A';
    		return true;
    	}
    }
}
