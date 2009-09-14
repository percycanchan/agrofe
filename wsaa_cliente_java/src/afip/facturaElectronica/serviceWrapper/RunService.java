package afip.facturaElectronica.serviceWrapper;

import org.tanukisoftware.wrapper.WrapperListener;
import org.tanukisoftware.wrapper.WrapperManager;

public class RunService implements WrapperListener{

	//para iniciar mi aplicacion en un hilo de ejecucion distinto
	private ServicioWSThead m_app;

    /*---------------------------------------------------------------
     * Constructors
     *-------------------------------------------------------------*/
    private RunService()
    {
    }
	
    public Integer start( String[] args )
    {
        m_app = new ServicioWSThead();
        m_app.start();

        if ( m_app.isAlive() )
        {
            return null;
        }
        else
        {
            System.out.println( "Error al intentar inicializar el Servicio WS" );
            return new Integer( 1 );
        }        
    }
	


    public int stop( int exitCode )
    {
    	WrapperManager.signalStopping( 60000 );
        //m_app.finalizar();
        m_app.interrupt();
        
        return exitCode;
    }
    
    public void controlEvent( int event )
    {
        if ( ( event == WrapperManager.WRAPPER_CTRL_LOGOFF_EVENT )
            && ( WrapperManager.isLaunchedAsService() || WrapperManager.isIgnoreUserLogoffs() ) )
        {
            // Ignore
        }
        else
        {
            WrapperManager.stop( 0 );
            // Will not get here.
        }
    }
    
    public static void main( String[] args )
    {
        // Start the application.  If the JVM was launched from the native
        //  Wrapper then the application will wait for the native Wrapper to
        //  call the application's start method.  Otherwise the start method
        //  will be called immediately.
        WrapperManager.start( new RunService(), args );
    }
    
}
