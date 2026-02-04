package com.meve.sigma.organizacional;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.meve.sigma.catalogos.CatalogoRol;
import com.meve.sigma.catalogos.CatalogoUtil;
import com.meve.sigma.organizacional.dao.EstructuraOrganizacionalDao;
import com.meve.sigma.organizacional.vo.AreaVO;
import com.meve.sigma.organizacional.vo.AsistenteVO;
import com.meve.sigma.organizacional.vo.PuestoVO;

public class EstructuraOrganizacional {

	List areas = new ArrayList();

	public EstructuraOrganizacional(Connection conn) {
		setAreas(conn);
	}

	public void setAreas(Connection conn) {
		List areasTemp = EstructuraOrganizacionalDao.getAreas(conn);
		for (int i = 0; i < areasTemp.size(); i++) {
			AreaVO area = (AreaVO) areasTemp.get(i);
			List puestosTemp = EstructuraOrganizacionalDao.getPuestos(conn,
					area.getIdArea());
			List puestosArea = new ArrayList();
			for (int j = 0; j < puestosTemp.size(); j++) {
				if (!existePuesto(((PuestoVO) puestosTemp.get(j)).getIdJefe(),
						puestosTemp)) {
					((PuestoVO) puestosTemp.get(j))
							.setSubordinados(puestosTemp);
					puestosArea.add(puestosTemp.get(j));
				}
			}
			area.setPuestos(puestosArea);
			area.setAreasSubordinadas(areasTemp);
			if (area.getIdAreaPadre() == -1) {
				areas.add(area);
			}
			setAsistentes(area, conn);
			setRoles(area, conn);
		}
	}

	public void setAsistentes(AreaVO area, Connection conn) {
		List relacionAsistentes = EstructuraOrganizacionalDao
				.getReleacionAsistentes(conn, area.getIdArea());
		List asistentes = new ArrayList();
		int idAsisTemp = -1;
		for (int i = 0; i < relacionAsistentes.size(); i++) {
			int idAsistente = ((int[]) relacionAsistentes.get(i))[0];
			if (idAsisTemp == idAsistente) {
				continue;
			}
			List asistidos = new ArrayList();
			AsistenteVO asistente = new AsistenteVO(
					area.getPuesto(idAsistente), asistidos);
			for (int j = i; j < relacionAsistentes.size(); j++) {
				if (idAsistente != ((int[]) relacionAsistentes.get(j))[0]) {
					break;
				}
				int idAsistido = ((int[]) relacionAsistentes.get(j))[1];
				PuestoVO asistido = area.getPuesto(idAsistido);
				if (asistido != null) {
					asistido.addAsistente(asistente);
					asistidos.add(asistido);
				}
			}
			asistente.setAsistidos(asistidos);
			asistentes.add(asistente);
			idAsisTemp = idAsistente;
		}
		area.setAsistentes(asistentes);
	}

	public void setRoles(AreaVO area, Connection conn) {
		List relacionRoles = EstructuraOrganizacionalDao.getReleacionRoles(
				conn, area.getIdArea());
		int idUsuarioTemp = -1;
		for (int i = 0; i < relacionRoles.size(); i++) {
			int idPuesto = ((int[]) relacionRoles.get(i))[0];
			if (idUsuarioTemp == idPuesto) {
				continue;
			}
			idUsuarioTemp = idPuesto;
			PuestoVO puesto = area.getPuesto(idPuesto);
			List roles = new ArrayList();
			for (int j = i; j < relacionRoles.size(); j++) {
				if (idPuesto != ((int[]) relacionRoles.get(j))[0]) {
					break;
				}
				int idRol = ((int[]) relacionRoles.get(j))[1];
				roles.add(new Integer(idRol));
			}
			puesto.setRoles(roles);
		}
	}

	public AreaVO getArea(int idArea) {
		for (int i = 0; i < areas.size(); i++) {
			AreaVO area = (AreaVO) areas.get(i);
			if (idArea == area.getIdArea()) {
				return new AreaVO(area);
			} else {
				AreaVO areaResultado = area.getAreaSubordinada(idArea);
				if (areaResultado != null) {
					return new AreaVO(areaResultado);
				}
			}
		}
		return null;
	}

	public List getAreas(boolean todas) {
		if (!todas) {
			return new ArrayList(areas);
		} else {
			List areasTodas = new ArrayList();
			for (int i = 0; i < areas.size(); i++) {
				AreaVO area = (AreaVO) areas.get(i);
				areasTodas.add(area);
				areasTodas.addAll(area.getAreasSubordinadas(todas));

			}
			return areasTodas;
		}
	}

	public PuestoVO getPuesto(int idUsuario) {
		for (int i = 0; i < areas.size(); i++) {
			AreaVO area = (AreaVO) areas.get(i);
			PuestoVO puesto = area.getPuesto(idUsuario);
			if (puesto != null) {
				return puesto;
			}
		}
		return null;
	}

	private boolean existePuesto(int idUsuario, List puestos) {
		for (int i = 0; i < puestos.size(); i++) {
			if (idUsuario == ((PuestoVO) puestos.get(i)).getIdUsuario()) {
				return true;
			}
		}
		return false;
	}

	public String toString() {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < areas.size(); i++) {
			sb.append(" " + ((AreaVO) areas.get(i)).toString());
		}
		return sb.toString();
	}

}
