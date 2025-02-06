public class Parcela {
    private double valorParcelas;
    private double juros;

    public Parcela(double valorParcelas, double juros) {
        this.valorParcelas = valorParcelas;
        this.juros = juros;
    }

    public double getValorParcelas() {
        return valorParcelas;
    }

    public void setValorParcelas(double valorParcelas) {
        this.valorParcelas = valorParcelas;
    }


    @Override
    public String toString() {
        return Double.toString(valorParcelas);
    }

    public double getJuros() {
        return juros;
    }

    public void setJuros(double juros) {
        this.juros = juros;
    }
}
