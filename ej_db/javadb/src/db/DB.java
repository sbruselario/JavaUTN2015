package db;

import java.sql.*;
import java.util.ArrayList;

import entidades.Persona;

public class DB {




	//para agregar una persona a la db
	public String add(String dni, String nombre, String apellido, String email) throws ClassNotFoundException, SQLException{

		Persona per;

		ResultSet rs=null;
		PreparedStatement stmt=null;


		try {
			stmt = FactoryConexion.getInstancia().getConexion().prepareStatement(
					"insert into personas(dni, nombre, apellido, email) values (?,?,?,?)",PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setString(1, dni);
			stmt.setString(2, nombre);
			stmt.setString(3, apellido);
			stmt.setString(4, email);
			stmt.execute();

			rs=stmt.getGeneratedKeys();

			if(rs!=null && rs.next()){
				return (rs.getString(1));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{

			try {
				if(rs!=null ) rs.close();
				if(stmt != null) stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			FactoryConexion.getInstancia().releaseConexion();
		}

		return null;

	}

	public String add(Persona per) throws ClassNotFoundException, SQLException{

		ResultSet rs=null;
		PreparedStatement stmt=null;


		try {
			stmt = FactoryConexion.getInstancia().getConexion().prepareStatement(
					"insert into personas(dni, nombre, apellido, email) values (?,?,?,?)",PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setString(1, per.getDni());
			stmt.setString(2, per.getNombre());
			stmt.setString(3, per.getApellido());
			stmt.setString(4, per.getEmail());
			stmt.execute();

			rs=stmt.getGeneratedKeys();

			if(rs!=null && rs.next()){
				return (rs.getString(1));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{

			try {
				if(rs!=null ) rs.close();
				if(stmt != null) stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			FactoryConexion.getInstancia().releaseConexion();
		}

		return null;

	}



	public void update(Persona nPer){
		Persona per = this.buscarDni(nPer.getDni());
		per.setNombre(nPer.getNombre());
		per.setApellido(nPer.getApellido());
		per.setEmail(nPer.getEmail());

		PreparedStatement stmt=null;

		try {
			stmt = FactoryConexion.getInstancia().getConexion().prepareStatement(
					"update personas set nombre = ?, apellido = ?, email = ? where dni = ? ;");
			stmt.setString(4, per.getDni());
			stmt.setString(1, per.getNombre());
			stmt.setString(2, per.getApellido());
			stmt.setString(3, per.getEmail());
			stmt.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			FactoryConexion.getInstancia().releaseConexion();
		}


	}


	public void borrar(Persona nPer){

		PreparedStatement stmt=null;

		try {
			stmt = FactoryConexion.getInstancia().getConexion().prepareStatement(
					"delete from personas where dni = ? ;");
			stmt.setString(1, nPer.getDni());
			stmt.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			FactoryConexion.getInstancia().releaseConexion();
		}


	}



	public Persona buscarDni(String dni){
		ResultSet rs=null;
		PreparedStatement stmt=null;
		Persona p=null;
		try {
			stmt = 	FactoryConexion.getInstancia().getConexion().prepareStatement(
					"select id, dni, nombre, apellido, email from personas where dni = ?");
			stmt.setString(1, dni);
			rs = stmt.executeQuery();
			if(rs !=null && rs.next()){
				p=new Persona(rs.getString("id"), rs.getString("dni"),rs.getString("nombre"),rs.getString("apellido"),rs.getString("email"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try {
				if(rs!=null)rs.close();
				if(stmt!=null) stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			FactoryConexion.getInstancia().releaseConexion();
		}
		return p;
	}




	//para leer todas las personas de la db
	public ArrayList<Persona> getAll() throws ClassNotFoundException, SQLException{
		ArrayList<Persona> listado = new ArrayList<Persona>();
		ResultSet rs=null;
		PreparedStatement stmt=null;

		try {
			stmt = 	FactoryConexion.getInstancia().getConexion().prepareStatement("select * from personas;");
			rs = stmt.executeQuery();	

			while(rs.next()){
				String id= rs.getString("id");
				String dni= rs.getString("dni");
				String nombre=rs.getString("nombre");
				String apellido=rs.getString("apellido");
				String email=rs.getString("email");

				listado.add(new Persona(id,dni,nombre,apellido,email));
			}	


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try {
				if(rs!=null)rs.close();
				if(stmt!=null) stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			FactoryConexion.getInstancia().releaseConexion();
		}

		return listado;

	}






}
