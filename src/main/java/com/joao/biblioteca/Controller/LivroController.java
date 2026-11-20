package com.joao.biblioteca.Controller;
import com.joao.biblioteca.Model.Livro;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/livros")
public class LivroController {
    private List<Livro> livros = new ArrayList<Livro>();

    @GetMapping("/inicio") public String inicio(){
        return "livros/inicio";
    }
    @GetMapping
    public String inicio(Model model) {
        Livro livro = new Livro();
        livro.setTitulo("Noites Brancas");
        livro.setAutor("Fiódor Dostoiévski");
        livro.setIsbn("100222200");

        model.addAttribute("livro", livro);

        return "livros/inicio";
    }

    @PostMapping
    public String cadastrar(Livro livro) {
        livros.add(livro);
        return "redirect:/livros";
    }

    @DeleteMapping("/excluir/{indice}")
    public String excluir (@PathVariable("indice") int indice) {
        if (indice>= 0 && indice < livros.size()) {
            livros.remove(indice);
        }
        return "redirect:/livros";
    }
}