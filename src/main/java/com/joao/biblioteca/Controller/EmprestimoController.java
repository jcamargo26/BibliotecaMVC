package com.joao.biblioteca.Controller;

import com.joao.biblioteca.Model.Emprestimo;
import com.joao.biblioteca.Model.Livro;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/emprestimos")
public class EmprestimoController {
    private List<Emprestimo> emprestimos = new ArrayList<Emprestimo>();

    @GetMapping("/inicio")
    public String inicio() {
        return "emprestimos/inicio";
    }

    @GetMapping
    public String inicio(Model model) {
        Emprestimo emprestimo = new Emprestimo();
        emprestimo.setId(1L);
        emprestimo.setNomeLeitor("Greg");

        Livro livro = new Livro();
        livro.setTitulo("Noites Brancas");
        livro.setAutor("Fiódor Dostoiévski");
        livro.setIsbn("100222200");
        emprestimo.setLivro(livro);

        model.addAttribute("emprestimo", emprestimo);

        return "emprestimos/inicio";
    }

    @PostMapping
    public String cadastrar(Emprestimo emprestimo) {
        emprestimos.add(emprestimo);
        return "redirect:/emprestimos";
    }

    @DeleteMapping("/excluir/{indice}")
    public String excluir(@PathVariable("indice") int indice) {
        if (indice >= 0 && indice < emprestimos.size()) {
            emprestimos.remove(indice);
        }
        return "redirect:/emprestimos";
    }
}