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
        return "usuarios/inicio";
    }

    @GetMapping
    public String inicio(Model model) {
        Usuario usuario = new Usuario();
        usuario.setId("01");
        usuario.setNome("Greg");
        usuario.setEmail("greg@email.com");
        usuario.setCpf("143.726.879-02");

        model.addAttribute("usuario", usuario);

        return "usuarios/inicio";
    }

    @PostMapping
    public String cadastrar(Usuario usuario) {
        usuarios.add(usuario);
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