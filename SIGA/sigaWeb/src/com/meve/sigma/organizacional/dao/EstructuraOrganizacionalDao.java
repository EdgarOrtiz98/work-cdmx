package com.meve.sigma.organizacional.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.meve.sigma.actualiza.ActualizaParamCorreo;
import com.meve.sigma.beans.UsuarioBean;
import com.meve.sigma.catalogos.CatalogoRol;
import com.meve.sigma.catalogos.dao.RolDao;
import com.meve.sigma.db2.ConexionDS;
import com.meve.sigma.organizacional.puesto.PuestoForm;
import com.meve.sigma.organizacional.vo.AreaVO;
import com.meve.sigma.organizacional.vo.PuestoVO;
import com.meve.sigma.sql.SQLUsuario;

public class EstructuraOrganizacionalDao {

	public static List getPuestos(Connection conn, int idArea) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT ID_USUARIO, USU_JEFE, USU_CARGO, USU_NOMBRE , USU_AREA FROM SD_USUARIO WHERE USU_AREA = ? AND USU_ESTATUS = 1 ORDER BY USU_AREA";
		List usuarios = new ArrayList();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idArea);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				PuestoVO puesto = new PuestoVO();
				puesto.setIdUsuario(rs.getInt("ID_USUARIO"));
				puesto.setIdJefe(rs.getInt("USU_JEFE"));
				puesto.setNombre(rs.getString("USU_CARGO"));
				puesto.setCargo(rs.getString("USU_NOMBRE"));
				puesto.setIdArea(rs.getInt("USU_AREA"));
				usuarios.add(puesto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConexionDS.endConnection(rs, pstmt, null);
		}
		return usuarios;
	}

	public static List getReleacionAsistentes(Connection conn, int idArea) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT ASI_ASISTENTE, ASI_USUARIO  FROM SD_ASISTENTES WHERE ASI_ASISTENTE "
				+ "IN(SELECT ID_USUARIO FROM SD_USUARIO WHERE USU_AREA = ? AND USU_ESTATUS = 1) ORDER BY ASI_ASISTENTE ";
		List relacionAsistentes = new ArrayList();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idArea);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int[] registro = new int[2];
				registro[0] = rs.getInt("ASI_ASISTENTE");
				registro[1] = rs.getInt("ASI_USUARIO");
				relacionAsistentes.add(registro);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConexionDS.endConnection(rs, pstmt, null);
		}
		return relacionAsistentes;
	}

	public static List getReleacionRoles(Connection conn, int idArea) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT ID_USUARIO1, ID_ROL  FROM SD_USUARIO_ROL WHERE ID_USUARIO1 "
				+ "IN(SELECT ID_USUARIO FROM SD_USUARIO WHERE USU_AREA = ? AND USU_ESTATUS = 1) ORDER BY ID_USUARIO1 ";
		List relacionRoles = new ArrayList();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idArea);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int[] registro = new int[2];
				registro[0] = rs.getInt("ID_USUARIO1");
				registro[1] = rs.getInt("ID_ROL");
				relacionRoles.add(registro);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConexionDS.endConnection(rs, pstmt, null);
		}
		return relacionRoles;
	}

	public static UsuarioBean getDestinatario(Connection conn, int idUsuario) {
		String sql = "SELECT USU_NOMBRE, USU_CARGO FROM SD_USUARIO WHERE ID_USUARIO = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		UsuarioBean usuario = new UsuarioBean();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idUsuario);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				usuario.setStrNombre(rs.getString("USU_CARGO"));// Esta asi
				// porque en la
				// base de datos
				// esta al revez
				usuario.setStrCargo(rs.getString("USU_NOMBRE"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConexionDS.endConnection(rs, pstmt, null);
		}
		return usuario;
	}

	public static List getAreas(Connection conn) {
		String sql = "SELECT ID_AREA, ARE_NOMBRE, ARE_ID_PADRE, ARE_SUPERVISOR FROM SD_AREA WHERE ARE_ESTATUS = 1 ORDER BY ID_AREA";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List areas = new ArrayList();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				AreaVO area = new AreaVO();
				area.setIdArea(rs.getInt("ID_AREA"));
				area.setNombre(rs.getString("ARE_NOMBRE"));
				area.setIdAreaPadre(rs.getString("ARE_ID_PADRE") == null
						|| rs.getString("ARE_ID_PADRE") == "null" ? -1 : rs
						.getInt("ARE_ID_PADRE"));
				area.setIdResponsable(rs.getInt("ARE_SUPERVISOR"));
				areas.add(area);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConexionDS.endConnection(rs, pstmt, null);
		}
		return areas;
	}

	public static void setPuesto(Connection conn, int idUsuario, PuestoForm pf) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT ID_USUARIO, USU_NOMBRE, USU_CARGO, "
				+ "USU_CORREO, USU_TELEFONO, USU_AREA, USU_FEC_ACTUALIZACION, "
				+ "USU_ESTATUS, USU_ASISTENTE, USU_JEFE, USU_USR_ACTUALIZO, "
				+ "USU_CONSECUTIVO, USU_ROL, USU_ACTIVO, USU_INTENTOS, USU_UID, "
				+ "USU_CAT, USU_NOTIFICACION, USU_BANDERA, AUT_CLAVE_USUARIO,USU_SUBVENTANILLA  "
				+ "FROM SD_USUARIO, SD_AUTENTIFICACION "
				+ "WHERE ID_USUARIO = ? AND AUT_NOMBRE_USUARIO=USU_UID";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idUsuario);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				pf.setUsuario(rs.getString("USU_UID"));
				pf.setPassword(rs.getString("AUT_CLAVE_USUARIO"));
				pf.setIdPuesto(rs.getInt("ID_USUARIO"));
				pf.setPuesto(rs.getString("USU_NOMBRE"));
				pf.setResponsable(rs.getString("USU_CARGO"));
				pf.setCorreo(rs.getString("USU_CORREO"));
				pf.setTelefono(rs.getString("USU_TELEFONO"));
				pf.setIdUnidadAdministrativa(rs.getInt("USU_AREA"));
				pf.setIdJefe(rs.getInt("USU_JEFE"));
				pf.setCatalogoArchivado(rs.getInt("USU_CAT") == 1);
				pf.setCorresEntrada(rs.getInt("USU_NOTIFICACION") == 0);
				pf.setAtencionExternos(rs.getInt("USU_BANDERA") == 1);
				pf.setIdSubventanilla(rs.getInt("USU_SUBVENTANILLA"));
				List roles = RolDao.getRoles(idUsuario, conn);
				String[] rolesString = new String[roles.size()];
				for (int i = 0; i < roles.size(); i++) {
					rolesString[i] = String
							.valueOf(((CatalogoRol) roles.get(i)).getId());
				}
				String[][] paramCorreos = ActualizaParamCorreo
						.getParamCorreo(String.valueOf(idUsuario));
				String[] idCorreosSalida = new String[paramCorreos.length];
				for (int i = 0; i < paramCorreos.length; i++) {
					idCorreosSalida[i] = paramCorreos[i][0];
				}
				pf.setIdRoles(rolesString);
				pf.setIdCorreosSalida(idCorreosSalida);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConexionDS.endConnection(rs, pstmt, null);
		}

	}

	public static boolean insertaUsuario(PuestoForm puesto, Connection conn) {
		String sql = "INSERT INTO SD_USUARIO (ID_USUARIO, USU_NOMBRE, USU_AREA, USU_CARGO, USU_CORREO, "
				+ "USU_TELEFONO, USU_INTENTOS, USU_JEFE, USU_USR_ACTUALIZO, USU_FEC_ACTUALIZACION, "
				+ "USU_ESTATUS, USU_UID, USU_CAT, USU_NOTIFICACION, USU_BANDERA, "
				+ "USU_SUBVENTANILLA)"
				+ " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

		PreparedStatement pstmt = null;
		try {
			puesto.setIdPuesto(getMaxUsuarioID(conn) + 1);
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, puesto.getIdPuesto());
			pstmt.setString(2, puesto.getPuesto());// Lo pongo al revez porque
			// asi ya etaba
			pstmt.setInt(3, puesto.getIdUnidadAdministrativa());
			pstmt.setString(4, puesto.getResponsable());
			pstmt.setString(5, puesto.getCorreo());
			pstmt.setString(6, puesto.getTelefono());
			pstmt.setInt(7, 0);// intentos para logearse a la app
			pstmt.setInt(8, puesto.getIdJefe());
			pstmt.setInt(9, puesto.getIdUsuarioActualizo());
			pstmt.setDate(10, new Date(new java.util.Date().getTime()));
			pstmt.setInt(11, 1);// TODO: ver cual es el estatus correcto
			pstmt.setString(12, puesto.getUsuario());
			pstmt.setInt(13, puesto.isCatalogoArchivado() ? 1 : 0);
			pstmt.setInt(14, puesto.isCorresEntrada() ? 1 : 0);
			pstmt.setInt(15, puesto.isAtencionExternos() ? 1 : 0);
			pstmt.setInt(16, 0);// TODO averiguar que es subventanilla
			return pstmt.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConexionDS.endConnection(null, pstmt, null);
		}
		return false;
	}

	public static boolean asignaAsistentes(PuestoForm puesto, Connection conn) {
		String sql = "INSERT INTO SD_ASISTENTES (ASI_USUARIO, ASI_ASISTENTE) VALUES(?,?)";
		PreparedStatement pstmt = null;
		if (quitaAsistentes(puesto.getIdPuesto(), conn)) {
			for (int i = 0; i < puesto.getIdAsistentes().length; i++) {
				try {
					pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1, puesto.getIdPuesto());
					pstmt.setInt(2, Integer
							.parseInt(puesto.getIdAsistentes()[i]));
					pstmt.executeUpdate();
				} catch (SQLException e) {
					e.printStackTrace();
					return false;
				} finally {
					ConexionDS.endConnection(null, pstmt, null);
				}

			}
		} else {
			return false;
		}
		return true;
	}

	public static boolean quitaAsistentes(int idUsuario, Connection conn) {
		String sql = "DELETE FROM SD_ASISTENTES WHERE ASI_USUARIO=?";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idUsuario);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			ConexionDS.endConnection(null, pstmt, null);
		}
		return true;
	}

	private static int getMaxUsuarioID(Connection conn) {
		String sql = "SELECT MAX(ID_USUARIO) AS MAX_ID FROM SD_USUARIO";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				return rs.getInt("MAX_ID");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConexionDS.endConnection(rs, pstmt, null);
		}
		return -1;
	}
}
