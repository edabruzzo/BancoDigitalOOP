package model;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Emmanuel Abruzzo
 * @date 18/01/2022
 */
public class ContaCorrente extends Conta{

    boolean podeTransferirValorSuperiorA10Mil = true;


    public ContaCorrente(double saldo, Cliente cliente, StatusConta statusConta) {
        super(saldo,cliente,statusConta);
    }
}
