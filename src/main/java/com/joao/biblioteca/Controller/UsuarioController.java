package com.joao.biblioteca.Controller;

import com.joao.biblioteca.Model.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {
    private List<Usuario> usuarios = new ArrayList<Usuario>();

    @GetMapping("/inicio")
    public String inicio() {
        return "redirect:/usuarios";
    }

    @GetMapping
    public String inicio(Model model) {
        model.addAttribute("usuario", new Usuario());
        model.addAttribute("usuarios", usuarios);
        return "usuarios/inicio";
    }

    @PostMapping
    public String cadastrar(Usuario usuario) {
        usuarios.add(usuario);
        return "redirect:/usuarios";
    }

    @GetMapping("/editar/{indice}")
    public String editar(@PathVariable("indice") int indice, Model model) {
        if (indice >= 0 && indice < usuarios.size()) {
            model.addAttribute("usuario", usuarios.get(indice));
            model.addAttribute("indiceEdicao", indice);
        }
        model.addAttribute("usuarios", usuarios);
        return "usuarios/inicio";
    }

    @PutMapping("/editar/{indice}")
    public String atualizar(@PathVariable("indice") int indice, Usuario usuario) {
        if (indice >= 0 && indice < usuarios.size()) {
            usuarios.set(indice, usuario);
        }
        return "redirect:/usuarios";
    }

    @DeleteMapping("/excluir/{indice}")
    public String excluir(@PathVariable("indice") int indice) {
        if (indice >= 0 && indice < usuarios.size()) {
            usuarios.remove(indice);
        }
        return "redirect:/usuarios";
    }
}