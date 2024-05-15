import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class GeraListaObjeto {
    public static class Objeto {
        public String descricao;
        public double largura;
        public double comprimento;
        public double altura;
        public int ocorrencia;
        public String garra;

        public void setDescricao(String Descricao) {
            descricao = Descricao;
        }

        public void setLargura(double Largura) {
            largura = Largura;
        }

        public void setComprimento(double Comprimento) {
            comprimento = Comprimento;
        }

        public void setAltura(double Altura) {
            altura = Altura;
        }

        public void setOcorrencia(int Ocorrencia) {
            ocorrencia = Ocorrencia;
        }
        public void setGarra(String Garra){
            garra = Garra;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rd = new Random();

        System.out.println();
        System.out.println("******** Objetos conhecidos ********");
        System.out.println();
        System.out.print("Quantos objetos conhecidos deseja cadastrar? ");
        int OBJCONHECIDOS = sc.nextInt();
        sc.nextLine();

        ArrayList<Objeto> objetos = new ArrayList<Objeto>();
        String[] garra = new String[4];
        garra[0] = "Garra Hidráulica";
        garra[1] = "Garra Pneumática";
        garra[2] = "Garra Elétrica";
        garra[3] = "Garra de Ventosa";

        for (int i = 0; i < OBJCONHECIDOS; i++) {
            Objeto obj = new Objeto();

            System.out.print("Descrição: ");
            obj.setDescricao(sc.nextLine().toUpperCase());
            objetos.add(obj);
        }

        System.out.println();
        System.out.println("******** Objetos desconhecidos ********");
        System.out.println();

        boolean loop = true;
        while (loop) {
            System.out.println("Novo objeto - 1");
            System.out.println("Sem objetos novos, continuar procura - 2");
            System.out.println("Objetos cadastrados - 3");
            System.out.println("Sem objetos novos, sair - 0");
            System.out.print("Opção: ");
            int escolha = sc.nextInt();
            sc.nextLine();

            switch (escolha) {
                case 0:
                    loop = false;
                    System.out.println("Encerrando programa...");
                    break;
                case 1:
                    Objeto novoObjeto = new Objeto();

                    System.out.println();
                    System.out.print("Descrição (caso exista, adiciona +1 ocorrência): ");
                    String novaDescricao = sc.nextLine().toUpperCase();
                    System.out.println();

                    boolean descricaoExistente = false;

                    for (Objeto obj : objetos) {
                        if (obj.descricao.equals(novaDescricao)) {
                            descricaoExistente = true;
                            if (obj.ocorrencia == 0) {
                                System.out.println("Objeto já existente com ocorrência zero!");
                                if (obj.largura == 0) {
                                    System.out.println("Adicione seus valores.");
                                    System.out.print("Largura: ");
                                    obj.setLargura(sc.nextDouble());
                                    sc.nextLine();
                                    System.out.print("Comprimento: ");
                                    obj.setComprimento(sc.nextDouble());
                                    sc.nextLine();
                                    System.out.print("Altura: ");
                                    obj.setAltura(sc.nextDouble());
                                    sc.nextLine();
                                    obj.setOcorrencia(obj.ocorrencia + 1);
                                    obj.setGarra(garra[rd.nextInt(4)]);
                                } else {
                                    System.out.println("Objeto já tem seus valores!");
                                    obj.setOcorrencia(obj.ocorrencia + 1);
                                }
                            }
                            else {
                                System.out.println("Objeto já existente! Adicionando ocorrência");
                                obj.setOcorrencia(obj.ocorrencia + 1);
                                System.out.println();
                            }
                            System.out.println();
                            break;
                        }
                    }

                    if (!descricaoExistente) {
                        novoObjeto.setDescricao(novaDescricao);
                        System.out.print("Largura: ");
                        novoObjeto.setLargura(sc.nextDouble());
                        sc.nextLine();
                        System.out.print("Comprimento: ");
                        novoObjeto.setComprimento(sc.nextDouble());
                        sc.nextLine();
                        System.out.print("Altura: ");
                        novoObjeto.setAltura(sc.nextDouble());
                        sc.nextLine();
                        novoObjeto.setOcorrencia(1);
                        novoObjeto.setGarra(garra[rd.nextInt(4)]);
                        objetos.add(novoObjeto);
                        System.out.println();
                    }
                    System.out.println();
                    break;

                case 2:
                    System.out.println();
                    System.out.println("Continuando...");
                    System.out.println();
                    break;

                case 3:
                    System.out.println();
                    System.out.println("Objetos cadastrados:");
                    for (Objeto obj : objetos) {
                        System.out.println("Descrição: " + obj.descricao);
                        System.out.println("Largura: " + obj.largura);
                        System.out.println("Comprimento: " + obj.comprimento);
                        System.out.println("Altura: " + obj.altura);
                        System.out.println("Ocorrência: " + obj.ocorrencia);
                        System.out.println("Garra para uso: " + obj.garra);
                        System.out.println();
                    }
                    break;

                default:
                    System.out.println();
                    System.out.println("Digite uma opção válida!");
                    System.out.println();
                    break;
            }
        }
        sc.close();
    }
}
