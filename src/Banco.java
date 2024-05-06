import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Banco {

	private String nome;
	private List<Conta> contas = new ArrayList<>();
	private double taxaDeJuros;

	public Banco(String nome, double taxaDeJuros)
	{
		this.nome = nome;
		this.taxaDeJuros = taxaDeJuros;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void addConta(Conta conta)
	{
		contas.add(conta);
	}
	public void deleteConta(IConta conta)
	{
		if(contas.isEmpty())
		{
			throw new RuntimeException("Este banco nao possui nenhum cliente.");
		}
		contas.removeIf(item -> item == conta);
	}
	public void deleteConta(String nomeConta)
	{
		if(contas.isEmpty())
		{
			throw new RuntimeException("Este banco nao possui nenhum cliente.");
		}
		List<Conta> deletionList = contas.stream()
				.filter(conta -> conta.getCliente().getNome().equals(nomeConta))
				.collect(Collectors.toList());
		if(deletionList.isEmpty())
		{
			throw new RuntimeException("Nao ha contas com esse nome nesse banco");
		}
		contas.removeAll(deletionList);
	}

	public List<Conta> getContas() {
		return contas;
	}

	public double getTaxaDeJuros() {
		return taxaDeJuros;
	}
	public void setTaxaDeJuros(double taxaDeJuros)
	{
		this.taxaDeJuros = taxaDeJuros;
	}

	public void printContas()
	{
		if(contas.isEmpty())
		{
			throw new RuntimeException("Este banco nao possui nenhum cliente.");
		}
		for(Conta conta : contas)
		{
			Cliente clienteConta = conta.getCliente();
			System.out.println("A conta de "+ clienteConta.getNome() + " do tipo "+conta.getTipo());
		}
	}
}
