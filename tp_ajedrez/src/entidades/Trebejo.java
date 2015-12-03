package entidades;

import entidades.Posicion;

public abstract class Trebejo {

	private int idTrebejo;
	private String color = "0";
	private Posicion posicion;
	private boolean estado = true;
	private char nombre;

	public int getidTrebejo() {
		return idTrebejo;
	}
	public void setidTrebejo(int idTrebejo) {
		this.idTrebejo = idTrebejo;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public Posicion getPosicion() {
		return posicion;
	}
	public void setPosicion(Posicion posicion) {
		this.posicion = posicion;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	public abstract boolean isMovimientoValido(Posicion p, Trebejo trebejop);

	public char getNombre(){
		return nombre;
	}
	public void moverA(Posicion p){
		this.posicion= p;
	}
	public void setNombre(char nombre) {
		this.nombre = nombre;
	}






}
