import model.Cliente;
import model.Conta;
import model.ContaCorrente;
import model.StatusConta;

/**
 * @author Emmanuel Abruzzo
 * @date 18/01/2022
 */
public class Main {


    public static void main(String[] args) {


        Cliente joaoCamargo = new Cliente();
        joaoCamargo.setNome("João Camargo");

        Conta contaCorrenteJoaoCamargo = new ContaCorrente(10000d,joaoCamargo, StatusConta.ATIVA);
        joaoCamargo.getContasCliente().add(contaCorrenteJoaoCamargo);

        Conta contaPoupancaJoaoCamargo = new ContaCorrente(5000d,joaoCamargo, StatusConta.ATIVA);
        joaoCamargo.getContasCliente().add(contaPoupancaJoaoCamargo);



        Cliente mariaDoSocorro = new Cliente();
        mariaDoSocorro.setNome("Maria do Socorro");

        Conta contaPoupancaMariaSocorro = new ContaCorrente(30000d,mariaDoSocorro, StatusConta.BLOQUEADA);
        mariaDoSocorro.getContasCliente().add(contaPoupancaMariaSocorro);


        contaCorrenteJoaoCamargo.transferir(5000,contaPoupancaMariaSocorro);




    }

}
