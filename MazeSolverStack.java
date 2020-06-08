package hw4;

public class MazeSolverStack extends MazeSolver {
	MyStack<Square> stack = new MyStack<>(maze.getMaze().length);

	MazeSolverStack(Maze maze){
		super(maze);
	}

	/**
	 * Make a new but same stack as the original stack.
	 */
	public void makeEmpty(){
		MyStack<Square> newStack = new MyStack<>(maze.getMaze().length);
	}

	/**
	 * Check if the stack is empty
	 * @return true if the stack is empty, else false
	 */
	public boolean isEmpty(){
		if(stack.size() == 0){
			return true;
		}
		else{
		return false;
		}
	}

	/**
	 * Add the square using the push method
	 */
	public void add(Square sq) {
		stack.push(sq);
	}

	/**
	 * Get the next square using the pop method
	 * @return stack.pop()
	 */
	public Square next() {
		return stack.pop();
	}

	/**
	 * @return stack
	 */
	public MyStack<Square> getStack() {
		return stack;
	}

	public static void main( String[] args )
	{
		Maze myMaze = new Maze();
		boolean load = myMaze.loadMaze(args[0]);
		if(!load) {
			System.out.println("Oops!! Could not load the Maze");
		} else {
			MazeSolverStack stackSolver = new MazeSolverStack(myMaze);
			stackSolver.solve();
			System.out.println(stackSolver.getPath() +"\n");
			System.out.println(stackSolver.getMaze().toString());
			System.out.println("Number of squares remaining in the worklist = "
			+ stackSolver.getStack().size() );
		}
	}
}
