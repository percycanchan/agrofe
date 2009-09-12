package afip.facturaElectronica.handshake.tratamientoErrores;

/**
 * abrstracción para validar los errores devueltos por el WS de la afip
 * @author lagromayor
 *
 */
public abstract class TratamientoErrores {

	/**
	 * valida si el código de error corresponde a un OK
	 * @param codError
	 * @return
	 */
	public static boolean esRespuestaOK(int codError) {
		if (codError != 0){
			return false;
		}
		return true;
	}

}
