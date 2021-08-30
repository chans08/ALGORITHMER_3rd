package Graph;

import java.util.HashSet;

public class 방의개수 {
	static class Point{
		int x,y,z;
		Point(int x, int y,int z){
			this.x = x;
			this.y = y;
			this.z = z; // 얘는 방향
		}
		@Override
		public boolean equals(Object obj) {
			Point p = (Point) obj;
			if(this.x == p.x && this.y == p.y && this.z == p.z)
				return true;
			else
				return false;
		}
		@Override
	    public int hashCode(){
	        int prime = 31;
	        int hashcode = 1;

	        hashcode = prime * hashcode + this.x;
	        hashcode = prime * hashcode + this.y;
	        hashcode = prime * hashcode + this.z;

	        return hashcode;
	    }
	}
	static class Node{
		int x,y;
		Node(int x, int y){
			this.x = x;
			this.y = y;
		}
		@Override
		public boolean equals(Object obj) {
			Node p = (Node) obj;
			if(this.x == p.x && this.y == p.y)
				return true;
			else
				return false;
		}
		@Override
	    public int hashCode(){
	        int prime = 31;
	        int hashcode = 1;
	        hashcode = prime * hashcode + this.x;
	        hashcode = prime * hashcode + this.y;
	        return hashcode;
	    }
	}
	public static int solution(int[] arrows) {
    	// 값에 따른 좌표 이동 값
    	int[] dx = {0,1,1,1,0,-1,-1,-1};
    	int[] dy = {1,1,0,-1,-1,-1,0,1};
    	int[] dz = {4,5,6,7,0,1,2,3};
    	int x1=0,y1=0,ans=0;
    	int x2,y2;
    	HashSet<Point> set = new HashSet<>();
    	HashSet<Node> node = new HashSet<>();
    	node.add(new Node(x1,y1));
    	for(int z : arrows) {
    		x2=x1+dx[z];
    		y2=y1+dy[z];
    		Point p1 = new Point(x1,y1,z);
    		Point p2 = new Point(x2,y2,dz[z]);
    		if(!set.contains(p1)) {	// 지나간적 없으면 set에 양쪽노드에 대해 저장
    			set.add(p1);
    			set.add(p2);
        		// 지나간적없는 길인데, 다시 노드에 접근한거라면 , 도형이 만들어지므로 ans+1 
    			if(node.contains(new Node(x2,y2))) {
            		//System.out.println("존재 : "+x2 +" "+y2);
    				ans+=1;
        		}
    			// 그게 아니면 새롭게 접근한 좌표이므로 추가
    			else {
    				node.add(new Node(x2,y2));
            		//System.out.println("없음 : "+x2+" "+y2);
    			}
    			
    			// (중요!) 신규 포인트가 대각선으로 그어졌는데, 기존꺼와 교차되었다면, 도형이 만들어지므로 ans+1
    			if(z%2==1) { // 대각이동체크
    				Point x;
    				switch(z) {
    				case 1:
    					x = new Point(x1,y1+1,3);
    					break;
    				case 3:
    					x = new Point(x1,y1-1,1);
    					break;
    				case 5:
    					x = new Point(x1,y1-1,7);
    					break;
    				case 7:
    					x = new Point(x1,y1+1,5);
    					break;
    				default:
    					x = new Point(0,0,0);
    				}					 				
    				if(set.contains(x))
						ans+=1;    				
    			}
    		}
    		x1=x2;
    		y1=y2;
    	}
    	return ans;
    }
    public static void main(String[] args) {
//    	int [] arrows = {6, 6, 6, 4, 4, 4, 2, 2, 2, 0, 0, 0, 1, 6, 5, 5, 3, 6, 0}; //result = 3
//    	int [] arrows = {6, 2, 4, 0, 5, 0, 6, 4, 2, 4, 2, 0}; //result = 3
    	int [] arrows = {5, 2, 7, 1, 6, 3}; //result = 3
//    	HashSet<point> set = new HashSet<>();
//    	point p1 = new point(0,0,0);
//    	point p2 = new point(0,0,0);
//    	set.add(p1);
//    	System.out.println(set.contains(p2));
    	System.out.println(solution(arrows));
	}
}
