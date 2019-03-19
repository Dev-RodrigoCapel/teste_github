package ifmt.tsi;

public class Menu {
    
    DAOPessoa daoPessoa = new DAOPessoa();
    
    public void menu() {

        int op = Teclado.leInt("(1) Cad (2) Alt (3) Exc (4) Con (5)Sair");
        switch (op) {
            case 1:
                cadastrar();
                break;
            case 2:
                alterar();
                break;
            case 3:
                excluir();
                break;
            case 4:
                consultar();
                break;
            case 5:
                System.out.println("..:: Bye Bye ::..");
                System.exit(0);
                break;
        }
    }
    
    public void cadastrar(){
    
        String nome = Teclado.leString("Digite o nome:");
        int cpf = Teclado.leInt("Digite o cpf");
        Pessoa p = new Pessoa(cpf, nome);
        daoPessoa.inserir(p);
        System.out.println("Cadastrado");
        menu();
    
    }
    
    public void alterar(){
    
        String nome = Teclado.leString("Digite o nome:");
        int cpf = Teclado.leInt("Digite o cpf");
        Pessoa p = new Pessoa(cpf, nome);
        daoPessoa.alterar(p);
        System.out.println("Alterado");
        menu();
    
    }
    
    public void excluir(){
    
        int cpf = Teclado.leInt("Digite o cpf");
        daoPessoa.excluir(cpf);
        System.out.println("Cadastrado");
        menu();
    
    }
    
    public void consultar(){
        daoPessoa.consultar();
        menu();
    
    }
    
    public static void main(String[] args) {
        Menu principal = new Menu();
        principal.menu();
    }
    
}
