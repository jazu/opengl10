package com.example.opengl10tutorial;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import android.opengl.GLSurfaceView.Renderer;
import android.opengl.GLU;

public class MyRenderer implements Renderer {

	Square square = new Square();
	float angle;
	
	public void onSurfaceCreated(GL10 gl, EGLConfig config) {
		gl.glClearColor(0.9f, 0.5f, 0.0f, 0.8f);
		gl.glShadeModel(GL10.GL_SMOOTH);
		gl.glClearDepthf(1.0f);
		gl.glEnable(GL10.GL_DEPTH_TEST);
		gl.glDepthFunc(GL10.GL_LEQUAL);
		gl.glHint(GL10.GL_PERSPECTIVE_CORRECTION_HINT, GL10.GL_NICEST);
	}
	
	public void onDrawFrame(GL10 gl) {
		gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
		gl.glLoadIdentity();
		gl.glTranslatef(0.0f,0.0f,-10.0f);
		
		//Square uno
		gl.glPushMatrix();
		gl.glRotatef(angle, 0.0f, 0.0f, 1.0f);
		square.draw(gl);
		gl.glPopMatrix();
		
		//Square dos
		gl.glPushMatrix();
		gl.glRotatef(-angle, 0.0f, 0.0f, 1.0f);
		gl.glTranslatef(2.0f, 0.0f, 0.0f);
		gl.glScalef(0.5f, 0.5f, 0.5f);
		square.draw(gl);
		gl.glPopMatrix();
		
		//Square trés
		gl.glPushMatrix();
		gl.glRotatef(-angle, 0.0f, 0.0f, 1.0f);
		gl.glTranslatef(2.0f, 0.0f, 0.0f);
		gl.glScalef(0.5f, 0.5f, 0.5f);
		gl.glRotatef(angle*10.0f, 0.0f, 0.0f, 1.0f);
		square.draw(gl);
		gl.glPopMatrix();
		
		
		angle++;
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

