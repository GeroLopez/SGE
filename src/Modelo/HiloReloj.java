package Modelo;

import java.util.Calendar;
import javax.swing.JLabel;

/**
 * La clase HiloReloj es la encargada de controlar el reloj que se despliega
 * en los formularios para mostrar la hora en que se comienza la entrada y la
 * hora en la que se termina.
 * @author:  Genaro López
 * @version: 5/08/2014
 */
public class HiloReloj extends Thread {

    /**
     * Mediante esta variable se captura la hora actual del sistema.
     */
    private Calendar calendario;
    /**
     * Es la etiqueta donde se muestra la hora.
     */
    private final JLabel jLabelReloj;
    /**
     * Se utiliza para validar la continuidad del while dentro del método run.
     */
    private boolean continuar;
    /**
     * La hora actual.
     */
    private int hora;
    /**
     * El minuto actual.
     */
    private int minuto;
    /**
     * El segundo actual.
     */
    private int segundo;

    /**
     * Constructor
     * @param jLabelReloj Es la etiqueta donde se muestra la hora.
     */
    public HiloReloj(JLabel jLabelReloj) {
        continuar = true;
        this.jLabelReloj = jLabelReloj;
    }

    @Override
    public void run() {
        while (isContinuar()) {
            String reloj = "";
            calendario = Calendar.getInstance();
            hora = calendario.get(Calendar.HOUR_OF_DAY);
            minuto = calendario.get(Calendar.MINUTE);
            segundo = calendario.get(Calendar.SECOND);
            if (hora < 10) {
                reloj = reloj.concat("0");
            }
            reloj = reloj.concat(hora + ":");
            if (minuto < 10) {
                reloj = reloj.concat("0");
            }
            reloj = reloj.concat(minuto + ":");
            if (segundo < 10) {
                reloj = reloj.concat("0");
            }
            reloj = reloj.concat("" + segundo);
            jLabelReloj.setText(reloj);
        }
    }

    /**
     * @return the continuar
     */
    public boolean isContinuar() {
        return continuar;
    }

    /**
     * @param continuar the continuar to set
     */
    public void setContinuar(boolean continuar) {
        this.continuar = continuar;
    }

}
