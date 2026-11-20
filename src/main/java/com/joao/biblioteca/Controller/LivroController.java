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

    @GetMapping("/inicio")
    public String inicio() {
        return "redirect:/livros";
    }

    @GetMapping
    public String inicio(Model model) {
        model.addAttribute("livro", new Livro());
        model.addAttribute("livros", livros);
        return "livros/inicio";
    }

    @PostMapping
    public String cadastrar(Livro livro) {
        livros.add(livro);
        return "redirect:/livros";
    }

    @GetMapping("/editar/{indice}")
    public String editar(@PathVariable("indice") int indice, Model model) {
        if (indice >= 0 && indice < livros.size()) {
            model.addAttribute("livro", livros.get(indice));
            model.addAttribute("indiceEdicao", indice);
        }
        model.addAttribute("livros", livros);
        return "livros/inicio";
    }

    @PutMapping("/editar/{indice}")
    public String atualizar(@PathVariable("indice") int indice, Livro livro) {
        if (indice >= 0 && indice < livros.size()) {
            livros.set(indice, livro);
        }
        return "redirect:/livros";
    }

    @DeleteMapping("/excluir/{indice}")
    public String excluir(@PathVariable("indice") int indice) {
        if (indice >= 0 && indice < livros.size()) {
            livros.remove(indice);
        }
        return "redirect:/livros";
    }
}