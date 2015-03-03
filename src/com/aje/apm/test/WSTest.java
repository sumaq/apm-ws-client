package com.aje.apm.test;

import com.aje.apm.webservices.WSCargarDatosClient;
import com.aje.apm.webservices.WSRecuperarDatosClient;

public class WSTest {

	public static void main(String[] args) {

		// public static WSConnectString wsCon = new WSConnectString();
		// wsCon.getServiceRecuperar()

		WSRecuperarDatosClient wsRecuperar = new WSRecuperarDatosClient();
		String[] paramsRecuperar = { "0004", "tmpAPMTurno2",
				"verTurnosCerrados", "companiaID=0004#fecha=2014-10-23",
				"turnos", "x" };
		wsRecuperar.main(paramsRecuperar);

		WSCargarDatosClient wsCargar = new WSCargarDatosClient();
		String[] paramsCarga = { "0004",
				"USP_APM_SQL_LISTA_PRECIO_SUC '0004','0002'",
				"cargarListaPrecioSucursal", "ListaPrecioSucursal",
				"LP_SUCURSAL", "LP_SUCURSAL" };
		// wsCargar.main(paramsCarga);

	}

}
