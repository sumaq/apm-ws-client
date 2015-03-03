package com.aje.apm.webservices;

import java.rmi.RemoteException;

import org.apache.axis2.AxisFault;

import com.aje.apm.webservices.WSCargarDatosStub.Execute;
import com.aje.apm.webservices.WSCargarDatosStub.ExecuteResponse;

public class WSCargarDatosClient {

	public static void main(String[] args) {
		try {
			String compania = args[0];
			String spName = args[1];
			String wsName = args[2];
			String wsNameParamList = args[3];
			String xmlRoot = args[4];
			String xmlElement = args[5];

			WSCargarDatosStub stub = new WSCargarDatosStub();
			Execute execute = new Execute();

			execute.setCompania(compania);
			execute.setSpName(spName);
			execute.setWsName(wsName);
			execute.setWsNameParamList(wsNameParamList);
			execute.setXmlElement(xmlRoot);
			execute.setXmlRoot(xmlElement);

			ExecuteResponse response = new ExecuteResponse();
			response = stub.execute(execute);
			System.out.println(response.get_return());

		} catch (AxisFault e) {
			System.out.println("Axis2 Error: " + e.getMessage());
			e.printStackTrace();
		} catch (RemoteException e) {
			System.out.println("Remote Error: " + e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("General Error: " + e.getMessage());
			e.printStackTrace();
		}

	}

}
