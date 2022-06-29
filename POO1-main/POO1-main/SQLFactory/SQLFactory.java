public class SQLFactory{
    public static void main(String[] args){

        Aluno aluno = new Aluno();
        
        aluno.id = 4;
        aluno.nome = "ANA";
        aluno.idade = 18;
        aluno.cidade = "SINOP";
        aluno.uf= "MT";

        //Database.inserir(aluno);
        if (Database.abrirID(aluno, 3)) {
           System.out.println("Nome: " + aluno.nome + ", Idade: " + aluno.idade + ", Cidade: " + aluno.cidade + ", UF" + aluno.uf );
        }
        //Aluno aluno1 = new Aluno();

        //if (Database.abrirID(aluno1, 1)) {
        //     System.out.println("Nome: " + aluno1.nome + ", Idade: " + aluno1.idade + ", Cidade: " + aluno1.cidade + ", UF" + aluno1.uf );      
        //}


        
    }
}