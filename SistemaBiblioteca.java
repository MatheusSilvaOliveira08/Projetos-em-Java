import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;


class Livro { 

    private String titulo; 
    private String autor; 
    private boolean emprestado;

    public Livro (String titulo, String autor) { 
        this.titulo = titulo; 
        this.autor = autor; 
        this.emprestado = false;
    }

    public String getTitulo() { 
        return titulo;
    }

    public String getAutor () { 
        return autor;
    }

    public boolean isEmprestado () { 
        return emprestado;
    }

    public void emprestarLivro () { 
        if (emprestado == false) { 
            emprestado = true; 
            System.out.println("Livro emprestado com sucesso!");
        }
        else { 
            System.out.println("Esse livro já foi emprestado...");
        }
    }

    public void devolverLivro () { 
        if (emprestado == true) { 
            emprestado = false;
            System.out.println("Livro devolvido com sucesso!");
        }
        else { 
            System.out.println("Esse livro não foi emprestado...");
        }
    }

    @Override
    public String toString () { 
        return titulo + " - " + autor + " - " + (emprestado ? "(Emprestado)" : "(Devolvido)");
    }
}

class Biblioteca { 
    private List <Livro> livros = new ArrayList<>();

    public void adicionarLivro(Livro livro) { 
        livros.add(livro);
        System.out.println("Livro adicionado com sucesso! " + livro.getTitulo());
    }

    public void listarLivros() { 

        System.out.println("\n Lista de livros: ");
        for (Livro livro: livros) { 
            System.out.println(livro);
        }  
    }

    public Livro buscarLivro (String titulo) { 
        for (Livro livro: livros) { 
            if (livro.getTitulo().equalsIgnoreCase(titulo)) { 
                return livro;
            }
        }
        return null;
    }
}

public class SistemaBiblioteca { 
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca();

        biblioteca.adicionarLivro(new Livro("Dom Casmurro", "Machado de Assis"));
        biblioteca.adicionarLivro(new Livro("Pequeno Príncipe", "Antoine de Saint-Exúpery"));
        biblioteca.adicionarLivro(new Livro("1984", "George Orwell"));

        while (true) { 
            System.out.println("\n1 - Listar livros\n2 - Adicionar livros\n3 - Emprestar livro\n4 - Devolver livro\n5 - Sair  ");
            int escolha = scanner.nextInt();
            scanner.nextLine();

            switch (escolha) { 

                case 1: 
                biblioteca.listarLivros();
                break;

                case 2: 
                System.out.println("Digite o nome do livro: ");
                String novoTitulo = scanner.nextLine();
                System.out.println("Digite o nome do autor: ");
                String novoAutor = scanner.nextLine();

                biblioteca.adicionarLivro(new Livro (novoTitulo,novoAutor));
                break; 

                case 3: 

                System.out.println("Digite o nome do livro que deseja pegar emprestado: ");
                String titulo_livro_emprestado = scanner.nextLine();
                Livro livroEmprestado = biblioteca.buscarLivro(titulo_livro_emprestado); 

                if (livroEmprestado != null) { 
                    livroEmprestado.emprestarLivro();
                }
                else { 
                    System.out.println("Livro não encontrado...");
                }

                break;

                case 4: 

                System.out.println("Digite o nome do livro que deseja devolver");
                String titulo_livro_devolvido = scanner.nextLine();
                Livro livroDevolvido = biblioteca.buscarLivro(titulo_livro_devolvido);

                if (livroDevolvido != null) { 
                    livroDevolvido.devolverLivro();
                }
                else { 
                    System.out.println("Livro não encontrado...");
                }

                break; 

                case 5: 
                System.out.println("Saindo do sistema...");
                scanner.close();
                return;

                default: 
                System.out.println("Opção inválida...");

            }

            }
        }
    }

