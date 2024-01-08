package edu.alumno.ivan.dwesUd3WebAppSpringBoot.srv;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.stereotype.Service;

import edu.alumno.ivan.dwesUd3WebAppSpringBoot.ram.Usuario;

@Service
public class LoginService {
	
	private static ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	
	static {
		usuarios.add(new Usuario("Ivan", "ivanp", "miPassword@1", "ivan.jpg"));
		usuarios.add(new Usuario("JoseRa", "joseramon", "miPassword@1", "joserramon.jpg"));
	}
	
	public Usuario encontrarUsuarioPorNickName(String nickname) {
		Usuario usuarioExistente = null;
		for (int i = 0; i < usuarios.size(); i++) {
			if (usuarios.get(i).getNickname().equals(nickname)) {
				return usuarios.get(i);
			}
		}
		return usuarioExistente;
	}
	
	public boolean usuarioValido (Usuario usuarioLogin) {
		Usuario  usuarioEncontrado = encontrarUsuarioPorNickName(usuarioLogin.getNickname());
		if(usuarioEncontrado == null) {
			return false;
		} else {
			if (usuarioLogin.getPassword().contentEquals(usuarioEncontrado.getPassword())) {
				return true;
			}
		}
		return false;
	}
	
	public void modificaUsuario (Usuario usuarioAModificar, String quienModifica) {
			Usuario usuarioActual = encontrarUsuarioPorNickName(quienModifica);
			usuarios.remove(usuarioActual);
			usuarioAModificar.setUser(quienModifica);
			usuarioAModificar.setTs(new Date());
			usuarios.add(usuarioAModificar);
	}
}