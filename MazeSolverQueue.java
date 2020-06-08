package hw4;

public class MazeSolverQueue extends MazeSolver {
	MyQueue<Square> queue = new MyQueue<>(maze.getMaze().length);
	
	MazeSolverQueue(Maze maze){
		super(maze);
	}
	
	/**
	 * Make a new but same queue as the original queue.
	 */
	public void makeEmpty(){
		MyQueue<Square> newQueue = new MyQueue<>(maze.getMaze().length);
	}
	
	/**
	 * Check if the queue is empty
	 * @return true if the queue is empty, else false
	 */
	public boolean isEmpty(){
		if(queue.size() == 0){
			return true;
		}
		else{
		return false;
		}
	}
	
	/**
	 * Add the square using the enqueue method
	 */
	public void add(Square sq) {
		queue.enqueue(sq);
	}
	
	/**
	 * Get the next square using the pop method
	 * @return stack.pop()
	 */
	public Square next() {
		return queue.dequeue();
	}
	
	/**
	 * @return queue
	 */
	public MyQueue<Square> getQueue() {
		return queue;
	}

	public static void main( String[] args )
	  {
		Maze myMaze = new Maze();
		boolean load = myMaze.loadMaze(args[0]);
		if(!load) {
			System.out.println("Oops!! Could not load the Maze");
		} else {
			MazeSolverQueue queueSolver = new MazeSolverQueue(myMaze);
			queueSolver.solve();
			System.out.println(queueSolver.getPath() +"\n");
			System.out.println(queueSolver.getMaze().toString());
			System.out.println("Number of squares remaining in the worklist = "
			+ queueSolver.getQueue().size() );
		}
	  }
}

