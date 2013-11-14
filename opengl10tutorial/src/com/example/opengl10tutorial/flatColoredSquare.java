package com.example.opengl10tutorial;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

import javax.microedition.khronos.opengles.GL10;

public class flatColoredSquare {
	
	public void resize(float mult) {
		for(int i=0; i<vertices.length; i++) {
			vertices[i] = vertices[i]*mult;
		}
		ByteBuffer vbb = ByteBuffer.allocateDirect(vertices.length * 4);
		vbb.order(ByteOrder.nativeOrder());
		vertexBuffer = vbb.asFloatBuffer();
		vertexBuffer.put(vertices);
		vertexBuffer.position(0);
	}
	private float vertices[] = {
			-1.0f, 1.0f, 0.0f,	//v0 top left
			-1.0f, -1.0f, 0.0f,	//v1 bottom left
			1.0f, -1.0f, 0.0f,	//v2 bottom right
			1.0f, 1.0f, 0.0f,	//v3 top right
		};
	
	private short[] indices = {
		0,1,2,0,2,3	
	};
	
	private FloatBuffer vertexBuffer;
	
	private ShortBuffer indexBuffer;
	
	public flatColoredSquare() {
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
	}
		
	public void draw(GL10 gl) {
		gl.glColor4f(0.5f,0.5f,1.0f,1.0f);
		
		gl.glFrontFace(GL10.GL_CCW);
	//	gl.glEnable(GL10.GL_CULL_FACE);
		gl.glCullFace(GL10.GL_BACK);
		
		gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
		gl.glVertexPointer(3, GL10.GL_FLOAT, 0, vertexBuffer);
		
		gl.glDrawElements(GL10.GL_TRIANGLES, indices.length, GL10.GL_UNSIGNED_SHORT, indexBuffer);
	
		gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
		
		gl.glDisable(GL10.GL_CULL_FACE);
	}
}
