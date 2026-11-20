package com.joao.biblioteca.Controller;

import com.joao.biblioteca.Model.Autor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/autores")
public class AutorController {
    private List<Autor> autores = new ArrayList<Autor>();

    @GetMapping("/inicio")
    public String inicio() {
        return "autores/inicio";
    }

    @GetMapping
    public String inicio(Model model) {
        Autor autor = new Autor();
        autor.setNome("Fiódor Dostoiévski");
        autor.setNacionalidade("Russo");

        model.addAttribute("autor", autor);

        return "autores/inicio";
    }

    @PostMapping
    public String cadastrar(Autor autor) {
        autores.add(autor);
        return "redirect:/autores";
    }

    @DeleteMapping("/excluir/{indice}")
    public String excluir(@PathVariable("indice") int indice) {
        if (indice >= 0 && indice < autores.size()) {
            autores.remove(indice);
        }
        return "redirect:/autores";
    }
}