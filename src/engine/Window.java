package engine;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWVidMode;

public class Window {
	private int width, height;
	private String title;
	private long window;
	
	public Window(int width, int height, String title) {
		super();
		this.width = width;
		this.height = height;
		this.title = title;
	}
	
	public void create() {
		if(!GLFW.glfwInit()) {
			System.out.println("ERROR: GLFW wasn't initializied");
			return;
		}
		
		window = GLFW.glfwCreateWindow(width, height, title, 0, 0);
		
		if(window == 0) {
			System.out.println("ERROR: Window wasn't initializied");
			return;
		}
		
		GLFWVidMode videoMode = GLFW.glfwGetVideoMode(GLFW.glfwGetPrimaryMonitor());
		GLFW.glfwSetWindowPos(window, videoMode.width()/2, videoMode.height()/2);
		GLFW.glfwMakeContextCurrent(window);
		
		GLFW.glfwShowWindow(window);
		
		GLFW.glfwSwapInterval(1);
	}
	
	public void update() {
		GLFW.glfwPollEvents();
	}
	
	public void swapBuffers() {
		GLFW.glfwSwapBuffers(window);
	}
	
	public boolean shouldClose() {
		return GLFW.glfwWindowShouldClose(window);
	}
}
