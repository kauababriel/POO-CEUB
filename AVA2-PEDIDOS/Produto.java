public class Produto {
    public int codigoItem;
    public String descricaoProduto;
    public int quantidadeProduto;
    public int precoUnitario;

    private static double calculoValorTotal(int preco, int quantidade) {
        double valor = 0.0;
        preco = 2
        quantidade = 3
        valor = preco * quantidade;
        return valor;
    }
    public void valorTotal() {
        System.out.println(calculoValorTotal(precoUnitario, quantidadeProduto));
    }
}
