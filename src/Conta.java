
public abstract class Conta implements IConta {
	
	private static final int AGENCIA_PADRAO = 1;

	protected int agencia;
	protected int numero;
	protected double saldo;
	protected Cliente cliente;
	protected Banco banco;
	protected final String tipo;


	public Conta(Cliente cliente, Banco banco, String tipo) {
		this.agencia = Conta.AGENCIA_PADRAO;
		if(banco.getContas().isEmpty())
		{
			this.numero = 1;
		}
		else
		{
			this.numero = banco.getContas().size()+1;
		}
		this.cliente = cliente;
		this.banco = banco;
		this.tipo = tipo;
	}

	@Override
	public void sacar(double valor) {
		saldo -= valor;
	}

	@Override
	public void depositar(double valor) {
		saldo += valor;
	}

	@Override
	public void transferir(double valor, IConta contaDestino) {
		this.sacar(valor);
		contaDestino.depositar(valor);
	}

	public Cliente getCliente() {
		return cliente;
	}

	public int getAgencia() {
		return agencia;
	}

	public int getNumero() {
		return numero;
	}

	public double getSaldo() {
		return saldo;
	}

	public String getTipo() {
		return tipo;
	}

	protected void imprimirInfosComuns() {
		System.out.println(String.format("Titular: %s", this.cliente.getNome()));
		System.out.println(String.format("Agencia: %d", this.agencia));
		System.out.println(String.format("Numero: %d", this.numero));
		System.out.println(String.format("Saldo: %.2f", this.saldo));
	}
}
