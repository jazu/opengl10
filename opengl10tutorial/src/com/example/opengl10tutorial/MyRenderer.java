package com.example.opengl10tutorial;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import android.opengl.GLSurfaceView.Renderer;
import android.opengl.GLU;

public class MyRenderer implements Renderer {

	smoothColoredSquare smoothCSquare= new smoothColoredSquare();
	flatColoredSquare flatCSquare = new flatColoredSquare();
	float angle=0.0f;
	float Mxspeed=-8.47f;
	float Pxspeed=8.47f;
	float x = 0.0f;
	float xv = 0.1f;
	
	
	public void onSurfaceCreated(GL10 gl, EGLConfig config) {
		gl.glClearColor(0.9f, 0.5f, 0.0f, 0.8f);
		gl.glShadeModel(GL10.GL_SMOOTH);
		gl.glClearDepthf(1.0f);
		gl.glEnable(GL10.GL_DEPTH_TEST);
		gl.glDepthFunc(GL10.GL_LEQUAL);
		gl.glHint(GL10.GL_PERSPECTIVE_CORRECTION_HINT, GL10.GL_NICEST);
		
		flatCSquare.resize(0.5f); 
	}
	
	public void onDrawFrame(GL10 gl) {
		gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
		gl.glLoadIdentity();
		gl.glTranslatef(0.0f,0.0f,-10.0f);
		
		//Square uno
		gl.glPushMatrix();
		gl.glTranslatef(x, 0.0f, 0.0f);
		
		gl.glRotatef(angle, 0.0f, 1.0f, 0.0f);
		flatCSquare.draw(gl);
		gl.glPopMatrix();
		
		angle += 1.0f;
		x += xv;
		if(x >= 8.47f || x <= -8.47) {
			xv = -xv;		
		}
	}
	
	public void onSurfaceChanged(GL10 gl, int width, int height) {
		gl.glViewport(0, 0, width, height);
		gl.glMatrixMode(GL10.GL_PROJECTION);
		gl.glLoadIdentity();
		GLU.gluPerspective(gl, 45.0f, (float) width / (float) height,
						   0.1f, 100.0f);
		gl.glMatrixMode(GL10.GL_MODELVIEW);
		
	
	} 
}

