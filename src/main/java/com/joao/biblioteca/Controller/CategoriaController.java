package com.joao.biblioteca.Controller;

import com.joao.biblioteca.Model.Categoria;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/categorias")
public class CategoriaController {
    private List<Categoria> categorias = new ArrayList<Categoria>();

    @GetMapping("/inicio")
    public String inicio() {
        return "categorias/inicio";
    }

    @GetMapping
    public String inicio(Model model) {
        Categoria categoria = new Categoria();
        categoria.setArea("Literatura");
        categoria.setGenero("Romance");
        categoria.setDescricao("Obra clássica da literatura.");

        model.addAttribute("categoria", categoria);

        return "categorias/inicio";
    }

    @PostMapping
    public String cadastrar(Categoria categoria) {
        categorias.add(categoria);
        return "redirect:/categorias";
    }

    @DeleteMapping("/excluir/{indice}")
    public String excluir(@PathVariable("indice") int indice) {
        if (indice >= 0 && indice < categorias.size()) {
            categorias.remove(indice);
        }
        return "redirect:/categorias";
    }
}