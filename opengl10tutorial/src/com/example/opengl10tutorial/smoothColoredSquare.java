package com.example.opengl10tutorial;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

import javax.microedition.khronos.opengles.GL10;

public class smoothColoredSquare {
	private float vertices[] = {
			-1.0f, 1.0f, 0.0f,	//v0 top left
			-1.0f, -1.0f, 0.0f,	//v1 bottom left
			1.0f, -1.0f, 0.0f,	//v2 bottom right
			1.0f, 1.0f, 0.0f,	//v3 top right
		};
	
	float[] colors= {
			1f,0f,0f,1f, //v0 top left 		Red
			0f,1f,0f,1f, //v1 bottom left	Green
			0f,0f,1f,1f, //v2 bottom right	Blue
			1f,0f,1f,1f, //v3 top right		Magenta
	};		
	
	private short[] indices = {
		0,1,2,0,2,3	
	};
	
	private FloatBuffer vertexBuffer;
	
	private ShortBuffer indexBuffer;

	private FloatBuffer colorBuffer;
	
	public smoothColoredSquare() {
		ByteBuffer vbb = ByteBuffer.allocateDirect(vertices.length * 4);
		vbb.order(ByteOrder.nativeOrder());
		vertexBuffer = vbb.asFloatBuffer();
		vertexBuffer.put(vertices);
		vertexBuffer.position(0);
		
		ByteBuffer ibb = ByteBuffer.allocateDirect(indices.length * 2);
		ibb.order(ByteOrder.nativeOrder());
		indexBuffer = ibb.asShortBuffer();
		indexBuffer.put(indices);
		indexBuffer.position(0);
		
		ByteBuffer cbb = ByteBuffer.allocateDirect(colors.length*4);
		cbb.order(ByteOrder.nativeOrder());
		colorBuffer = cbb.asFloatBuffer();
		colorBuffer.put(colors);
		colorBuffer.position(0);
	}
		
	public void draw(GL10 gl) {
		gl.glColor4f(0.5f,0.5f,1.0f,1.0f);
		
		gl.glFrontFace(GL10.GL_CCW);
		gl.glEnable(GL10.GL_CULL_FACE);
		gl.glCullFace(GL10.GL_BACK);
		
		gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
		gl.glVertexPointer(3, GL10.GL_FLOAT, 0, vertexBuffer);
		
		gl.glEnableClientState(GL10.GL_COLOR_ARRAY);
		gl.glColorPointer(4, GL10.GL_FLOAT, 0, colorBuffer);
		
		gl.glDrawElements(GL10.GL_TRIANGLES, indices.length, GL10.GL_UNSIGNED_SHORT, indexBuffer);
	
		gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
		gl.glDisableClientState(GL10.GL_COLOR_ARRAY);
		
		gl.glDisable(GL10.GL_CULL_FACE);
	}
}
