

import exception.OperacaoBloqueadaContaDestinoSituacaoIrregular;
import model.Cliente;
import model.Conta;
import model.ContaCorrente;
import model.StatusConta;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.omg.CORBA.portable.ApplicationException;

/**
 *
 *
 *
 * @link https://howtodoinjava.com/junit5/expected-exception-example/
 *
 *
 *
 * @author Emmanuel Abruzzo
 * @date 18/01/2022
 */
class MainTest {


    static Cliente joaoCamargo;
    static Conta contaCorrenteJoaoCamargo;
    static Conta contaPoupancaJoaoCamargo;
    static Cliente mariaDoSocorro;
    static Conta contaPoupancaMariaSocorro;



    @BeforeAll
    static void setUp(){

        joaoCamargo= new Cliente();
        joaoCamargo.setNome("João Camargo");
        contaCorrenteJoaoCamargo = new ContaCorrente(10000d,joaoCamargo, StatusConta.ATIVA);
        joaoCamargo.getContasCliente().add(contaCorrenteJoaoCamargo);
        contaPoupancaJoaoCamargo = new ContaCorrente(5000d,joaoCamargo, StatusConta.ATIVA);
        joaoCamargo.getContasCliente().add(contaPoupancaJoaoCamargo);
        mariaDoSocorro = new Cliente();
        mariaDoSocorro.setNome("Maria do Socorro");
        contaPoupancaMariaSocorro = new ContaCorrente(30000d,mariaDoSocorro, StatusConta.BLOQUEADA);
        mariaDoSocorro.getContasCliente().add(contaPoupancaMariaSocorro);
    }


    @Test
    void testExcepionThrownWhenClientTryToTransferMoneyToBlockedAccount() {

        OperacaoBloqueadaContaDestinoSituacaoIrregular thrown = Assertions.assertThrows(OperacaoBloqueadaContaDestinoSituacaoIrregular.class, () -> {
            //Code under test
            contaCorrenteJoaoCamargo.transferir(5000d,contaPoupancaMariaSocorro);

        });

        Assertions.assertEquals("Conta de destino em situação irregular", thrown.getMessage());
    }




}
