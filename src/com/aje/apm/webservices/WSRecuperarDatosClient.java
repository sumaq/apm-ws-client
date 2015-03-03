package com.aje.apm.webservices;

import java.rmi.RemoteException;

import org.apache.axis2.AxisFault;

import com.aje.apm.webservices.WSRecuperarDatosStub.Execute;
import com.aje.apm.webservices.WSRecuperarDatosStub.ExecuteResponse;

public class WSRecuperarDatosClient {

	public static void main(String[] args) {
		try {
			String compania = args[0];
			String tableName = args[1];
			String wsName = args[2];
			String wsParams = args[3];
			String xmlRoot = args[4];
			String xmlChild = args[5];

			// Replace params char separator
			wsParams = wsParams.replace("#", "&");

			WSRecuperarDatosStub stub = new WSRecuperarDatosStub();
			Execute execute = new Execute();

			execute.setCompania(compania);
			execute.setTableName(tableName);
			execute.setWsName(wsName);
			execute.setWsParams(wsParams);
			execute.setXmlRoot(xmlRoot);
			execute.setXmlChild(xmlChild);

			ExecuteResponse response = new ExecuteResponse();
			response = stub.execute(execute);
			System.out.println(response.get_return());

		} catch (AxisFault e) {
			System.out.println("Axis2 Error: " + e);
			e.printStackTrace();
		} catch (RemoteException e) {
			System.out.println("Remote Error: " + e);
			e.printStackTrace();
		}

	}

}
