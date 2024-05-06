public class Main {

    public static void main(String[] args) {

        Banco banco1 = new Banco("Banco do Brasil", 25.3);


        Cliente venilton = new Cliente();
        venilton.setNome("Venilton");

        Cliente jonathan = new Cliente();
        jonathan.setNome("Jonathan");

        Conta cc = new ContaCorrente(venilton, banco1);


        Conta jc = new ContaCorrente(jonathan, banco1);
        banco1.addConta(jc);
        banco1.addConta(cc);

        Conta poupanca = new ContaPoupanca(venilton, banco1);

        banco1.addConta(poupanca);

        cc.depositar(100);
        cc.transferir(100, poupanca);

        cc.imprimirExtrato();
        poupanca.imprimirExtrato();

        banco1.printContas();
        banco1.deleteConta(cc);
        banco1.deleteConta("Jonathan");

        banco1.printContas();
    }
}