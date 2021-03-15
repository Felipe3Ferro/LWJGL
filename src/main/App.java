package main;

import engine.Window;

public class App implements Runnable{
	public static Window window;
	public static final int WIDTH = 1200, HEIGHT = 760;
	public Thread game;
	public int frames;
	public static long time;
	
	
	public void start() {
		game = new Thread(this, "game");
		game.start();
	}
	
	public static void init() {
		System.out.println("Initializing Game!");
		window = new Window(WIDTH, HEIGHT, "Game");
		window.create();
		time = System.currentTimeMillis();
	}
	
	public void run() {
		init();
		while(!window.shouldClose()) {
			update();
			render();
		}
	}
	
	public void update() {
		//System.out.println("Updating Game!");
		window.update();
		frames ++;
		if(System.currentTimeMillis() > time + 1000) {
			System.out.println(frames);
			time = System.currentTimeMillis();
			frames = 0;
		}
	}
	
	public void render() {
		//System.out.println("Rendering Game!");
		window.swapBuffers();
	}
	
	public static void main(String[] args) {
		new App().start();
	}

}
